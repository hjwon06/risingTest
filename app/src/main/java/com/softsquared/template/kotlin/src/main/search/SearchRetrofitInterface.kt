package com.softsquared.template.kotlin.src.main.search

import com.softsquared.template.kotlin.src.main.home.models.HospitalDataResponse
import com.softsquared.template.kotlin.src.main.home.models.PostSignUpRequest
import com.softsquared.template.kotlin.src.main.home.models.SignUpResponse
import retrofit2.Call
import retrofit2.http.*

interface SearchRetrofitInterface {

    //666e556d666e6f673130395542784968
    @GET("{apiKey}/json/LOCALDATA_010101_NW/1/100/")
    fun getHospital(@Path("apiKey") apiKey : String) : Call<HospitalDataResponse>

    @POST("/template/users")
    fun postSignUp(@Body params: PostSignUpRequest): Call<SignUpResponse>
}
