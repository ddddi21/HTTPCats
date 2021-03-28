package com.example.httpcats.presenter.list

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcourse.presenter.model.City

class WeatherAdapter(
    private var list : List<City>,
    private val itemClick: (Int) -> Unit
): RecyclerView.Adapter<WeatherHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherHolder {
        return WeatherHolder.create(parent).also {
            it.itemClick = itemClick }
    }

    override fun onBindViewHolder(holder: WeatherHolder, position: Int) =
        holder.bind(list[position])

    override fun getItemCount(): Int = list.size

    fun updateDataSource(newList: List<City>){
        list = newList
        notifyDataSetChanged()
    }
}