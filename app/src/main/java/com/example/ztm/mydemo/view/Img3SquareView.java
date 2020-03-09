package com.example.ztm.mydemo.view;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

public class Img3SquareView extends LinearLayout {

    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;

    private int screenHeight;
    private int screenWidth;


    public Img3SquareView(Context context) {
        this(context, null);
    }

    public Img3SquareView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Img3SquareView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initSreenSize();
        initView(context);
    }

    private void initSreenSize() {
        Activity activity = (Activity) (getContext());
        WindowManager windowManager = activity.getWindowManager();
        Display defaultDisplay = windowManager.getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(outMetrics);
        screenHeight = outMetrics.heightPixels;
        screenWidth = outMetrics.widthPixels;
    }

    private void initView(Context context) {
        this.setOrientation(HORIZONTAL);
        iv1 = getImageView();
        iv2 = getImageView();
        iv3 = getImageView();
        addView(iv1);
        addView(iv2);
        addView(iv3);
        setImgMargin(3);
    }

    private ImageView getImageView() {
        ImageView iv = new ImageView(getContext());
        LinearLayout.LayoutParams params = new LayoutParams(0, screenWidth / 3);
        params.weight = 1;
        iv.setLayoutParams(params);
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return iv;
    }

    public void setImage(String url1, String url2, String url3) {
        Glide.with(getContext()).asBitmap().load(url1).into(iv1);
        Glide.with(getContext()).asBitmap().load(url2).into(iv2);
        Glide.with(getContext()).asBitmap().load(url3).into(iv3);
    }


    public void setImgMargin(int margin) {
        LinearLayout.LayoutParams layoutParams1 = (LayoutParams) iv1.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LayoutParams) iv2.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LayoutParams) iv3.getLayoutParams();
        layoutParams1.setMargins(margin, 0, 0, 0);
        layoutParams2.setMargins(margin, 0, margin, 0);
        layoutParams3.setMargins(0, 0, margin, 0);
    }


}
