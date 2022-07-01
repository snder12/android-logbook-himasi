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
    public AnggotaModel(){}
    public AnggotaModel(String no_anggota, String npm, String nama, String no_hp)
    {
        this.no_anggota = no_anggota;
        this.npm = npm;
        this.nama = nama;
        this.no_hp = no_hp;
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
}