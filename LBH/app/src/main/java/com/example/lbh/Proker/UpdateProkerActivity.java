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

import com.example.lbh.Proker.Model.ManageProkerModel;
import com.example.lbh.Rest.ApiClient;
import com.example.lbh.Rest.ApiInterface;
import com.example.lbh.R;

public class UpdateProkerActivity extends AppCompatActivity {

    EditText etIdProker, etNamaProker, etKetuaPelaksana, etTanggal, etDeskripsi;
    Button btnUpdate, btnDelete, btnBack;
    ApiInterface mApiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_proker);
        etIdProker = (EditText) findViewById(R.id.etIdProker);
        etNamaProker = (EditText) findViewById(R.id.etNamaProker);
        etKetuaPelaksana = (EditText) findViewById(R.id.etKetuaPelaksana);
        etTanggal = (EditText) findViewById(R.id.etTanggal);
        etDeskripsi = (EditText) findViewById(R.id.etDeskripsi);

        Intent mIntent = getIntent();
        etIdProker.setText(mIntent.getStringExtra("Id_Proker"));
        etIdProker.setTag(etIdProker.getKeyListener());
        etIdProker.setKeyListener(null);
        etNamaProker.setText(mIntent.getStringExtra("Nama_Proker"));
        etKetuaPelaksana.setText(mIntent.getStringExtra("Ketua_Pelaksana"));
        etTanggal.setText(mIntent.getStringExtra("Tanggal"));
        etDeskripsi.setText(mIntent.getStringExtra("Deskripsi"));

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btnUpdate = (Button) findViewById(R.id.btnUpdate2);
        btnDelete = (Button) findViewById(R.id.btnDelete2);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<ManageProkerModel> updateProkerCall = mApiInterface.putProker(
                        etIdProker.getText().toString(),
                        etNamaProker.getText().toString(),
                        etKetuaPelaksana.getText().toString(),
                        etTanggal.getText().toString(),
                        etDeskripsi.getText().toString());
                updateProkerCall.enqueue(new Callback<ManageProkerModel>() {
                    @Override
                    public void onResponse(Call<ManageProkerModel> call, Response<ManageProkerModel>
                            response) {
                        ProkerActivity.pa.refresh();
                        finish();
                    }
                    @Override
                    public void onFailure(Call<ManageProkerModel> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error : ",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etIdProker.getText().toString().trim().isEmpty()==false){
                    Call<ManageProkerModel> deleteProker =
                            mApiInterface.deleteProker(etIdProker.getText().toString());
                    deleteProker.enqueue(new Callback<ManageProkerModel>() {
                        @Override
                        public void onResponse(Call<ManageProkerModel> call, Response<ManageProkerModel>
                                response) {
                            ProkerActivity.pa.refresh();
                            finish();
                        }
                        @Override
                        public void onFailure(Call<ManageProkerModel> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Error",
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                }else{
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
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