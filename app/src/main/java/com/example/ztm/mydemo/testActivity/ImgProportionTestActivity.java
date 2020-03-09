package com.example.ztm.mydemo.testActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.ztm.mydemo.R;
import com.example.ztm.mydemo.view.Img1L2SSquareView;
import com.example.ztm.mydemo.view.Img1L2SView;
import com.example.ztm.mydemo.view.Img1L3SSquareView;
import com.example.ztm.mydemo.view.Img1SquareView;
import com.example.ztm.mydemo.view.Img2SquareView;
import com.example.ztm.mydemo.view.Img3SquareView;
import com.example.ztm.mydemo.view.Img4SquareView;

public class ImgProportionTestActivity extends AppCompatActivity {

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
    private Img3SquareView img3Test;
    private Img2SquareView img2Test;
    private Img1SquareView img1Test;
    private Img1L2SSquareView imglL2sTest;
    private Img1L2SView imglL2s2Test;
    private Img1L3SSquareView imglL3sTest;
    private Img4SquareView img4Test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_img_proportion_test);
        initView();
        img3Test.setImage(urls[0], urls[3], urls[4]);
        img3Test.setImgMargin(10);
        img2Test.setImage(urls[3], urls[4]);
        img2Test.setImgMargin(10);
        img1Test.setImgMargin(10);
        Glide.with(this).asBitmap().load(urls[3]).into(img1Test);
        imglL2sTest.setImage(urls[0], urls[3], urls[4]);
        imglL2s2Test.setImage(urls[0], urls[8], urls[8]);
        imglL3sTest.setImage(urls[0], urls[3], urls[4], urls[8]);
        img4Test.setImage(urls[0], urls[3], urls[4], urls[5]);
    }

    private void initView() {
        img3Test = (Img3SquareView) findViewById(R.id.img3_test);
        img2Test = (Img2SquareView) findViewById(R.id.img2_test);
        img1Test = (Img1SquareView) findViewById(R.id.img1_test);
        imglL2sTest = (Img1L2SSquareView) findViewById(R.id.imglL2s_test);
        imglL2s2Test = (Img1L2SView) findViewById(R.id.imglL2s2_test);
        imglL3sTest = (Img1L3SSquareView) findViewById(R.id.imglL3s_test);
        img4Test = (Img4SquareView) findViewById(R.id.img4_test);
    }
}
