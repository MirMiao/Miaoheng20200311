package com.bw.miaoheng20200311.model3;

import android.widget.Toast;

import com.bw.miaoheng20200311.api.IGetDataService;
import com.bw.miaoheng20200311.contract.IContract;
import com.bw.miaoheng20200311.entity.DataEntity;
import com.bw.miaoheng20200311.util.RetfoitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 时间 :2020/3/11  16:50
 * 作者 :苗恒
 * 功能 :
 */
public class Model implements IContract.IModel {
    @Override
    public void getData(String userId, String sessionId, int status, int page, int count, final ModelCallBack modelCallBack) {
        //在这请求数据
        RetfoitUtil.getInstance().creatService(IGetDataService.class)
                .getData(userId,sessionId,status,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DataEntity>() {
                    @Override
                    public void accept(DataEntity dataEntity) throws Exception {
                        modelCallBack.seccess(dataEntity);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        modelCallBack.failur(throwable);
                    }
                });
    }
}
