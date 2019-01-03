package c.hernanrazo.sensorapp;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set instance of Android's sensorManager to access sensor services
        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        //set up all button instances
        Button proximityBtn = findViewById(R.id.proximityBtn);
        Button accelerometerBtn = findViewById(R.id.accelerometerBtn);
        Button lightBtn = findViewById(R.id.lightBtn);
        Button GPSBtn = findViewById(R.id.GPSBtn);
        Button magnetometerBtn = findViewById(R.id.magnetometerBtn);
        Button pressureBtn = findViewById(R.id.pressureBtn);

        //add logic for each sensor where the button is disabled if that specific sensor is
        //not available on the current device. Notice that the GPS does
        //not have logic for this because all phones have GPS

        if(sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY) != null) {

            //set listener for button
            proximityBtn.setOnClickListener(new View.OnClickListener () {
                @Override
                public void onClick(View view) {

                    //add intent that takes use to the sensor's activity if the button pressed
                    Intent proximityIntent = new Intent(MainActivity.this, proximityActivity.class);
                    startActivity(proximityIntent);
                }
            });
        } else {

            //disable button if sensor is not available
            proximityBtn.setEnabled(false);
        }

        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {

            //set listener for button
            accelerometerBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //add intent that takes use to the sensor's activity if the button pressed
                    Intent accelerometerIntent = new Intent(MainActivity.this, accelerometerActivity.class);
                    startActivity(accelerometerIntent);
                }
            });
        } else {

            //disable button if sensor is not available
            accelerometerBtn.setEnabled(false);
        }

        if (sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT) != null) {

            //set listener for button
            lightBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //add intent that takes use to the sensor's activity if the button pressed
                    Intent lightIntent = new Intent(MainActivity.this, lightActivity.class);
                    startActivity(lightIntent);
                }
            });
        } else {

            //disable button if sensor is not available
            lightBtn.setEnabled(false);
        }

        //GPS does not need if/ else statement
        GPSBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //add intent that takes use to the sensor's activity if the button pressed
                Intent GPSIntent = new Intent(MainActivity.this, GPSActivity.class);
                startActivity(GPSIntent);
            }
        });

        if (sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null) {

            //set listener for button
            magnetometerBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //add intent that takes use to the sensor's activity if the button pressed
                    Intent magnetometerIntent = new Intent(MainActivity.this, magnetometerActivity.class);
                    startActivity(magnetometerIntent);
                }
            });
        } else {

            //disable button if sensor is not available
            magnetometerBtn.setEnabled(false);
        }

        if(sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE) != null) {

            //set listener for button
            pressureBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //add intent that takes use to the sensor's activity if the button pressed
                    Intent pressureIntent = new Intent(MainActivity.this, pressureActivity.class);
                    startActivity(pressureIntent);
                }
            });
        } else {

            //disable button if sensor is not available
            pressureBtn.setEnabled(false);
        }
    }
}
