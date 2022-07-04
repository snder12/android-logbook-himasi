package com.example.lbh.Proker.Model;

import com.example.lbh.Proker.Model.ProkerModel;
import com.google.gson.annotations.SerializedName;

public class ManageProkerModel {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    ProkerModel mProker;
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
    public ProkerModel getProker() {
        return mProker;
    }
    public void setAnggota(ProkerModel Proker) {
        mProker = Proker;
    }
}
