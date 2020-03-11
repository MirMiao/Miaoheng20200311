package com.bw.miaoheng20200311.util;


import com.bw.miaoheng20200311.api.Api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 时间 :2020/3/11  16:22
 * 作者 :苗恒
 * 功能 :   网络工具类
 */
public class RetfoitUtil {
    private static RetfoitUtil retfoitUtil;

    private final Retrofit retrofit;

    private RetfoitUtil() {
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Api.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
    public static RetfoitUtil getInstance() {
         if(retfoitUtil==null){
             synchronized (RetfoitUtil.class){
                 if(retfoitUtil==null){
                     retfoitUtil=new RetfoitUtil();
                 }
             }
         }
        return retfoitUtil;
    }
    public <T>T creatService(Class<T> tClass){
        return  retrofit.create(tClass);
    }
}
