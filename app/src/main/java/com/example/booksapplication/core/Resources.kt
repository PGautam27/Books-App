package com.example.booksapplication.core

sealed interface Resources<out T>

data class Loading<T>(val data: T? = null) : Resources<T>
data class Success<T>(val data: T) : Resources<T>
class Error<T>(val message: String, val data: T? = null) : Resources<T>


fun <T> Resources<T>.onSuccess(action: (value: T) -> Unit) = apply {
    if(this is Success)
        action(data)
}

fun <T> Resources<T>.onLoading(action: (value: T?) -> Unit) = apply {
    if(this is Loading)
        action(data)
}

fun <T> Resources<T>.onError(action: (message: String, error: T?) -> Unit) = apply {
    if(this is Error)
        action(message, data)
}