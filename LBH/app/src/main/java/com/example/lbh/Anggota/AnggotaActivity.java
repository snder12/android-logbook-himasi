package com.example.lbh.Anggota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.lbh.Anggota.Adapter.AnggotaAdapter;
import com.example.lbh.Anggota.Model.AnggotaModel;
import com.example.lbh.Anggota.Model.GetAnggotaModel;
import com.example.lbh.Rest.ApiClient;
import com.example.lbh.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.lbh.R;

public class AnggotaActivity extends AppCompatActivity {

    Button btIns;
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static AnggotaActivity aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anggota);
        btIns = (Button) findViewById(R.id.btIns);
        btIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AnggotaActivity.this,
                        CreateAnggotaActivity.class));
            }
        });
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        aa=this;
        refresh();
    }
    public void refresh() {
        Call<GetAnggotaModel> anggotaCall = mApiInterface.getAnggota();
        anggotaCall.enqueue(new Callback<GetAnggotaModel>() {
            @Override
            public void onResponse(Call<GetAnggotaModel> call, Response<GetAnggotaModel> response) {
                List<AnggotaModel> AnggotaList = response.body().getListDataAnggota();
//                Log.d("Retrofit Get", "Jumlah data Anggota: " + String.valueOf(AnggotaList.size()));
                mAdapter = new AnggotaAdapter(AnggotaList);
                mRecyclerView.setAdapter(mAdapter);
            }
            @Override
            public void onFailure(Call<GetAnggotaModel> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}