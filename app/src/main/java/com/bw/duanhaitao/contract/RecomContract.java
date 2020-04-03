package com.bw.duanhaitao.contract;
/*
 *@auther:段海涛
 *@Date: 2020-04-02
 *@Time:20:35
 *@Description:${DESCRIPTION}
 **/

public interface RecomContract {
    interface View extends IBaseView{
        void success(Object obj);
        void filter(String msg);
    }
    interface Model{
        void recom(int userId,String sessionId,int page,int count,DataCallBack callBack);
        interface DataCallBack{
            void success(Object obj);
            void filter(String msg);
        }
    }
    interface Presenter{
        void recom(int userId,String sessionId,int page,int count);
    }
}
