package com.example.lbh.Proker.Adapter;

import android.annotation.SuppressLint;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lbh.Proker.Model.ProkerModel;
import com.example.lbh.Proker.UpdateProkerActivity;
import com.example.lbh.R;

import org.w3c.dom.Text;

import java.util.List;

public class ProkerAdapter extends RecyclerView.Adapter<com.example.lbh.Proker.Adapter.ProkerAdapter.MyViewHolder> {

    List<ProkerModel> mProkerList;
    public ProkerAdapter(List <ProkerModel> ProkerList) {
        mProkerList= ProkerList;
    }
    @Override
    public com.example.lbh.Proker.Adapter.ProkerAdapter.MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_proker, parent, false);
        com.example.lbh.Proker.Adapter.ProkerAdapter.MyViewHolder mViewHolder = new com.example.lbh.Proker.Adapter.ProkerAdapter.MyViewHolder(mView);
        return mViewHolder;
    }
    @Override
    public void onBindViewHolder (com.example.lbh.Proker.Adapter.ProkerAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") final int position){
        holder.mTextViewIdProker.setText("ID Proker = " +
                mProkerList.get(position).getId_proker());
        holder.mTextViewNamaProker.setText("Nama Proker = " +
                mProkerList.get(position).getNama_proker());
        holder.mTextViewTanggal.setText("Tanggal = " +
                mProkerList.get(position).getTanggal());
        holder.mTextViewDeskripsi.setText("Deskripsi = " +
                mProkerList.get(position).getDeskripsi());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(),
                        UpdateProkerActivity.class);
                mIntent.putExtra("Id_Proker",
                        mProkerList.get(position).getId_proker());
                mIntent.putExtra("Nama_Proker",
                        mProkerList.get(position).getNama_proker());
                mIntent.putExtra("Tanggal",
                        mProkerList.get(position).getTanggal());
                mIntent.putExtra("Deskripsi",
                        mProkerList.get(position).getDeskripsi());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mProkerList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewIdProker, mTextViewNamaProker, mTextViewTanggal, mTextViewDeskripsi;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewIdProker = (TextView) itemView.findViewById(R.id.tvIdProker);
            mTextViewNamaProker = (TextView) itemView.findViewById(R.id.tvNamaProker);
            mTextViewTanggal = (TextView) itemView.findViewById(R.id.tvTanggal);
            mTextViewDeskripsi = (TextView) itemView.findViewById(R.id.tvDeskripsi);
        }
    }

}