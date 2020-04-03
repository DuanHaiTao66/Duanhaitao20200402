package com.bw.duanhaitao;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.bw.duanhaitao.base.BaseActivity;
import com.bw.duanhaitao.base.BasePresenter;
import com.bw.duanhaitao.fragment.MyFragment;
import com.bw.duanhaitao.fragment.RecomFragment;
import com.bw.duanhaitao.fragment.RegionFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tab)
    XTabLayout tab;

    private List<Fragment>fragmentList  = new ArrayList<>();
    private List<String>list = new ArrayList<>();
    @Override
    protected void initData() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        fragmentList.add(new RecomFragment());
        fragmentList.add(new RegionFragment());
        fragmentList.add(new MyFragment());
        list.add("推荐影院");
        list.add("地区");
        list.add("我的");
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }
        });
        vp.setOffscreenPageLimit(2);
        tab.setupWithViewPager(vp);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }


}
