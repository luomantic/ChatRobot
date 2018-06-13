package com.haod.www.chatroot.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.haod.www.chatroot.Constant;
import com.haod.www.chatroot.R;
import com.haod.www.chatroot.base.TalkBean;
import com.haod.www.chatroot.base.Translation;
import com.haod.www.chatroot.base.impl.GetRequest_Interface;
import com.haod.www.chatroot.tools.SpeechRecTool;
import com.haod.www.chatroot.tools.SpeechSynTools;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements SpeechRecTool.ResultsCallback {
    private ListView listView;
    private Button button;

    private Call<Translation> call;

    private ArrayList<TalkBean> talkBeans = new ArrayList<>();
    private TalkListAdapter adapter;

    private SpeechRecTool speechRecTool = new SpeechRecTool(this);


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.content_list);
        button = findViewById(R.id.button_lis);

        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        speechRecTool.startASR(MainActivity.this);
                        break;
                    case MotionEvent.ACTION_UP:
                        speechRecTool.stopASR();
                        break;
                    default:
                        return false;
                }
                return false;
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        speechRecTool.createTool();
    }

    @Override
    protected void onStop() {
        super.onStop();
        call.cancel();
        speechRecTool.destroyTool();
    }

    @Override
    public void onResults(String result) {
        // TODO: 把发送的内容显示到ListView中
        talkBeans.add(new TalkBean(result, true, -1));
        adapter = new TalkListAdapter();
        listView.setAdapter(adapter);
        listView.setSelection(talkBeans.size() -1);

        request(result);
    }

    public void request(String askMsg){
        // 创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.TULING_API_BASE) // 设置网络请求的基本url
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 创建网络请求接口的实例
        GetRequest_Interface request_interface = retrofit.create(GetRequest_Interface.class);

        // 对发送请求进行封装
        call = request_interface.getCall(askMsg);

        // 发送网络请求（异步）
        call.enqueue(new Callback<Translation>() {
            @Override
            public void onResponse(Call<Translation> call, Response<Translation> response) {
                String answer = response.body().getText();

                // TODO：获取到信息之后，让获取到的text，显示在ListView上
                talkBeans.add(new TalkBean(answer, false, -1));
                adapter.notifyDataSetChanged();
                SpeechSynTools.getInstance().speak(answer);
                listView.setSelection(talkBeans.size() -1);
            }

            @Override
            public void onFailure(Call<Translation> call, Throwable t) {

            }
        });
    }

    class TalkListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return talkBeans.size();
        }

        @Override
        public TalkBean getItem(int position) {
            return talkBeans.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
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

            TalkBean item = getItem(position);
            if (item.isAsk) {
                holder.tvAsk.setVisibility(View.VISIBLE);
                holder.llAnswer.setVisibility(View.GONE);

                holder.tvAsk.setText(item.talk_content);
            } else {
                holder.tvAsk.setVisibility(View.GONE);
                holder.llAnswer.setVisibility(View.VISIBLE);

                holder.tvAnswer.setText(item.talk_content);

                if (item.imageId > 0) {
                    holder.ivAnswer.setVisibility(View.VISIBLE);
                    holder.ivAnswer.setImageResource(item.imageId);
                } else {
                    holder.ivAnswer.setVisibility(View.GONE);
                }
            }

            return convertView;
        }
    }

    private static class ViewHolder {
        private TextView tvAsk;
        private TextView tvAnswer;
        private ImageView ivAnswer;
        private LinearLayout llAnswer;
    }

}
