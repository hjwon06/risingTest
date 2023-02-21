package com.softsquared.template.kotlin.src.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.R

class MyViewPagerAdapter (var viewPagerImg: ArrayList<Int>) :
    RecyclerView.Adapter<MyViewPagerAdapter.PagerViewHolder>() {


    inner class PagerViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder
        (LayoutInflater.from(parent.context).inflate(R.layout.main_img_slider, parent, false)) {
        val viewManager = itemView.findViewById<ImageView>(R.id.main_post_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PagerViewHolder((parent))

    override fun getItemCount(): Int = viewPagerImg.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.viewManager.setImageResource(viewPagerImg[position])
    }
}