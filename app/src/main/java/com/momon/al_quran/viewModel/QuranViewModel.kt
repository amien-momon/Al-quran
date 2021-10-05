package com.momon.al_quran.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.momon.al_quran.response.QuranListResponse
import com.momon.al_quran.api.Retrofit
import com.momon.al_quran.model.Quran
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class QuranViewModel :ViewModel() {

   var myResponse :MutableLiveData<ArrayList<Quran>> = MutableLiveData()

   fun getQuran(): LiveData<ArrayList<Quran>> {
      Retrofit.api.getQuran()
         .enqueue(object : Callback<QuranListResponse> {
            override fun onFailure(call: Call<QuranListResponse>, t: Throwable) {
               t.message?.let { Log.d("Failure", it) }
            }
            override fun onResponse(
               call: Call<QuranListResponse>,
               response: Response<QuranListResponse>
            ) {
               if(response.isSuccessful){
                  myResponse.apply {
                    value = response.body()!!.data
                  }
               }
            }

         })
      return myResponse
   }






}