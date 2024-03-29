package com.example.booksapplication.feature.di

import com.example.booksapplication.core.Constants
import com.example.booksapplication.feature.data.remote.BooksApi
import com.example.booksapplication.feature.data.repository.BooksRepositoryImpl
import com.example.booksapplication.feature.domain.repository.BooksRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun bookApi(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor()).build())
        .build()


    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideBooksService(retrofit: Retrofit): BooksApi = retrofit.create(BooksApi::class.java)

    @Provides
    @Singleton
    fun providesBooksRepository(api: BooksApi): BooksRepository{
        return BooksRepositoryImpl(api = api)
    }

}