package com.haod.www.chatroot.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.haod.www.chatroot.R;
import com.haod.www.chatroot.tools.SpeechRecTool;

public class SpeechRecActivity extends Activity implements SpeechRecTool.ResultsCallback{
    private TextView textView;
    private Button button;

    private SpeechRecTool speechRecTool = new SpeechRecTool(this);

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_rec);

        initView();
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        speechRecTool.startASR(SpeechRecActivity.this);
                        button.setBackgroundResource(R.drawable.bdspeech_btn_orangelight_pressed);
                        break;
                    case MotionEvent.ACTION_UP:
                        speechRecTool.stopASR();
                        button.setBackgroundResource( R.drawable.bdspeech_btn_orangelight_normal);
                        break;
                    default:
                        return false;
                }
                return true;
            }
        });

    }

    private void initView() {
        textView = findViewById(R.id.tv_rec);
        button = findViewById(R.id.button_rec);
    }

    @Override
    protected void onStart() {
        super.onStart();
        speechRecTool.createTool();
    }

    @Override
    protected void onStop() {
        super.onStop();
        speechRecTool.destroyTool();
    }

    @Override
    public void onResults(String result) {
        final String defResult = result;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView.setText(defResult);
            }
        });
    }
}
