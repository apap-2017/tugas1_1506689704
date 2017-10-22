package com.example.tugas1.model;

import javax.validation.constraints.NotNull;

public class PendudukModel {
	@NotNull
	private String idPenduduk;
	@NotNull
	private String nik;
	@NotNull
	private String namaPenduduk;
	@NotNull
	private String tempat_lahir;
	@NotNull
	private String tanggal_lahir;
	@NotNull
	private int jenis_kelamin;
	@NotNull
	private int is_wni;
	@NotNull
	private String id_keluarga;
	@NotNull
	private String agama;
	@NotNull
	private String pekerjaan;
	@NotNull
	private String status_perkawinan;
	@NotNull
	private String status_dalam_keluarga;
	@NotNull
	private String golongan_darah;
	@NotNull
	private int is_wafat;
	public String getIdPenduduk() {
		return idPenduduk;
	}
	public void setIdPenduduk(String idPenduduk) {
		this.idPenduduk = idPenduduk;
	}
	public String getNik() {
		return nik;
	}
	public void setNik(String nik) {
		this.nik = nik;
	}
	public String getNamaPenduduk() {
		return namaPenduduk;
	}
	public void setNamaPenduduk(String namaPenduduk) {
		this.namaPenduduk = namaPenduduk;
	}
	public String getTempat_lahir() {
		return tempat_lahir;
	}
	public void setTempat_lahir(String tempat_lahir) {
		this.tempat_lahir = tempat_lahir;
	}
	public String getTanggal_lahir() {
		return tanggal_lahir;
	}
	public void setTanggal_lahir(String tanggal_lahir) {
		this.tanggal_lahir = tanggal_lahir;
	}
	public int getJenis_kelamin() {
		return jenis_kelamin;
	}
	public void setJenis_kelamin(int jenis_kelamin) {
		this.jenis_kelamin = jenis_kelamin;
	}
	public int getIs_wni() {
			return is_wni;
		}
	public void setIs_wni(int is_wni) {
		this.is_wni = is_wni;
	}
	public String getId_keluarga() {
		return id_keluarga;
	}
	public void setId_keluarga(String id_keluarga) {
		this.id_keluarga = id_keluarga;
	}
	public String getAgama() {
		return agama;
	}
	public void setAgama(String agama) {
		this.agama = agama;
	}
	public String getPekerjaan() {
		return pekerjaan;
	}
	public void setPekerjaan(String pekerjaan) {
		this.pekerjaan = pekerjaan;
	}
	public String getStatus_perkawinan() {
		return status_perkawinan;
	}
	public void setStatus_perkawinan(String status_perkawinan) {
		this.status_perkawinan = status_perkawinan;
	}
	public String getStatus_dalam_keluarga() {
		return status_dalam_keluarga;
	}
	public void setStatus_dalam_keluarga(String status_dalam_keluarga) {
		this.status_dalam_keluarga = status_dalam_keluarga;
	}
	public String getGolongan_darah() {
		return golongan_darah;
	}
	public void setGolongan_darah(String golongan_darah) {
		this.golongan_darah = golongan_darah;
	}
	public int getIs_wafat() {
			return is_wafat;
	}
	public void setIs_wafat(int is_wafat) {
		this.is_wafat = is_wafat;
	}
}
