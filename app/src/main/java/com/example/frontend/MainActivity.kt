package com.example.frontend

import android.content.ClipData
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.time.OffsetDateTime


class MainActivity : AppCompatActivity() {
private val swipeRefreshLayout: SwipeRefreshLayout by lazy {
findViewById(R.id.swipeRefereshLayout)
}
    private val recyclerView: RecyclerView by lazy {
    findViewById(R.id.recycler)
}
    private lateinit var adapter:TestAdapter
    private lateinit var layoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initList()
        reload()
        val btnShow : Button = findViewById(R.id.button)
        btnShow.setOnClickListener{
            val view: View = layoutInflater.inflate(R.layout.bottomnavigationpanel,null)
            val dialog = BottomSheetDialog(this)
            dialog.setContentView(view)
            dialog.show()
        }

    }
    private fun initList(){
        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing=false
            reload()
        }
        layoutManager = LinearLayoutManager(this)
        adapter = TestAdapter {
            loadMore()
        }
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter= adapter
    }
    private fun reload(){
        val list = dummyData(0,20)
        recyclerView.post {
            adapter.reload(list)
        }
    }
    private fun loadMore(){
        val list = dummyData(adapter.itemCount,20)
        recyclerView.post {
            adapter.loadMore(list)
        }
    }
    private fun dummyData(offset:Int,limit:Int):MutableList<ItemModel>{
        val list= mutableListOf<ItemModel>()
        var itemModel: ItemModel
        for (i in offset until offset+ limit){
            itemModel=when(i){
                in 0..15->{
                    ItemModel("title $i", getDummyDataString("01"))
                }
                in 16..30->{
                    ItemModel("title $i",getDummyDataString("02"))
                }
                else->{
                    ItemModel("title $i",getDummyDataString("03"))
                }
            }
            list.add(itemModel)

        }
        return list
    }
    private fun getDummyDataString(day:String):String{
        return "2022-06-$day"
    }
}