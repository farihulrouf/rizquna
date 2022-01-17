package com.silver.dao;

import com.silver.data.Pegawai;
import java.util.List;

public interface DaoPengguna {
  void insertPengguna(Pegawai paramPegawai) throws ErrorInfo;
  
  void updatePengguna(Pegawai paramPegawai) throws ErrorInfo;
  
  void deletePengguna(String paramString) throws ErrorInfo;
  
  List<Pegawai> selectAll() throws ErrorInfo;
  
  List<Pegawai> selectAll(String paramString) throws ErrorInfo;
  
  Pegawai getAdmin(int paramInt) throws ErrorInfo;
  
  int selectCount(Pegawai paramPegawai) throws ErrorInfo;
  
  List<Pegawai> selectAllDua() throws ErrorInfo;
}
