package com.sbd.pascolan_one

import com.sbd.pascolan_one.model.ApiData
import retrofit2.Call
import retrofit2.http.GET

interface JsonPlaceHolder {

//https://pascolan-config.s3.us-east-2.amazonaws.com/android/v1/prod/Category/hi/category.json
    @GET("category.json")
    fun getData(): Call<List<ApiData>>
}