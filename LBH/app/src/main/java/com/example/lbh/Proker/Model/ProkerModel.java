package com.example.lbh.Proker.Model;

import com.google.gson.annotations.SerializedName;

public class ProkerModel {

    @SerializedName("id_proker")
    private String id_proker;
    @SerializedName("nama_proker")
    private String nama_proker;
    @SerializedName("tanggal")
    private String tanggal;
    @SerializedName("deskripsi")
    private String deskripsi;
    public ProkerModel(){}
    public ProkerModel(String id_proker, String nama_proker, String tanggal, String deskripsi)
    {
        this.id_proker = id_proker;
        this.nama_proker = nama_proker;
        this.tanggal = tanggal;
        this.deskripsi = deskripsi;
    }
    public String getId_proker() {
        return id_proker;
    }
    public void setId_proker(String id_proker) {
        this.id_proker = id_proker;
    }
    public String getNama_proker() { return nama_proker; }
    public void setNama_proker(String nama_proker) {
        this.nama_proker = nama_proker;
    }
    public String getTanggal() {
        return tanggal;
    }
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    public String getDeskripsi() {
        return deskripsi;
    }
    public void setDeskripsi(String deskripsi) {
        this.deskripsi= deskripsi;
    }

}
