package com.softsquared.template.kotlin.src.main.search

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentSearch2Binding
import com.softsquared.template.kotlin.src.main.ItemClickListener
import com.softsquared.template.kotlin.src.main.detail.DetailFragment
import com.softsquared.template.kotlin.src.main.home.models.HospitalDataResponse
import com.softsquared.template.kotlin.src.main.home.models.Row

class Search2Fragment :
    BaseFragment<FragmentSearch2Binding>(FragmentSearch2Binding::bind, R.layout.fragment_search2),SearchFragmentInterface {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val apikey = "666e556d666e6f673130395542784968"
        SearchService(this).tryGetHos(apikey)

        binding.back.setOnClickListener {
            parentFragmentManager.beginTransaction().remove(this).commit()
        }
    }

    override fun onGetUserSuccess(response: HospitalDataResponse) {
        Log.d("test",response.LOCALDATA_010101_NW.row.toString())
        binding.hosCnt.text = "총 ${response.LOCALDATA_010101_NW.list_total_count}개"
        val searchName = ApplicationClass.sSharedPreferences.getString("search","")
        binding.editText.setText(searchName)
        binding.searchList.apply {
            adapter = SearchHospitalAdapter(response.LOCALDATA_010101_NW.row,object :
                ItemClickListener<Row> {
                override fun onItemClick(pos: Int, item: Row) {
                    /*
                    START_INDEX	INTEGER(필수)	요청시작위치	정수 입력 (페이징 시작번호 입니다 : 데이터 행 시작번호)
                    END_INDEX	INTEGER(필수)	요청종료위치	정수 입력 (페이징 끝번호 입니다 : 데이터 행 끝번호)
                    이렇게 정보를 주어주니깐 START_INDEX + 1 과 END_INDEX + 1 로 넘겨주고 GET을 그냥 따로 설정하자 -> ㅇㅇ
                     */
                    showDetailHospital(pos + 1)
                }
            })
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        }
        Log.d("test",response.toString())
    }

    override fun onGetUserFailure(message: String) {
        Log.d("test",message)
    }

    private fun showDetailHospital(pos : Int){ //행 번호를 넘겨주면 될듯 ㅇㅇ
        val args = Bundle()
        val detailHospitalFragment = DetailFragment()
        args.putInt("hospitalNum",pos)
        detailHospitalFragment.arguments = args
        parentFragmentManager.beginTransaction().add(R.id.main_frm,detailHospitalFragment).commit()

    }
}