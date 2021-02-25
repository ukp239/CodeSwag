package com.example.codeswag.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.codeswag.Model.Product
import com.example.codeswag.R
import com.example.codeswag.Utilities.EXTRA_CATEGORY
import com.example.codeswag.Utilities.EXTRA_ITEM
import kotlinx.android.synthetic.main.activity_item.*

class ItemActivity : AppCompatActivity() {

    lateinit var itemType : Product
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        itemType = intent.getParcelableExtra(EXTRA_ITEM)!!

        val context = this

        itemImage.setImageResource(context.resources.getIdentifier(itemType.image, "drawable", context.packageName))

        itemNametext.text = itemType.title
        itemPriceText.text = itemType.price
        itemDescription.text = "You would have definitely seen Shahrukh Khan in this ${itemType.title} outfit. It is designed and manufactured " +
                "exclusively by us.. The price ${itemType.price} is the best deal that you can get anywhere. " +
                "Order soon before it gets out of stock.... "




    }


    fun buyButtonClicked(view: View) {
        Toast.makeText(this, "Ohh No!!. It just went Out of Stock!!", Toast.LENGTH_SHORT).show()

    }
}