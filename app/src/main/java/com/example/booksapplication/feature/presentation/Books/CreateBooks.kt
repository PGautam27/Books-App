package com.example.booksapplication.feature.presentation.CreateBooks

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.booksapplication.feature.data.remote.dto.BooksDto
import com.example.booksapplication.feature.data.remote.dto.BooksDtoItem
import com.example.booksapplication.feature.data.remote.dto.BooksSendingItem
import com.example.booksapplication.feature.presentation.Books.BooksViewModel
import java.util.*

@Composable
fun CreateBooks(viewModel: BooksViewModel = hiltViewModel()) {

    val titleValue = remember {
        mutableStateOf(String())
    }
    val publishDate = remember {
        mutableStateOf(String())
    }
    val numberOfPages = remember {
        mutableStateOf(String())
    }
    val quantity = remember {
        mutableStateOf(String())
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        
        OutlinedTextField(value = titleValue.value, onValueChange = {titleValue.value = it})
        Spacer(modifier = Modifier.padding(20.dp))

        OutlinedTextField(value = numberOfPages.value, onValueChange = {numberOfPages.value = it})
        Spacer(modifier = Modifier.padding(20.dp))

        OutlinedTextField(value = publishDate.value, onValueChange = {publishDate.value = it})
        Spacer(modifier = Modifier.padding(20.dp))

        OutlinedTextField(value = quantity.value, onValueChange = {quantity.value = it})
        Spacer(modifier = Modifier.padding(20.dp))

        Button(onClick = { /*TODO*/ }) {

        }
    }
}

private fun convertBooksDto(title:String, numberOfPages:String, publishDate:String,quantity:String){
    val title1 = title
    val numberOfPages1 = numberOfPages.toInt()
    val publishDate1 = publishDate
    val quantity1 = quantity.toInt()

    val books = BooksSendingItem(title = title1, number_of_pages = numberOfPages1, publish_date = publishDate, quantity = quantity1)
}