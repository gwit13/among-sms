package com.example.a2psms;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapFragment extends Fragment implements OnMapReadyCallback{
    ViewPager2 mViewPager2;
    int count;
    SharedPreferences sharedPref;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.map_layout, container, false); //inflate has to come first

        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager() //ChildFragmentManager bc this object extends Fragment itself
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this); //gaming
        sharedPref=getContext().getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE);
        return v; //lpendleton
    }

    //newInstance for the tab layout (we barely knew ye) (but also prob needs something similar if not exactly this for BottomNavigationView)
    public static Fragment newInstance(ViewPager2 mViewPager2, int position) {
        MapFragment fragment = new MapFragment();
        fragment.mViewPager2 = mViewPager2;
        fragment.count = position;
        return fragment;
    }

    //Markers!
    @Override
    public void onMapReady(GoogleMap googleMap) {
        String lat=sharedPref.getString("lat","");
        String lon=sharedPref.getString("lon","");
        if(!lat.equals("")){
            String[] latArray=lat.split(",");
            String[] lonArray=lon.split(",");
            PolylineOptions polyline=new PolylineOptions();
            polyline.color(0xFFFF0000);
            for(int i=0;i<latArray.length;i++){
                LatLng location=new LatLng(Float.parseFloat(latArray[i]),Float.parseFloat(lonArray[i]));
                googleMap.addMarker(new MarkerOptions().position(location).title("Marker"));
                polyline.add(location);
            }
            googleMap.addPolyline(polyline);
        }
    }
}
