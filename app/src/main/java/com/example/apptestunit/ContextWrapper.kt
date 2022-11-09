package com.example.apptestunit

import android.content.Context

class ContextWrapper(private val context: Context) {

    fun getTitle(): PersonModel{
        var person = PersonModel(
            name = "Bruno",
            age = "23"
        )
        return person
    }

}