package org.joy.map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.snackbar.Snackbar;
import com.pedro.library.AutoPermissions;
import com.pedro.library.AutoPermissionsListener;

import java.text.DecimalFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements AutoPermissionsListener {
    public static final String TAG = "HuStar";
    private SupportMapFragment mapFragment;
    private GoogleMap map;
    private MarkerOptions myLocationMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, ">onCreate:");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @SuppressLint("MissingPermission")
            @Override
            public void onMapReady(GoogleMap googleMap) {
                Log.d(TAG, "MapAsync 지도 준비됨.");
                map = googleMap;
                map.setMyLocationEnabled(true);
            }
        });

        try {
            MapsInitializer.initialize(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.d(TAG, " onCreate:Button");
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startLocationService();
            }
        });

        AutoPermissions.Companion.loadAllPermissions(this, 101);
        Log.d(TAG, "<onCreate");
    } // end of onCreate()

    @SuppressLint("MissingPermission")
    @Override
    public void onResume() {
        super.onResume();
        if (map != null) {
            map.setMyLocationEnabled(true);
        }
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onPause() {
        super.onPause();
        if (map != null) {
            map.setMyLocationEnabled(false);
        }
    }

    @Override
    public void onDenied(int i, String[] strings) {
        Toast.makeText(this, "Permission denied", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onGranted(int i, String[] strings) {
        Toast.makeText(this, "Permission granted", Toast.LENGTH_LONG).show();
    }

    public void startLocationService() {
        Log.d(TAG, ">startLocationService");
        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        try {
            Location location = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (location != null) {
                showCurrentLocation(location.getLatitude(), location.getLongitude());
            }

            GPSListener gpsListener = new GPSListener();
            long minTime = 10000;
            float minDistance = 0;

            manager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                    minTime, minDistance, gpsListener);

            Log.d(TAG, "<startLocationService: 내 위치확인 요청함");
        } catch(SecurityException e) {
            e.printStackTrace();
        }

        Log.d(TAG, " onCreate:MapClickListener: map = " + map);
        map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                Log.d(TAG, " onMapClick = " + map.toString());
                setMockLocation(latLng.latitude, latLng.longitude);  // update gps
                myLocationMarker.position(latLng);
                map.animateCamera(CameraUpdateFactory.newLatLng(latLng));
            }
        });

        Log.d(TAG, " onCreate:DragListener");
        map.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker arg0) {
                Log.d(TAG, "onMarkerDragStart...");
            }

            @Override
            public void onMarkerDrag(Marker arg0) {
                Log.d(TAG, ">...onMarkerDrag");
            }

            @Override
            public void onMarkerDragEnd(Marker marker) {
                Log.d(TAG, "onMarkerDragEnd...at " + marker.toString());

                myLocationMarker = null; // new marker

                showCurrentLocation(marker.getPosition().latitude, marker.getPosition().longitude);
                setMockLocation(marker.getPosition().latitude, marker.getPosition().longitude);
            }
        });
    }

    class GPSListener implements LocationListener {
        @Override
        public void onLocationChanged(Location location) {
            showCurrentLocation(location.getLatitude(), location.getLongitude());
        }

        @Override
        public void onProviderDisabled(String provider) { }
        @Override
        public void onProviderEnabled(String provider) { }
    }

    public void showCurrentLocation(double latitude, double longitude) {
        Log.d(TAG, ">showCurrentlocation");
        DecimalFormat df = new DecimalFormat("###.####");
        String msg = "Latitude: " + df.format(latitude) + "  " +
                     "Longitude: " + df.format(longitude);
        Snackbar snackbar = Snackbar.make(findViewById(R.id.map), msg, Snackbar.LENGTH_INDEFINITE);
        snackbar.setBackgroundTint(ContextCompat.getColor(this, R.color.colorAccent));
        snackbar.show();

        LatLng curPoint = new LatLng(latitude, longitude);
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(curPoint, 15));
        showMyLocationMarker(curPoint);
        Log.d(TAG, "<showCurrentLocation");
    }

    private void showMyLocationMarker (LatLng curPoint){
        Log.d(TAG, ">showMyLocationMarker");
        if (myLocationMarker == null) {
            Log.d(TAG, " New Marker");
            myLocationMarker = new MarkerOptions();
            myLocationMarker.position(curPoint);
            myLocationMarker.title("내 위치").snippet("B'Day Party");
            myLocationMarker.draggable(true).alpha(0.5f);
            myLocationMarker.icon(BitmapDescriptorFactory.fromResource(R.drawable.mylocation));
        } else {
            Log.d(TAG, " New position");
            myLocationMarker.position(curPoint);
        }

        map.addMarker(myLocationMarker);
        Log.d(TAG, "<showMyLocationMarker");
    }

    private void setMockLocation(double latitude, double longitude) {
        Log.d(TAG, ">setMockLocation: " + latitude + " " + longitude);
        LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);

        Log.d(TAG, " mock Location()");
        Location mockLocation = new Location(LocationManager.GPS_PROVIDER);
        mockLocation.setLatitude(latitude);
        mockLocation.setLongitude(longitude);
        mockLocation.setAltitude(10f);
        mockLocation.setAccuracy(5f);
        mockLocation.setElapsedRealtimeNanos(System.nanoTime());
        mockLocation.setTime(new Date().getTime());

        mockLocation.setProvider(LocationManager.GPS_PROVIDER);
        Log.d(TAG, " setTestProviderEnabled()");
        Log.d(TAG, " @@@@@@@@@@ not working @@@@@@@@@@@@@@@@@@setTestProvider()");
        /*
        locationManager.setTestProviderEnabled(LocationManager.GPS_PROVIDER, true);
        Log.d(TAG, " setTestProviderLocation()");
        locationManager.setTestProviderLocation(LocationManager.GPS_PROVIDER, mockLocation);
        */
        Log.d(TAG, "<setMockLocation: " + latitude + " " + longitude);
    }
}