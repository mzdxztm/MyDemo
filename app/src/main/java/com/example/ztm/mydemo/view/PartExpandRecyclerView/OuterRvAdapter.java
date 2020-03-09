package com.example.ztm.mydemo.view.PartExpandRecyclerView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ztm.mydemo.R;

import java.util.ArrayList;
import java.util.List;

public class OuterRvAdapter extends RecyclerView.Adapter<OuterRvAdapter.MyViewHolder> {

    private Context context;
    private int count;

    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();

    private List<InnerRvAdapter> adapters;

    public OuterRvAdapter(Context context, int count) {
        this.count = count;
        this.context = context;
        List<String> str = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            str.add("劳力士");
        }
        adapters = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            InnerRvAdapter innerRvAdapter = new InnerRvAdapter(str, 6);
            adapters.add(innerRvAdapter);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customview_partexpandrvview, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int position) {
//            myViewHolder.rvitemList.setLayoutManager(new StaggeredGridLayoutManager(7, StaggeredGridLayoutManager.VERTICAL));
//        myViewHolder.rvitemList.addItemDecoration(new SpaceItemDecoration(8));
        InnerRvAdapter adapter = (InnerRvAdapter) myViewHolder.rvitemList.getAdapter();
        if (adapter == null) {
            adapter = adapters.get(position);
            myViewHolder.rvitemList.setAdapter(adapter);
        }
        adapter.notifyDataSetChanged();

        final InnerRvAdapter finalAdapter = adapter;
        myViewHolder.tvhint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalAdapter.switchState();
            }
        });

    }

    @Override
    public int getItemCount() {
        return count;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvhint;
        public RecyclerView rvitemList;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            rvitemList = (RecyclerView) itemView.findViewById(R.id.rv_itemList);
            tvhint = (TextView) itemView.findViewById(R.id.tv_hint);
            rvitemList.setRecycledViewPool(viewPool);
            rvitemList.addItemDecoration(new SpaceItemDecoration(5));

            rvitemList.setLayoutManager(new GridLayoutManager(context, 3));
        }
    }


}