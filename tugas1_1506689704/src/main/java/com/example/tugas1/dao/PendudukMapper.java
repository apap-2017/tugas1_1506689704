package com.example.tugas1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Many;

import com.example.tugas1.model.AlamatModel;
import com.example.tugas1.model.KecamatanModel;
import com.example.tugas1.model.KeluargaModel;
import com.example.tugas1.model.KelurahanModel;
import com.example.tugas1.model.KotaModel;
import com.example.tugas1.model.PendudukModel;

@Mapper
public interface PendudukMapper {
	  @Select("select id, nik, nama, tempat_lahir, tanggal_lahir, golongan_darah, agama,status_perkawinan, pekerjaan,is_wni,is_wafat, id_keluarga, jenis_kelamin, status_dalam_keluarga from penduduk where nik = #{nik}")
	    @Results(value = {
	    		@Result(property="idPenduduk", column="id"),
	    		@Result(property="nik", column="nik"),
	    		@Result(property="namaPenduduk", column="nama"),
	    		@Result(property="tempat_lahir", column="tempat_lahir"),
	    		@Result(property="tanggal_lahir", column="tanggal_lahir"),
	    		@Result(property="golongan_darah", column="golongan_darah"),
	    		@Result(property="agama", column="agama"),
	    		@Result(property="status_perkawinan", column="status_perkawinan"),
	    		@Result(property="pekerjaan", column="pekerjaan"),
	    		@Result(property="is_wni", column="is_wni"),
	    		@Result(property="is_wafat", column="is_wafat"),
	    		@Result(property="id_keluarga", column="id_keluarga"),
	    		@Result(property="jenis_kelamin", column="jenis_kelamin"),
	    		@Result(property="status_dalam_keluarga", column="status_dalam_keluarga")
	    		
	    })
	    PendudukModel selectPenduduk (@Param("nik") String nik);
	  	
	  	@Select("select K.alamat, K.rt, K.rw, E.nama_kelurahan, C.nama_kecamatan, O.nama_kota from keluarga K, kelurahan E, kecamatan C, kota O "
	  			+ "where  K.id_kelurahan = E.id AND E.id_kecamatan = C.id AND C.id_kota = O.id AND K.id = #{id_keluarga}")
	  	 @Results(value = {
		    		@Result(property="alamat", column="alamat"),
		    		@Result(property="rt", column="rt"),
		    		@Result(property="rw", column="rw"),
		    		@Result(property="nama_kelurahan", column="nama_kelurahan"),
		    		@Result(property="nama_kecamatan", column="nama_kecamatan"),
		  			@Result(property="nama_kota", column="nama_kota")
	  	 })
		AlamatModel selectAlamat(@Param ("id_keluarga") String id_keluarga);
	  	

	  
	  @Select("select id, nomor_kk, alamat, rt, rw from keluarga where nomor_kk = #{nkk}")
	    @Results(value = {
	    		@Result(property="id", column="id"),
	    		@Result(property="nomor_kk", column="nomor_kk"),
	    		@Result(property="alamat", column="alamat"),
	    		@Result(property="rt", column="rt"),
	    		@Result(property="rw", column="rw"),
	    		@Result(property="penduduks", column="nomor_kk",
	    		javaType = List.class,
	    		many=@Many(select="selectAnggota"))
	    })

	    KeluargaModel selectKeluarga (@Param("nkk") String nkk);
	  
	  	
	  @Select("select nama, nik, jenis_kelamin, tempat_lahir, tanggal_lahir, agama, pekerjaan, status_perkawinan, status_dalam_keluarga, is_wni " +
	    		"from penduduk join keluarga " +
	    		"on keluarga.id = penduduk.id_keluarga " +
	    		"where keluarga.nomor_kk = #{nkk}")
	  @Results(value = {
			  @Result(property="namaPenduduk", column="nama"),
	  })
	  	List<PendudukModel> selectAnggota (@Param("nkk") String nkk);
	  
	  
	  @Select("SELECT COUNT(nik) FROM penduduk WHERE nik LIKE #{query}")
		int hitungPenduduk(String query);
	  
	  @Select("select id_kelurahan from keluarga where id = #{id_kelurahan}")
		String selectPidK(String id_kelurahan);
	  
	  @Select("select kode_kecamatan from kecamatan ke, kelurahan kel where kel.id = #{id_kelurahan} AND "
				+ "ke.id = kel.id_kecamatan")
		String selectKodeKecamatan(String id_kelurahan);
	  
	  @Insert("INSERT INTO penduduk (nik, jenis_kelamin, nama, tempat_lahir, tanggal_lahir, golongan_darah, agama, "
				+ "status_perkawinan, pekerjaan, is_wni, is_wafat, id_keluarga, status_dalam_keluarga) "
				+ "VALUES (#{nik}, #{jenis_kelamin}, #{namaPenduduk}, #{tempat_lahir}, "
				+ "#{tanggal_lahir}, #{golongan_darah}, #{agama}, #{status_perkawinan}, #{pekerjaan}, "
				+ "#{is_wni}, #{is_wafat},#{id_keluarga},#{status_dalam_keluarga})")
	    void addPenduduk (PendudukModel penduduk);
	 
	  @Update("UPDATE penduduk SET nik = #{nik}, jenis_kelamin = #{jenis_kelamin}, nama = #{namaPenduduk}, tempat_lahir = #{tempat_lahir}, "
	  		+ "tanggal_lahir =  #{tanggal_lahir}, golongan_darah = #{golongan_darah}, agama = #{agama}, status_perkawinan =  #{status_perkawinan}, "
	  		+ "pekerjaan = #{pekerjaan}, is_wni = #{is_wni}, is_wafat = #{is_wafat}, id_keluarga = #{id_keluarga}, status_dalam_keluarga = #{status_dalam_keluarga} "
	  		+ "WHERE  id = #{idPenduduk}")
	  	void updatePenduduk (PendudukModel penduduk);
	  
	  @Update("UPDATE keluarga SET nomor_kk = #{nomor_kk}, alamat = #{alamat}, RT = #{rt}, RW = #{rw}, id_kelurahan = #{id_kelurahan}, is_tidak_berlaku = #{is_tidak_berlaku} "
	  		+ "WHERE id = #{id}")
	    void updateKeluarga (KeluargaModel keluarga);

	  	@Select("select kode_kecamatan from kecamatan where nama_kecamatan = #{nama_kecamatan}")
		String selectKodeKecamatan2(String nama_kecamatan);
		
		@Select("select id from kelurahan where nama_kelurahan = #{nama_kelurahan}")
		String selectKelurahanId(String nama_kelurahan);

		@Select("SELECT COUNT(nomor_kk) FROM keluarga WHERE nomor_kk LIKE #{query}")
		int hitungKeluarga(String query);
		
		@Select("select id_kelurahan from keluarga where id = #{id_kelurahan}")
		String selectKeluargaId(String id_kelurahan);
		
		@Insert("insert into keluarga (nomor_kk,alamat,RT,RW,id_kelurahan,is_tidak_berlaku) "
				   + "values ('${nomor_kk}','${alamat}','${rt}','${rw}','${id_kelurahan}',0)")
		void addKeluarga (KeluargaModel keluarga);		
		
		@Update("UPDATE penduduk SET isWafat = 1 WHERE nik = #{nik}")
		void updateMati(@Param("nik") String nik);
		
}
