package view;

 
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class FakturDua {
  NumberFormat formatter = NumberFormat.getCurrencyInstance();
  
  private String jam;
  
  private String nomorFaktur;
  
  private String tanggal;
  
  private String total;
  
  private String tunai;
  
  private String kembali;
  
  private String nama;
  
  public String getNama() {
    return this.nama;
  }
  
  public void setNama(String nama) {
    this.nama = nama;
  }
  
  private List<ItemFakturDua> listItemFakturDua = new ArrayList<>();
  
  private int poin;
  
  public void setListItemFakturDua(List<ItemFakturDua> listItemFakturDua) {
    this.listItemFakturDua = listItemFakturDua;
  }
  
  public int getPoin() {
    return this.poin;
  }
  
  public void setPoin(int poin) {
    this.poin = poin;
  }
  
  public String getKembali() {
    return this.kembali;
  }
  
  public String getTunai() {
    return this.tunai;
  }
  
  public String getTotal() {
    return this.total;
  }
  
  public String getTanggal() {
    return this.tanggal;
  }
  
  public FakturDua(String nomorFaktur, String tanggal, String jam, String total, String tunai, String kembali, int poin, String nama) {
    this.nomorFaktur = nomorFaktur;
    this.tanggal = tanggal;
    this.total = total;
    this.tunai = tunai;
    this.kembali = kembali;
    this.jam = jam;
    this.poin = poin;
    this.nama = nama;
  }
  
  public String getJam() {
    return this.jam;
  }
  
  public void setJam(String jam) {
    this.jam = jam;
  }
  
  public String getNomorFaktur() {
    return this.nomorFaktur;
  }
  
  public void tambahItemFaktur(ItemFakturDua itemFaktur) {
    this.listItemFakturDua.add(itemFaktur);
  }
  
  public List<ItemFakturDua> getListItemFakturDua() {
    return this.listItemFakturDua;
  }
}
