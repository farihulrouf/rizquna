package view.dialog;
 

import com.silver.con2.AdminDatabase;
import com.silver.controller.ControllerPengguna;
import com.silver.dao.DaoPengguna;
import com.silver.dao.ErrorInfo;
import com.silver.data.Pegawai;
import com.silver.model.ModelPegawai;
import com.silver.model.table.TableModelPegawai;
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

public class viewPegawai extends JDialog {
  private final JPanel contentPanel = new JPanel();
  
  private JTextField textField;
  
  private JTextField textField_1;
  
  private JPasswordField passwordField;
  
  private JTextField textField_2;
  
  private JTable table;
  
  private ModelPegawai model;
  
  private TableModelPegawai tableModel;
  
  private ControllerPengguna controller;
  
  private void cariPengguna() throws ErrorInfo, SQLException {
    this.tableModel.fireTableDataChanged();
    DaoPengguna dao = AdminDatabase.getDaoPengguna();
    this.tableModel.setList(dao.selectAll(this.textField_2.getText()));
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
  
  public viewPegawai() {
    setBounds(100, 100, 600, 400);
    this.model = new ModelPegawai();
    this.tableModel = new TableModelPegawai();
    this.controller = new ControllerPengguna();
    this.controller.setModel(this.model);
    getContentPane().setLayout(new BorderLayout());
    this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(this.contentPanel, "Center");
    this.contentPanel.setLayout((LayoutManager)null);
    JLabel lblUserName = new JLabel("User Name");
    lblUserName.setBounds(43, 122, 115, 15);
    this.contentPanel.add(lblUserName);
    JLabel lblNamaLengkap = new JLabel("Nama Lengkap");
    lblNamaLengkap.setBounds(43, 180, 115, 15);
    this.contentPanel.add(lblNamaLengkap);
    this.textField = new JTextField();
    this.textField.setBounds(191, 120, 135, 27);
    this.contentPanel.add(this.textField);
    this.textField.setColumns(10);
    this.textField_1 = new JTextField();
    this.textField_1.setBounds(191, 178, 135, 27);
    this.contentPanel.add(this.textField_1);
    this.textField_1.setColumns(10);
    JLabel lblPassword = new JLabel("Password");
    lblPassword.setBounds(43, 239, 70, 15);
    this.contentPanel.add(lblPassword);
    this.passwordField = new JPasswordField();
    this.passwordField.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            viewPegawai.this.insert();
          }
        });
    this.passwordField.setBounds(189, 233, 137, 27);
    this.contentPanel.add(this.passwordField);
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(347, 79, 228, 246);
    this.contentPanel.add(scrollPane);
    this.table = new JTable();
    this.table.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent e) {
            viewPegawai.this.clik();
          }
        });
    scrollPane.setViewportView(this.table);
    this.textField_2 = new JTextField();
    this.textField_2.addKeyListener(new KeyAdapter() {
          public void keyTyped(KeyEvent e) {
            viewPegawai.this.table.setModel((TableModel)viewPegawai.this.tableModel);
            try {
              viewPegawai.this.cariPengguna();
            } catch (ErrorInfo e1) {
              e1.printStackTrace();
            } catch (SQLException e1) {
              e1.printStackTrace();
            } 
          }
        });
    this.textField_2.setBounds(367, 24, 208, 32);
    this.contentPanel.add(this.textField_2);
    this.textField_2.setColumns(10);
    JButton btnTambah = new JButton("Tambah");
    btnTambah.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            viewPegawai.this.insert();
          }
        });
    btnTambah.setBounds(245, 286, 90, 25);
    this.contentPanel.add(btnTambah);
    JButton btnHapus = new JButton("Hapus");
    btnHapus.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            viewPegawai.this.deletePengguna();
          }
        });
    btnHapus.setBounds(131, 286, 90, 25);
    this.contentPanel.add(btnHapus);
    JButton btnEdit = new JButton("edit");
    btnEdit.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            viewPegawai.this.updatePengguna();
          }
        });
    btnEdit.setBounds(12, 286, 90, 25);
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
  
  public JPasswordField getPasswordField() {
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
    this.controller.insertPengguna(this);
    this.textField.setText("");
    this.textField_1.setText("");
    this.passwordField.setText("");
  }
  
  private void updatePengguna() {
    this.controller.updatePegawai(this);
    this.textField.setText("");
    this.textField_1.setText("");
    this.passwordField.setText("");
  }
  
  private void deletePengguna() {
    this.controller.deletePengguna(this);
    this.textField.setText("");
    this.textField_1.setText("");
    this.passwordField.setText("");
  }
  
  private void clik() {
    Pegawai pegawai = this.tableModel.get(this.table.getSelectedRow());
    this.textField.setText(pegawai.getUser_name());
    this.passwordField.setText(pegawai.getPassword());
    this.textField_1.setText(pegawai.getNama_pegawai());
  }
}
