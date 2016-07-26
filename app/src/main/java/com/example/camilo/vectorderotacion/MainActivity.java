package com.example.camilo.vectorderotacion;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private TextView textViewX;
    private TextView textViewY;
    private TextView textViewZ;
    private TextView textViewE;

    private SensorManager sensorManager;
    private Sensor vectorRotacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TextView para el vector de rotacion
        textViewX = (TextView) findViewById(R.id.txtViewX);
        textViewY = (TextView) findViewById(R.id.txtViewY);
        textViewZ = (TextView) findViewById(R.id.txtViewZ);
        textViewE = (TextView) findViewById(R.id.txtViewE);

        // Instancia de la clase SensorManager a traves del siguiente metodo
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        // definicion del tipó de sensor que sera utilizado
        vectorRotacion = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
