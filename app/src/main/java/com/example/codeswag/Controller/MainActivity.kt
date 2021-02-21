package com.example.codeswag.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.codeswag.Adapters.CategoryAdapter
import com.example.codeswag.Model.Category
import com.example.codeswag.R
import com.example.codeswag.Services.DataService
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    //lateinit var adapter: ArrayAdapter<Category> //adapter to take data and put it in the list view

    lateinit var adapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryAdapter(this, DataService.category)

        categoryListView.adapter = adapter //setting the adapter for the list view from activity_main to the adapter created

        categoryListView.setOnItemClickListener { adapterView, view, i, l ->
            val category = DataService.category[i]
            Toast.makeText(this, "You clicked on ${category} item", Toast.LENGTH_SHORT).show()
        }
    }
}