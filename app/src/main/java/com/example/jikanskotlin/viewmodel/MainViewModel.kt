package com.example.jikanskotlin.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.jikanskotlin.model.JikanResponse
import com.example.jikanskotlin.repo.JikanRepo
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class MainViewModel @Inject constructor(private val jikansRepo: JikanRepo): ViewModel() {

    private val jikanResponseListMLD = MutableLiveData<List<JikanResponse>>()
    private val jikanResponseMLD = MutableLiveData<JikanResponse>()

    //used for the recyclerview adaptor
    val jikanResponseListLiveData = jikansRepo.jikanFlow.asLiveData(viewModelScope.coroutineContext)

    //for details fragment
    val jikanResponseLiveData : LiveData<JikanResponse>
        get() = jikanResponseMLD

    fun getAllJikanResponses(){
        val jikanLiveData = jikansRepo.jikanFlow.asLiveData(viewModelScope.coroutineContext)
        jikanResponseListMLD.postValue(jikanLiveData.value)
    }

    fun insertAndCreateJikanResponses(animeName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val jikans = jikansRepo.createJikanResponse(animeName)
            Log.d("inside", "insertAndCreateJikanResponses: $jikans")
            jikansRepo.insertFavoriteAnime(jikans)
            jikanResponseMLD.postValue(jikans)
        }
    }




}