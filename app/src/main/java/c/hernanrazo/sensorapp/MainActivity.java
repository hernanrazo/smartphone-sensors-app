package c.hernanrazo.sensorapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button proximityBtn = findViewById(R.id.proximityBtn);
        Button accelerometerBtn = findViewById(R.id.accelerometerBtn);
        Button lightBtn = findViewById(R.id.lightBtn);
        Button GPSBtn = findViewById(R.id.GPSBtn);

        proximityBtn.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Intent proximityIntent = new Intent(MainActivity.this, proximityActivity.class);
                startActivity(proximityIntent);
            }
        });

        accelerometerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent accelerometerIntent = new Intent(MainActivity.this, accelerometerActivity.class);
                startActivity(accelerometerIntent);
            }
        });

        lightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent lightIntent = new Intent(MainActivity.this, lightActivity.class);
                startActivity(lightIntent);
            }
        });

        GPSBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent GPSIntent = new Intent(MainActivity.this, GPSActivity.class);
                startActivity(GPSIntent);
            }
        });
    }
}
