package com.nuc.gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_pager_content.view.*


class PagerPhotoListAdapter :
    ListAdapter<PhotoItem, PagerPhotoViewHolder>(DiffCallBack) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerPhotoViewHolder {
        LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.view_pager_content,
                parent, false
            )
            .apply {
                return PagerPhotoViewHolder(this)
            }
    }

    override fun onBindViewHolder(holder: PagerPhotoViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(getItem(position).previewUrl)
            .placeholder(R.drawable.ic_photo_gray_24dp)
            .into(holder.itemView.pagerPhoto)
    }

    object DiffCallBack :
        DiffUtil.ItemCallback<PhotoItem>() {
        override fun areItemsTheSame(oldItem: PhotoItem, newItem: PhotoItem): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: PhotoItem, newItem: PhotoItem): Boolean {
            return oldItem.photoId == newItem.photoId
        }

    }
}

class PagerPhotoViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

}
