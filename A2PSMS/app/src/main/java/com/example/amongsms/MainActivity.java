package com.example.a2psms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity{
    ViewPager2 mViewPager2;
    RecyclerView.Adapter mFragmentStateAdapter;
    int NUM_ITEMS=2;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager2=findViewById(R.id.tab_layout);
        mFragmentStateAdapter=new MyFragmentStateAdapter(this);
        mViewPager2.setAdapter(mFragmentStateAdapter);
        checkForSMSPermission();
    }
    private void checkForSMSPermission(){
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.READ_SMS)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_SMS},1);
        }
        else{}
    }
    private class MyFragmentStateAdapter extends FragmentStateAdapter{
        public MyFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity){
            super(fragmentActivity);
        }
        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return SendFragment.newInstance(mViewPager2, position);
        }
        @Override
        public int getItemCount(){
            return NUM_ITEMS;
        }
    }
}
