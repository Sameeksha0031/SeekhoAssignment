package com.example.seekhoassignment

sealed class APIResult<T> {
    class Success<T>(val response: T) : APIResult<T>()
    class Failure<T>(val error: String) : APIResult<T>()
    class Loading<T> : APIResult<T>()
}