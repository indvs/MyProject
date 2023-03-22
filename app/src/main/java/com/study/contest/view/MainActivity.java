package com.study.contest.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.study.contest.R;


public class MainActivity extends AppCompatActivity {
    public static final String EMAIL_ERROR = "Почта не может быть пустой";
    public static final String PASSWORD_ERROR = "Пароль не может быть пустым";
    public static final String CANT_LOGIN = "Неправильный пароль или логин";
    private Button loginButton;
    private FirebaseAuth firebaseAuth;
    private Intent firstPage;
    private EditText etEmail;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseApp.initializeApp(MainActivity.this);

        loginButton = findViewById(R.id.logInButton);
        etEmail = findViewById(R.id.emailTextEdit);
        etPassword = findViewById(R.id.editTextPassword);

        firstPage = new Intent(this, MainPage.class);

        firebaseAuth = FirebaseAuth.getInstance();

        loginButton.setOnClickListener(view -> loginUser());
    }


    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser != null) {
            startActivity(firstPage);
        }
    }

    private void loginUser() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString();

        if (TextUtils.isEmpty(email)) {
            etEmail.setError(EMAIL_ERROR);
            etEmail.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            etPassword.setError(PASSWORD_ERROR);
            etPassword.requestFocus();
        } else {
            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            startActivity(firstPage);
                        } else if (task.isComplete()) {
                            etPassword.setError(CANT_LOGIN);
                        }
                    }
            );
        }


    }


}