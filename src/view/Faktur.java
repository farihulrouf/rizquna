package view;

 

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Faktur {
  NumberFormat formatter = NumberFormat.getCurrencyInstance();
  
  private String nomorFaktur;
  
  private String tanggal;
  
  private String total;
  
  private String tunai;
  
  private String kembali;
  
  public String getKembali() {
    return this.kembali;
  }
  
  public String getTunai() {
    return this.tunai;
  }
  
  public String getTotal() {
    return this.total;
  }
  
  private List<ItemFaktur> listItemFaktur = new ArrayList<>();
  
  public String getTanggal() {
    return this.tanggal;
  }
  
  public Faktur(String nomorFaktur, String tanggal, String total, String tunai, String kembali) {
    this.nomorFaktur = nomorFaktur;
    this.tanggal = tanggal;
    this.total = total;
    this.tunai = tunai;
    this.kembali = kembali;
  }
  
  public String getNomorFaktur() {
    return this.nomorFaktur;
  }
  
  public List<ItemFaktur> getListItemFaktur() {
    return this.listItemFaktur;
  }
  
  public void tambahItemFaktur(ItemFaktur itemFaktur) {
    this.listItemFaktur.add(itemFaktur);
  }
}
