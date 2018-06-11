package com.haod.www.chatroot.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.haod.www.chatroot.R;
import com.haod.www.chatroot.tools.SpeechSynTools;

public class SpeechSynActivity extends Activity {
    private TextView textView;
    private Button button;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_syn);
        textView = findViewById(R.id.tv_syn);
        button = findViewById(R.id.button_syn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = textView.getText().toString();
                // TODO: 点击开始播放TextView上的文字的语音。
                SpeechSynTools.getInstance().speak(msg);
            }
        });
    }
}
