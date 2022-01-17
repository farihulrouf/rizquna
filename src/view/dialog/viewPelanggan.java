package view.dialog;
 

import com.silver.con2.MappingDbPelanggan;
import com.silver.dao.DaoPelanggan;
import com.silver.dao.ErrorInfo;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JDialog;
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
import javax.swing.table.TableModel;

public class viewPelanggan extends JDialog {
  private final JPanel contentPanel = new JPanel();
  
  private JTextField textField;
  
  private JTable table;
  
  private TableModelPelanggan tableModel;
  
  private String nama_barang;
  
  private Double harga_jual;
  
  private Double harga_diskon1;
  
  private Double harga_diskon2;
  
  private String persediaan;
  
  private String satuan;
  
  private String barcode;
  
  private int poin;
  
  private JTextField textField_1;
  
  public JTextField getinputJumlah() {
    return this.textField_1;
  }
  
  public String getBarcode() {
    return this.barcode;
  }
  
  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }
  
  private void pesanEror() {
    JOptionPane.showMessageDialog(this, "Anda Memasukan Huruf, Lakukan Masukan angka");
  }
  
  public String getNama_barang() {
    return this.nama_barang;
  }
  
  public void setNama_barang(String nama_barang) {
    this.nama_barang = nama_barang;
  }
  
  public Double getHarga_jual() {
    return this.harga_jual;
  }
  
  public void setHarga_jual(Double harga_jual) {
    this.harga_jual = harga_jual;
  }
  
  public Double getHarga_diskon1() {
    return this.harga_diskon1;
  }
  
  public void setHarga_diskon1(Double harga_diskon1) {
    this.harga_diskon1 = harga_diskon1;
  }
  
  public Double getHarga_diskon2() {
    return this.harga_diskon2;
  }
  
  public void setHarga_diskon2(Double harga_diskon2) {
    this.harga_diskon2 = harga_diskon2;
  }
  
  public String getPersediaan() {
    return this.persediaan;
  }
  
  public void setPersediaan(String persediaan) {
    this.persediaan = persediaan;
  }
  
  public int getPoin() {
    return this.poin;
  }
  
  public void setPoin(int poin) {
    this.poin = poin;
  }
  
  public String getSatuan() {
    return this.satuan;
  }
  
  public void setSatuan(String satuan) {
    this.satuan = satuan;
  }
  
  public viewPelanggan(AdminKasir parent) {
    setBackground(new Color(153, 153, 153));
    this.tableModel = new TableModelPelanggan();
    init();
  }
  
  private void init() {
    setBounds(15, 15, 700, 550);
    getContentPane().setLayout(new BorderLayout());
    this.contentPanel.setBackground(Color.DARK_GRAY);
    this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(this.contentPanel, "Center");
    this.contentPanel.setLayout((LayoutManager)null);
    JPanel panel = new JPanel();
    panel.setBackground(Color.WHITE);
    panel.setBounds(12, 12, 676, 445);
    this.contentPanel.add(panel);
    panel.setLayout((LayoutManager)null);
    this.textField = new JTextField();
    this.textField.addKeyListener(new KeyAdapter() {
          public void keyTyped(KeyEvent e) {
            try {
              viewPelanggan.this.table.setModel((TableModel)viewPelanggan.this.tableModel);
              viewPelanggan.this.Cari();
            } catch (Exception exception) {}
          }
          
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
              case 40:
                viewPelanggan.this.table.requestFocus();
                break;
              case 37:
                viewPelanggan.this.textField_1.requestFocus();
                break;
            } 
          }
        });
    this.textField.setFont(new Font("Dialog", 0, 20));
    this.textField.setBounds(250, 12, 357, 33);
    panel.add(this.textField);
    this.textField.setColumns(10);
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(12, 72, 652, 350);
    panel.add(scrollPane);
    this.table = new JTable() {
        public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
          Component component = super.prepareRenderer(renderer, row, column);
          int rendererWidth = (component.getPreferredSize()).width;
          TableColumn tableColumn = getColumnModel().getColumn(column);
          tableColumn.setPreferredWidth(Math.max(rendererWidth + (getIntercellSpacing()).width, tableColumn.getPreferredWidth()));
          return component;
        }
      };
    this.table.setBorder(UIManager.getBorder("EditorPane.border"));
    this.table.setBackground(new Color(0, 255, 153));
    this.table.setRowHeight(25);
    this.table.setForeground(new Color(0, 0, 0));
    this.table.setFont(new Font("Dialog", 0, 20));
    this.table.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == 10) {
              e.consume();
              viewPelanggan.this.klik();
              viewPelanggan.this.dispose();
            } 
          }
        });
    this.table.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent e) {
            viewPelanggan.this.klik();
          }
        });
    this.table.setModel(new DefaultTableModel(
          new Object[0][], 
          
          (Object[])new String[] { "nama", "Hp", "Poin" }));
    scrollPane.setViewportView(this.table);
    this.textField_1 = new JTextField();
    this.textField_1.setVisible(false);
    this.textField_1.setForeground(Color.BLUE);
    this.textField_1.addKeyListener(new KeyAdapter() {
          public void keyTyped(KeyEvent e) {
            char karakter = e.getKeyChar();
            if ((karakter < '0' || karakter > '9' || 
              viewPelanggan.this.textField_1.getText().length() >= 14) && 
              karakter != '\b') {
              viewPelanggan.this.getToolkit().beep();
              e.consume();
              viewPelanggan.this.pesanEror();
            } 
          }
          
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
              case 39:
                viewPelanggan.this.textField.requestFocus();
                break;
            } 
          }
        });
    this.textField_1.setFont(new Font("Dialog", 0, 23));
    this.textField_1.setBounds(124, 12, 114, 33);
    this.textField_1.selectAll();
    this.textField_1.setText("1");
    this.textField_1.requestFocus();
    panel.add(this.textField_1);
    this.textField_1.setColumns(10);
    JPanel buttonPane = new JPanel();
    buttonPane.setBackground(new Color(220, 220, 220));
    buttonPane.setLayout(new FlowLayout(2));
    getContentPane().add(buttonPane, "South");
    JButton okButton = new JButton("OK");
    okButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            viewPelanggan.this.jButtonSaveActionPerformed(e);
          }
        });
    okButton.setActionCommand("OK");
    buttonPane.add(okButton);
    getRootPane().setDefaultButton(okButton);
    JButton cancelButton = new JButton("Cancel");
    cancelButton.setActionCommand("Cancel");
    buttonPane.add(cancelButton);
  }
  
  private void Cari() throws ErrorInfo, SQLException {
    this.tableModel.fireTableDataChanged();
    DaoPelanggan dao = MappingDbPelanggan.getDaoPelanggan();
    this.tableModel.setList(dao.cariPelanggan(this.textField.getText()));
  }
  
  public viewPelanggan(AdminKasir parent, boolean modal) {
    setModal(true);
    this.tableModel = new TableModelPelanggan();
    init();
    setLocationRelativeTo((Component)parent);
    setVisible(true);
  }
  
  private void klik() {
    Pelanggan modele = this.tableModel.get(this.table.getSelectedRow());
    setBarcode(modele.getId_pelanggan());
    setNama_barang(modele.getNama_pelanggan());
    setPoin(modele.getPoin());
  }
  
  private void jButtonSaveActionPerformed(ActionEvent evt) {
    dispose();
  }
  
  private void jMyTableKeyPressed(KeyEvent evt) {
    if (evt.getKeyCode() == 10) {
      evt.consume();
      klik();
    } 
  }
}
