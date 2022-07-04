package com.example.lbh.Anggota.Model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class GetAnggotaModel {
    @SerializedName("status")
    String status;

    @SerializedName("result")
    List<AnggotaModel> listDataAnggota;

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

    public List<AnggotaModel> getListDataAnggota() {
        return listDataAnggota;
    }

    public void setListDataAnggota(List<AnggotaModel> listDataAnggota) {
        this.listDataAnggota = listDataAnggota;
    }
}
