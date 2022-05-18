package com.example.finddoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class HospitalActivity extends AppCompatActivity {

    private Button eLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);
        eLocation = findViewById(R.id.Location1);
        //ELOCATION ITU REDIRECT KE LOKASI DENGAN GOOGLE MAPS
    }
}