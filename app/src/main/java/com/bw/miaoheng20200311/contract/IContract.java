package com.bw.miaoheng20200311.contract;

import com.bw.miaoheng20200311.base.IBaseModel;
import com.bw.miaoheng20200311.base.IBaseView;
import com.bw.miaoheng20200311.entity.DataEntity;

import java.lang.reflect.Field;

/**
 * 时间 :2020/3/11  16:48
 * 作者 :苗恒
 * 功能 :
 */
public interface IContract {
    interface IModel extends IBaseModel{
         void getData(String userId,String sessionId,int status,int page,int count,ModelCallBack modelCallBack);
         interface ModelCallBack{
             void seccess(DataEntity dataEntity);
             void failur(Throwable throwable);
         }
    }
    interface IPresenter{
        void getData(String userId,String sessionId,int status,int page,int count);
    }
    interface IView extends IBaseView{
        void seccess(DataEntity dataEntity);
        void failur(Throwable throwable);
    }
}
