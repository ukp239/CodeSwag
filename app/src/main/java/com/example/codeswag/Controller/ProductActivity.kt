package com.example.codeswag.Controller

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.codeswag.Adapters.ProductAdapter
import com.example.codeswag.R
import com.example.codeswag.Services.DataService
import com.example.codeswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity() {

    lateinit var adapter : ProductAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)

        adapter = ProductAdapter(this, DataService.getProducts(categoryType))


        // When orientation is landscape we will want spancount to be 3, when it is potrait we want it to be 2
        // Also when screen size > 720 dp

        val orientation = resources.configuration.orientation

        var spanCount = 2

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 3
        }

        if (resources.configuration.screenWidthDp > 720){

            spanCount = 3
        }

        if ((resources.configuration.screenWidthDp > 720) and (orientation == Configuration.ORIENTATION_LANDSCAPE)){

            spanCount = 4
        }

        val layoutManger = GridLayoutManager(this, spanCount) // span count is the number of columns

        productListView.layoutManager = layoutManger
        productListView.adapter = adapter

    }
}