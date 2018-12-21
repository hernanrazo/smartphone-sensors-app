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

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        Button proximityBtn = findViewById(R.id.proximityBtn);
        Button accelerometerBtn = findViewById(R.id.accelerometerBtn);
        Button lightBtn = findViewById(R.id.lightBtn);
        Button GPSBtn = findViewById(R.id.GPSBtn);
        Button magnetometerBtn = findViewById(R.id.magnetometerBtn);
        Button pressureBtn = findViewById(R.id.pressureBtn);

        if(sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY) != null) {

            proximityBtn.setOnClickListener(new View.OnClickListener () {
                @Override
                public void onClick(View view) {

                    Intent proximityIntent = new Intent(MainActivity.this, proximityActivity.class);
                    startActivity(proximityIntent);
                }
            });
        } else {

            proximityBtn.setEnabled(false);
        }

        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {

            accelerometerBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent accelerometerIntent = new Intent(MainActivity.this, accelerometerActivity.class);
                    startActivity(accelerometerIntent);
                }
            });
        } else {

            accelerometerBtn.setEnabled(false);
        }

        if (sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT) != null) {

            lightBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent lightIntent = new Intent(MainActivity.this, lightActivity.class);
                    startActivity(lightIntent);
                }
            });
        } else {

            lightBtn.setEnabled(false);
        }

        //GPS does not need if/else statement
        GPSBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent GPSIntent = new Intent(MainActivity.this, GPSActivity.class);
                startActivity(GPSIntent);
            }
        });

        if (sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null) {

            magnetometerBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent magnetometerIntent = new Intent(MainActivity.this, magnetometerActivity.class);
                    startActivity(magnetometerIntent);
                }
            });
        } else {

            magnetometerBtn.setEnabled(false);
        }

        if(sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE) != null) {

            pressureBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent pressureIntent = new Intent(MainActivity.this, pressureActivity.class);
                    startActivity(pressureIntent);
                }
            });
        } else {

            pressureBtn.setEnabled(false);
        }
    }
}
