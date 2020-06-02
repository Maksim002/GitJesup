package com.example.gitjesup


import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    private var image: ImageView = itemView.findViewById(R.id.image_new)
    private var title: TextView = itemView.findViewById(R.id.text_new)


    fun bind(newModel: NewModel) {
        title.text = newModel.title

        Picasso.with(image.context)
            .load(newModel.image)
            .transform(CropSquareTransformation())
            .into(image)
    }
}