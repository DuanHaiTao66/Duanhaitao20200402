package com.bw.duanhaitao.adapter;
/*
 *@auther:段海涛
 *@Date: 2020-04-02
 *@Time:20:41
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.duanhaitao.R;
import com.bw.duanhaitao.bean.RecomBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecomAdapter extends RecyclerView.Adapter<RecomAdapter.RecomViewHolder> {
    public int  OnClickItem = 0;
    private List<RecomBean.ResultBean> list;
    private Context context;

    public RecomAdapter(List<RecomBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recom_layout, parent, false);
        return new RecomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecomViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getLogo()).into(holder.recomImage);
        holder.recomName.setText(list.get(position).getName());
        holder.recomArdess.setText(list.get(position).getAddress());
        if(position==OnClickItem){
            holder.itemView.setBackgroundColor(Color.GREEN);
        }else{
            holder.itemView.setBackgroundColor(Color.WHITE);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnClickItem = position;
                notifyDataSetChanged();
            }

        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RecomViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.recom_Image)
        ImageView recomImage;
        @BindView(R.id.recom_Name)
        TextView recomName;
        @BindView(R.id.recom_Ardess)
        TextView recomArdess;
        public RecomViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
