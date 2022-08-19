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
    private val _publish_date = MutableLiveData<String>()
    private val number_of_Pages = MutableLiveData<Int>()
    private val _quantity = MutableLiveData<Int>()

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
        numberOfPages: String,
        publishDate: String,
        quantity: String
    ){

        val numberOfPages1 = numberOfPages.toInt()
        val quantity1 = quantity.toInt()

        _title.value = title
        number_of_Pages.value = numberOfPages1
        _publish_date.value = publishDate
        _quantity.value = quantity1

         viewModelScope.launch {
             createBooks()
         }
    }

    private fun convertBooks():BooksSendingItem{
        return BooksSendingItem(
            title = _title.value.toString(),
            number_of_pages = number_of_Pages.value!!.toInt(),
            publish_date = _publish_date.value.toString(),
            quantity = _quantity.value!!.toInt()
        )
    }

}