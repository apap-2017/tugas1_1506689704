package com.example.tugas1.controller;


import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.tugas1.service.PendudukService;

import lombok.extern.slf4j.Slf4j;

import com.example.tugas1.model.AlamatModel;
import com.example.tugas1.model.KecamatanModel;
import com.example.tugas1.model.KeluargaModel;
import com.example.tugas1.model.KelurahanModel;
import com.example.tugas1.model.KotaModel;
import com.example.tugas1.model.PendudukModel;

@Slf4j
@Controller
public class PendudukController {
	
	  @Autowired
	    PendudukService pendudukDAO;
	  	  	

	  @RequestMapping("/")
	    public String search ()
	    {
	        return "search";
	    }
	  
	@RequestMapping("/penduduk")
    public String view (Model model,
            @RequestParam(value = "nik", required = false) String nik)
    {
        PendudukModel penduduk = pendudukDAO.selectPenduduk(nik);
        AlamatModel alamat = pendudukDAO.selectAlamat(penduduk.getId_keluarga());
       
        if (penduduk != null && alamat != null) {
            model.addAttribute ("penduduk", penduduk);
            model.addAttribute ("alamat", alamat);

            return "view";
        }else {
        	model.addAttribute ("nik", nik);
        	return "not-found";
        }
    }
	 
	 @RequestMapping("/keluarga")
	    public String viewK (Model model,
	            @RequestParam(value = "nkk", required = false) String nkk)
	    {
	        KeluargaModel keluarga = pendudukDAO.selectKeluarga (nkk);
	        AlamatModel alamat = pendudukDAO.selectAlamat(keluarga.getId());

	        if (keluarga != null && alamat !=null ) {
	            model.addAttribute ("keluarga", keluarga);
	            model.addAttribute ("alamat", alamat);
	            return "view2";
	        } else {
	            model.addAttribute ("nkk", nkk);
	            return "not-found";
	        }
	    }
	 
	 @RequestMapping("/penduduk/tambah")
	    public String tambahP (Model model){
	    	PendudukModel penduduk = new PendudukModel();
	    	   	
	    	model.addAttribute("action", "/penduduk/tambah");
	    	model.addAttribute("penduduk", penduduk);
	    	return "tambahPenduduk";
	    }
	 
	 @RequestMapping(value = "/penduduk/tambah" , method = RequestMethod.POST)
	    public String tambahP(Model model, @ModelAttribute PendudukModel penduduk)
	    {
		   String[] tanggal_lahir = penduduk.getTanggal_lahir().split("-");
		   int tahun = (Integer.parseInt(tanggal_lahir[0]) % 1000) %100;
		   int bulan = (Integer.parseInt(tanggal_lahir[1]));
		   int hari = (Integer.parseInt(tanggal_lahir[2]));
		   
		   if(penduduk.getJenis_kelamin()==1) {
		    hari = hari + 40;
		   }
		  
		   	String id_kelurahan = pendudukDAO.selectPidK(penduduk.getId_keluarga());
		   	String kode_kecamatan = pendudukDAO.selectKodeKecamatan(id_kelurahan).substring(0, 6);
	    	
	    	String awal = kode_kecamatan + String.format("%02d", hari) + String.format("%02d", bulan) + String.format("%02d", tahun);
	    	String generate = awal + "%";
	    	
	    	int hitungPenduduk = pendudukDAO.hitungPenduduk(generate);
	   
	    	String getNewNIK = awal + String.format("%04d", hitungPenduduk + 1);
	    	
	    	penduduk.setNik(getNewNIK);
	    	
	    	pendudukDAO.addPenduduk(penduduk);
	    	model.addAttribute("nik", penduduk.getNik());
	    	return "suksesTambahPenduduk";

	    }
	 
	 @RequestMapping("keluarga/tambah")
	    public String tambahK(Model model)
	    {
		 	KeluargaModel keluarga = new KeluargaModel();
		   	
	    	model.addAttribute("action", "/keluarga/tambah");
	    	model.addAttribute("keluarga", keluarga);
	        return "tambahKeluarga";
	    }
	 
	    @RequestMapping(value = "/keluarga/tambah", method = RequestMethod.POST)
	    public String tambahK (Model model, @RequestParam(value = "nama_kecamatan", required = false) String nama_kecamatan,
	    		@RequestParam(value = "alamat", required = false) String alamat,
	    		@RequestParam(value = "RT", required = false) String RT,
	    		@RequestParam(value = "RW", required = false) String RW,
	    		@RequestParam(value = "id_kelurahan", required = false) String id_kelurahan,
	    		@RequestParam(value = "nama_kota", required = false) String nama_kota,
	    		@RequestParam(value = "nama_kelurahan", required = false) String nama_kelurahan,
	    		@ModelAttribute KeluargaModel keluarga) {
	
	    	String date = new SimpleDateFormat("ddMMyy").format(Calendar.getInstance().getTime());
	    	
	    	String kode_kecamatan = pendudukDAO.selectKodeKecamatan2(nama_kecamatan).substring(0,6);  
	    	
	    	String id_kelurahan1 = pendudukDAO.selectKelurahanId(nama_kelurahan); //udah dapet id
	    	
	    	String awal = kode_kecamatan + date;
	    	String generate = awal + "%";
	    	
	    	int hitungKeluarga = pendudukDAO.hitungKeluarga(generate);
	    	
	    	String nomor_kk = awal + String.format("%04d", hitungKeluarga + 1);
	    	System.out.println(nomor_kk);
	    	
	    	keluarga.setNomor_kk(nomor_kk);
	    	keluarga.setId_kelurahan(id_kelurahan1);
	    	
	    	pendudukDAO.addkeluarga(keluarga);
			model.addAttribute("nomor_kk", keluarga.getNomor_kk());
			return "suksesTambahKeluarga";
	    	
	    }
	    
	    @RequestMapping(value = "/penduduk/ubah/{nik}")
	    public String updateP (Model model, @PathVariable(value = "nik") String nik)
	    {
	    	PendudukModel penduduk = pendudukDAO.selectPenduduk(nik);
	    	
	    	if (penduduk != null) {
	    		model.addAttribute ("penduduk", penduduk);
	            return "updatePenduduk";
	        } else {
	        	model.addAttribute ("nik", nik);
	            return "not-found";
	        }
	    }
	    
	    
		 @RequestMapping(value = "/penduduk/ubah/{nik}" , method = RequestMethod.POST)
		    public String updateP(@ModelAttribute PendudukModel penduduk, Model model,@RequestParam (value = "golongan_darah", required = false) String golongan_darah)
		    {
			 String[] tanggal_lahir = penduduk.getTanggal_lahir().split("-");
			 String NikLama = penduduk.getNik();	

			 
			 int tahun = (Integer.parseInt(tanggal_lahir[0]) % 1000) %100;
			 int bulan = (Integer.parseInt(tanggal_lahir[1]));
			 int hari = (Integer.parseInt(tanggal_lahir[2]));
			   
			   if(penduduk.getJenis_kelamin()==1) {
			    hari = hari + 40;
			   }
			  
			   	penduduk.setGolongan_darah(golongan_darah);
			   	log.info(golongan_darah);
			   	
			   	String id_kelurahan = pendudukDAO.selectPidK(penduduk.getId_keluarga());
			   	String kode_kecamatan = pendudukDAO.selectKodeKecamatan(id_kelurahan).substring(0, 6);
		    	
		    	String awal = kode_kecamatan + String.format("%02d", hari) + String.format("%02d", bulan) + String.format("%02d", tahun);
		    	String generate = awal + "%";
		    	
		    	int hitungPenduduk = pendudukDAO.hitungPenduduk(generate);
		   
		    	String getNewNIK = awal + String.format("%04d", hitungPenduduk + 1);
		    	
		    	penduduk.setNik(getNewNIK);
		    	log.info(getNewNIK);
		    	
		    	log.info(penduduk.getNamaPenduduk());
		    	log.info(penduduk.getIdPenduduk());
		    	
		    	
		    	pendudukDAO.updatePenduduk(penduduk);
		    	model.addAttribute("nik", NikLama);
		    	return "suksesUbahPenduduk";
		    }
		 
		  @RequestMapping(value = "/keluarga/ubah/{nkk}")
		    public String updateK (Model model, @PathVariable(value = "nkk") String nkk)
		    {
		    	KeluargaModel keluarga = pendudukDAO.selectKeluarga(nkk);
		    	AlamatModel alamat = pendudukDAO.selectAlamat(keluarga.getId());

		    	String nama_kelurahan = alamat.getNama_kelurahan();
		    	String nama_kecamatan = alamat.getNama_kecamatan();
		    	String nama_kota = alamat.getNama_kota();
		    	keluarga.setNama_kelurahan(nama_kelurahan);
		    	keluarga.setNama_kecamatan(nama_kecamatan);
		    	keluarga.setNama_kota(nama_kota);
		    	
		    	log.info(nama_kecamatan);
		    	
		    	if (keluarga != null) {
		    		model.addAttribute ("keluarga", keluarga);
		            return "updateKeluarga";
		        } else {
		        	model.addAttribute ("nkk", nkk);
		            return "not-found";
		        }
		    }
		    
		    @RequestMapping(value = "/keluarga/ubah/{nkk}", method = RequestMethod.POST)
		    public String updateK (@PathVariable(value = "nkk", required = false) String nkk,
		    		@RequestParam(value = "nama_kecamatan", required = false) String nama_kecamatan,
		    		@RequestParam(value = "alamat", required = false) String alamat,
		    		@RequestParam(value = "rt", required = false) String RT,
		    		@RequestParam(value = "rw", required = false) String RW,
		    		@RequestParam(value = "nama_kota", required = false) String nama_kota,
		    		@RequestParam(value = "nama_kelurahan", required = false) String nama_kelurahan,
		    		@ModelAttribute KeluargaModel keluarga, Model model) {
				
		    	String date = new SimpleDateFormat("ddMMyy").format(Calendar.getInstance().getTime());
		    	
		    	String kode_kecamatan = pendudukDAO.selectKodeKecamatan2(nama_kecamatan).substring(0,6);
		  
		    	
		    	
		    	String id_kelurahan1 = pendudukDAO.selectKelurahanId(nama_kelurahan); //udah dapet id
		    	
		    	String awal = kode_kecamatan + date;
		    	String generate = awal + "%";
		    	
		    	int hitungKeluarga = pendudukDAO.hitungKeluarga(generate);
		    	
		    	String nomor_kk = awal + String.format("%04d", hitungKeluarga + 1);
		    	System.out.println(nomor_kk);
		    	
		    	keluarga.setNomor_kk(nomor_kk);
		    	keluarga.setId_kelurahan(id_kelurahan1);
		    	
		    	pendudukDAO.updateKeluarga(keluarga);
				model.addAttribute("nomor_kk", nkk);
				return "suskesUbahKeluarga";
		    	
		    }
		    
		    @RequestMapping(value = "/penduduk/mati", method = RequestMethod.POST)
		    public String pendudukMati (Model model,
		            @ModelAttribute PendudukModel penduduk)
		    {
		    	penduduk = pendudukDAO.selectPenduduk(penduduk.getNik());
		    	
		    	penduduk.setIs_wafat(1);
		    	pendudukDAO.updatePenduduk(penduduk);
		    	model.addAttribute("nik", penduduk.getNik());
		    	
		    	return "suksesMati";
		    	
		    }
	
}
