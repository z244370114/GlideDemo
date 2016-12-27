package test.demo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.VideoView;

/**
 * <p/>
 * 作者：zhouyuan on  2016/12/21 09:24
 * <p/>
 * 邮箱：244370114@qq.com
 * <p/>
 */

public class TestRecyclerView extends AppCompatActivity {

    private Button bt_glide;
    private WebView webView;
    private VideoView videoView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        bt_glide = (Button) findViewById(R.id.bt_glide);
        webView = (WebView) findViewById(R.id.webView);
        videoView = (VideoView) findViewById(R.id.videoView);
        bt_glide.setOnClickListener(v -> startActivity(new Intent(this, TestGlideActivity.class)));
        final String url = "http://v-jia.deyi.com/锯门.mp4";
//        Map<String, String> extraHeaders = new HashMap<String, String>();
//        extraHeaders.put("Referer", "*deyi.com");
//        webView.loadUrl(url, extraHeaders);
//        HashMap<String, String> headers = new HashMap<String, String>();
//        headers.put("headers", "Referer:deyi.com");
//        videoView.setVideoURI(Uri.parse(url), headers);
        videoView.setVideoURI(Uri.parse(url));
        videoView.start();
    }
}
