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
import com.example.lbh.Anggota.Rest.ApiClient;
import com.example.lbh.Anggota.Rest.ApiInterface;

import com.example.lbh.R;

public class CreateAnggotaActivity extends AppCompatActivity {

    EditText edtNoAnggota, edtNpm, edtNama, edtNoHp;
    Button btInsert, btBack;
    ApiInterface mApiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_anggota);
        edtNoAnggota = (EditText) findViewById(R.id.edtNoAnggota);
        edtNpm = (EditText) findViewById(R.id.edtNpm);
        edtNama = (EditText) findViewById(R.id.edtNama);
        edtNoHp = (EditText) findViewById(R.id.edtNoHp);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btInsert = (Button) findViewById(R.id.btInserting);
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<ManageAnggotaModel> postAnggotaCall =
                        mApiInterface.postAnggota(edtNoAnggota.getText().toString(), edtNpm.getText().toString(),
                                edtNama.getText().toString(), edtNoHp.getText().toString());
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
    }
}