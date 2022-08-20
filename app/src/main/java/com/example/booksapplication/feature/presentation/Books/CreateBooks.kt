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
import com.example.booksapplication.feature.presentation.Books.BooksViewModel

@Composable
fun CreateBooks(viewModel: BooksViewModel = hiltViewModel(),context : ComponentActivity) {

    val titleValue = remember {
        mutableStateOf(String())
    }
    val authorName = remember {
        mutableStateOf(String())
    }
    val completedReading = remember {
        mutableStateOf(Boolean)
    }
    val readingPlatform = remember {
        mutableStateOf(String())
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        
        OutlinedTextField(value = titleValue.value, onValueChange = {titleValue.value = it})
        Spacer(modifier = Modifier.padding(20.dp))


        OutlinedTextField(value = authorName.value, onValueChange = {authorName.value = it})
        Spacer(modifier = Modifier.padding(20.dp))

        OutlinedTextField(value = readingPlatform.value, onValueChange = {readingPlatform.value = it})
        Spacer(modifier = Modifier.padding(20.dp))

        Button(onClick = {
            if (titleValue.value.isNotEmpty() && authorName.value.isNotEmpty() && readingPlatform.value.isNotEmpty()){
                viewModel.updateBooks(title = titleValue.value, author_name = authorName.value, completed_reading = true, reading_platform = readingPlatform.value)
            }
            else Toast.makeText(context, "Boy some problem occurred", Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Create book")
        }
    }
}
