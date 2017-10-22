package com.example.tugas1.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tugas1.dao.PendudukMapper;
import com.example.tugas1.model.AlamatModel;
import com.example.tugas1.model.KecamatanModel;
import com.example.tugas1.model.KeluargaModel;
import com.example.tugas1.model.KelurahanModel;
import com.example.tugas1.model.KotaModel;
import com.example.tugas1.model.PendudukModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PendudukServiceDatabase implements PendudukService {
	  @Autowired
	    private PendudukMapper PendudukMapper;


	  @Override
	   public PendudukModel selectPenduduk (String nik)
	    {
	        return PendudukMapper.selectPenduduk(nik);
	    }
	    
	  
	  @Override
		public AlamatModel selectAlamat(String id_keluarga)
		    {
		        return PendudukMapper.selectAlamat(id_keluarga);
		    }
	    
	    @Override
	    public KeluargaModel selectKeluarga (String nkk)
	    {
	    	return PendudukMapper.selectKeluarga(nkk);
	    }
	    
	    @Override
	    public String selectPidK(String id_kelurahan)
	    {
	    	return PendudukMapper.selectPidK(id_kelurahan);
	    }
	    
	    @Override
	    public int hitungPenduduk(String query)
	    {
	    	return PendudukMapper.hitungPenduduk(query);
	    }
	    
	    public String selectKodeKecamatan(String id_kelurahan) {
	    	return PendudukMapper.selectKodeKecamatan(id_kelurahan);
	    }
	    
	    public void addPenduduk(PendudukModel penduduk) {
	    	PendudukMapper.addPenduduk(penduduk);
	    }
	    
	    public String selectKodeKecamatan2(String nama_kecamatan)
	    {
	    	return PendudukMapper.selectKodeKecamatan2(nama_kecamatan);
	    }
	    
	    public String selectKelurahanId(String nama_kelurahan)
	    {
	    	return PendudukMapper.selectKelurahanId(nama_kelurahan);
	    }
	    
	    @Override
		public int hitungKeluarga(String query) {
			
			return PendudukMapper.hitungKeluarga(query);
		}
		
		@Override
		public void addkeluarga(KeluargaModel keluarga) {
			PendudukMapper.addKeluarga(keluarga);
		}
	    
		@Override
		public void updatePenduduk (PendudukModel penduduk)
		{
			PendudukMapper.updatePenduduk(penduduk);
		}
		
		@Override
		public void updateKeluarga (KeluargaModel keluarga) {
			PendudukMapper.updateKeluarga(keluarga);
		}
	    
}
