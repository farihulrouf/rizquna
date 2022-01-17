package view;

 
public class ItemFaktur {
  private String namaBarang;
  
  private Integer qty;
  
  private Double harga;
  
  public ItemFaktur(String namaBarang, Integer qty, Double harga) {
    this.namaBarang = namaBarang;
    this.qty = qty;
    this.harga = harga;
  }
  
  public Double getHarga() {
    return this.harga;
  }
  
  public String getNamaBarang() {
    return this.namaBarang;
  }
  
  public Integer getQty() {
    return this.qty;
  }
}
