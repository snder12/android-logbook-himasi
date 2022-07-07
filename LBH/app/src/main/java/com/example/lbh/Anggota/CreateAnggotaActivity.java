package com.example.lbh.Anggota;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.lbh.Anggota.Model.ManageAnggotaModel;
import com.example.lbh.Rest.ApiClient;
import com.example.lbh.Rest.ApiInterface;

import com.example.lbh.R;

public class CreateAnggotaActivity extends AppCompatActivity {

    EditText etNoAnggota, etNpm, etNama, etNoHp, etEmail, etAngkatan, etJabatan, etLevel;
    Button btnInsert, btnBack;
    ApiInterface mApiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_anggota);
        etNoAnggota = (EditText) findViewById(R.id.etNoAnggota);
        etNpm = (EditText) findViewById(R.id.etNpm);
        etNama = (EditText) findViewById(R.id.etNama);
        etNoHp = (EditText) findViewById(R.id.etNoHp);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etAngkatan = (EditText) findViewById(R.id.etAngkatan);
        etJabatan = (EditText) findViewById(R.id.etJabatan);
        etLevel = (EditText) findViewById(R.id.etLevel);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btnInsert = (Button) findViewById(R.id.btnInserting);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<ManageAnggotaModel> postAnggotaCall =
                        mApiInterface.postAnggota(etNoAnggota.getText().toString(), etNpm.getText().toString(),
                                etNama.getText().toString(), etNoHp.getText().toString(), etEmail.getText().toString(),
                                etAngkatan.getText().toString(), etJabatan.getText().toString(), etLevel.getText().toString());
                postAnggotaCall.enqueue(new Callback<ManageAnggotaModel>() {
                    @Override
                    public void onResponse(Call<ManageAnggotaModel> call,
                                           Response<ManageAnggotaModel> response) {
                        AnggotaActivity.aa.refresh();
                        finish();
                    }
                    @Override
                    public void onFailure(Call<ManageAnggotaModel> call, Throwable t) {
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
                AnggotaActivity.aa.refresh();
                finish();
            }
        });
    }
}