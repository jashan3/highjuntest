package com.han.highjune.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.RecyclerView
import com.han.highjune.R

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val demoList: RecyclerView = view.findViewById(R.id.demo_list)
        val adapter = DemoListAdapter { demo ->
            requireActivity().startActivity(demo.toIntent())
        }
        demoList.adapter = adapter
        viewModel.demos.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
        }
    }
}