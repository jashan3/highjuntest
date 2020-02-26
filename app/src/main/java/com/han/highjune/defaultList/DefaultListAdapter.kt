package com.han.highjune.defaultList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.han.highjune.R
import com.han.highjune.model.DefaultListModel

class DefaultListAdapter(private val context: Context, private val model:ArrayList<DefaultListModel>, private val onListClick:(model:DefaultListModel) -> Unit ): RecyclerView.Adapter<DefaultListAdapter.DefaultListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DefaultListHolder {
        return DefaultListHolder(parent).apply {
            itemView.setOnClickListener {
                onListClick(model.get(adapterPosition))
            }
        }
    }

    override fun getItemCount(): Int {
        return model.size
    }

    override fun onBindViewHolder(holder: DefaultListHolder, position: Int) {
        holder.bindView(model.get(position))
    }


    inner class DefaultListHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.default_list_item, parent, false)
    ) {
        private val iv:ImageView = itemView.findViewById(R.id.imageview)
        private val titleView:TextView = itemView.findViewById(R.id.title_label)
        private val bodyView:TextView = itemView.findViewById(R.id.body_label)

        fun bindView(model:DefaultListModel){
            titleView.text = model.defaultTitle
            bodyView.text = model.defaultBody
            Glide
                .with(context)
                .load( model.defaultImage)
                .centerCrop()
                .placeholder(R.drawable.no_image)
                .into(iv)
        }
    }
}