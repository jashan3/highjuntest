package com.han.highjune.Util

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.han.highjune.model.DefaultListModel
import com.han.highjune.model.Music
import org.json.JSONObject
import java.io.InputStream

class Parser{
    companion object{
        fun getAlbumList(context:Context,fileName:String ): ArrayList<DefaultListModel> {
            val list_album: ArrayList<DefaultListModel> = ArrayList()
            val gson = Gson()
            try {
                val `is`: InputStream = context.assets.open("${fileName}.json")
                val buffer = ByteArray(`is`.available())
                `is`.read(buffer)
                `is`.close()
                val json = String(buffer)
                val jsonObject = JSONObject(json)
                val jsonArray = jsonObject.getJSONArray(fileName)
                var index = 0
                while (index < jsonArray.length()) {
                    val albumVO: DefaultListModel =
                        gson.fromJson(jsonArray[index].toString(), DefaultListModel::class.java)
                    list_album.add(albumVO)
                    index++
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return list_album
        }

        fun getMusicList(context:Context,fileName:String ): ArrayList<Music> {
            val lst: ArrayList<Music> = ArrayList()
            val gson2 = Gson()
            try {
                val `is`: InputStream = context.assets.open("${fileName}.json")
                val buffer = ByteArray(`is`.available())
                `is`.read(buffer)
                `is`.close()
                val json = String(buffer)
                val jsonObject = JSONObject(json)
                val jsonArray = jsonObject.getJSONArray(fileName)
                var index = 0
                while (index < jsonArray.length()) {
                    val albumVO: Music =
                        gson2.fromJson(jsonArray[index].toString(), Music::class.java)
                    lst.add(albumVO)
                    index++
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return lst
        }
    }
}