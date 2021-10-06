package com.example.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "MyService";

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //로그 찍기
        Log.d(TAG, "onCreate() 호출됨.");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 명령어 처리(intent 처리)
        Log.d(TAG, "onStartCommand() 호출됨.");

        if(intent == null) {
            return Service.START_STICKY;
        } else {
            processCommand(intent);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void processCommand(Intent intent) {
        String command = intent.getStringExtra("command");   // 명령어 구분
        String name = intent.getStringExtra("name");

        Log.d(TAG, "전달받은 데이터: " + command + ", " + name);

        try {
            Thread.sleep(5000);    // 5초 쉬기
        } catch(Exception e) {}

        Intent showIntent = new Intent(getApplicationContext(), MainActivity.class);
        showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP |
                Intent.FLAG_ACTIVITY_CLEAR_TOP); //화면이 없는 데서 띄울 수 있다
        showIntent.putExtra("command", "show");
        showIntent.putExtra("name", name + " from service");
        startActivity(showIntent);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy() 호출됨.");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}