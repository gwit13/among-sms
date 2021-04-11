package com.example.a2psms;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class SendFragment extends Fragment{
    int count;
    ViewPager2 mViewPager2;
    public static Fragment newInstance(ViewPager2 mViewPager2,int position) {
        SendFragment fragment=new SendFragment();
        fragment.mViewPager2=mViewPager2;
        fragment.count=position;
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState){
        View rootView=inflater.inflate(R.layout.send_layout,container,false);
        return rootView;
    }
    @Override
    public void onViewCreated(@NonNull View view,@Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        TabLayout tabLayout=getActivity().findViewById(R.id.tabframe);
        new TabLayoutMediator(tabLayout,mViewPager2,((tab,position)->tab.setText("Receive"))).attach();
    }
}
