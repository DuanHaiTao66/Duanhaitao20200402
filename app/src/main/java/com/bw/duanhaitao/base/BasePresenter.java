package com.bw.duanhaitao.base;
/*
 *@auther:段海涛
 *@Date: 2020-04-02
 *@Time:19:47
 *@Description:${DESCRIPTION}
 **/

import com.bw.duanhaitao.contract.IBaseView;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends IBaseView> {
    public WeakReference<V>weakReference;
    public BasePresenter() {
        initModel();
    }
    public void attach(V v){
        weakReference = new WeakReference<>(v);
    }
    public void deatch(){
        if (weakReference!=null){
            weakReference.clear();
            weakReference=null;
        }
    }
    protected abstract void initModel();
    public V getView(){
        V v = weakReference.get();
        return v;
    }
}
