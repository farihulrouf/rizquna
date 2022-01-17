package view.dialog;
 

import com.silver.con2.MappingLaporanJam;
import com.silver.dao.DaoHasilPerjam;
import com.silver.dao.ErrorInfo;
import com.silver.model.table.TableModelJam;
import com.silver.model.table.TableModelJam2;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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
import javax.swing.table.TableModel;

public class viewSejarah extends JDialog {
  private final JPanel contentPanel = new JPanel();
  
  private JTable table;
  
  private JTextField textField;
  
  private JTextField textField_1;
  
  private TableModelJam tableModel;
  
  private TableModelJam2 tableModel2;
  
  private JTable table_1;
  
  private JDateChooser dateChooser;
  
  private JDateChooser dateChooser_1;
  
  SimpleDateFormat dataFormatTanggal = new SimpleDateFormat("yyy-MM-dd");
  
  Locale locale = new Locale("en", "UK");
  
  DecimalFormat df = (DecimalFormat)NumberFormat.getNumberInstance(this.locale);
  
  private JTextField textField_2;
  
  public static void main(String[] args) {
    try {
      viewSejarah dialog = new viewSejarah();
      dialog.setDefaultCloseOperation(2);
      dialog.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  private void lihat_hasil(String dari, String ke) throws ErrorInfo, SQLException {
    this.tableModel.fireTableDataChanged();
    DaoHasilPerjam dao = MappingLaporanJam.getDaoHasilPerjam();
    this.tableModel.setList(dao.pilihTanggal(dari, ke));
  }
  
  private void lihat_hasil2(String dari, String ke) throws ErrorInfo, SQLException {
    this.tableModel2.fireTableDataChanged();
    DaoHasilPerjam dao = MappingLaporanJam.getDaoHasilPerjam();
    this.tableModel2.setList(dao.pilihTanggal2(dari, ke));
  }
  
  public viewSejarah() {
    setBounds(100, 100, 750, 500);
    this.tableModel = new TableModelJam();
    this.tableModel2 = new TableModelJam2();
    getContentPane().setLayout(new BorderLayout());
    this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(this.contentPanel, "Center");
    this.contentPanel.setLayout((LayoutManager)null);
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(23, 39, 358, 243);
    this.contentPanel.add(scrollPane);
    this.table = new JTable();
    scrollPane.setViewportView(this.table);
    this.textField = new JTextField();
    this.textField.setFont(new Font("Dialog", 1, 20));
    this.textField.setBounds(207, 288, 165, 31);
    this.contentPanel.add(this.textField);
    this.textField.setColumns(10);
    this.textField_1 = new JTextField();
    this.textField_1.setFont(new Font("Dialog", 1, 20));
    this.textField_1.setColumns(10);
    this.textField_1.setBounds(403, 288, 165, 31);
    this.contentPanel.add(this.textField_1);
    JButton btnLihat = new JButton("Prosess");
    btnLihat.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            viewSejarah.this.table.setModel((TableModel)viewSejarah.this.tableModel);
            viewSejarah.this.table_1.setModel((TableModel)viewSejarah.this.tableModel2);
            try {
              viewSejarah.this.lihat_hasil(String.valueOf(viewSejarah.this.dataFormatTanggal.format(viewSejarah.this.dateChooser.getDate())), 
                  viewSejarah.this.dataFormatTanggal.format(viewSejarah.this.dateChooser_1.getDate()));
              viewSejarah.this.lihat_hasil2(String.valueOf(viewSejarah.this.dataFormatTanggal.format(viewSejarah.this.dateChooser.getDate())), 
                  viewSejarah.this.dataFormatTanggal.format(viewSejarah.this.dateChooser_1.getDate()));
              viewSejarah.this.hitung_total();
              viewSejarah.this.hitung_total2();
              viewSejarah.this.hitungAll();
            } catch (ErrorInfo e) {
              e.printStackTrace();
            } catch (SQLException e) {
              e.printStackTrace();
            } 
          }
        });
    btnLihat.setBounds(36, 2, 117, 25);
    this.contentPanel.add(btnLihat);
    JScrollPane scrollPane_1 = new JScrollPane();
    scrollPane_1.setBounds(393, 39, 345, 243);
    this.contentPanel.add(scrollPane_1);
    this.table_1 = new JTable();
    scrollPane_1.setViewportView(this.table_1);
    JButton btnTotal = new JButton("Total");
    btnTotal.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            viewSejarah.this.hitungAll();
          }
        });
    btnTotal.setBounds(355, 400, 117, 25);
    this.contentPanel.add(btnTotal);
    this.textField_2 = new JTextField();
    this.textField_2.setFont(new Font("Dialog", 1, 20));
    this.textField_2.setColumns(10);
    this.textField_2.setBounds(324, 331, 165, 31);
    this.contentPanel.add(this.textField_2);
    this.dateChooser = new JDateChooser(new Date());
    this.dateChooser.setBounds(242, 2, 142, 25);
    this.contentPanel.add((Component)this.dateChooser);
    this.dateChooser_1 = new JDateChooser(new Date());
    this.dateChooser_1.setBounds(400, 2, 142, 25);
    this.contentPanel.add((Component)this.dateChooser_1);
    JButton btnCetakKomputer = new JButton("Cetak Komputer 1");
    btnCetakKomputer.setBounds(23, 400, 193, 25);
    this.contentPanel.add(btnCetakKomputer);
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
  
  public void hitung_total() {
    Double total = Double.valueOf(0.0D);
    int transaksi = 0;
    for (int i = 0; i < this.table.getRowCount(); i++)
      total = Double.valueOf(total.doubleValue() + Double.parseDouble(((String)this.table.getValueAt(i, 2)).replace(",", ""))); 
    this.textField.setText(this.df.format(total));
  }
  
  public void hitung_total2() {
    Double total = Double.valueOf(0.0D);
    int transaksi = 0;
    for (int i = 0; i < this.table_1.getRowCount(); i++)
      total = Double.valueOf(total.doubleValue() + Double.parseDouble(((String)this.table_1.getValueAt(i, 2)).replace(",", ""))); 
    this.textField_1.setText(this.df.format(total));
  }
  
  private void hitungAll() {
    Double total = Double.valueOf(0.0D);
    total = Double.valueOf(Double.parseDouble(this.textField.getText().replace(",", "")) + 
        Double.parseDouble(this.textField_1.getText().replace(",", "")));
    this.textField_2.setText(this.df.format(total));
  }
}
