package com.softsquared.template.kotlin.src.main

interface ItemClickListener<T> {
    fun onItemClick(pos:Int, item:T)
}