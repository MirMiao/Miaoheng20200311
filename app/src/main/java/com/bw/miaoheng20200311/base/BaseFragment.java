package com.bw.miaoheng20200311.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * 时间 :2020/3/11  16:46
 * 作者 :苗恒
 * 功能 :
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IBaseView {
    public P presenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(bindLayoutid(), container, false);
        presenter=initPresenter();
        if (presenter != null) {
            presenter.attach(this);
        }
        initView(inflate);
        initData();
        return inflate;
    }

    protected abstract void initView(View inflate);

    protected abstract P initPresenter();

    protected abstract int bindLayoutid();


    protected abstract void initData();
}
