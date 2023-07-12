package view;
import com.silver.data.Fakturx;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import com.silver.controller.ControllerJual;
import com.silver.controller.controllerDetailJual;
import com.silver.data.Harga;
import com.silver.data.ItemFakturx;
import com.silver.data.UserSession;
import com.silver.model.ModelDetailJual;
import com.silver.model.ModelJual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.LayoutManager;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import simple.escp.SimpleEscp;
import simple.escp.Template;
import simple.escp.data.DataSource;
import simple.escp.data.DataSources;
import simple.escp.json.JsonTemplate;
import simple.escp.swing.PrintPreviewPane;
import view.dialog.ViewDialogBarang;
import view.dialog.Withdraw;
import view.dialog.cekStok;
import view.dialog.viewBarang;
import view.dialog.viewDataPelanggan;
import view.dialog.viewHarga;
import view.dialog.viewKonfirmasi;
import view.dialog.viewPegawai;
import view.dialog.viewPelanggan;
import view.dialog.viewBayar;


public class AdminKasir extends JFrame {
  private String nomer;
  
  private JButton btnHistori;
  
  private JButton btnPelanggan;
  
  int poinCetak;
  private Double poinTotal;
  private Double tunai;
  
  public static JLabel poinDum;
  
  public Double poin_total_jual;
  
  private Double kembali;
  
  private ControllerJual controllerJ;
  
  private controllerDetailJual conttrollerD;
  
  private ModelJual model;
  
  private int mindiskon1;
  String patternx = "###,###.###";
  DecimalFormat decimalFormatx = new DecimalFormat(patternx);
  
  
  public Double getPoin_total_jual() {
    return this.poin_total_jual;
  }
  
  public void setPoin_total_jual(Double poin_total_jual) {
    this.poin_total_jual = poin_total_jual;
  }
  
  public int getMindiskon1() {
    return this.mindiskon1;
  }
  
  public void setMindiskon1(int mindiskon1) {
    this.mindiskon1 = mindiskon1;
  }
  
  public int getMindiskon2() {
    return this.mindiskon2;
  }
  
  public void setMindiskon2(int mindiskon2) {
    this.mindiskon2 = mindiskon2;
  }
  
  private static Double dapatPoin = Double.valueOf(0.0D);
  
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
  
  public static Double getDapatPoin() {
    return dapatPoin;
  }
  
  public static void setDapatPoin(Double newAbc) {
    dapatPoin = newAbc;
  }
  
  public int getPoinCetak() {
    return this.poinCetak;
  }
  
  public void setPoinCetak(int poinCetak) {
    this.poinCetak = poinCetak;
  }
  
  public Double getSeluruh_poin() {
    return Double.valueOf(this.seluruh_poin);
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
  
  private Double uang;
  
  public Double getPoint() {
    return this.point;
  }
  
  public Double getUang() {
    return this.uang;
  }
  
  public void setUang(Double uang) {
    this.uang = uang;
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
    return Double.valueOf(this.jumlahpoindiprint);
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
    return table;
  }
  
  public void setTable(JTable table) {
    AdminKasir.table = table;
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
  
  private Double harga_jual1;
  
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
  private JButton btnNewButton_1;
  
  private int Persedian;
  
  private Double harga_beli;
  
  private String ujibarcode;
  
  private Double harga_jual_tab;
  
  private JButton btnBarang;
  
  private String balance;
  
  private JPanel contentPane;
  
  private JTextField barCode;
  
  private JTextField textPelanggan;
  
  public static JTable table;
  
  private Double total_bayar;
  
  private static JLabel labelTotal;
  
  private JButton btnWithdraw;
  
  private JLabel lblNamaPelanggan;
  
  public Double getHarga_jual1() {
    return this.harga_jual1;
  }
  
  public static void setHarga_jual1(Double harga_jual1) {
    harga_jual1 = harga_jual1;
  }
  
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
            String time = String.valueOf(String.valueOf(String.valueOf(String.valueOf(jam)))) + ":" + menit + ":" + detik + " " + siang_malam;
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
  
  public static DefaultTableModel tableModel = new DefaultTableModel(
      new Object[0][], (Object[])new String[] { "Barcode", "Poin", 
        "Nama barang", "Jumlah", "Harga Juals", "Total" }) {
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
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds(100, 100, (int)dim.getWidth(), (int)dim.getHeight());
    setLocationRelativeTo(null);
    this.usersesion = new UserSession();
    this.conttrollerD = new controllerDetailJual();
    this.controllerJ = new ControllerJual();
    this.model2 = new ModelDetailJual();
    this.model = new ModelJual();
    this.controllerJ.setModel(this.model);
    this.conttrollerD.setModel(this.model2);
    this.contentPane = new JPanel();
    this.contentPane.setBackground(new Color(64, 224, 208));
    this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    getScreen();
    setContentPane(this.contentPane);
    this.contentPane.setLayout((LayoutManager)null);
    this.textField_1 = new JTextField();
    textField_1.setBounds(0, 0, 0, 0);
    contentPane.setLayout(null);
    contentPane.setLayout(null);
    contentPane.setLayout(null);
    contentPane.setLayout(null);
    contentPane.setLayout(null);
    contentPane.setLayout(null);
    contentPane.setLayout(null);
    contentPane.setLayout(null);
    contentPane.setLayout(null);
    contentPane.setLayout(null);
    contentPane.setLayout(null);
    contentPane.setLayout(null);
    contentPane.setLayout(null);
    contentPane.setLayout(null);
    contentPane.setLayout(null);
    contentPane.setLayout(null);
    contentPane.setLayout(null);
    this.contentPane.add(this.textField_1);
    this.textField_1.setColumns(10);
  
  
    this.barCode = new JTextField();
    barCode.setBounds(85, 62, 168, 34);
    this.barCode.requestFocus();
    this.barCode.setBackground(new Color(0, 255, 0));
    this.barCode.requestFocus();
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
                //AdminKasir.this.textField.requestFocus();
                //AdminKasir.this.textField.selectAll();
                //AdminKasir.this.textField.setBackground(Color.GREEN);
                AdminKasir.this.barCode.setBackground(Color.WHITE);
                lihatBayar();
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
                        AdminKasir.this.getHarga_beli(), AdminKasir.this.getBalance(), true, AdminKasir.this.getMindiskon1(), AdminKasir.this.getMindiskon2(), AdminKasir.this.barCode.getText());
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
                AdminKasir.this.findPelanggan();
                break;
            } 
          }
        });
    this.contentPane.add(this.barCode);
    this.barCode.setColumns(10);
    this.btnReset = new JButton("Reset");
    btnReset.setBounds(127, 35, 109, 20);
    this.btnReset.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            AdminKasir.this.resetTable();
          }
        });
    this.btnReset.setIcon(new ImageIcon(AdminKasir.class.getResource("/com/silver/peratan/image/clear.png")));
    this.contentPane.add(this.btnReset);
    this.btnReset.setVisible(false);
    JLabel lblBarcode = new JLabel("BARCODE");
    lblBarcode.setBounds(6, 72, 70, 15);
    lblBarcode.setForeground(new Color(255, 255, 255));
    lblBarcode.setFont(new Font("Dialog", 1, 12));
    this.contentPane.add(lblBarcode);
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(12, 100, 1408, 670);
    this.contentPane.add(scrollPane);
    table = new JTable();
    table.setForeground(Color.BLACK);
    table.setFillsViewportHeight(true);
    table.setBackground(Color.WHITE);
    table.setFont(new Font("Dialog", 1, 22));
    table.setModel(tableModel);
    TableColumnModel colmod = table.getColumnModel();
    TableColumn TC_ProdName = colmod.getColumn(0);
    TableColumn TC_Poin = colmod.getColumn(1);
    TableColumn TC_nama = colmod.getColumn(2);
    TableColumn TC_qty = colmod.getColumn(4);
    TC_ProdName.setPreferredWidth(2);
    TC_Poin.setPreferredWidth(2);
    TC_nama.setPreferredWidth(2);
    TC_nama.setPreferredWidth(500);
    table.setRowHeight(38);
    table.addComponentListener(new ComponentAdapter() {
          public void componentResized(ComponentEvent e) {
            AdminKasir.table.scrollRectToVisible(AdminKasir.table.getCellRect(AdminKasir.table.getRowCount() - 1, 0, true));
          }
        });
    scrollPane.setViewportView(table);
    scrollPane.setBackground(new Color(255, 140, 0));
    scrollPane.setOpaque(true);
    this.btnWithdraw = new JButton("Hari ini");
    btnWithdraw.setBounds(516, 2, 140, 20);
    this.btnWithdraw.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            AdminKasir.this.ligatWithdraw();
          }
        });
    this.btnWithdraw.setIcon(new ImageIcon(AdminKasir.class.getResource("/com/silver/peratan/image/wire-transfer-icon.png")));
    this.contentPane.add(this.btnWithdraw);
    this.btnBarang = new JButton("Barang");
    btnBarang.setBounds(387, 2, 117, 20);
    this.btnBarang.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            AdminKasir.this.tampilBarang();
          }
        });
    this.btnBarang.setIcon(new ImageIcon(AdminKasir.class.getResource("/com/silver/peratan/image/sup.png")));
    this.contentPane.add(this.btnBarang);
    JButton btnHapus = new JButton("");
    btnHapus.setBounds(280, 42, 20, 18);
    btnHapus.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            AdminKasir.this.hapusTableJual();
          }
        });
    btnHapus.setIcon(new ImageIcon(AdminKasir.class.getResource("/com/silver/peratan/image/Actions-edit-clear-icon.png")));
    this.contentPane.add(btnHapus);
    JButton btnActive = new JButton("Active");
    btnActive.setBounds(22, 35, 109, 20);
    btnActive.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            AdminKasir.this.kuncil();
          }
        });
    btnActive.setIcon(new ImageIcon(AdminKasir.class.getResource("/com/silver/peratan/image/check.png")));
    this.contentPane.add(btnActive);
    setUser_name(UserSession.getUserLogin());
    JPanel panel3 = new JPanel();
    panel3.setBounds(1200, 6, 230, 34);panel3.setBackground(new Color(199, 21, 133));
   
    this.contentPane.add(panel3);
   
    panel3.setLayout((LayoutManager)null);
 
    this.lblNamaPelanggan = new JLabel("");
    lblNamaPelanggan.setForeground(Color.WHITE);
    this.lblNamaPelanggan.setFont(new Font("Dialog", Font.BOLD, 20));
    this.lblNamaPelanggan.setBounds(12, 5, 200, 30);
  
    panel3.add(this.lblNamaPelanggan);
    this.labelKembali = new JLabel("");
    this.labelKembali.setFont(new Font("Dialog", 1, 27));
    this.labelKembali.setBounds(114, 12, 207, 53);
   
    JPanel panel_1 = new JPanel();
    panel_1.setBounds(971, 2, 228, 94);
    panel_1.setBackground(new Color(218, 112, 214));
    panel_1.setLayout((LayoutManager)null);
    this.contentPane.add(panel_1);
    panel_1.setLayout(null);
    JLabel lblTotal = new JLabel("Total");
    lblTotal.setForeground(new Color(255, 255, 255));
    lblTotal.setFont(new Font("Dialog", 1, 12));
    lblTotal.setBounds(12, 2, 48, 20);
    panel_1.add(lblTotal);
    this.labelTotal = new JLabel("");
    this.labelTotal.setFont(new Font("Dialog", Font.ITALIC, 40));
    this.labelTotal.setBounds(12, 34, 208, 54);
    panel_1.add(this.labelTotal);
    this.lblNewLabel = new JLabel("");
    lblNewLabel.setBounds(690, 10, 168, 30);
    this.lblNewLabel.setForeground(new Color(0, 128, 0));
    this.lblNewLabel.setFont(new Font("Dialog", 1, 14));
    this.contentPane.add(this.lblNewLabel);
    this.textPelanggan = new JTextField();
    textPelanggan.setBounds(1393, 67, 10, 20);
    this.textPelanggan.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
              case 38:
                //AdminKasir.this.textField.requestFocus();
                //AdminKasir.this.textField.setBackground(Color.GREEN);
                //AdminKasir.this.textPelanggan.setBackground(Color.WHITE);
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
    this.textPelanggan.setForeground(Color.BLACK);
    this.textPelanggan.setFont(new Font("Dialog", 1, 17));
    this.contentPane.add(this.textPelanggan);
    this.textPelanggan.setColumns(10);
    JPanel panel_4 = new JPanel();
    panel_4.setBounds(1200, 46, 129, 50);
    panel_4.setBackground(new Color(255, 165, 0));
    panel_4.setLayout((LayoutManager)null);
    this.contentPane.add(panel_4);
    JLabel lblpoinsaat = new JLabel("Poin Saat Ini");
    lblpoinsaat.setForeground(new Color(255, 255, 255));
    lblpoinsaat.setFont(new Font("Dialog", 1, 10));
    lblpoinsaat.setBounds(12, 2, 80, 25);
    this.totalPoinPelanggan = new JLabel("0");
    this.totalPoinPelanggan.setForeground(new Color(255, 255, 255));
    poinDum = new JLabel("0");
    poinDum.setForeground(new Color(255, 255, 255));
    poinDum.setFont(new Font("Dialog", 1, 15));
    this.totalPoinPelanggan.setFont(new Font("Dialog", 1, 15));
    this.totalPoinPelanggan.setBounds(22, 19, 30, 25);
    poinDum.setBounds(83, 19, 50, 25);
    panel_4.setLayout(null);
    panel_4.add(this.totalPoinPelanggan);
    panel_4.add(poinDum);
    panel_4.add(lblpoinsaat);
    this.lblJam = new JLabel("");
    lblJam.setBounds(925, 12, 143, 25);
    this.lblJam.setFont(new Font("Dialog", 1, 20));
    this.contentPane.add(this.lblJam);
    this.btnNewButton = new JButton("Pegawai");
    btnNewButton.setBounds(270, 2, 117, 20);
    this.btnNewButton.setIcon(new ImageIcon(AdminKasir.class.getResource("/com/silver/peratan/image/login.png")));
    this.btnNewButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            AdminKasir.this.tampilkanPegawai();
          }
        });
    //this.btnNewButton.setVisible(true);
    this.btnNewButton.setFont(new Font("Dialog", 1, 10));
    this.contentPane.add(this.btnNewButton);
    this.btnPelanggan = new JButton("Pelanggan");
    btnPelanggan.setBounds(141, 2, 117, 20);
    this.btnPelanggan.setIcon(new ImageIcon(AdminKasir.class.getResource("/com/silver/peratan/image/login.png")));
    this.btnPelanggan.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            AdminKasir.this.tampilPelanggan();
          }
        });
    this.btnPelanggan.setFont(new Font("Dialog", 1, 10));
    this.contentPane.add(this.btnPelanggan);
    btnNewButton_1 = new JButton("Cetak Ulang");
    btnNewButton_1.setBounds(12, 2, 117, 20);
    btnNewButton_1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {}
        });
    btnNewButton_1.setIcon(new ImageIcon(AdminKasir.class.getResource("/com/silver/peratan/image/buku.png")));
    this.contentPane.add(btnNewButton_1);
    this.btnBarang.setVisible(false);//
    this.btnWithdraw.setVisible(false);
    this.btnNewButton_1.setVisible(false);
    this.btnPelanggan.setVisible(false);
    this.btnNewButton.setVisible(false);
    autoNumber3();
    autoNumber5();
    jam_digital();
  }
  
  private void lihat_harga() {
    viewHarga viewharga = new viewHarga(null, 
        getPersedian(), getPoin_barang(), getNama_barang(), 
        getHarga_jual(), 
        getHarga_diskon(), getHarga_lain(), 
        getHarga_beli(), getBalance(), true, getMindiskon1(), getMindiskon2(), this.barCode.getText());
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
    tableModel.setRowCount(0);
  }
  
  private void resetTable() {
    this.barCode.setText("");
    clearTable();
    tableModel.setRowCount(0);
    labelTotal.setText("0");
    this.barCode.requestFocus();
    poinDum.setText("0");
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
    System.out.println("mengambil data ===" + getHarga_jual1());
  }
  
  public void ambil_coba() {
    System.out.println("ambil ata test");
    tableModel.addRow(new Object[] { "8734638743", 
          "Coba test", 
          Integer.valueOf(5600), 
          Integer.valueOf(5), 
          Integer.valueOf(5000) });
  }
  
  private void checkTable() {
    String s = "";
    boolean exists = false;
    double harg = 0.0D;
    int i = 0;
    while (i < table.getRowCount() && !exists) {
      s = tableModel.getValueAt(i, 0).toString().trim();
      harg = 
        Double.parseDouble(((String)table.getValueAt(i, 2)).replace(",", ""));
      if (this.barCode.getText().equals(s)) {
        System.out.println("barcode__ " + this.barCode.getText());
        setJumlah_barter(tableModel.getValueAt(i, 3).toString().trim());
        exists = true;
        tableModel.removeRow(i);
        i += 100000;
        continue;
      } 
      i++;
    } 
  }
  
  public static void AddRowToJTable(Object[] dataRow, String barcodeid, String poin, Double totalBayar) {
    tableModel.addRow(dataRow);
    hitungTotal(poin, totalBayar);
  }
  
  public static Double test_poin = Double.valueOf(0.0D);
  
  public static void hitungTotal(String poin, Double totalBayar) {
    String pattern = "###,###.###";
    DecimalFormat decimalFormat = new DecimalFormat(pattern);
    Double Subtotal = Double.valueOf(0.0D);
    Double SubtotalPoin = Double.valueOf(0.0D);
    for (int j = 0; j < table.getRowCount(); j++) {
      String totalString = tableModel.getValueAt(j, 5).toString().trim();
      String strNew22 = totalString.replaceFirst(",", "");
      Subtotal = Double.valueOf(Double.parseDouble(strNew22) + Subtotal.doubleValue());
      System.out.println(Subtotal);
      String totalPoin = tableModel.getValueAt(j, 1).toString().trim();
      SubtotalPoin = Double.valueOf(Double.parseDouble(totalPoin) + SubtotalPoin.doubleValue());
      labelTotal.setText(decimalFormat.format(Subtotal));
      poinDum.setText(decimalFormat.format(SubtotalPoin));
    } 
  }
  
  private void ambil_Data2() {}
  
  private void hitung_poin() {
    double haarga = getHarga_juals().doubleValue();
    int k = Integer.valueOf(Integer.parseInt(getJuml())).intValue();
    if (getPoin_barang() != 0) {
      double total = haarga * k / getPoin_barang() + Double.parseDouble(poinDum.getText());
      setPoin_total_jual(Double.valueOf(total));
      System.out.println(total);
      poinDum.setText((new StringBuilder(String.valueOf(total))).toString());
    } else {
      double total = 0.0D + Double.parseDouble(poinDum.getText());
      setPoin_total_jual(Double.valueOf(total));
      System.out.println(total);
      poinDum.setText((new StringBuilder(String.valueOf(total))).toString());
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
    String sql = "select id, nama, hp, poins, uang from pelanggan WHERE id = '" + 
      
      this.textPelanggan.getText() + "'";
    ResultSet rs = state.executeQuery(sql);
    while (rs.next()) {
      setId_pelanggan(rs.getString(1));
      setNama_pelanggan(rs.getString(2));
      setNo_hp(rs.getString(3));
      setPoint(Double.valueOf(rs.getDouble(4)));
      setUang(Double.valueOf(rs.getDouble(5)));
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
    for (int j = 0; j < table.getRowCount(); j++) {
      double value = 
        Double.parseDouble(((String)table.getValueAt(j, 4)).replace(",", ""));
      totals = Double.valueOf(totals.doubleValue() + value);
      labelTotal.setText(this.decimalFormat.format(totals));
    } 
    setTotal_bayar(totals);
  }
  
  private void hapusTableJual() {
    if (table.getSelectedRowCount() == 0) {
      JOptionPane.showMessageDialog(this, "Pilih dahulu baris yang akan dihapus");
    } else if (table.getRowCount() == 1) {
      clearTable();
      labelTotal.setText("0");
      this.barCode.requestFocus();
    } else {
      int[] rows = table.getSelectedRows();
      for (int i = 0; i < rows.length; i++)
        tableModel.removeRow(rows[i] - i); 
      hitungTotal("1", Double.valueOf(1000.0D));
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
        this.btnPelanggan.setVisible(true);
        this.btnNewButton_1.setVisible(true);
    	this.btnNewButton.setVisible(true);

        //this.btnNewButton.setVisible(true);
        this.btnHistori.setVisible(true);
        this.btnNewButton.setVisible(true);
        
      } else {
    	this.btnNewButton.setVisible(false);
        this.btnPelanggan.setVisible(false);
        this.btnNewButton_1.setVisible(false);
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
      double i = Double.valueOf(poinDum.getText()).doubleValue();
      double j = Double.valueOf(this.totalPoinPelanggan.getText()).doubleValue();
      double poin = i + j;
      double totalUang = getTotal_bayar().doubleValue() + getUang().doubleValue();
      System.out.print("total uang" + totalUang);
      System.out.println("toatl uang" + getUang());
      setJumlahpoindiprint(poin);
      String sql = "UPDATE pelanggan SET uang = uang + " + totalUang + "," + "poin='" + poin + "'WHERE id = '" + idPelanggan + "'";
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
  
  class NextPageDua {
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
      double jumlahPoin = AdminKasir.this.getJumlahpoindiprint().doubleValue();
      System.out.println("Test Total Poin" + jumlahPoin);
      x = AdminKasir.this.getNo_jual() - 1;
      if (AdminKasir.this.getNama_pelanggan() == null || AdminKasir.this.getNama_pelanggan() == "") {
        jumlahPoin = 0.0D;
      } else {
        jumlahPoin = AdminKasir.this.getJumlahpoindiprint().doubleValue();
      } 
      Fakturtiga fakturdua = new Fakturtiga(String.valueOf(String.valueOf(String.valueOf(String.valueOf(this.no_faktur)))) + "-" + x, tanggal, AdminKasir.this.jam_skr, 
          dfx.format(Math.round(AdminKasir.this.getTotal_bayar().doubleValue())), dfx.format(AdminKasir.this.getTunai()), 
          dfx.format(AdminKasir.this.getKembali()), jumlahPoin, AdminKasir.this.lblNamaPelanggan.getText());
      for (int i = 0; i < AdminKasir.table.getRowCount(); i++) {
        int jum = 0;
        jum = Integer.parseInt(AdminKasir.table.getValueAt(i, 4).toString());
        fakturdua.tambahItemFaktur(new ItemFakturtiga((String)AdminKasir.table.getValueAt(i, 1), 
              Integer.valueOf(jum), 
              (String)AdminKasir.table.getValueAt(i, 2), 
              (String)AdminKasir.table.getValueAt(i, 5)));
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
      simpleEscp.print((Template)jsonTemplate1, dataSource);
      AdminKasir.this.setJumlahpoindiprint(0.0D);
      AdminKasir.this.setPoinCetak(0);
      AdminKasir.this.setPoint(Double.valueOf(0.0D));
      AdminKasir.this.setUang(Double.valueOf(0.0D));
      AdminKasir.this.setPoin_total_jual(Double.valueOf(0.0D));
      AdminKasir.this.setPoin_barang(0);
    }
  }
  
  private void cek_uang() {
    String strNew22 = labelTotal.getText().replaceFirst(",", "");
    setTotal_bayar(Double.valueOf(Double.parseDouble(strNew22)));
    Double total_bayars = Double.valueOf(Double.parseDouble(this.textField.getText().replace(",", "")));
    Double y = Double.valueOf(0.0D);
    try {
      cari2();
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    if (table.getRowCount() == 0) {
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
          setPoint(Double.valueOf(0.0D)); 
        setUang(Double.valueOf(0.0D));
        UpdatePoinPelanggan();
        this.controllerJ.insertJuals(this);
        this.conttrollerD.setNo_transaksi(this.controllerJ.getNo_trans());
        this.conttrollerD.insertDetailJuals(this);
        this.labelKembali.setText(this.decimalFormat.format(getKembali()));
        autoNumber3();
        this.barCode.requestFocus();
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
        this.totalPoinPelanggan.setText(Double.toString(view.getPoin().doubleValue()));
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
    setSeluruh_poin(0.0D);
    setNama_pelanggan("");
    setPoint(Double.valueOf(0.0D));
    setUang(Double.valueOf(0.0D));
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
  public  void insertPenjualan(Double bayar, Double total_bayar, Double kembali, Double Poin) {
	  //System.out.println("di insert penjualan");


	   setTunai(total_bayar);
     // y = Double.valueOf(total_bayars.doubleValue() - getTotal_bayar().doubleValue());
      setKembali(kembali);
      setPoinTotal(Poin);
      setUang(bayar);
      //UpdatePoinPelanggan();
      this.controllerJ.insertJuals(this);
      this.conttrollerD.setNo_transaksi(this.controllerJ.getNo_trans());
      this.conttrollerD.insertDetailJuals(this);
      //CetakPrint view = new CetakPrint();
      //decimalFormatx
    //  String.valueOf(decimalFormatx.format(bayar));
      cetakDotMatrix(String.valueOf(decimalFormatx.format(bayar)),String.valueOf(decimalFormatx.format(total_bayar)),String.valueOf(decimalFormatx.format(kembali)));
      //view.setVisible(true);
      //this.labelKembali.setText(this.decimalFormat.format(getKembali()));
      autoNumber3();
      this.barCode.requestFocus();
      resetTable();
      clearPelanggan();
    //  this.poin_aray.clear();
      
  }
  private void lihatBayar() {
	  viewBayar bayar = new viewBayar( labelTotal.getText(), poinDum.getText());
	  
  }

public Double getPoinTotal() {
	return poinTotal;
}

public void setPoinTotal(Double poinTotal) {
	this.poinTotal = poinTotal;
}

private void cetakDotMatrix(String bayar, String total, String kembali) {
	  int x =0;
      x = AdminKasir.this.getNo_jual() - 1; //CetakCoba
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
      LocalDate localDate = LocalDate.now();
      System.out.println(dtf.format(localDate)); //
        Fakturx faktur = new Fakturx(getUser_name()+"#"+x,"*", 
        		total, kembali, AdminKasir.this.jam_skr, bayar,dtf.format(localDate));
        //getUser_name()
        String nama_barang = (String) AdminKasir.table.getValueAt(0, 2);
        for (int i = 0; i < AdminKasir.table.getRowCount(); i++) {
        	
        	
	        faktur.tambahItemFakturx(new ItemFakturx((String) AdminKasir.table.getValueAt(i, 2),
	        		(String)AdminKasir.table.getValueAt(i, 3), 
	        		(String)AdminKasir.table.getValueAt(i, 4),  
	        		(String)AdminKasir.table.getValueAt(i, 5)));
	        
          } 
         
       
        
        Template template  = null;
        try {
          //   jsonTemplate = new JsonTemplate(Main.class.getResourceAsStream("templatedua.json"));

            template = new JsonTemplate(CetakCoba.class.getResourceAsStream("faktur.json"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("dotmatrix di cetak");

}
class CetakCoba extends JFrame {

	  private JPanel contentPane;

	  /**
	   * Launch the application.
	   */
	 /* public void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	      public void run() {
	        try {
	          CetakCoba frame = new CetakCoba();
	          frame.setVisible(true);
	        } catch (Exception e) {
	          e.printStackTrace();
	        }
	      }
	    });
	  }
	  */

	  /**
	   * Create the frame.
	   */
	  public CetakCoba(String bayar, String total, String kembali) {
	    super("Latihan");
	     // this.no_faktur = UserSession.getUserLogin();
	      int x =0;
	      x = AdminKasir.this.getNo_jual() - 1; //CetakCoba
	      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	      LocalDate localDate = LocalDate.now();
	      System.out.println(dtf.format(localDate)); //
	        Fakturx faktur = new Fakturx(getUser_name()+"#"+x,"*", 
	        		total, kembali, AdminKasir.this.jam_skr, bayar,dtf.format(localDate));
	        //getUser_name()
	        String nama_barang = (String) AdminKasir.table.getValueAt(0, 2);
	        for (int i = 0; i < AdminKasir.table.getRowCount(); i++) {
	        	
	        	
		        faktur.tambahItemFakturx(new ItemFakturx((String) AdminKasir.table.getValueAt(i, 2),
		        		(String)AdminKasir.table.getValueAt(i, 3), 
		        		(String)AdminKasir.table.getValueAt(i, 4),  
		        		(String)AdminKasir.table.getValueAt(i, 5)));
		        
	          } 
	         
	       
	        
	        Template template  = null;
	        try {
	          //   jsonTemplate = new JsonTemplate(Main.class.getResourceAsStream("templatedua.json"));

	            template = new JsonTemplate(CetakCoba.class.getResourceAsStream("faktur.json"));
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        PrintPreviewPane preview = new PrintPreviewPane(template, null, faktur);
	        setLayout(new BorderLayout());
	        add(preview, BorderLayout.CENTER);
	 
	        pack();
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setVisible(true);
	  }

	}

class CetakPrint extends JFrame {
    private static final long serialVersionUID = 1L;
    
    private String nama_barang;
    
    String no_faktur;
    
    public String getNama_barang() {
      return this.nama_barang;
    }
    
    public void setNama_barang(String nama_barang) {
      this.nama_barang = nama_barang;
    }
    
    public CetakPrint() {
      JsonTemplate jsonTemplate1 = null, jsonTemplate = null;
      this.no_faktur = "23244";
      Locale locale = new Locale("en", "UK");
      String pattern = "###.##";
      DecimalFormat dfx = 
        (DecimalFormat)NumberFormat.getNumberInstance(locale);
      Date tgl = new Date();
      SimpleEscp simpleEscp = new SimpleEscp();
      SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
      String tanggal = DATE_FORMAT.format(tgl);
      int x = 0;
      double jumlahPoin = 2.2;
      //double jumlahPoin = AdminKasir.this.getJumlahpoindiprint().doubleValue();
      System.out.println("Test Total Poin" + jumlahPoin);
      x = AdminKasir.this.getNo_jual() - 1;
      if (AdminKasir.this.getNama_pelanggan() == null || AdminKasir.this.getNama_pelanggan() == "") {
        jumlahPoin = 0.0D;
      } else {
        jumlahPoin = 2.2;
      } 
      Fakturtiga fakturdua = new Fakturtiga(String.valueOf(String.valueOf(String.valueOf(String.valueOf(this.no_faktur)))) + "-" + x, tanggal, AdminKasir.this.jam_skr, 
          //dfx.format(Math.round(AdminKasir.this.getTotal_bayar().doubleValue())), dfx.format(AdminKasir.this.getTunai()), 
    		  dfx.format(Math.round(AdminKasir.this.getUang().doubleValue())), dfx.format(AdminKasir.this.getTunai()), 
    		  dfx.format(AdminKasir.this.getKembali()), jumlahPoin, AdminKasir.this.lblNamaPelanggan.getText());
      for (int i = 0; i < AdminKasir.table.getRowCount(); i++) {
        int jum = 0;
        jum = Integer.parseInt(AdminKasir.table.getValueAt(i, 3).toString());
        fakturdua.tambahItemFaktur(new ItemFakturtiga((String)AdminKasir.table.getValueAt(i, 2), 
              Integer.valueOf(jum), 
              (String)AdminKasir.table.getValueAt(i, 2), 
              (String)AdminKasir.table.getValueAt(i, 5)));
      } 
      DataSource dataSource = DataSources.from(fakturdua);
      AdminKasir.this.clearTable();
     // AdminKasir.this.textField.setText("");
      //listItemFakturDua
      Template template = null;
      /*
      try {
    	  template = new JsonTemplate(CetakPrint.class.getResourceAsStream("templateempat.json"));
      } catch (IOException e) {
        e.printStackTrace();
      } 
      */
      try {
    	  template = new JsonTemplate(CetakPrint.class.getResourceAsStream("templateempat.json"));
      } catch (Exception ex) {
        ex.printStackTrace();
      } 
      PrintPreviewPane preview = new PrintPreviewPane(template, null, fakturdua);

     // simpleEscp.print((Template)jsonTemplate1, dataSource);
      AdminKasir.this.setJumlahpoindiprint(0.0D);
      AdminKasir.this.setPoinCetak(0);
      AdminKasir.this.setPoint(Double.valueOf(0.0D));
      AdminKasir.this.setUang(Double.valueOf(0.0D));
      AdminKasir.this.setPoin_total_jual(Double.valueOf(0.0D));
      AdminKasir.this.setPoin_barang(0);
    }
  }


}
