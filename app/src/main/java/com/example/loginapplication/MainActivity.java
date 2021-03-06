package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
      private EditText eName, ePassword;      //defining variabels
      private Button eLogin;
      private TextView eAttemptInfo;
      private final String Username= "Sachin", Password="12345";
      boolean isvalid= false;
      private int count=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eName= findViewById(R.id.etName);
        ePassword= findViewById(R.id.etPassword);
        eLogin=findViewById(R.id.btnLogin);
        eAttemptInfo= findViewById(R.id.etAttemptCounter);
        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputName= eName.getText().toString();
                String inputPassword= ePassword.getText().toString();
                if(inputName.isEmpty()|| inputPassword.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter all the details", Toast.LENGTH_SHORT).show();
                }
                else{
                    isvalid= validate(inputName,inputPassword);
                    if(!isvalid)
                    {
                        count--;
                        Toast.makeText(MainActivity.this, "Incorrect Details", Toast.LENGTH_SHORT).show();
                        eAttemptInfo.setText("Number of Attempts remaining: "+count);
                        if(count==0)
                        {
                            eLogin.setEnabled(false);
                        }
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(MainActivity.this, HomePageActivity.class);
                        startActivity(intent);
                }}
            }
        });

    }
    private boolean validate(String name, String password){
        if(name.equals(Username) && password.equals(Password)){
            return true;
        }
        else
            return false;
    }
}