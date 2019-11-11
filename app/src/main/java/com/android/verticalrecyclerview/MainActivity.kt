package com.android.verticalrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.verticalrecyclerview.adapter.UserDto
import com.android.verticalrecyclerview.adapter.UsersAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val arrList = ArrayList<UserDto>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        arrList.add(UserDto("", 1))
        val layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.HORIZONTAL, false)
        mRvImage.layoutManager = layoutManager
        val adapter = UsersAdapter(this@MainActivity, arrList)
        mRvImage.adapter = adapter
    }
}
