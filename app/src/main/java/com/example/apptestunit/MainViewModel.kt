package com.example.apptestunit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apptestunit.models.MoviesModel
import com.example.apptestunit.models.MoviesRepository

class MainViewModel: ViewModel() {

    var title = MutableLiveData<String>()
    var listaMovies = MutableLiveData<MutableList<MoviesModel>>()

    fun getMovies(): LiveData<MutableList<MoviesModel>>?{
        listaMovies = MoviesRepository().getMovies()!!
        return listaMovies
    }

    fun addTitle(auxTitle: String){
        title.value = auxTitle
    }

    fun getTitle(): LiveData<String>{
        return title
    }

}