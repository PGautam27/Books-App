package com.example.booksapplication.feature.presentation.Books

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booksapplication.core.*
import com.example.booksapplication.feature.data.remote.dto.BooksDto
import com.example.booksapplication.feature.data.remote.dto.BooksSendingItem
import com.example.booksapplication.feature.domain.useCases.CreateBooksUseCases
import com.example.booksapplication.feature.domain.useCases.GetBooksUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(
    private val getBooksUseCases: GetBooksUseCases,
    private val createBooksUseCases: CreateBooksUseCases
) : ViewModel(){

    private val _state = mutableStateOf(BooksState())
    val state: State<BooksState> = _state

    init {
        getBooks()
    }

    private fun getBooks(){
        getBooksUseCases().onEach { result->
            result.onSuccess {
                _state.value = BooksState(books = it)
            }.onLoading {
                _state.value = BooksState(isLoading = true)
            }.onError { message, _ ->
                _state.value = BooksState(error = message)
            }
        }.launchIn(viewModelScope)
    }

    suspend fun createBooks(booksSendingItem: BooksSendingItem){
        createBooksUseCases.createBooks(booksSendingItem)
    }

}