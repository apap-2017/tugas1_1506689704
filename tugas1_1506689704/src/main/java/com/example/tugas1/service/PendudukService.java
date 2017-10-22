package com.example.tugas1.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.tugas1.model.AlamatModel;
import com.example.tugas1.model.KecamatanModel;
import com.example.tugas1.model.KeluargaModel;
import com.example.tugas1.model.KelurahanModel;
import com.example.tugas1.model.KotaModel;
import com.example.tugas1.model.PendudukModel;


public interface PendudukService {
	
	 PendudukModel selectPenduduk (String nik );
	 
	 AlamatModel selectAlamat(String id_keluarga);
	 
	 KeluargaModel selectKeluarga (String nkk);
	 
	 String selectPidK(String id_kelurahan);
	 
	 int hitungPenduduk(String query);
	 
	 String selectKodeKecamatan(String id_kelurahan);
	 
	 void addPenduduk(PendudukModel penduduk);
	 
	 String selectKodeKecamatan2(String nama_kecamatan);
	 
	 String selectKelurahanId(String nama_kelurahan);
	 
	 int hitungKeluarga(String query);
	 
	 void addkeluarga(KeluargaModel keluarga);
	 
	 void updatePenduduk (PendudukModel penduduk);
	 
	 void updateKeluarga (KeluargaModel keluarga);
	
}
