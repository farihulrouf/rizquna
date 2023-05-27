package view.dialog;

 
import com.silver.data.Harga;
import com.silver.model.table.TableModelHarga;
import view.AdminKasir;
import view.Koneksi;

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

public class viewHarga extends JDialog {
  private final JPanel contentPanel = new JPanel();
  
  private TableModelHarga tableModel;
  private JLabel Jlablediskon1;
  private JLabel Jlablediskon2;
  private Harga harga;
  private JLabel Jlabelstatus; 
  Locale locale = new Locale("en", "UK");
  private JLabel jLjLabelStatuttext;
  DecimalFormat df = (DecimalFormat)NumberFormat.getNumberInstance(this.locale);
  
  public static Double harga_barang;
  
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
  
  public int getPersediaanBarang() {
  return persediaanBarang;
}

public void setPersediaanBarang(int persediaanBarang) {
  this.persediaanBarang = persediaanBarang;
}

public int getStatus() {
  return status;
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
  
  private JTextField textField_2;
  
  private JTextField textField_3;
  
  private JTextField textField_4;
  private JTextField barcodeTextField;
  
  public viewHarga(AdminKasir parent, int persediaan, int poin, String nama, final Double harga1, final Double haraga2, final Double harga3, Double harga_beli, String status, boolean modal, int mindiskon, int mindiskon2) {
    setModal(true);
    setBackground(new Color(211, 211, 211));
    this.tableModel = new TableModelHarga();
    this.harga = new Harga();
    setBounds(100, 100, 500, 500);
    getContentPane().setLayout(new BorderLayout());
    this.contentPanel.setBackground(new Color(30, 144, 255));
    this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(this.contentPanel, "Center");
    this.data = new Object[][] { { "harga ecerl", harga1 }, { "harga kulak", haraga2 }, { "harga carton", harga3 } };
    this.contentPanel.setLayout((LayoutManager)null);
    setPoin(poin);
    setStatus(Integer.parseInt(status));
    setPersediaanBarang(persediaan);
    setModal(true);
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
              case 10:
                viewHarga.this.ambil_satu(harga1);
                if(getStatus() == 1) {
                  cekStatus();
                }
                else {
                  viewHarga.this.dispose();
                }
                //viewHarga.this.dispose();
                break;
            } 
          }
        });
    this.textField.setText("1");
    this.textField.selectAll();
    this.textField.setFont(new Font("Dialog", 1, 24));
    this.textField.setBounds(200, 190, 70, 48);
    this.contentPanel.add(this.textField);
    this.textField.setColumns(10);
    JLabel lblJumlah = new JLabel("Jumlah");
    lblJumlah.setForeground(new Color(255, 255, 255));
    lblJumlah.setFont(new Font("Dialog", 1, 20));
    lblJumlah.setBounds(32, 200, 112, 33);
    this.contentPanel.add(lblJumlah);
    JPanel panel = new JPanel();
    panel.setBackground(Color.WHITE);
    panel.setBounds(27, 110, 436, 70);
    this.contentPanel.add(panel);
    panel.setLayout((LayoutManager)null);
    JLabel lblNewLabel = new JLabel(nama);
    lblNewLabel.setBounds(30, 12, 373, 35);
    panel.add(lblNewLabel);
    lblNewLabel.setForeground(new Color(0, 0, 205));
    lblNewLabel.setFont(new Font("Dialog", 1, 18));
    JButton btnNewButton = new JButton("Simpan");
    btnNewButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {}
        });
    btnNewButton.setBounds(605, 392, 133, 33);
    this.contentPanel.add(btnNewButton);
    JLabel lblNewLabel_1 = new JLabel(String.valueOf(persediaan));
  JLabel Jlabelstatus = new JLabel(status);
    lblNewLabel_1.setForeground(Color.ORANGE);
    lblNewLabel_1.setFont(new Font("Dialog", 1, 25));
    lblNewLabel_1.setBounds(186, 70, 100, 29);
    
    Jlabelstatus.setForeground(Color.ORANGE);
    Jlabelstatus.setFont(new Font("Dialog", 1, 25));
    Jlabelstatus.setBounds(400, 60, 50, 50);
    


    this.contentPanel.add(lblNewLabel_1);
    this.contentPanel.add(Jlabelstatus);
    JLabel lblKodeBarcode = new JLabel("Persediaan");
    lblKodeBarcode.setForeground(new Color(255, 255, 255));
    lblKodeBarcode.setFont(new Font("Dialog", 1, 15));
    lblKodeBarcode.setBounds(27, 70, 117, 23);
    

    JLabel jLjLabelStatuttext = new JLabel("status");
    jLjLabelStatuttext.setForeground(new Color(255, 255, 255));
    jLjLabelStatuttext.setFont(new Font("Dialog", 1, 15));
    jLjLabelStatuttext.setBounds(300, 70, 117, 23);
    this.contentPanel.add(jLjLabelStatuttext);
    
    this.contentPanel.add(lblKodeBarcode);
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
                viewHarga.this.ambil_satu(harga1);
                if(getStatus() == 1) {
                  cekStatus();
                }
                else {
                  viewHarga.this.dispose();
                }
                //viewHarga.this.dispose();
                break;
            } 
          }
        });
    this.textField_1.setBounds(180, 250, 150, 33);
    this.textField_1.setText(this.df.format(harga1));
    this.contentPanel.add(this.textField_1);
    this.textField_1.setColumns(10);
    
    
    barcodeTextField = new JTextField();
    barcodeTextField.addKeyListener(new KeyAdapter() {
    	@Override
    	public void keyPressed(KeyEvent e) {
    		CariBarang();
    	}
    });
    this.barcodeTextField.setBounds(50, 30, 300, 33);
    //this.textField_1.setText(this.df.format(harga1));
    this.contentPanel.add(this.barcodeTextField);
    //this.textField_1.setColumns(10);
    

   // private JTextField barcodeTextField;
    
    
    JLabel Jlablediskon1 = new JLabel(String.valueOf(mindiskon));
  //JLabel Jlablediskon1 = new JLabel(status);
    Jlablediskon1.setForeground(Color.ORANGE);
    Jlablediskon1.setFont(new Font("Dialog", 1, 25));
    Jlablediskon1.setBounds(400, 300, 40, 29);
    
    this.contentPanel.add(Jlablediskon1);
    
    
    JLabel Jlablediskon2 = new JLabel(String.valueOf(mindiskon2));
    //JLabel Jlablediskon1 = new JLabel(status);
      Jlablediskon2.setForeground(Color.ORANGE);
      Jlablediskon2.setFont(new Font("Dialog", 1, 25));
      Jlablediskon2.setBounds(400, 350, 40, 29);
      
      this.contentPanel.add(Jlablediskon2);
      
    
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
                viewHarga.this.ambil_satu(haraga2);
                if(getStatus() == 1) {
                  cekStatus();
                }
                else {
                  viewHarga.this.dispose();
                }
                //viewHarga.this.dispose();
                break;
            } 
          }
        });
    this.textField_2.setColumns(10);
    this.textField_2.setBounds(180, 300, 150, 33);
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
                viewHarga.this.ambil_satu(harga3);
                if(getStatus() == 1) {
                  cekStatus();
                }
                else {
                  viewHarga.this.dispose();
                }
                //viewHarga.this.dispose();
                break;
            } 
          }
        });
    this.textField_3.setColumns(10);
    this.textField_3.setBounds(180, 350, 150, 33);
    this.textField_3.setText(this.df.format(harga3));
    this.contentPanel.add(this.textField_3);
    JLabel lblHargaEcer = new JLabel("Harga Ecer");
    lblHargaEcer.setForeground(new Color(255, 255, 255));
    lblHargaEcer.setFont(new Font("Dialog", 1, 18));
    lblHargaEcer.setBounds(32, 250, 118, 33);
    this.contentPanel.add(lblHargaEcer);
    JLabel lblHargaKulak = new JLabel("Harga Kulak");
    lblHargaKulak.setForeground(new Color(255, 255, 255));
    lblHargaKulak.setFont(new Font("Dialog", 1, 18));
    lblHargaKulak.setBounds(32, 300, 174, 33);
    this.contentPanel.add(lblHargaKulak);
    JLabel lblHargaKarton = new JLabel("Harga Karton");
    lblHargaKarton.setForeground(new Color(255, 255, 255));
    lblHargaKarton.setFont(new Font("Dialog", 1, 18));
    lblHargaKarton.setBounds(32, 350, 174, 33);
    this.contentPanel.add(lblHargaKarton);
    JPanel buttonPane = new JPanel();
    buttonPane.setBackground(new Color(165, 42, 42));
    buttonPane.setLayout(new FlowLayout(2));
    getContentPane().add(buttonPane, "South");
    JButton okButton = new JButton("OK");
    okButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            viewHarga.this.klik();
            if(getStatus() == 1) {
              cekStatus();
            }
            else {
              viewHarga.this.dispose();
            };
            //viewHarga.this.dispose();
          }
        });
    okButton.setActionCommand("OK");
    buttonPane.add(okButton);
    getRootPane().setDefaultButton(okButton);
    JButton cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            if(getStatus() == 1) {
                cekStatus();
              }
              else {
                viewHarga.this.dispose();
              }
          }
        });
    cancelButton.setActionCommand("Cancel");
    buttonPane.add(cancelButton);
    setLocationRelativeTo((Component)parent);
    setVisible(true);
  }
  
  private void klik() {
    setJumlah(this.textField.getText());
  }
  
  private void cekStatus() {
   // getPersediaanBarang
  // setStatus(Integer.parseInt(status));
    //getJumlah
   System.out.println(getJumlah());
   System.out.println(getPersediaanBarang());
   
   if(getPersediaanBarang()-Integer.parseInt(getJumlah()) >= 1 ) {
     System.out.print("oke");
     viewHarga.this.dispose();
   }
   else {

      JOptionPane.showMessageDialog(this, "Hai tidak boleh melebihi persediaan");
   }
  
  }
  
  private void ambil_satu(Double hargas) {
    setJumlah(this.textField.getText());
    setHarga_barang(hargas);
  }
  
  
  private void CariBarang() {
	    boolean benar = true;
	    try {
	      Connection konek = Koneksi.getKoneksi();
	      Statement state = konek.createStatement();
	      String sql = "select nama_barang, harga_jual,harga_diskon,harga_lain,persediaan,balance,mindiskon,mindiskon2,harga_beli,id_kategori,satuan, poins from Barang WHERE kd_barang = '" + 
	        
	        this.textField.getText() + "'";
	      ResultSet rs = state.executeQuery(sql);
	      if (rs.next()) {
	       /* this.textField_1.setText(rs.getString(1));
	        this.textField_6.setText(this.df.format(rs.getDouble(2)));
	        this.textField_7.setText(this.df.format(rs.getDouble(3)));
	        this.textField_8.setText(this.df.format(rs.getDouble(4)));
	        this.textField_9.setText(String.valueOf(rs.getInt(5)));
	        this.textField_5.setText(this.df.format(rs.getDouble(9)));
	        this.textField_11.setText("1");
	        this.textField_15.setText(String.valueOf(rs.getInt(7)));
	        this.textField_16.setText(String.valueOf(rs.getInt(8)));
	        this.textPointField.setText(String.valueOf(rs.getInt(12)));
	        this.textField_12.setText((new StringBuilder(String.valueOf(rs.getInt(6)))).toString());
	        */
	        benar = false;
	      } else {
	    	/*
	        this.textField_1.setText("");
	        this.textField_6.setText("0");
	        this.textField_7.setText("0");
	        this.textField_8.setText("0");
	        this.textField_9.setText("0");
	        this.textField_5.setText("0");
	        this.textField_11.setText("0");
	        this.textField_12.setText("0");
	        this.textPointField.setText("0");
	        */
	      } 
	    } catch (Exception exception) {}
	  }
	  
	  /*public JTextField getTextField_15() {
		return textField_15;
	} */
}