package com.example.lbh.Staf.Adapter;

import android.annotation.SuppressLint;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lbh.Anggota.Adapter.AnggotaAdapter;
import com.example.lbh.Anggota.Model.AnggotaModel;
import com.example.lbh.Anggota.UpdateAnggotaActivity;
import com.example.lbh.Staf.Model.StafModel;
import com.example.lbh.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class StafAdapter extends RecyclerView.Adapter<StafAdapter.MyViewHolder>{
    List<StafModel> mStafList;
    public StafAdapter(List <StafModel> StafList) {
        mStafList= StafList;
    }
    @Override
    public StafAdapter.MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_staf, parent, false);
        StafAdapter.MyViewHolder mViewHolder = new StafAdapter.MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (StafAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") final int position){
        holder.mTextViewIdAnggota.setText("ID Anggota = " +
                mStafList.get(position).getId_anggota());
        holder.mTextViewNpm.setText("NPM = " +
                mStafList.get(position).getNpm());
        holder.mTextViewNama.setText("Nama = " +
                mStafList.get(position).getNama());
        holder.mTextViewAngkatan.setText("Angkatan = " +
                mStafList.get(position).getAngkatan());
        holder.mTextViewJabatan.setText("Jabatan = " +
                mStafList.get(position).getJabatan());

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent mIntent = new Intent(view.getContext(),
//                        UpdateAnggotaActivity.class);
//                mIntent.putExtra("Id_anggota",
//                        mAnggotaList.get(position).getId_anggota());
//                mIntent.putExtra("Npm",
//                        mAnggotaList.get(position).getNpm());
//                mIntent.putExtra("Nama",
//                        mAnggotaList.get(position).getNama());
//                mIntent.putExtra("No_hp",
//                        mAnggotaList.get(position).getNo_hp());
//                mIntent.putExtra("Email",
//                        mAnggotaList.get(position).getEmail());
//                mIntent.putExtra("Angkatan",
//                        mAnggotaList.get(position).getAngkatan());
//                mIntent.putExtra("Jabatan",
//                        mAnggotaList.get(position).getJabatan());
//                view.getContext().startActivity(mIntent);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return mStafList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewIdAnggota, mTextViewNpm, mTextViewNama, mTextViewAngkatan, mTextViewJabatan;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewIdAnggota = (TextView) itemView.findViewById(R.id.tvIdAnggota);
            mTextViewNpm = (TextView) itemView.findViewById(R.id.tvNpm);
            mTextViewNama = (TextView) itemView.findViewById(R.id.tvNama);
            mTextViewAngkatan = (TextView) itemView.findViewById(R.id.tvAngkatan);
            mTextViewJabatan = (TextView) itemView.findViewById(R.id.tvJabatan);
        }
    }
}
