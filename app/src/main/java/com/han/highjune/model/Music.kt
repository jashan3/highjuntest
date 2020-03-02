package com.han.highjune.model

import android.content.Context
import androidx.recyclerview.widget.DiffUtil
import com.han.highjune.Util.Parser

data class Music(
    val mTitle:String,
    val mBody:String,
    val mUrl:String)
{
companion object{

     fun refresh (context: Context):List<Music> {
       return Parser.getMusicList(context,"MusicList")
    }

    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Music>() {
        override fun areItemsTheSame(oldItem: Music, newItem: Music): Boolean {
            return oldItem.mTitle == newItem.mTitle
        }

        override fun areContentsTheSame(oldItem: Music, newItem: Music): Boolean {
            return oldItem == newItem
        }
    }
}
}