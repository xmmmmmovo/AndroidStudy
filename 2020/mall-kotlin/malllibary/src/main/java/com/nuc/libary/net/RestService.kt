package com.nuc.libary.net

import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*
import java.util.*

/**
 * Restful api
 * 通用
 * */
interface RestService {

    /**
     * get
     * */
    @GET
    fun get(
        @Url url: String?,
        @QueryMap params: WeakHashMap<String, Any>?
    ): Call<String>

    /**
     * post
     * */
    @FormUrlEncoded
    @POST
    fun post(
        @Url url: String?,
        @QueryMap params: WeakHashMap<String, Any>?
    ): Call<String>

    /**
     * put
     * */
    @FormUrlEncoded
    @PUT
    fun put(
        @Url url: String?,
        @QueryMap params: WeakHashMap<String, Any>?
    ): Call<String>

    /**
     * delete
     * */
    @DELETE
    fun delete(
        @Url url: String?,
        @QueryMap params: WeakHashMap<String, Any>?
    ): Call<String>

    /**
     * download
     * */
    // 流形式下载
    @Streaming
    @GET
    fun download(
        @Url url: String?,
        @QueryMap params: WeakHashMap<String, Any>?
    ): Call<ResponseBody>


    /**
     * 上传成功
     * */
    fun upload(
        @Url url: String?,
        @Part file: MultipartBody.Part?
    ): Call<String>
}