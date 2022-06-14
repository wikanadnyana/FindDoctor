package com.example.finddoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DoctorbActivity extends AppCompatActivity {
    Button sendbtn, antrianbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorb);
        sendbtn = findViewById(R.id.doctorb);
        antrianbtn = findViewById(R.id.antrianb);
        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String messagestr = "Hallo, Dokter";
                String phonestr = "+6285935098770";

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone="+phonestr+
                        "&text="+messagestr));
                startActivity(i);


            }
        });
        antrianbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String doctorb = "Dr. Andi";
                Intent intent = new Intent(DoctorbActivity.this, BuatAntrianActivity.class);
                intent.putExtra("dokterINTENT", doctorb);
                startActivity(intent);
            }
        });
    }
}