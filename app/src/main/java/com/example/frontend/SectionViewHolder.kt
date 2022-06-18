package com.example.frontend

import android.content.Context
import android.widget.FrameLayout
import android.widget.TextView

class SectionViewHolder(
    context:Context
):FrameLayout(context){
    private lateinit var textViewDate:TextView
    init {
        inflate(context,R.layout.view_holder_section,this)
        findView()
    }

    private fun findView() {
        textViewDate=findViewById(R.id.textViewDate)
    }
    fun setDate(dateString:String){
        textViewDate.text=dateString
    }
}
