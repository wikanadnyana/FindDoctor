package com.example.finddoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DoctoraActivity extends AppCompatActivity {
    Button sendbtn, antrianbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctora);

        sendbtn = findViewById(R.id.doctora);
        antrianbtn = findViewById(R.id.antrian);
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
                String doctora = "Dr. Nugraha";
                Intent intent = new Intent(DoctoraActivity.this, BuatAntrianActivity.class);
                intent.putExtra("dokterINTENT", doctora);
                startActivity(intent);
            }
        });
    }
}