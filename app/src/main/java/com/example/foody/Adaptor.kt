package com.example.foody

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class Adaptor: RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private var items: List<FoodItems> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return FoodViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false))

    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(list: List<FoodItems>)
    {
        items = list
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            when(holder){
                is FoodViewHolder ->{
                    holder.bind(items.get(position))
                }
            }
    }

    class FoodViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var iname: TextView = itemView.iname
        var desc: TextView = itemView.idesc
        var image: ImageView = itemView.img

        fun bind(foodItems: FoodItems){
            iname.setText(foodItems.name)
            desc.setText(foodItems.desc)
            image.setImageResource(foodItems.image)
        }
    }
}

