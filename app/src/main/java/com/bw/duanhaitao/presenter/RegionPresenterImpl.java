package com.bw.duanhaitao.presenter;
/*
 *@auther:段海涛
 *@Date: 2020-04-03
 *@Time:9:50
 *@Description:${DESCRIPTION}
 **/

import com.bw.duanhaitao.base.BasePresenter;
import com.bw.duanhaitao.contract.RegionContract;
import com.bw.duanhaitao.model.RegionModelImpl;

public class RegionPresenterImpl extends BasePresenter<RegionContract.View>implements RegionContract.Presenter {

    private RegionModelImpl model;

    @Override
    protected void initModel() {
        model = new RegionModelImpl();
    }

    @Override
    public void left() {
        model.left(new RegionContract.Model.LeftCallBack() {
            @Override
            public void leftSuccess(Object obj) {
                getView().leftSuccess(obj);
            }

            @Override
            public void leftFilter(String msg) {
                getView().leftFilter(msg);
            }
        });
    }

    @Override
    public void right(int regionId) {
        model.right(regionId, new RegionContract.Model.RightCallBack() {
            @Override
            public void rightSuccess(Object obj) {
                getView().rightSuccess(obj);
            }

            @Override
            public void rightFilter(String msg) {
                getView().rightFilter(msg);
            }
        });
    }
}
