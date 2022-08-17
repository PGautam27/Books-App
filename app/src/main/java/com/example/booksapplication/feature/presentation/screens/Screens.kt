package com.example.booksapplication.feature.presentation.screens

sealed class Screens(val route:String){
    object BookListScreen : Screens("book_list_screen")
}
