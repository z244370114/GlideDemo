package test.demo;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.widget.RemoteViews;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.AppWidgetTarget;

/**
 * <p/>
 * 作者：zhouyuan on  2016/12/22 15:02
 * <p/>
 * 邮箱：244370114@qq.com
 * <p/>
 */

public class FSAppWidgetProvider extends AppWidgetProvider {
    private AppWidgetTarget appWidgetTarget;

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {

        RemoteViews rv = new RemoteViews(context.getPackageName(), R.layout.custom_view_futurestudio);

        appWidgetTarget = new AppWidgetTarget(context, rv, R.id.custom_view_image, appWidgetIds);

        Glide
                .with(context.getApplicationContext()) // safer!
                .load("http://pic6.huitu.com/res/20130116/84481_20130116142820494200_1.jpg")
                .asBitmap()
                .into(appWidgetTarget);

        pushWidgetUpdate(context, rv);
    }

    public static void pushWidgetUpdate(Context context, RemoteViews rv) {
        ComponentName myWidget = new ComponentName(context, FSAppWidgetProvider.class);
        AppWidgetManager manager = AppWidgetManager.getInstance(context);
        manager.updateAppWidget(myWidget, rv);
    }
}
