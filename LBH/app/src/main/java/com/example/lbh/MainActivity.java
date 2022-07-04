package com.example.lbh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lbh.Anggota.AnggotaActivity;
import com.example.lbh.Login.LoginActivity;
import com.example.lbh.Proker.ProkerActivity;

public class MainActivity extends AppCompatActivity {

    Button btnAnggota, btnLogout, btnProker;
    SessionManager sessionManager;
    TextView etUsername, etUserId;
    String username, user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(MainActivity.this);
        if(!sessionManager.isLoggedIn()){
            moveToLogin();
        }

        etUserId = findViewById(R.id.etMainUserId);
        etUsername = findViewById(R.id.etMainUsername);

        user_id = sessionManager.getUserDetail().get(SessionManager.USER_ID);
        username = sessionManager.getUserDetail().get(SessionManager.USERNAME);

        etUserId.setText(user_id);
        etUsername.setText(username);

        btnAnggota = (Button) findViewById(R.id.btnAnggota);
        btnAnggota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AnggotaActivity.class));
            }
        });

        btnProker = (Button) findViewById(R.id.btnProker);
        btnProker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProkerActivity.class));
            }
        });

        btnLogout = (Button) findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.logoutSession();
                finish();
                moveToLogin();
            }
        });

    }

    private void moveToLogin() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }
}