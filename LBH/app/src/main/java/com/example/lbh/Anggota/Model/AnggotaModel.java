package com.example.lbh.Anggota.Model;

import com.google.gson.annotations.SerializedName;

public class AnggotaModel {

    @SerializedName("no_anggota")
    private String no_anggota;
    @SerializedName("npm")
    private String npm;
    @SerializedName("nama")
    private String nama;
    @SerializedName("no_hp")
    private String no_hp;
    @SerializedName("email")
    private String email;
    @SerializedName("angkatan")
    private String angkatan;
    @SerializedName("jabatan")
    private String jabatan;
    public AnggotaModel(){}
    public AnggotaModel(String no_anggota, String npm, String nama, String no_hp, String email, String angkatan, String jabatan)
    {
        this.no_anggota = no_anggota;
        this.npm = npm;
        this.nama = nama;
        this.no_hp = no_hp;
        this.email = email;
        this.angkatan = angkatan;
        this.jabatan = jabatan;
    }
    public String getNo_anggota() {
        return no_anggota;
    }
    public void setNo_anggota(String no_anggota) {
        this.no_anggota = no_anggota;
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
    public String getNo_hp() {
        return no_hp;
    }
    public void setNo_hp(String no_hp) {
        this.no_hp= no_hp;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email= email;
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