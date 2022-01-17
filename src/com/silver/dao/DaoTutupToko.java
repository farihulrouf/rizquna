package com.silver.dao;

import com.silver.data.tutup_toko;
import java.util.List;

public interface DaoTutupToko {
  List<tutup_toko> selectAllbarang() throws ErrorInfo;
  
  List<tutup_toko> select() throws ErrorInfo;
  
  void insertBarang(tutup_toko paramtutup_toko) throws ErrorInfo;
  
  List<tutup_toko> selectTutup(String paramString) throws ErrorInfo;
  
  List<tutup_toko> selectDari(String paramString1, String paramString2) throws ErrorInfo;
  
  List<tutup_toko> selectDari2(String paramString1, String paramString2) throws ErrorInfo;
}
