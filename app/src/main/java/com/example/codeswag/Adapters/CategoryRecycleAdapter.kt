package com.example.codeswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.codeswag.Model.Category
import com.example.codeswag.R
import kotlinx.android.synthetic.main.category_list_items.view.*
import com.example.codeswag.R.layout.category_list_items as category_list_items1

class CategoryRecycleAdapter (val context: Context, val categories : List<Category>) : RecyclerView.Adapter<CategoryRecycleAdapter.Holder>() {

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) { // inner class since class within class
        // in list view, we had to create our own holder class but here we can get extension from Recylerview.viewholder class (pre build)
        val categoryImage =  itemView?.findViewById<ImageView>(R.id.categoryImage)
        val categoryName = itemView?.findViewById<TextView>(R.id.categoryName)

        fun bindCategory(category: Category, context: Context){
            val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
            categoryImage?.setImageResource(resourceId)
            categoryName?.text = category.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.category_list_items, parent, false)
        return Holder(view)
    } // when new view holders are needed; similar to inflating the xml view for the first time

    override fun getItemCount(): Int {
        return categories.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bindCategory(categories[position], context)
    }  // to display the data at specific location

}