package com.haod.www.chatroot;

import android.app.Application;
import android.content.Context;

import com.haod.www.chatroot.tools.SpeechSynTools;

public class ChatApp extends Application{

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        SpeechSynTools.getInstance().init();
    }

    public static Context getContext() {
        return context;
    }
}
