package com.haod.www.chatroot;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.content_list);
        button = findViewById(R.id.listen_button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    class VoiceAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = View.inflate(getApplicationContext(), R.layout.content_list_item, null);
                holder = new ViewHolder();
                holder.tvAsk = convertView.findViewById(R.id.tv_ask);
                holder.tvAnswer = convertView.findViewById(R.id.tv_answer);
                holder.ivAnswer = convertView.findViewById(R.id.iv_answer);
                holder.llAnswer = convertView.findViewById(R.id.ll_answer);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            return convertView;
        }
    }

    static class ViewHolder {
        private TextView tvAsk;
        private TextView tvAnswer;
        private ImageView ivAnswer;
        private LinearLayout llAnswer;
    }
}
