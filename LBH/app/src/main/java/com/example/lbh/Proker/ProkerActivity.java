package com.example.lbh.Proker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.lbh.Proker.Adapter.ProkerAdapter;
import com.example.lbh.Proker.CreateProkerActivity;
import com.example.lbh.Proker.Model.ProkerModel;
import com.example.lbh.Proker.Model.GetProkerModel;
import com.example.lbh.Rest.ApiClient;
import com.example.lbh.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.lbh.R;

public class ProkerActivity extends AppCompatActivity {

    Button btIns;
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static ProkerActivity pa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anggota);
        btIns = (Button) findViewById(R.id.btIns);
        btIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(com.example.lbh.Proker.ProkerActivity.this,
                        CreateProkerActivity.class));
            }
        });
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        pa=this;
        refresh();
    }
    public void refresh() {
        Call<GetProkerModel> prokerCall = mApiInterface.getProker();
        prokerCall.enqueue(new Callback<GetProkerModel>() {
            @Override
            public void onResponse(Call<GetProkerModel> call, Response<GetProkerModel> response) {
                List<ProkerModel> ProkerList = response.body().getListDataProker();
                Log.d("Retrofit Get", "Jumlah data Proker: " + String.valueOf(ProkerList.size()));
                mAdapter = new ProkerAdapter(ProkerList);
                mRecyclerView.setAdapter(mAdapter);
            }
            @Override
            public void onFailure(Call<GetProkerModel> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}