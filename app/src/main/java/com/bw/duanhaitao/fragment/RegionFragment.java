package com.bw.duanhaitao.fragment;
/*
 *@auther:段海涛
 *@Date: 2020-04-02
 *@Time:20:27
 *@Description:${DESCRIPTION}
 **/

import android.annotation.SuppressLint;
import android.os.Handler;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.duanhaitao.Event;
import com.bw.duanhaitao.R;
import com.bw.duanhaitao.adapter.LeftAdapter;
import com.bw.duanhaitao.adapter.RightAdapter;
import com.bw.duanhaitao.base.BaseFragment;
import com.bw.duanhaitao.bean.LeftBean;
import com.bw.duanhaitao.bean.RightBean;
import com.bw.duanhaitao.contract.RegionContract;
import com.bw.duanhaitao.presenter.RegionPresenterImpl;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;

public class RegionFragment extends BaseFragment<RegionPresenterImpl> implements RegionContract.View {
    @BindView(R.id.left_rv)
    RecyclerView leftRv;
    @BindView(R.id.right_rv)
    RecyclerView rightRv;


    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected RegionPresenterImpl initPresenter() {
        return new RegionPresenterImpl();
    }
    public Handler handler = new Handler();
    @SuppressLint("WrongConstant")
    @Override
    protected void initView(View inflate) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        leftRv.setLayoutManager(linearLayoutManager);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
        rightRv.setLayoutManager(linearLayoutManager1);
    }

    @Override
    protected int initLayout() {
        return R.layout.region_layout;
    }



    @Subscribe
    public void MainThread(Event event){
        int id = event.id;
        presenter.right(id);
    }

    @Override
    protected void initData() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                presenter.left();
                presenter.right(1);
            }
        });
    }

    @Override
    public void leftSuccess(Object obj) {
        if (obj instanceof LeftBean) {
            LeftBean leftBean = (LeftBean) obj;
            List<LeftBean.ResultBean> result = leftBean.getResult();
            LeftAdapter adapter = new LeftAdapter(result, getContext());
            leftRv.setAdapter(adapter);

        }
    }

    @Override
    public void leftFilter(String msg) {

    }

    @Override
    public void rightSuccess(Object obj) {
        if (obj instanceof RightBean){
            RightBean rightBean = (RightBean) obj;
            List<RightBean.ResultBean> result = rightBean.getResult();
            RightAdapter adapter = new RightAdapter(result,getContext());
            rightRv.setAdapter(adapter);
        }
    }

    @Override
    public void rightFilter(String msg) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
