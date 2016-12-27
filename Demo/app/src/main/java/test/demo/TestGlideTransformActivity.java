package test.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.ColorFilterTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.CropSquareTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;
import jp.wasabeef.glide.transformations.MaskTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import jp.wasabeef.glide.transformations.gpu.BrightnessFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.KuwaharaFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SwirlFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.VignetteFilterTransformation;

/**
 * <p/>
 * 作者：zhouyuan on  2016/12/27 14:36
 * <p/>
 * 邮箱：244370114@qq.com
 * <p/>
 */

public class TestGlideTransformActivity extends AppCompatActivity {
    private TextView tv_title1;
    private ImageView iv_1;
    private TextView tv_title2;
    private ImageView iv_2;
    private TextView tv_title3;
    private ImageView iv_3;
    private TextView tv_title4;
    private ImageView iv_4;
    private TextView tv_title5;
    private ImageView iv_5;
    private TextView tv_title6;
    private ImageView iv_6;
    private TextView tv_title7;
    private ImageView iv_7;
    private TextView tv_title8;
    private ImageView iv_8;
    private TextView tv_title9;
    private ImageView iv_9;
    private TextView tv_title10;
    private ImageView iv_10;
    private TextView tv_title11;
    private ImageView iv_11;
    private TextView tv_title12;
    private ImageView iv_12;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_glide);
        tv_title1 = (TextView) findViewById(R.id.tv_title1);
        iv_1 = (ImageView) findViewById(R.id.iv_1);
        tv_title2 = (TextView) findViewById(R.id.tv_title2);
        iv_2 = (ImageView) findViewById(R.id.iv_2);
        tv_title3 = (TextView) findViewById(R.id.tv_title3);
        iv_3 = (ImageView) findViewById(R.id.iv_3);
        tv_title4 = (TextView) findViewById(R.id.tv_title4);
        iv_4 = (ImageView) findViewById(R.id.iv_4);
        tv_title5 = (TextView) findViewById(R.id.tv_title5);
        iv_5 = (ImageView) findViewById(R.id.iv_5);
        tv_title6 = (TextView) findViewById(R.id.tv_title6);
        iv_6 = (ImageView) findViewById(R.id.iv_6);
        tv_title7 = (TextView) findViewById(R.id.tv_title7);
        iv_7 = (ImageView) findViewById(R.id.iv_7);
        tv_title8 = (TextView) findViewById(R.id.tv_title8);
        iv_8 = (ImageView) findViewById(R.id.iv_8);
        tv_title9 = (TextView) findViewById(R.id.tv_title9);
        iv_9 = (ImageView) findViewById(R.id.iv_9);
        tv_title10 = (TextView) findViewById(R.id.tv_title10);
        iv_10 = (ImageView) findViewById(R.id.iv_10);
        tv_title11 = (TextView) findViewById(R.id.tv_title11);
        iv_11 = (ImageView) findViewById(R.id.iv_11);
        tv_title12 = (TextView) findViewById(R.id.tv_title12);
        iv_12 = (ImageView) findViewById(R.id.iv_12);
        initData();
    }

    private void initData() {
//        String glideUrl = "http://mimg.xmeise.com/thumb/m/allimg/161226/1-161226143005.jpg";
        String glideUrl = "http://u-jia.deyi.com/2016/12/21/1e06021b5d6c86fcb69a8041eec000e5aa280f48_640x426.jpg";
        CustomImageSizeModel modelFutureStudio =
                new CustomImageSizeModelFutureStudio(glideUrl);
        tv_title1.setText("高斯模糊");
        Glide.with(TestGlideTransformActivity.this)
                .load(modelFutureStudio)
                .asBitmap()
                .transform(new BlurTransformation(this, 10))
                .into(iv_1);
        tv_title2.setText("麦田怪圈的转换");
        Glide.with(TestGlideTransformActivity.this)
                .load(modelFutureStudio)
                .bitmapTransform(new CropCircleTransformation(this))
                .into(iv_2);
        tv_title3.setText("作物平方变换");
        Glide.with(TestGlideTransformActivity.this)
                .load(modelFutureStudio)
                .bitmapTransform(new CropSquareTransformation(this))
                .into(iv_3);
        tv_title4.setText("灰度变换");
        Glide.with(TestGlideTransformActivity.this)
                .load(modelFutureStudio)
                .bitmapTransform(new GrayscaleTransformation(this))
                .into(iv_4);
        tv_title5.setText("Kuwahara滤波器变换");
        Glide.with(TestGlideTransformActivity.this)
                .load(modelFutureStudio)
                .asBitmap()
                .transform(new KuwaharaFilterTransformation(this, 20))
                .into(iv_5);
        tv_title6.setText("掩码转换");
        Glide.with(TestGlideTransformActivity.this)
                .load(modelFutureStudio)
                .bitmapTransform(new MaskTransformation(this, R.drawable.ic_pb_default))
                .into(iv_6);
        tv_title7.setText("圆角的转换");
        Glide.with(TestGlideTransformActivity.this)
                .load(modelFutureStudio)
                .bitmapTransform(new RoundedCornersTransformation(this, 20, 10))
                .into(iv_7);
        tv_title8.setText("滤色器转换");
        Glide.with(TestGlideTransformActivity.this)
                .load(modelFutureStudio)
                .bitmapTransform(new ColorFilterTransformation(this, R.color.colorPrimaryDark),
                        new RoundedCornersTransformation(this, 20, 20))
                .into(iv_8);
        tv_title9.setText("亮度滤波器变换");
        Glide.with(TestGlideTransformActivity.this)
                .load(modelFutureStudio)
                .bitmapTransform(new BrightnessFilterTransformation(this, 10f))
                .into(iv_9);
        tv_title10.setText("加工标记滤波器");
        Glide.with(TestGlideTransformActivity.this)
                .load(modelFutureStudio)
                .bitmapTransform(new VignetteFilterTransformation(this))
                .into(iv_10);
        tv_title11.setText("漩涡滤波器变换");
        Glide.with(TestGlideTransformActivity.this)
                .load(modelFutureStudio)
                .bitmapTransform(new SwirlFilterTransformation(this))
                .into(iv_11);
    }


}
