package com.example.frontend

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.os.Build
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager
import androidx.recyclerview.widget.RecyclerView

class ItemSectionDecoration(
    private val context: Context,
    private val getItemList: ()->   MutableList<ItemModel>
): RecyclerView.ItemDecoration() {

    private val dividerHeight = dipToPx(context,0.8f)
    private val dividerPaint = Paint(Paint.ANTI_ALIAS_FLAG).also{
        it.color = Color.parseColor("ff0000")
    }
    private val sectionItemWidth: Int by lazy {
        getScreenWidth(context)
    }
    private val sectionViewHolder

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
    }
    private fun dipToPx(context: Context, dipValue: Float): Int {
        return (dipValue * context.resources.displayMetrics.density).toInt()
    }
    private fun getScreenWidth(context:Context):Int{
            val outMetrics = DisplayMetrics()
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.R){
            val display = context.display
            display?.getRealMetrics(outMetrics)
        }
        else{
            val display = (context.getSystemService(Context.WINDOW_SERVICE)as WindowManager).defaultDisplay
            display.getMetrics(outMetrics)
        }
        return outMetrics.widthPixels
    }

}