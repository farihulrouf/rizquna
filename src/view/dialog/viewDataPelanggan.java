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
import java.awt.Color;
import java.awt.Font;

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
  private JTextField textField_3;
  
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
    setBounds(100, 100, 1200, 600);
    this.model = new ModelPelanggan();
    this.tableModel = new TableModelPelanggan();
    this.controller = new ControllerPlanggan();
    this.controller.setModel(this.model);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBackground(new Color(64, 224, 208));
    this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(this.contentPanel, "Center");
    this.contentPanel.setLayout((LayoutManager)null);
    contentPanel.setLayout(null);
    contentPanel.setLayout(null);
    contentPanel.setLayout(null);
    contentPanel.setLayout(null);
    contentPanel.setLayout(null);
    JLabel lblUserName = new JLabel("NOMER");
    lblUserName.setBounds(43, 122, 115, 15);
    this.contentPanel.add(lblUserName);
    JLabel lblNamaLengkap = new JLabel("Nama Lengkap");
    lblNamaLengkap.setBounds(43, 180, 115, 15);
    this.contentPanel.add(lblNamaLengkap);
    this.textField = new JTextField();
    textField.setBounds(194, 103, 190, 52);
    textField.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
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
    this.contentPanel.add(this.textField);
    this.textField.setColumns(10);
    this.textField_1 = new JTextField();
    textField_1.setBounds(194, 178, 190, 40);
    textField_1.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
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
    this.contentPanel.add(this.textField_1);
    this.textField_1.setColumns(10);
    JLabel lblPassword = new JLabel("No HP");
    lblPassword.setBounds(43, 239, 70, 15);
    JLabel lblPoin = new JLabel("Jumlah Poin");
    lblPoin.setBounds(43, 300, 100, 15);
    this.contentPanel.add(lblPassword);
    this.contentPanel.add(lblPoin);
    this.passwordField = new JTextField();
    passwordField.setBounds(194, 230, 190, 40);
    passwordField.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
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
    this.textPoin = new JTextField();
    textPoin.setBounds(194, 282, 190, 40);
    textPoin.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
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
    this.contentPanel.add(this.textPoin);
    this.contentPanel.add(this.passwordField);
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(439, 82, 713, 400);
    this.contentPanel.add(scrollPane);
    this.table = new JTable();
    table.setRowHeight(38);
    table.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
    this.table.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent e) {
            viewDataPelanggan.this.clik();
          }
        });
    scrollPane.setViewportView(this.table);
    this.textField_2 = new JTextField();
    textField_2.setBounds(439, 23, 399, 32);
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
    btnLihat.setBounds(850, 24, 100, 32);
    this.btnTop = new JButton("Top");
    btnTop.setBounds(976, 24, 100, 32);
    this.btnTop.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            try {
              viewDataPelanggan.this.TopPelanggan();
            } catch (ErrorInfo|SQLException e1) {
              e1.printStackTrace();
            } 
          }
        });
    this.contentPanel.add(this.btnLihat);
    this.contentPanel.add(this.btnTop);
    this.contentPanel.add(this.textField_2);
    this.textField_2.setColumns(10);
    JButton btnTambah = new JButton("Tambah");
    btnTambah.setBounds(245, 500, 90, 25);
    btnTambah.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            viewDataPelanggan.this.insert();
          }
        });
    this.contentPanel.add(btnTambah);
    JButton btnHapus = new JButton("Hapus");
    btnHapus.setBounds(131, 500, 90, 25);
    btnHapus.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            viewDataPelanggan.this.deletePelanggan();
          }
        });
    
    JButton button = new JButton("New button");
    button.setBounds(0, 0, 0, 0);
    contentPanel.add(button);
    this.contentPanel.add(btnHapus);
    JButton btnEdit = new JButton("edit");
    btnEdit.setBounds(12, 500, 90, 25);
    btnEdit.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            viewDataPelanggan.this.updatePelanggan();
          }
        });
    this.contentPanel.add(btnEdit);
    
    textField_3 = new JTextField();
    textField_3.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		insert();
    	}
    });
    textField_3.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
    textField_3.setBounds(194, 350, 190, 40);
    contentPanel.add(textField_3);
    textField_3.setColumns(10);
    
    JLabel lblNewLabel = new JLabel("Uang");
    lblNewLabel.setBounds(43, 372, 61, 16);
    contentPanel.add(lblNewLabel);
    
    JButton btnNewButton = new JButton("clear");
    btnNewButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		resetPelanggan();
    	}
    });
    btnNewButton.setBounds(359, 500, 117, 29);
    contentPanel.add(btnNewButton);
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
    this.textField.requestFocus();
  }
  
  private void updatePelanggan() {
    this.controller.updatePelanggan(this);
    this.textField.setText("");
    this.textField_1.setText("");
    this.passwordField.setText("");
    this.textPoin.setText("");
    this.textField_3.setText("");

    this.textField.requestFocus();

  }
  
  private void deletePelanggan() {
    this.controller.deletePelanggan(this);
    this.textField.setText("");
    this.textField_1.setText("");
    this.passwordField.setText("");
    this.textPoin.setText("");
    this.textField_3.setText("");

    this.textField.requestFocus();
  }
  
  private void resetPelanggan() {
	  this.textField.setText("");
	    this.textField_1.setText("");
	    this.passwordField.setText("");
	    this.textPoin.setText("");
	    this.textField_3.setText("");
  }
  
  private void clik() {
    Pelanggan pelangan = this.tableModel.get(this.table.getSelectedRow());
    this.textField.setText(pelangan.getId_pelanggan());
    this.passwordField.setText(pelangan.getNo_hp());
    this.textField_1.setText(pelangan.getNama_pelanggan());
    this.textPoin.setText(String.valueOf(pelangan.getPoin()));
    this.textField_3.setText(String.valueOf(pelangan.getUang()));
    
  }
}
