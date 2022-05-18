package com.example.booksapplication.feature.domain.repository

import com.example.booksapplication.feature.data.remote.dto.BooksDto
import com.example.booksapplication.feature.data.remote.dto.BooksDtoItem

interface BooksRepository {

    suspend fun getBooks() : BooksDto

}