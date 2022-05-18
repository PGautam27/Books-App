package com.example.booksapplication.feature.data.remote.dto

import com.google.gson.annotations.SerializedName

data class BooksDtoItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("number_of_pages")
    val number_of_pages: Int,
    @SerializedName("publish_date")
    val publish_date: String,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("title")
    val title: String
)