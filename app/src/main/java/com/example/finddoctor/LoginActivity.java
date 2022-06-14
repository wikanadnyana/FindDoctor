package com.example.finddoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    /* Define the UI elements */
    private EditText eName;
    private EditText ePassword;
    private Button eLogin;

    String userName = "";
    String userPassword = "";

    /* Class to hold credentials */
    class Credentials
    {
        String name = "Wikan";
        String password = "123456";
    }

    boolean isValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /* Bind the XML views to Java Code Elements */
        eName = findViewById(R.id.username);
        ePassword = findViewById(R.id.password);
        eLogin = findViewById(R.id.btnlogin);

        /* Describe the logic when the login button is clicked */
        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* Obtain user inputs */
                userName = eName.getText().toString();
                userPassword = ePassword.getText().toString();

                /* Check if the user inputs are empty */
                if(userName.isEmpty() || userPassword.isEmpty())
                {
                    /* Display a message toast to user to enter the details */
                    Toast.makeText(LoginActivity.this, "Please enter name and password!", Toast.LENGTH_LONG).show();

                }else {

                    /* Validate the user inputs */
                    isValid = validate(userName, userPassword);

                    /* Validate the user inputs */

                    /* If not valid */
                    if (!isValid) {
                        Toast.makeText(LoginActivity.this, "Incorrect credentials, please try again!", Toast.LENGTH_LONG).show();
                    }
                    /* If valid */
                    else {

                        String userName = eName.getText().toString();
                        Intent dashboard = new Intent(LoginActivity.this, DashboardActivity.class);
                        dashboard.putExtra("dataUsername",userName);
                        startActivity(dashboard);
                        eName.getText().clear();
                        ePassword.getText().clear();
                    }

                }
            }
        });
    }

    /* Validate the credentials */
    private boolean validate(String userName, String userPassword)
    {
        /* Get the object of Credentials class */
        Credentials credentials = new Credentials();

        /* Check the credentials */
        if(userName.equals(credentials.name) && userPassword.equals(credentials.password))
        {
            return true;
        }

        return false;
    }

    public void register(View view) {
        Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(i);
    }
}