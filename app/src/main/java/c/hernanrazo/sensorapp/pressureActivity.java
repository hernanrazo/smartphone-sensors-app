package c.hernanrazo.sensorapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class pressureActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor pressureSensor;
    private TextView pressureSensorText;

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        float currentValue = sensorEvent.values[0];
        pressureSensorText.setText(getResources().getString(R.string.pressure_text, currentValue));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

        //pressure sensor does not report accuracy changes
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);

        pressureSensorText = findViewById(R.id.pressureSensorText);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        pressureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (pressureSensor != null) {

            sensorManager.registerListener(this, pressureSensor, sensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        sensorManager.unregisterListener(this);
    }
}
