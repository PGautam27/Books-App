package com.example.booksapplication.core

sealed class Resources<T>(val data: Any? = null,val message: String? = null) {
    class Loading<T>(data: T? = null) : Resources<T>(data)
    class Success<T>(data: T) : Resources<T>(data)
    class Error<T>(message: String, data: T? = null) : Resources<T>(data, message)
}