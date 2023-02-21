package com.softsquared.template.kotlin.src.main.search

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.databinding.SearchListItemBinding
import com.softsquared.template.kotlin.src.main.ItemClickListener
import com.softsquared.template.kotlin.src.main.home.models.HospitalDataResponse
import com.softsquared.template.kotlin.src.main.home.models.Row

class SearchHospitalAdapter(var hospitalList: List<Row>, private val clickListener : ItemClickListener<Row>) : RecyclerView.Adapter<SearchHospitalAdapter.HospitalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalViewHolder {
        val binding = SearchListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return HospitalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HospitalViewHolder, position: Int) {
        holder.bind(hospitalList[position])
        val editor = ApplicationClass.sSharedPreferences.edit()
        holder.binding.searchListItem.setOnClickListener {
            clickListener.onItemClick(position,hospitalList[position])
            editor.putString("name",hospitalList[position].hospitalName)
            editor.putString("taenm",hospitalList[position].UPTAENM)
            editor.apply()
            Log.d("test1",ApplicationClass.sSharedPreferences.getString("name","").toString())
        }
    }

    override fun getItemCount(): Int {
        return hospitalList.size
    }

    inner class HospitalViewHolder(val binding : SearchListItemBinding) : RecyclerView.ViewHolder(binding.root){
        @SuppressLint("SetTextI18n")
        fun bind(hospitalList: Row){
            binding.textView5.text = hospitalList.hospitalName
            binding.textView8.text = " | " + hospitalList.hospitalAddress

        }
    }
}