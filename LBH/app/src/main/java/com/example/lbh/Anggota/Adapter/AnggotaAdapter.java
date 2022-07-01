package com.example.lbh.Anggota.Adapter;

import android.annotation.SuppressLint;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lbh.Anggota.Model.AnggotaModel;
import com.example.lbh.Anggota.UpdateAnggotaActivity;
import com.example.lbh.R;

import java.util.List;

public class AnggotaAdapter extends RecyclerView.Adapter<AnggotaAdapter.MyViewHolder> {

    List<AnggotaModel> mAnggotaList;
    public AnggotaAdapter(List <AnggotaModel> AnggotaList) {
        mAnggotaList= AnggotaList;
    }
    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_anggota, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }
    @Override
    public void onBindViewHolder (MyViewHolder holder, @SuppressLint("RecyclerView") final int position){
        holder.mTextViewNoAnggota.setText("No Anggota = " +
                mAnggotaList.get(position).getNo_anggota());
        holder.mTextViewNpm.setText("NPM = " +
                mAnggotaList.get(position).getNpm());
        holder.mTextViewNama.setText("Nama = " +
                mAnggotaList.get(position).getNama());
        holder.mTextViewNoHp.setText("Nomor HP = " +
                mAnggotaList.get(position).getNo_hp());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(),
                        UpdateAnggotaActivity.class);
                mIntent.putExtra("No_Anggota",
                        mAnggotaList.get(position).getNo_anggota());
                mIntent.putExtra("Npm", mAnggotaList.get(position).getNpm());
                mIntent.putExtra("Nama",
                        mAnggotaList.get(position).getNama());
                mIntent.putExtra("No_hp",
                        mAnggotaList.get(position).getNo_hp());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mAnggotaList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewNoAnggota, mTextViewNpm, mTextViewNama, mTextViewNoHp;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewNoAnggota = (TextView) itemView.findViewById(R.id.tvNoAnggota);
            mTextViewNpm = (TextView) itemView.findViewById(R.id.tvNpm);
            mTextViewNama = (TextView) itemView.findViewById(R.id.tvNama);
            mTextViewNoHp = (TextView) itemView.findViewById(R.id.tvNoHp);
        }
    }

}