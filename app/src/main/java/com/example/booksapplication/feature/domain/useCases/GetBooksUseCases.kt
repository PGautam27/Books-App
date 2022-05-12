package com.example.booksapplication.feature.domain.useCases

import com.example.booksapplication.core.Resources
import com.example.booksapplication.feature.data.remote.dto.BooksDto
import com.example.booksapplication.feature.data.remote.dto.BooksDtoItem
import com.example.booksapplication.feature.domain.repository.BooksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetBooksUseCases @Inject constructor(
    private val repository: BooksRepository
) {
    operator fun invoke(): Flow<Resources<List<BooksDtoItem>>> = flow {
        try {
            emit(Resources.Loading<List<BooksDtoItem>>())
            val books = repository.getBooks()
            emit(Resources.Success<List<BooksDtoItem>>(books))
        }catch (e: HttpException){
            emit(Resources.Error<List<BooksDtoItem>>(e.localizedMessage?: "An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resources.Error<List<BooksDtoItem>>("Couldn't reach the server."))
        }
    }
}