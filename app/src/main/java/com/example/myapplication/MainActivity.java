package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = (EditText)findViewById(R.id.name);
        Password = (EditText)findViewById(R.id.sapid);
        Login = (Button)findViewById(R.id.login);
        Info = (TextView)findViewById(R.id.count);

        Info.setText("Max Attempts's: 5");
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });
    }
    private void validate(String userName, String userPassword)
    {
        if((userName.equals("admin")) && (userPassword.equals("admin"))){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }
        else{
            counter--;

            Info.setText("Max Attempt's: " + String.valueOf(counter));

            if(counter == 0)
                Login.setEnabled(false);
        }

    }
}