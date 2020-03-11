package com.bw.miaoheng20200311.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.miaoheng20200311.R;
import com.bw.miaoheng20200311.entity.DataEntity;

import java.util.List;

/**
 * 时间 :2020/3/11  17:12
 * 作者 :苗恒
 * 功能 :
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {
    Context context;
    List<DataEntity.OrderListBean> orderList;
    public DataAdapter(Context context, List<DataEntity.OrderListBean> orderList) {
        this.context=context;
        this.orderList=orderList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String commodityPic = orderList.get(position).getDetailList().get(0).getCommodityPic();
        String[] split = commodityPic.split(",");
        Glide.with(context).load(split[0]).into(holder.imageView);
        holder.tv_name.setText(orderList.get(position).getDetailList().get(0).getCommodityName());
        holder.tv_price.setText("￥"+orderList.get(position).getDetailList().get(0).getCommodityPrice());
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView imageView;
        private final TextView tv_name;
        private final TextView tv_price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_price = itemView.findViewById(R.id.tv_price);
        }
    }
}
