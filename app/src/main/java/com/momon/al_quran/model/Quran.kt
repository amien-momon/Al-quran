package com.momon.al_quran.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Quran(
    @SerializedName("number")
    val number: Int,
    @SerializedName("numberOfVerses")
    val numberOfVerses : Int,
    @SerializedName("name")
    var name: Name

) : Parcelable {
    @Parcelize
    data class Name(
        @SerializedName("short")
        val short : String,
        @SerializedName("long")
        val long : String,
        var transliteration: SubContent2? = null
        ): Parcelable{
        @Parcelize
        data class SubContent2(
            @SerializedName("id")
            val id : String
        ): Parcelable
    }
}
