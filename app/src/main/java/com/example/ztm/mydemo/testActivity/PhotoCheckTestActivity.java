package com.example.ztm.mydemo.testActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.ztm.mydemo.R;
import com.example.ztm.mydemo.photo.PhotoViewActivity;
import com.example.ztm.mydemo.tool.CustomTool;

public class PhotoCheckTestActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_CHOOSE = 325233;
    private String testUrl = "https://b-ssl.duitang.com/uploads/item/201609/08/20160908155309_f2XtB.jpeg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_check_test);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void checkImg(View view) {
        startActivity(new Intent(this, PhotoViewActivity.class));
    }

    public void dialog(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        AlertDialog alertDialog = alertDialogBuilder.create();

        ImageView iv = new ImageView(this);
        Glide.with(this).load(testUrl).into(iv);

        DisplayMetrics metrics = CustomTool.getScreenSize(this);
        alertDialog.setView(iv);
        Window window = alertDialog.getWindow();
        Drawable drawable = getResources().getDrawable(R.drawable.shape_half_transparency);
        window.setBackgroundDrawable(drawable);

        alertDialog.show();
        window.getDecorView().setBackground(drawable);
        window.setLayout(metrics.widthPixels, metrics.heightPixels / 3);
    }


}
