package com.example.booksapplication.feature.presentation.Books

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booksapplication.core.Resources
import com.example.booksapplication.feature.data.remote.dto.BooksDto
import com.example.booksapplication.feature.domain.useCases.GetBooksUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(
    private val getBooksUseCases: GetBooksUseCases
) : ViewModel(){

    private val _state = mutableStateOf(BooksState())
    val state: State<BooksState> = _state

    init {
        getBooks()
    }

    private fun getBooks(){
        getBooksUseCases().onEach { result->
            when(result){
                is Resources.Success ->{
                    _state.value = BooksState(books = result.data as BooksDto)
                }
                is Resources.Error -> {
                    _state.value = BooksState(error = result.message?: "An unexpected error occurred")
                }
                is Resources.Loading -> {
                    _state.value = BooksState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}