package com.example.tugas1.model;

import javax.validation.constraints.NotNull;

public class KotaModel {
	@NotNull
	private int id_kota;
	@NotNull
	private String kode_kota;
	@NotNull
	private String nama_kota;

	
	public int getId_kota() {
		return id_kota;
	}
	public void setId_kota(int id_kota) {
		this.id_kota = id_kota;
	}
	public String getKode_kota() {
		return kode_kota;
	}
	public void setKode_kota(String kode_kota) {
		this.kode_kota = kode_kota;
	}
	public String getNama_kota() {
		return nama_kota;
	}
	public void setNama_kota(String nama_kota) {
		this.nama_kota = nama_kota;
	}
}
