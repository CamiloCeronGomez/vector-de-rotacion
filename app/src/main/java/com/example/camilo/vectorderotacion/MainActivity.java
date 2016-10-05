package com.example.camilo.vectorderotacion;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private TextView textViewX;
    private TextView textViewY;
    private TextView textViewZ;
    private TextView textViewE;
    private int Azimuth = 0;
    private int Pitch = 0;
    private int Roll = 0;
    float[] orientation = new float[3];
    float[] rMat = new float[9];
    private SensorManager sensorManager = null;
    private Sensor vectorRotacion;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


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
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    // Metodo para iniciar la captura del vector de rotacion
    protected void onResume() {
        super.onResume();
        // El parametro SENSOR_DELAY_NORMAL define la velocidad de captura del sensor
        sensorManager.registerListener((SensorEventListener) this, vectorRotacion, sensorManager.SENSOR_DELAY_NORMAL);
    }

    // Metodo para parar cuando no se esta interactuando con el susario, esto reduce el consumo de energia
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener((SensorEventListener) this);
    }


    // Accionado cuando los valores del sensor cambian
    @Override
    public void onSensorChanged(SensorEvent event) {

        switch (event.sensor.getType()) {
            // Valores de la aceleracion del dispositivo incluyendo la gravedad
            case Sensor.TYPE_ROTATION_VECTOR:

                //Calcular la Matris de Rotacion
                SensorManager.getRotationMatrixFromVector(rMat, event.values);
                // Obtener el valor de Azimuth en Grados
                Azimuth = (int) (Math.toDegrees(SensorManager.getOrientation(rMat, orientation)[0]) + 360) % 360;
                Pitch = (int) (Math.toDegrees(SensorManager.getOrientation(rMat, orientation)[1]) + 360) % 360;
                Roll = (int) (Math.toDegrees(SensorManager.getOrientation(rMat, orientation)[2]) + 360) % 360;

                textViewX.setText("Posicion X: " + Azimuth);
                textViewY.setText("Posicion Y: " + Pitch);
                textViewZ.setText("Posicion Z: " + Roll);

                break;

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.camilo.vectorderotacion/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.camilo.vectorderotacion/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
