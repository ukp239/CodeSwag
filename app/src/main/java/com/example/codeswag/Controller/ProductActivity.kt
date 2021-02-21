package com.example.codeswag.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.codeswag.R
import com.example.codeswag.Utilities.EXTRA_CATEGORY

class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        println(categoryType)
    }
}