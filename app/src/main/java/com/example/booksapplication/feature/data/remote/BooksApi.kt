package com.example.booksapplication.feature.data.remote

import com.example.booksapplication.feature.data.remote.dto.BooksDto
import com.example.booksapplication.feature.data.remote.dto.BooksDtoItem
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface BooksApi {

    @GET("books/list/")
    suspend fun getAllBooks() : BooksDto

    @POST("books/")
    suspend fun createBooks(@Body booksDtoItem: BooksDtoItem) : Result<BooksDtoItem>
}