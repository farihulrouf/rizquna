package view.dialog;


import com.silver.con2.MappingCetak;
import com.silver.con2.MappingJual;
import com.silver.dao.DaoCetakUlang;
import com.silver.dao.DaoJual;
import com.silver.dao.ErrorInfo;
import com.silver.data.Jual;
import com.silver.model.table.TableModelDetailJual;
import com.silver.model.table.TableModelJual;
import com.toedter.calendar.JDateChooser;
import view.Fakturtiga;
import view.ItemFakturtiga;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import simple.escp.SimpleEscp;
import simple.escp.Template;
import simple.escp.data.DataSource;
import simple.escp.data.DataSources;
import simple.escp.json.JsonTemplate;

public class viewCetakUlang extends JDialog {
  private final JPanel contentPanel = new JPanel();
  
  private JTextField textField;
  
  private JTable table;
  
  private TableModelDetailJual tableModelDetailJual;
  
  private JDateChooser dateChooser;
  
  Locale locale = new Locale("en", "UK");
  
  private String nama_user;
  
  private Date tanggalC;
  
  private String jam_cetak;
  
  private String nama_pelanggan;
  
  private Double poin;
  
  private Double penghasilan;
  
  public String getNama_pelanggan() {
    return this.nama_pelanggan;
  }
  
  public void setNama_pelanggan(String nama_pelanggan) {
    this.nama_pelanggan = nama_pelanggan;
  }
  
  public Double getPoin() {
    return this.poin;
  }
  
  public void setPoin(Double poin) {
    this.poin = poin;
  }
  
  public String getJam_cetak() {
    return this.jam_cetak;
  }
  
  public void setJam_cetak(String jam_cetak) {
    this.jam_cetak = jam_cetak;
  }
  
  public Double getPenghasilan() {
    return this.penghasilan;
  }
  
  public void setPenghasilan(Double penghasilan) {
    this.penghasilan = penghasilan;
  }
  
  public Date getTanggalC() {
    return this.tanggalC;
  }
  
  public void setTanggalC(Date tanggalC) {
    this.tanggalC = tanggalC;
  }
  
  public String getNama_user() {
    return this.nama_user;
  }
  
  public void setNama_user(String nama_user) {
    this.nama_user = nama_user;
  }
  
  DecimalFormat df = (DecimalFormat)NumberFormat.getNumberInstance(this.locale);
  
  SimpleDateFormat dataFormatTanggal = new SimpleDateFormat("yyy-MM-dd");
  
  DefaultTableModel tableModel = new DefaultTableModel(
      new Object[0][], (Object[])new String[] { "Barcode", "Barang", "Harga Jual", 
        "Qty", "Total" }) {
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };
  
  private TableModelJual tabModel;
  
  private JTextField textField_1;
  
  private JTextField textField_2;
  
  private JTextField textField_3;
  
  private JTextField textField_4;
  
  private JTable table_1;
  
  private JTextField textField_5;
  
  private String tanggal_jual;
  
  private Double total_bayar;
  
  private String id_jual;
  
  private JTextField textField_6;
  
  public String getId_jual() {
    return this.id_jual;
  }
  
  public void setId_jual(String id_jual) {
    this.id_jual = id_jual;
  }
  
  public String getTanggal_jual() {
    return this.tanggal_jual;
  }
  
  public void setTanggal_jual(String tanggal_jual) {
    this.tanggal_jual = tanggal_jual;
  }
  
  public Double getTotal_bayar() {
    return this.total_bayar;
  }
  
  public void setTotal_bayar(Double total_bayar) {
    this.total_bayar = total_bayar;
  }
  
  private void CariJual() throws ErrorInfo, SQLException {
    this.tabModel.fireTableDataChanged();
    DaoJual dao = MappingJual.getDaoJual();
    this.tabModel.setList(dao.CariNotmerTransaksi(this.textField.getText()));
  }
  
  private void CariJualDua(String tanggal) throws ErrorInfo, SQLException {
    this.tabModel.fireTableDataChanged();
    DaoJual dao = MappingJual.getDaoJual();
    this.tabModel.setList(dao.TampilkanTanggal(tanggal));
  }
  
  private void cariDetailJual() throws ErrorInfo, SQLException {
    this.tableModelDetailJual.fireTableDataChanged();
    DaoCetakUlang dao = MappingCetak.getDaoCetakUlang();
    this.tableModelDetailJual.setList(dao.CetakUlangData(this.textField_1.getText()));
  }
  
  public static void main(String[] args) {
    try {
      viewCetakUlang dialog = new viewCetakUlang();
      dialog.setDefaultCloseOperation(2);
      dialog.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public viewCetakUlang() {
    setBounds(100, 100, 1000, 600);
    getContentPane().setLayout(new BorderLayout());
    this.tabModel = new TableModelJual();
    this.tableModelDetailJual = new TableModelDetailJual();
    this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(this.contentPanel, "Center");
    this.contentPanel.setLayout((LayoutManager)null);
    JPanel panel = new JPanel();
    panel.setBackground(Color.BLACK);
    panel.setBounds(12, 74, 450, 459);
    this.contentPanel.add(panel);
    panel.setLayout((LayoutManager)null);
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(12, 12, 430, 435);
    panel.add(scrollPane);
    this.table = new JTable();
    this.table.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent e) {
            viewCetakUlang.this.clik();
          }
        });
    scrollPane.setViewportView(this.table);
    this.textField = new JTextField();
    this.textField.addKeyListener(new KeyAdapter() {
          public void keyReleased(KeyEvent e) {
            viewCetakUlang.this.table.setModel((TableModel)viewCetakUlang.this.tabModel);
            try {
              viewCetakUlang.this.CariJual();
            } catch (ErrorInfo e1) {
              e1.printStackTrace();
            } catch (SQLException e1) {
              e1.printStackTrace();
            } 
          }
        });
    this.textField.setBounds(12, 28, 114, 34);
    this.contentPanel.add(this.textField);
    this.textField.setColumns(10);
    JButton btnCari = new JButton("Cari");
    btnCari.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            viewCetakUlang.this.table.setModel((TableModel)viewCetakUlang.this.tabModel);
            try {
              viewCetakUlang.this.CariJualDua(String.valueOf(viewCetakUlang.this.dataFormatTanggal.format(viewCetakUlang.this.dateChooser.getDate())));
            } catch (ErrorInfo e) {
              e.printStackTrace();
            } catch (SQLException e) {
              e.printStackTrace();
            } 
          }
        });
    btnCari.setBounds(308, 28, 92, 34);
    this.contentPanel.add(btnCari);
    JPanel panel_1 = new JPanel();
    panel_1.setBackground(Color.BLACK);
    panel_1.setBounds(500, 74, 478, 282);
    this.contentPanel.add(panel_1);
    panel_1.setLayout((LayoutManager)null);
    JScrollPane scrollPane_1 = new JScrollPane();
    scrollPane_1.setBounds(12, 24, 454, 258);
    panel_1.add(scrollPane_1);
    this.table_1 = new JTable() {
        public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
          Component component = super.prepareRenderer(renderer, row, column);
          int rendererWidth = (component.getPreferredSize()).width;
          TableColumn tableColumn = getColumnModel().getColumn(column);
          tableColumn.setPreferredWidth(Math.max(rendererWidth + (getIntercellSpacing()).width, tableColumn.getPreferredWidth()));
          return component;
        }
      };
    this.table_1.setRowHeight(30);
    this.table_1.setModel(this.tableModel);
    scrollPane_1.setViewportView(this.table_1);
    JButton btnCetak = new JButton("Cetak");
    btnCetak.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            viewCetakUlang.this.cetak();
          }
        });
    btnCetak.setBounds(600, 508, 117, 25);
    this.contentPanel.add(btnCetak);
    this.textField_1 = new JTextField();
    this.textField_1.setBounds(595, 35, 114, 19);
    this.contentPanel.add(this.textField_1);
    this.textField_1.setVisible(false);
    this.textField_1.setColumns(10);
    this.textField_2 = new JTextField();
    this.textField_2.setFont(new Font("Dialog", 1, 15));
    this.textField_2.setBounds(562, 368, 176, 34);
    this.contentPanel.add(this.textField_2);
    this.textField_2.setColumns(10);
    this.dateChooser = new JDateChooser();
    this.dateChooser.setBounds(138, 28, 160, 34);
    this.contentPanel.add((Component)this.dateChooser);
    this.textField_3 = new JTextField();
    this.textField_3.setFont(new Font("Dialog", 1, 15));
    this.textField_3.setColumns(10);
    this.textField_3.setBounds(562, 416, 176, 34);
    this.contentPanel.add(this.textField_3);
    this.textField_4 = new JTextField();
    this.textField_4.setFont(new Font("Dialog", 1, 15));
    this.textField_4.setColumns(10);
    this.textField_4.setBounds(562, 462, 176, 34);
    this.contentPanel.add(this.textField_4);
    this.textField_5 = new JTextField();
    this.textField_5.setBounds(469, 35, 114, 19);
    this.contentPanel.add(this.textField_5);
    this.textField_5.setColumns(10);
    this.textField_5.setVisible(false);
    this.textField_6 = new JTextField();
    this.textField_6.setBounds(469, 4, 114, 19);
    this.textField_6.setVisible(false);
    this.contentPanel.add(this.textField_6);
    this.textField_6.setColumns(10);
    JPanel buttonPane = new JPanel();
    buttonPane.setLayout(new FlowLayout(2));
    getContentPane().add(buttonPane, "South");
    JButton okButton = new JButton("OK");
    okButton.setActionCommand("OK");
    buttonPane.add(okButton);
    getRootPane().setDefaultButton(okButton);
    JButton cancelButton = new JButton("Cancel");
    cancelButton.setActionCommand("Cancel");
    buttonPane.add(cancelButton);
  }
  
  private void clik() {
    Jual jual = this.tabModel.get(this.table.getSelectedRow());
    this.textField_1.setText((new StringBuilder(String.valueOf(jual.getId_jual()))).toString());
    this.textField_2.setText(this.df.format(jual.getTunai()));
    this.textField_3.setText(this.df.format(jual.getTotal()));
    this.textField_4.setText(this.df.format(jual.getTunai().doubleValue() - jual.getTotal().doubleValue()));
    this.textField_5.setText(jual.getId_user());
    setId_jual((new StringBuilder(String.valueOf(jual.getNo()))).toString());
    setJam_cetak(jual.getJam());
    setNama_pelanggan(jual.getNama());
    setPoin(jual.getPoin());
    setNama_user(jual.getId_user());
    setTanggalC(jual.getTanggal());
    setTotal_bayar(jual.getTotal());
    try {
      this.table_1.setModel((TableModel)this.tableModelDetailJual);
      cariDetailJual();
    } catch (ErrorInfo|SQLException e) {
      e.printStackTrace();
    } 
    try {
      cari2();
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }
  
  private void cari2() throws SQLException {
    Connection konek = Koneksi.getKoneksi();
    Statement state = konek.createStatement();
    String sql = "select jumlah from pengguna WHERE id_pengguna = '" + 
      
      this.textField_5.getText() + "'";
    ResultSet rs = state.executeQuery(sql);
    while (rs.next())
      setPenghasilan(Double.valueOf(rs.getDouble(1))); 
    rs.close();
    state.close();
  }
  
  private void cetak() {
    NextPageDua page = new NextPageDua();
  }
  
  class NextPageDua extends JDialog {
    int jum;
    
    public NextPageDua() {
      JsonTemplate jsonTemplate;
      SimpleEscp simpleEscp = new SimpleEscp();
      int x = Integer.parseInt(viewCetakUlang.this.getId_jual());
      Fakturtiga fakturdua = new Fakturtiga(String.valueOf(String.valueOf(viewCetakUlang.this.textField_5.getText())) + "-" + x, 
          viewCetakUlang.this.getTanggal_jual(), viewCetakUlang.this.getJam_cetak(), 
          viewCetakUlang.this.textField_3.getText(), viewCetakUlang.this.textField_2.getText(), 
          viewCetakUlang.this.textField_4.getText(), viewCetakUlang.this.poin, "nama");
      for (int i = 0; i < viewCetakUlang.this.table_1.getRowCount(); i++) {
        this.jum = Integer.parseInt(viewCetakUlang.this.table_1.getValueAt(i, 3).toString());
        fakturdua.tambahItemFaktur(new ItemFakturtiga((String)viewCetakUlang.this.table_1.getValueAt(i, 1), 
              Integer.valueOf(this.jum), 
              (String)viewCetakUlang.this.table_1.getValueAt(i, 2), 
              (String)viewCetakUlang.this.table_1.getValueAt(i, 4)));
      } 
      DataSource dataSource = DataSources.from(fakturdua);
      Template template = null;
      try {
        jsonTemplate = new JsonTemplate(NextPageDua.class.getResourceAsStream("templateempat.json"));
      } catch (IOException e) {
        e.printStackTrace();
      } 
      //simpleEscp.print((Template)jsonTemplate, dataSource);
    }
  }
}
