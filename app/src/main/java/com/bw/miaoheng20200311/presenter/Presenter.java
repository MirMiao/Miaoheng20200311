package com.bw.miaoheng20200311.presenter;

import com.bw.miaoheng20200311.base.BasePresenter;
import com.bw.miaoheng20200311.contract.IContract;
import com.bw.miaoheng20200311.entity.DataEntity;
import com.bw.miaoheng20200311.model3.Model;

/**
 * 时间 :2020/3/11  16:51
 * 作者 :苗恒
 * 功能 :
 */
public class Presenter extends BasePresenter<Model, IContract.IView> implements IContract.IPresenter {
    @Override
    protected Model initModel() {
        return new Model();
    }

    @Override
    public void getData(String userId, String sessionId, int status, int page, int count) {
            model.getData(userId, sessionId, status, page, count, new IContract.IModel.ModelCallBack() {
                @Override
                public void seccess(DataEntity dataEntity) {
                    getView().seccess(dataEntity);
                }

                @Override
                public void failur(Throwable throwable) {
                        getView().failur(throwable);
                }
            });
    }
}
