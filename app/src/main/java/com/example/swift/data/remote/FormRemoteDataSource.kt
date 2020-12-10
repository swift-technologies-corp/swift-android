package com.example.swift.data.remote

import javax.inject.Inject

class FormRemoteDataSource @Inject constructor(private val formService: FormService) :
    BaseDataSource() {
    suspend fun getForm(id: String) = getResult { formService.getForm(id) }
}