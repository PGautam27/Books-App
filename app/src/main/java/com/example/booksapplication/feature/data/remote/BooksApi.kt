package com.example.booksapplication.feature.data.remote

import com.example.booksapplication.feature.data.remote.dto.BooksDto
import com.example.booksapplication.feature.data.remote.dto.BooksSendingItem
import retrofit2.http.GET
import retrofit2.http.POST

interface BooksApi {

    @GET("books/list/")
    suspend fun getAllBooks() : BooksDto

    @POST("books/")
    suspend fun createBooks(booksSendingItem: BooksSendingItem) : BooksSendingItem
}