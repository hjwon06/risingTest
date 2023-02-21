package com.softsquared.template.kotlin.src.main.search

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.main.home.models.HospitalDataResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchService(val searchFragmentInterface: SearchFragmentInterface) {

    fun tryGetHos(apiKey : String){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(SearchRetrofitInterface::class.java)
        homeRetrofitInterface.getHospital(apiKey).enqueue(object : Callback<HospitalDataResponse>{
            override fun onResponse(call: Call<HospitalDataResponse>, response: Response<HospitalDataResponse>) {
                searchFragmentInterface.onGetUserSuccess(response.body() as HospitalDataResponse)
            }

            override fun onFailure(call: Call<HospitalDataResponse>, t: Throwable) {
                searchFragmentInterface.onGetUserFailure(t.message ?: "통신 오류")
            }
        })
    }

}
