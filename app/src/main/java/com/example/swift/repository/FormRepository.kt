package com.example.swift.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.swift.data.entities.Form
import com.example.swift.data.local.FormDao
import com.example.swift.data.remote.FormRemoteDataSource
import com.example.swift.util.performGetOperation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class FormRepository @Inject constructor(
    private val formDaoLocal: FormDao,
    private val formRemote: FormRemoteDataSource
) {
    fun insert(form: Form) {
        CoroutineScope(Dispatchers.IO).launch {
            formDaoLocal.insert(form)
        }
    }

    fun delete(form: Form) {
        CoroutineScope(Dispatchers.IO).launch {
            formDaoLocal.delete(form)
        }
    }

    fun update(form: Form) {
        CoroutineScope(Dispatchers.IO).launch {
            formDaoLocal.update(form)
            Log.e("DEBUG", "Update was called in repo")

        }
    }

    fun getForm(id: String) = performGetOperation(
        databaseQuery = { formDaoLocal.getForm(id) },
        networkCall = { formRemote.getForm(id) },
        saveCallResult = { formDaoLocal.insert(it) }
    )

    fun getAllForms(): LiveData<List<Form>> {
        return formDaoLocal.getAllForms()
    }

    fun getSectionsOfFormId(): LiveData<List<Form>> {
        return formDaoLocal.getAllForms()
    }
}