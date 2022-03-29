package com.geermank.todoapp.settings;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

public class UserCredentials {

    private static final String USER_CREDENTIALS_FILE_NAME = "USER_CREDENTIALS_FILE_NAME";
    private static final String USER_EMAIL = "USER_EMAIL";
    private static final String USER_PASS = "USER_PASS";

    private final SharedPreferences preferences;

    public UserCredentials(Context context) {
        preferences = context.getSharedPreferences(USER_CREDENTIALS_FILE_NAME, Context.MODE_PRIVATE);
    }

    public boolean isUserLogged() {
        String email = preferences.getString(USER_EMAIL, null);
        String password = preferences.getString(USER_PASS, null);
        return email != null && password != null;
    }

    public void saveUserCredentials(@NonNull String email, @NonNull String password) {
        if (email == null || password == null) {
            return;
        }
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(USER_EMAIL, email)
                .putString(USER_PASS, password)
                .apply();
    }

    public void delete() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear().apply();
    }
}
