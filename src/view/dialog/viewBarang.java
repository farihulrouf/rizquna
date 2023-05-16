package view.dialog;

 
import com.silver.con2.MappingDbBarang;
import com.silver.controller.ControllerBarang;
import com.silver.dao.DaoBarang;
import com.silver.dao.ErrorInfo;
import com.silver.data.Barang;
import com.silver.model.ModelBarang;
import com.silver.model.table.TableModelBarang;
import view.Koneksi;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class viewBarang extends JDialog {
  Locale locale = new Locale("en", "UK");
  
  DecimalFormat df = (DecimalFormat)NumberFormat.getNumberInstance(this.locale);
  
  private ControllerBarang controller;
  
  private final JPanel contentPanel = new JPanel();
  
  private JTextField textField;
  
  private JTextField textPointField;
  
  private JTextField textField_1;
  
  //private JTextField textField_2;
  
  //private JTextField textField_3;
  
  //private JTextField textField_4;
  
  private JTextField textField_5;
  
  private JTextField textField_6;
  
  private JTextField textField_7;
  
  private JTextField textField_8;
  
  private JTextField textField_9;
  
  private JTextField textField_15;
  private JTextField textField_16;
  
  private JLabel lblPpn;
  
  private JLabel lblJumlah;
  
  private JLabel lblTotal;
  
  private JLabel lblBarang;
  
  private JLabel lblHargaBeli;
  
  private JLabel lblHargaEcer;
  
  private JLabel lblHargaKulak;
  
  private JLabel lblHargaKarton;
  
  private JLabel lblPersediaan;
  
  private JScrollPane scrollPane;
  
  private JTable table;
  
  private JButton btnTambah;
  
  private JButton btnUbah;
  
  private JButton btnHapus;
  
  private JButton btnReset;
  
  private JTextField textField_10;
  
  private JLabel lblCari;
  
  private String barcode = "";
  
  private TableModelBarang tableModel;
  
  private ModelBarang model;
  
  public String getBarcode() {
    return this.barcode;
  }
  
  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }
  
  public JTextField getINputKategori() {
    return this.textField_12;
  }
  
  public static void main(String[] args) {
    try {
      viewBarang dialog = new viewBarang();
      dialog.setDefaultCloseOperation(2);
      dialog.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  private Double total_beli = Double.valueOf(0.0D);
  
  private Double harga_akhir = Double.valueOf(0.0D);
  
  private Double ppn = Double.valueOf(0.0D);
  
  private JTextField textField_11;
  
  private JTextField textField_12;
  
 /* private void total_beli() {
    this.total_beli = 
      Double.valueOf(Double.parseDouble(
          this.textField_4.getText()) / Integer.parseInt(
          this.textField_3.getText()));
    //this.ppn = Double.valueOf(this.total_beli.doubleValue() * Double.parseDouble(this.textField_2.getText()) / 100.0D);
    this.harga_akhir = Double.valueOf(this.total_beli.doubleValue() + this.ppn.doubleValue());
    this.textField_5.setText(this.df.format(this.harga_akhir));
  }
  */
  
  private void clik_barang() {
    Barang barang = this.tableModel.get(this.table.getSelectedRow());
    this.textField.setText(barang.getId_barang());
    this.textField_1.setText(barang.getNama_barang());
    this.textField_5.setText(this.df.format(barang.getHarga_beli()));
    this.textField_6.setText(this.df.format(barang.getHarga_jual()));
    this.textField_7.setText(this.df.format(barang.getHarga_diskon()));
    this.textField_8.setText(this.df.format(barang.getHarga_lain()));
    this.textField_9.setText(this.df.format(barang.getPersediaan()));

    this.textField_15.setText(this.df.format(barang.getMindiskon()));

    this.textField_16.setText(this.df.format(barang.getMindiskon2()));
    this.textPointField.setText(String.valueOf(barang.getPoin()));
    this.textField_12.setText(String.valueOf(barang.getBalance()));
    this.textField_11.setText("1");
  }
  
  private void Cari() throws ErrorInfo, SQLException {
    this.tableModel.fireTableDataChanged();
    DaoBarang dao = MappingDbBarang.getDaoBarang();
    this.tableModel.setList(dao.cariBarang(this.textField_10.getText()));
  }
  
  private void Cari2() throws ErrorInfo, SQLException {
    this.tableModel.fireTableDataChanged();
    DaoBarang dao = MappingDbBarang.getDaoBarang();
    this.tableModel.setList(dao.cariBarangKode(this.textField_10.getText()));
  }
  
  public viewBarang() {
    setBackground(new Color(34, 139, 34));
    setBounds(100, 100, 900, 700);
    this.controller = new ControllerBarang();
    this.model = new ModelBarang();
    this.controller.setModel(this.model);
    getContentPane().setLayout(new BorderLayout());
    this.contentPanel.setBackground(SystemColor.info);
    this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(this.contentPanel, "Center");
    this.tableModel = new TableModelBarang();
    this.contentPanel.setLayout((LayoutManager)null);
    this.textField = new JTextField();
    this.textField.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent paramActionEvent) {
            viewBarang.this.setBarcode(viewBarang.this.textField.getText());
          }
        });
    this.textField.setFont(new Font("Dialog", 1, 18));
    this.textField.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
              case 40:
                //viewBarang.this.textField_2.requestFocus();
                break;
              case 39:
                viewBarang.this.textPointField.requestFocus();
                break;
              case 10:
                viewBarang.this.CariBarang();
                break;
            } 
          }
          
          public void keyReleased(KeyEvent e) {
            viewBarang.this.CariBarang();
          }
        });
    this.textField.setBounds(100, 10, 260, 29);
    this.contentPanel.add(this.textField);
    this.textField.setColumns(10);
    this.textPointField = new JTextField();
    this.textPointField.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
              case 37:
                viewBarang.this.textField.requestFocus();
                break;
              case 40:
                //viewBarang.this.textField_2.requestFocus();
                break;
            } 
          }
        });
    this.textPointField.setBounds(450, 14, 70, 23);
    this.contentPanel.add(this.textPointField);
    JLabel lblBarcode = new JLabel("Barcode");
    JLabel lblpoint = new JLabel("Poin");
    lblpoint.setBounds(400, 14, 70, 23);
    lblBarcode.setBounds(12, 14, 70, 23);
    this.contentPanel.add(lblpoint);
    this.contentPanel.add(lblBarcode);
    this.textField_1 = new JTextField();
    this.textField_1.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
              case 38:
                //viewBarang.this.textField_2.requestFocus();
                //viewBarang.this.textField_2.selectAll();
                break;
              case 40:
                viewBarang.this.textField_5.requestFocus();
                viewBarang.this.textField_5.selectAll();
                break;
              case 37:
                viewBarang.this.textField_1.requestFocus();
                break;
              case 39:
                viewBarang.this.textField_12.requestFocus();
                break;
            } 
          }
        });
    this.textField_1.setFont(new Font("Dialog", 1, 18));
    this.textField_1.setColumns(10);
    this.textField_1.setBounds(100, 60, 450, 29);
    this.contentPanel.add(this.textField_1);
    /*
    this.textField_2 = new JTextField();
    this.textField_2.setFont(new Font("Dialog", 1, 18));
    this.textField_2.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
              case 38:
                viewBarang.this.textField.requestFocus();
                break;
              case 40:
                viewBarang.this.textField_1.requestFocus();
                break;
              case 37:
                viewBarang.this.textField_1.requestFocus();
                break;
              case 39:
                viewBarang.this.textField_3.requestFocus();
                break;
            } 
          }
        });
    this.textField_2.setColumns(10);
    this.textField_2.setBounds(100, 53, 114, 29);
    */
   // this.contentPanel.add(this.textField_2);
    //this.textField_3 = new JTextField();
    /*this.textField_3.setFont(new Font("Dialog", 1, 18));
    this.textField_3.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
              case 38:
                viewBarang.this.textField.requestFocus();
                break;
              case 40:
                viewBarang.this.textField_1.requestFocus();
                break;
              case 37:
               // viewBarang.this.textField_2.requestFocus();
                break;
              case 39:
                viewBarang.this.textField_4.requestFocus();
                break;
            } 
          }
        });
    this.textField_3.setColumns(10);
    this.textField_3.setBounds(332, 53, 114, 29);
    this.contentPanel.add(this.textField_3);
    */
    
    /*
    this.textField_4 = new JTextField();
    this.textField_4.setFont(new Font("Dialog", 1, 18));
    this.textField_4.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
              case 40:
                viewBarang.this.textField_1.requestFocus();
                break;
              case 37:
               // viewBarang.this.textField_3.requestFocus();
                break;
              case 10:
               // viewBarang.this.total_beli();
                break;
            } 
          }
        });
    this.textField_4.setColumns(10);
    this.textField_4.setBounds(612, 53, 114, 29);
    */
    //this.contentPanel.add(this.textField_4);
    this.textField_5 = new JTextField();
    this.textField_5.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            viewBarang.this.apdateBarang();
          }
        });
    this.textField_5.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
              case 38:
                viewBarang.this.textField_1.requestFocus();
                viewBarang.this.textField_1.selectAll();
                break;
              case 40:
                viewBarang.this.textField_6.requestFocus();
                viewBarang.this.textField_6.selectAll();
                break;
              case 37:
                viewBarang.this.textField_1.requestFocus();
                viewBarang.this.textField_1.selectAll();
                break;
              case 39:
                //viewBarang.this.textField_3.requestFocus();
                break;
            } 
          }
        });
    this.textField_5.setFont(new Font("Dialog", 1, 18));
    this.textField_5.setColumns(10);
    this.textField_5.setBounds(100, 100, 318, 29);
    this.contentPanel.add(this.textField_5);
    this.textField_6 = new JTextField();
    this.textField_6.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
              case 38:
                viewBarang.this.textField_5.requestFocus();
                viewBarang.this.textField_5.selectAll();
                break;
              case 40:
                viewBarang.this.textField_9.requestFocus();
                viewBarang.this.textField_9.selectAll();
                break;
              case 37:
                viewBarang.this.textField_1.requestFocus();
                break;
              case 39:
                viewBarang.this.textField_7.requestFocus();
                viewBarang.this.textField_7.selectAll();
                break;
            } 
          }
        });
    this.textField_6.setFont(new Font("Dialog", 1, 18));
    this.textField_6.setColumns(10);
    this.textField_6.setBounds(100, 140, 114, 29);
    this.contentPanel.add(this.textField_6);
    this.textField_7 = new JTextField();
    this.textField_7.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
              case 38:
               // viewBarang.this.textField_2.requestFocus();
                //viewBarang.this.textField.selectAll();
                break;
              case 40:
                viewBarang.this.textField_5.requestFocus();
                break;
              case 37:
                viewBarang.this.textField_6.selectAll();
                viewBarang.this.textField_6.requestFocus();
                break;
              case 39:
                viewBarang.this.textField_8.requestFocus();
                viewBarang.this.textField_8.selectAll();
                break;
            } 
          }
        });
    this.textField_7.setFont(new Font("Dialog", 1, 18));
    this.textField_7.setColumns(10);
    this.textField_7.setBounds(332, 140, 114, 29);
    this.contentPanel.add(this.textField_7);
    
    this.textField_15 = new JTextField();
    this.textField_15.addKeyListener(new KeyAdapter() {
        public void keyPressed(KeyEvent e) {
          int keyCode = e.getKeyCode();
          switch (keyCode) {
            case 38:
             // viewBarang.this.textField_2.requestFocus();
              //viewBarang.this.textField.selectAll();
              break;
            case 40:
              //viewBarang.this.textField_5.requestFocus();
              break;
            case 37:
              //viewBarang.this.textField_6.selectAll();
              //viewBarang.this.textField_6.requestFocus();
              break;
            case 39:
             // viewBarang.this.textField_8.requestFocus();
             // viewBarang.this.textField_8.selectAll();
              break;
          } 
        }
      });
  this.textField_15.setFont(new Font("Dialog", 1, 18));
  this.textField_15.setColumns(10);
  this.textField_15.setBounds(332, 180, 114, 29);
  this.contentPanel.add(this.textField_15);
  
  
  
  this.textField_16 = new JTextField();
  this.textField_16.addKeyListener(new KeyAdapter() {
        public void keyPressed(KeyEvent e) {
          int keyCode = e.getKeyCode();
          switch (keyCode) {
            case 38:
              //viewBarang.this.textField_7.requestFocus();
              break;
            case 40:
              //viewBarang.this.textField_9.requestFocus();
              break;
            case 37:
             // viewBarang.this.textField_7.selectAll();
              //viewBarang.this.textField_7.requestFocus();
              break;
            case 39:
              //viewBarang.this.textField_9.requestFocus();
              break;
          } 
        }
      });
  this.textField_16.setFont(new Font("Dialog", 1, 18));
  this.textField_16.setColumns(10);
  this.textField_16.setBounds(612, 180, 114, 29);
  this.contentPanel.add(this.textField_16);
  
  
    
    
    this.textField_8 = new JTextField();
    this.textField_8.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
              case 38:
                viewBarang.this.textField_7.requestFocus();
                break;
              case 40:
                viewBarang.this.textField_9.requestFocus();
                break;
              case 37:
                viewBarang.this.textField_7.selectAll();
                viewBarang.this.textField_7.requestFocus();
                break;
              case 39:
                viewBarang.this.textField_9.requestFocus();
                break;
            } 
          }
        });
    this.textField_8.setFont(new Font("Dialog", 1, 18));
    this.textField_8.setColumns(10);
    this.textField_8.setBounds(612, 140, 114, 29);
    this.contentPanel.add(this.textField_8);
    this.textField_9 = new JTextField();
    this.textField_9.setText("0");
    this.textField_9.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
              case 38:
                viewBarang.this.textField_6.requestFocus();
                viewBarang.this.textField_6.selectAll();
                break;
              case 40:
                viewBarang.this.textField_5.requestFocus();
                break;
              case 37:
                viewBarang.this.textField_1.requestFocus();
                break;
              case 39:
                //viewBarang.this.textField_3.requestFocus();
                break;
              case 10:
                if (viewBarang.this.textField_11.getText().equals("0")) {
                  viewBarang.this.insertBarang();
                  break;
                } 
                viewBarang.this.UpdatePBarang();
                break;
            } 
          }
        });
    this.textField_9.setFont(new Font("Dialog", 1, 18));
    this.textField_9.setColumns(10);
    this.textField_9.setBounds(100, 235, 114, 29);
    this.contentPanel.add(this.textField_9);
    //this.lblPpn = new JLabel("ppn");
    //this.lblPpn.setBounds(12, 60, 70, 15);
    //this.contentPanel.add(this.lblPpn);
    //this.lblJumlah = new JLabel("jumlah");
    //this.lblJumlah.setBounds(245, 60, 70, 15);
    //this.contentPanel.add(this.lblJumlah);
    //this.lblTotal = new JLabel("total");
    //this.lblTotal.setBounds(502, 60, 70, 15);
    //this.contentPanel.add(this.lblTotal);
    this.lblBarang = new JLabel("Barang");
    this.lblBarang.setBounds(12, 60, 70, 15);
    this.contentPanel.add(this.lblBarang);
    this.lblHargaBeli = new JLabel("harga beli");
    this.lblHargaBeli.setBounds(12, 100, 94, 16);
    this.contentPanel.add(this.lblHargaBeli);
    this.lblHargaEcer = new JLabel("harga ecer");
    
    
    
    this.lblHargaEcer.setBounds(12, 140, 94, 15);
    this.contentPanel.add(this.lblHargaEcer);
    this.lblHargaKulak = new JLabel("Harga Kulak");
    this.lblHargaKulak.setBounds(232, 140, 94, 15);
    this.contentPanel.add(this.lblHargaKulak);
    this.lblHargaKarton = new JLabel("Harga Karton");
    this.lblHargaKarton.setBounds(489, 140, 120, 15);
    this.contentPanel.add(this.lblHargaKarton);
    this.lblPersediaan = new JLabel("Persediaan");
    this.lblPersediaan.setBounds(12, 240, 94, 15);
    this.contentPanel.add(this.lblPersediaan);
    this.scrollPane = new JScrollPane();
    this.scrollPane.setBounds(12, 370, 850, 300);
    this.contentPanel.add(this.scrollPane);
    this.table = new JTable() {
        public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
          Component component = super.prepareRenderer(renderer, row, column);
          int rendererWidth = (component.getPreferredSize()).width;
          TableColumn tableColumn = getColumnModel().getColumn(column);
          tableColumn.setPreferredWidth(Math.max(rendererWidth + (getIntercellSpacing()).width, tableColumn.getPreferredWidth()));
          return component;
        }
      };
    this.table.setForeground(new Color(0, 0, 0));
    this.table.setFont(new Font("Dialog", 1, 18));
    this.table.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent e) {
            viewBarang.this.clik_barang();
          }
        });
    this.scrollPane.setViewportView(this.table);
    this.btnTambah = new JButton("Tambah");
    this.btnTambah.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            viewBarang.this.insertBarang();
          }
        });
    this.btnTambah.setIcon(new ImageIcon(viewBarang.class.getResource("/com/silver/peratan/image/add-icon.png")));
    this.btnTambah.setBounds(399, 330, 129, 25);
    this.contentPanel.add(this.btnTambah);
    this.btnUbah = new JButton("Ubah");
    this.btnUbah.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            viewBarang.this.UpdatePBarang();
          }
        });
    this.btnUbah.setIcon(new ImageIcon(viewBarang.class.getResource("/com/silver/peratan/image/edit-validated-icon.png")));
    this.btnUbah.setBounds(270, 330, 117, 25);
    this.contentPanel.add(this.btnUbah);
    this.btnHapus = new JButton("Hapus");
    this.btnHapus.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            viewBarang.this.hapusBarang();
          }
        });
    this.btnHapus.setIcon(new ImageIcon(viewBarang.class.getResource("/com/silver/peratan/image/Actions-edit-clear-icon.png")));
    this.btnHapus.setBounds(141, 330, 117, 25);
    this.contentPanel.add(this.btnHapus);
    this.btnReset = new JButton("Reset");
    this.btnReset.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            viewBarang.this.cleardata();
          }
        });
    this.btnReset.setIcon(new ImageIcon(viewBarang.class.getResource("/com/silver/peratan/image/clear.png")));
    this.btnReset.setBounds(12, 330, 117, 25);
    this.contentPanel.add(this.btnReset);
    this.textField_10 = new JTextField();
    this.textField_10.setFont(new Font("Dialog", 0, 25));
    this.textField_10.addKeyListener(new KeyAdapter() {
          public void keyTyped(KeyEvent e) {
            viewBarang.this.table.setModel((TableModel)viewBarang.this.tableModel);
            try {
              viewBarang.this.Cari();
            } catch (ErrorInfo e1) {
              e1.printStackTrace();
            } catch (SQLException e1) {
              e1.printStackTrace();
            } 
          }
        });
    this.textField_10.setBounds(60, 280, 600, 37);
    this.contentPanel.add(this.textField_10);
    this.textField_10.setColumns(10);
    this.lblCari = new JLabel("CARI");
    this.lblCari.setBounds(12, 280, 70, 15);
    this.contentPanel.add(this.lblCari);
    this.textField_11 = new JTextField();
    this.textField_11.setBounds(700, 16, 50, 19);
    this.contentPanel.add(this.textField_11);
    this.textField_11.setColumns(10);
    JLabel lblNewLabel = new JLabel("Status Barang");
    lblNewLabel.setBounds(600, 70, 120, 15);
    this.contentPanel.add(lblNewLabel);
    this.textField_12 = new JTextField();
    this.textField_12.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
              case 38:
                //viewBarang.this.textField_2.requestFocus();
                //viewBarang.this.textField_2.selectAll();
                break;
              case 40:
                viewBarang.this.textField_5.requestFocus();
                viewBarang.this.textField_5.selectAll();
                break;
              case 37:
                viewBarang.this.textField_1.requestFocus();
                viewBarang.this.textField_1.selectAll();
                break;
              case 39:
                //viewBarang.this.textField_3.requestFocus();
                break;
            } 
          }
        });
    this.textField_12.setFont(new Font("Dialog", 1, 18));
    this.textField_12.setColumns(10);
    this.textField_12.setBounds(700, 60, 62, 29);
    this.textField_12.setText("0");
    this.contentPanel.add(this.textField_12);
    this.textField_11.setVisible(false);
    JPanel buttonPane = new JPanel();
    buttonPane.setBackground(new Color(0, 0, 0));
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
  
  private void cleardata() {
    this.textField.setText("");
    this.textField_1.setText("");
    //this.textField_2.setText("");
    //this.textField_3.setText("");
    //this.textField_4.setText("");
    this.textField_5.setText("");
    this.textField_6.setText("");
    this.textField_7.setText("");
    this.textField_8.setText("");
    this.textField_9.setText("");
    this.textField_10.setText("");

    this.textField_15.setText("");

    this.textField_16.setText("");
    this.textField_12.setText("0");
    this.textPointField.setText("");
    setBarcode(" ");
    this.textField.requestFocus();
  }
  
  /*
  public JTextField getTextField_4() {
    return this.textField_4;
  }
  
  public void setTextField_4(JTextField textField_4) {
    this.textField_4 = textField_4;
  }
  
  */
  public JTextField getTextField_6() {
    return this.textField_6;
  }
  
  public void setTextField_6(JTextField textField_6) {
    this.textField_6 = textField_6;
  }
  
  public JTextField getTextField_7() {
    return this.textField_7;
  }
  
  public void setTextField_7(JTextField textField_7) {
    this.textField_7 = textField_7;
  }
  
  public JTextField getTextField_8() {
    return this.textField_8;
  }
  
  public void setTextField_8(JTextField textField_8) {
    this.textField_8 = textField_8;
  }
  
  public JTextField getTextField_9() {
    return this.textField_9;
  }
  
  public void setTextField_9(JTextField textField_9) {
    this.textField_9 = textField_9;
  }
  
  public JTextField getTextField_1() {
    return this.textField_1;
  }
  
  public void setTextField_1(JTextField textField_1) {
    this.textField_1 = textField_1;
  }
  
  public JTextField getTextField_5() {
    return this.textField_5;
  }
  
  public void setTextField_5(JTextField textField_5) {
    this.textField_5 = textField_5;
  }
  
  public JTable getTable() {
    return this.table;
  }
  
  public JTextField getTextField() {
    return this.textField;
  }
  
  public void setTextField(JTextField textField) {
    this.textField = textField;
  }
  
  public void setTable(JTable table) {
    this.table = table;
  }
  
  private void insertBarang() {
    this.controller.insertBarang(this);
    cleardata();
    this.textField.requestFocus();
    setBarcode("");
  }
  
  private void apdateBarang() {
    this.controller.updateBarang(this);
    cleardata();
    this.textField.requestFocus();
    setBarcode("");
  }
  
  private void hapusBarang() {
    this.controller.deleteBarang(this);
    cleardata();
    setBarcode("");
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
        this.textField_1.setText(rs.getString(1));
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
        benar = false;
      } else {
        this.textField_1.setText("");
        this.textField_6.setText("0");
        this.textField_7.setText("0");
        this.textField_8.setText("0");
        this.textField_9.setText("0");
        this.textField_5.setText("0");
        this.textField_11.setText("0");
        this.textField_12.setText("0");
        this.textPointField.setText("0");
      } 
    } catch (Exception exception) {}
  }
  
  public JTextField getTextField_15() {
	return textField_15;
}

public void setTextField_15(JTextField textField_15) {
	this.textField_15 = textField_15;
}

public JTextField getTextField_16() {
	return textField_16;
}

public void setTextField_16(JTextField textField_16) {
	this.textField_16 = textField_16;
}

public JTextField getTextPointField() {
    return this.textPointField;
  }
  
  public void setTextPointField(JTextField textPointField) {
    this.textPointField = textPointField;
  }
  
  private void UpdatePBarang() {
    if (this.textPointField.getText().equals("")) {
      JOptionPane.showMessageDialog(this, "Poin Belum di masukan");
    } else if (this.textField_1.getText().equals("")) {
      JOptionPane.showMessageDialog(this, "Nama Barang Belum di masukan");
    } else if (this.textField_5.getText().equals("")) {
      JOptionPane.showMessageDialog(this, "Harga beli Belum di masukan");
    } else if (this.textField_6.getText().equals("")) {
      JOptionPane.showMessageDialog(this, "Harga  jual Belum di masukan");
    } else if (this.textField_7.getText().equals("")) {
      JOptionPane.showMessageDialog(this, "Harga Kulak Belum di masukan");
    } else if (this.textField_8.getText().equals("")) {
      JOptionPane.showMessageDialog(this, "Harga Karton Belum di masukan");
    } else if (this.textField_9.getText().equals("")) {
      JOptionPane.showMessageDialog(this, "Persediaan Belum di masukan");
    } else {
      String idBarang = this.textField.getText();
      int point = Integer.parseInt(this.textPointField.getText());
      String nama_barang = this.textField_1.getText();
      int status_barang = 0;
      Double harga_beli = Double.valueOf(Double.parseDouble(this.textField_5.getText().replace(",", "")));
      Double harga_ecer = Double.valueOf(Double.parseDouble(this.textField_6.getText().replace(",", "")));
      Double harga_kulak = Double.valueOf(Double.parseDouble(this.textField_7.getText().replace(",", "")));
      Double harga_karton = Double.valueOf(Double.parseDouble(this.textField_8.getText().replace(",", "")));
      int persediaan = Integer.parseInt(this.textField_9.getText());
      int balance = Integer.parseInt(this.textField_12.getText());
      int min = Integer.parseInt(this.textField_15.getText());
      int min2 = Integer.parseInt(this.textField_16.getText());
      Connection konek = Koneksi.getKoneksi();
      String sql1 = "UPDATE `barang` SET `nama_barang` = '" + 
        nama_barang + "', " + 
        "`harga_beli` = '" + harga_beli + "', " + 
        "`harga_jual` = '" + harga_ecer + "', " + 
        "`harga_diskon` = '" + harga_kulak + "', " + 
        "`harga_lain` = '" + harga_karton + "', " + 
        "`persediaan` = '" + persediaan + "', " + 
        "`balance` = '" + balance + "', " + 
        "`mindiskon` = '" + min + "', " + 
        "`mindiskon2` = '" + min2 + "', " + 
        "`poins` = '" + point + "' " + 
        "WHERE `barang`.`kd_barang` = '" + idBarang + "';";
      
      try {
        Statement state = konek.createStatement();
        state.executeUpdate(sql1);
        JOptionPane.showMessageDialog(this, "Sukses di ubah");
        clear_data();
      } catch (SQLException e1) {
        e1.printStackTrace();
      } 
    } 
    cleardata();
  }
  
  private void clear_data() {
    this.textField_1.setText("");
    this.textField_6.setText("0");
    this.textField_7.setText("0");
    this.textField_8.setText("0");
    this.textField_9.setText("0");
    this.textField_5.setText("0");
    this.textField_11.setText("1");
    this.textField_12.setText("0");

    this.textField_15.setText("0");
    this.textField_16.setText("0");
  }
}
