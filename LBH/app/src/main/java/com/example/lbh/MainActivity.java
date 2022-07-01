package com.example.lbh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lbh.Anggota.AnggotaActivity;

public class MainActivity extends AppCompatActivity {

    Button btnAnggota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAnggota = (Button) findViewById(R.id.btnAnggota);
        btnAnggota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AnggotaActivity.class));
            }
        });
    }
}