package com.nuc.libary.net

import com.mall.library.net.callback.*
import java.util.*

class RestClient internal constructor(
    private val url: String?,
    private val params: WeakHashMap<String, Any>?,
    private val request: IRequest?,
    private val success: ISuccess?,
    private val failure: IFailure?,
    private val error: IError?,
    private val complete: IComplete?
) {
    companion object {
        fun builder(): RestClientBuilder {
            return RestClientBuilder()
        }
    }

}