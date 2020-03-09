package com.example.ztm.mydemo.photo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.ztm.mydemo.R;
import com.example.ztm.mydemo.tool.CustomTool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhotoViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private GridView gvImgList;

    private static final String[] urls = {"http://dingyue.nosdn.127.net/pEi2b8XzjDliAJS1qNVXhMibJzbe20xcpUFF5DVtslihr1527417407570.jpg",
            "https://b-ssl.duitang.com/uploads/item/201609/08/20160908155309_f2XtB.jpeg",
            "http://img5.imgtn.bdimg.com/it/u=2946961622,4071466309&fm=26&gp=0.jpg",
            "http://img3.imgtn.bdimg.com/it/u=282627370,858396101&fm=26&gp=0.jpg",
            "http://img0.imgtn.bdimg.com/it/u=2614050347,2859119057&fm=26&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=259694040,3951564017&fm=26&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=2217568150,207080245&fm=26&gp=0.jpg",
            "http://img3.imgtn.bdimg.com/it/u=1605216125,3497140748&fm=26&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=1280120652,2364238058&fm=11&gp=0.jpg",
            "http://img1.imgtn.bdimg.com/it/u=617179800,1788427777&fm=26&gp=0.jpg"};

    private ViewPager vpImg;
    private List<String> urlList;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);
        initView();
        initData();
        setListener();
    }

    private void initData() {

        urlList = Arrays.asList(urls);

        GvImgAdapter adapter = new GvImgAdapter(this, urlList);
        gvImgList.setAdapter(adapter);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.dialog_img, null);

        vpImg = (ViewPager) view.findViewById(R.id.vp_img);
        vpImg.setAdapter(new VpImgAdapter(this, urlList));
    /*    Drawable drawable = getResources().getDrawable(R.drawable.shape_test);
        vpImg.setBackground(drawable);*/

//        alertDialogBuilder.setTitle("").setMessage("");
        alertDialog = alertDialogBuilder.create();
        alertDialog.setView(view);
    }

    private void setListener() {
        gvImgList.setOnItemClickListener(this);
    }

    private void initView() {
        gvImgList = (GridView) findViewById(R.id.gv_imgList);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        refereshVp(i);
        showDialog();
    }

    private void refereshVp(int i) {
        vpImg.setCurrentItem(i);
    }

    private void showDialog() {
        DisplayMetrics metrics = CustomTool.getScreenSize(this);

        Window window = alertDialog.getWindow();
        Drawable drawable = getResources().getDrawable(R.drawable.shape_half_transparency);
        window.setBackgroundDrawable(drawable);
        alertDialog.show();
        window.getDecorView().setBackground(drawable);
        window.setLayout(metrics.widthPixels, metrics.heightPixels / 3);
    }

    private class GvImgAdapter extends BaseAdapter {

        private Activity activity;

        private List<String> list;
        private final LayoutInflater inflater;
        private final DisplayMetrics metrics;

        public GvImgAdapter(Activity activity, List<String> list) {
            if (list == null) new ArrayList<>();
            this.activity = activity;
            this.list = list;
            inflater = LayoutInflater.from(activity);
            metrics = CustomTool.getScreenSize(activity);
        }


        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            if (view == null) {
//                view = inflater.inflate(R.layout.grideview_img_item, null);
                ImageView imageView = new ImageView(activity);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(metrics.widthPixels / 3, metrics.widthPixels / 3);
                imageView.setLayoutParams(layoutParams);
                view = imageView;
            }
            ImageView iv = (ImageView) view;
            Glide.with(activity).load(list.get(i)).into(iv);

            return iv;
        }
    }

    private class VpImgAdapter extends PagerAdapter {

        private static final String TAG = "VpImgAdapter";

        private List<String> urls;

        private Context context;

        public VpImgAdapter(Context context, List<String> urls) {
            super();
            this.urls = urls;
            this.context = context;
           /* iv1 = new PhotoView(context);
            iv2 = new PhotoView(context);
            iv3 = new PhotoView(context);

            iv1.setEnabled(true);
            iv2.setEnabled(true);
            iv3.setEnabled(true);

            imageViews = new ArrayList<>();
            imageViews.add(iv1);
            imageViews.add(iv2);
            imageViews.add(iv3);*/
        }

        @Override
        public int getCount() {
            return urls.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            PhotoView pv = new PhotoView(context);
            pv.enable();
            pv.setBackgroundResource(R.drawable.shape_half_transparency);
            Glide.with(context).load(urls.get(position)).into(pv);
            container.addView(pv);
            Log.i(TAG, "instantiateItem: " + position);
            return pv;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
            Log.i(TAG, "destroyItem: " + position);
        }
    }

}
