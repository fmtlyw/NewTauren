package com.lyw.lyw_common.ext

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter(value = ["url"])
fun AppCompatImageView.loadUrl(url: String) {
    if (url.isNotEmpty()) {
        Glide.with(context).load(url).into(this)
    }
}