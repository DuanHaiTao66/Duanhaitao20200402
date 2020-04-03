package com.bw.duanhaitao.model;
/*
 *@auther:段海涛
 *@Date: 2020-04-02
 *@Time:20:38
 *@Description:${DESCRIPTION}
 **/

import com.bw.duanhaitao.api.ApiService;
import com.bw.duanhaitao.bean.RecomBean;
import com.bw.duanhaitao.contract.RecomContract;
import com.bw.duanhaitao.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class RecomModelImpl implements RecomContract.Model {
    @Override
    public void recom(int userId, String sessionId, int page, int count, DataCallBack callBack) {
        Retrofit retrofit = RetrofitUtil.getInstance().getRetrofit();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<RecomBean> observable = apiService.getRecom(userId, sessionId, page, count);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RecomBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RecomBean recomBean) {
                        callBack.success(recomBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.filter(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
