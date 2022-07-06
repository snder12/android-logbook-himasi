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

    EditText edtIdAnggota, edtNpm, edtNama, edtNoHp, edtEmail, edtAngkatan, edtJabatan;
    Button btUpdate, btDelete, btBack;
    ApiInterface mApiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_anggota);
        edtIdAnggota = (EditText) findViewById(R.id.edtIdAnggota);
        edtNpm = (EditText) findViewById(R.id.edtNpm);
        edtNama = (EditText) findViewById(R.id.edtNama);
        edtNoHp = (EditText) findViewById(R.id.edtNoHp);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtAngkatan = (EditText) findViewById(R.id.edtAngkatan);
        edtJabatan = (EditText) findViewById(R.id.edtJabatan);

        Intent mIntent = getIntent();
        edtIdAnggota.setText(mIntent.getStringExtra("Id_anggota"));
        edtIdAnggota.setTag(edtIdAnggota.getKeyListener());
        edtIdAnggota.setKeyListener(null);
        edtNpm.setText(mIntent.getStringExtra("Npm"));
        edtNpm.setTag(edtNpm.getKeyListener());
        edtNpm.setKeyListener(null);
        edtNama.setText(mIntent.getStringExtra("Nama"));
        edtNoHp.setText(mIntent.getStringExtra("No_hp"));
        edtEmail.setText((mIntent.getStringExtra("Email")));
        edtAngkatan.setText(mIntent.getStringExtra("Angkatan"));
        edtJabatan.setText(mIntent.getStringExtra("Jabatan"));

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btUpdate = (Button) findViewById(R.id.btUpdate2);
        btDelete = (Button) findViewById(R.id.btDelete2);

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<ManageAnggotaModel> updateAnggotaCall = mApiInterface.putAnggota(
                        edtIdAnggota.getText().toString(),
                        edtNpm.getText().toString(),
                        edtNama.getText().toString(),
                        edtNoHp.getText().toString(),
                        edtEmail.getText().toString(),
                        edtAngkatan.getText().toString(),
                        edtJabatan.getText().toString());
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
                if (edtIdAnggota.getText().toString().trim().isEmpty()==false){
                    Call<ManageAnggotaModel> deleteAnggota =
                            mApiInterface.deleteAnggota(edtIdAnggota.getText().toString());
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