package com.momon.al_quran.model

import com.google.gson.annotations.SerializedName

data class Surat(
 val data : Data
 //@SerializedName("verses")
// val verses : Verses
){
 data class Data(
  val number : Int,
  val preBismillah : Bismi,
  val verses :  ArrayList<Verses>
 ) {  data class Bismi(
          @SerializedName("text")
          val text : Text1,
          val translation : Text1
      ){
         data class Text1(
             @SerializedName("arab")
             val arab : String,
             @SerializedName("id")
             val id : String
             )
     }
     data class Verses(
         @SerializedName("text")
         val text : Text,
         val translation : Text

     ){
         data class Text(
             @SerializedName("arab")
             val arab : String,
             @SerializedName("id")
             val id : String

         )
     }

 }
}
