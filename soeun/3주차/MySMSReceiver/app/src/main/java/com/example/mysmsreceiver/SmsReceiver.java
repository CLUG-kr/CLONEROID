package com.example.mysmsreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SmsReceiver extends BroadcastReceiver {
    private static final String TAG = "SmsReceiver";
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @Override
    public void onReceive(Context context, Intent intent) { // call back 메소드(sms가 오면 자동으로 호출됨)
        //throw new UnsupportedOperationException("Not yet implemented");

        Log.d(TAG, "onReceive() 호출됨."); //에뮬레이터에서 문자 받으면 로그에 기록됨

        Bundle bundle = intent.getExtras();
        SmsMessage[] messages = parseSmsMessage(bundle);

        if(messages.length > 0) {
            String sender = messages[0].getOriginatingAddress();    // 상대방 번호
            Log.d(TAG, "sender: " + sender);

            String contents = messages[0].getMessageBody().toString();
            Log.d(TAG, "contents: " + contents);

            Date receivedDate = new Date(messages[0].getTimestampMillis());
            Log.d(TAG, "received date: " + receivedDate);

            sendToActivity(context, sender, contents, receivedDate);
        }
    }

    private void sendToActivity(Context context, String sender, String contents, Date receivedDate) {
        Intent intent = new Intent(context, SmsActivity.class);

        // 화면이 없는데 뭘 띄우려면 -> Flag
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP |
                Intent.FLAG_ACTIVITY_CLEAR_TOP);

        intent.putExtra("sender", sender);
        intent.putExtra("contents", contents);
        intent.putExtra("receivedDate", format.format(receivedDate));

        context.startActivity(intent);
    }

    private SmsMessage[] parseSmsMessage(Bundle bundle) {
        Object[] objs = (Object[]) bundle.get("pdus"); // pdus안에 데이터가 들어가있다
        SmsMessage[] messages = new SmsMessage[objs.length];

        for(int i=0; i< objs.length; i++) {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                String format = bundle.getString("format");
                messages[i] = SmsMessage.createFromPdu((byte[]) objs[i], format);
            } else {
                messages[i] = SmsMessage.createFromPdu((byte[]) objs[i]);
            }


        }
        return messages;
    }
}