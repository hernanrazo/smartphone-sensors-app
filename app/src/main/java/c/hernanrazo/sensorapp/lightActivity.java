package c.hernanrazo.sensorapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class lightActivity extends AppCompatActivity implements SensorEventListener {

    //set instances for the sensorManager, light sensor, and textViews
    private SensorManager sensorManager;
    private Sensor lightSensor;
    private TextView lightSensorText;

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        //retrieve the current value of the light sensor
        float currentValue = sensorEvent.values[0];

        //display the retrieved values onto the textView
        lightSensorText.setText(getResources().getString(R.string.light_text, currentValue));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

        //ambient light sensor does not report accuracy changes
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);

        //retrieve widgets
        lightSensorText = findViewById(R.id.lightSensorText);

        //define instances
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
    }

    //register the listener once the activity starts
    @Override
    protected void onStart() {
        super.onStart();

        if(lightSensor != null) {

            sensorManager.registerListener(this, lightSensor, sensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    //stop the sensor when the activity stops to reduce battery usage
    @Override
    protected void onStop() {
        super.onStop();

        sensorManager.unregisterListener(this);
    }
}
