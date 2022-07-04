package com.example.lbh.Rest;

import com.example.lbh.Anggota.Model.GetAnggotaModel;
import com.example.lbh.Anggota.Model.ManageAnggotaModel;
import com.example.lbh.Login.Model.Login;
import com.example.lbh.Register.Model.Register;

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
            @Field("password") String password,
            @Field("no_hp") String no_hp,
            @Field("jenis_kelamin") String jenis_kelamin,
            @Field("angkatan") String angkatan
    );
}

