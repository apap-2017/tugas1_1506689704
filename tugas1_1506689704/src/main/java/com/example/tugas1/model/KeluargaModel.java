package com.example.tugas1.model;

import java.util.List;

import javax.validation.constraints.NotNull;



public class KeluargaModel {
	@NotNull
	private String id;
	@NotNull
	private String nomor_kk;
	@NotNull
	private String alamat;
	@NotNull
	private int rt;
	@NotNull
	private int rw;
	@NotNull
	private String nama_kelurahan;
	@NotNull
	private String nama_kecamatan;
	@NotNull
	private String nama_kota;
	@NotNull
	private String id_kelurahan;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getId_kelurahan() {
		return id_kelurahan;
	}

	public void setId_kelurahan(String id_kelurahan) {
		this.id_kelurahan = id_kelurahan;
	}

	public String getNomor_kk() {
		return nomor_kk;
	}

	public void setNomor_kk(String nomor_kk) {
		this.nomor_kk = nomor_kk;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public int getRt() {
		return rt;
	}

	public void setRt(int rt) {
		this.rt = rt;
	}

	public int getRw() {
		return rw;
	}

	public void setRw(int rw) {
		this.rw = rw;
	}

	public String getNama_kelurahan() {
		return nama_kelurahan;
	}

	public void setNama_kelurahan(String nama_kelurahan) {
		this.nama_kelurahan = nama_kelurahan;
	}

	public String getNama_kecamatan() {
		return nama_kecamatan;
	}

	public void setNama_kecamatan(String nama_kecamatan) {
		this.nama_kecamatan = nama_kecamatan;
	}

	public String getNama_kota() {
		return nama_kota;
	}

	public void setNama_kota(String nama_kota) {
		this.nama_kota = nama_kota;
	}

	public int getIs_tidak_berlaku() {
		return is_tidak_berlaku;
	}

	public void setIs_tidak_berlaku(int is_tidak_berlaku) {
		this.is_tidak_berlaku = is_tidak_berlaku;
	}

	public List<PendudukModel> getPenduduks() {
		return penduduks;
	}

	public void setPenduduks(List<PendudukModel> penduduks) {
		this.penduduks = penduduks;
	}

	private int is_tidak_berlaku;
	
	private List<PendudukModel> penduduks;
}
