package com.softsquared.template.kotlin.src.main.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentHomeBinding
import com.softsquared.template.kotlin.src.main.MainActivity
import com.softsquared.template.kotlin.src.main.home.models.PostSignUpRequest
import com.softsquared.template.kotlin.src.main.home.models.SignUpResponse
import com.softsquared.template.kotlin.src.main.home.models.UserResponse
import com.softsquared.template.kotlin.src.main.search.SearchFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home),
        HomeFragmentInterface {

    lateinit var viewPager: ViewPager2

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mainact = activity as MainActivity
        mainact.hideNavigationBar(false)

        viewPager = binding.homeViewpager
        viewPager.adapter = MyViewPagerAdapter(getviewPagerImg()) // 어댑터 생성
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL // 방향을 가로로

        binding.searchIcon.setOnClickListener {
            parentFragmentManager.beginTransaction().add(R.id.main_frm, SearchFragment()).commit()
            val mainAct = activity as MainActivity
            mainAct.hideNavigationBar(false)
        }

    }

    private fun getviewPagerImg(): ArrayList<Int> {
        return arrayListOf<Int>(
            R.drawable.ic_view_pager_1,
            R.drawable.ic_view_pager_2,
            R.drawable.ic_view_pager_3,)
    }

    override fun onGetUserSuccess(response: UserResponse) {
    }

    override fun onGetUserFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }

    override fun onPostSignUpSuccess(response: SignUpResponse) {
//        dismissLoadingDialog()
//        binding.homeBtnTryPostHttpMethod.text = response.message
//        response.message?.let { showCustomToast(it) }
    }

    override fun onPostSignUpFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }
}