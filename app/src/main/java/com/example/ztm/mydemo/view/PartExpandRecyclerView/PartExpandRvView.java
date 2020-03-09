package com.example.ztm.mydemo.view.PartExpandRecyclerView;

import android.content.Context;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;


public class PartExpandRvView extends RecyclerView {

    private OuterRvAdapter outerRvAdapter;


    public PartExpandRvView(@NonNull Context context) {
        super(context);
    }

    public PartExpandRvView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PartExpandRvView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void initData() {
      /*  this.setLayoutManager(new LinearLayoutManager(getContext()));
        outerRvAdapter = new OuterRvAdapter(15);
        this.setAdapter(outerRvAdapter);*/
    }




}

