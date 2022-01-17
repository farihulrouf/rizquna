package com.silver.dao;

import com.silver.data.Barang;
import java.util.List;

public interface DaoBarang {
  void insertBarang(Barang paramBarang) throws ErrorInfo;
  
  void updateBarang(Barang paramBarang) throws ErrorInfo;
  
  List<Barang> selectAllbarang() throws ErrorInfo;
  
  List<Barang> cariBarang(String paramString) throws ErrorInfo;
  
  List<Barang> cariBarangKode(String paramString) throws ErrorInfo;
  
  void deleteBarang(String paramString) throws ErrorInfo;
  
  Barang getBarang(String paramString) throws ErrorInfo;
}
