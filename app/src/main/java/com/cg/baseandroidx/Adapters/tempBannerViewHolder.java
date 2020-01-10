package com.cg.baseandroidx.Adapters;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.cg.baseandroidx.R;
import com.cg.baseandroidx.customs.GlideRoundTransform;
import com.cg.baseandroidx.models.tempBannerModel;
import com.zhpan.bannerview.holder.ViewHolder;

/**
 * 首页banner的Viewholder
 */
public class tempBannerViewHolder implements ViewHolder<tempBannerModel> {
    @Override
    public int getLayoutId() {
        return R.layout.tempmainbanneritem;
    }

    @Override
    public void onBind(View itemView, tempBannerModel data, int position, int size) {
        ImageView banner_image = (ImageView)itemView.findViewById(R.id.banner_image);
        Glide.with(itemView).load(data.getPicURL())
                .apply(new RequestOptions().placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.img_login_loading1)
                        .transform(new GlideRoundTransform(5))//添加圆角
                        )
                .into(banner_image);
    }
}
