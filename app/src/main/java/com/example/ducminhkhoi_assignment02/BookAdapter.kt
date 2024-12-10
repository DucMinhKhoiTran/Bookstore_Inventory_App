package com.example.ducminhkhoi_assignment02

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ducminhkhoi_assignment02.databinding.ItemBookBinding

class BookAdapter (private val books: List<BookEntity>, private val onClick: (BookEntity) -> Unit) :
RecyclerView.Adapter<BookAdapter.BookViewHolder> (){

    inner class BookViewHolder(val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(book: BookEntity) {
            binding.titleTv.text = book.title
            binding.authorTv.text = book.author
            binding.priceTv.text = "Price: ${book.price}"
            binding.quantityTv.text = "Quantity: ${book.quantity}"

            binding.root.setOnClickListener {onClick(book)}

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ItemBookBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(books[position])
    }

    override fun getItemCount() = books.size

}