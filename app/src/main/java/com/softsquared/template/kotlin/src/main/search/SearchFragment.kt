package com.softsquared.template.kotlin.src.main.search

import android.os.Bundle
import android.view.View
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentMyPageBinding
import com.softsquared.template.kotlin.databinding.FragmentSearchBinding


class SearchFragment :
    BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::bind, R.layout.fragment_search){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editor = ApplicationClass.sSharedPreferences.edit()

        binding.back.setOnClickListener {
            parentFragmentManager.beginTransaction().remove(this).commit()
        }

        binding.searchIcon2.setOnClickListener {
            editor.putString("search",binding.editText.text.toString())
            editor.apply()
            parentFragmentManager.beginTransaction().add(R.id.main_frm, Search2Fragment()).commit()
        }
    }

}