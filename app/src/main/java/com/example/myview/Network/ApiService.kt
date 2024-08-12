package com.example.myview.Network

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/todos")
    suspend fun getTodos() : List<Todo>

    @GET("/todos/")
    suspend fun getTodo(@Query("id") id: Int) : Todo


}