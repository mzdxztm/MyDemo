package com.example.ztm.mydemo.view;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;

public class Img1SquareView extends android.support.v7.widget.AppCompatImageView {

    private int screenHeight;
    private int screenWidth;


    public Img1SquareView(Context context) {
        this(context, null);
    }

    public Img1SquareView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Img1SquareView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initSreenSize();
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

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(screenWidth, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void setImgMargin(int margin) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = screenWidth - 2 * margin;
        setLayoutParams(layoutParams);
    }
}
