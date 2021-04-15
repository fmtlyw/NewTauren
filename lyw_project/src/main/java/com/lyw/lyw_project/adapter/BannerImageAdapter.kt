package com.lyw.lyw_project.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lyw.lyw_project.databinding.ProjectItemBannerImageBinding
import com.lyw.lyw_provider.model.Item
import com.youth.banner.adapter.BannerAdapter

/**
 * 功能描述:
 * Created on 2021/4/15.
 * @author lyw
 */
class BannerImageAdapter(context: Context, datas: List<Item>) :
    BannerAdapter<Item, BannerImageAdapter.BannerViewHolder>(datas) {

    private val mInflater = LayoutInflater.from(context)

    class BannerViewHolder(val binding: ProjectItemBannerImageBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateHolder(parent: ViewGroup?, viewType: Int): BannerViewHolder {
        val binding = ProjectItemBannerImageBinding.inflate(mInflater, parent, false)
        return BannerViewHolder(binding)
    }

    override fun onBindView(holder: BannerViewHolder, data: Item?, position: Int, size: Int) {
        holder.binding.model = data
    }
}