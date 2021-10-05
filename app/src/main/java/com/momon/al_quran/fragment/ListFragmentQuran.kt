package com.momon.al_quran.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.momon.al_quran.viewModel.QuranViewModel
import com.momon.al_quran.adapter.QuranAdapter
import com.momon.al_quran.databinding.FragmentListQuranBinding



class ListFragmentQuran : Fragment() {
    private lateinit var binding : FragmentListQuranBinding
    private lateinit var viewModel : QuranViewModel
    private lateinit var myAdapter : QuranAdapter
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentListQuranBinding.inflate(inflater, container, false)
        val view = binding.root

        myAdapter = QuranAdapter()
        myAdapter.notifyDataSetChanged()


            binding.apply {
            recyclerView.apply {
                adapter = myAdapter
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)

                }
            }

        viewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory())[QuranViewModel :: class.java]

            viewModel.getQuran().observe(viewLifecycleOwner,{
                if (it != null){
                    myAdapter.setData(it)
                }
            })
        return view
    }



}