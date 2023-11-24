package com.example.meteoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import android.Manifest;


import com.google.android.gms.location.FusedLocationProviderClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_CODE = 1;
    private LocationManager locationManager;
    private LocationListener locationListener;

    private TextView nomVille, ciel, temperature, minTemp, maxTemp, direction, vitesseVent, humidite, hpa;
    private ImageView imageMeteo;
    private int testout = 1;

    private double lat,lon;
    private EditText ville;
    private Button getData;

    private String apiKey = "0839b7e104e8560d253120b7e4b9b041";
    private static final String TAG = "MainActivity";

    Call<ModelMeteo> call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomVille = findViewById(R.id.nomVille);
        ciel = findViewById(R.id.ciel);
        temperature = findViewById(R.id.temperature);
        minTemp = findViewById(R.id.minTemp);
        maxTemp = findViewById(R.id.maxTemp);
        direction = findViewById(R.id.direction);
        vitesseVent = findViewById(R.id.vitesseVent);
        humidite = findViewById(R.id.humidite);
        hpa = findViewById(R.id.hpa);

        ville = findViewById(R.id.meteoVille);

        getData = findViewById(R.id.chercher);

        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ville2 = ville.getText().toString();
                System.out.println(ville2);
                MethodMeteo methods = RetrofitMeteo.getRetrofitInstance().create(MethodMeteo.class);

                System.out.println(ville2);
                if(ville2.equals("")){

                    call = methods.getAllData(lat, lon,"metric", apiKey);
                }else {

                    call = methods.getAllData(ville2, "metric", apiKey);
                }

                System.out.println(call.toString());
                call.enqueue(new Callback<ModelMeteo>() {
                    @Override
                    public void onResponse(Call<ModelMeteo> call, Response<ModelMeteo> response) {

                        ArrayList<ModelMeteo.Prevision> data = response.body().getPrevision();
                        ModelMeteo.City city = response.body().getCity();

                        nomVille.setText(city.getName());
                        ciel.setText(data.get(0).getWeather().get(0).getMain());
                        temperature.setText(data.get(0).getMain().getTemp());
                        minTemp.setText(data.get(0).getMain().getTemp_min());
                        maxTemp.setText(data.get(0).getMain().getTemp_max());
                        vitesseVent.setText(data.get(0).getWind().getSpeed());
                        humidite.setText(data.get(0).getMain().getHumidity());
                        hpa.setText(data.get(0).getMain().getPressure());
                    }

                    @Override
                    public void onFailure(Call<ModelMeteo> call, Throwable t) {

                    }
                });
            }
        });


        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                // La méthode appelée lorsque la localisation est mise à jour
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();

                Toast.makeText(MainActivity.this, "Latitude: " + latitude + "\nLongitude: " + longitude, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            @Override
            public void onProviderEnabled(String provider) {
            }

            @Override
            public void onProviderDisabled(String provider) {
            }
        };

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Demander la permission
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSION_REQUEST_CODE);
        } else {
            // Permission déjà accordée, commencez à écouter les mises à jour de localisation
            startListening();
        }
    }
    private void startListening() {
        // Vérifier à nouveau la permission pour les versions Android 6.0 et supérieures
        if (Build.VERSION.SDK_INT < 23 ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission accordée, commencez à écouter les mises à jour de localisation
                startListening();
            } else {
                // Permission refusée, vous pouvez informer l'utilisateur ou demander à nouveau la permission
            }
        }
    }
}