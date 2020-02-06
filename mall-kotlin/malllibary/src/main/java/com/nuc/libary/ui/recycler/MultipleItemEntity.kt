package com.mall.library.ui.recycler

import com.chad.library.adapter.base.entity.MultiItemEntity

class MultipleItemEntity internal constructor
    (fields: LinkedHashMap<Any, Any>) : MultiItemEntity {

    private val mMultipleFields = LinkedHashMap<Any, Any>()

    init {
        mMultipleFields.putAll(fields)
    }

    companion object {
        fun builder(): MultipleEntityBuilder {
            return MultipleEntityBuilder()
        }
    }

    override fun getItemType(): Int {
        return mMultipleFields[MultipleFields.ITEM_TYPE] as Int
    }

    fun <T> getField(key: Any): T {
        @Suppress("UNCHECKED_CAST")
        return mMultipleFields[key] as T
    }

    fun setField(key: Any, value: Any): MultipleItemEntity {
        mMultipleFields[key] = value
        return this
    }
}