package com.example.finddoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

    }

    public void ShowDoctora(View view) {
        Intent i = new Intent(getApplicationContext(), DoctoraActivity.class);
        startActivity(i);
    }

    public void ShowDoctorb(View view) {
        Intent i = new Intent(getApplicationContext(), DoctorbActivity.class);
        startActivity(i);
    }

    public void ShowDoctorc(View view) {
        Intent i = new Intent(getApplicationContext(), DoctorcActivity.class);
        startActivity(i);
    }

}