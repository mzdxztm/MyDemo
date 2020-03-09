package com.example.ztm.mydemo.view.PartExpandRecyclerView2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.ztm.mydemo.R;

import java.util.List;

public class InnerLvAdapter extends BaseAdapter {

    private List<String> list;

    private int minItemCount;

    private boolean isExpand;
    private Activity activity;

    public InnerLvAdapter(Activity activity, List<String> list, int minItemCount) {
        this.list = list;
        this.activity = activity;
        this.minItemCount = minItemCount;
        isExpand = false;
    }

    @Override
    public int getCount() {
        if (!isExpand) {
            if (list.size() > minItemCount) return minItemCount;
            else return list.size();
        } else {
            return list.size();
        }
    }


    public void switchState() {
        isExpand = !isExpand;
        this.notifyDataSetChanged();
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
            convertView = LayoutInflater.from(activity).inflate(R.layout.recyclerview_inner_item, null);
            ViewHolder holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        return convertView;
    }

    public class ViewHolder {
        public View rootView;
        public TextView tvBtn;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tvBtn = (TextView) rootView.findViewById(R.id.tv_btn);
        }

    }
}
