package com.example.booksapplication.feature.presentation.CreateBooks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.booksapplication.feature.presentation.Books.BooksViewModel

@Composable
fun CreateBooks(viewModel: BooksViewModel = hiltViewModel()) {

    val titleValue = remember {
        mutableStateOf(String())
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        
        OutlinedTextField(value = titleValue.value, onValueChange = {titleValue.value = it})
        
    }
}