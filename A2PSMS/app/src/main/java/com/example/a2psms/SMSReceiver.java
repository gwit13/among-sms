package com.example.a2psms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SMSReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context,Intent intent){
        Bundle bundle=intent.getExtras();
        SmsMessage[] message;
        String format=bundle.getString("format");
        Object[] pdus=(Object[])bundle.get("pdus");
        Pattern regex=Pattern.compile("^AMONG SMS:-?\\d*\\.?\\d*,-?\\d*\\.?\\d*$");
        if(pdus!=null){
            message=new SmsMessage[pdus.length];
            for(int i=0;i<message.length;i++){
                message[i]=SmsMessage.createFromPdu((byte[]) pdus[i],format);
                Matcher matcher=regex.matcher(message[i].getMessageBody());
                if(matcher.matches()){
                    Log.e("SMS In","Matched!");
                    int start=message[i].getMessageBody().indexOf(':')+1;
                    int comma=message[i].getMessageBody().indexOf(',');
                    SharedPreferences sharedPref=context.getSharedPreferences("SharedPrefs",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPref.edit();
                    editor.putString("lat",sharedPref.getString("lat","")+message[i].getMessageBody().substring(start,comma)+',');
                    editor.putString("lon",sharedPref.getString("lon","")+message[i].getMessageBody().substring(comma+1)+',');
                    editor.apply();
                }
                else{
                    Log.e("SMS In","Did not match!");
                }
            }
        }
    }
}