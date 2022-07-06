package com.example.lbh.Anggota;

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

import com.example.lbh.Anggota.Model.ManageAnggotaModel;
import com.example.lbh.Rest.ApiClient;
import com.example.lbh.Rest.ApiInterface;
import com.example.lbh.R;

public class UpdateAnggotaActivity extends AppCompatActivity {

    EditText etIdAnggota, etNpm, etNama, etNoHp, etEmail, etAngkatan, etJabatan;
    Button btUpdate, btDelete, btBack;
    ApiInterface mApiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_anggota);
        etIdAnggota = (EditText) findViewById(R.id.etIdAnggota);
        etNpm = (EditText) findViewById(R.id.etNpm);
        etNama = (EditText) findViewById(R.id.etNama);
        etNoHp = (EditText) findViewById(R.id.etNoHp);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etAngkatan = (EditText) findViewById(R.id.etAngkatan);
        etJabatan = (EditText) findViewById(R.id.etJabatan);

        Intent mIntent = getIntent();
        etIdAnggota.setText(mIntent.getStringExtra("Id_anggota"));
        etIdAnggota.setTag(etIdAnggota.getKeyListener());
        etIdAnggota.setKeyListener(null);
        etNpm.setText(mIntent.getStringExtra("Npm"));
        etNpm.setTag(etNpm.getKeyListener());
        etNpm.setKeyListener(null);
        etNama.setText(mIntent.getStringExtra("Nama"));
        etNoHp.setText(mIntent.getStringExtra("No_hp"));
        etEmail.setText((mIntent.getStringExtra("Email")));
        etAngkatan.setText(mIntent.getStringExtra("Angkatan"));
        etJabatan.setText(mIntent.getStringExtra("Jabatan"));

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btUpdate = (Button) findViewById(R.id.btUpdate2);
        btDelete = (Button) findViewById(R.id.btDelete2);

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<ManageAnggotaModel> updateAnggotaCall = mApiInterface.putAnggota(
                        etIdAnggota.getText().toString(),
                        etNpm.getText().toString(),
                        etNama.getText().toString(),
                        etNoHp.getText().toString(),
                        etEmail.getText().toString(),
                        etAngkatan.getText().toString(),
                        etJabatan.getText().toString());
                updateAnggotaCall.enqueue(new Callback<ManageAnggotaModel>() {
                    @Override
                    public void onResponse(Call<ManageAnggotaModel> call, Response<ManageAnggotaModel>
                            response) {
                        AnggotaActivity.aa.refresh();
                        finish();
                    }
                    @Override
                    public void onFailure(Call<ManageAnggotaModel> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error : ",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etIdAnggota.getText().toString().trim().isEmpty()==false){
                    Call<ManageAnggotaModel> deleteAnggota =
                            mApiInterface.deleteAnggota(etIdAnggota.getText().toString());
                    deleteAnggota.enqueue(new Callback<ManageAnggotaModel>() {
                        @Override
                        public void onResponse(Call<ManageAnggotaModel> call, Response<ManageAnggotaModel>
                                response) {
                            AnggotaActivity.aa.refresh();
                            finish();
                        }
                        @Override
                        public void onFailure(Call<ManageAnggotaModel> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Error",
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                }else{
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
            }
        });
        btBack = (Button) findViewById(R.id.btBackGo);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnggotaActivity.aa.refresh();
                finish();
            }
        });
    }
}