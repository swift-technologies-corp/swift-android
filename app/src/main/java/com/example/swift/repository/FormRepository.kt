package com.example.swift.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.swift.persistence.Form
import com.example.swift.persistence.FormDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class FormRepository @Inject constructor(val formDao: FormDao) {
    fun insert(form: Form) {
        CoroutineScope(Dispatchers.IO).launch {
            formDao.insert(form)
        }
    }

    fun delete(form: Form) {
        CoroutineScope(Dispatchers.IO).launch {
            formDao.delete(form)
        }
    }

    fun update(form: Form) {
        CoroutineScope(Dispatchers.IO).launch {
            formDao.update(form)
            Log.e("DEBUG", "Update was called in repo")

        }
    }

    fun getAllForms(): LiveData<List<Form>> {
        return formDao.getAllForms()
    }

    fun getSectionsOfFormId(): LiveData<List<Form>> {
        return formDao.getAllForms()
    }
}