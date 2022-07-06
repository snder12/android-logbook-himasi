package com.example.lbh.Rest;

import com.example.lbh.Anggota.Model.GetAnggotaModel;
import com.example.lbh.Anggota.Model.ManageAnggotaModel;
import com.example.lbh.Login.Model.Login;
import com.example.lbh.Register.Model.Register;
import com.example.lbh.Proker.Model.GetProkerModel;
import com.example.lbh.Proker.Model.ManageProkerModel;
import com.example.lbh.Staf.Model.GetStafModel;

import kotlin.jvm.JvmMultifileClass;
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
    Call<ManageAnggotaModel> postAnggota(@Field("id_anggota") String id_anggota,
                                         @Field("npm") String npm,
                                         @Field("nama") String nama,
                                         @Field("no_hp") String no_hp,
                                         @Field("email") String email,
                                         @Field("angkatan") String angkatan,
                                         @Field("jabatan") String jabatan);
    @FormUrlEncoded
    @PUT("Anggota")
    Call<ManageAnggotaModel> putAnggota(@Field("id_anggota") String id_anggota,
                                        @Field("npm") String npm,
                                        @Field("nama") String nama,
                                        @Field("no_hp") String no_hp,
                                        @Field("email") String email,
                                        @Field("angkatan") String angkatan,
                                        @Field("jabatan") String jabatan);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "Anggota", hasBody = true)
    Call<ManageAnggotaModel> deleteAnggota(@Field("id_anggota") String id_anggota);

    @FormUrlEncoded
    @POST("login")
    Call<Login> loginResponse(
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("register")
    Call<Register> registerResponse(
            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password
    );

    @GET("proker")
    Call<GetProkerModel> getProker();
    @FormUrlEncoded
    @POST("proker")
    Call<ManageProkerModel> postProker(@Field("id_proker") String id_proker,
                                       @Field("nama_proker") String nama_proker,
                                       @Field("ketua_pelaksana") String ketua_pelaksana,
                                       @Field("tanggal") String tanggal,
                                       @Field("deskripsi") String deskripsi);
    @FormUrlEncoded
    @PUT("proker")
    Call<ManageProkerModel> putProker(@Field("id_proker") String id_proker,
                                      @Field("nama_proker") String nama_proker,
                                      @Field("ketua_pelaksana") String ketua_pelaksana,
                                      @Field("tanggal") String tanggal,
                                      @Field("deskripsi") String deskripsi);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "Proker", hasBody = true)
    Call<ManageProkerModel> deleteProker(@Field("id_proker") String id_proker);

    @GET("Staf")
    Call<GetStafModel> getStaf();
}

