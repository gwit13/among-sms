package com.example.a2psms;

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

public class MapFragment extends Fragment implements OnMapReadyCallback{
    ViewPager2 mViewPager2;
    int count;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.map_layout, container, false); //inflate has to come first

        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager() //ChildFragmentManager bc this object extends Fragment itself
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this); //gaming

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
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(0, 0))
                .title("Marker"));
    }
}
