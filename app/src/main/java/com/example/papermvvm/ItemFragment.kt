package com.example.papermvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.papermvvm.databinding.FragmentItemListBinding


class ItemFragment : Fragment() {

    private lateinit var carViewModel: CarViewModel
    private lateinit var binding: FragmentItemListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)
        val list = view.findViewById<RecyclerView>(R.id.list)
        val btnAddCar = view.findViewById<Button>(R.id.btnAddCar)
        // Set the adapter
        carViewModel = ViewModelProvider(requireActivity())[CarViewModel::class.java]

        carViewModel.cars.observe(viewLifecycleOwner){cars ->
            if(!cars.isNullOrEmpty()){
                with(list) {
                    layoutManager = LinearLayoutManager(context)
                    adapter = MyItemRecyclerViewAdapter(cars)
                }
            }
        }

        return view
    }

}