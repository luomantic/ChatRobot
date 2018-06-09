package com.haod.www.chatroot.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.baidu.speech.EventListener;
import com.baidu.speech.EventManager;
import com.baidu.speech.EventManagerFactory;
import com.baidu.speech.asr.SpeechConstant;
import com.haod.www.chatroot.R;

import org.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

public class AsrTestActivity extends Activity implements EventListener{
    private TextView textView;
    private Button button;

    private EventManager eventManager;

//    private boolean enableOffline = false; // 测试离线命令词，需要改成true

    private String msg;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asr_test);

        initView();
//        initPermission(); // 6.0以上需要进行权限处理，先暂时不处理

        eventManager = EventManagerFactory.create(this, "asr");
        eventManager.registerListener(this);

        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP://松开事件发生后执行代码的区域
                        // TODO: 执行start语音识别
                        start();
                        break;
                    case MotionEvent.ACTION_DOWN://按住事件发生后执行代码的区域
                        // TODO: 执行stop语音识别
                        stop();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        /*
            暂不开启离线命令词功能
         */
//        if (enableOffline) {
//            loadOfflineEngine(); // 测试离线命令词请开启, 测试 ASR_OFFLINE_ENGINE_GRAMMER_FILE_PATH 参数时开启
//        }
    }

    /*
        停止语音识别
     */
    private void stop() {
        eventManager.send(SpeechConstant.ASR_STOP, null, null, 0, 0);
    }

    /*
        开始语音识别
     */
    private void start() {
        Map<String, Object> params = new LinkedHashMap<String, Object>();
//        "accept-audio-data":false,"disable-punctuation":false,"accept-audio-volume":true,"pid":1736
        params.put("accept-audio-data", false);
        params.put("disable-punctuation", false);
        params.put("accept-audio-volume", true);
        params.put("pid", 1736);

        params.put(SpeechConstant.ACCEPT_AUDIO_VOLUME, false);
        // params.put(SpeechConstant.NLU, "enable");
        // params.put(SpeechConstant.VAD_ENDPOINT_TIMEOUT, 0); // 长语音
        // params.put(SpeechConstant.IN_FILE, "res:///com/baidu/android/voicedemo/16k_test.pcm");
        // params.put(SpeechConstant.VAD, SpeechConstant.VAD_DNN);
        // params.put(SpeechConstant.PROP ,20000);
        // params.put(SpeechConstant.PID, 1537); // 中文输入法模型，有逗号
        // 请先使用如‘在线识别’界面测试和生成识别参数。 params同ActivityRecog类中myRecognizer.start(params);

        String json = new JSONObject(params).toString();
        eventManager.send(SpeechConstant.ASR_START, json, null, 0, 0);
    }

    private void initView() {
        textView = findViewById(R.id.test_textview);
        button = findViewById(R.id.test_button);
    }

    /*

     */
    @Override
    public void onEvent(String name, String params, byte[] data, int offset, int length) {
        if (params != null && !params.isEmpty()) {
            if (name.equals(SpeechConstant.CALLBACK_EVENT_ASR_PARTIAL)) {
                if (params.contains("\"nlu_reslut\"")) {
                    if (length > 0 && data.length > 0) {
                        msg += new String(data, offset, length); // 这个是语义解析的结果
                    }
                }
            }else if (data != null) {
                msg += data.length;
            }
        }
    }
}
