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

    EditText edtIdProker, edtNamaProker, edtTanggal, edtDeskripsi;
    Button btInsert, btBack;
    ApiInterface mApiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_proker);
        edtIdProker = (EditText) findViewById(R.id.edtIdProker);
        edtNamaProker = (EditText) findViewById(R.id.edtNamaProker);
        edtTanggal = (EditText) findViewById(R.id.edtTanggal);
        edtDeskripsi = (EditText) findViewById(R.id.edtDeskripsi);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btInsert = (Button) findViewById(R.id.btInserting);
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<ManageProkerModel> postProkerCall =
                        mApiInterface.postProker(edtIdProker.getText().toString(), edtNamaProker.getText().toString(),
                                edtTanggal.getText().toString(), edtDeskripsi.getText().toString());
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
        btBack = (Button) findViewById(R.id.btBackGo);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProkerActivity.pa.refresh();
                finish();
            }
        });
    }
}