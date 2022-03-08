package com.geermank.todoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvWelcomeMessage;
    private EditText etEmail, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvWelcomeMessage = findViewById(R.id.tv_welcome_message);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toastMessage = getString(R.string.login_in);
                Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_login) {
            /*
            String toastMessage = getString(R.string.login_in);
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
             */
            tvWelcomeMessage.setBackgroundColor(ContextCompat.getColor(this, R.color.black));
            login();
        }
    }

    private void login() {
        String email = etEmail.getText().toString();
        Toast.makeText(this, email, Toast.LENGTH_SHORT).show();
    }
}
