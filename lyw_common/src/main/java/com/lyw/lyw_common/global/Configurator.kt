package com.lyw.lyw_common.global

/**
 * 功能描述:全局配置类
 * Created on 2021/4/12.
 * @author lyw
 */
class Configurator private constructor() {

    companion object {
        val instance: Configurator by lazy { Configurator() }
    }

    private val CONFIGS = mutableMapOf<Any, Any>()

    init {
        CONFIGS[ConfigKeys.CONFIG_READY] = false
    }

    fun withWebApiHost(apiHost: String): Configurator {
        CONFIGS[ConfigKeys.WEB_API_HOST] = apiHost
        return this
    }

    fun <T> getConfiguration(key: Any): T {
        val ready = CONFIGS[ConfigKeys.CONFIG_READY] as Boolean
        check(ready) {
            "Configuration is not ready,call configure"
        }

        val value = CONFIGS[key]

        require(value != null) {
            "$key IS NULL"
        }
        return value as T
    }

    fun configure() {
        CONFIGS[ConfigKeys.CONFIG_READY] = true
    }

}