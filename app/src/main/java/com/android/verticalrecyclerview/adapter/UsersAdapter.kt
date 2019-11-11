package com.android.verticalrecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.android.verticalrecyclerview.R
import java.util.*


class UsersAdapter(private var context: Context, private var items: ArrayList<UserDto>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ADD = 1
    private val TYPE_IMAGE = 2
    private var isAddExist = true

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == TYPE_ADD) {
            (holder as AddViewHolder).mImgAdd.setOnClickListener {
                if (items.size < 5) {
                    items.add(0, UserDto("", 2))
                    notifyDataSetChanged()
                } else {
                    items.add(0, UserDto("", 2))
                    items.removeAt(5)
                    isAddExist = false
                    notifyDataSetChanged()
                }
            }
        } else {
            (holder as ImageViewHolder).mImgDelete.setOnClickListener {
                if (items.size == 5 && !isAddExist) {
                    items.add(UserDto("", 1))
                    isAddExist = true
                }
                items.removeAt(position)
                notifyDataSetChanged()
            }
            holder.mImg.setImageResource(R.mipmap.ic_launcher)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        return if (viewType == TYPE_ADD) {
            view = LayoutInflater.from(context).inflate(R.layout.item_add, parent, false)
            AddViewHolder(view)
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.item_image, parent, false)
            ImageViewHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position].type == 1) {
            TYPE_ADD
        } else {
            TYPE_IMAGE
        }
    }

    internal inner class AddViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mImgAdd: ImageView = itemView.findViewById(R.id.mImageAdd)
    }

    internal inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mImg: ImageView = itemView.findViewById(R.id.mImageView)
        val mImgDelete: ImageView = itemView.findViewById(R.id.mImgDelete)
    }
}