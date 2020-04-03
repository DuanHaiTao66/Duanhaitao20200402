package com.bw.duanhaitao;
/*
 *@auther:段海涛
 *@Date: 2020-04-03
 *@Time:11:33
 *@Description:${DESCRIPTION}
 **/

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
