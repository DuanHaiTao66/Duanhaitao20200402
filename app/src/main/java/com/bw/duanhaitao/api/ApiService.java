package com.bw.duanhaitao.api;
/*
 *@auther:段海涛
 *@Date: 2020-04-02
 *@Time:20:21
 *@Description:${DESCRIPTION}
 **/

import com.bw.duanhaitao.bean.LeftBean;
import com.bw.duanhaitao.bean.RecomBean;
import com.bw.duanhaitao.bean.RightBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ApiService {
    @GET(Api.RECOMURL)
    Observable<RecomBean>getRecom(@Header("userId")int userId,
                                  @Header("sessionId")String sessionId,
                                  @Query("page") int page,
                                  @Query("count")int count);
    @GET(Api.LEFTURL)
    Observable<LeftBean>getLeft();

    @GET(Api.RIGHTURL)
    Observable<RightBean>getRight(@Query("regionId") int regionId);
}
