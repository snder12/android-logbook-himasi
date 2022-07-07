package com.example.lbh.Anggota.Model;

import com.google.gson.annotations.SerializedName;

public class AnggotaModel {

    @SerializedName("id_anggota")
    private String id_anggota;
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
    @SerializedName("level")
    private String level;

    public AnggotaModel(){}
    public AnggotaModel(String id_anggota, String npm, String nama, String no_hp, String email, String angkatan, String jabatan, String level)
    {
        this.id_anggota = id_anggota;
        this.npm = npm;
        this.nama = nama;
        this.no_hp = no_hp;
        this.email = email;
        this.angkatan = angkatan;
        this.jabatan = jabatan;
        this.level = level;
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
    public String getLevel() {
        return level;
    }
    public void setLevel(String level) { this.level = level; }

}