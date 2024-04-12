package com.lalo.earthquakes.details;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.lalo.earthquakes.Earthquake;
import com.lalo.earthquakes.R;
import com.lalo.earthquakes.databinding.ActivityDetailsBinding;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DetailsActivity extends AppCompatActivity
                                implements OnMapReadyCallback {

    public static final String EARTHQUAKE_KEY = "earthquake_key";
    ActivityDetailsBinding binding;
    private MapView mMapView;
    private GoogleMap mMap;

    Earthquake earthquake;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras = getIntent().getExtras();
        earthquake = extras.getParcelable("earthquake_key");
        Date date = new Date(earthquake.getTime());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formattedDate = simpleDateFormat.format(date);

        binding.setEarthquake(earthquake);
        binding.setTime(formattedDate);
        binding.setMag(String.format(String.valueOf(R.string.magnitude_format), earthquake.getMagnitude()));

        mMapView = binding.mapView;
        mMapView.onCreate(savedInstanceState);
        mMapView.getMapAsync(this);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        if (mMap != null) {
            LatLng loc = new LatLng(earthquake.getLongitude(), earthquake.getLatitude());
            MarkerOptions markerOptions = new MarkerOptions()
                    .position(loc)
                    .title(earthquake.getPlace());

            mMap.addMarker(markerOptions);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(loc, 3));
        }
    }
}


