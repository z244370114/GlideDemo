package test;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.HashMap;
import java.util.Map;

import test.demo.R;

/**
 * Created by Administrator on 2016/12/23.
 */
public class StrategyVedioViewActivity extends FragmentActivity {
    public static final String DATA_URL = "url_data";
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy_viedio);
        videoView = (VideoView) findViewById(R.id.video_view);
        //设置视频控制器
        videoView.setMediaController(new MediaController(this));

        //播放完成回调
        videoView.setOnCompletionListener(new MyPlayerOnCompletionListener());

        Map<String, String> extraHeaders = new HashMap<>();
        extraHeaders.put("Referer", "http://jia.deyi.com/video-show/20.html");
        //设置视频路径
//        videoView.setVideoURI(Uri.parse("http://v-jia.deyi.com/锯门.mp4"), extraHeaders);
        String path = "http://v-jia.deyi.com/" + Uri.encode("锯门.mp4");
//        String path = "http://video.cztv.com/video/rzx/201208/15/1345010952759.mp4";
        videoView.setVideoURI(Uri.parse(path), extraHeaders);
//        videoView.setVideoURI(Uri.parse(path));
        //开始播放视频
        videoView.start();
    }

    class MyPlayerOnCompletionListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mp) {
            Toast.makeText(StrategyVedioViewActivity.this, "播放完成了", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
