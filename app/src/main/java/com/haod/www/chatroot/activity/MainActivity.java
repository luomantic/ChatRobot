package com.haod.www.chatroot.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.haod.www.chatroot.Constant;
import com.haod.www.chatroot.R;
import com.haod.www.chatroot.base.Translation;
import com.haod.www.chatroot.base.impl.GetRequest_Interface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

import static com.haod.www.chatroot.Constant.test_api_base;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private Button btn_send;
    private EditText et_send;

    private String askMsg;
    private String request_url;
    private String test_api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.content_list);
        btn_send = findViewById(R.id.btn_send);
        et_send = findViewById(R.id.et_input);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askMsg = et_send.getText().toString();

                // 将askMsg显示到ListView

                // 将askMsg拼接到字符串，并发送给图灵机器人服务器
                request_url = Constant.TULING_API_BASE + "&info=" + askMsg;
                test_api = test_api_base + "repos/square/retrofit/contributors/";

                request();

            }
        });
    }

    public void request(){
        // 创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.TULING_API_BASE) // 设置网络请求的基本url
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 创建网络请求接口的实例
        GetRequest_Interface request_interface = retrofit.create(GetRequest_Interface.class);

        // 对发送请求进行封装
        Call<Translation> call = request_interface.getCall();

        // 发送网络请求（异步）
        call.enqueue(new Callback<Translation>() {
            @Override
            public void onResponse(Call<Translation> call, Response<Translation> response) {
                Log.e(Constant.TAG, "response.body(): " + response.body().getText());
            }

            @Override
            public void onFailure(Call<Translation> call, Throwable t) {

            }
        });
    }

    private void showResponse() {

    }


    @Override
    protected void onStop() {
        super.onStop();
//        call.cancel;
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
