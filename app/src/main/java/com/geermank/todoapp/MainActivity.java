package com.geermank.todoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvWelcomeMessage, tvTermsAndConditions;
    private EditText etEmail, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvWelcomeMessage = findViewById(R.id.tv_welcome_message);
        tvTermsAndConditions = findViewById(R.id.tv_terms_and_conditions);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(this);
        tvTermsAndConditions.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_login) {
            login();
        } else if (v.getId() == R.id.tv_terms_and_conditions) {
            openTermsAndConditions();
        }
    }

    private void login() {
        String email = etEmail.getText().toString();
        Toast.makeText(this, email, Toast.LENGTH_SHORT).show();
    }

    private void openTermsAndConditions() {
        Intent termsAndConditionsIntent = new Intent(this, TermsAndConditionsActivity.class);
        // Parcelable
        termsAndConditionsIntent.putExtra("name", "Germán");
        termsAndConditionsIntent.putExtra("age", 27);
        termsAndConditionsIntent.putExtra("weight", 70f);

        startActivity(termsAndConditionsIntent);
        // finish();
    }
}
