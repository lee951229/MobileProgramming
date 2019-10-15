package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import android.util.Log;


public class SecondActivity extends AppCompatActivity  {


    /* boolean idCheck; //id 중복체크
    boolean btnCheck = false;
    Button btnEmailCheck
     */
    EditText editEmail;
    boolean btnPw = false; // 비밀번호 여부 확인
    Button btnSignup, btnCancel, btnPwCheck;
    RadioButton rd_btn;

    @Override
    public void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // btnEmailCheck = (Button)findViewById(R.id.btnEmailCheck); //중복체크 버튼

        btnSignup = (Button)findViewById(R.id.btnSignup);
        btnCancel = (Button)findViewById(R.id.btnCancel);
        rd_btn = (RadioButton)findViewById(R.id.rd_btn);

        File files = new File(getFilesDir()+"userInfo.txt");

        //파일이 존재하지 않는 경우, 새로운 파일 생성
        if(files.exists()==false) {
            try{
                BufferedWriter bw = new BufferedWriter(new FileWriter(getFilesDir() + "userInfo.txt", true));
                bw.write("");
                bw.close();
            }catch (Exception e){
                e.printStackTrace();
                Log.i("에러 메세지", "error");
            }
        }

        /*
        btnEmailCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }

        }); */

        btnPwCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPw = true;

                EditText editPw = (EditText)findViewById(R.id.editPw);
                String pw = editPw.getText().toString();
                EditText editPwConfirm = (EditText)findViewById(R.id.editPwConfirm);
                String pwConfirm = editPwConfirm.getText().toString();

                if(pw.equals("") == true) {
                    Toast.makeText(getApplicationContext(), "아이디를 입력해주세요.", Toast.LENGTH_LONG).show();
                    return;
                }
                else if(!pw.equals(pwConfirm)) {
                    Toast.makeText(getApplicationContext(), "비밀번호가 일치하지 않습니다.", Toast.LENGTH_LONG).show();
                }


            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //중복확인
               /* if(btnCheck == false) {
                    Toast.makeText(getApplicationContext(), "중복확인을 해주세요.", Toast.LENGTH_LONG).show();
                }
                */

                if(btnPw == false) {
                    Toast.makeText(getApplicationContext(), "비밀번호를 확인해주세요", Toast.LENGTH_LONG).show();
                }
                else if(!rd_btn.isChecked()) {
                    Toast.makeText(getApplicationContext(), "이용약관에 동의해주세요.", Toast.LENGTH_LONG).show();
                }
                else {

                    Toast.makeText(getApplicationContext(), "회원가입에 성공했습니다.", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }

                Intent result = new Intent();
                result.putExtra("email", editEmail.getText().toString());
                setResult(RESULT_OK, result);
                finish();
            }
        });
    }
}
