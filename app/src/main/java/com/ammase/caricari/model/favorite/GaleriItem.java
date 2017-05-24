package com.ammase.caricari.model.favorite;


import com.google.gson.annotations.SerializedName;

public class GaleriItem{

	@SerializedName("no_urut")
	private String noUrut;

	@SerializedName("url_gambar")
	private String urlGambar;

	@SerializedName("tgl_posting")
	private String tglPosting;

	@SerializedName("nama_galeri")
	private String namaGaleri;

	@SerializedName("kode_galeri")
	private String kodeGaleri;

	public void setNoUrut(String noUrut){
		this.noUrut = noUrut;
	}

	public String getNoUrut(){
		return noUrut;
	}

	public void setUrlGambar(String urlGambar){
		this.urlGambar = urlGambar;
	}

	public String getUrlGambar(){
		return urlGambar;
	}

	public void setTglPosting(String tglPosting){
		this.tglPosting = tglPosting;
	}

	public String getTglPosting(){
		return tglPosting;
	}

	public void setNamaGaleri(String namaGaleri){
		this.namaGaleri = namaGaleri;
	}

	public String getNamaGaleri(){
		return namaGaleri;
	}

	public void setKodeGaleri(String kodeGaleri){
		this.kodeGaleri = kodeGaleri;
	}

	public String getKodeGaleri(){
		return kodeGaleri;
	}

	@Override
 	public String toString(){
		return 
			"GaleriItem{" + 
			"no_urut = '" + noUrut + '\'' + 
			",url_gambar = '" + urlGambar + '\'' + 
			",tgl_posting = '" + tglPosting + '\'' + 
			",nama_galeri = '" + namaGaleri + '\'' + 
			",kode_galeri = '" + kodeGaleri + '\'' + 
			"}";
		}
}