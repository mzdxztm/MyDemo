package com.example.ztm.mydemo.testActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.ztm.mydemo.R;
import com.example.ztm.mydemo.view.PartExpandRecyclerView.OuterRvAdapter;

public class PartExpandRvListActivity extends AppCompatActivity {


    private RecyclerView rvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_expand_rv_list);
        initView();
    }

    private void initView() {

        rvTest = (RecyclerView) findViewById(R.id.rv_test);
        rvTest.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        });
        rvTest.setAdapter(new OuterRvAdapter(this, 20));
    }
}
