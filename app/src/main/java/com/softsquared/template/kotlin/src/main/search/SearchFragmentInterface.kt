package com.softsquared.template.kotlin.src.main.search

import com.softsquared.template.kotlin.src.main.home.models.HospitalDataResponse


interface SearchFragmentInterface {

    fun onGetUserSuccess(response: HospitalDataResponse)

    fun onGetUserFailure(message: String)

//    fun onPostSignUpSuccess(response: SignUpResponse)
//
//    fun onPostSignUpFailure(message: String)
}