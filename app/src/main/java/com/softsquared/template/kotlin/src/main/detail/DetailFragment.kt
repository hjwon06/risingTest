package com.softsquared.template.kotlin.src.main.detail

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentDetailHospitalBinding
import com.softsquared.template.kotlin.databinding.FragmentHomeBinding
import com.softsquared.template.kotlin.src.main.MainActivity
import com.softsquared.template.kotlin.src.main.home.models.PostSignUpRequest
import com.softsquared.template.kotlin.src.main.home.models.SignUpResponse
import com.softsquared.template.kotlin.src.main.home.models.UserResponse
import com.softsquared.template.kotlin.src.main.search.SearchFragment

class DetailFragment : BaseFragment<FragmentDetailHospitalBinding>(FragmentDetailHospitalBinding::bind, R.layout.fragment_detail_hospital){


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = ApplicationClass.sSharedPreferences.getString("name","")
        val taenm = ApplicationClass.sSharedPreferences.getString("taenm","")

        binding.mainScrollView.run {
            header = binding.headerView
        }

        binding.ibtnDetailHospitalBack.setOnClickListener {
            parentFragmentManager.beginTransaction().remove(this).commit()
        }

        binding.tvDetailHospitalTitle.text = name
        binding.tvDetailHospitalName.text = name
        binding.tvDetailHospitalHospitalSector.text = taenm

    }

}