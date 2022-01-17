package view.dialog;
 

import com.silver.con2.MappingDbPelanggan;
import com.silver.controller.ControllerPlanggan;
import com.silver.dao.DaoPelanggan;
import com.silver.dao.ErrorInfo;
import com.silver.data.Pelanggan;
import com.silver.model.ModelPelanggan;
import com.silver.model.table.TableModelPelanggan;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

public class viewDataPelanggan extends JDialog {
  private final JPanel contentPanel = new JPanel();
  
  private JTextField textField;
  
  private JTextField textField_1;
  
  private JTextField passwordField;
  
  private JTextField textField_2;
  
  private JButton btnTop;
  
  private JTextField textPoin;
  
  private JTable table;
  
  private ModelPelanggan model;
  
  private TableModelPelanggan tableModel;
  
  private JButton btnLihat;
  
  private ControllerPlanggan controller;
  
  private void cariPelanggan() throws ErrorInfo, SQLException {
    this.tableModel.fireTableDataChanged();
    DaoPelanggan dao = MappingDbPelanggan.getDaoPelanggan();
    this.tableModel.setList(dao.cariPelanggan(this.textField_2.getText()));
  }
  
  private void TopPelanggan() throws ErrorInfo, SQLException {
    this.tableModel.fireTableDataChanged();
    DaoPelanggan dao = MappingDbPelanggan.getDaoPelanggan();
    this.tableModel.setList(dao.selectAllpelanggan());
  }
  
  public JTable getTable() {
    return this.table;
  }
  
  public void setTable(JTable table) {
    this.table = table;
  }
  
  public static void main(String[] args) {
    try {
      viewPegawai dialog = new viewPegawai();
      dialog.setDefaultCloseOperation(2);
      dialog.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public viewDataPelanggan() {
    setBounds(100, 100, 900, 600);
    this.model = new ModelPelanggan();
    this.tableModel = new TableModelPelanggan();
    this.controller = new ControllerPlanggan();
    this.controller.setModel(this.model);
    getContentPane().setLayout(new BorderLayout());
    this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(this.contentPanel, "Center");
    this.contentPanel.setLayout((LayoutManager)null);
    JLabel lblUserName = new JLabel("NOMER");
    lblUserName.setBounds(43, 122, 115, 15);
    this.contentPanel.add(lblUserName);
    JLabel lblNamaLengkap = new JLabel("Nama Lengkap");
    lblNamaLengkap.setBounds(43, 180, 115, 15);
    this.contentPanel.add(lblNamaLengkap);
    this.textField = new JTextField();
    this.textField.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
              case 40:
                viewDataPelanggan.this.textField_1.requestFocus();
                break;
            } 
          }
        });
    this.textField.setBounds(191, 120, 135, 27);
    this.contentPanel.add(this.textField);
    this.textField.setColumns(10);
    this.textField_1 = new JTextField();
    this.textField_1.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
              case 40:
                viewDataPelanggan.this.passwordField.requestFocus();
                break;
              case 38:
                viewDataPelanggan.this.textField.requestFocus();
                break;
            } 
          }
        });
    this.textField_1.setBounds(191, 178, 135, 27);
    this.contentPanel.add(this.textField_1);
    this.textField_1.setColumns(10);
    JLabel lblPassword = new JLabel("No HP");
    lblPassword.setBounds(43, 239, 70, 15);
    JLabel lblPoin = new JLabel("Jumlah Poin");
    lblPoin.setBounds(43, 300, 100, 15);
    this.contentPanel.add(lblPassword);
    this.contentPanel.add(lblPoin);
    this.passwordField = new JTextField();
    this.passwordField.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
              case 40:
                viewDataPelanggan.this.textPoin.requestFocus();
                break;
              case 38:
                viewDataPelanggan.this.textField_1.requestFocus();
                break;
            } 
          }
        });
    this.passwordField.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            viewDataPelanggan.this.insert();
          }
        });
    this.passwordField.setBounds(189, 233, 137, 27);
    this.textPoin = new JTextField();
    this.textPoin.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
              case 40:
                viewDataPelanggan.this.passwordField.requestFocus();
                break;
              case 38:
                viewDataPelanggan.this.passwordField.requestFocus();
                break;
            } 
          }
        });
    this.textPoin.setBounds(189, 300, 137, 27);
    this.contentPanel.add(this.textPoin);
    this.contentPanel.add(this.passwordField);
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(347, 79, 500, 400);
    this.contentPanel.add(scrollPane);
    this.table = new JTable();
    this.table.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent e) {
            viewDataPelanggan.this.clik();
          }
        });
    scrollPane.setViewportView(this.table);
    this.textField_2 = new JTextField();
    this.textField_2.addKeyListener(new KeyAdapter() {
          public void keyTyped(KeyEvent e) {
            viewDataPelanggan.this.table.setModel((TableModel)viewDataPelanggan.this.tableModel);
            try {
              viewDataPelanggan.this.cariPelanggan();
            } catch (ErrorInfo e1) {
              e1.printStackTrace();
            } catch (SQLException e1) {
              e1.printStackTrace();
            } 
          }
        });
    this.btnLihat = new JButton("Lihat");
    this.btnLihat.setBounds(580, 24, 100, 32);
    this.btnTop = new JButton("Top");
    this.btnTop.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            try {
              viewDataPelanggan.this.TopPelanggan();
            } catch (ErrorInfo|SQLException e1) {
              e1.printStackTrace();
            } 
          }
        });
    this.btnTop.setBounds(700, 24, 100, 32);
    this.contentPanel.add(this.btnLihat);
    this.contentPanel.add(this.btnTop);
    this.textField_2.setBounds(367, 24, 208, 32);
    this.contentPanel.add(this.textField_2);
    this.textField_2.setColumns(10);
    JButton btnTambah = new JButton("Tambah");
    btnTambah.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            viewDataPelanggan.this.insert();
          }
        });
    btnTambah.setBounds(245, 500, 90, 25);
    this.contentPanel.add(btnTambah);
    JButton btnHapus = new JButton("Hapus");
    btnHapus.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            viewDataPelanggan.this.deletePelanggan();
          }
        });
    btnHapus.setBounds(131, 500, 90, 25);
    this.contentPanel.add(btnHapus);
    JButton btnEdit = new JButton("edit");
    btnEdit.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            viewDataPelanggan.this.updatePelanggan();
          }
        });
    btnEdit.setBounds(12, 500, 90, 25);
    this.contentPanel.add(btnEdit);
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
  
  public JTextField getTextPoin() {
    return this.textPoin;
  }
  
  public void setTextPoin(JTextField textPoin) {
    this.textPoin = textPoin;
  }
  
  public JTextField getPasswordField() {
    return this.passwordField;
  }
  
  public void setPasswordField(JPasswordField passwordField) {
    this.passwordField = passwordField;
  }
  
  public JTextField getTextFieldUser() {
    return this.textField;
  }
  
  public void setTextField(JTextField textField) {
    this.textField = textField;
  }
  
  public JTextField getTextField_1() {
    return this.textField_1;
  }
  
  public void setTextField_1(JTextField textField_1) {
    this.textField_1 = textField_1;
  }
  
  public JTextField getTextField_2() {
    return this.textField_2;
  }
  
  public void setTextField_2(JTextField textField_2) {
    this.textField_2 = textField_2;
  }
  
  private void insert() {
    this.controller.insertPelanggan(this);
    this.textField.setText("");
    this.textField_1.setText("");
    this.passwordField.setText("");
    this.textPoin.setText("");
  }
  
  private void updatePelanggan() {
    this.controller.updatePelanggan(this);
    this.textField.setText("");
    this.textField_1.setText("");
    this.passwordField.setText("");
    this.textPoin.setText("");
  }
  
  private void deletePelanggan() {
    this.controller.deletePelanggan(this);
    this.textField.setText("");
    this.textField_1.setText("");
    this.passwordField.setText("");
    this.textPoin.setText("");
  }
  
  private void clik() {
    Pelanggan pelangan = this.tableModel.get(this.table.getSelectedRow());
    this.textField.setText(pelangan.getId_pelanggan());
    this.passwordField.setText(pelangan.getNo_hp());
    this.textField_1.setText(pelangan.getNama_pelanggan());
    this.textPoin.setText(String.valueOf(pelangan.getPoin()));
  }
}
