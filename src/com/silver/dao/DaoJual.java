package com.silver.dao;

import com.silver.data.Jual;
import java.util.List;

public interface DaoJual {
  void insertJual(Jual paramJual) throws ErrorInfo;
  
  List<Jual> CariNotmerTransaksi(String paramString) throws ErrorInfo;
  
  List<Jual> TampilkanReport() throws ErrorInfo;
  
  List<Jual> TampilkanPerjam() throws ErrorInfo;
  
  List<Jual> TampilkanTanggal(String paramString) throws ErrorInfo;
  
  List<Jual> TampilkanPerPc() throws ErrorInfo;
}
