package com.example.turkishtourguide.util

import android.util.Log
import androidx.lifecycle.ViewModel

inline fun ViewModel.loge(message: Any?) {
    Log.e(this.javaClass.simpleName, message.toString())
}