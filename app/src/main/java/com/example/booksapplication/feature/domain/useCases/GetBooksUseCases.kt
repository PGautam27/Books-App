package com.example.booksapplication.feature.domain.useCases

import com.example.booksapplication.core.Error
import com.example.booksapplication.core.Loading
import com.example.booksapplication.core.Resources
import com.example.booksapplication.core.Success
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
    operator fun invoke(): Flow<Resources<BooksDto>> = flow {
        try {
            emit(Loading<BooksDto>())
            val books = repository.getBooks()
            emit(Success<BooksDto>(books))
        }catch (e: HttpException){
            emit(Error<BooksDto>(e.localizedMessage?: "An unexpected error occurred"))
        }catch (e: IOException){
            emit(Error<BooksDto>("Couldn't reach the server."))
        }
    }
}