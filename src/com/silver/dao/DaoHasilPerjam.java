package com.silver.dao;

import com.silver.data.JamLaporan;
import java.util.List;

public interface DaoHasilPerjam {
  List<JamLaporan> selectAll() throws ErrorInfo;
  
  List<JamLaporan> selectAlldua() throws ErrorInfo;
  
  List<JamLaporan> pilihTanggal(String paramString1, String paramString2) throws ErrorInfo;
  
  List<JamLaporan> pilihTanggal2(String paramString1, String paramString2) throws ErrorInfo;
}
