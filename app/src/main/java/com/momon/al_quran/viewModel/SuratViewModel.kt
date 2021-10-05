package com.momon.al_quran.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.momon.al_quran.api.Retrofit
import com.momon.al_quran.model.Surat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SuratViewModel : ViewModel(){

    var aresponse = MutableLiveData<ArrayList<Surat.Data.Verses>>()
    var bresponse = MutableLiveData<Surat>()

        fun getSurat(number: Int): MutableLiveData<ArrayList<Surat.Data.Verses>> {
            Retrofit.api.getSurat(number)
                .enqueue(object : Callback<Surat> {

                    override fun onFailure(call: Call<Surat>, t: Throwable) {
                        t.message?.let { Log.d("Failure", it) }
                    }
                    override fun onResponse(

                        call: Call<Surat>,
                        response: Response<Surat>
                    ) {
                        if(response.isSuccessful){
                            aresponse.value = response.body()?.data?.verses
                        }
                    }

                })
            return aresponse
        }
    fun getSurat2(number: Int): MutableLiveData<Surat> {
        Retrofit.api.getSurat(number)
            .enqueue(object : Callback<Surat> {

                override fun onFailure(call: Call<Surat>, t: Throwable) {
                    t.message?.let { Log.d("Failure", it) }
                }
                override fun onResponse(

                    call: Call<Surat>,
                    response: Response<Surat>
                ) {
                    if(response.isSuccessful){
                        bresponse.value = response.body()
                    }
                }

            })
        return bresponse
    }
}