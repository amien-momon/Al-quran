package com.momon.al_quran.api


import com.momon.al_quran.model.Surat
import com.momon.al_quran.response.QuranListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface Api {
    @GET("surah")
    fun getQuran(): Call<QuranListResponse>

    @GET("surah/{number}")
    fun getSurat(
        @Path("number") number: Int
    ): Call<Surat>

}