package com.example.on2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DonutAdapter extends RecyclerView.Adapter<DonutAdapter.DonutViewHolder> {
    private ArrayList<Donut> mDonutList;
    private LayoutInflater mInflater;
    private Context context;


    @Override
    public DonutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.donutcake,parent,false);
        DonutViewHolder dvh= new DonutViewHolder(v);
        return dvh;
    }

    public DonutAdapter(Context context,ArrayList<Donut> donutList){
        mInflater=LayoutInflater.from(context);
        this.mDonutList=donutList;
        this.context=context;
    }

    @Override
    public void onBindViewHolder(@NonNull  DonutAdapter.DonutViewHolder holder, int position) {
        Donut currentDonut= mDonutList.get(position);

        holder.mImageView.setImageResource(currentDonut.getImgHinh());
        holder.tvName.setText(currentDonut.getName());
        holder.tvPrice.setText(currentDonut.getPrice());
    }

    @Override
    public int getItemCount() {
        return mDonutList.size();
    }

    public void filterListH(ArrayList<Donut> filterlist){
        mDonutList=filterlist;
        notifyDataSetChanged();
    }

    public class DonutViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView mImageView;
        public TextView tvName;
        public TextView tvPrice;
        public DonutViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView=itemView.findViewById(R.id.imgDonut);
            tvName=itemView.findViewById(R.id.tvName);
            tvPrice=itemView.findViewById(R.id.tvPrice);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int mPosition= getLayoutPosition();
            Donut donuts= mDonutList.get(mPosition);

            Intent intent= new Intent(context, DonutScreen2.class);
            intent.putExtra("img2",donuts.getImgHinh());
            intent.putExtra("name",donuts.getName());
            intent.putExtra("price",donuts.getPrice());

            context.startActivity(intent);
        }
    }
}
