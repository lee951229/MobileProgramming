package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button btnSignup, btnLogin;
    EditText editEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        btnSignup = (Button) findViewById(R.id.btnSignup);
        btnLogin = (Button)findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                Toast.makeText(getApplicationContext(), "로그인에 성공하였습니다.", Toast.LENGTH_LONG).show();
                startActivity(intent);

            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivityForResult(intent, 1000);

            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        Log.d("RESULT", requestCode + "");
        Log.d("RESULT", resultCode + "");
        Log.d("RESULT", data + "");

        if(requestCode == 1000 && resultCode == RESULT_OK) {
            Toast.makeText(MainActivity.this, "회원가입을 완료했습니다!", Toast.LENGTH_SHORT).show();
            editEmail.setText(data.getStringExtra("email"));
        }
    }
}


