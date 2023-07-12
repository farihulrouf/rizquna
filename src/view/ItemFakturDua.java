package view;

 

public class ItemFakturDua {
  private String namaBarang;
  
  private String qty;
  
  private String harga;
  
  private String total;
  
  public ItemFakturDua(String namaBarang, String qty, String harga, String total) {
    this.namaBarang = namaBarang;
    this.qty = qty;
    this.harga = harga;
    this.total = total;
  }
  
  public String getNamaBarang() {
    return this.namaBarang;
  }
  
  public String getQty() {
    return this.qty;
  }
  
  public String getHarga() {
    return this.harga;
  }
  
  public String getTotal() {
    return this.total;
  }
}
