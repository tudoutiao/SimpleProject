package com.my.base.utils

import android.content.SharedPreferences
import android.os.Build

class EditorUtils {
    companion object {
        fun fastCommit(editor: SharedPreferences.Editor) {
            // edit.apply could not commit your preferences changes in time on
            // Android 4.3
            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                GingerbreadCompatLayer.fastCommit(editor)
            } else {
                // FIXME: there's no fast commit below GINGERBREAD.
                editor.commit()
            }
        }
    }

    class GingerbreadCompatLayer {
        companion object {
            fun fastCommit(editor: SharedPreferences.Editor) {
                editor.apply()
            }
        }
    }

}