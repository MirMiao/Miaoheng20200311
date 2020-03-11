package com.bw.miaoheng20200311.api;

import com.bw.miaoheng20200311.entity.DataEntity;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * 时间 :2020/3/11  16:37
 * 作者 :苗恒
 * 功能 :
 */
public interface IGetDataService {
    @GET("small/order/verify/v1/findOrderListByStatus")
    Observable<DataEntity> getData(@Header("userId") String userId, @Header("sessionId")  String sessionId, @Query("status") int status, @Query("page") int page, @Query("count") int cunt);
}
