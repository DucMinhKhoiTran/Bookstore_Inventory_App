package com.example.ducminhkhoi_assignment02

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface BookDao {
    @Query("Select * from Book")
    suspend fun getAllBooks(): List<BookEntity>

    @Insert
    suspend fun addBook(book: BookEntity)

    @Update
    suspend fun updateBook(book: BookEntity)

    @Delete
    suspend fun deleteBook(book: BookEntity)
}