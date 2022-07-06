package com.example.lbh.Staf.Model;

import com.example.lbh.Staf.Model.StafModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class GetStafModel {
    @SerializedName("status")
    String status;

    @SerializedName("result")
    List<StafModel> listDataStaf;

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

    public List<StafModel> getListDataStaf() {
        return listDataStaf;
    }

    public void setListDataStaf(List<StafModel> listDataStaf) {
        this.listDataStaf = listDataStaf;
    }
}
