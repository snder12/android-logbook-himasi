package com.example.lbh.Login.Model;

import com.google.gson.annotations.SerializedName;

public class LoginData {

	@SerializedName("username")
	private String username;
	private String user_id;

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public void setUser_id(){
		this.user_id = user_id;
	}

	public String getUser_id(){
		return user_id;
	}
}