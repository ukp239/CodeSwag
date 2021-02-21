package com.example.codeswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.codeswag.Model.Category
import com.example.codeswag.R
import java.util.zip.Inflater


//Base adapter is an adapter that other adapters can inherit from
class CategoryAdapter(context: Context, categories : List<Category>) : BaseAdapter() {

    val context = context
    val categories = categories


    //Alt enter on base adapter to implement these 4 methods
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView : View
        categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_items, null)
        //Layout inflater takes a layout and creates a view out of this
        //Now we need to create UI items based on the ids that are found inside these list items that are categoryName and categoryImage

        val categoryImage : ImageView = categoryView.findViewById(R.id.categoryImage)
        val categoryName : TextView = categoryView.findViewById(R.id.categoryName)

        val category = categories[position]

        // We have image names but we need the resource Ids

        val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
        categoryImage.setImageResource(resourceId)

        println(resourceId)
        categoryName.text = category.title

        return categoryView
    }

    override fun getItem(position: Int): Any {
        return categories[position]
    } //item at a articular position

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return categories.count()
    }  // how many items are there in the list view


}