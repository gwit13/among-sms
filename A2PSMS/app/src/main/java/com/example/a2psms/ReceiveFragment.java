package com.example.a2psms;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import java.util.ArrayList;
import java.util.List;

public class ReceiveFragment extends Fragment{
    int count;
    ViewPager2 mViewPager2;
    List<String> coordList;
    RecyclerView recyclerView;
    CoordAdapter coordAdapter;
    SharedPreferences sharedPref;
    Button refresh;
    public static Fragment newInstance(ViewPager2 mViewPager2,int position){
        ReceiveFragment fragment=new ReceiveFragment();
        fragment.mViewPager2=mViewPager2;
        fragment.count=position;
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState){
        View rootView=inflater.inflate(R.layout.receive_layout,container,false);
        coordList=new ArrayList<>();
        recyclerView=rootView.findViewById(R.id.recycler);
        coordAdapter=new CoordAdapter(coordList);
        sharedPref=getContext().getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE);
        refresh=rootView.findViewById(R.id.refresh);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(coordAdapter);
        refresh.setOnClickListener(new ClickListener());
        refresh();
        return rootView;
    }
    @Override
    public void onViewCreated(@NonNull View view,@Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        TabLayout tabLayout=getActivity().findViewById(R.id.tabframe);
        new TabLayoutMediator(tabLayout,mViewPager2,((tab,position)->tab.setText("Send"))).attach();
    }
    public void refresh(){
        String lat=sharedPref.getString("lat",",");
        String lon=sharedPref.getString("lon",",");
        lat=lat.substring(0,lat.length()-1);
        lon=lon.substring(0,lon.length()-1);
        String[] latArray=lat.split(",");
        String[] lonArray=lon.split(",");
        coordList.clear();
        for(int i=0;i<latArray.length;i++){
            Log.e(i+"",latArray[i]+','+lonArray[i]);
            coordList.add(latArray[i]+','+lonArray[i]);
        }
        coordAdapter.notifyDataSetChanged();
    }
    private class ClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v){
            refresh();
        }
    }
}
