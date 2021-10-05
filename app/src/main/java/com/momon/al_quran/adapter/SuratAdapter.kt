package com.momon.al_quran.adapter


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.momon.al_quran.databinding.ItemSuratBinding
import com.momon.al_quran.model.Surat


class SuratAdapter : RecyclerView.Adapter<SuratAdapter.SuratViewHolder>(){
   private var data = ArrayList<Surat.Data.Verses>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(surat:ArrayList<Surat.Data.Verses>){
        this.data.clear()
        this.data.addAll(surat)
        notifyDataSetChanged()
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setData1(surat:ArrayList<Surat.Data.Verses>){
        this.data.clear()
        this.data.add(surat[1])
        this.data.add(surat[2])
        this.data.add(surat[3])
        this.data.add(surat[4])
        this.data.add(surat[5])
        this.data.add(surat[6])
        notifyDataSetChanged()
    }

    inner class SuratViewHolder(private val binding : ItemSuratBinding): RecyclerView.ViewHolder(binding.root){
        fun  bind(surat:Surat.Data.Verses){

            binding.apply {
                tAyat.text = surat.text.arab
                tvArti.text = surat.translation.id

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuratViewHolder {
        val view = ItemSuratBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SuratViewHolder((view))
    }

    override fun onBindViewHolder(holder: SuratViewHolder, position: Int) {
        holder.bind(data[position])

    }

    override fun getItemCount(): Int {
        return data.size
    }


}