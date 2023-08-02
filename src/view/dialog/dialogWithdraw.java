package view.dialog;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import com.silver.con2.MappindTututpToko;
import com.silver.dao.DaoTutupToko;
import com.silver.dao.ErrorInfo;
import com.silver.model.table.TableModelTutup;
import com.toedter.calendar.JDateChooser;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dialogWithdraw extends JDialog {
	  SimpleDateFormat dataFormatTanggal = new SimpleDateFormat("yyy-MM-dd");

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTable table_1;
	  private TableModelTutup tableModel;

	  private JDateChooser dateChooser_1;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			dialogWithdraw dialog = new dialogWithdraw();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/

	/**
	 * Create the dialog.
	 */
	public dialogWithdraw(String jam) {
		setBounds(100, 100, 900, 600);
		getContentPane().setLayout(new BorderLayout());
	    this.tableModel = new TableModelTutup();

		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 74, 423, 297);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(461, 74, 416, 297);
		contentPanel.add(scrollPane_1);
	    this.dateChooser_1 = new JDateChooser(new Date());
	   
	    this.dateChooser_1.setBounds(531, 18, 179, 19);
	    
	    this.contentPanel.add((Component)this.dateChooser_1);
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JButton btnNewButton = new JButton("Lihat");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Tampilkan("2023-07-12","2023-07-12");
				} catch (ErrorInfo | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(308, 8, 117, 29);
		contentPanel.add(btnNewButton);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void Tampilkan(String tanggal1, String tanggal2) throws ErrorInfo, SQLException {
		System.out.println("di eksekusi");
	    table.setModel((TableModel)this.tableModel);
	    this.tableModel.fireTableDataChanged();
	    DaoTutupToko dao = MappindTututpToko.getDaoTutupToko();
	    this.tableModel.setList(dao.selectDari(tanggal1, tanggal2));
	    System.out.println("di eksekusi");
	  }
}
