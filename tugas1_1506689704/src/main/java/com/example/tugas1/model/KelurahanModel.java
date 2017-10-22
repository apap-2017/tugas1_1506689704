package com.example.tugas1.model;

import javax.validation.constraints.NotNull;

public class KelurahanModel {
	@NotNull
	private int id_kelurahan;
	@NotNull
	private String kode_kelurahan;
	@NotNull
	private String id_kecamatan;
	@NotNull
	private String nama_kelurahan;
	@NotNull
	private char kode_pos;
	
	public String getNama_kelurahan() {
		return nama_kelurahan;
	}
	public void setNama_kelurahan(String nama_kelurahan) {
		this.nama_kelurahan = nama_kelurahan;
	}

	public int getId_kelurahan() {
		return id_kelurahan;
	}
	public void setId_kelurahan(int id_kelurahan) {
		this.id_kelurahan = id_kelurahan;
	}
	public String getKode_kelurahan() {
		return kode_kelurahan;
	}
	public void setKode_kelurahan(String kode_kelurahan) {
		this.kode_kelurahan = kode_kelurahan;
	}
	public String getId_kecamatan() {
		return id_kecamatan;
	}
	public void setId_kecamatan(String id_kecamatan) {
		this.id_kecamatan = id_kecamatan;
	}

	public char getKode_pos() {
		return kode_pos;
	}
	public void setKode_pos(char kode_pos) {
		this.kode_pos = kode_pos;
	}
	
}
