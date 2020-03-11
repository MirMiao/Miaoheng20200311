package com.bw.miaoheng20200311.view.fragment;

import android.os.Bundle;
import android.view.View;

import android.widget.Toast;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.miaoheng20200311.R;
import com.bw.miaoheng20200311.adapter.DataAdapter;
import com.bw.miaoheng20200311.base.BaseFragment;
import com.bw.miaoheng20200311.contract.IContract;
import com.bw.miaoheng20200311.entity.DataEntity;
import com.bw.miaoheng20200311.presenter.Presenter;

import java.util.List;


/**
 * 时间 :2020/3/11  16:29
 * 作者 :苗恒
 * 功能 :
 */
public class HomeFragment extends BaseFragment<Presenter> implements IContract.IView {


    private RecyclerView recyclerView;

    @Override
    protected void initView(View inflate) {
        recyclerView = inflate.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected Presenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected int bindLayoutid() {
        return R.layout.homefragment;
    }

    @Override
    protected void initData() {
        int status = getArguments().getInt("status");
       presenter.getData("28309","158391500903528309",status,1,5);
    }

    @Override
    public void seccess(DataEntity dataEntity) {
        Toast.makeText(getContext() , ""+dataEntity.getMessage(), Toast.LENGTH_SHORT).show();
        //设置适配器
        List<DataEntity.OrderListBean> orderList = dataEntity.getOrderList();
        DataAdapter dataAdapter = new DataAdapter(getContext(), orderList);
        recyclerView.setAdapter(dataAdapter);

    }

    @Override
    public void failur(Throwable throwable) {

    }
    //动态传值
    public static HomeFragment getInstance(int status) {
        HomeFragment homeFragment = new HomeFragment();
        Bundle bundle=new Bundle();
        bundle.putInt("status",status);
        homeFragment.setArguments(bundle);
        return homeFragment;
    }

}
