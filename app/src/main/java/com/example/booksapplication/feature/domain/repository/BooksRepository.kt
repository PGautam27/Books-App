package com.example.booksapplication.feature.domain.repository

import com.example.booksapplication.feature.data.remote.dto.BooksDtoItem

interface BooksRepository {

    suspend fun getBooks() : List<BooksDtoItem>

}