package com.nuc.libary.global

import android.content.Context
import com.nuc.libary.store.MemoryStore

object Mall {
    val configurator: Configurator
        get() = Configurator.instance

    fun init(context: Context): Configurator {
        MemoryStore.instance
            .addData(
                GlobalKeys.APPLICATION_CONTEXT,
                context.applicationContext
            )
        return Configurator.instance
    }

    fun <T> getConfiguration(key: String): T {
        return configurator.getConfiguration(key)
    }

    fun <T> getConfiguration(key: Enum<*>): T {
        return configurator.getConfiguration(key.name)
    }
}