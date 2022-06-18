package com.example.frontend

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.frontend.R.*
import java.lang.ref.WeakReference

class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val view = WeakReference(itemView)
    private var textViewTitle: TextView? = null
    private var textViewDate: TextView? = null

    var itemModel: ItemModel? = null

    init {
        view.get()?.let{
            textViewTitle = it.findViewById(id.textView6)
            textViewTitle = it.findViewById(id.textView7)
        }
    }
    fun updateView(){
        textViewTitle?.text=itemModel?.title
        textViewDate?.text=itemModel?.date
    }
}
