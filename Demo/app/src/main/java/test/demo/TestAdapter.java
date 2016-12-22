package test.demo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * <p/>
 * 作者：zhouyuan on  2016/12/20 18:07
 * <p/>
 * 邮箱：244370114@qq.com
 * <p/>
 */

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {


    private Context context;

    public TestAdapter(Context context) {
        this.context = context;
    }

    private String[] listData = new String[]{"RecyclerView", "test"};

    @Override
    public TestAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TestAdapter.ViewHolder holder, int position) {
        holder.tv_title.setText(listData[position]);
        holder.tv_title.setOnClickListener(v -> {
            switch (position) {
                case 0:
                    Intent intent = new Intent(context, TestRecyclerView.class);
                    context.startActivity(intent);
                    break;
                case 1:
                    break;
            }
        });

    }

    @Override
    public int getItemCount() {
        return listData.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_title;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}
