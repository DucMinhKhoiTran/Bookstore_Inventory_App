package com.example.ducminhkhoi_assignment02

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Book") //Define the table name as "Book"
data class BookEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0, // Auto-generated primary key
    val title: String,
    val author: String,
    val price: Double,
    val quantity: Int
)
