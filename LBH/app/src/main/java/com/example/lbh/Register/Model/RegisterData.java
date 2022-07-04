package com.example.lbh.Register.Model;

import com.google.gson.annotations.SerializedName;

public class RegisterData {

	@SerializedName("username")
	private String username;

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}
}