package com.softsquared.template.kotlin.src.main.search.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("등록기준일")
    val 등록기준일: String?,
    @SerializedName("순번")
    val 순번: Int?,
    @SerializedName("의료기관명")
    val 의료기관명: String?,
    @SerializedName("의료기관전화번호")
    val 의료기관전화번호: String?,
    @SerializedName("의료기관종")
    val 의료기관종: String?,
    @SerializedName("의료기관주소(도로명)")
    val 의료기관주소도로명: String?
)