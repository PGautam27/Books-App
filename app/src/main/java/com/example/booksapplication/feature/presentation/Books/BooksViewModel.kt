package com.example.booksapplication.feature.presentation.Books

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booksapplication.core.onError
import com.example.booksapplication.core.onLoading
import com.example.booksapplication.core.onSuccess
import com.example.booksapplication.feature.data.remote.dto.BooksDtoItem
import com.example.booksapplication.feature.domain.useCases.CreateBooksUseCases
import com.example.booksapplication.feature.domain.useCases.GetBooksUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(
    private val getBooksUseCases: GetBooksUseCases,
    private val createBooksUseCases: CreateBooksUseCases
) : ViewModel(){

    private val _state = mutableStateOf(BooksState())
    val state: State<BooksState> = _state

    private val _title = MutableLiveData<String>()
    private val _author_name = MutableLiveData<String>()
    private val _completed_reading = MutableLiveData<Boolean>()
    private val _reading_platform = MutableLiveData<String>()

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

    private suspend fun createBooks(){
        createBooksUseCases.createBooks(convertBooks())
    }

     fun updateBooks(
        title: String,
        author_name : String,
        completed_reading : Boolean,
        reading_platform : String
    ){

        _title.value = title
         _author_name.value= author_name
        _reading_platform.value = reading_platform
        _completed_reading.value = completed_reading

         viewModelScope.launch {
             createBooks()
         }
    }

    private fun convertBooks():BooksDtoItem{
        return BooksDtoItem(
            title = _title.value.toString(),
            completed_reading = _completed_reading.value!!,
            author_name = _author_name.value.toString(),
            reading_platform = _reading_platform.value.toString()
        )
    }

}