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

// Metodo para iniciar la captura del vector de rotacion
    protected void onResume(){
        super.onResume();
        // El parametro SENSOR_DELAY_NORMAL define la velocidad de captura del sensor
        sensorManager.registerListener(this, vectorRotacion, sensorManager.SENSOR_DELAY_NORMAL);
    }

    // Metodo para parar cuando no se esta interactuando con el susario, esto reduce el consumo de energia
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
    // Accionado cuando los valores del sensor cambian
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Float x = sensorEvent.values[0];
        Float y = sensorEvent.values[1];
        Float z = sensorEvent.values[2];
        Float e = sensorEvent.values[3];


        textViewX.setText("Valor en X: " + x.toString());
        textViewY.setText("Valor en Y: " + y.toString());
        textViewZ.setText("Valor en Z: " + z.toString());
        textViewE.setText("Magnitud Escalar: " + e.toString());
    }
    // Cuando hay un cambio en la presicion del sensor
    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
