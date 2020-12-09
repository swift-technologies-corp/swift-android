package com.example.swift.ui

import androidx.lifecycle.ViewModel
import com.example.swift.persistence.Form
import com.example.swift.repository.FormRepository
import javax.inject.Inject

class FormViewModel @Inject constructor(
    val formRepository: FormRepository
) : ViewModel() {

    fun insert (form: Form) {
        return formRepository.insert(form)
    }

    fun delete (form: Form) {
        return formRepository.delete(form)
    }

    fun update (form: Form) {
        return formRepository.update(form)
    }
}