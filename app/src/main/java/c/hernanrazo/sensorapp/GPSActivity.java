package c.hernanrazo.sensorapp;

import android.Manifest;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GPSActivity extends AppCompatActivity {

    private int LOCATION_REQUEST = 1;
    private Button GPSBtn;
    private TextView latText;
    private TextView longText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        GPSBtn = findViewById(R.id.GPSBtn);
        latText = findViewById(R.id.latText);
        longText = findViewById(R.id.longText);

        ActivityCompat.requestPermissions(GPSActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_REQUEST);

        GPSBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GPSTracker GPSTracker = new GPSTracker(getApplicationContext());
                Location location = GPSTracker.getLocation();

                if (location != null) {

                    double latValue = location.getLatitude();
                    double longValue = location.getLongitude();
                    latText.setText(getResources().getString(R.string.GPS_lat_value, latValue));
                    longText.setText(getResources().getString(R.string.GPS_long_value, longValue));

                    Toast.makeText(getApplicationContext(), "Lat: " + latValue + "\n Lon: " + longValue, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
