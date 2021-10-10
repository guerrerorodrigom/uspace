package com.raywenderlich.android.uspace.network.dto

import com.google.gson.annotations.SerializedName

data class CrewDTO(
    val name: String,
    val agency: String,
    val image: String,
    @SerializedName("wikipedia")
    val externalLink: String,
    val status: String
)
