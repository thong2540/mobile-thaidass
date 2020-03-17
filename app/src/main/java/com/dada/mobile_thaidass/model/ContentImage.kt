package com.dada.mobile_thaidass.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class ContentImage (
    val nameimage: String = "",
    val part: String = ""
)