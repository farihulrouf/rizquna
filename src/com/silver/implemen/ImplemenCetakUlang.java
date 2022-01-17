package com.silver.implemen;

import com.silver.dao.DaoCetakUlang;
import com.silver.dao.ErrorInfo;
import com.silver.data.CetakUlang;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ImplemenCetakUlang implements DaoCetakUlang {
  private Connection con;
  
  public ImplemenCetakUlang(Connection con) {
    this.con = con;
  }
  
  public List<CetakUlang> CetakUlangData(String nomerTransaksi) throws ErrorInfo {
    Statement statement = null;
    List<CetakUlang> list = new ArrayList<>();
    try {
      this.con.setAutoCommit(false);
      statement = this.con.createStatement();
      ResultSet result = 
        statement.executeQuery("\nSELECT barang.nama_barang as nama_barang, barang.kd_barang as kd_barang, detail_jual.id_jual as id_jual, detail_jual.harga_jual as harga_jual, detail_jual.jumlah as jumlah, detail_jual.harga_jual * detail_jual.jumlah as total FROM barang JOIN detail_jual ON barang.kd_barang = detail_jual.kd_barang where detail_jual.id_jual=" + 
          
          nomerTransaksi + ";");
      while (result.next()) {
        CetakUlang cetakUlang = new CetakUlang();
        cetakUlang.setId_jual(result.getInt("id_jual"));
        cetakUlang.setKode_barang(result.getString("kd_barang"));
        cetakUlang.setNama_barang(result.getString("nama_barang"));
        cetakUlang.setHarga_jual(Double.valueOf(result.getDouble("harga_jual")));
        cetakUlang.setQty(result.getInt("jumlah"));
        cetakUlang.setTotal(Double.valueOf(result.getDouble("total")));
        list.add(cetakUlang);
      } 
      this.con.commit();
      return list;
    } catch (SQLException exception) {
      try {
        this.con.rollback();
      } catch (SQLException sQLException) {}
      throw new ErrorInfo(exception.getMessage());
    } finally {
      try {
        this.con.setAutoCommit(true);
      } catch (SQLException sQLException) {}
      if (statement != null)
        try {
          statement.close();
        } catch (SQLException sQLException) {} 
    } 
  }
}
