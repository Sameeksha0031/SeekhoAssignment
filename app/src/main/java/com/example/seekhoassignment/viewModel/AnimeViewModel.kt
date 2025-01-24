package com.example.seekhoassignment.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seekhoassignment.APIResult
import com.example.seekhoassignment.model.AnimeListResponse
import com.example.seekhoassignment.model.detail.AnimeDetailResponse
import com.example.seekhoassignment.repository.AnimeRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AnimeViewModel : ViewModel() {
    private val repository = AnimeRepository()
    private val _animeList = MutableStateFlow<APIResult<AnimeListResponse>>(APIResult.Loading())
    var animeList : StateFlow<APIResult<AnimeListResponse>> = _animeList.asStateFlow()

    private val _animeDetail = MutableStateFlow<APIResult<AnimeDetailResponse>>(APIResult.Loading())
    var animeDetail : StateFlow<APIResult<AnimeDetailResponse>> = _animeDetail.asStateFlow()

    fun getList() {
        viewModelScope.launch {
            Log.d("ApiListener", "getList: ")
            val result = repository.getAnimeList()
            if(result?.isSuccessful == true){
                Log.d("ApiListener", "getList: isSuccessful ${APIResult.Success(result.body()!!).response.data[4]} ")
                _animeList.value = APIResult.Success(result.body()!!)
            } else {
                Log.d("ApiListener", "getList: Failure")
                _animeList.value = APIResult.Failure("Error Message")
            }
        }
    }

    fun getAnimeDetail(id : String) {
        viewModelScope.launch {
            Log.d("ApiListener", "getAnimeDetail: ")
            val result = repository.getAnimeDetails(id)
            if(result?.isSuccessful == true){
                Log.d("ApiListener", "getList: isSuccessful ${APIResult.Success(result.body()!!).response.data} ")
                _animeDetail.value = APIResult.Success(result.body()!!)
            } else {
                Log.d("ApiListener", "getAnimeDetail: Failure")
                _animeDetail.value = APIResult.Failure("Error Message")
            }
        }
    }
}