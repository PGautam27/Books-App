package com.example.booksapplication.feature.presentation.Books

import com.example.booksapplication.feature.data.remote.dto.BooksDto
import com.example.booksapplication.feature.data.remote.dto.BooksDtoItem

data class BooksState(
    val isLoading: Boolean = false,
    val books: BooksDto = BooksDto(),
    val error: String = ""
)
