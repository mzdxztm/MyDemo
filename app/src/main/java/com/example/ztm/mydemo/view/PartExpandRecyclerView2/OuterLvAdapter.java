package com.example.ztm.mydemo.view.PartExpandRecyclerView2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;


import com.example.ztm.mydemo.R;

import java.util.ArrayList;
import java.util.List;

public class OuterLvAdapter extends BaseAdapter {

    private List<String> list;

    private Activity activity;

    public OuterLvAdapter(Activity activity, List<String> list) {
        this.list = list;
        this.activity = activity;
    }

    @Override
    public int getCount() {

        return list.size();
    }


    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(activity).inflate(R.layout.customview_partexpandrvview2, null);
            ViewHolder holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        List<String> itemList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            itemList.add("劳力士");
        }
        int numColumns = holder.gvItemList.getNumColumns();
        numColumns = numColumns == 0 ? 3 : numColumns;
        InnerLvAdapter adapter = new InnerLvAdapter(activity, itemList, numColumns);
        holder.gvItemList.setAdapter(adapter);
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView tvHint;
        public GridView gvItemList;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tvHint = (TextView) rootView.findViewById(R.id.tv_hint);
            this.gvItemList = (GridView) rootView.findViewById(R.id.gv_itemList);
        }

    }
}
