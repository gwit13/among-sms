package com.example.a2psms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements android.location.LocationListener{
    SharedPreferences sharedPref;
    ImageButton send;
    double lat,lon;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPref=this.getSharedPreferences("SharedPrefs",Context.MODE_PRIVATE);
        send=findViewById(R.id.send);
        send.setOnClickListener(new SendListener());
        checkForSMSPermission();
    }
    @Override
    public void onLocationChanged(Location location){
        lat=location.getLatitude();
        lon=location.getLongitude();
        Log.e("LOCAITON CHANGE","botto mtext");
    }
    private void checkForSMSPermission(){
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.RECEIVE_SMS)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECEIVE_SMS},1);
        }
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.SEND_SMS)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);
        }
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
        }
    }
    private class SendListener implements View.OnClickListener{
        @Override
        public void onClick(View v){
            SmsManager.getDefault().sendTextMessage(sharedPref.getString("phone","5719992849"),null,"AMONG SMS:"+lat+','+lon,null,null);
        }
    }
}
