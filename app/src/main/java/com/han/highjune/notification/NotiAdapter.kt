package com.han.highjune.notification

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.ViewGroupCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.han.highjune.R
import com.han.highjune.model.Music
import com.han.highjune.model.NotiModel

class NotiAdapter(private val onClick:(noti:NotiModel)->Unit) : ListAdapter<NotiModel, NotiHolder>(NotiModel.DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotiHolder {
        return NotiHolder(parent).apply {
            itemView.setOnClickListener {
                onClick(getItem(adapterPosition))
            }
        }
    }

    override fun onBindViewHolder(holder: NotiHolder, position: Int) {
      holder.bind(getItem(position))
    }
}

class NotiHolder(parent:ViewGroup): RecyclerView.ViewHolder(
    LayoutInflater
        .from(parent.context)
        .inflate(R.layout.noti_list_item, parent, false)
) {
    private val mTitle: TextView = itemView.findViewById(R.id.mTitle)
    private val mBody: TextView = itemView.findViewById(R.id.mBody)


    init {
        ViewGroupCompat.setTransitionGroup(itemView as ViewGroup, true)
    }

    fun bind(noti: NotiModel) {
        mTitle.text = noti.notiTitle
        mBody.text = noti.notiExplain
    }
}