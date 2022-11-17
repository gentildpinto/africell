package me.gentilpinto.africell.view.adapter

import me.gentilpinto.africell.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.imageview.ShapeableImageView
import com.smarteist.autoimageslider.SliderViewAdapter

class SliderAdapter(private var sliderItems: List<Int>) :
    SliderViewAdapter<SliderAdapter.SliderAdapterVH>() {

    fun renewItems(sliderItems: List<Int>) {
        this.sliderItems = sliderItems
        notifyDataSetChanged()
    }

    fun deleteItem(position: Int) {
        this.sliderItems = this.sliderItems.drop(position)
        notifyDataSetChanged()
    }

    fun addItem(sliderItem: ShapeableImageView) {
        this.sliderItems.apply { addItem(sliderItem) }
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return this.sliderItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH? {
        val inflate: View =
            LayoutInflater.from(parent.context).inflate(R.layout.image_slider, null)
        return SliderAdapterVH(inflate)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterVH?, position: Int) {
        if (viewHolder != null) {
            val item: Int = this.sliderItems[position]
            viewHolder.imageView.setImageResource(item)
        }
    }

    class SliderAdapterVH(itemView: View?) : ViewHolder(itemView) {
        var imageView: ShapeableImageView = itemView!!.findViewById(R.id.shapeableImageView)
    }
}