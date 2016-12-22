package test.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

/**
 * <p/>
 * 作者：zhouyuan on  2016/12/21 09:24
 * <p/>
 * 邮箱：244370114@qq.com
 * <p/>
 */

public class TestRecyclerView extends AppCompatActivity {

    private Button bt_glide;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        bt_glide = (Button) findViewById(R.id.bt_glide);
        bt_glide.setOnClickListener(v -> startActivity(new Intent(this,TestGlideActivity.class)));
    }
}
