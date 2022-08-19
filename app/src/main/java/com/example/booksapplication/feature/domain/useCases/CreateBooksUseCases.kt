package com.example.booksapplication.feature.domain.useCases

import com.example.booksapplication.feature.data.remote.dto.BooksDto
import com.example.booksapplication.feature.data.remote.dto.BooksSendingItem
import com.example.booksapplication.feature.domain.repository.BooksRepository
import javax.inject.Inject

class CreateBooksUseCases @Inject constructor(
   private val repository : BooksRepository
){
    suspend fun createBooks(booksSendingItem: BooksSendingItem){
        repository.createBooks(booksSendingItem)
    }
}