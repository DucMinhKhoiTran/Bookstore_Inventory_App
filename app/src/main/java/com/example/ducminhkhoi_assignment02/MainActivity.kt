package com.example.ducminhkhoi_assignment02

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ducminhkhoi_assignment02.databinding.ActivityMainBinding
import com.example.ducminhkhoi_assignment02.databinding.DialogAddBookBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var database: BookDatabase
    private lateinit var adapter: BookAdapter
    private lateinit var bookDao: BookDao
    private var bookList = listOf<BookEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the database
        database = BookDatabase.getInstance(this)

        // Set click listener for Add Book Button
        binding.addBookButton.setOnClickListener{
            showAddBookDialog() // Show dialog to add new book
        }

        // Set up RecyclerView and display Books
        loadBooks()
    }

    // Load books from database and set them in RecyclerView
    private fun loadBooks() {
        lifecycleScope.launch {

            // Fetch all books from database
            bookList = database.bookDao().getAllBooks()
            adapter = BookAdapter(bookList) { book ->
                showEditBookDialog(book)
            }

            // Set up RecyclerView
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    // Shows dialog to add a new book
    private fun showAddBookDialog() {
        val dialogBinding = DialogAddBookBinding.inflate(layoutInflater)
        val dialog = AlertDialog.Builder(this)
            .setTitle("Add Book")
            .setView(dialogBinding.root)
            .setPositiveButton("Add") { _, _ ->
                val title = dialogBinding.titleEditText.text.toString()
                val author = dialogBinding.authorEditText.text.toString()
                val price = dialogBinding.priceEditText.text.toString().toDouble()
                val quantity = dialogBinding.quantityEditText.text.toString().toInt()

                lifecycleScope.launch {

                    // Add a new book to database
                    database.bookDao().addBook(
                        BookEntity(
                            title = title,
                            author = author,
                            price = price,
                            quantity = quantity
                        )
                    )
                    loadBooks()
                }
            }
            .setNegativeButton("Cancel", null)
            .create()
        dialog.show()
    }
    private fun showEditBookDialog(book: BookEntity) {
        val dialogBinding = DialogAddBookBinding.inflate(layoutInflater)
        dialogBinding.titleEditText.setText(book.title)
        dialogBinding.authorEditText.setText(book.author)
        dialogBinding.priceEditText.setText(book.price.toString())
        dialogBinding.quantityEditText.setText(book.quantity.toString())

        val dialog = AlertDialog.Builder(this)
            .setTitle("Edit Book")
            .setView(dialogBinding.root)
            .setPositiveButton("Update") { _, _ ->
                val updatedBook = book.copy(
                    title = dialogBinding.titleEditText.text.toString(),
                    author = dialogBinding.authorEditText.text.toString(),
                    price = dialogBinding.priceEditText.text.toString().toDouble(),
                    quantity = dialogBinding.quantityEditText.text.toString().toInt()
                )

                lifecycleScope.launch {
                    // Update the book in database
                    database.bookDao().updateBook(updatedBook)
                    loadBooks()
                }
            }
            .setNegativeButton("Delete") { _, _ ->
                lifecycleScope.launch {
                    // Delete the book from database
                    database.bookDao().deleteBook(book)
                    loadBooks()
                }
            }
            .setNeutralButton("Cancel", null)
            .create()
        dialog.show()
    }
}