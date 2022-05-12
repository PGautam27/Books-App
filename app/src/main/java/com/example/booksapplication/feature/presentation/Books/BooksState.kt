package com.example.booksapplication.feature.presentation.Books

import com.example.booksapplication.feature.data.remote.dto.BooksDtoItem

data class BooksState(
    val isLoading: Boolean = false,
    val books: List<BooksDtoItem> = emptyList(),
    val error: String = ""
)
