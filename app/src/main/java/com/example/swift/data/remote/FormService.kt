package com.example.swift.data.remote

import com.example.swift.data.entities.Form
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface FormService {
    @GET("form/{id}")
    suspend fun getForm(@Path("id") id: String): Response<Form>
}
