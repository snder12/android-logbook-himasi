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

    EditText edtIdProker, edtNamaProker, edtTanggal, edtDeskripsi;
    Button btUpdate, btDelete, btBack;
    ApiInterface mApiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_proker);
        edtIdProker = (EditText) findViewById(R.id.edtIdProker);
        edtNamaProker = (EditText) findViewById(R.id.edtNamaProker);
        edtTanggal = (EditText) findViewById(R.id.edtTanggal);
        edtDeskripsi = (EditText) findViewById(R.id.edtDeskripsi);

        Intent mIntent = getIntent();
        edtIdProker.setText(mIntent.getStringExtra("Id_Proker"));
        edtIdProker.setTag(edtIdProker.getKeyListener());
        edtIdProker.setKeyListener(null);
        edtNamaProker.setText(mIntent.getStringExtra("Nama_Proker"));
        edtTanggal.setText(mIntent.getStringExtra("Tanggal"));
        edtDeskripsi.setText(mIntent.getStringExtra("Deskripsi"));

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btUpdate = (Button) findViewById(R.id.btUpdate2);
        btDelete = (Button) findViewById(R.id.btDelete2);

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<ManageProkerModel> updateProkerCall = mApiInterface.putProker(
                        edtIdProker.getText().toString(),
                        edtNamaProker.getText().toString(),
                        edtTanggal.getText().toString(),
                        edtDeskripsi.getText().toString());
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
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtIdProker.getText().toString().trim().isEmpty()==false){
                    Call<ManageProkerModel> deleteProker =
                            mApiInterface.deleteProker(edtIdProker.getText().toString());
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