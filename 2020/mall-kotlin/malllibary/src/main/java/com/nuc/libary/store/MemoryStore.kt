package com.nuc.libary.store

class MemoryStore private constructor() {

    /**
     * 线程安全单例
     * */
    private object Holder {
        internal val INSTANCE = MemoryStore()
    }

    companion object {
        val instance: MemoryStore
            get() = Holder.INSTANCE
    }

    private val mDataMap = HashMap<String, Any>()

    fun <T> getData(key: String): T {
        @Suppress("UNCHECKED_CAST")
        return mDataMap[key] as T
    }

    fun addData(key: String, value: Any): MemoryStore {
        mDataMap[key] = value

        return this
    }

    fun <T> getData(key: Enum<*>): T {
        return getData(key.name)
    }

    fun addData(key: Enum<*>, value: Any): MemoryStore {
        addData(key.name, value)
        return this
    }
}