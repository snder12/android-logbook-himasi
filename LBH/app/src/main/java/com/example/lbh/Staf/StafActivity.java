package com.example.lbh.Staf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.lbh.Staf.Adapter.StafAdapter;
import com.example.lbh.Staf.StafActivity;
import com.example.lbh.Staf.Model.StafModel;
import com.example.lbh.Staf.Model.GetStafModel;
import com.example.lbh.Staf.Adapter.StafAdapter;
import com.example.lbh.Staf.Model.StafModel;
import com.example.lbh.Staf.Model.GetStafModel;
import com.example.lbh.Rest.ApiClient;
import com.example.lbh.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.lbh.R;

public class StafActivity extends AppCompatActivity {

    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static StafActivity sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staf);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        sa=this;
        refresh();
    }

    public void refresh() {
//        Call<GetStafModel> stafCall = mApiInterface.getStaf();
        Call<GetStafModel> stafCall = mApiInterface.getStaf();
        stafCall.enqueue(new Callback<GetStafModel>() {
            @Override
            public void onResponse(Call<GetStafModel> call, Response<GetStafModel> response) {
                List<StafModel> StafList = response.body().getListDataStaf();
//                Log.d("Retrofit Get", "Jumlah data Anggota: " + String.valueOf(AnggotaList.size()));
                mAdapter = new StafAdapter(StafList);
                mRecyclerView.setAdapter(mAdapter);
            }
            @Override
            public void onFailure(Call<GetStafModel> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}