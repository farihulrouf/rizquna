package view.dialog;

import com.silver.data.Harga;
import com.silver.model.table.TableModelHarga;
import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import view.AdminKasir;
import view.Koneksi;

public class viewHarga extends JDialog {
  private final JPanel contentPanel = new JPanel();
  
  private TableModelHarga tableModel;
  //DecimalFormat dfx = new DecimalFormat("###.#");

  private JLabel Jlablediskon1;
  
  private JLabel Jlablediskon2;
  
  private Harga harga;
  
  private JLabel lblNewLabel;
  
  private JLabel Jlabelstatus;
  
  private String barcodeText;
  
  private JLabel lblpoin;
  
  //private JLabel lblBelanjaTotal;
  
  private JLabel lblBelanjaPoin;
  
  private JLabel lblBelanjaPoinNilai;
  
  private JLabel lblBelanjaTotalNilai;
  private int diskon1;
  private int diskon2;
  
  public int getDiskon1() {
  return diskon1;
}

public void setDiskon1(int diskon1) {
  this.diskon1 = diskon1;
}

public int getDiskon2() {
  return diskon2;
}

public void setDiskon2(int diskon2) {
  this.diskon2 = diskon2;
}

private JPanel panelTotal;
  
  public String getBarcodeText() {
    return this.barcodeText;
  }
  
  public void setBarcodeText(String barcodeText) {
    this.barcodeText = barcodeText;
  }
  
  Locale locale = new Locale("en", "UK");
  
  DecimalFormat decimalFormat = (DecimalFormat)NumberFormat.getNumberInstance(this.locale);
  
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
  
  private Double harga1;
  
  private Double harga2;
  
  private Double harga3;
  
  private JLabel lblbarcodeBarang;
  
  public Double getHarga1() {
    return this.harga1;
  }
  
  public void setHarga1(Double harga1) {
    this.harga1 = harga1;
  }
  
  public Double getHarga2() {
    return this.harga2;
  }
  
  public void setHarga2(Double harga2) {
    this.harga2 = harga2;
  }
  
  public Double getHarga3() {
    return this.harga3;
  }
  
  public void setHarga3(Double harga3) {
    this.harga3 = harga3;
  }
  
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
  
  private JTextField textField_2;
  
  private JTextField textField_3;
  
  private JTextField textField_4;
  
  private JTextField barcodeTextField;
  
  public viewHarga(AdminKasir parent, int persediaan, int poin, String nama, Double harga1, 
      Double haraga2, Double harga3, Double harga_beli, String status, 
      boolean modal, int mindiskon, int mindiskon2, String barcodeAdmin,Double poinTotal, String totalSaat ) {
    setUndecorated(true);
    setBounds(2, 2, 1440, 450);
    setVisible(true);
    setBackground(new Color(1.0F, 1.0F, 1.0F, 0.0F));
    this.tableModel = new TableModelHarga();
    this.harga = new Harga();
    getContentPane().setLayout(new BorderLayout());
    this.contentPanel.setBackground(new Color(0.1F, 0.1F, 0.1F, 0.0F));
    this.contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
    getContentPane().add(this.contentPanel, "Center");
    this.data = new Object[][] { { "harga ecerl", harga1 }, { "harga kulak", haraga2 }, { "harga carton", harga3 } };
    this.contentPanel.setLayout((LayoutManager)null);
    setPoin(poin);
    setStatus(Integer.parseInt(status));
    setPersediaanBarang(persediaan);
    this.textField = new JTextField();
    textField.setBackground(Color.ORANGE);
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
                viewHarga.this.dispose();
                break;
            } 
          }
        });
    this.textField.setText("1");
    this.textField.selectAll();
    contentPanel.setLayout(null);
    
    this.textField.setFont(new Font("Dialog", 1, 24));
    this.textField.setBounds(756, 139, 50, 48);
    this.contentPanel.add(this.textField);
    this.textField.setColumns(10);
    JLabel lblJumlah = new JLabel("Jumlah");
    lblJumlah.setBackground(Color.GREEN);
    lblJumlah.setForeground(Color.BLACK);
    lblJumlah.setFont(new Font("Dialog", 1, 20));
    lblJumlah.setBounds(542, 154, 112, 33);
    this.contentPanel.add(lblJumlah);
    JLabel lblKodeBarcode = new JLabel("Persediaan");
    lblKodeBarcode.setForeground(new Color(255, 0, 255));
    lblKodeBarcode.setFont(new Font("Dialog", 1, 15));
    lblKodeBarcode.setBounds(27, 70, 117, 23);
    
    this.textField_1 = new JTextField();
    textField_1.setBackground(Color.ORANGE);
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
                viewHarga.this.ambilHargaSatu();
                viewHarga.this.dispose();
                break;
            } 
          }
        });
    this.textField_1.setBounds(732, 202, 120, 33);
    this.textField_1.setText(this.df.format(harga1));
    this.contentPanel.add(this.textField_1);
    this.textField_1.setColumns(10);
    this.lblbarcodeBarang = new JLabel(barcodeAdmin);
    this.lblbarcodeBarang.setFont(new Font("Lucida Grande", 0, 5));
    this.lblbarcodeBarang.setForeground(Color.ORANGE);
    this.lblbarcodeBarang.setBackground(new Color(1.0F, 1.0F, 1.0F, 0.2F));
    this.lblbarcodeBarang.setBounds(10, 380, 200, 33);
    this.contentPanel.add(this.lblbarcodeBarang);
    this.textField_1.setText(this.df.format(harga1));
    this.textField_1.setColumns(10);
    this.lblBelanjaTotalNilai = new JLabel(totalSaat);
    JPanel panel = new JPanel();
    panel.setBorder((Border)null);
    panel.setBackground(new Color(1.0F, 1.0F, 1.0F, 0.0F));

    //panel.setBackground(Color.WHITE);
    panel.setBounds(438, -1, 600, 70);
    this.contentPanel.add(panel);
    panel.setLayout((LayoutManager)null);
    panel.setLayout(null);

    this.lblNewLabel = new JLabel(nama);

    this.lblNewLabel.setBounds(103, 16, 491, 35);
 
    panel.add(this.lblNewLabel);
    this.lblNewLabel.setForeground(new Color(0, 0, 0));
    this.lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
    this.Jlablediskon1 = new JLabel(String.valueOf(mindiskon));
    Jlablediskon1.setForeground(Color.BLACK);
    this.Jlablediskon1.setFont(new Font("Dialog", 1, 25));
    this.Jlablediskon1.setBounds(874, 260, 200, 29);
    this.contentPanel.add(Jlablediskon1);
    this.Jlablediskon2 = new JLabel(String.valueOf(mindiskon2));
    System.out.print("labeldiskon"+ mindiskon);
    this.Jlablediskon2.setForeground(Color.BLACK);
    this.Jlablediskon2.setFont(new Font("Dialog", 1, 25));
    this.Jlablediskon2.setBounds(874, 318, 200, 29);
    this.contentPanel.add(Jlablediskon2);
    this.textField_2 = new JTextField();
    textField_2.setBackground(Color.ORANGE);
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
                viewHarga.this.ambilHargaDua();
                viewHarga.this.dispose();
                break;
            } 
          }
        });
    this.textField_2.setColumns(10);
    this.textField_2.setBounds(732, 258, 120, 33);
    this.textField_2.setText(this.df.format(haraga2));
    this.contentPanel.add(this.textField_2);
    this.textField_3 = new JTextField();
    textField_3.setBackground(Color.ORANGE);
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
                viewHarga.this.ambilHargaTiga();
                if (viewHarga.this.getStatus() == 1) {
                  viewHarga.this.cekStatus();
                } else {
                  viewHarga.this.dispose();
                } 
                viewHarga.this.dispose();
                break;
            } 
          }
        });
    this.textField_3.setColumns(10);
    this.textField_3.setBounds(732, 316, 120, 33);
    this.textField_3.setText(this.df.format(harga3));
    this.contentPanel.add(this.textField_3);
    this.lblBelanjaPoinNilai = new JLabel(poinTotal+"");
    JLabel lblHargaEcer = new JLabel("Harga Ecer");
    lblHargaEcer.setForeground(Color.BLACK);
    lblHargaEcer.setFont(new Font("Dialog", 1, 18));
    lblHargaEcer.setBounds(536, 205, 118, 33);
    this.contentPanel.add(lblHargaEcer);
    JLabel lblHargaKulak = new JLabel("Harga Kulak");
    lblHargaKulak.setForeground(Color.BLACK);
    lblHargaKulak.setFont(new Font("Dialog", 1, 18));
    lblHargaKulak.setBounds(536, 261, 145, 33);
    this.contentPanel.add(lblHargaKulak);
    JLabel lblHargaKarton = new JLabel("Harga Karton");
    //this.lblBelanjaTotal = new JLabel("Total Belanja");
    this.lblBelanjaPoin = new JLabel("Total Poin");
    this.lblBelanjaPoinNilai.setForeground(Color.BLACK);
    this.lblBelanjaPoinNilai.setFont(new Font("Dialog", Font.BOLD, 20));
    this.lblBelanjaPoinNilai.setBounds(359, 6, 101, 33);
    this.contentPanel.add(this.lblBelanjaPoinNilai);
    /*
    this.lblBelanjaTotal.setForeground(Color.BLACK);
    this.lblBelanjaTotal.setFont(new Font("Dialog", 1, 18));
    this.lblBelanjaTotal.setBounds(32, 350, 174, 33);
    */
    //this.contentPanel.add(this.lblBelanjaTotal);
    this.lblBelanjaTotalNilai.setForeground(Color.BLACK);
    this.lblBelanjaTotalNilai.setFont(new Font("Dialog", Font.BOLD, 40));
    this.lblBelanjaTotalNilai.setBounds(1065, 12, 302, 57);
    this.contentPanel.add(this.lblBelanjaTotalNilai);
    this.lblBelanjaPoin.setForeground(Color.BLACK);
    this.lblBelanjaPoin.setFont(new Font("Dialog", Font.BOLD, 14));
    this.lblBelanjaPoin.setBounds(269, 8, 101, 33);
    this.contentPanel.add(this.lblBelanjaPoin);
    lblHargaKarton.setForeground(Color.BLACK);
    lblHargaKarton.setFont(new Font("Dialog", 1, 18));
    lblHargaKarton.setBounds(536, 319, 174, 33);
    this.contentPanel.add(lblHargaKarton);
    this.barcodeTextField = new JTextField();
    barcodeTextField.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
    contentPanel.add(barcodeTextField);
    this.barcodeTextField.setBackground(new Color(0, 120, 255));
    this.barcodeTextField.setBounds(10, 6, 245, 63);
    JLabel jLjLabelStatuttext_1 = new JLabel("Persediaan");
    contentPanel.add(jLjLabelStatuttext_1);
    jLjLabelStatuttext_1.setForeground(new Color(0, 0, 0));
    jLjLabelStatuttext_1.setFont(new Font("Dialog", 1, 14));
    jLjLabelStatuttext_1.setBounds(269, 34, 100, 35);
    JLabel lblNewLabel_1 = new JLabel(String.valueOf(persediaan));
    contentPanel.add(lblNewLabel_1);
    lblNewLabel_1.setForeground(new Color(0, 0, 0));
    lblNewLabel_1.setFont(new Font("Dialog", 1, 14));
    lblNewLabel_1.setBounds(369, 34, 57, 35);
    JLabel lblmin = new JLabel("Minimal Poin Belanja");
    contentPanel.add(lblmin);
    lblmin.setForeground(new Color(1.0F, 1.0F, 1.0F, 0.0F));
    lblmin.setFont(new Font("Dialog", Font.BOLD, 20));
    lblmin.setBounds(536, 378, 218, 29);
    this.lblpoin = new JLabel((new StringBuilder(String.valueOf(poin))).toString());
    contentPanel.add(lblpoin);
    this.lblpoin.setForeground(new Color(1.0F, 1.0F, 1.0F, 0.0F));
    this.lblpoin.setFont(new Font("Dialog", Font.BOLD, 20));
    this.lblpoin.setBounds(818, 378, 140, 29);
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
                viewHarga.this.ambilDataDua();
                viewHarga.this.dispose();
                break;
            } 
          }
        });
    this.barcodeTextField.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            if (viewHarga.this.barcodeTextField.getText().equals(viewHarga.this.lblbarcodeBarang.getText())) {
              int jumlah_aja = 0;
              jumlah_aja = 1 + Integer.parseInt(viewHarga.this.textField.getText());
              //viewHarga.this.textField.setText(jumlah_aja);
              viewHarga.this.CariBarang();
              viewHarga.this.barcodeTextField.selectAll();
              viewHarga.this.barcodeTextField.requestFocus();
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
  
  private void ambilHargaTiga() {
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
    String str = this.textField_3.getText();
    String strNew = str.replaceFirst(",", "");
    Double harga = Double.valueOf(Double.parseDouble(strNew));
    AdminKasir.AddRowToJTable(new Object[] { this.lblbarcodeBarang.getText(), 
          Double.valueOf(jumlah_qty * harga.doubleValue() / Integer.parseInt(this.lblpoin.getText())), 
          this.lblNewLabel.getText(), 
          Integer.toString(jumlah_qty), 
          this.textField_3.getText(), 
          this.decimalFormat.format(jumlah_qty * harga.doubleValue()) }, this.lblbarcodeBarang.getText(), this.lblpoin.getText(), Double.valueOf(jumlah_qty * harga.doubleValue()));
  }
  
  private void hitunssgTotalPoin() {
    AdminKasir.table.getRowCount();
  }
  
  public void hitungTotalPoin() {
    String pattern = "###,###.###";
    DecimalFormat decimalFormat = new DecimalFormat(pattern);
    Double Subtotal = Double.valueOf(0.0D);
    Double SubtotalPoin = Double.valueOf(0.0D);
    for (int j = 0; j < AdminKasir.table.getRowCount(); j++) {
      String totalString = AdminKasir.tableModel.getValueAt(j, 5).toString().trim();
      String strNew22 = totalString.replaceFirst(",", "");
      Subtotal = Double.valueOf(Double.parseDouble(strNew22) + Subtotal.doubleValue());
      System.out.println("nilai total di harga" + Subtotal);
      String totalPoin = AdminKasir.tableModel.getValueAt(j, 1).toString().trim();
      SubtotalPoin = Double.valueOf(Double.parseDouble(totalPoin) + SubtotalPoin.doubleValue());
      System.out.println("nilai di harga" + totalPoin);
      this.lblBelanjaTotalNilai.setText(decimalFormat.format(Subtotal));
      this.lblBelanjaPoinNilai.setText(decimalFormat.format(SubtotalPoin));
    } 
  }
  
  private void ambilDataDua() {
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
   // String mind = Jlablediskon1.getText()
    //System.out.print("nilai min diskon"+mind);
    if (jumlah_qty >=  Integer.parseInt(Jlablediskon1.getText()) && jumlah_qty <  Integer.parseInt(Jlablediskon2.getText()) ) {
       if(Jlablediskon1.getText().equals("0")) {
         String str22 = this.textField_1.getText();
            String strNew22 = str22.replaceFirst(",", "");
            Double harga32 = Double.valueOf(Double.parseDouble(strNew22));
            AdminKasir.AddRowToJTable(new Object[] { this.lblbarcodeBarang.getText(), 
                  Double.valueOf(jumlah_qty * harga32.doubleValue() / Integer.parseInt(this.lblpoin.getText())), 
                  this.lblNewLabel.getText(), 
                  Integer.toString(jumlah_qty), 
                  this.textField_1.getText(), 
                  this.decimalFormat.format(jumlah_qty * harga32.doubleValue()) }, this.lblbarcodeBarang.getText(), this.lblpoin.getText(), Double.valueOf(jumlah_qty * harga32.doubleValue()));
       }
       else if(Jlablediskon1.getText().equals("0") && Jlablediskon2.getText().equals("0")) {
         String str22 = this.textField_2.getText();
        String strNew22 = str22.replaceFirst(",", "");
        Double harga32 = Double.valueOf(Double.parseDouble(strNew22));
        AdminKasir.AddRowToJTable(new Object[] { this.lblbarcodeBarang.getText(), 
              Double.valueOf(jumlah_qty * harga32.doubleValue() / Integer.parseInt(this.lblpoin.getText())), 
              this.lblNewLabel.getText(), 
              Integer.toString(jumlah_qty), 
              this.textField_2.getText(), 
              this.decimalFormat.format(jumlah_qty * harga32.doubleValue()) }, this.lblbarcodeBarang.getText(), this.lblpoin.getText(), Double.valueOf(jumlah_qty * harga32.doubleValue()));
 
       }
       else {
         String str22 = this.textField_2.getText();
            String strNew22 = str22.replaceFirst(",", "");
            Double harga32 = Double.valueOf(Double.parseDouble(strNew22));
            AdminKasir.AddRowToJTable(new Object[] { this.lblbarcodeBarang.getText(), 
                  Double.valueOf(jumlah_qty * harga32.doubleValue() / Integer.parseInt(this.lblpoin.getText())), 
                  this.lblNewLabel.getText(), 
                  Integer.toString(jumlah_qty), 
                  this.textField_2.getText(), 
                  this.decimalFormat.format(jumlah_qty * harga32.doubleValue()) }, this.lblbarcodeBarang.getText(), this.lblpoin.getText(), Double.valueOf(jumlah_qty * harga32.doubleValue()));
       }
     
    } else if (jumlah_qty >=  Integer.parseInt(Jlablediskon2.getText())) {
      if(Jlablediskon2.getText().equals("0")) {
        
          String str2 = this.textField_2.getText();
            String strNew2 = str2.replaceFirst(",", "");
            Double harga3 = Double.valueOf(Double.parseDouble(strNew2));
            AdminKasir.AddRowToJTable(new Object[] { this.lblbarcodeBarang.getText(), 
                  Double.valueOf(jumlah_qty * harga3.doubleValue() / Integer.parseInt(this.lblpoin.getText())), 
                  this.lblNewLabel.getText(), 
                  Integer.toString(jumlah_qty), 
                  this.textField_2.getText(), 
                  this.decimalFormat.format(jumlah_qty * harga3.doubleValue()) }, this.lblbarcodeBarang.getText(), this.lblpoin.getText(), Double.valueOf(jumlah_qty * harga3.doubleValue()));
        
      }
      else if (Jlablediskon2.getText().equals("0") && Jlablediskon1.getText().equals("0")) {
          String str2 = this.textField_1.getText();
            String strNew2 = str2.replaceFirst(",", "");
            Double harga3 = Double.valueOf(Double.parseDouble(strNew2));
            AdminKasir.AddRowToJTable(new Object[] { this.lblbarcodeBarang.getText(), 
                  Double.valueOf(jumlah_qty * harga3.doubleValue() / Integer.parseInt(this.lblpoin.getText())), 
                  this.lblNewLabel.getText(), 
                  Integer.toString(jumlah_qty), 
                  this.textField_1.getText(), 
                  this.decimalFormat.format(jumlah_qty * harga3.doubleValue()) }, this.lblbarcodeBarang.getText(), this.lblpoin.getText(), Double.valueOf(jumlah_qty * harga3.doubleValue()));
      }
      else {
         String str2 = this.textField_3.getText();
            String strNew2 = str2.replaceFirst(",", "");
            Double harga3 = Double.valueOf(Double.parseDouble(strNew2));
            AdminKasir.AddRowToJTable(new Object[] { this.lblbarcodeBarang.getText(), 
                  Double.valueOf(jumlah_qty * harga3.doubleValue() / Integer.parseInt(this.lblpoin.getText())), 
                  this.lblNewLabel.getText(), 
                  Integer.toString(jumlah_qty), 
                  this.textField_3.getText(), 
                  this.decimalFormat.format(jumlah_qty * harga3.doubleValue()) }, this.lblbarcodeBarang.getText(), this.lblpoin.getText(), Double.valueOf(jumlah_qty * harga3.doubleValue()));
      }
     
    } else {
      String str = this.textField_1.getText();
      String strNew = str.replaceFirst(",", "");
      Double harga = Double.valueOf(Double.parseDouble(strNew));
      System.out.println("hasil x" + strNew);
      AdminKasir.AddRowToJTable(new Object[] { this.lblbarcodeBarang.getText(), 
            Double.valueOf(jumlah_qty * harga.doubleValue() / Integer.parseInt(this.lblpoin.getText())), 
            this.lblNewLabel.getText(), 
            Integer.toString(jumlah_qty), 
            this.textField_1.getText(), 
            this.decimalFormat.format(jumlah_qty * harga.doubleValue()) }, this.lblbarcodeBarang.getText(), this.lblpoin.getText(), Double.valueOf(jumlah_qty * harga.doubleValue()));
    } 
    
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
          Double.valueOf(jumlah_qty * harga.doubleValue() / Integer.parseInt(this.lblpoin.getText())), 
          this.lblNewLabel.getText(), 
          Integer.toString(jumlah_qty), 
          this.textField_1.getText(), 
          this.decimalFormat.format(jumlah_qty * harga.doubleValue()) }, this.lblbarcodeBarang.getText(), this.lblpoin.getText(), Double.valueOf(jumlah_qty * harga.doubleValue()));
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
              Double.valueOf(jumlah_qty * harga.doubleValue() / Integer.parseInt(this.lblpoin.getText())), 
              this.lblNewLabel.getText(), 
              Integer.toString(jumlah_qty), 
              this.textField_2.getText(), 
              this.decimalFormat.format(jumlah_qty * harga.doubleValue()) }, this.lblbarcodeBarang.getText(), this.lblpoin.getText(), Double.valueOf(jumlah_qty * harga.doubleValue()));
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
    if(Jlablediskon1.getText().equals("0") && Jlablediskon2.getText().equals("0")) {
        String str = this.textField_1.getText();
        String strNew = str.replaceFirst(",", "");
        Double harga = Double.valueOf(Double.parseDouble(strNew));
        AdminKasir.AddRowToJTable(new Object[] { this.lblbarcodeBarang.getText(), 
              Double.valueOf(jumlah_qty * harga.doubleValue() / Integer.parseInt(this.lblpoin.getText())), 
              this.lblNewLabel.getText(), 
              Integer.toString(jumlah_qty), 
              this.textField_1.getText(), 
              this.decimalFormat.format(jumlah_qty * harga.doubleValue()) }, this.lblbarcodeBarang.getText(), this.lblpoin.getText(), Double.valueOf(jumlah_qty * harga.doubleValue()));
              HitungTotal(jumlah_qty * harga , jum_table);

    }
    else if(Jlablediskon2.getText().equals("0") && Jlablediskon1.getText() != "0" ) {
      if(jumlah_qty < Integer.parseInt(Jlablediskon1.getText())) {
          String str = this.textField_1.getText();
 
        String strNew = str.replaceFirst(",", "");
              Double harga = Double.valueOf(Double.parseDouble(strNew));
              AdminKasir.AddRowToJTable(new Object[] { this.lblbarcodeBarang.getText(), 
                    Double.valueOf(jumlah_qty * harga.doubleValue() / Integer.parseInt(this.lblpoin.getText())), 
                    this.lblNewLabel.getText(), 
                    Integer.toString(jumlah_qty), 
                    this.textField_1.getText(), 
                    this.decimalFormat.format(jumlah_qty * harga.doubleValue()) }, this.lblbarcodeBarang.getText(), this.lblpoin.getText(), Double.valueOf(jumlah_qty * harga.doubleValue()));
              HitungTotal(jumlah_qty * harga , jum_table);

      }
      else if (jumlah_qty>= Integer.parseInt(Jlablediskon1.getText())) {
          String str = this.textField_2.getText();

        String strNew = str.replaceFirst(",", "");
          Double harga = Double.valueOf(Double.parseDouble(strNew));
          AdminKasir.AddRowToJTable(new Object[] { this.lblbarcodeBarang.getText(), 
                Double.valueOf(jumlah_qty * harga.doubleValue() / Integer.parseInt(this.lblpoin.getText())), 
                this.lblNewLabel.getText(), 
                Integer.toString(jumlah_qty), 
                this.textField_2.getText(), 
                this.decimalFormat.format(jumlah_qty * harga.doubleValue()) }, this.lblbarcodeBarang.getText(), this.lblpoin.getText(), Double.valueOf(jumlah_qty * harga.doubleValue()));
          HitungTotal(jumlah_qty * harga ,jum_table);

      }
    }
    else if(Jlablediskon1.getText().equals("0") && Jlablediskon2.getText() != "0" ) {
      if (jumlah_qty < Integer.parseInt(Jlablediskon2.getText())) {
         String str = this.textField_1.getText();

        String strNew = str.replaceFirst(",", "");
          Double harga = Double.valueOf(Double.parseDouble(strNew));
          AdminKasir.AddRowToJTable(new Object[] { this.lblbarcodeBarang.getText(), 
                Double.valueOf(jumlah_qty * harga.doubleValue() / Integer.parseInt(this.lblpoin.getText())), 
                this.lblNewLabel.getText(), 
                Integer.toString(jumlah_qty), 
                this.textField_1.getText(), 
                this.decimalFormat.format(jumlah_qty * harga.doubleValue()) }, this.lblbarcodeBarang.getText(), this.lblpoin.getText(), Double.valueOf(jumlah_qty * harga.doubleValue()));
          HitungTotal(jumlah_qty * harga, jum_table );

      }
      else  if(jumlah_qty >=  Integer.parseInt(Jlablediskon2.getText())){
       String str = this.textField_3.getText();

        String strNew = str.replaceFirst(",", "");
          Double harga = Double.valueOf(Double.parseDouble(strNew));
          AdminKasir.AddRowToJTable(new Object[] { this.lblbarcodeBarang.getText(), 
                Double.valueOf(jumlah_qty * harga.doubleValue() / Integer.parseInt(this.lblpoin.getText())), 
                this.lblNewLabel.getText(), 
                Integer.toString(jumlah_qty), 
                this.textField_3.getText(), 
                this.decimalFormat.format(jumlah_qty * harga.doubleValue()) }, this.lblbarcodeBarang.getText(), this.lblpoin.getText(), Double.valueOf(jumlah_qty * harga.doubleValue()));
          		HitungTotal(jumlah_qty * harga , jum_table);

      }


    }
    else {
        String str = this.textField_2.getText();
       String strNew = str.replaceFirst(",", "");
      Double harga = Double.valueOf(Double.parseDouble(strNew));
      AdminKasir.AddRowToJTable(new Object[] { this.lblbarcodeBarang.getText(), 
            Double.valueOf(jumlah_qty * harga.doubleValue() / Integer.parseInt(this.lblpoin.getText())), 
            this.lblNewLabel.getText(), 
            Integer.toString(jumlah_qty), 
            this.textField_2.getText(), 
            this.decimalFormat.format(jumlah_qty * harga.doubleValue()) }, this.lblbarcodeBarang.getText(), this.lblpoin.getText(), Double.valueOf(jumlah_qty * harga.doubleValue()));
      		HitungTotal(jumlah_qty * harga , jum_table);

    }
  
}
     
  /*
  private void ambilDataBarang() {
    if (this.barcodeTextField.getText().equals(this.lblbarcodeBarang.getText())) {
      int jumlah_qty = 0;
      jumlah_qty += Integer.parseInt(this.textField.getText());
    } else {
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
        System.out.println("silver");//
      } 

      if (jumlah_qty >=  Integer.parseInt(Jlablediskon1.getText()) && jumlah_qty <  Integer.parseInt(Jlablediskon2.getText())) {
        String str22 = this.textField_2.getText();
        String strNew22 = str22.replaceFirst(",", "");
        Double harga32 = Double.valueOf(Double.parseDouble(strNew22));
        AdminKasir.AddRowToJTable(new Object[] { this.lblbarcodeBarang.getText(), 
              Double.valueOf(jumlah_qty * harga32.doubleValue() / Integer.parseInt(this.lblpoin.getText())), 
              this.lblNewLabel.getText(), 
              Integer.toString(jumlah_qty), 
              this.textField_2.getText(), 
              this.decimalFormat.format(jumlah_qty * harga32.doubleValue()) }, this.lblbarcodeBarang.getText(), this.lblpoin.getText(), Double.valueOf(jumlah_qty * harga32.doubleValue()));
      } else if (jumlah_qty >=  Integer.parseInt(Jlablediskon2.getText())) {
        String str2 = this.textField_3.getText();
        String strNew2 = str2.replaceFirst(",", "");
        Double harga3 = Double.valueOf(Double.parseDouble(strNew2));
        AdminKasir.AddRowToJTable(new Object[] { this.lblbarcodeBarang.getText(), 
              Double.valueOf(jumlah_qty * harga3.doubleValue() / Integer.parseInt(this.lblpoin.getText())), 
              this.lblNewLabel.getText(), 
              Integer.toString(jumlah_qty), 
              this.textField_3.getText(), 
              this.decimalFormat.format(jumlah_qty * harga3.doubleValue()) }, this.lblbarcodeBarang.getText(), this.lblpoin.getText(), Double.valueOf(jumlah_qty * harga3.doubleValue()));
      } else {
        String str = this.textField_1.getText();
        String strNew = str.replaceFirst(",", "");
        Double harga = Double.valueOf(Double.parseDouble(strNew));
        System.out.println("hasil x" + strNew);
        AdminKasir.AddRowToJTable(new Object[] { this.lblbarcodeBarang.getText(), 
              Double.valueOf(jumlah_qty * harga.doubleValue() / Integer.parseInt(this.lblpoin.getText())), 
              this.lblNewLabel.getText(), 
              Integer.toString(jumlah_qty), 
              this.textField_1.getText(),               
              this.decimalFormat.format(jumlah_qty * harga.doubleValue()) }, this.lblbarcodeBarang.getText(), this.lblpoin.getText(), Double.valueOf(jumlah_qty * harga.doubleValue()));
      } 
      
      hitungTotalPoin();
      this.textField.setText("1");
    } 
  }
  */
  private void CariBarang2() {
    boolean benar = true;
    try {
      Connection konek = Koneksi.getKoneksi();
      Statement state = konek.createStatement();
      String sql = "select nama_barang, harga_jual,harga_diskon,harga_lain,persediaan,balance,mindiskon,mindiskon2,harga_beli,id_kategori,satuan, poins, kd_barang from Barang WHERE kd_barang = '" + 
        
        this.barcodeTextField.getText() + "'";
      ResultSet rs = state.executeQuery(sql);
      if (rs.next()) {
        this.lblNewLabel.setText(rs.getString(1));
        this.textField_1.setText(this.df.format(rs.getDouble(2)));
        setHarga1(Double.valueOf(rs.getDouble(2)));
        this.textField_2.setText(this.df.format(rs.getDouble(3)));
        setHarga2(Double.valueOf(rs.getDouble(3)));
        this.textField_3.setText(this.df.format(rs.getDouble(4)));
        setHarga3(Double.valueOf(rs.getDouble(4)));
        this.lblbarcodeBarang.setText(rs.getString(13));
        this.Jlablediskon1.setText(rs.getInt(7)+"");
        this.Jlablediskon2.setText(rs.getInt(8)+"");
        System.out.println("nilai nya"+ rs.getInt(7));
        this.lblpoin.setText(String.valueOf(rs.getInt(12)));
        this.Jlabelstatus.setText((new StringBuilder(String.valueOf(rs.getInt(6)))).toString());
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
        this.lblNewLabel.setText(rs.getString(1));
        this.textField_1.setText(this.df.format(rs.getDouble(2)));
        setHarga1(Double.valueOf(rs.getDouble(2)));
        this.textField_2.setText(this.df.format(rs.getDouble(3)));
        setHarga2(Double.valueOf(rs.getDouble(3)));
        this.textField_3.setText(this.df.format(rs.getDouble(4)));
        setHarga3(Double.valueOf(rs.getDouble(4)));
        this.lblbarcodeBarang.setText(rs.getString(13));
        this.lblpoin.setText(String.valueOf(rs.getInt(12)));
        
        this.Jlablediskon1.setText((rs.getInt(7))+"");
        this.Jlablediskon2.setText((rs.getInt(8))+"");
        this.Jlabelstatus.setText((new StringBuilder(String.valueOf(rs.getInt(6)))).toString());
        benar = false;
      } 
    } catch (Exception exception) {}
  }
  private void HitungTotal(Double total_juml_bayar, Double total_di_table) {
	  
	  Double total_bayar_skr = (Double.parseDouble(lblBelanjaTotalNilai.getText().replace(",", "")) +  total_juml_bayar) - total_di_table;
	  lblBelanjaTotalNilai.setText(df.format(total_bayar_skr));
	  
  }
}
