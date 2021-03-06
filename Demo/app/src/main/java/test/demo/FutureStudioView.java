package test.demo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * <p/>
 * 作者：zhouyuan on  2016/12/22 14:13
 * <p/>
 * 邮箱：244370114@qq.com
 * <p/>
 */

public class FutureStudioView extends FrameLayout {
    ImageView iv;
    TextView tv;

    public void initialize(Context context) {
        inflate(context, R.layout.custom_view_futurestudio, this);

        iv = (ImageView) findViewById(R.id.custom_view_image);
        tv = (TextView) findViewById(R.id.custom_view_text);
    }

    public FutureStudioView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public FutureStudioView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);
    }

    public void setImage(Drawable drawable) {
        iv.setImageDrawable(drawable);
    }

    public void setText(String s) {
        tv.setText(s);
    }
}
