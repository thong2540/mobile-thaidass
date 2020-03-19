package com.dada.mobile_thaidass.model

import java.io.Serializable

data class Content(
    var title: String = "",
    var itemBoy: Six,
    var itemWoMen: Six
): Serializable

data class Six(
    var icon: List<LstIcon> = arrayListOf(),
    var content: List<LstContent> = arrayListOf()
): Serializable

data class LstIcon(
    var icon: Int = -1
): Serializable

data class LstContent(
    var content: Int = -1
): Serializable