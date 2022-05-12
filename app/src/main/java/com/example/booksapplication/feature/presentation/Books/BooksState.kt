package com.example.booksapplication.feature.presentation.Books

import com.example.booksapplication.feature.data.remote.dto.BooksDtoItem

data class BooksState(
    val isLoading: Boolean = false,
    val coins: List<BooksDtoItem> = emptyList(),
    val error: String = ""
)
