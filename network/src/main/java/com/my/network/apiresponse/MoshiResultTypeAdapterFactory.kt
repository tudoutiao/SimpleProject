package com.my.network.apiresponse

import com.my.network.error.BusinessException
import com.squareup.moshi.*
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * 如果是标准的response
 * 200 没有baseresponse
 * 500 只有baseresponse
 * 根据需求使用
 * Json转换器  返回数据没有baseresponse时,此类用于解析出baseresponse，
 */
class MoshiResultTypeAdapterFactory(val envelope: Envelope?) : JsonAdapter.Factory {
    interface Envelope {
        fun getStatusCodeKey(): String
        fun getErrorMessageKey(): String
        fun getDataKey(): String
        fun doseStatusCodeIndicateSuccess(statusCode: Int): Boolean
        fun isNeedOpenEnvelope(): Boolean
    }

    override fun create(
        type: Type,
        annotations: MutableSet<out Annotation>,
        moshi: Moshi
    ): JsonAdapter<*>? {
        val rawType = type.rawType
        if (rawType != NetworkResponse::class.java) return null
        val dataType: Type =
            (type as? ParameterizedType)?.actualTypeArguments?.firstOrNull() ?: return null
        val dataTypeAdapter = moshi.nextAdapter<Any>(this, dataType, annotations)
        return ResultTypeAdapter(dataTypeAdapter, envelope)
    }

    class ResultTypeAdapter<T>(
        val dataTypeAdapter: JsonAdapter<T>,
        val envelope: Envelope?
    ) :
        JsonAdapter<T>() {
        override fun fromJson(reader: JsonReader): T? {
            if (null != envelope && envelope.isNeedOpenEnvelope()) {
                reader.beginObject()
                var errorcode: Int? = null
                var msg: String? = null
                var data: Any? = null

                while (reader.hasNext()) {
                    when (reader.nextName()) {
                        envelope.getStatusCodeKey() -> {
                            var code = reader.nextString()
                            errorcode = code.toIntOrNull()
                        }
                        envelope.getErrorMessageKey() -> {
                            msg = reader.nextString()
                        }
                        envelope.getDataKey() -> {
                            //读取的obj，但此处读取到的是list
                            //Expected BEGIN_OBJECT but was BEGIN_ARRAY at path
                            data = dataTypeAdapter.fromJson(reader)

                        }
                        else -> reader.skipValue()
                    }
                }
                reader.endObject()
                if (errorcode == null)
                    throw JsonDataException("Expected field [errcode] not present.")
                return if (envelope.doseStatusCodeIndicateSuccess(errorcode)) data as T
                else throw BusinessException(errorcode, msg)
            } else {
                return dataTypeAdapter.fromJson(reader) as T
            }
        }


        override fun toJson(writer: JsonWriter, value: T?) {
            TODO("Not yet implemented")
        }
    }
}