package com.example.apptestunit

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.apptestunit.models.MoviesModel
import com.example.apptestunit.util.LiveDataTaskUtilTest
import org.hamcrest.CoreMatchers.not
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainViewModelTest: LiveDataTaskUtilTest() {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun getTitle(){
        //GIVEN
        val viewModel = MainViewModel()

        //WHEN
        viewModel.addTitle("Hello World")

        //THEN
        val value = viewModel.getTitle().getOrAwaitValue()
        assertThat(value,  (not(nullValue())))
    }

    @Test
    fun getFilmes(){
        //GIVEN
        val viewModel = MainViewModel()

        //WHEN
        var value = viewModel.getMovies()?.getOrAwaitValue()

        //THEN
        assertThat(value, (not(nullValue())))
    }
}