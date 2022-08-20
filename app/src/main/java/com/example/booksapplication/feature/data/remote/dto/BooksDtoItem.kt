package com.example.booksapplication.feature.data.remote.dto

import com.google.gson.annotations.SerializedName

data class BooksDtoItem(
    @SerializedName("title")
    val title: String,
    @SerializedName("author_name")
    val author_name: String,
    @SerializedName("completed_reading")
    val completed_reading: Boolean,
    @SerializedName("reading_platform")
    val reading_platform: String
)

data class BooksSendingItem(
    @SerializedName("title")
    val title: String,
    @SerializedName("author_name")
    val author_name: String,
    @SerializedName("completed_reading")
    val completed_reading: Boolean,
    @SerializedName("reading_platform")
    val reading_platform: String
)