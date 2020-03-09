package com.example.ztm.mydemo.view.PartExpandRecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.ztm.mydemo.R;

import java.util.List;

public class InnerRvAdapter extends RecyclerView.Adapter<InnerRvAdapter.MyViewHolder> {

    private List<String> list;

    private int minItemCount;

    private boolean isExpand;

    public InnerRvAdapter(List<String> list, int minItemCount) {
        this.list = list;
        isExpand = false;
        this.minItemCount = minItemCount;
    }

    public void switchState() {
        isExpand = !isExpand;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_inner_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        myViewHolder.tv.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        if (!isExpand) {
            if (list.size() > minItemCount) return minItemCount;
            else return list.size();
        } else {
            return list.size();
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv_btn);
        }
    }
}