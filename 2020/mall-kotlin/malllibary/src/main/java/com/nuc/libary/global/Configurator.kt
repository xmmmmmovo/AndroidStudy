package com.nuc.libary.global

import android.os.Handler
import com.nuc.libary.store.MemoryStore
import java.lang.RuntimeException

/**
 * 全局配置控制类
 * */
class Configurator private constructor() {
    /**
     * 线程安全单例
     * */
    private object Holder {
        internal val INSTANCE = Configurator()
    }

    companion object {
        // 全局存储容器
        private val mStore: MemoryStore = MemoryStore.instance
        // handler需要反复使用 提前创建
        private val mHandler = Handler()

        val instance: Configurator
            get() = Holder.INSTANCE
    }

    init {
        // 添加标签 没开始配置
        mStore.addData(GlobalKeys.IS_CONFIG_READY, true)
        mStore.addData(GlobalKeys.HANDLER, mHandler)
    }

    /**
     * API
     * */
    fun withApiHost(host: String): Configurator {
        mStore.addData(GlobalKeys.API_HOST, host)
        return this
    }

    /**
     * 结束操作
     * */
    fun configure() {
        mStore.addData(GlobalKeys.IS_CONFIG_READY, true)
    }

    private fun checkConfiguration() {
        val isReady: Boolean =
            mStore.getData<Boolean>(GlobalKeys.IS_CONFIG_READY)
        if (!isReady) {
            throw RuntimeException("config is not ready!")
        }
    }

    fun <T> getConfiguration(key: String): T {
        return mStore.getData(key)
    }

    fun <T> getConfiguration(key: Enum<*>): T {
        return getConfiguration(key.name)
    }

}