package com.example.lbh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lbh.About.AboutActivity;
import com.example.lbh.Anggota.AnggotaActivity;
import com.example.lbh.Login.LoginActivity;
import com.example.lbh.Proker.ProkerActivity;
import com.example.lbh.Staf.StafActivity;

public class MainActivity extends AppCompatActivity {

    Button btnAnggota, btnLogout, btnProker, btnStaf, btnAbout;
    SessionManager sessionManager;
    TextView tvUsername, tvIdUser;
    String username, id_users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(MainActivity.this);
        if(!sessionManager.isLoggedIn()){
            moveToLogin();
        }

        tvIdUser = findViewById(R.id.tvMainUserId);
        tvUsername = findViewById(R.id.tvMainUsername);

        id_users = sessionManager.getUserDetail().get(SessionManager.ID_USERS);
        username = sessionManager.getUserDetail().get(SessionManager.USERNAME);

        tvIdUser.setText(id_users);
        tvUsername.setText(username);

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

        btnStaf = (Button)findViewById(R.id.btnStaf);
        btnStaf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StafActivity.class));
            }
        });

        btnAbout = (Button)findViewById(R.id.btnAbout);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
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