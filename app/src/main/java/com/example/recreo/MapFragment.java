package com.example.recreo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment implements OnMapReadyCallback {

    // Coordenadas de ReCreo
    private final LatLng recreoLocation = new LatLng(-17.787897094646812, -63.21423865872864);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_map_fragment, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.fragmentContainerView);

        if (mapFragment == null) {
            mapFragment = SupportMapFragment.newInstance();
            getChildFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerView, mapFragment)
                    .commit();
        }

        mapFragment.getMapAsync(this);
        return view;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        // Icono personalizado
        BitmapDescriptor customIcon = resizeIcon(R.drawable.recreologo, 100, 100);

        // Agregar marcador en la ubicación de ReCreo
        googleMap.addMarker(new MarkerOptions()
                .position(recreoLocation)
                .title("ReCreo")
                .icon(customIcon));

        // Centrar y hacer zoom en ReCreo
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(recreoLocation, 15));
    }

    private BitmapDescriptor resizeIcon(int elemento, int width, int height) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), elemento);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, width, height, false);
        return BitmapDescriptorFactory.fromBitmap(resizedBitmap);
    }
}

