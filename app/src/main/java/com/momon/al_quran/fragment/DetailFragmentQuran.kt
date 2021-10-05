package com.momon.al_quran.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.momon.al_quran.adapter.SuratAdapter
import com.momon.al_quran.databinding.FragmentDetailQuranBinding
import com.momon.al_quran.viewModel.SuratViewModel


class DetailFragmentQuran : Fragment() {
    private val args by navArgs<DetailFragmentQuranArgs>()
    private lateinit var binding : FragmentDetailQuranBinding
    private lateinit var viewModel : SuratViewModel
    private lateinit var myAdapter : SuratAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentDetailQuranBinding.inflate(inflater, container, false)
        val view = binding.root



        val a = args.current.number

        myAdapter = SuratAdapter()
        myAdapter.notifyDataSetChanged()

        binding.apply {
            recycler.apply {
                adapter = myAdapter
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
            }
        }

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[SuratViewModel::class.java]

      showloading(true)



        if (a == 1 || a == 9) {
            viewModel.getSurat(a).observe(viewLifecycleOwner, {
                showloading(true)
                if (it != null) {
                    myAdapter.setData1(it)
                    showloading(false)
                }
            })
            viewModel.getSurat2(2).observe(viewLifecycleOwner, {
                showloading(true)
                if (it != null) {
                    binding.apply {
                        showloading(false)
                        tname.text = args.current.name.transliteration?.id
                        tvbis.text = it.data.preBismillah.text.arab
                        tarti.text = it.data.preBismillah.translation.id

                    }
                }
            })

        } else {
            viewModel.getSurat(a).observe(viewLifecycleOwner, {
                showloading(true)
                if (it != null) {
                    showloading(false)
                    myAdapter.setData(it)
                }
            })
            viewModel.getSurat2(a).observe(viewLifecycleOwner, {
                showloading(true)
                if (it != null) {
                    binding.apply {
                        showloading(false)
                        tname.text = args.current.name.transliteration?.id
                        tvbis.text = it.data.preBismillah.text.arab
                        tarti.text = it.data.preBismillah.translation.id


                    }
                }
            })

        }

        return  view
    }


    private fun showloading(state :Boolean){
        if (state){
            binding.progressBar.visibility = View.VISIBLE
        }else{
            binding.progressBar.visibility = View.GONE
        }
    }

}