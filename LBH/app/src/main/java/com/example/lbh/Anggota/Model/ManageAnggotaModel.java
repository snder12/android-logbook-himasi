package com.example.lbh.Anggota.Model;

import com.google.gson.annotations.SerializedName;

public class ManageAnggotaModel {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    AnggotaModel mAnggota;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public AnggotaModel getAnggota() {
        return mAnggota;
    }
    public void setAnggota(AnggotaModel Anggota) {
        mAnggota= Anggota;
    }
}