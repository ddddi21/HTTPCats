package com.example.httpcats.presenter.joke

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.httpcats.databinding.ItemJokeBinding
import com.example.httpcats.presenter.model.Joke

class JokeAdapter(
    private var list : List<Joke>
): RecyclerView.Adapter<JokeAdapter.VH>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemJokeBinding.inflate(layoutInflater, parent, false)
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) =
        holder.bind(list[position]!!)

    override fun getItemCount(): Int = list.size

    fun updateDataSource(newList: List<Joke>) {
        list = newList
        notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        list.toMutableList().removeAt(position)
        notifyDataSetChanged()
    }


    inner class VH(
        private val binding: ItemJokeBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(joke: Joke) {
            with(binding) {
                tvName.text = joke.setUp
                tvDescription.text = joke.punchline
            }
        }

    }
}