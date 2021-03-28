package com.example.httpcats.presenter.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcourse.R
import com.example.androidcourse.presenter.model.City
import com.example.androidcourse.domain.services.TempService
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_weather.*

class WeatherHolder (
    override val containerView: View
    ): RecyclerView.ViewHolder(containerView), LayoutContainer {
    var itemClick: ((Int) -> Unit)? = null

    companion object {
        fun create(parent: ViewGroup): WeatherHolder {
            return WeatherHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_weather, parent, false),
            )
        }
    }

    fun bind (city: City){
        val tempColor = TempService()
        tv_city_name.text = city.name
        tv_city_temp.text = city.temperature.toString() + "°"
        tv_city_temp.setTextColor(ContextCompat.getColor(containerView.context, tempColor.findColor(city.temperature.toInt())))
        itemView.setOnClickListener{
            itemClick?.let { it1 -> it1(city.id) }
        }

    }
}