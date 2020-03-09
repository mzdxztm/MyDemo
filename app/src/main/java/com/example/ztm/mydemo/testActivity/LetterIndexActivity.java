package com.example.ztm.mydemo.testActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.ztm.mydemo.R;
import com.example.ztm.mydemo.letterPicter.SideIndexBar;

public class LetterIndexActivity extends AppCompatActivity {

    private SideIndexBar siTest;
    private RecyclerView rvList;
    private TextView tvOverlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letter_index);
        initView();
    }

    private void initView() {
        siTest = (SideIndexBar) findViewById(R.id.si_test);
        rvList = (RecyclerView) findViewById(R.id.rv_list);
        siTest.setOnIndexChangedListener(new SideIndexBar.OnIndexTouchedChangedListener() {
            @Override
            public void onIndexChanged(String index, int position) {

            }
        });
        tvOverlay = (TextView) findViewById(R.id.tv_overlay);
        siTest.setOverlayTextView(tvOverlay);
    }
}
