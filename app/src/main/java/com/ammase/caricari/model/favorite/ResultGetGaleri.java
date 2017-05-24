package com.ammase.caricari.model.favorite;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultGetGaleri{

	@SerializedName("galeri")
	private List<GaleriItem> galeri;

	@SerializedName("success")
	private int success;

	public void setGaleri(List<GaleriItem> galeri){
		this.galeri = galeri;
	}

	public List<GaleriItem> getGaleri(){
		return galeri;
	}

	public void setSuccess(int success){
		this.success = success;
	}

	public int getSuccess(){
		return success;
	}

	@Override
 	public String toString(){
		return 
			"ResultGetGaleri{" + 
			"galeri = '" + galeri + '\'' + 
			",success = '" + success + '\'' + 
			"}";
		}
}