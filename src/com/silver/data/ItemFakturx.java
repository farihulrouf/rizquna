package com.silver.data;

import java.math.BigDecimal;

public class ItemFakturx {
	 private String namaBarang;
	    private String qty;
	    private String harga, total;
	    
	    public ItemFakturx(String namaBarang, String qty, String harga, String total) {
	        this.namaBarang = namaBarang;
	        this.qty = qty;
	        this.harga = harga;
	        this.total = total;
	    }
	 
	    public String getNamaBarang() {
	        return namaBarang;
	    }
	 
	    public String getTotal() {
			return total;
		}

		public void setTotal(String total) {
			this.total = total;
		}

		public String getQty() {
	        return qty;
	    }
	 
	    public String getHarga() {
	        return harga;
	    }
	 
}
