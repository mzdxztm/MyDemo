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

public class Img1L2SSquareView extends LinearLayout {

    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;

    private int screenHeight;
    private int screenWidth;
    private LinearLayout linearLayout;


    public Img1L2SSquareView(Context context) {
        this(context, null);
    }

    public Img1L2SSquareView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Img1L2SSquareView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        iv1 = getImageView1();
        iv2 = getImageView23();
        iv3 = getImageView23();
        addView(iv1);
        linearLayout = init23ImgLayout();
        linearLayout.addView(iv2);
        linearLayout.addView(iv3);
        addView(linearLayout);
        setImgMargin(10, 10);
    }

    private LinearLayout init23ImgLayout() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        LayoutParams params = new LayoutParams(0, screenWidth / 3 * 2);
        params.weight = 1;
        linearLayout.setLayoutParams(params);
        linearLayout.setOrientation(VERTICAL);
        return linearLayout;
    }

    private ImageView getImageView1() {
        ImageView iv = new ImageView(getContext());
        LayoutParams params = new LayoutParams(0, screenWidth / 3 * 2);
        params.weight = 2;
        iv.setLayoutParams(params);
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return iv;
    }

    private ImageView getImageView23() {
        ImageView iv = new ImageView(getContext());
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, 0);
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

    public void setImgMargin(int innerMargin, int outerMargin) {
        LayoutParams layoutParams1 = (LayoutParams) iv1.getLayoutParams();
        LayoutParams layoutParams2 = (LayoutParams) iv2.getLayoutParams();
        LayoutParams layoutParams3 = (LayoutParams) iv3.getLayoutParams();
        layoutParams1.setMargins(outerMargin, 0, 0, 0);
        layoutParams2.setMargins(innerMargin, 0, outerMargin, innerMargin);
        layoutParams3.setMargins(innerMargin, 0, outerMargin, 0);
    }


}
