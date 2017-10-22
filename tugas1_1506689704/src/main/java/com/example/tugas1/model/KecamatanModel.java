package com.example.tugas1.model;

import javax.validation.constraints.NotNull;

public class KecamatanModel {
	@NotNull
	private int id_kecamatan;
	@NotNull
	private String kode_kecamatan;
	@NotNull
	private String id_kota;
	@NotNull
	private String nama_kecamatan;
	public int getId_kecamatan() {
		return id_kecamatan;
	}
	public void setId_kecamatan(int id_kecamatan) {
		this.id_kecamatan = id_kecamatan;
	}
	public String getKode_kecamatan() {
		return kode_kecamatan;
	}
	public void setKode_kecamatan(String kode_kecamatan) {
		this.kode_kecamatan = kode_kecamatan;
	}
	public String getId_kota() {
		return id_kota;
	}
	public void setId_kota(String id_kota) {
		this.id_kota = id_kota;
	}
	public String getNama_kecamatan() {
		return nama_kecamatan;
	}
	public void setNama_kecamatan(String nama_kecamatan) {
		this.nama_kecamatan = nama_kecamatan;
	}
		
}
