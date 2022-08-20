package com.example.booksapplication.feature.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.booksapplication.feature.presentation.Books.BookListScreen
import com.example.booksapplication.feature.presentation.CreateBooks.CreateBooks
import com.example.booksapplication.feature.presentation.screens.Screens
import com.example.booksapplication.ui.theme.BooksApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BooksApplicationTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screens.CreateBooksScreen.route){
                    composable(Screens.BookListScreen.route){
                        BookListScreen()
                    }
                    composable(Screens.CreateBooksScreen.route){
                        CreateBooks(context = this@MainActivity)
                    }
                }
            }
        }
    }
}
