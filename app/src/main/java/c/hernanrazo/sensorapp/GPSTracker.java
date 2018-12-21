package c.hernanrazo.sensorapp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

public class GPSTracker implements LocationListener {

    private Context context;

    public GPSTracker(Context c) {

        context = c;
    }

    public Location getLocation() {

        if (ContextCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            Toast.makeText(context, "Please enable location to continue", Toast.LENGTH_LONG).show();
        }

        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        boolean isEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        if (isEnabled) {

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, this);
            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            return location;

        } else {

            Toast.makeText(context, "Please enable location to continue", Toast.LENGTH_LONG).show();
        }
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
