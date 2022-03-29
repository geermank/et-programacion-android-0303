package com.geermank.todoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.geermank.todoapp.main.MainActivity;
import com.geermank.todoapp.settings.UserCredentials;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvWelcomeMessage, tvTermsAndConditions;
    private EditText etEmail, etPassword;
    private Button btnLogin;
    private AppCompatCheckBox cbRememberCredentials;

    private UserCredentials userCredentials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userCredentials = new UserCredentials(this);

        tvWelcomeMessage = findViewById(R.id.tv_welcome_message);
        tvTermsAndConditions = findViewById(R.id.tv_terms_and_conditions);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        cbRememberCredentials = findViewById(R.id.cb_remember_credentials);

        btnLogin.setOnClickListener(this);
        tvTermsAndConditions.setOnClickListener(this);

        checkIfUserHadSavedCredentials();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_login) {
            login();
        } else if (v.getId() == R.id.tv_terms_and_conditions) {
            openTermsAndConditions();
        }
    }

    private void checkIfUserHadSavedCredentials() {
        if (userCredentials.isUserLogged()) {
            navigateToMainActivity();
        }
    }

    private void login() {
        saveUserCredentials();
        navigateToMainActivity();
    }

    private void saveUserCredentials() {
        if (!cbRememberCredentials.isChecked()) {
            return;
        }
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        userCredentials.saveUserCredentials(email, password);
    }

    private void navigateToMainActivity() {
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
        finish();
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
