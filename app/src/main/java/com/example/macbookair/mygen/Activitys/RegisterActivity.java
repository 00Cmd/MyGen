package com.example.macbookair.mygen.Activitys;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.macbookair.mygen.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {
    private ImageView logo;
    private TextView appName;
    private TextInputLayout name,mail,pass;
    private Button signup,login;
    private DatabaseReference mRef;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        find();
        onClickActions();
    }

    private void onClickActions() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = "";
                String userMail = "";
                String userPass = "";


                if(!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(userMail) && !TextUtils.isEmpty(userPass)) {

                    userName = name.getEditText().getText().toString();
                    userMail = mail.getEditText().getText().toString();
                    userPass = pass.getEditText().getText().toString();

                    registerUser(userName,userMail,userPass);

                }
            }
        });
    }

    private void registerUser(final String name, final String mail, String pass) {
        mAuth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    FirebaseUser user = mAuth.getCurrentUser();
                    String uid = user.getUid();
                    mRef = FirebaseDatabase.getInstance().getReference().child("Users").child(uid);
                    HashMap<String, String> userMap = new HashMap<String, String>();
                    userMap.put("Name", name);
                    userMap.put("Email", mail);
                    mRef.setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()) {
                                Intent i = new Intent(RegisterActivity.this, MainActivity.class);
                                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(i);
                            } else {
                                Toast.makeText(RegisterActivity.this, "Something went wrong.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });


    }



    private void find() {
        logo = (ImageView) findViewById(R.id.signup_logo);
        appName = (TextView) findViewById(R.id.signup_welcome_app_name);
        name = (TextInputLayout) findViewById(R.id.signup_name_inputLayout);
        mail = (TextInputLayout) findViewById(R.id.signup_email_inputLayout);
        pass = (TextInputLayout) findViewById(R.id.signup_password_inputLayout);
        signup = (Button)findViewById(R.id.signup_btn_signup);
        login = (Button)findViewById(R.id.signup_login_btn);
    }


}
