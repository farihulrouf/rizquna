package view;

 

public class ItemFakturtiga {
  private String namaBarang;
  
  private Integer qty;
  
  private String harga;
  
  private String total;
  
  public ItemFakturtiga(String namaBarang, Integer qty, String harga, String total) {
    this.namaBarang = namaBarang;
    this.qty = qty;
    this.harga = harga;
    this.total = total;
  }
  
  public String getTotal() {
    return this.total;
  }
  
  public void setTotal(String total) {
    this.total = total;
  }
  
  public String getNamaBarang() {
    return this.namaBarang;
  }
  
  public Integer getQty() {
    return this.qty;
  }
  
  public String getHarga() {
    return this.harga;
  }
}
