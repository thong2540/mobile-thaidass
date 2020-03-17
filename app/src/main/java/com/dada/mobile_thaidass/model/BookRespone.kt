package com.dada.mobile_thaidass.model


import com.google.firebase.database.IgnoreExtraProperties
import com.google.firebase.database.PropertyName

@IgnoreExtraProperties
data class BookRespone(
    @PropertyName("id")
    val id: String = "",
    @PropertyName("imagebook")
    val imagebook: String = "",
    @PropertyName("imagecontent")
    val imagecontent: String = "",
    @PropertyName("imagedress1-2")
    val imagedress12: String = "",
    @PropertyName("imagerama")
    val imagerama: String = "",
    @PropertyName("infocontent")
    val infocontent: String = "",
    @PropertyName("infodress1")
    val infodress1: String = "",
    @PropertyName("infodress2")
    val infodress2: String = "",
    @PropertyName("namebook")
    val namebook: String = "",
    @PropertyName("namecontent")
    val namecontent: String = "",
    @PropertyName("namedress1")
    val namedress1: String = "",
    @PropertyName("namedress2")
    val namedress2: String = "",
    @PropertyName("namerama")
    val namerama: String = ""
)