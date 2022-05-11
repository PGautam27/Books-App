package com.example.booksapplication.feature.data.remote.dto

data class BooksDtoItem(
    val id: Int,
    val number_of_pages: Int,
    val publish_date: String,
    val quantity: Int,
    val title: String
)