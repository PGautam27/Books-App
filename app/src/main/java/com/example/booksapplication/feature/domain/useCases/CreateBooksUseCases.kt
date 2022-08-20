package com.example.booksapplication.feature.domain.useCases

import com.example.booksapplication.feature.data.remote.dto.BooksDtoItem
import com.example.booksapplication.feature.domain.repository.BooksRepository
import javax.inject.Inject

class CreateBooksUseCases @Inject constructor(
   private val repository : BooksRepository
){
    suspend fun createBooks(booksDtoItem: BooksDtoItem){
        repository.createBooks(booksDtoItem)
    }
}