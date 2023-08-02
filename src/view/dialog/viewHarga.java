package view.dialog;

import com.silver.data.Harga;
import com.silver.model.table.TableModelHarga;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import view.AdminKasir;
import view.Koneksi;

public class viewHarga extends JDialog {
  private final JPanel contentPanel = new JPanel();
  
  private TableModelHarga tableModel;
  
  private JLabel Jlablediskon1;
  private JLabel lblpoin;

  private JLabel Jlablediskon2;
  private JLabel Jlabelstatus_1;
  private Harga harga;
  private JLabel lblNewLabel;
  private JLabel Jlabelstatus;
  
  Locale locale = new Locale("en", "UK");
  
  private JLabel jLjLabelStatuttext;
  
  DecimalFormat df = (DecimalFormat)NumberFormat.getNumberInstance(this.locale);
  
  public static Double harga_barang;
  private JLabel lblbarcodeBarang;
  
  public Double getHarga_barang() {
    return harga_barang;
  }
  
  public void setHarga_barang(Double harga_barang) {
    viewHarga.harga_barang = harga_barang;
  }
  
  private String[] columns = new String[] { "harga", "Rp" };
  
  
  public String jumlah;
  
  private String barcode;
  
  private int poin;
  
  private int status;
  
  private int persediaanBarang;
  //private AdminKasir adminksir = new AdminKasir();
  
  public int getPersediaanBarang() {
    return this.persediaanBarang;
  }
  
  public void setPersediaanBarang(int persediaanBarang) {
    this.persediaanBarang = persediaanBarang;
  }
  
  public int getStatus() {
    return this.status;
  }
  
  public void setStatus(int status) {
    this.status = status;
  }
  
  public int getPoin() {
    return this.poin;
  }
  
  public void setPoin(int poin) {
    this.poin = poin;
  }
  
  public String getJumlah() {
    return this.jumlah;
  }
  
  public void setJumlah(String jumlah) {
    this.jumlah = jumlah;
  }
  
  public String getBarcode() {
    return this.barcode;
  }
  
  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }
  
  DefaultTableModel tableModel2 = new DefaultTableModel(
      new Object[0][], (Object[])new String[] { "harga", "nominal" }) {
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };
  
  private JTextField textField;
  
  Object[][] data;
  
  private JTextField textField_1;
  private  JLabel lblNewLabel_1;
  private JTextField textField_2;
  
  private JTextField textField_3;
  
  private JTextField textField_4;
  private JTextField barcodeTextField;
  
  public viewHarga(AdminKasir parent, int persediaan, int poin, String nama, final Double harga1, final Double haraga2, final Double harga3,
		  Double harga_beli, String status, boolean modal, int mindiskon, int mindiskon2, String barcodeAdmin) {
    setModal(true);
    setBackground(new Color(1.0F, 1.0F, 1.0F, 0.0F));

   // setBackground(new Color(211, 211, 211));
    this.tableModel = new TableModelHarga();
    this.harga = new Harga();
     setBounds(0, 10, 1280, 400);
    getContentPane().setLayout(new BorderLayout());
    //this.contentPanel.setBackground(new Color(30, 144, 255));
    this.contentPanel.setBackground(new Color(1.0F, 1.0F, 1.0F, 0.0F));

    this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(this.contentPanel, "Center");
    this.data = new Object[][] { { "harga ecerl", harga1 }, { "harga kulak", haraga2 }, { "harga carton", harga3 } };
    this.contentPanel.setLayout((LayoutManager)null);
    setPoin(poin);
    setStatus(Integer.parseInt(status));
    setPersediaanBarang(persediaan);
    contentPanel.setLayout(null);
    contentPanel.setLayout(null);
    
   // setModal(true);

    this.lblbarcodeBarang = new JLabel(barcodeAdmin);
    this.lblbarcodeBarang.setFont(new Font("Lucida Grande", 0, 5));
    this.lblbarcodeBarang.setForeground(Color.ORANGE);
    this.lblbarcodeBarang.setBackground(new Color(1.0F, 1.0F, 1.0F, 0.2F));
    this.lblbarcodeBarang.setBounds(20, 141, 200, 33);
    this.contentPanel.add(this.lblbarcodeBarang);
    this.textField = new JTextField();
    this.textField.addKeyListener(new KeyAdapter() {
    	
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
            case 40:
            	viewHarga.this.textField.setBackground(Color.WHITE);
            	viewHarga.this.textField_1.setBackground(Color.GREEN);
            	viewHarga.this.textField_1.requestFocus();
              break;
            case 38:
            	viewHarga.this.barcodeTextField.requestFocus();
            	viewHarga.this.barcodeTextField.setBackground(Color.GREEN);
              break;
            case 10:
            	viewHarga.this.ambilDataBarang();
            	//viewharge.this.text
            	viewHarga.this.dispose();
              break;
          }  
          }
        });
    this.textField.setText("1");
    this.textField.selectAll();
    this.textField.setFont(new Font("Dialog", 1, 24));
    this.textField.setBounds(557, 126, 70, 48);
    this.contentPanel.add(this.textField);
    this.textField.setColumns(10);
    JLabel lblJumlah = new JLabel("Jumlah");
    lblJumlah.setForeground(new Color(0, 0, 0));
    lblJumlah.setFont(new Font("Dialog", 1, 20));
    lblJumlah.setBounds(397, 135, 112, 33);
    this.contentPanel.add(lblJumlah);
    JButton btnNewButton = new JButton("Simpan");
    btnNewButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {}
        });
    btnNewButton.setBounds(605, 392, 133, 33);
    this.contentPanel.add(btnNewButton);
    this.lblpoin = new JLabel((new StringBuilder(String.valueOf(poin))).toString());
    //this.lblpoin.setForeground(new Color(1.0F, 1.0F, 1.0F, 0.0F));
    this.lblpoin.setFont(new Font("Dialog", Font.BOLD, 20));
    this.lblpoin.setBounds(807, 137, 140, 29);
    this.contentPanel.add(lblpoin);
    this.textField_1 = new JTextField();
    this.textField_1.setFont(new Font("Dialog", 1, 25));
    this.textField_1.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
              case 40:
                viewHarga.this.textField_1.setBackground(Color.WHITE);
                viewHarga.this.textField_2.requestFocus();
                viewHarga.this.textField_2.setBackground(Color.GREEN);
                break;
              case 38:
                viewHarga.this.textField_1.setBackground(Color.WHITE);
                viewHarga.this.textField.requestFocus();
                viewHarga.this.textField.setBackground(Color.GREEN);
                break;
              case 10:
            	  ambilHargaSatu();
                 viewHarga.this.dispose();
                break;
            } 
          }
        });
    this.textField_1.setBounds(530, 186, 150, 33);
    this.textField_1.setText(this.df.format(harga1));
    this.contentPanel.add(this.textField_1);
    this.textField_1.setColumns(10);
    this.textField_2 = new JTextField();
    this.textField_2.setFont(new Font("Dialog", 1, 25));
    this.textField_2.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
              case 40:
                viewHarga.this.textField_3.requestFocus();
                viewHarga.this.textField_3.setBackground(Color.GREEN);
                viewHarga.this.textField_2.setBackground(Color.WHITE);
                break;
              case 38:
                viewHarga.this.textField_1.requestFocus();
                viewHarga.this.textField_1.setBackground(Color.GREEN);
                viewHarga.this.textField_2.setBackground(Color.WHITE);
                break;
              case 10:
                /*viewHarga.this.ambil_satu(haraga2);
                if (viewHarga.this.getStatus() == 1) {
                  viewHarga.this.cekStatus();
                  break;
                } 
                */
            	 ambilHargaDua();
                viewHarga.this.dispose();
                break;
            } 
          }
        });
    this.textField_2.setColumns(10);
    this.textField_2.setBounds(530, 238, 150, 33);
    this.textField_2.setText(this.df.format(haraga2));
    this.contentPanel.add(this.textField_2);
    this.textField_3 = new JTextField();
    this.textField_3.setFont(new Font("Dialog", 1, 25));
    this.textField_3.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
              case 40:
                viewHarga.this.textField_3.setBackground(Color.WHITE);
                viewHarga.this.textField.requestFocus();
                viewHarga.this.textField.setBackground(Color.GREEN);
                break;
              case 38:
                viewHarga.this.textField_3.setBackground(Color.WHITE);
                viewHarga.this.textField_2.requestFocus();
                viewHarga.this.textField_2.setBackground(Color.GREEN);
                break;
              case 10:
               // viewHarga.this.ambil_satu(harga3);
                ambilHargaTiga();
               /* if (viewHarga.this.getStatus() == 1) {
                  viewHarga.this.cekStatus();
                } else {
                  viewHarga.this.dispose();
                } 
                */
                dispose();
               // viewHarga.this.setVisible(false);
                break;
            } 
          }
        });
    
    JPanel panel_1 = new JPanel();
    panel_1.setBackground(new Color(255, 140, 0));
    panel_1.setBounds(705, 238, 100, 88);
    contentPanel.add(panel_1);
    panel_1.setLayout(null);
    Jlablediskon1 = new JLabel(String.valueOf(mindiskon));
    Jlablediskon1.setBounds(6, 6, 90, 31);
    panel_1.add(Jlablediskon1);
    Jlablediskon1.setForeground(new Color(0, 0, 0));
    Jlablediskon1.setFont(new Font("Dialog", 1, 25));
    Jlablediskon2 = new JLabel(String.valueOf(mindiskon2));
    Jlablediskon2.setBounds(6, 53, 90, 29);
    panel_1.add(Jlablediskon2);
    Jlablediskon2.setForeground(new Color(0, 0, 0));
    Jlablediskon2.setFont(new Font("Dialog", 1, 25));
    this.textField_3.setColumns(10);
    
    this.textField_3.setBounds(530, 293, 150, 33);
    this.textField_3.setText(this.df.format(harga3));
    this.contentPanel.add(this.textField_3);
    JLabel lblHargaEcer = new JLabel("Harga Ecer");
    lblHargaEcer.setForeground(new Color(0, 0, 0));
    lblHargaEcer.setFont(new Font("Dialog", 1, 18));
    lblHargaEcer.setBounds(362, 189, 118, 33);
    this.contentPanel.add(lblHargaEcer);
    JLabel lblHargaKulak = new JLabel("Harga Kulak");
    lblHargaKulak.setForeground(new Color(0, 0, 0));
    lblHargaKulak.setFont(new Font("Dialog", 1, 18));
    lblHargaKulak.setBounds(362, 241, 174, 33);
    this.contentPanel.add(lblHargaKulak);
    JLabel lblHargaKarton = new JLabel("Harga Karton");
    lblHargaKarton.setForeground(new Color(0, 0, 0));
    lblHargaKarton.setFont(new Font("Dialog", 1, 18));
    lblHargaKarton.setBounds(362, 296, 174, 33);
    this.contentPanel.add(lblHargaKarton);
    
    JPanel panel = new JPanel();
    panel.setBackground(new Color(255, 140, 0));
    panel.setBounds(38, -16, 879, 130);
    contentPanel.add(panel);
    panel.setLayout(null);
    lblNewLabel = new JLabel(nama);
    lblNewLabel.setBounds(322, 54, 492, 51);
    panel.add(lblNewLabel);
    lblNewLabel.setForeground(new Color(0, 0, 0));
    lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 50));
    JLabel lblKodeBarcode = new JLabel("Persediaan");
    lblKodeBarcode.setBounds(236, 19, 117, 23);
    panel.add(lblKodeBarcode);
    lblKodeBarcode.setForeground(new Color(255, 255, 255));
    lblKodeBarcode.setFont(new Font("Dialog", 1, 15));
    lblNewLabel_1 = new JLabel(String.valueOf(persediaan));
    lblNewLabel_1.setBounds(236, 51, 100, 29);
    panel.add(lblNewLabel_1);
    lblNewLabel_1.setForeground(new Color(255, 255, 255));
    lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 24));
    barcodeTextField = new JTextField();
    barcodeTextField.setBounds(6, 19, 187, 47);
    panel.add(barcodeTextField);
    this.barcodeTextField.addKeyListener(new KeyAdapter() {
        public void keyPressed(KeyEvent e) {
          int keyCode = e.getKeyCode();
          switch (keyCode) {
            case 40:
              viewHarga.this.textField.setBackground(Color.WHITE);
              viewHarga.this.textField.setBackground(Color.GREEN);
              viewHarga.this.textField.selectAll();
              viewHarga.this.textField.requestFocus();
              break;
            case 38:
              viewHarga.this.ambilDataBarang();
              viewHarga.this.dispose();
              break;
          } 
        }
      });
    barcodeTextField.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		 if (viewHarga.this.barcodeTextField.getText().equals(viewHarga.this.lblbarcodeBarang.getText())) {
                 int jumlah_aja = 0;
                 jumlah_aja = 1 + Integer.parseInt(viewHarga.this.textField.getText());
                 //viewHarga.this.textField.setText(jumlah_aja);
                // viewHarga.this.CariBarang();
                 viewHarga.this.barcodeTextField.selectAll();
                 viewHarga.this.barcodeTextField.requestFocus();
                 viewHarga.this.textField.setText(jumlah_aja+"");

               } else if (viewHarga.this.barcodeTextField.getText().equals("")) {
                 System.out.println("kosong");
               } else {
                 viewHarga.this.ambilDataBarang();
                 viewHarga.this.CariBarang2();
                 viewHarga.this.barcodeTextField.selectAll();
                 viewHarga.this.barcodeTextField.requestFocus();
                 
               } 
             }
    	
    });
    barcodeTextField.setColumns(10);
    JLabel jLjLabelStatuttext_1 = new JLabel("status");
    jLjLabelStatuttext_1.setBounds(16, 85, 117, 23);
    panel.add(jLjLabelStatuttext_1);
    jLjLabelStatuttext_1.setForeground(new Color(255, 255, 255));
    jLjLabelStatuttext_1.setFont(new Font("Dialog", 1, 15));
    Jlabelstatus_1 = new JLabel(status);
    Jlabelstatus_1.setBounds(77, 78, 186, 29);
    panel.add(Jlabelstatus_1);
    Jlabelstatus_1.setForeground(new Color(255, 255, 255));
    Jlabelstatus_1.setFont(new Font("Dialog", 1, 25));
    JPanel buttonPane = new JPanel();
    buttonPane.setBackground(new Color(165, 42, 42));
    buttonPane.setLayout(new FlowLayout(2));
    getContentPane().add(buttonPane, "South");
    /*
    JButton okButton = new JButton("OK");
    okButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            viewHarga.this.klik();
            if (viewHarga.this.getStatus() == 1) {
              viewHarga.this.cekStatus();
            } else {
              viewHarga.this.dispose();
            } 
          }
        });
    okButton.setActionCommand("OK");
    buttonPane.add(okButton);
    getRootPane().setDefaultButton(okButton);
    JButton cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            if (viewHarga.this.getStatus() == 1) {
              viewHarga.this.cekStatus();
            } else {
              viewHarga.this.dispose();
            } 
          }
        });
    cancelButton.setActionCommand("Cancel");
    buttonPane.add(cancelButton);
    */
   // setLocationRelativeTo((Component)parent);
    setVisible(true);
  }
  
  private void klik() {
    setJumlah(this.textField.getText());
  }
  
  private void cekStatus() {
    System.out.println(getJumlah());
    System.out.println(getPersediaanBarang());
    if (getPersediaanBarang() - Integer.parseInt(getJumlah()) >= 1) {
      System.out.print("oke");
      dispose();
    } else {
      JOptionPane.showMessageDialog(this, "Hai tidak boleh melebihi persediaan");
    } 
  }
  
  private void ambil_satu(Double hargas) {
    setJumlah(this.textField.getText());
    setHarga_barang(hargas);
  }
  private void CariBarang2() {
	    boolean benar = true;
	    try {
	      Connection konek = Koneksi.getKoneksi();
	      Statement state = konek.createStatement();
	      String sql = "select nama_barang, harga_jual,harga_diskon,harga_lain,persediaan,balance,mindiskon,mindiskon2,harga_beli,id_kategori,satuan, poins, kd_barang from Barang WHERE kd_barang = '" + 
	        
	        this.barcodeTextField.getText() + "'";
	      ResultSet rs = state.executeQuery(sql);
	      if (rs.next()) {
	    	  lblNewLabel.setText("");

	    	  lblNewLabel.setText(rs.getString(1));
	          textField_1.setText(this.df.format(rs.getDouble(2)));
	         // setHarga1(Double.valueOf(rs.getDouble(2)));
	          this.textField_2.setText(this.df.format(rs.getDouble(3)));
	         // setHarga2(Double.valueOf(rs.getDouble(3)));
	          this.textField_3.setText(this.df.format(rs.getDouble(4)));
	        //  setHarga3(Double.valueOf(rs.getDouble(4)));
	          this.lblNewLabel_1.setText(rs.getInt(5)+"");
	         this.lblbarcodeBarang.setText(rs.getString(13));
	         Jlablediskon1.setText(rs.getInt(7)+"");
	          this.Jlablediskon2.setText(rs.getInt(8)+"");
	          System.out.println("nilai nya"+ rs.getInt(7));
	        //  this.lblpoin.setText(String.valueOf(rs.getInt(12)));
	          this.Jlabelstatus.setText((new StringBuilder(String.valueOf(rs.getInt(6)))).toString());
	          System.out.println(this.df.format(rs.getDouble(3)));
	          benar = false;
	      } 
	    } catch (Exception exception) {}
	  }
	  
	  private void CariBarang() {
	    boolean benar = true;
	    try {
	      Connection konek = Koneksi.getKoneksi();
	      Statement state = konek.createStatement();
	      String sql = "select nama_barang, harga_jual,harga_diskon,harga_lain,persediaan,balance,mindiskon,mindiskon2,harga_beli,id_kategori,satuan, poins, kd_barang from Barang WHERE kd_barang = '" + 
	        
	        this.barcodeTextField.getText() + "'";
	      ResultSet rs = state.executeQuery(sql);
	      if (rs.next()) {
	    	  lblNewLabel.setText("");

	        lblNewLabel.setText(rs.getString(1));
	        this.textField_1.setText(this.df.format(rs.getDouble(2)));
	        //setHarga1(Double.valueOf(rs.getDouble(2)));
	        this.textField_2.setText(this.df.format(rs.getDouble(3)));
	        //setHarga2(Double.valueOf(rs.getDouble(3)));
	        this.textField_3.setText(this.df.format(rs.getDouble(4)));
	          this.lblNewLabel_1.setText(rs.getInt(5)+"");

	        //setHarga3(Double.valueOf(rs.getDouble(4)));
	        this.lblbarcodeBarang.setText(rs.getString(13));
	        //this.lblpoin.setText(String.valueOf(rs.getInt(12)));
	        
	        this.Jlablediskon1.setText((rs.getInt(7))+"");
	        this.Jlablediskon2.setText((rs.getInt(8))+"");
	        this.Jlabelstatus.setText((new StringBuilder(String.valueOf(rs.getInt(6)))).toString());
	        benar = false;
	      } 
	    } catch (Exception exception) {}
	  }
	  private void HitungTotal(Double total_juml_bayar, Double total_di_table) {
		  
		 // Double total_bayar_skr = (Double.parseDouble(lblBelanjaTotalNilai.getText().replace(",", "")) +  total_juml_bayar) - total_di_table;
		  //lblBelanjaTotalNilai.setText(df.format(total_bayar_skr));
		  
	  }
	  private void ambilHargaTiga() { 
		   //AdminKasir adminkasir = new AdminKasir();
	        int jumlah_qty = 0;
	        DecimalFormat df = (DecimalFormat)NumberFormat.getNumberInstance(this.locale);

	       // System.out.println("test" + adminkasir.table.getRowCount());
	        if (AdminKasir.table.getRowCount() > 0) {
	          String s = "";
	          boolean exists = false;
	          double harg = 0.0D;
	          int i = 0;
	          while (i < AdminKasir.table.getRowCount() && !exists) {
	            s = AdminKasir.tableModel.getValueAt(i, 0).toString().trim();
	            if (this.lblbarcodeBarang.getText().equals(s)) {
	              //System.out.println(adminkasir.tableModel.getValueAt(i, 3).toString().trim());
	              jumlah_qty = Integer.parseInt(AdminKasir.tableModel.getValueAt(i, 3).toString().trim());
	              exists = true;
	              AdminKasir.tableModel.removeRow(i);
	              i += 100000;
	              continue;
	            } 
	            i++;
	          } 
	        } else {
	          System.out.println("silver");
	        } 
	        jumlah_qty += Integer.parseInt(this.textField.getText());
	        String str = this.textField_3.getText();
	        String strNew = str.replaceFirst(",", "");
	        Double harga = Double.valueOf(Double.parseDouble(strNew));
	     
	        AdminKasir.AddRowToJTable(new Object[] { this.lblbarcodeBarang.getText(), 
	              df.format(Double.valueOf(jumlah_qty * harga.doubleValue() / Integer.parseInt(this.lblpoin.getText()))), 
	              this.lblNewLabel.getText(), 
	              Integer.toString(jumlah_qty), 
	              this.textField_3.getText(), 
	              this.df.format(jumlah_qty * harga.doubleValue()) });
	      
	      }
	  
	  
	  private void ambilHargaDua() {
	        int jumlah_qty = 0;
	        System.out.println("test" + AdminKasir.table.getRowCount());
	        if (AdminKasir.table.getRowCount() > 0) {
	          String s = "";
	          boolean exists = false;
	          double harg = 0.0D;
	          int i = 0;
	          while (i < AdminKasir.table.getRowCount() && !exists) {
	            s = AdminKasir.tableModel.getValueAt(i, 0).toString().trim();
	            if (this.lblbarcodeBarang.getText().equals(s)) {
	              System.out.println(AdminKasir.tableModel.getValueAt(i, 3).toString().trim());
	              jumlah_qty = Integer.parseInt(AdminKasir.tableModel.getValueAt(i, 3).toString().trim());
	              exists = true;
	              AdminKasir.tableModel.removeRow(i);
	              i += 100000;
	              continue;
	            } 
	            i++;
	          } 
	        } else {
	          System.out.println("silver");
	        } 
	        jumlah_qty = Integer.parseInt(this.textField.getText());
	        String str = this.textField_2.getText();
	        String strNew = str.replaceFirst(",", "");
	        Double harga = Double.valueOf(Double.parseDouble(strNew));
	        AdminKasir.AddRowToJTable(new Object[] { this.lblbarcodeBarang.getText(), 
	        	  df.format(Double.valueOf(jumlah_qty * harga.doubleValue() / Integer.parseInt(this.lblpoin.getText()))), 
	              this.lblNewLabel.getText(), 
	              Integer.toString(jumlah_qty), 
	              this.textField_2.getText(), 
	              this.df.format(jumlah_qty * harga.doubleValue()) });
	 }
	  
	  private void ambilHargaSatu() {
		    int jumlah_qty = 0;
		    System.out.println("test" + AdminKasir.table.getRowCount());
		    if (AdminKasir.table.getRowCount() > 0) {
		      String s = "";
		      boolean exists = false;
		      double harg = 0.0D;
		      int i = 0;
		      while (i < AdminKasir.table.getRowCount() && !exists) {
		        s = AdminKasir.tableModel.getValueAt(i, 0).toString().trim();
		        if (this.lblbarcodeBarang.getText().equals(s)) {
		          System.out.println(AdminKasir.tableModel.getValueAt(i, 3).toString().trim());
		          jumlah_qty = Integer.parseInt(AdminKasir.tableModel.getValueAt(i, 3).toString().trim());
		          exists = true;
		          AdminKasir.tableModel.removeRow(i);
		          i += 100000;
		          continue;
		        } 
		        i++;
		      } 
		    } else {
		      System.out.println("silver");
		    } 
		    jumlah_qty += Integer.parseInt(this.textField.getText());
		    String str = this.textField_1.getText();
		    String strNew = str.replaceFirst(",", "");
		    Double harga = Double.valueOf(Double.parseDouble(strNew));
		    AdminKasir.AddRowToJTable(new Object[] { this.lblbarcodeBarang.getText(), 
		    		df.format(Double.valueOf(jumlah_qty * harga.doubleValue() / Integer.parseInt(this.lblpoin.getText()))), 
		          this.lblNewLabel.getText(), 
		          Integer.toString(jumlah_qty), 
		          this.textField_1.getText(), 
		          this.df.format(jumlah_qty * harga.doubleValue()) });
		  }

	  private void ambilDataBarang() {
		    int jumlah_qty = 0;
		    Double jum_table = 0.0;
		    System.out.println("test" + AdminKasir.table.getRowCount());
		    if (AdminKasir.table.getRowCount() > 0) {
		      String s = "";
		      boolean exists = false;
		      double harg = 0.0D;
		      int i = 0;
		      while (i < AdminKasir.table.getRowCount() && !exists) {
		        s = AdminKasir.tableModel.getValueAt(i, 0).toString().trim();
		        if (this.lblbarcodeBarang.getText().equals(s)) {
		          System.out.println(AdminKasir.tableModel.getValueAt(i, 3).toString().trim());
		          jumlah_qty = Integer.parseInt(AdminKasir.tableModel.getValueAt(i, 3).toString().trim());
		          jum_table =  Double.parseDouble(((String)AdminKasir.tableModel.getValueAt(i, 5)).replace(",", ""));
		          //jum_table = Integer.parseInt(AdminKasir.tableModel.getValueAt(i, ).toString().trim());
		          exists = true;
		          AdminKasir.tableModel.removeRow(i);
		          i += 100000;
		          continue;
		        } 
		        i++;
		      } 
		    } else {
		      System.out.println("silver");
		    } 
		   
		   
		    jumlah_qty += Integer.parseInt(this.textField.getText());
		    System.out.println("ambil data barang di eksekusi tidak sama dengan "+Jlablediskon1.getText());
		    System.out.println("ambil data barang di eksekusi tidak sama dengan "+Jlablediskon2.getText());
		    
		    
		    if(Jlablediskon1.getText().equals("0") && Jlablediskon2.getText().equals("0")) {
		        String str = this.textField_1.getText();
		        String strNew = str.replaceFirst(",", "");
		        Double harga = Double.valueOf(Double.parseDouble(strNew));
		        AdminKasir.AddRowToJTable(new Object[] { this.lblbarcodeBarang.getText(), 
		        	  df.format(Double.valueOf(jumlah_qty * harga.doubleValue() / Integer.parseInt(this.lblpoin.getText()))), 
		              this.lblNewLabel.getText(), 
		              Integer.toString(jumlah_qty), 
		              this.textField_1.getText(), 
		              this.df.format(jumlah_qty * harga.doubleValue()) });
		             // HitungTotal(jumlah_qty * harga , jum_table);

		    }
		    else if(Jlablediskon2.getText().equals("0") && Jlablediskon1.getText() != "0" ) {
		      if(jumlah_qty < Integer.parseInt(Jlablediskon1.getText())) {
		          String str = this.textField_1.getText();
		 
		        String strNew = str.replaceFirst(",", "");
		              Double harga = Double.valueOf(Double.parseDouble(strNew));
		              AdminKasir.AddRowToJTable(new Object[] { this.lblbarcodeBarang.getText(), 
		            		df.format(Double.valueOf(jumlah_qty * harga.doubleValue() / Integer.parseInt(this.lblpoin.getText()))), 
		                    this.lblNewLabel.getText(), 
		                    Integer.toString(jumlah_qty), 
		                    this.textField_1.getText(), 
		                    this.df.format(jumlah_qty * harga.doubleValue()) });
		             // HitungTotal(jumlah_qty * harga , jum_table);

		      }
		      else if (jumlah_qty>= Integer.parseInt(Jlablediskon1.getText())) {
		          String str = this.textField_2.getText();

		        String strNew = str.replaceFirst(",", "");
		          Double harga = Double.valueOf(Double.parseDouble(strNew));
		          AdminKasir.AddRowToJTable(new Object[] { this.lblbarcodeBarang.getText(), 
		        		df.format(Double.valueOf(jumlah_qty * harga.doubleValue() / Integer.parseInt(this.lblpoin.getText()))), 
		                this.lblNewLabel.getText(), 
		                Integer.toString(jumlah_qty), 
		                this.textField_2.getText(), 
		                this.df.format(jumlah_qty * harga.doubleValue()) });
		         // HitungTotal(jumlah_qty * harga ,jum_table);

		      }
		    }
		    else if(Jlablediskon1.getText().equals("0") && Jlablediskon2.getText() != "0" ) {
		      if (jumlah_qty < Integer.parseInt(Jlablediskon2.getText())) {
		         String str = this.textField_1.getText();

		        String strNew = str.replaceFirst(",", "");
		          Double harga = Double.valueOf(Double.parseDouble(strNew));
		          AdminKasir.AddRowToJTable(new Object[] { this.lblbarcodeBarang.getText(), 
		        		df.format(Double.valueOf(jumlah_qty * harga.doubleValue() / Integer.parseInt(this.lblpoin.getText()))), 
		                this.lblNewLabel.getText(), 
		                Integer.toString(jumlah_qty), 
		                this.textField_1.getText(), 
		                this.df.format(jumlah_qty * harga.doubleValue()) });
		         // HitungTotal(jumlah_qty * harga, jum_table );

		      }
		      else  if(jumlah_qty >=  Integer.parseInt(Jlablediskon2.getText())){
		       String str = this.textField_3.getText();

		        String strNew = str.replaceFirst(",", "");
		          Double harga = Double.valueOf(Double.parseDouble(strNew));
		          AdminKasir.AddRowToJTable(new Object[] { this.lblbarcodeBarang.getText(), 
		        		df.format(Double.valueOf(jumlah_qty * harga.doubleValue() / Integer.parseInt(this.lblpoin.getText()))), 
		                this.lblNewLabel.getText(), 
		                Integer.toString(jumlah_qty), 
		                this.textField_3.getText(), 
		                this.df.format(jumlah_qty * harga.doubleValue()) });
		          	//	HitungTotal(jumlah_qty * harga , jum_table);

		      }


		    }
		    else {
		    	if(jumlah_qty <  Integer.parseInt(Jlablediskon1.getText())) {
		    		  String str = this.textField_1.getText();
				       String strNew = str.replaceFirst(",", "");
				      Double harga = Double.valueOf(Double.parseDouble(strNew));
				      AdminKasir.AddRowToJTable(new Object[] { this.lblbarcodeBarang.getText(), 
				    	    df.format(Double.valueOf(jumlah_qty * harga.doubleValue() / Integer.parseInt(this.lblpoin.getText()))), 
				            this.lblNewLabel.getText(), 
				            Integer.toString(jumlah_qty), 
				            this.textField_1.getText(), 
				            this.df.format(jumlah_qty * harga.doubleValue()) });
				      		//HitungTotal(jumlah_qty * harga , jum_table);
		    		
		    	}
		    	else if(jumlah_qty >=  Integer.parseInt(Jlablediskon1.getText()) && jumlah_qty < Integer.parseInt(Jlablediskon2.getText())) {
		    		  String str = this.textField_2.getText();
				       String strNew = str.replaceFirst(",", "");
				      Double harga = Double.valueOf(Double.parseDouble(strNew));
				      AdminKasir.AddRowToJTable(new Object[] { this.lblbarcodeBarang.getText(), 
				    	    df.format(Double.valueOf(jumlah_qty * harga.doubleValue() / Integer.parseInt(this.lblpoin.getText()))), 
				            this.lblNewLabel.getText(), 
				            Integer.toString(jumlah_qty), 
				            this.textField_2.getText(), 
				            this.df.format(jumlah_qty * harga.doubleValue()) });
		    	}
		    	else if(jumlah_qty >=  Integer.parseInt(Jlablediskon2.getText())) {
		    		  String str = this.textField_3.getText();
				       String strNew = str.replaceFirst(",", "");
				      Double harga = Double.valueOf(Double.parseDouble(strNew));
				      AdminKasir.AddRowToJTable(new Object[] { this.lblbarcodeBarang.getText(), 
				    	    df.format(Double.valueOf(jumlah_qty * harga.doubleValue() / Integer.parseInt(this.lblpoin.getText()))), 
				            this.lblNewLabel.getText(), 
				            Integer.toString(jumlah_qty), 
				            this.textField_3.getText(), 
				            this.df.format(jumlah_qty * harga.doubleValue()) });
				      		//HitungTotal(jumlah_qty * harga , jum_table);

		    	}
		      
		    }
		    
		    
		    textField.setText("1");
		    barcodeTextField.selectAll();
		    barcodeTextField.requestFocus();
		  
		}
}
