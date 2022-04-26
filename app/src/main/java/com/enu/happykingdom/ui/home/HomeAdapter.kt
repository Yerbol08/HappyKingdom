package com.enu.happykingdom.ui.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.enu.happykingdom.R

class HomeAdapter(private val list: List<HomeItems>, var context: Context): RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    class ViewHolder (ItemView: View):RecyclerView.ViewHolder(ItemView){
        val name: TextView = itemView.findViewById(R.id.name_lessions)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val text: TextView = itemView.findViewById(R.id.text_lessions)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeAdapter.ViewHolder, position: Int) {
        val items = list[position]
        holder.name.text = items.name
        holder.text.text = items.text
        items.image?.let { holder.imageView.setImageResource(it)
        holder.itemView.setOnClickListener(View.OnClickListener {
            var intent: Intent = Intent(context, LessonActivity::class.java)
            intent.putExtra("name", items.name)
            intent.putExtra("image", items.image)
            intent.putExtra("position", position)
            intent.putExtra("text", items.text)
            context.startActivity(intent)

        })}
    }

    override fun getItemCount(): Int {
        return list.size
    }
}