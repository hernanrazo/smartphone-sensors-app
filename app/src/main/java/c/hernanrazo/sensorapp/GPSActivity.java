package c.hernanrazo.sensorapp;

import android.Manifest;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//notice that the GPS does not require the sensorEventListener
public class GPSActivity extends AppCompatActivity {

    //set instances of widgets and location request code
    private int LOCATION_REQUEST = 1;
    private Button GPSBtn;
    private TextView latText;
    private TextView longText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        //retrieve widgets
        GPSBtn = findViewById(R.id.GPSBtn);
        latText = findViewById(R.id.latText);
        longText = findViewById(R.id.longText);

        //request permission for GPS access
        ActivityCompat.requestPermissions(GPSActivity.this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                LOCATION_REQUEST);

        //set listener for GPS button widget
        GPSBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //get instance of GPSTracker class in order to ask the user for
                //location access
                GPSTracker GPSTracker = new GPSTracker(getApplicationContext());
                Location location = GPSTracker.getLocation();

                if (location != null) {

                    //get current values for latitude and longitude
                    double latValue = location.getLatitude();
                    double longValue = location.getLongitude();

                    //display the values retrieved onto the textView widgets
                    latText.setText(getResources().getString(R.string.GPS_lat_value, latValue));
                    longText.setText(getResources().getString(R.string.GPS_long_value, longValue));
                }
            }
        });
    }
}
