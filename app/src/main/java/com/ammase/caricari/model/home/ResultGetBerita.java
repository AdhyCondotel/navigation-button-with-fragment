package com.ammase.caricari.model.home;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultGetBerita{

	@SerializedName("success")
	private int success;

	@SerializedName("berita")
	private List<BeritaItem> berita;

	public void setSuccess(int success){
		this.success = success;
	}

	public int getSuccess(){
		return success;
	}

	public void setBerita(List<BeritaItem> berita){
		this.berita = berita;
	}

	public List<BeritaItem> getBerita(){
		return berita;
	}

	@Override
 	public String toString(){
		return 
			"ResultGetBerita{" + 
			"success = '" + success + '\'' + 
			",berita = '" + berita + '\'' + 
			"}";
		}
}