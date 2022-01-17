package view.dialog;

 
import com.silver.model.table.TableModelPemasok;
import view.AdminKasir;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

public class viewKonfirmasi extends JDialog {
  private String nama_dokter;
  
  private int id_dokter;
  
  private static final long serialVersionUID = -6771272602999625537L;
  
  public int getId_dokter() {
    return this.id_dokter;
  }
  
  public void setId_dokter(int id_dokter) {
    this.id_dokter = id_dokter;
  }
  
  private final JPanel contentPanel = new JPanel();
  
  private TableModelPemasok tableModel;
  
  private JPasswordField passwordField;
  
  private String password;
  
  public String getPassword() {
    return this.password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public boolean verivikasi() {
    if (getPassword().equals("amin") || 
      getPassword().equals("200468") || 
      getPassword().equals("999edys"))
      return true; 
    return false;
  }
  
  private void init() {
    setBounds(600, 200, 200, 120);
    getContentPane().setLayout(new BorderLayout());
    this.contentPanel.setBackground(new Color(204, 255, 102));
    this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(this.contentPanel, "Center");
    this.contentPanel.setLayout((LayoutManager)null);
    this.passwordField = new JPasswordField();
    this.passwordField.setBounds(12, 12, 176, 28);
    this.contentPanel.add(this.passwordField);
    JPanel buttonPane = new JPanel();
    buttonPane.setLayout(new FlowLayout(2));
    getContentPane().add(buttonPane, "South");
    JButton okButton = new JButton("OK");
    okButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            viewKonfirmasi.this.jButtonSaveActionPerformed(arg0);
          }
        });
    okButton.setActionCommand("OK");
    buttonPane.add(okButton);
    getRootPane().setDefaultButton(okButton);
    JButton cancelButton = new JButton("Cancel");
    cancelButton.setActionCommand("Cancel");
    buttonPane.add(cancelButton);
  }
  
  public String getNama_dokter() {
    return this.nama_dokter;
  }
  
  public void setNama_dokter(String nama_dokter) {
    this.nama_dokter = nama_dokter;
  }
  
  public viewKonfirmasi(AdminKasir parent, boolean modal) {
    setModal(true);
    init();
    setLocationRelativeTo((Component)parent);
  }
  
  public void viewKonfirmasi() {
    setVisible(true);
  }
  
  private void jButtonSaveActionPerformed(ActionEvent evt) {
    setPassword(this.passwordField.getText());
    dispose();
  }
}
