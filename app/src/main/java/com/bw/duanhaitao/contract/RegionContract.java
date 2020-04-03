package com.bw.duanhaitao.contract;
/*
 *@auther:段海涛
 *@Date: 2020-04-03
 *@Time:9:45
 *@Description:${DESCRIPTION}
 **/

public interface RegionContract {
    interface View extends IBaseView{
        void leftSuccess(Object obj);
        void leftFilter(String msg);

        void rightSuccess(Object obj);
        void rightFilter(String msg);
    }
    interface Model{
        void left(LeftCallBack callBack);
        interface LeftCallBack{
            void leftSuccess(Object obj);
            void leftFilter(String msg);
        }
        void right(int regionId,RightCallBack callBack);
        interface RightCallBack{
            void rightSuccess(Object obj);
            void rightFilter(String msg);
        }
    }
    interface Presenter{
        void left();
        void right(int regionId);
    }
}
