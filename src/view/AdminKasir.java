package view;

 

import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import com.silver.controller.ControllerJual;
import com.silver.controller.controllerDetailJual;
import com.silver.data.Harga;
import com.silver.data.UserSession;
import com.silver.model.ModelDetailJual;
import com.silver.model.ModelJual;
import view.dialog.ViewDialogBarang;
import view.dialog.Withdraw;
import view.dialog.cekStok;
import view.dialog.viewBarang;
import view.dialog.viewCetakUlang;
import view.dialog.viewDataPelanggan;
import view.dialog.viewHarga;
import view.dialog.viewKonfirmasi;
import view.dialog.viewPegawai;
import view.dialog.viewPelanggan;
import view.dialog.viewSejarah;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.LayoutManager;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import simple.escp.SimpleEscp;
import simple.escp.Template;
import simple.escp.data.DataSource;
import simple.escp.data.DataSources;
import simple.escp.json.JsonTemplate;

public class AdminKasir extends JFrame {
  private String nomer;
  
  private JButton btnHistori;
  
  private JButton btnPelanggan;
  
  int poinCetak;
  
  private Double tunai;
  
  private JLabel poinDum;
  
  public Double poin_total_jual;
  
  public Double getPoin_total_jual() {
	return poin_total_jual;
}

public void setPoin_total_jual(Double poin_total_jual) {
	this.poin_total_jual = poin_total_jual;
}

public int getMindiskon1() {
	return mindiskon1;
}

public void setMindiskon1(int mindiskon1) {
	this.mindiskon1 = mindiskon1;
}

public int getMindiskon2() {
	return mindiskon2;
}

public void setMindiskon2(int mindiskon2) {
	this.mindiskon2 = mindiskon2;
}

private Double kembali;
  
  private ControllerJual controllerJ;
  
  private controllerDetailJual conttrollerD;
  
  private ModelJual model;
  private int mindiskon1;
  private int mindiskon2;
  
  private ModelDetailJual model2;
  
  private String kalkulasi_jam;
  
  private String tanggal_tutup;
  
  private Double total_penghasilan;
  
  private String user_name;
  
  private Double total_curen;
  
  private int id_kategori;
  
  private JButton btnNewButton;
  
  private Double total_reni;
  
  private Double point;
  
  private JLabel totalPoinPelanggan;
  
  private double seluruh_poin;
  
  private int total_poin;
  
  private int poin_barang;
  
  private String no_hp;
  
  private JButton btnCekstok;
  
  private String id_pelanggan;
  
  public int getPoinCetak() {
    return this.poinCetak;
  }
  
  public void setPoinCetak(int poinCetak) {
    this.poinCetak = poinCetak;
  }
  
  public Double getSeluruh_poin() {
    return this.seluruh_poin;
  }
  
  public void setSeluruh_poin(double seluruh_poin) {
    this.seluruh_poin = seluruh_poin;
  }
  
  public int getTotal_poin() {
    return this.total_poin;
  }
  
  public void setTotal_poin(int total_poin) {
    this.total_poin = total_poin;
  }
  
  public int getPoin_barang() {
    return this.poin_barang;
  }
  
  public void setPoin_barang(int poin_barang) {
    this.poin_barang = poin_barang;
  }
  
  private ArrayList poin_aray = new ArrayList();
  
  private String nama_pelanggan;
  
  public Double getPoint() {
    return this.point;
  }
  
  public String getId_pelanggan() {
    return this.id_pelanggan;
  }
  
  public void setId_pelanggan(String id_pelanggan) {
    this.id_pelanggan = id_pelanggan;
  }
  
  public void setPoint(Double point) {
    this.point = point;
  }
  
  public String getNo_hp() {
    return this.no_hp;
  }
  
  public void setNo_hp(String no_hp) {
    this.no_hp = no_hp;
  }
  
  public String getNama_pelanggan() {
    return this.nama_pelanggan;
  }
  
  public void setNama_pelanggan(String nama_pelanggan) {
    this.nama_pelanggan = nama_pelanggan;
  }
  
  public Double getTotal_reni() {
    return this.total_reni;
  }
  
  public void setTotal_reni(Double total_reni) {
    this.total_reni = total_reni;
  }
  
  public int getId_kategori() {
    return this.id_kategori;
  }
  
  public void setId_kategori(int id_kategori) {
    this.id_kategori = id_kategori;
  }
  
  public Double getTotal_curen() {
    return this.total_curen;
  }
  
  public void setTotal_curen(Double total_curen) {
    this.total_curen = total_curen;
  }
  
  NumberFormat numberFormat = new DecimalFormat("#,###,###");
  
  private UserSession usersesion;
  
  private int no_jual;
  
  double jumlahpoindiprint;
  
  public String getUser_name() {
    return this.user_name;
  }
  
  public void setUser_name(String user_name) {
    this.user_name = user_name;
  }
  
  public Double getTotal_penghasilan() {
    return this.total_penghasilan;
  }
  
  public void setTotal_penghasilan(Double total_penghasilan) {
    this.total_penghasilan = total_penghasilan;
  }
  
  public String getTanggal_tutup() {
    return this.tanggal_tutup;
  }
  
  public Double getJumlahpoindiprint() {
    return this.jumlahpoindiprint;
  }
  
  public void setJumlahpoindiprint(double jumlahpoindiprint) {
    this.jumlahpoindiprint = jumlahpoindiprint;
  }
  
  public void setTanggal_tutup(String tanggal_tutup) {
    this.tanggal_tutup = tanggal_tutup;
  }
  
  public String getKalkulasi_jam() {
    return this.kalkulasi_jam;
  }
  
  public void setKalkulasi_jam(String kalkulasi_jam) {
    this.kalkulasi_jam = kalkulasi_jam;
  }
  
  public Double getKembali() {
    return this.kembali;
  }
  
  public JTable getTable() {
    return this.table;
  }
  
  public void setTable(JTable table) {
    this.table = table;
  }
  
  public int getNo_jual() {
    return this.no_jual;
  }
  
  public void setNo_jual(int no_jual) {
    this.no_jual = no_jual;
  }
  
  public void setKembali(Double kembali) {
    this.kembali = kembali;
  }
  
  public Double getTunai() {
    return this.tunai;
  }
  
  public void setTunai(Double tunai) {
    this.tunai = tunai;
  }
  
  public String getNomer() {
    return this.nomer;
  }
  
  public void setNomer(String nomer) {
    this.nomer = nomer;
  }
  
  DateFormat jam = new SimpleDateFormat("HH:mm:ss");
  
  Date hasil = new Date();
  
  String jam_skr = this.jam.format(this.hasil).toString();
  
  int waktumulai = 0;
  
  private JLabel lblJam;
  
  private JButton btnReset;
  
  private JLabel lblNewLabel;
  
  private Double Harga_juals;
  
  private String juml;
  
  private String jumlah_barter;
  
  private String nama_barang;
  
  private Double harga_jual;
  
  private Double harga_diskon;
  
  private Double harga_lain;
  
  private int Persedian;
  
  private Double harga_beli;
  
  private String ujibarcode;
  
  private Double harga_jual_tab;
  
  private JButton btnBarang;
  
  private String balance;
  
  private JPanel contentPane;
  
  private JTextField barCode;
  
  private JTextField textPelanggan;
  
  private JTable table;
  
  private Double total_bayar;
  
  private JLabel labelTotal;
  
  private JButton btnWithdraw;
  
  private JLabel lblNamaPelanggan;
  
  public void jam_digital() {
    (new Thread() {
        public void run() {
          while (AdminKasir.this.waktumulai == 0) {
            Calendar kalender = new GregorianCalendar();
            int jam = kalender.get(10);
            int menit = kalender.get(12);
            int detik = kalender.get(13);
            int AM_PM = kalender.get(9);
            String siang_malam = "";
            if (AM_PM == 1) {
              siang_malam = "PM";
            } else {
              siang_malam = "AM";
            } 
            String time = String.valueOf(String.valueOf(String.valueOf(jam))) + ":" + menit + ":" + detik + " " + siang_malam;
            AdminKasir.this.lblNewLabel.setText(time);
          } 
        }
      }).start();
  }
  
  private void ligatWithdraw() {
    Withdraw view = new Withdraw(this.lblJam.getText());
    view.setVisible(true);
  }
  
  public Double getHarga_juals() {
    return this.Harga_juals;
  }
  
  public String getJuml() {
    return this.juml;
  }
  
  public void setJuml(String juml) {
    this.juml = juml;
  }
  
  public void setHarga_juals(Double harga_juals) {
    this.Harga_juals = harga_juals;
  }
  
  public String getJumlah_barter() {
    return this.jumlah_barter;
  }
  
  public void setJumlah_barter(String jumlah_barter) {
    this.jumlah_barter = jumlah_barter;
  }
  
  public String getNama_barang() {
    return this.nama_barang;
  }
  
  public void setNama_barang(String nama_barang) {
    this.nama_barang = nama_barang;
  }
  
  private void pesan() {
    JOptionPane.showMessageDialog(this, "Maaf " + getUser_name() + "!!!" + "Barcode Masih Kosong, Tolong Di isi ya");
  }
  
  private void pesan2() {
    JOptionPane.showMessageDialog(this, "Maaf " + getUser_name() + "!!!" + "Kode Barcode tidak di temukan");
  }
  
  public Double getHarga_jual() {
    return this.harga_jual;
  }
  
  public void setHarga_jual(Double harga_jual) {
    this.harga_jual = harga_jual;
  }
  
  public Double getHarga_diskon() {
    return this.harga_diskon;
  }
  
  public void setHarga_diskon(Double harga_diskon) {
    this.harga_diskon = harga_diskon;
  }
  
  public Double getHarga_lain() {
    return this.harga_lain;
  }
  
  public void setHarga_lain(Double harga_lain) {
    this.harga_lain = harga_lain;
  }
  
  public int getPersedian() {
    return this.Persedian;
  }
  
  public void setPersedian(int Persedian) {
    this.Persedian = Persedian;
  }
  
  public Double getHarga_beli() {
    return this.harga_beli;
  }
  
  public void setHarga_beli(Double harga_beli) {
    this.harga_beli = harga_beli;
  }
  
  public String getUjibarcode() {
    return this.ujibarcode;
  }
  
  public void setUjibarcode(String ujibarcode) {
    this.ujibarcode = ujibarcode;
  }
  
  public Double getHarga_jual_tab() {
    return this.harga_jual_tab;
  }
  
  public void setHarga_jual_tab(Double harga_jual_tab) {
    this.harga_jual_tab = harga_jual_tab;
  }
  
  public String getBalance() {
    return this.balance;
  }
  
  public void setBalance(String balance) {
    this.balance = balance;
  }
  
  Locale locale = new Locale("en", "UK");
  
  DecimalFormat decimalFormat = (DecimalFormat)NumberFormat.getNumberInstance(this.locale);
  
  private JLabel labelKembali;
  
  DefaultTableModel tableModel = new DefaultTableModel(
      new Object[0][], (Object[])new String[] { "Barcode", "Barang", 
        "Harga Jual", "Qty", "Total" }) {
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };
  
  private JTextField textField;
  
  private JTextField textField_1;
  
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
          public void run() {
            try {
              McWinLookAndFeel.setTheme("Large-Font", "Java Swing", "");
              UIManager.setLookAndFeel(
                  "com.jtattoo.plaf.mcwin.McWinLookAndFeel");
              AdminKasir frame = new AdminKasir();
              frame.setVisible(true);
            } catch (Exception e) {
              e.printStackTrace();
            } 
          }
        });
  }
  
  private void tampilBarang() {
    viewBarang view = new viewBarang();
    view.setVisible(true);
  }
  
  private void getScreen() {
    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    int width = gd.getDisplayMode().getWidth();
    int height = gd.getDisplayMode().getHeight();
  }
  
  public AdminKasir() {
    setDefaultCloseOperation(3);
    setBounds(100, 100, 1200, 700);
    this.usersesion = new UserSession();
    this.conttrollerD = new controllerDetailJual();
    this.controllerJ = new ControllerJual();
    this.model2 = new ModelDetailJual();
    this.model = new ModelJual();
    this.controllerJ.setModel(this.model);
    this.conttrollerD.setModel(this.model2);
    this.contentPane = new JPanel();
    this.contentPane.setBackground(new Color(0, 191, 255));
    this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    getScreen();
    setContentPane(this.contentPane);
    this.contentPane.setLayout((LayoutManager)null);
    this.textField_1 = new JTextField();
    this.textPelanggan = new JTextField();
    this.barCode = new JTextField();
    this.barCode.requestFocus();
    this.barCode.setBackground(Color.red);
    this.barCode.requestFocus();
    this.textPelanggan.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
              case 38:
                AdminKasir.this.textField.requestFocus();
                AdminKasir.this.textField.setBackground(Color.GREEN);
                AdminKasir.this.textPelanggan.setBackground(Color.WHITE);
                break;
              case 39:
                AdminKasir.this.findPelanggan();
                break;
              case 10:
                if (AdminKasir.this.textPelanggan.getText() != "")
                  try {
                    AdminKasir.this.cariPelanggan();
                    if (AdminKasir.this.textPelanggan.getText().equals("")) {
                      AdminKasir.this.pesan();
                      break;
                    } 
                    AdminKasir.this.textPelanggan.setText("");
                  } catch (SQLException e1) {
                    e1.printStackTrace();
                  }  
                break;
            } 
          }
        });
    this.contentPane.add(this.textField_1);
    this.textField_1.setColumns(10);
    JLabel lblBayar = new JLabel("Bayar");
    lblBayar.setFont(new Font("Dialog", 1, 20));
    lblBayar.setBounds(12, 550, 96, 62);
    this.contentPane.add(lblBayar);
    this.textField = new JTextField();
    this.textField.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
              case 38:
                AdminKasir.this.barCode.requestFocus();
                AdminKasir.this.barCode.setBackground(Color.GREEN);
                AdminKasir.this.textField.setBackground(Color.WHITE);
                break;
              case 39:
                AdminKasir.this.findPelanggan();
                break;
              case 10:
                if (AdminKasir.this.textField.getText().equals("")) {
                  AdminKasir.this.pesandua();
                  break;
                } 
                AdminKasir.this.cek_uang();
                break;
            } 
          }
        });
    this.textField.setForeground(Color.RED);
    this.textField.setFont(new Font("Dialog", 1, 40));
    this.textField.setBounds(126, 550, 265, 77);
    this.contentPane.add(this.textField);
    this.textField.setColumns(10);
    this.textPelanggan.setForeground(Color.BLACK);
    this.textPelanggan.setFont(new Font("Dialog", 1, 17));
    this.textPelanggan.setBounds(126, 630, 180, 40);
    this.contentPane.add(this.textPelanggan);
    this.textPelanggan.setColumns(10);
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(12, 125, 1013, 380);
    this.contentPane.add(scrollPane);
    this.table = new JTable() {
        public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
          Component component = super.prepareRenderer(renderer, row, column);
          int rendererWidth = (component.getPreferredSize()).width;
          TableColumn tableColumn = getColumnModel().getColumn(column);
          tableColumn.setPreferredWidth(Math.max(rendererWidth + (getIntercellSpacing()).width, tableColumn.getPreferredWidth()));
          return component;
        }
      };
    this.table.setBackground(new Color(255, 140, 0));
    this.table.setFont(new Font("Dialog", 1, 21));
    this.table.setModel(this.tableModel);
    this.table.setRowHeight(35);
    this.table.addComponentListener(new ComponentAdapter() {
          public void componentResized(ComponentEvent e) {
            AdminKasir.this.table.scrollRectToVisible(AdminKasir.this.table.getCellRect(AdminKasir.this.table.getRowCount() - 1, 0, true));
          }
        });
    scrollPane.setViewportView(this.table);
    this.barCode.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            Harga harga;
            int keyCode = e.getKeyCode();
            switch (keyCode) {
              case 38:
                AdminKasir.this.findBarang();
                AdminKasir.this.labelKembali.setText("0");
                break;
              case 40:
                AdminKasir.this.textField.requestFocus();
                AdminKasir.this.textField.selectAll();
                AdminKasir.this.textField.setBackground(Color.GREEN);
                AdminKasir.this.barCode.setBackground(Color.WHITE);
                break;
              case 10:
                harga = new Harga();
                if (AdminKasir.this.barCode.getText() != "")
                  try {
                    AdminKasir.this.cari();
                    if (AdminKasir.this.barCode.getText().equals("")) {
                      AdminKasir.this.pesan();
                      break;
                    } 
                    if (AdminKasir.this.getNama_barang().equals("")) {
                      AdminKasir.this.pesan2();
                      break;
                    } 
                    viewHarga viewharga = new viewHarga(null, 
                        AdminKasir.this.getPersedian(), AdminKasir.this.getPoin_barang(), AdminKasir.this.getNama_barang(), 
                        AdminKasir.this.getHarga_jual(), 
                        AdminKasir.this.getHarga_diskon(), AdminKasir.this.getHarga_lain(), 
                        AdminKasir.this.getHarga_beli(), getBalance(), true);
                    AdminKasir.this.setHarga_juals(viewharga.getHarga_barang());
                    AdminKasir.this.setJuml(viewharga.getJumlah());
                    AdminKasir.this.setPoin_barang(viewharga.getPoin());
                    if (AdminKasir.this.getId_kategori() == 0) {
                      AdminKasir.this.ambil_Data();
                    } else if (AdminKasir.this.getId_kategori() == 1) {
                      AdminKasir.this.ambil_Data2();
                    } 
                    AdminKasir.this.setNama_barang("");
                    AdminKasir.this.setPersedian(0);
                    AdminKasir.this.setHarga_jual(Double.valueOf(0.0D));
                    AdminKasir.this.setBalance("");
                    AdminKasir.this.barCode.setText("");
                  } catch (SQLException e1) {
                    e1.printStackTrace();
                  }  
                break;
              case 39:
                AdminKasir.this.barCode.setBackground(Color.WHITE);
                break;
            } 
          }
        });
    this.barCode.setBounds(126, 89, 300, 34);
    this.contentPane.add(this.barCode);
    this.barCode.setColumns(10);
    JLabel lblBarcode = new JLabel("BARCODE");
    lblBarcode.setFont(new Font("Dialog", 1, 12));
    lblBarcode.setBounds(38, 98, 70, 15);
    this.contentPane.add(lblBarcode);
    this.btnWithdraw = new JButton("Hari ini");
    this.btnWithdraw.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            AdminKasir.this.ligatWithdraw();
          }
        });
    this.btnWithdraw.setIcon(new ImageIcon(AdminKasir.class.getResource("/com/silver/peratan/image/wire-transfer-icon.png")));
    this.btnWithdraw.setBounds(12, 1, 143, 35);
    this.contentPane.add(this.btnWithdraw);
    this.btnBarang = new JButton("Barang");
    this.btnBarang.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            AdminKasir.this.tampilBarang();
          }
        });
    this.btnBarang.setIcon(new ImageIcon(AdminKasir.class.getResource("/com/silver/peratan/image/sup.png")));
    this.btnBarang.setBounds(167, 1, 117, 35);
    this.contentPane.add(this.btnBarang);
    this.btnHistori = new JButton("Histori");
    this.btnHistori.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent paramActionEvent) {
            viewSejarah view = new viewSejarah();
            view.setVisible(true);
          }
        });
    this.btnHistori.setVisible(false);
    this.btnHistori.setIcon(new ImageIcon(AdminKasir.class.getResource("/com/silver/peratan/image/chart.png")));
    this.btnHistori.setBounds(296, 1, 117, 35);
    this.contentPane.add(this.btnHistori);
    JButton btnGantiShift = new JButton("x");
    btnGantiShift.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            try {
              AdminKasir.this.konfirmasiTutup();
            } catch (SQLException e) {
              e.printStackTrace();
            } 
          }
        });
    btnGantiShift.setIcon(new ImageIcon(AdminKasir.class.getResource("/com/silver/peratan/image/Preppy-icon.png")));
    btnGantiShift.setBounds(751, 39, 81, 25);
    this.contentPane.add(btnGantiShift);
    JButton btnHapus = new JButton("Hapus");
    btnHapus.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            AdminKasir.this.hapusTableJual();
          }
        });
    btnHapus.setIcon(new ImageIcon(AdminKasir.class.getResource("/com/silver/peratan/image/Actions-edit-clear-icon.png")));
    btnHapus.setBounds(794, 83, 109, 25);
    this.contentPane.add(btnHapus);
    this.btnReset = new JButton("Reset");
    this.btnReset.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            AdminKasir.this.resetTable();
          }
        });
    this.btnReset.setIcon(new ImageIcon(AdminKasir.class.getResource("/com/silver/peratan/image/clear.png")));
    this.btnReset.setBounds(908, 83, 117, 25);
    this.contentPane.add(this.btnReset);
    JButton btnActive = new JButton("Active");
    btnActive.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            AdminKasir.this.kuncil();
          }
        });
    btnActive.setIcon(new ImageIcon(AdminKasir.class.getResource("/com/silver/peratan/image/check.png")));
    btnActive.setBounds(865, 39, 109, 25);
    this.contentPane.add(btnActive);
    setUser_name(UserSession.getUserLogin());
    JPanel panel = new JPanel();
    JPanel panel3 = new JPanel();
    panel.setBackground(SystemColor.info);
    panel.setBounds(403, 550, 333, 77);
    panel3.setBackground(new Color(199, 21, 133));
    panel3.setBounds(403, 630, 333, 40);
    this.contentPane.add(panel);
    this.contentPane.add(panel3);
    panel.setLayout((LayoutManager)null);
    panel3.setLayout((LayoutManager)null);
    JLabel lblKembali = new JLabel("Kembali");
    lblKembali.setFont(new Font("Dialog", 1, 15));
    lblKembali.setBounds(12, 12, 70, 53);
    this.lblNamaPelanggan = new JLabel("");
    this.lblNamaPelanggan.setFont(new Font("Dialog", 1, 30));
    this.lblNamaPelanggan.setBounds(12, 12, 200, 20);
    panel.add(lblKembali);
    panel3.add(this.lblNamaPelanggan);
    this.labelKembali = new JLabel("");
    this.labelKembali.setFont(new Font("Dialog", 1, 27));
    this.labelKembali.setBounds(114, 12, 207, 53);
    panel.add(this.labelKembali);
    JPanel panel_1 = new JPanel();
    panel_1.setBackground(new Color(218, 112, 214));
    panel_1.setLayout((LayoutManager)null);
    panel_1.setBounds(751, 550, 253, 77);
    this.contentPane.add(panel_1);
    JPanel panel_4 = new JPanel();
    panel_4.setBackground(new Color(255, 165, 0));
    panel_4.setLayout((LayoutManager)null);
    panel_4.setBounds(751, 630, 253, 45);
    this.contentPane.add(panel_4);
    JLabel lblpoinsaat = new JLabel("Poin Saat Ini");
    lblpoinsaat.setFont(new Font("Dialog", 1, 10));
    lblpoinsaat.setBounds(12, 12, 80, 25);
    this.totalPoinPelanggan = new JLabel("0");
    this.poinDum = new JLabel("0");
    this.poinDum.setForeground(Color.RED);
    this.poinDum.setFont(new Font("Dialog", 1, 22));
    this.totalPoinPelanggan.setFont(new Font("Dialog", 1, 22));
    this.totalPoinPelanggan.setBounds(90, 12, 90, 25);
    this.poinDum.setBounds(180, 12, 80, 25);
    panel_4.add(this.totalPoinPelanggan);
    panel_4.add(this.poinDum);
    panel_4.add(lblpoinsaat);
    JLabel lblTotal = new JLabel("Total");
    lblTotal.setFont(new Font("Dialog", 1, 15));
    lblTotal.setBounds(12, 12, 48, 53);
    panel_1.add(lblTotal);
    this.labelTotal = new JLabel("");
    this.labelTotal.setFont(new Font("Dialog", 1, 30));
    this.labelTotal.setBounds(72, 12, 160, 53);
    panel_1.add(this.labelTotal);
    this.lblNewLabel = new JLabel("");
    this.lblNewLabel.setForeground(new Color(0, 128, 0));
    this.lblNewLabel.setFont(new Font("Dialog", 1, 17));
    this.lblNewLabel.setBounds(440, 68, 168, 45);
    this.contentPane.add(this.lblNewLabel);
    JLabel lblTerakhirTutup = new JLabel("Terakhir tutup di jam");
    lblTerakhirTutup.setFont(new Font("Dialog", 1, 18));
    lblTerakhirTutup.setBounds(685, 12, 265, 15);
    this.contentPane.add(lblTerakhirTutup);
    this.lblJam = new JLabel("");
    this.lblJam.setFont(new Font("Dialog", 1, 20));
    this.lblJam.setBounds(925, 12, 143, 25);
    this.contentPane.add(this.lblJam);
    JLabel label = new JLabel("Helo " + UserSession.getUserLogin() + " " + "Selamat Bekerja");
    label.setFont(new Font("Dialog", 1, 15));
    label.setBounds(421, 19, 280, 25);
    this.contentPane.add(label);
    this.btnNewButton = new JButton("Pegawai");
    this.btnNewButton.setIcon(new ImageIcon(AdminKasir.class.getResource("/com/silver/peratan/image/login.png")));
    this.btnNewButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            AdminKasir.this.tampilkanPegawai();
          }
        });
    this.btnNewButton.setVisible(false);
    this.btnNewButton.setFont(new Font("Dialog", 1, 10));
    this.btnNewButton.setBounds(12, 48, 130, 34);
    this.contentPane.add(this.btnNewButton);
    this.btnPelanggan = new JButton("Pelanggan");
    this.btnPelanggan.setIcon(new ImageIcon(AdminKasir.class.getResource("/com/silver/peratan/image/login.png")));
    this.btnPelanggan.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            AdminKasir.this.tampilPelanggan();
          }
        });
    this.btnPelanggan.setFont(new Font("Dialog", 1, 10));
    this.btnPelanggan.setBounds(167, 48, 130, 34);
    this.contentPane.add(this.btnPelanggan);
    JButton btnNewButton_1 = new JButton("Cetak Ulang");
    btnNewButton_1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            viewCetakUlang viewcetak = new viewCetakUlang();
            viewcetak.setVisible(true);
          }
        });
    btnNewButton_1.setIcon(new ImageIcon(AdminKasir.class.getResource("/com/silver/peratan/image/buku.png")));
    btnNewButton_1.setBounds(296, 48, 140, 34);
    this.contentPane.add(btnNewButton_1);
    JButton btnCekstok = new JButton("stok");
    btnCekstok.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            AdminKasir.this.tampilStok();
          }
        });
    btnCekstok.setIcon(new ImageIcon(AdminKasir.class.getResource("/com/silver/peratan/image/check.png")));
    btnCekstok.setBounds(450, 48, 100, 34);
    this.contentPane.add(btnCekstok);
    this.btnBarang.setVisible(false);
    this.btnWithdraw.setVisible(false);
    this.btnReset.setVisible(false);
    autoNumber3();
    autoNumber5();
    jam_digital();
  }
  
  private void lihat_harga() {
    viewHarga viewharga = new viewHarga(null, 
        getPersedian(), getPoin_barang(), getNama_barang(), 
        getHarga_jual(), 
        getHarga_diskon(), getHarga_lain(), 
        getHarga_beli(), getBalance(), true);
    setHarga_juals(viewharga.getHarga_barang());
    setJuml(viewharga.getJumlah());
    setPoin_barang(viewharga.getPoin());
    if (getId_kategori() == 0) {
      ambil_Data();
    } else if (getId_kategori() == 1) {
      ambil_Data2();
    } 
    setNama_barang("");
    setPersedian(0);
    setHarga_jual(Double.valueOf(0.0D));
    setBalance("");
    this.barCode.setText("");
  }
  
  private void clearTable() {
    this.tableModel.setRowCount(0);
  }
  
  private void resetTable() {
    this.barCode.setText("");
    clearTable();
    this.tableModel.setRowCount(0);
    this.labelTotal.setText("0");
    this.barCode.requestFocus();
    this.poinDum.setText("0");
  }
  
  private void simpan_dataArr(int arr) {
    this.poin_aray.add(Integer.valueOf(arr));
  }
  
  private void convertArray() {
    Integer[] jumArra = (Integer[])this.poin_aray.toArray((Object[])new Integer[0]);
    int total = 0;
    for (int i = 0; i < jumArra.length; i++)
      total += jumArra[i].intValue(); 
    setTotal_poin(total);
  }
  
  private void ambil_Data() {
    double totalnya = 0.0D;
    int k = Integer.valueOf(Integer.parseInt(getJuml())).intValue();
    simpan_dataArr(k * getPoin_barang());
    int stok = getPersedian();
    double haarga = 0.0;
    if(k < getMindiskon1()) {
        haarga = getHarga_juals().doubleValue();
    }
    else if ( k >= getMindiskon1() && k < getMindiskon2() ) {
    	haarga = getHarga_diskon().doubleValue();
    }
    else if ( k >= getMindiskon2()) {
    	haarga = getHarga_lain().doubleValue();
    }
    int balanc = Integer.valueOf(Integer.parseInt(getBalance())).intValue();
    System.out.println("tes balance" + balanc);
    System.out.println(haarga);
    System.out.println("harga diskon"+  getHarga_diskon().doubleValue());
    System.out.println("nilai min diskon"+ getMindiskon2());

    String s = "";
    boolean exists = false;
    double harg = 0.0D;
    int i = 0;
    while (i < this.table.getRowCount() && !exists) {
      s = this.tableModel.getValueAt(i, 0).toString().trim();
      harg = 
        Double.parseDouble(((String)this.table.getValueAt(i, 2)).replace(",", ""));
      if (this.barCode.getText().equals(s) && haarga == harg) {
        setJumlah_barter(this.tableModel.getValueAt(i, 3).toString().trim());
        exists = true;
        this.tableModel.removeRow(i);
        i += 100000;
        continue;
      } 
      i++;
    } 
    System.out.println("kurangkan stok" + (stok - k));
    if (!exists && getNama_barang() != "" ) {
      this.tableModel.addRow(new Object[] { this.barCode.getText(), 
            getNama_barang(), 
            this.decimalFormat.format(haarga), 
            Integer.valueOf(k), 
            this.decimalFormat.format(k * haarga) });
      SubTotal();
      hitung_poin();
    } else if (exists) {
      int juml = Integer.parseInt(getJumlah_barter());
      int y = 0;
      y = juml + k;
      this.tableModel.addRow(new Object[] { this.barCode.getText(), 
            getNama_barang(), 
            this.decimalFormat.format(haarga), 
            Integer.valueOf(juml + k), 
            this.decimalFormat.format(y * haarga) });
      SubTotal();
      hitung_poin();
    }   
  }
  
  private void ambil_Data2() {
    double totalnya = 0.0D;
    int k = Integer.valueOf(Integer.parseInt(getJuml())).intValue();
    int stok = getPersedian();
    System.out.println("total stok" + stok);
    //double haarga = getHarga_juals().doubleValue();
    double haarga = 2.0;
    if(k < getMindiskon1()) {
        haarga = getHarga_juals().doubleValue();
    }
    else if ( k >=getMindiskon1() && k < getMindiskon2() ) {
    	haarga = getHarga_diskon().doubleValue();
    }
    else if ( k >= getMindiskon2()) {
    	haarga = getHarga_lain().doubleValue();
    }
    System.out.println("nilai min diskon"+ getMindiskon2());
    System.out.println("cek"+ haarga);
    System.out.println("harga diskon"+  getHarga_diskon().doubleValue());

    int balanc = Integer.valueOf(Integer.parseInt(getBalance())).intValue();
    String s = "";
    boolean exists = false;
    double harg = 0.0D;
    int i = 0;
    while (i < this.table.getRowCount() && !exists) {
      s = this.tableModel.getValueAt(i, 0).toString().trim();
      harg = 
        Double.parseDouble(((String)this.table.getValueAt(i, 2))
          .replace(",", ""));
      if (this.barCode.getText().equals(s) && haarga == harg) {
        setJumlah_barter(this.tableModel.getValueAt(i, 3).toString().trim());
        exists = true;
        this.tableModel.removeRow(i);
        i += 100000;
        continue;
      } 
      i++;
    } 
    if (!exists && getNama_barang() != "") {
      this.tableModel.addRow(new Object[] { this.barCode.getText(), 
            getNama_barang(), 
            this.decimalFormat.format(haarga), 
            Integer.valueOf(k), 
            this.decimalFormat.format(k * haarga) });
      SubTotal();
      hitung_poin();
    } else if (exists) {
      int juml = Integer.parseInt(getJumlah_barter());
      int y = 0;
      y = juml + k;
      this.tableModel.addRow(new Object[] { this.barCode.getText(), 
            getNama_barang(), 
            this.decimalFormat.format(haarga), 
            Integer.valueOf(juml + k), 
            this.decimalFormat.format(y * haarga) });
      SubTotal();
      hitung_poin();
    } else if (exists) {
      JOptionPane.showMessageDialog(null, "Hai " + getUser_name() + 
          "stok saat ini Berjumlah " + stok + " total transaksi " + 
          "anda berjumlah " + (k + Integer.parseInt(getJumlah_barter())) + 
          " silahkan ulangi " + 
          "transaksi", 
          "message", -1);
      SubTotal();
      hitung_poin();
    } else {
      JOptionPane.showMessageDialog(null, "Hai " + getUser_name() + " !! stok saat ini Berjumlah " + stok + " ,total transaksi " + 
          "anda berjumlah " + k + " Yg Melebihi stok persediaan toko", "message", -1);
      SubTotal();
      hitung_poin();
    } 
  }
  
  private void hitung_poin() {
	 // getHarga_juals().doubleValue();

	double haarga = getHarga_juals().doubleValue();
    int k = Integer.valueOf(Integer.parseInt(getJuml())).intValue();
    if (getPoin_barang() != 0 ) {
        double total = haarga * k / getPoin_barang() + Double.parseDouble(this.poinDum.getText());
        setPoin_total_jual(total);
        // int total = k * getPoin_barang() + Integer.parseInt(this.poinDum.getText());
         //System.out.println("jumlah poin  =   " + getPoin_barang());
         System.out.println(total);
         this.poinDum.setText((new StringBuilder(String.valueOf(total))).toString());
    }
    else {

        double total = 0 + Double.parseDouble(this.poinDum.getText());
        setPoin_total_jual(total);
        // int total = k * getPoin_barang() + Integer.parseInt(this.poinDum.getText());
         //System.out.println("jumlah poin  =   " + getPoin_barang());
         System.out.println(total);
         this.poinDum.setText((new StringBuilder(String.valueOf(total))).toString());
    	
    }
  }
  
  private void cari() throws SQLException {
    Connection konek = Koneksi.getKoneksi();
    Statement state = konek.createStatement();
    String sql = "select nama_barang, harga_jual,harga_diskon,harga_lain,poins,balance,harga_beli,kd_barang,persediaan, id_kategori,mindiskon, mindiskon2 from Barang WHERE kd_barang = '" + 
      
      this.barCode.getText() + "'";
    ResultSet rs = state.executeQuery(sql);
    while (rs.next()) {
      setNama_barang(rs.getString(1));
      setHarga_jual(Double.valueOf(rs.getDouble(2)));
      setHarga_diskon(Double.valueOf(rs.getDouble(3)));
      setHarga_lain(Double.valueOf(rs.getDouble(4)));
      setPoin_barang(rs.getInt(5));
      setBalance(rs.getString(6));
      setHarga_beli(Double.valueOf(rs.getDouble(7)));
      setUjibarcode(rs.getString(8));
      setPersedian(rs.getInt(9));
      setId_kategori(rs.getInt(10));
      setMindiskon1(rs.getInt(11));
      setMindiskon2(rs.getInt(12));
      
    } 
    rs.close();
    state.close();
    this.barCode.setBackground(Color.GREEN);
  }
  
  private void cariPelanggan() throws SQLException {
    Connection konek = Koneksi.getKoneksi();
    Statement state = konek.createStatement();
    String sql = "select id, nama, hp, poins from pelanggan WHERE id = '" + 
      
      this.textPelanggan.getText() + "'";
    ResultSet rs = state.executeQuery(sql);
    while (rs.next()) {
      setId_pelanggan(rs.getString(1));
      setNama_pelanggan(rs.getString(2));
      setNo_hp(rs.getString(3));
      setPoint(rs.getDouble(4));
    } 
    rs.close();
    state.close();
    this.textPelanggan.setBackground(Color.GREEN);
  }
  
  private void cari2() throws SQLException {
    Connection konek = Koneksi.getKoneksi();
    Statement state = konek.createStatement();
    String sql = "select kd_barang, harga_jual,harga_diskon,harga_lain,persediaan,balance,mindiskon,mindiskon2,satuan from Barang WHERE kd_barang = '" + 
      
      this.textField.getText() + "'";
    ResultSet rs = state.executeQuery(sql);
    while (rs.next())
      setNomer(rs.getString(1)); 
    rs.close();
    state.close();
  }
  
  private void SubTotal() {
    this.barCode.setText("");
    Double totals = Double.valueOf(0.0D);
    for (int j = 0; j < this.table.getRowCount(); j++) {
      double value = 
        Double.parseDouble(((String)this.table.getValueAt(j, 4)).replace(",", ""));
      totals = Double.valueOf(totals.doubleValue() + value);
      this.labelTotal.setText(this.decimalFormat.format(totals));
    } 
    setTotal_bayar(totals);
  }
  
  private void hapusTableJual() {
    if (this.table.getSelectedRowCount() == 0) {
      JOptionPane.showMessageDialog(this, "Pilih dahulu baris yang akan dihapus");
    } else if (this.table.getRowCount() == 1) {
      clearTable();
      this.labelTotal.setText("0");
      this.barCode.requestFocus();
    } else {
      int[] rows = this.table.getSelectedRows();
      for (int i = 0; i < rows.length; i++)
        this.tableModel.removeRow(rows[i] - i); 
      SubTotal();
      this.textField.requestFocus();
    } 
  }
  
  private void findBarang() {
    try {
      ViewDialogBarang view = new ViewDialogBarang(this, true);
      if (view.getBarcode() != "") {
        this.barCode.setText(view.getBarcode());
        cari();
      } 
    } catch (Exception exception) {}
    lihat_harga();
  }
  
  public Double getTotal_bayar() {
    return this.total_bayar;
  }
  
  public void setTotal_bayar(Double total_bayar) {
    this.total_bayar = total_bayar;
  }
  
  private void kuncil() {
    try {
      viewKonfirmasi view = new viewKonfirmasi(this, true);
      view.viewKonfirmasi();
      if (view.verivikasi()) {
        this.btnWithdraw.setVisible(true);
        this.btnBarang.setVisible(true);
        this.btnReset.setVisible(true);
        this.btnHistori.setVisible(false);
        this.btnNewButton.setVisible(true);
      } else {
        this.btnWithdraw.setVisible(false);
        this.btnBarang.setVisible(false);
        this.btnReset.setVisible(false);
        this.btnHistori.setVisible(false);
        this.btnNewButton.setVisible(false);
      } 
    } catch (Exception exception) {}
  }
  
  private void autoNumber3() {
    try {
      Connection konek = Koneksi.getKoneksi();
      Statement state = konek.createStatement();
      String query = "SELECT MAX(no_transaksi) AS nomer FROM jual WHERE tanggal = CURDATE()";
      ResultSet rs = state.executeQuery(query);
      while (rs.next()) {
        if (!rs.first()) {
          setNo_jual(1);
          continue;
        } 
        rs.last();
        int noPegawai = rs.getInt(1) + 1;
        setNo_jual(noPegawai);
      } 
      rs.close();
      state.close();
    } catch (Exception exception) {}
  }
  
  private void UpdatePoinPelanggan() {
    String idPelanggan = this.textPelanggan.getText();
    if (idPelanggan != "") {
      Connection konek = Koneksi.getKoneksi();
      double i = Double.valueOf(this.poinDum.getText());
      double j = Double.valueOf(this.totalPoinPelanggan.getText());
      double poin = i + j;
      setJumlahpoindiprint(poin);
      String sql = "UPDATE pelanggan SET poin='" + poin + "'WHERE id = '" + idPelanggan + "'";
      try {
        Statement state = konek.createStatement();
        state.executeUpdate(sql);
      } catch (SQLException e1) {
        e1.printStackTrace();
      } 
      setSeluruh_poin(poin);
    } else {
      System.out.println("Member biasa");
    } 
  }
  
  private void autoNumber5() {
    try {
      Connection konek = Koneksi.getKoneksi();
      Statement state = konek.createStatement();
      String query = "select jam from total_hasil where tanggal=curdate() order by no desc limit 1;";
      ResultSet rs = state.executeQuery(query);
      while (rs.next()) {
        if (!rs.first()) {
          this.lblJam.setText("1");
          continue;
        } 
        rs.last();
        int noPegawai = rs.getInt(1);
        String no = String.valueOf(noPegawai);
        this.lblJam.setText(rs.getString(1));
      } 
      rs.close();
      state.close();
    } catch (Exception exception) {}
  }
  
  class NextPageDua  {
    private static final long serialVersionUID = 1L;
    
    private String nama_barang;
    
    String no_faktur;
    
    public String getNama_barang() {
      return this.nama_barang;
    }
    
    public void setNama_barang(String nama_barang) {
      this.nama_barang = nama_barang;
    }
    
    public NextPageDua() {
      JsonTemplate jsonTemplate1 = null, jsonTemplate = null;
      this.no_faktur = UserSession.getUserLogin();
      Locale locale = new Locale("en", "UK");
      String pattern = "###.##";
      DecimalFormat dfx = 
        (DecimalFormat)NumberFormat.getNumberInstance(locale);
      Date tgl = new Date();
      SimpleEscp simpleEscp = new SimpleEscp();
      SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
      String tanggal = DATE_FORMAT.format(tgl);
      int x = 0;
      double jumlahPoin = AdminKasir.this.getJumlahpoindiprint();
      System.out.println("Test Total Poin" + jumlahPoin);
      x = AdminKasir.this.getNo_jual() - 1;
      if (AdminKasir.this.getNama_pelanggan() == null || AdminKasir.this.getNama_pelanggan() == "") {
        jumlahPoin = 0;
      } else {
        jumlahPoin = AdminKasir.this.getJumlahpoindiprint();
      } 
      Fakturtiga fakturdua = new Fakturtiga(String.valueOf(String.valueOf(String.valueOf(this.no_faktur))) + "-" + x, tanggal, AdminKasir.this.jam_skr, 
          dfx.format(Math.round(AdminKasir.this.getTotal_bayar().doubleValue())), dfx.format(AdminKasir.this.getTunai()), 
          dfx.format(AdminKasir.this.getKembali()), jumlahPoin, AdminKasir.this.lblNamaPelanggan.getText());
      for (int i = 0; i < AdminKasir.this.table.getRowCount(); i++) {
        int jum = 0;
        jum = Integer.parseInt(AdminKasir.this.table.getValueAt(i, 3).toString());
        fakturdua.tambahItemFaktur(new ItemFakturtiga((String)AdminKasir.this.table.getValueAt(i, 1), 
              Integer.valueOf(jum), 
              (String)AdminKasir.this.table.getValueAt(i, 2), 
              (String)AdminKasir.this.table.getValueAt(i, 4)));
      } 
      DataSource dataSource = DataSources.from(fakturdua);
      AdminKasir.this.clearTable();
      AdminKasir.this.textField.setText("");
      Template template = null;
      try {
        jsonTemplate1 = new JsonTemplate(NextPageDua.class.getResourceAsStream("templateempat.json"));
      } catch (IOException e) {
        e.printStackTrace();
      } 
      try {
        jsonTemplate = new JsonTemplate(NextPageDua.class.getResourceAsStream("templatetiga.json"));
      } catch (Exception ex) {
        ex.printStackTrace();
      } 
      //simpleEscp.print((Template)jsonTemplate1, dataSource);
      AdminKasir.this.setJumlahpoindiprint(0);
      AdminKasir.this.setPoinCetak(0);
      AdminKasir.this.setPoint(0.0);
      AdminKasir.this.setPoin_total_jual(0.0);
      AdminKasir.this.setPoin_barang(0);
      //clearPelanggan();
    }
  }
  
  private void cek_uang() {
    Double total_bayars = Double.valueOf(Double.parseDouble(this.textField.getText().replace(",", "")));
    Double y = Double.valueOf(0.0D);
    try {
      cari2();
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    if (this.table.getRowCount() == 0) {
      JOptionPane.showMessageDialog(this, "Haii " + getUser_name() + "!!" + "Jangan Pusing ya" + " " + "Anda Belum Bertransaksi,silahkan barcode  cari barang ");
      this.textField.selectAll();
    } else if (total_bayars.doubleValue() < getTotal_bayar().doubleValue()) {
      JOptionPane.showMessageDialog(this, "Haii " + getUser_name() + " " + "Jangan Pusing ya" + " " + "Uang Lebih kecil dari Total, silahkan masukan lebih besar");
      viewPelanggan vl = new viewPelanggan(null);
      this.textField.selectAll();
    } else if (this.textField.getText().equals(getNomer())) {
      JOptionPane.showMessageDialog(this, "Haii " + getUser_name() + " " + "Jangan Pusing ya" + " " + "Anda Meninputkan Barcode Bukan Nominal Uang");
      this.textField.selectAll();
    } else {
      this.textField.setText(this.decimalFormat.format(total_bayars));
      if (JOptionPane.showConfirmDialog(this, "Haii " + getUser_name() + " " + "Pastikan" + " " + "Anda Meninputkan " + 
          this.decimalFormat.format(total_bayars) + " " + 
          "Nominal Uang dengan benar, tekan ENTER") == 0) {
        setTunai(total_bayars);
        y = Double.valueOf(total_bayars.doubleValue() - getTotal_bayar().doubleValue());
        setKembali(y);
        convertArray();
        if (this.textPelanggan.getText() == "")
          setPoint(0.0); 
        UpdatePoinPelanggan();
        this.controllerJ.insertJuals(this);
        this.conttrollerD.setNo_transaksi(this.controllerJ.getNo_trans());
        this.conttrollerD.insertDetailJuals(this);
        this.labelKembali.setText(this.decimalFormat.format(getKembali()));
        autoNumber3();
        this.barCode.requestFocus();
        @SuppressWarnings("unused")
		NextPageDua nextPageDua = new NextPageDua();
        //clearPelanggan();
        resetTable();
        clearPelanggan();
        this.poin_aray.clear();
      } 
    } 
  }
  
  private void tutupToko() throws SQLException {
    Connection konek = Koneksi.getKoneksi();
    Statement state = konek.createStatement();
    String sql = "select curdate(),curtime() as jam, sum(total) from jual where  tanggal=curdate() && id_kasir='wati'";
    ResultSet rs = state.executeQuery(sql);
    while (rs.next()) {
      setTanggal_tutup(rs.getString(1));
      setKalkulasi_jam(rs.getString(2));
      setTotal_penghasilan(Double.valueOf(rs.getDouble(3)));
    } 
    rs.close();
    state.close();
  }
  
  private void tutupToko2() throws SQLException {
    Connection konek = Koneksi.getKoneksi();
    Statement state = konek.createStatement();
    String sql = "select curdate(),curtime() as jam, sum(total) from jual where id_kasir='wati' && tanggal=curdate() and jam >'" + 
      
      this.lblJam.getText() + "'" + ";";
    ResultSet rs = state.executeQuery(sql);
    while (rs.next()) {
      setTanggal_tutup(rs.getString(1));
      setKalkulasi_jam(rs.getString(2));
      setTotal_penghasilan(Double.valueOf(rs.getDouble(3)));
    } 
    rs.close();
    state.close();
  }
  
  private void tutupTokoReni() throws SQLException {
    Connection konek = Koneksi.getKoneksi();
    Statement state = konek.createStatement();
    String sql = "select curdate(),curtime() as jam, sum(total) from jual where  tanggal=curdate() && id_kasir='reni'";
    ResultSet rs = state.executeQuery(sql);
    while (rs.next()) {
      setTanggal_tutup(rs.getString(1));
      setKalkulasi_jam(rs.getString(2));
      setTotal_reni(Double.valueOf(rs.getDouble(3)));
    } 
    rs.close();
    state.close();
  }
  
  private void tutupToko2Reni() throws SQLException {
    Connection konek = Koneksi.getKoneksi();
    Statement state = konek.createStatement();
    String sql = "select curdate(),curtime() as jam, sum(total) from jual where id_kasir='reni' && tanggal=curdate() and jam >'" + 
      
      this.lblJam.getText() + "'" + ";";
    ResultSet rs = state.executeQuery(sql);
    while (rs.next()) {
      setTanggal_tutup(rs.getString(1));
      setKalkulasi_jam(rs.getString(2));
      setTotal_reni(Double.valueOf(rs.getDouble(3)));
    } 
    rs.close();
    state.close();
  }
  
  private void konfirmasiTutup() throws SQLException {
    if (this.lblJam.getText().equals("")) {
      tutupToko();
      tutupTokoReni();
    } else {
      tutupToko2();
      tutupToko2Reni();
    } 
    Connection konek = Koneksi.getKoneksi();
    Statement state = konek.createStatement();
    String sql = "INSERT INTO total_hasil (tanggal, jam, total,id_kasir) VALUES (?, ?, ?, ?)";
    PreparedStatement statement = konek.prepareStatement(sql);
    statement.setString(1, getTanggal_tutup());
    statement.setString(2, getKalkulasi_jam());
    statement.setDouble(3, getTotal_penghasilan().doubleValue());
    statement.setString(4, "wati");
    int rowsInserted = statement.executeUpdate();
    if (rowsInserted > 0)
      System.out.println("A new user was inserted successfully!"); 
    tutup_toko_reni();
  }
  
  private void tutup_toko_reni() throws SQLException {
    Connection konek = Koneksi.getKoneksi();
    Statement state = konek.createStatement();
    String sql = "INSERT INTO total_hasil (tanggal, jam, total,id_kasir) VALUES (?, ?, ?, ?)";
    PreparedStatement statement = konek.prepareStatement(sql);
    statement.setString(1, getTanggal_tutup());
    statement.setString(2, getKalkulasi_jam());
    statement.setDouble(3, getTotal_reni().doubleValue());
    statement.setString(4, "reni");
    int rowsInserted = statement.executeUpdate();
    if (rowsInserted > 0)
      System.out.println("A new user was inserted successfully!"); 
    keluar();
  }
  
  private void findPelanggan() {
    try {
      viewPelanggan view = new viewPelanggan(this, true);
      if (view.getBarcode() != "") {
        this.textPelanggan.setText(view.getBarcode());
        this.lblNamaPelanggan.setText(view.getNama_barang());
        this.totalPoinPelanggan.setText(Double.toString(view.getPoin()));
        setId_pelanggan(view.getBarcode());
        setNama_pelanggan(view.getNama_barang());
        setPoint(view.getPoin());
        cariPelanggan();
      } 
    } catch (Exception exception) {}
  }
  
  private void clearPelanggan() {
    this.textPelanggan.setText("");
    this.lblNamaPelanggan.setText("");
    setSeluruh_poin(0);
    setNama_pelanggan("");
    setPoint(0.0);
    this.totalPoinPelanggan.setText("0");
  }
  
  private void pesandua() {
    JOptionPane.showMessageDialog(this, "Haii " + getUser_name() + " " + "Anda Belum Memasukan Nominal uang, Silahkan ketik nominal");
  }
  
  private void tampilkanPegawai() {
    viewPegawai views = new viewPegawai();
    views.setVisible(true);
  }
  
  private void tampilStok() {
    cekStok view = new cekStok();
    view.setVisible(true);
  }
  
  private void tampilPelanggan() {
    viewDataPelanggan view = new viewDataPelanggan();
    view.setVisible(true);
  }
  
  private void keluar() {
    JOptionPane.showMessageDialog(this, "Terima kasih " + getUser_name() + " " + "Selamat istirahat" + "toko dan Program akan di tutup dan ganti sift");
    dispose();
  }
}
