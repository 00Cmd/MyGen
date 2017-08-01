package com.example.macbookair.mygen.Activitys;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.macbookair.mygen.R;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private ImageView logo;
    private TextView appName;
    private TextInputLayout name, pass;
    private Button btnLogin, btnRegister;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        find();
    }

    private void find() {
        logo = (ImageView) findViewById(R.id.login_logo);
        appName = (TextView) findViewById(R.id.login_welcome_app_name);
        name = (TextInputLayout) findViewById(R.id.login_email_inputLayout);
        pass = (TextInputLayout) findViewById(R.id.login_password_inputLayout);
        btnLogin = (Button) findViewById(R.id.login_btn_login);
        btnRegister = (Button) findViewById(R.id.login_register_btn);
    }

    private void onClickActions() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Ref to db
                //Check user
                String userName = "";
                String userPass = "";
                userName = name.getEditText().getText().toString();
                userPass = pass.getEditText().getText().toString();
            }
        });
    }
}
