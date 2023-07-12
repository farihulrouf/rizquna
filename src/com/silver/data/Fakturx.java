package com.silver.data;
import java.util.ArrayList;
import java.util.List;


public class Fakturx {
	 private String nomorFaktur;
	 private String kasir;
	 private String tunai;
	 private String kembali;
	 private String jam;
	 private String tanggal;
	 public String getTanggal() {
		return tanggal;
	}

	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}

	private String totalx;
	    public String getKasir() {
		return kasir;
	}

	public void setKasir(String kasir) {
		this.kasir = kasir;
	}

		private List<ItemFakturx> listItemFakturx = new ArrayList<ItemFakturx>();
	 
	    public String getTunai() {
			return tunai;
		}

		public void setTunai(String tunai) {
			this.tunai = tunai;
		}

		public String getKembali() {
			return kembali;
		}

		public void setKembali(String kembali) {
			this.kembali = kembali;
		}

		public String getJam() {
			return jam;
		}

		public void setJam(String jam) {
			this.jam = jam;
		}

		public List<ItemFakturx> getListItemFakturx() {
			return listItemFakturx;
		}

		public void setListItemFakturx(List<ItemFakturx> listItemFakturx) {
			this.listItemFakturx = listItemFakturx;
		}

		public void setNomorFaktur(String nomorFaktur) {
			this.nomorFaktur = nomorFaktur;
		}

		public Fakturx(String nomorFaktur, String kasir, String tunai, String kembali, String jam, String totalx, String tanggal) {
	        this.nomorFaktur = nomorFaktur;
	        this.kasir = kasir;
	        this.tunai = tunai;
	        this.kembali = kembali;
	        this.jam = jam;
	        this.totalx = totalx;
	        this.tanggal = tanggal;
	    }
	 


		public String getTotalx() {
			return totalx;
		}

		public void setTotalx(String totalx) {
			this.totalx = totalx;
		}

		public String getNomorFaktur() {
	        return nomorFaktur;
	    }
	 
	    public List<ItemFakturx> getListItemFaktur() {
	        return listItemFakturx;
	    }
	 
	    public void tambahItemFakturx(ItemFakturx itemFaktur) {
	        this.listItemFakturx.add(itemFaktur);
	    }

}
