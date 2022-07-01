package com.example.lbh.Anggota.Rest;

import com.example.lbh.Anggota.Model.GetAnggotaModel;
import com.example.lbh.Anggota.Model.ManageAnggotaModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;
public interface ApiInterface {
    @GET("Anggota")
    Call<GetAnggotaModel> getAnggota();
    @FormUrlEncoded
    @POST("Anggota")
    Call<ManageAnggotaModel> postAnggota(@Field("no_anggota") String no_anggota,
                                         @Field("npm") String npm,
                                         @Field("nama") String nama,
                                         @Field("no_hp") String no_hp);
    @FormUrlEncoded
    @PUT("Anggota")
    Call<ManageAnggotaModel> putAnggota(@Field("no_anggota") String no_anggota,
                                        @Field("npm") String npm,
                                        @Field("nama") String nama,
                                        @Field("no_hp") String no_hp);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "Anggota", hasBody = true)
    Call<ManageAnggotaModel> deleteAnggota(@Field("no_anggota") String no_anggota);
}

