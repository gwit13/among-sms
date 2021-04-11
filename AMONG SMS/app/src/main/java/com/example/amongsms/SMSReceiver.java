package com.example.amongsms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle=intent.getExtras();
        SmsMessage[] msgs;
        String strMessage="";
        String format=bundle.getString("format");
        Object[] pdus=(Object[]) bundle.get("pdus");
        if(pdus!=null){
            msgs=new SmsMessage[pdus.length];
            for(int i=0;i<msgs.length;i++){
                msgs[i]=SmsMessage.createFromPdu((byte[]) pdus[i],format);
                strMessage+="SMS from "+msgs[i].getOriginatingAddress();
                strMessage+=" :"+msgs[i].getMessageBody()+"\n";
                Toast.makeText(context,strMessage,Toast.LENGTH_LONG).show();
            }
        }
    }
}