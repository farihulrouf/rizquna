package view.dialog;
 

import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import com.silver.con2.AdminDatabase;
import com.silver.dao.DaoPengguna;
import com.silver.dao.ErrorInfo;
import com.silver.data.Pegawai;
import com.silver.data.UserSession;
import view.AdminKasir;
import view.Koneksi;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class viewLogin extends JDialog {
  private final JPanel contentPanel = new JPanel();
  
  private JTextField txtUsername;
  
  private JPasswordField pf;
  
  private UserSession seseion;
  
  static int i = 0;
  
  static String username;
  
  String loginusername;
  
  String loginpassword;
  
  static String password;
  
  public static void main(String[] args) {
    try {
      McWinLookAndFeel.setTheme("Large-Font", "Java Swing", "");
      UIManager.setLookAndFeel(
          "com.jtattoo.plaf.mcwin.McWinLookAndFeel");
      viewLogin dialog = new viewLogin();
      dialog.setDefaultCloseOperation(2);
      dialog.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public viewLogin() {
    setBounds(100, 100, 450, 300);
    getContentPane().setLayout(new BorderLayout());
    this.contentPanel.setBackground(new Color(128, 128, 128));
    this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    this.seseion = new UserSession();
    getContentPane().add(this.contentPanel, "Center");
    this.contentPanel.setLayout((LayoutManager)null);
    JPanel panel = new JPanel();
    panel.setBackground(new Color(102, 204, 255));
    panel.setBounds(35, 36, 389, 195);
    this.contentPanel.add(panel);
    panel.setLayout((LayoutManager)null);
    this.txtUsername = new JTextField();
    this.txtUsername.setBounds(125, 42, 230, 33);
    panel.add(this.txtUsername);
    this.txtUsername.setColumns(10);
    this.pf = new JPasswordField();
    this.pf.setBounds(125, 110, 230, 33);
    panel.add(this.pf);
    JLabel lblUser = new JLabel("User");
    lblUser.setBounds(12, 51, 70, 15);
    panel.add(lblUser);
    JLabel lblPassword = new JLabel("Password");
    lblPassword.setBounds(12, 119, 70, 15);
    panel.add(lblPassword);
    JLabel lblSelamatDatangDi = new JLabel("Selamat Datang di Toko Rahmat ");
    lblSelamatDatangDi.setFont(new Font("Dialog", 1, 14));
    lblSelamatDatangDi.setForeground(new Color(50, 205, 50));
    lblSelamatDatangDi.setBounds(124, 12, 280, 15);
    this.contentPanel.add(lblSelamatDatangDi);
    JPanel buttonPane = new JPanel();
    buttonPane.setLayout(new FlowLayout(2));
    getContentPane().add(buttonPane, "South");
    JButton okButton = new JButton("OK");
    okButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            viewLogin.this.validasi();
            viewLogin.this.dispose();
          }
        });
    okButton.setActionCommand("OK");
    buttonPane.add(okButton);
    getRootPane().setDefaultButton(okButton);
    JButton cancelButton = new JButton("Cancel");
    cancelButton.setActionCommand("Cancel");
    buttonPane.add(cancelButton);
  }
  
  private void validasi() {
    int rowCount = 0;
    Pegawai pegawai = new Pegawai();
    pegawai.setUser_name(this.txtUsername.getText());
    pegawai.setPassword(this.pf.getText());
    try {
      DaoPengguna dao = AdminDatabase.getDaoPengguna();
      try {
        if (this.txtUsername.getText().equals("")) {
          JOptionPane.showMessageDialog(null, "Username masih kosong");
        } else if (this.pf.getText().equals("")) {
          JOptionPane.showMessageDialog(null, "Username masih kosong");
        } else {
          rowCount = dao.selectCount(pegawai);
        } 
      } catch (ErrorInfo ex) {
        Logger.getLogger(viewLogin.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
      } 
    } catch (SQLException sQLException) {}
    if (rowCount == 2) {
      UserSession.setUserLogin(this.txtUsername.getText());
      dispose();
    } else if (rowCount == 3) {
      UserSession.setUserLogin(this.txtUsername.getText());
      (new AdminKasir()).setVisible(true);
      dispose();
    } else if (i < 3) {
      JOptionPane.showMessageDialog(this, "invalid login");
      i++;
      (new viewLogin()).setVisible(true);
    } else {
      System.exit(0);
    } 
  }
  
  public static Boolean statusLogin() {
    Boolean status = Boolean.valueOf(false);
    PreparedStatement prepare = null;
    Connection konek = null;
    try {
      konek = Koneksi.getKoneksi();
      String sql = " SELECT * FROM  login  WHERE username = ?  AND password = ? ";
      prepare = konek.prepareStatement(sql);
      prepare.setString(1, username);
      prepare.setString(2, password);
      ResultSet rec = prepare.executeQuery();
      if (rec.next()) {
        status = Boolean.valueOf(true);
      } else {
        JOptionPane.showMessageDialog(null, "Username / Password salah");
      } 
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage());
      e.printStackTrace();
    } 
    try {
      if (prepare != null) {
        prepare.close();
        konek.close();
      } 
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    } 
    return status;
  }
  
  public static void bukaLogin() {
    viewLogin login = new viewLogin();
    login.setModal(true);
    login.setVisible(true);
    username = login.loginusername;
    password = login.loginpassword;
    if (!statusLogin().booleanValue())
      bukaLogin(); 
  }
}
