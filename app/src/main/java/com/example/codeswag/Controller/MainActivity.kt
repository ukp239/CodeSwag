package com.example.codeswag.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.codeswag.Model.Category
import com.example.codeswag.R
import com.example.codeswag.Services.DataService
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var adapter: ArrayAdapter<Category> //adapter to take data and put it in the list view

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                DataService.category
        )

        categoryListView.adapter = adapter //setting the adapter for the list view from activity_main to the adapter created
    }
}