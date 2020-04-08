package `in`.rahul.triviaapp.utils

import `in`.rahul.triviaapp.BuildConfig
import android.content.Context
import android.util.Log
import android.widget.Toast

object CommonUtils {
    fun showMessage(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun logMessage(tag: String, message: String) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, message)
        }
    }

}