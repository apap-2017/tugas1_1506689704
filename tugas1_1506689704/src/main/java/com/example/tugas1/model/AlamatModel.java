package com.example.tugas1.model;

import javax.validation.constraints.NotNull;

public class AlamatModel {
	public String alamat;
	public String rt;
	public String rw;
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getRt() {
		return rt;
	}
	public void setRt(String rt) {
		this.rt = rt;
	}
	public String getRw() {
		return rw;
	}
	public void setRw(String rw) {
		this.rw = rw;
	}
	@NotNull
	private String id_kecamatan;
	@NotNull
	private String nama_kecamatan;
	@NotNull
	private String id_kelurahan;
	public String getId_kecamatan() {
		return id_kecamatan;
	}
	public void setId_kecamatan(String id_kecamatan) {
		this.id_kecamatan = id_kecamatan;
	}
	public String getNama_kecamatan() {
		return nama_kecamatan;
	}
	public void setNama_kecamatan(String nama_kecamatan) {
		this.nama_kecamatan = nama_kecamatan;
	}
	public String getId_kelurahan() {
		return id_kelurahan;
	}
	public void setId_kelurahan(String id_kelurahan) {
		this.id_kelurahan = id_kelurahan;
	}
	public String getNama_kelurahan() {
		return nama_kelurahan;
	}
	public void setNama_kelurahan(String nama_kelurahan) {
		this.nama_kelurahan = nama_kelurahan;
	}
	public String getId_kota() {
		return id_kota;
	}
	public void setId_kota(String id_kota) {
		this.id_kota = id_kota;
	}
	public String getNama_kota() {
		return nama_kota;
	}
	public void setNama_kota(String nama_kota) {
		this.nama_kota = nama_kota;
	}
	@NotNull
	private String nama_kelurahan;
	@NotNull
	private String id_kota;
	@NotNull
	private String nama_kota;
}
