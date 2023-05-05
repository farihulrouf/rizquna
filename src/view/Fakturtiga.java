package view;

import java.util.ArrayList;
import java.util.List;

public class Fakturtiga {
  private String jam;
  
  private String tanggal;
  
  private String total;
  
  private String tunai;
  
  private String nama;
  
  private String kembali;
  
  private String nomorFaktur;
  
  private double poin;
  
  public String getNama() {
    return this.nama;
  }
  
  public void setNama(String nama) {
    this.nama = nama;
  }
  
  public String getTanggal() {
    return this.tanggal;
  }
  
  public String getTotal() {
    return this.total;
  }
  
  public String getTunai() {
    return this.tunai;
  }
  
  public String getKembali() {
    return this.kembali;
  }
  
  public Double getPoin() {
    return this.poin;
  }
  
  public String getJam() {
    return this.jam;
  }
  
  private List<ItemFakturtiga> listItemFaktur = new ArrayList<>();
  
  public Fakturtiga(String nomorFaktur, String tanggal, String jam, String total, String tunai, String kembali, double poin, String nama) {
    this.nomorFaktur = nomorFaktur;
    this.tanggal = tanggal;
    this.total = total;
    this.tunai = tunai;
    this.kembali = kembali;
    this.jam = jam;
    this.poin = poin;
    this.nama = nama;
  }
  
  public String getNomorFaktur() {
    return this.nomorFaktur;
  }
  
  public List<ItemFakturtiga> getListItemFaktur() {
    return this.listItemFaktur;
  }
  
  public void tambahItemFaktur(ItemFakturtiga itemFaktur) {
    this.listItemFaktur.add(itemFaktur);
  }
}
