package com.han.highjune.defaultList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.han.highjune.R
import com.han.highjune.Util.Parser


class DefaultListFragment :Fragment(){

//
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.default_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val data = context?.let {
            Parser.getAlbumList(it,"DefaultList")
        }
        val rcv: RecyclerView = view.findViewById(R.id.demo_list)
        val mAdapter = context?.let {
            data?.let { it1 ->
                DefaultListAdapter(it, it1){ list ->
                    Log.d("asdf","Title : ${list.defaultTitle}, Body : ${list.defaultBody}, image : ${list.defaultImage}")
                }
            }
        }

        rcv.apply {
            layoutManager = GridLayoutManager(context,2)
            adapter = mAdapter
        }
    }

}