package br.com.renancsdev.sky.ui.adapter

import android.app.Activity
import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.renancsdev.sky.R
import br.com.renancsdev.sky.databinding.ItemListBinding
import br.com.renancsdev.sky.model.Filmes
import br.com.renancsdev.sky.ui.holder.RecyclerFilmeViewHolder


class RecyclerFilmeAdapter (private var filmes: List<Filmes>): RecyclerView.Adapter<RecyclerFilmeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerFilmeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemListBinding.inflate(layoutInflater)
        return RecyclerFilmeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerFilmeViewHolder, position: Int) {
        holder.bind(filmes[position])
    }

    override fun getItemCount() = filmes.size

}