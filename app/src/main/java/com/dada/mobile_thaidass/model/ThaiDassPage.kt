package com.dada.mobile_thaidass.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class ThaiDassPage (
    val imagedress: String = "",
    val imagepage: String = "",
    val infodress: String = "",
    val namedress: String = "",
    val namepage: String = ""
)