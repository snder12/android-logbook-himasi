package com.example.lbh.Staf.Model;

import com.google.gson.annotations.SerializedName;

public class StafModel {
    @SerializedName("id_anggota")
    private String id_anggota;
    @SerializedName("npm")
    private String npm;
    @SerializedName("nama")
    private String nama;
    @SerializedName("angkatan")
    private String angkatan;
    @SerializedName("jabatan")
    private String jabatan;

    public StafModel(){}
    public StafModel(String id_anggota, String npm, String nama, String angkatan, String jabatan)
    {
        this.id_anggota = id_anggota;
        this.npm = npm;
        this.nama = nama;
        this.angkatan = angkatan;
        this.jabatan = jabatan;
    }
    public String getId_anggota() { return id_anggota; }
    public void setId_anggota(String id_anggota) {
        this.id_anggota = id_anggota;
    }
    public String getNpm() {
        return npm;
    }
    public void setNpm(String npm) {
        this.npm = npm;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getAngkatan() {
        return angkatan;
    }
    public void setAngkatan(String angkatan) {
        this.angkatan= angkatan;
    }
    public String getJabatan() {
        return jabatan;
    }
    public void setJabatan(String jabatan) {
        this.jabatan= jabatan;
    }
}
