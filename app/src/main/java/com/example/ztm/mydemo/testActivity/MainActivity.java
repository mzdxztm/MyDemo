package com.example.ztm.mydemo.testActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.ztm.mydemo.DataBindingTestActivity;
import com.example.ztm.mydemo.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btnReferesh;
    private Button btnImgCheck;
    private Button btnLetterIndex;
    private Button btnRecyclerview;
    private Button btnDatabinding;
    private Button btnTwowayview;
    private Button btnImgProportion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        btnReferesh = (Button) findViewById(R.id.btn_referesh);
        btnReferesh.setOnClickListener(this);
        btnImgCheck = (Button) findViewById(R.id.btn_imgCheck);
        btnImgCheck.setOnClickListener(this);
        btnLetterIndex = (Button) findViewById(R.id.btn_letterIndex);
        btnLetterIndex.setOnClickListener(this);
        btnRecyclerview = (Button) findViewById(R.id.btn_recyclerview);
        btnRecyclerview.setOnClickListener(this);
        btnDatabinding = (Button) findViewById(R.id.btn_databinding);
        btnDatabinding.setOnClickListener(this);
        btnTwowayview = (Button) findViewById(R.id.btn_twowayview);
        btnTwowayview.setOnClickListener(this);
        btnImgProportion = (Button) findViewById(R.id.btn_imgProportion);
        btnImgProportion.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_referesh:
                startActivity(new Intent(this, RefereshTestActivity.class));
                break;
            case R.id.btn_imgCheck:
                startActivity(new Intent(this, PhotoCheckTestActivity.class));
                break;
            case R.id.btn_letterIndex:
                startActivity(new Intent(this, LetterIndexActivity.class));
                break;
            case R.id.btn_recyclerview:
                startActivity(new Intent(this, PartExpandRvListActivity.class));
                break;
            case R.id.btn_databinding:
                startActivity(new Intent(this, DataBindingTestActivity.class));
                break;
            case R.id.btn_twowayview:
                startActivity(new Intent(this, TwowayViewActivity.class));
                break;
            case R.id.btn_imgProportion:
                startActivity(new Intent(this, ImgProportionTestActivity.class));
                break;
        }
    }

}
