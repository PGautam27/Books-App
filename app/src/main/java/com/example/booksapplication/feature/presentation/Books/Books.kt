package com.example.booksapplication.feature.presentation.Books

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun BookListScreen(viewModel: BooksViewModel = hiltViewModel()) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()){
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(state.books) { book ->
                Card(
                    modifier = Modifier
                        .width(LocalConfiguration.current.screenWidthDp.dp - 50.dp)
                        .height(
                            LocalConfiguration.current.screenHeightDp.dp / 8
                        )
                        .clip(RoundedCornerShape(20.dp))
                        .align(Alignment.Center)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = book.title)
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(text = book.publish_date)
                    }
                }
                Spacer(modifier = Modifier.padding(25.dp))
            }
        }
    }
}