package com.example.ztm.mydemo.tool;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class CustomTool {

    public static final DisplayMetrics getScreenSize(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager windowManager = activity.getWindowManager();
        Display defaultDisplay = windowManager.getDefaultDisplay();
        defaultDisplay.getMetrics(metrics);
        return metrics;
    }
}