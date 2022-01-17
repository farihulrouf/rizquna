package com.silver.dao;

import com.silver.data.Pelanggan;
import java.util.List;

public interface DaoPelanggan {
  void insertPelanggan(Pelanggan paramPelanggan) throws ErrorInfo;
  
  void updatePelanggan(Pelanggan paramPelanggan) throws ErrorInfo;
  
  List<Pelanggan> selectAllpelanggan() throws ErrorInfo;
  
  List<Pelanggan> cariPelanggan(String paramString) throws ErrorInfo;
  
  List<Pelanggan> cariPelangganKode(String paramString) throws ErrorInfo;
  
  void deletePelanggan(String paramString) throws ErrorInfo;
  
  Pelanggan getPelanggan(String paramString) throws ErrorInfo;
}
