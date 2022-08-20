package com.example.booksapplication.feature.data.repository

import com.example.booksapplication.feature.data.remote.BooksApi
import com.example.booksapplication.feature.data.remote.dto.BooksDto
import com.example.booksapplication.feature.data.remote.dto.BooksDtoItem
import com.example.booksapplication.feature.domain.repository.BooksRepository
import javax.inject.Inject

class BooksRepositoryImpl @Inject constructor(
    private val api: BooksApi
): BooksRepository {
    override suspend fun getBooks(): BooksDto{
        return api.getAllBooks()
    }

    override suspend fun createBooks(booksDtoItem: BooksDtoItem)  {
        api.createBooks(booksDtoItem)
    }
}