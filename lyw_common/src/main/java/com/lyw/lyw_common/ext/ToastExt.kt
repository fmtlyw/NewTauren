package com.lyw.lyw_common.ext

import com.lyw.lyw_common.utils.AppGlobal
import com.sdsmdg.tastytoast.TastyToast

fun infoToast(message: String) {
    AppGlobal.get()
        ?.let { TastyToast.makeText(it, message, TastyToast.LENGTH_LONG, TastyToast.INFO) }
}

fun errorToast(message: String) {
    AppGlobal.get()
        ?.let { TastyToast.makeText(it, message, TastyToast.LENGTH_LONG, TastyToast.ERROR) }
}