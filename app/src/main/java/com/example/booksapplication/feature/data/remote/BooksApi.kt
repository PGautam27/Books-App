package com.example.booksapplication.feature.data.remote

import com.example.booksapplication.feature.data.remote.dto.BooksDto
import retrofit2.http.GET

interface BooksApi {


    @GET("list/")
    suspend fun getAllBooks() : BooksDto

}