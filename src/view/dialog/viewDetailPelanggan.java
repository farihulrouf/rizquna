package view.dialog;
 

import com.silver.data.Pelanggan;
import com.silver.model.table.TableModelPelanggan;
import view.AdminKasir;
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
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class viewDetailPelanggan extends JDialog {
  private final JPanel contentPanel = new JPanel();
  
  private TableModelPelanggan tableModel;
  
  private Pelanggan pelanggan;
  
  Locale locale = new Locale("en", "UK");
  
  DecimalFormat df = (DecimalFormat)NumberFormat.getNumberInstance(this.locale);
  
  public static Double harga_barang;
  
  public Double getHarga_barang() {
    return harga_barang;
  }
  
  public void setHarga_barang(Double harga_barang) {
    viewDetailPelanggan.harga_barang = harga_barang;
  }
  
  private String[] columns = new String[] { "harga", "Rp" };
  
  public String jumlah;
  
  private String barcode;
  
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
  
  public viewDetailPelanggan(AdminKasir parent, int poin, String nama, String hp, boolean modal) {
    setModal(true);
    setBackground(new Color(211, 211, 211));
    this.tableModel = new TableModelPelanggan();
    this.pelanggan = new Pelanggan();
    setBounds(100, 100, 500, 400);
    getContentPane().setLayout(new BorderLayout());
    this.contentPanel.setBackground(Color.GREEN);
    this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(this.contentPanel, "Center");
    this.data = new Object[][] { { "nama", nama }, { "hp", hp }, { "poin", Integer.valueOf(poin) } };
    this.contentPanel.setLayout((LayoutManager)null);
    setModal(true);
    this.textField = new JTextField();
    this.textField.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
              case 40:
                viewDetailPelanggan.this.textField.setBackground(Color.WHITE);
                viewDetailPelanggan.this.textField_1.setBackground(Color.GREEN);
                viewDetailPelanggan.this.textField_1.requestFocus();
                break;
              case 10:
                viewDetailPelanggan.this.dispose();
                break;
            } 
          }
        });
    this.textField.setText("1");
    this.textField.selectAll();
    this.textField.setFont(new Font("Dialog", 1, 24));
    this.textField.setBounds(246, 126, 114, 48);
    this.contentPanel.add(this.textField);
    this.textField.setColumns(10);
    JLabel lblJumlah = new JLabel("Jumlah");
    lblJumlah.setFont(new Font("Dialog", 1, 20));
    lblJumlah.setBounds(32, 135, 112, 33);
    this.contentPanel.add(lblJumlah);
    JPanel panel = new JPanel();
    panel.setBackground(Color.WHITE);
    panel.setBounds(27, 53, 436, 70);
    this.contentPanel.add(panel);
    panel.setLayout((LayoutManager)null);
    JLabel lblNewLabel = new JLabel(nama);
    lblNewLabel.setBounds(30, 12, 373, 35);
    panel.add(lblNewLabel);
    lblNewLabel.setForeground(new Color(255, 140, 0));
    lblNewLabel.setFont(new Font("Dialog", 1, 18));
    JButton btnNewButton = new JButton("Simpan");
    btnNewButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {}
        });
    btnNewButton.setBounds(605, 392, 133, 33);
    this.contentPanel.add(btnNewButton);
    JLabel lblNewLabel_1 = new JLabel();
    lblNewLabel_1.setForeground(Color.ORANGE);
    lblNewLabel_1.setFont(new Font("Dialog", 1, 25));
    lblNewLabel_1.setBounds(186, 12, 220, 29);
    this.contentPanel.add(lblNewLabel_1);
    JLabel lblKodeBarcode = new JLabel("Persediaan");
    lblKodeBarcode.setFont(new Font("Dialog", 1, 15));
    lblKodeBarcode.setBounds(27, 18, 117, 23);
    this.contentPanel.add(lblKodeBarcode);
    this.textField_1 = new JTextField();
    this.textField_1.setFont(new Font("Dialog", 1, 25));
    this.textField_1.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
              case 40:
                viewDetailPelanggan.this.textField_1.setBackground(Color.WHITE);
                viewDetailPelanggan.this.textField_2.requestFocus();
                viewDetailPelanggan.this.textField_2.setBackground(Color.GREEN);
                break;
              case 38:
                viewDetailPelanggan.this.textField_1.setBackground(Color.WHITE);
                viewDetailPelanggan.this.textField.requestFocus();
                viewDetailPelanggan.this.textField.setBackground(Color.GREEN);
                break;
              case 10:
                viewDetailPelanggan.this.dispose();
                break;
            } 
          }
        });
    this.textField_1.setBounds(246, 202, 202, 33);
    this.contentPanel.add(this.textField_1);
    this.textField_1.setColumns(10);
    this.textField_2 = new JTextField();
    this.textField_2.setFont(new Font("Dialog", 1, 25));
    this.textField_2.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
              case 40:
                viewDetailPelanggan.this.textField_3.requestFocus();
                viewDetailPelanggan.this.textField_3.setBackground(Color.GREEN);
                viewDetailPelanggan.this.textField_2.setBackground(Color.WHITE);
                break;
              case 38:
                viewDetailPelanggan.this.textField_1.requestFocus();
                viewDetailPelanggan.this.textField_1.setBackground(Color.GREEN);
                viewDetailPelanggan.this.textField_2.setBackground(Color.WHITE);
                break;
              case 10:
                viewDetailPelanggan.this.dispose();
                break;
            } 
          }
        });
    this.textField_2.setColumns(10);
    this.textField_2.setBounds(246, 247, 202, 33);
    this.contentPanel.add(this.textField_2);
    this.textField_3 = new JTextField();
    this.textField_3.setFont(new Font("Dialog", 1, 25));
    this.textField_3.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
              case 40:
                viewDetailPelanggan.this.textField_3.setBackground(Color.WHITE);
                viewDetailPelanggan.this.textField.requestFocus();
                viewDetailPelanggan.this.textField.setBackground(Color.GREEN);
                break;
              case 38:
                viewDetailPelanggan.this.textField_3.setBackground(Color.WHITE);
                viewDetailPelanggan.this.textField_2.requestFocus();
                viewDetailPelanggan.this.textField_2.setBackground(Color.GREEN);
                break;
              case 10:
                viewDetailPelanggan.this.dispose();
                break;
            } 
          }
        });
    this.textField_3.setColumns(10);
    this.textField_3.setBounds(246, 292, 202, 33);
    this.contentPanel.add(this.textField_3);
    JLabel lblHargaEcer = new JLabel("Harga Ecer");
    lblHargaEcer.setFont(new Font("Dialog", 1, 18));
    lblHargaEcer.setBounds(32, 210, 118, 33);
    this.contentPanel.add(lblHargaEcer);
    JLabel lblHargaKulak = new JLabel("Harga Kulak");
    lblHargaKulak.setFont(new Font("Dialog", 1, 18));
    lblHargaKulak.setBounds(32, 255, 174, 33);
    this.contentPanel.add(lblHargaKulak);
    JLabel lblHargaKarton = new JLabel("Harga Karton");
    lblHargaKarton.setFont(new Font("Dialog", 1, 18));
    lblHargaKarton.setBounds(32, 296, 174, 33);
    this.contentPanel.add(lblHargaKarton);
    JPanel buttonPane = new JPanel();
    buttonPane.setBackground(new Color(165, 42, 42));
    buttonPane.setLayout(new FlowLayout(2));
    getContentPane().add(buttonPane, "South");
    JButton okButton = new JButton("OK");
    okButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            viewDetailPelanggan.this.klik();
            viewDetailPelanggan.this.dispose();
          }
        });
    okButton.setActionCommand("OK");
    buttonPane.add(okButton);
    getRootPane().setDefaultButton(okButton);
    JButton cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            viewDetailPelanggan.this.dispose();
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
  
  private void ambil_satu(Double hargas) {
    setJumlah(this.textField.getText());
    setHarga_barang(hargas);
  }
}
