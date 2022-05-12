package com.example.booksapplication.feature.presentation.Books

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.booksapplication.feature.domain.useCases.GetBooksUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(
    private val getBooksUseCases: GetBooksUseCases
) : ViewModel(){

    private val _state = mutableStateOf(BooksState())
    val state: State<BooksState> = _state

    private fun getBooks(){
        getBooksUseCases().onEach { result->

        }
    }

}