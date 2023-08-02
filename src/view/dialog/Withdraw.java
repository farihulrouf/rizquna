package view.dialog;

 
import com.silver.con2.MappindTututpToko;
import com.silver.con2.MappingPerPc;
import com.silver.dao.DaoPerPc;
import com.silver.dao.DaoTutupToko;
import com.silver.dao.ErrorInfo;
import com.silver.model.table.TableModelTutup;
import com.silver.model.table.TableModelTutup2;
import com.silver.model.table.tableModelPerPc;
import com.toedter.calendar.JDateChooser;
import view.Koneksi;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

public class Withdraw extends JDialog {
  SimpleDateFormat dataFormatTanggal = new SimpleDateFormat("yyy-MM-dd");
  
  private final JPanel contentPanel = new JPanel();
  
  private JTextField textField;
  
  private JTextField textField_1;
  
  private tableModelPerPc tableModel2;
  
  private TableModelTutup2 tableModel3;
  
  private JDateChooser dateChooser_1;
  
  Locale locale = new Locale("en", "UK");
  
  private JTextField txtTotal;
  
  DecimalFormat df = (DecimalFormat)NumberFormat.getNumberInstance(this.locale);
  
  private JDateChooser dateChooser;
  
  private TableModelTutup tableModel;
  
  int waktumulai = 0;
  
  private JLabel lblNewLabel;
  
  private JTextField textField_2;
  
  private JTable table;
  
  private JTable table_1;
  
  private JTextField textField_3;
  
  private JTextField textTotal;
  
  private int i;
  
  private void Tampilkan(String tanggal1, String tanggal2) throws ErrorInfo, SQLException {
    this.table.setModel((TableModel)this.tableModel);
    this.tableModel.fireTableDataChanged();
    DaoTutupToko dao = MappindTututpToko.getDaoTutupToko();
    this.tableModel.setList(dao.selectDari(tanggal1, tanggal2));
  }
  
  private void Tampilkan2(String tanggal1, String tanggal2) throws ErrorInfo, SQLException {
    this.table_1.setModel((TableModel)this.tableModel3);
    this.tableModel3.fireTableDataChanged();
    DaoTutupToko dao = MappindTututpToko.getDaoTutupToko();
    this.tableModel3.setList(dao.selectDari2(tanggal1, tanggal2));
  }
  
  private void TampilkanPerpc() throws ErrorInfo, SQLException {
    this.tableModel2.fireTableDataChanged();
    DaoPerPc dao = MappingPerPc.geDaoPerPc();
    this.tableModel2.setList(dao.selectAll());
  }
  
  public double hitung_total2() {
    double total = 0.0D;
    if (this.table_1.getRowCount() < 1)
      return 0.0D; 
    for (int i = 0; i < this.table_1.getRowCount(); i++)
      total += Double.parseDouble(((String)this.table_1.getValueAt(i, 2)).replace(",", "")); 
    return total;
  }
  
  void totalFull() {
    double total = 0.0D;
    DecimalFormat dfx = 
      (DecimalFormat)NumberFormat.getNumberInstance(this.locale);
    total = hitung_total() + hitung_total2();
    this.textTotal.setText(dfx.format(total));
  }
  
  public double hitung_total() {
    double total = 0.0D;
    if (this.table.getRowCount() < 1)
      return 0.0D; 
    for (int i = 0; i < this.table.getRowCount(); i++)
      total += Double.parseDouble(((String)this.table.getValueAt(i, 2)).replace(",", "")); 
    return total;
  }
  
  public Withdraw(String jam) {
    setBounds(100, 100, 1100, 600);
    this.tableModel = new TableModelTutup();
    this.tableModel3 = new TableModelTutup2();
    this.tableModel2 = new tableModelPerPc();
    getContentPane().setLayout(new BorderLayout());
    this.contentPanel.setBackground(new Color(135, 206, 250));
    this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(this.contentPanel, "Center");
    this.contentPanel.setLayout((LayoutManager)null);
    JLabel lblYangBerjalanSaat = new JLabel("Yang Berjalan Saat Ini");
    lblYangBerjalanSaat.setFont(new Font("Dialog", 1, 13));
    lblYangBerjalanSaat.setBounds(12, 294, 188, 37);
    JButton btnHitungTotal = new JButton("Hitung Total");
    btnHitungTotal.setBounds(359, 450, 151, 25);
    this.contentPanel.add(btnHitungTotal);
    this.textTotal = new JTextField();
    this.textTotal.setFont(new Font("Dialog", 1, 30));
    this.textTotal.setColumns(10);
    this.textTotal.setBounds(346, 400, 350, 37);
    this.contentPanel.add(this.textTotal);
    JButton btnNewButton = new JButton("Lihat");
    /*
    btnNewButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            try {
              Withdraw.this.Tampilkan(String.valueOf(Withdraw.this.dataFormatTanggal.format(Withdraw.this.dateChooser.getDate())), 
                  Withdraw.this.dataFormatTanggal.format(Withdraw.this.dateChooser_1.getDate()));
              Withdraw.this.Tampilkan2(String.valueOf(Withdraw.this.dataFormatTanggal.format(Withdraw.this.dateChooser.getDate())), 
                  Withdraw.this.dataFormatTanggal.format(Withdraw.this.dateChooser_1.getDate()));
            } catch (ErrorInfo|SQLException e) {
              e.printStackTrace();
            } 
          }
        });
        */
    btnNewButton.setBounds(37, 12, 117, 25);
    this.contentPanel.add(btnNewButton);
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(23, 68, 487, 300);
    this.contentPanel.add(scrollPane);
    this.table = new JTable();
    this.table.setBackground(new Color(255, 140, 0));
    this.table.setFont(new Font("Dialog", 1, 23));
    this.table.setRowHeight(50);
    scrollPane.setViewportView(this.table);
    JScrollPane scrollPane_1 = new JScrollPane();
    scrollPane_1.setBounds(531, 68, 500, 300);
    this.contentPanel.add(scrollPane_1);
    this.table_1 = new JTable();
    this.table_1.setRowHeight(50);
    this.table_1.setBackground(new Color(255, 140, 0));
    this.table_1.setFont(new Font("Dialog", 1, 23));
    scrollPane_1.setViewportView(this.table_1);
    this.dateChooser = new JDateChooser(new Date());
    this.dateChooser.setBounds(288, 18, 170, 75);
    this.dateChooser_1 = new JDateChooser(new Date());
    this.dateChooser_1.addPropertyChangeListener(new PropertyChangeListener() {
          public void propertyChange(PropertyChangeEvent evt) {
            try {
              Withdraw.this.Tampilkan(String.valueOf(Withdraw.this.dataFormatTanggal.format(Withdraw.this.dateChooser.getDate())), 
                  Withdraw.this.dataFormatTanggal.format(Withdraw.this.dateChooser_1.getDate()));
              Withdraw.this.Tampilkan2(String.valueOf(Withdraw.this.dataFormatTanggal.format(Withdraw.this.dateChooser.getDate())), 
                  Withdraw.this.dataFormatTanggal.format(Withdraw.this.dateChooser_1.getDate()));
              Withdraw.this.totalFull();
            } catch (ErrorInfo|SQLException y) {
              y.printStackTrace();
            } 
          }
        });
    this.dateChooser_1.setBounds(531, 18, 179, 19);
    this.contentPanel.add((Component)this.dateChooser_1);
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
  //  autoNumber4(jam);
   // autoNumber3(jam);
  }
  
  private void autoNumber3(String jam) {
    try {
      Connection konek = Koneksi.getKoneksi();
      String satu = ">'" + jam + "'" + "and tanggal = curdate()";
      Statement state = konek.createStatement();
      String query = "select sum(total) from jual where id_kasir='eka' && jam" + satu + ";";
      ResultSet rs = state.executeQuery(query);
      while (rs.next()) {
        if (!rs.first()) {
          this.textField.setText("0");
          continue;
        } 
        rs.last();
        Double total = Double.valueOf(rs.getDouble(1));
        this.textField.setText(this.df.format(total));
      } 
      rs.close();
      state.close();
    } catch (Exception exception) {}
  }
  
  private void autoNumber4(String jam) {
    try {
      Connection konek = Koneksi.getKoneksi();
      String satu = ">'" + jam + "'" + "and tanggal = curdate()";
      Statement state = konek.createStatement();
      String query = "select sum(total) from jual where  jam" + satu + ";";
      ResultSet rs = state.executeQuery(query);
      while (rs.next()) {
        if (!rs.first()) {
          this.textField.setText("0");
          continue;
        } 
        rs.last();
        Double total = Double.valueOf(rs.getDouble(1));
        this.textField_2.setText(this.df.format(total));
      } 
      rs.close();
      state.close();
    } catch (Exception exception) {}
  }
}
