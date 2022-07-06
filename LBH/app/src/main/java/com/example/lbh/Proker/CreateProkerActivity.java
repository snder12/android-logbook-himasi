package com.example.lbh.Proker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.lbh.Anggota.AnggotaActivity;
import com.example.lbh.MainActivity;
import com.example.lbh.Proker.Model.ManageProkerModel;
import com.example.lbh.Rest.ApiClient;
import com.example.lbh.Rest.ApiInterface;

import com.example.lbh.R;

public class CreateProkerActivity extends AppCompatActivity {

    EditText etIdProker, etNamaProker, etKetuaPelaksana, etTanggal, etDeskripsi;
    Button btnInsert, btnBack;
    ApiInterface mApiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_proker);
        etIdProker = (EditText) findViewById(R.id.etIdProker);
        etNamaProker = (EditText) findViewById(R.id.etNamaProker);
        etKetuaPelaksana = (EditText) findViewById(R.id.etKetuaPelaksana);
        etTanggal = (EditText) findViewById(R.id.etTanggal);
        etDeskripsi = (EditText) findViewById(R.id.etDeskripsi);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btnInsert = (Button) findViewById(R.id.btnInserting);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<ManageProkerModel> postProkerCall =
                        mApiInterface.postProker(etIdProker.getText().toString(), etNamaProker.getText().toString(),
                                etKetuaPelaksana.getText().toString(), etTanggal.getText().toString(), etDeskripsi.getText().toString());
                postProkerCall.enqueue(new Callback<ManageProkerModel>() {
                    @Override
                    public void onResponse(Call<ManageProkerModel> call,
                                           Response<ManageProkerModel> response) {
                        ProkerActivity.pa.refresh();
                        finish();
                    }
                    @Override
                    public void onFailure(Call<ManageProkerModel> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        btnBack = (Button) findViewById(R.id.btnBackGo);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProkerActivity.pa.refresh();
                finish();
            }
        });
    }
}