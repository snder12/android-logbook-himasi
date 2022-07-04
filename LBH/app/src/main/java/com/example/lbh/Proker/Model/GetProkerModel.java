package com.example.lbh.Proker.Model;

import com.example.lbh.Proker.Model.ProkerModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class GetProkerModel {
    @SerializedName("status")
    String status;

    @SerializedName("result")
    List<ProkerModel> listDataProker;

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

    public List<ProkerModel> getListDataProker() {
        return listDataProker;
    }

    public void setListDataProker(List<ProkerModel> listDataProker) {
        this.listDataProker = listDataProker;
    }
}
