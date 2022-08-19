package com.example.booksapplication.feature.data.remote

import com.example.booksapplication.feature.data.remote.dto.BooksDto
import com.example.booksapplication.feature.data.remote.dto.BooksSendingItem
import retrofit2.http.GET
import retrofit2.http.POST

interface BooksApi {

    @GET("list/")
    suspend fun getAllBooks() : BooksDto

    @POST("")
    suspend fun createBooks(booksSendingItem: BooksSendingItem) : BooksSendingItem
}