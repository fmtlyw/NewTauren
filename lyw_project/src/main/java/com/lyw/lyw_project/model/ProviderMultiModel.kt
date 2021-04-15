package com.lyw.lyw_project.model

import androidx.annotation.IntDef
import com.lyw.lyw_provider.model.Item

class ProviderMultiModel(
    @Type val type: Int,
    val item: Item? = null,
    val items: List<Item> = mutableListOf()
) {

    @IntDef(value = [Type.TYPE_BANNER, Type.TYPE_TITLE, Type.TYPE_IMAGE])
    annotation class Type {
        companion object {
            const val TYPE_BANNER = 0
            const val TYPE_TITLE = 1
            const val TYPE_IMAGE = 2
        }
    }
}