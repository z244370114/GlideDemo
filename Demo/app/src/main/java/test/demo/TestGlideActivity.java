package test.demo;

import android.animation.ObjectAnimator;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.animation.ViewPropertyAnimation;
import com.bumptech.glide.request.target.NotificationTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;

import java.io.File;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropSquareTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;
import jp.wasabeef.glide.transformations.gpu.BrightnessFilterTransformation;


/**
 * <p/>
 * 作者：zhouyuan on  2016/12/21 09:45
 * <p/>
 * 邮箱：244370114@qq.com
 * <p/>
 */

public class TestGlideActivity extends AppCompatActivity {

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
    private int NOTIFICATION_ID = 1;
    private NotificationTarget notificationTarget;

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
        tv_title1.setText("加载网络地址资源");
        Glide.with(this)
                .load("http://pic6.huitu.com/res/20130116/84481_20130116142820494200_1.jpg")
                .animate(R.anim.zoom)
                .placeholder(R.drawable.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                .priority(Priority.LOW)
//                .override(500, 500)
//                .fitCenter()
//                .centerCrop()
                .into(iv_1);
        tv_title2.setText("加载gif资源");
        Glide.with(this)
                .load("http://2f.zol-img.com.cn/product/104_1200x900/305/cevDJaCdeLQ6.gif")
                .override(800, 300)
//                .skipMemoryCache(true) //跳过内存缓存
//                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .priority(Priority.HIGH)
                .placeholder(R.drawable.ic_pb_default)
                .error(R.mipmap.ic_launcher_round)
                .into(iv_2);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.ic_launcher);
        tv_title3.setText("从 Uri 中加载");
        Glide.with(this)
                .load(uri)
                .placeholder(R.drawable.ic_pb_default)
                .error(R.mipmap.ic_launcher_round)
                .dontAnimate() //加载没有任何动画
                .into(iv_3);
        //这个文件可能不存在于你的设备中。然而你可以用任何文件路径，去指定一个图片路径。
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "S61215-011806.jpg");
        tv_title4.setText("从文件中加载");
        Glide.with(this)
                .load(file)
                .override(500, 300)
                .placeholder(R.drawable.ic_pb_default)
                .error(R.mipmap.ic_launcher_round)
//                .centerCrop()
                .crossFade()//加载淡入淡出动画，属于默认我猛可以在crossFade(int )里面设置加载时间
                .into(iv_4);
        tv_title5.setText("GIF检测，把常规图给设置成GIF图");
        Glide.with(this)
                .load("http://2f.zol-img.com.cn/product/104_1200x900/305/cevDJaCdeLQ6.gif")
                .asGif() //必须放在load后面
                .placeholder(R.drawable.ic_pb_default)
                .error(R.mipmap.ic_launcher_round)
                .into(iv_5);
        tv_title6.setText("把GIF图的第一帧当常规图使用");
        Glide.with(this)
                .load("http://2f.zol-img.com.cn/product/104_1200x900/305/cevDJaCdeLQ6.gif")
                .asBitmap() //必须放在load后面
                .placeholder(R.drawable.ic_pb_default)
                .error(R.mipmap.ic_launcher_round)
                .into(iv_6);
        tv_title7.setText("加载本地视频");
        Glide.with(this)
                .load(Uri.fromFile(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "V61221-145100.mp4")))
                .asBitmap()
                .transform(new CropSquareTransformation(this))
                .placeholder(R.drawable.ic_pb_default)
                .error(R.mipmap.ic_launcher_round)
                .into(iv_7);
        tv_title8.setText("自定义加载缩略图");
        DrawableRequestBuilder<Integer> thumbail = Glide.with(this)
                .load(R.drawable.ic_pb_default);
        Glide.with(this)
                .load("http://pic6.huitu.com/res/20130116/84481_20130116142820494200_1.jpg")
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .thumbnail(thumbail)
                .into(iv_8);
        tv_title9.setText("Glide 中的回调：SimpleTarget");
        SimpleTarget simpleTarget = new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                iv_9.setImageBitmap(resource);
            }
        };
        Glide.with(this)
                .load("http://pic6.huitu.com/res/20130116/84481_20130116142820494200_1.jpg")
                .asBitmap()
                .transform(new BrightnessFilterTransformation(this, 20))
                .into(simpleTarget);

        tv_title10.setText("Glide 中的回调：ViewTargets自定义视图");
        FutureStudioView studioView = (FutureStudioView) findViewById(R.id.custom_view);
        ViewTarget viewTarget = new ViewTarget<FutureStudioView, GlideDrawable>(studioView) {

            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                this.view.setImage(resource.getCurrent());
                this.view.setText(String.valueOf(resource.getCurrent()));
            }
        };
        Glide.with(this)
                .load("http://pic6.huitu.com/res/20130116/84481_20130116142820494200_1.jpg")
                .bitmapTransform(new GrayscaleTransformation(this))
                .into(viewTarget);

        final RemoteViews rv = new RemoteViews(getPackageName(), R.layout.item_notification);
        rv.setImageViewResource(R.id.remoteview_notification_icon, R.mipmap.ic_launcher);

        rv.setTextViewText(R.id.remoteview_notification_headline, "Headline title");
        rv.setTextViewText(R.id.remoteview_notification_short_message, "Short Message");
        // build notification
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Content Title")
                        .setContentText("Content Text")
                        .setContent(rv)
                        .setPriority(NotificationCompat.PRIORITY_MIN);

        final Notification notification = mBuilder.build();

// set big content view for newer androids
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            notification.bigContentView = rv;
        }
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(NOTIFICATION_ID, notification);
        notificationTarget = new NotificationTarget(
                this,
                rv,
                R.id.remoteview_notification_icon,
                notification,
                NOTIFICATION_ID);
        Glide.with(getApplicationContext()) // safer!
                .load("http://pic6.huitu.com/res/20130116/84481_20130116142820494200_1.jpg")
                .asBitmap()
                .into(notificationTarget);
        FSAppWidgetProvider fsAppWidgetProvider = new FSAppWidgetProvider();
        fsAppWidgetProvider.pushWidgetUpdate(this, rv);

        tv_title11.setText("查看常规异常日志记录");
        RequestListener requestListener = new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                Toast.makeText(TestGlideActivity.this, "onException : " + e.toString(), Toast.LENGTH_SHORT).show();
                System.out.println("TestGlideActivity.onException : " + e.toString());
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                Toast.makeText(TestGlideActivity.this, "onResourceReady", Toast.LENGTH_SHORT).show();
                iv_10.setImageDrawable(resource.getCurrent());
                return false;
            }
        };
        Glide.with(getApplicationContext())
                .load("http://www.sinaimg.cn/dy/slidenews/4_img/2016_51/704_2095729_594750.jpg")
                .animate(animationObject)
//                .listener(requestListener)
                .bitmapTransform(new BlurTransformation(this, 10))
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .error(R.mipmap.ic_launcher_round)
                .into(iv_11);

        tv_title12.setText("自定义Glide的图像像素尺寸");
//        String baseImageUrl = "http://u-jia.deyi.com/2016/12/21/471709051959e3c46fb118dcbab77079c0b56c6b_945x647.jpg";
        String baseImageUrl = "http://u-jia.deyi.com/2016/12/21/1e06021b5d6c86fcb69a8041eec000e5aa280f48_640x426.jpg";
        CustomImageSizeModel modelFutureStudio =
                new CustomImageSizeModelFutureStudio(baseImageUrl);
        Glide.with(getApplicationContext())
                .using(new CustomImageSizeUrlLoader(getApplicationContext()))
                .load(modelFutureStudio)
                .into(iv_12);
    }

    ViewPropertyAnimation.Animator animationObject = new ViewPropertyAnimation.Animator() {
        @Override
        public void animate(View view) {
            view.setAlpha(0f);
            ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f);
            fadeAnim.setDuration(2500);
            fadeAnim.start();
        }
    };
}
