package com.example.finddoctor;

import static android.provider.Telephony.Mms.Part.NAME;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class DashboardActivity extends AppCompatActivity {
    TextView nameText;
    Button doctorSatu;
    BottomNavigationView bottomNavigation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        nameText = findViewById(R.id.hitext);
        doctorSatu = findViewById(R.id.doctora);

        bottomNavigation =findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()){
                    case R.id.nav_home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.nav_courses:
                        selectedFragment = new DoctorFragment();
                        break;
                    case R.id.nav_about:
                        selectedFragment = new HospitalFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                return true;
            }
        });


//        Intent dashboard = getIntent();
//        String name = dashboard.getStringExtra(NAME);
//        nameText.setText("Hi" + name + "!");
    }

    public void ShowDoctor(View view) {
        Intent i = new Intent(getApplicationContext(), DoctorActivity.class);
        startActivity(i);
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
    public void ShowHospitala(View view) {
        String source = "Kampus Bukit Jimbaran";
        String destination = "Rumah Sakit Sanglah";

        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/dir/"+source+
                "/" + destination));
        startActivity(i);
    }
    public void ShowHospitalb(View view) {
        String source = "Kampus Bukit Jimbaran";
        String destination = "Rumah Sakit Surya Husada";

        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/dir/"+source+
                "/" + destination));
        startActivity(i);
    }
    public void ShowHospitalc(View view) {
        String source = "Kampus Bukit Jimbaran";
        String destination = "Rumah Sakit Prima Medika";


        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/dir/"+source+
                "/" + destination));
        startActivity(i);
    }

    public void ShowHospital(View view) {
        Intent i = new Intent(getApplicationContext(), HospitalActivity.class);
        startActivity(i);
    }

    public void ShowMedicine(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.guesehat.com/info-obat"));
        startActivity(intent);
    }

    public void ShowCovid(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/results?search_query=covid+indonesia+terkini"));
        startActivity(intent);
    }
}