package com.example.finddoctor;

import static android.provider.Telephony.Mms.Part.NAME;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    private EditText eName;
    private Button eRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        eName = findViewById(R.id.username);
        eRegister = findViewById(R.id.btnregister);

        eRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String userName = eName.getText().toString();
                Intent dashboard = new Intent(RegisterActivity.this, DashboardActivity.class);
                dashboard.putExtra("dataUsername",userName);
                startActivity(dashboard);
            }
        });

    }
}