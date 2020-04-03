package com.bw.duanhaitao.presenter;
/*
 *@auther:段海涛
 *@Date: 2020-04-02
 *@Time:20:38
 *@Description:${DESCRIPTION}
 **/

import com.bw.duanhaitao.base.BasePresenter;
import com.bw.duanhaitao.contract.RecomContract;
import com.bw.duanhaitao.model.RecomModelImpl;

public class RecomPresenterImpl extends BasePresenter<RecomContract.View>implements RecomContract.Presenter {

    private RecomModelImpl model;

    @Override
    protected void initModel() {
        model = new RecomModelImpl();
    }

    @Override
    public void recom(int userId, String sessionId, int page, int count) {
        model.recom(userId, sessionId, page, count, new RecomContract.Model.DataCallBack() {
            @Override
            public void success(Object obj) {
                getView().success(obj);
            }

            @Override
            public void filter(String msg) {
                getView().filter(msg);
            }
        });
    }
}
