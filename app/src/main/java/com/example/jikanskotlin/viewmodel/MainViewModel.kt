package com.example.jikanskotlin.viewmodel

import androidx.lifecycle.*
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jikanskotlin.model.JikanResponse
import com.example.jikanskotlin.repo.JikanRepo
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel @Inject constructor(private val jikansRepo: JikanRepo): ViewModel() {

    private val jikanResponseListMLD = MutableLiveData<List<JikanResponse>>()
    private val jikanResponseLD = MutableLiveData<JikanResponse>()

    //used for the recyclerview adaptor
    val jikanResponseListLiveData : LiveData<List<JikanResponse>>
        get() = jikanResponseListMLD

    val jikanResponseLiveData : LiveData<JikanResponse>
        get() = jikanResponseLD



    fun getAllJikanResponses(){
        val jikanLiveData = jikansRepo.jikanFlow.asLiveData(viewModelScope.coroutineContext)
        jikanResponseListMLD.postValue(jikanLiveData.value)
    }

    fun insertAndCreateJikanResponses(animeName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val jikans = jikansRepo.createJikanResponse(animeName)
            jikansRepo.insertFavoriteAnime(jikans)
        }
    }




}