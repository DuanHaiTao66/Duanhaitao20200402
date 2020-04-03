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

import com.bw.duanhaitao.R;
import com.bw.duanhaitao.adapter.RecomAdapter;
import com.bw.duanhaitao.base.BaseFragment;
import com.bw.duanhaitao.bean.RecomBean;
import com.bw.duanhaitao.contract.RecomContract;
import com.bw.duanhaitao.presenter.RecomPresenterImpl;

import java.util.List;

import butterknife.BindView;

public class RecomFragment extends BaseFragment<RecomPresenterImpl> implements RecomContract.View {


    public Handler handler = new Handler();
    @BindView(R.id.rv)
    RecyclerView rv;

    @Override
    protected RecomPresenterImpl initPresenter() {
        return new RecomPresenterImpl();
    }


    @SuppressLint("WrongConstant")
    @Override
    protected void initView(View inflate) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected int initLayout() {
        return R.layout.recome_layout;
    }

    @Override
    protected void initData() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                presenter.recom(13828,"158582945095913828",1,10);
            }
        });
    }

    @Override
    public void success(Object obj) {
        if (obj instanceof RecomBean) {
            RecomBean recomBean = (RecomBean) obj;
            List<RecomBean.ResultBean> result = recomBean.getResult();
            RecomAdapter adapter = new RecomAdapter(result,getContext());
            rv.setAdapter(adapter);

        }
    }

    @Override
    public void filter(String msg) {

    }
}
