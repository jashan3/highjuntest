package com.han.highjune.model

import androidx.recyclerview.widget.DiffUtil

data class NotiModel (
    var notiID:String,
    var notiTitle:String,
    var notiExplain:String
){

    companion object{
        fun refresh():List<NotiModel>{
            val noti1 = NotiModel("noti1","default notification","기본 노티피케이션 입니다.")
            val noti2 = NotiModel("noti2","default notification","기본 노티피케이션 입니다.")
            val noti3 = NotiModel("noti3","default notification","기본 노티피케이션 입니다.")
            val noti4 = NotiModel("noti4","default notification","기본 노티피케이션 입니다.")
            val noti5 = NotiModel("noti5","default notification","기본 노티피케이션 입니다.")

            val list = arrayListOf<NotiModel>()
            list.addAll(listOf(noti1,noti2,noti3,noti4,noti5))
            return list
        }


        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<NotiModel>() {
            override fun areItemsTheSame(oldItem: NotiModel, newItem: NotiModel): Boolean {
                return oldItem.notiID == newItem.notiID
            }

            override fun areContentsTheSame(oldItem: NotiModel, newItem: NotiModel): Boolean {
                return oldItem == newItem
            }
        }
    }

}