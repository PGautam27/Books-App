package com.example.booksapplication.feature.presentation.CreateBooks

import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.booksapplication.feature.data.remote.dto.BooksSendingItem
import com.example.booksapplication.feature.presentation.Books.BooksViewModel

@Composable
fun CreateBooks(viewModel: BooksViewModel = hiltViewModel(),context : ComponentActivity) {

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

        Button(onClick = {
            if (titleValue.value.isNotEmpty() && numberOfPages.value.isNotEmpty() && publishDate.value.isNotEmpty() && quantity.value.isNotEmpty()){
                val books = convertBooksDto(title = titleValue.value, numberOfPages = numberOfPages.value, publishDate = publishDate.value, quantity = quantity.value)
                Toast.makeText(context, "It worked go check the backend", Toast.LENGTH_SHORT).show()
            }
            else Toast.makeText(context, "Boy some problem occurred", Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Create book")
        }
    }
}

private fun convertBooksDto(
    title: String,
    numberOfPages: String,
    publishDate: String,
    quantity: String
): BooksSendingItem {

    val numberOfPages1 = numberOfPages.toInt()
    val quantity1 = quantity.toInt()

    return BooksSendingItem(
        title = title,
        number_of_pages = numberOfPages1,
        publish_date = publishDate,
        quantity = quantity1
    )
}