package com.momon.al_quran.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.momon.al_quran.databinding.ItemQuranBinding
import com.momon.al_quran.fragment.ListFragmentQuranDirections
import com.momon.al_quran.model.Quran


class QuranAdapter: RecyclerView.Adapter<QuranAdapter.QuranViewHolder>(){

    private var data = ArrayList<Quran>()


    @SuppressLint("NotifyDataSetChanged")
    fun setData(quran: ArrayList<Quran>){
        this.data.clear()
        this.data.addAll(quran)
        notifyDataSetChanged()
    }

    inner class QuranViewHolder(val binding : ItemQuranBinding):RecyclerView.ViewHolder(binding.root){

       val rowHutang : LinearLayout = binding.rowQuranLayout

        fun  bind(quran:Quran){

            binding.apply {
                tvAsma.text = quran.name.short
                tvNama.text = quran.name.transliteration?.id
                tvNumber.text = quran.number.toString()
                tvAyat.text = quran.numberOfVerses.toString()

            }

            }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuranViewHolder {
        val view = ItemQuranBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuranViewHolder((view))

    }

    override fun onBindViewHolder(holder: QuranViewHolder, position: Int) {

        holder.bind(data[position])
        val current = data[position]
        //holder.number1.text = current.number.toString()
       holder.rowHutang.setOnClickListener {
            val action = ListFragmentQuranDirections.actionListFragmentQuranToDetailFragmentQuran(current)
                holder.itemView.findNavController().navigate(action)
        }

    }



    override fun getItemCount(): Int {
        return data.size
    }
   /* interface OnItemClickCallBack{
        fun onItemClicked(data: Quran)
    }*/

}