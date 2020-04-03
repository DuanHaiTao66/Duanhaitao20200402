package com.bw.duanhaitao.fragment;
/*
 *@auther:段海涛
 *@Date: 2020-04-02
 *@Time:20:27
 *@Description:${DESCRIPTION}
 **/

import android.view.View;

import com.bw.duanhaitao.R;
import com.bw.duanhaitao.base.BaseFragment;
import com.bw.duanhaitao.base.BasePresenter;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;

public class MyFragment extends BaseFragment {
    @BindView(R.id.sdv)
    SimpleDraweeView sdv;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView(View inflate) {
        sdv.setImageURI("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1585894729227&di=4e842738871634051378adc284c49919&imgtype=0&src=http%3A%2F%2Fdesk.fd.zol-img.com.cn%2Ft_s960x600c5%2Fg5%2FM00%2F02%2F06%2FChMkJlbKyqmIdwcpADYDEqqTunIAALIfAMOtQkANgMq921.jpg");
    }

    @Override
    protected int initLayout() {
        return R.layout.my_layout;
    }

    @Override
    protected void initData() {

    }
}
