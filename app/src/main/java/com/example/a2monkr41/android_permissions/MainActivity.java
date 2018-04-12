package com.example.a2monkr41.android_permissions;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LocationListener, View.OnClickListener{

    LocationManager mgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mgr =(LocationManager)getSystemService(Context.LOCATION_SERVICE);


    }

    public void onLocationChanged(Location loc){
        TextView lon =(TextView)findViewById(R.id.lon),
                lat = (TextView)findViewById(R.id.lat);

        lat.setText(String.valueOf(loc.getLatitude()));
        lon.setText(String.valueOf(loc.getLongitude()));

        Button grant = (Button)findViewById(R.id.grant),
                start = (Button)findViewById(R.id.start);

        grant.setOnClickListener(this);
        start.setOnClickListener(this);
    }

    public void onClick(View view) {
        if(view.getId() == R.id.grant) {
            if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED) {
                mgr.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
            } else {
                new AlertDialog.Builder(this).setPositiveButton("OK", null).
                        setMessage("No permission to read files!!").show();
            }
        }
        else if (view.getId() ==R.id.start) {


        }
    }

    public void onProviderEnabled(String provider) {

    }

    public void onProviderDisabled(String provider) {

    }
    public void onStatusChanged(String provider, int status, Bundle b) {

    }
}
