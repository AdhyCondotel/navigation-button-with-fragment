package com.ammase.caricari.model.home;
import com.google.gson.annotations.SerializedName;

public class BeritaItem{

	@SerializedName("kode_berita")
	private String kodeBerita;

	@SerializedName("artikel")
	private String artikel;

	@SerializedName("sampul_artikel")
	private String sampulArtikel;

	@SerializedName("url_gambar")
	private String urlGambar;

	@SerializedName("tgl_posting")
	private String tglPosting;

	@SerializedName("kegiatan")
	private String kegiatan;

	@SerializedName("judul")
	private String judul;

	public void setKodeBerita(String kodeBerita){
		this.kodeBerita = kodeBerita;
	}

	public String getKodeBerita(){
		return kodeBerita;
	}

	public void setArtikel(String artikel){
		this.artikel = artikel;
	}

	public String getArtikel(){
		return artikel;
	}

	public void setSampulArtikel(String sampulArtikel){
		this.sampulArtikel = sampulArtikel;
	}

	public String getSampulArtikel(){
		return sampulArtikel;
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

	public void setKegiatan(String kegiatan){
		this.kegiatan = kegiatan;
	}

	public String getKegiatan(){
		return kegiatan;
	}

	public void setJudul(String judul){
		this.judul = judul;
	}

	public String getJudul(){
		return judul;
	}

	@Override
 	public String toString(){
		return 
			"BeritaItem{" + 
			"kode_berita = '" + kodeBerita + '\'' + 
			",artikel = '" + artikel + '\'' + 
			",sampul_artikel = '" + sampulArtikel + '\'' + 
			",url_gambar = '" + urlGambar + '\'' + 
			",tgl_posting = '" + tglPosting + '\'' + 
			",kegiatan = '" + kegiatan + '\'' + 
			",judul = '" + judul + '\'' + 
			"}";
		}
}