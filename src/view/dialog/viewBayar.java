package view.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.AdminKasir;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class viewBayar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblByar;
	private JTextField textField;
	private JLabel lblNewLabel_1, lblNewLabel_3;
	private JLabel  lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JPanel panel_1;
	private String idPegawai;
	private JLabel lblNewLabel_7;
	private JPanel panel_2;
	/**
	 * Launch the application.
	 */

	public String getIdPegawai() {
		return idPegawai;
	}
	public void setIdPegawai(String idPegawai) {
		this.idPegawai = idPegawai;
	}
	/**
	 * Create the dialog.
	 */
	public viewBayar(String total, String poin, String nama_pelanggan, String idPegawai) {
		setUndecorated(true);
		setBounds(400, 300, 500, 350);
		setBackground(new Color(1.0F, 1.0F, 1.0F, 0.0F));
		getContentPane().setLayout(new BorderLayout());
		//lblByar = new JLabel(total);
		this.lblByar = new JLabel(total);
		this.lblByar.setBounds(5, 2, 100, 35);
	   
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setIdPegawai(idPegawai);
	   // getContentPane().setLayout(new BorderLayout());
	    this.contentPanel.setBackground(new Color(0.1F, 0.1F, 0.1F, 0.0F));
	    this.contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel_4 = new JLabel("Kembali");
			lblNewLabel_4.setBounds(41, 247, 128, 25);
			lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
			contentPanel.add(lblNewLabel_4);
		}
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 6, 500, 128);
		panel.setBackground(new Color(64, 224, 208));
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Total Bayar");
			lblNewLabel.setBounds(31, 18, 125, 28);
			panel.add(lblNewLabel);
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		}
		{
		    lblNewLabel_1 = new JLabel(total);
		    lblNewLabel_1.setBounds(173, 6, 250, 40);
		    panel.add(lblNewLabel_1);
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		}
		{
			panel_1 = new JPanel();
			panel_1.setBounds(113, 58, 267, 40);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
	    lblNewLabel_6 = new JLabel(nama_pelanggan);
	    lblNewLabel_6.setBounds(31, 0, 230, 40);
	    panel_1.add(lblNewLabel_6);
	    lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Total Poin");
			lblNewLabel_2.setBounds(54, 106, 150, 16);
			panel.add(lblNewLabel_2);
			lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		}
		{
		    lblNewLabel_3 = new JLabel(poin);
		    lblNewLabel_3.setBounds(278, 89, 122, 50);
		    panel.add(lblNewLabel_3);
			lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		}
		
		textField = new JTextField();
		textField.setBounds(141, 146, 201, 40);
		contentPanel.add(textField);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				  
			            int keyCode = e.getKeyCode();
			            switch (keyCode) {
			              case 40:
			            	   viewBayar.this.dispose();
			                break;
			         
			            } 
			          
			}
		});
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BayarUang();
			}
		});
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		textField.setColumns(10);
		
			lblNewLabel_7 = new JLabel("");
			lblNewLabel_7.setForeground(new Color(218, 112, 214));
			lblNewLabel_7.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblNewLabel_7.setBounds(102, 185, 326, 50);
			contentPanel.add(lblNewLabel_7);
			{
				panel_2 = new JPanel();
				panel_2.setBounds(163, 234, 232, 66);
				contentPanel.add(panel_2);
				panel_2.setLayout(null);
				{
				    lblNewLabel_5 = new JLabel("0");
				    lblNewLabel_5.setBounds(6, 18, 209, 42);
				    panel_2.add(lblNewLabel_5);
					lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
				}
			}
	
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			
		}
	    setVisible(true);

	}
	private void BayarUang() {
		//lblNewLabel_1.getText();
	    String str = 	lblNewLabel_1.getText();
	   Locale locale = new Locale("en", "UK");

	   DecimalFormat df = (DecimalFormat)NumberFormat.getNumberInstance(locale);

		//String strNew = str.replaceFirst(",", "");
	    Double harga = Double.valueOf(Double.parseDouble(str.replace(",", "")));
	    Double total_bayar =  Double.valueOf(Double.parseDouble(textField.getText()));
	    //lblNewLabel_3
	    Double poin =  Double.valueOf(Double.parseDouble(lblNewLabel_3.getText()));
	    if(total_bayar>= harga) {
	    	lblNewLabel_7.setForeground(new Color(64, 224, 208));
	    	lblNewLabel_7.setText("Transaksi Sukses");
	    	
	    	
	    
	    	//int reply = JOptionPane.showConfirmDialog(null, "kaamu jawab y", "message", JOptionPane.YES_NO_OPTION);

            JOptionPane.showMessageDialog(this, "Kamu menjawab ya");

	    	AdminKasir.insertPenjualan(df.format(total_bayar-harga), textField.getText() );
	    	lblNewLabel_5.setText(df.format(total_bayar-harga));
	    	//AdminKasir adminKasir = new AdminKasir();
		//	adminKasir.insertPenjualan(harga, total_bayar,  (total_bayar - harga), poin, getIdPegawai());
	    //	lblNewLabel_5.setText((total_bayar - harga)+"");
	    	
	    	//AdminKasir adminKasir = new AdminKasir();
	    	//AdminKasir.resetTransaksi();
			//transaksi(harga, total_bayar, (total_bayar - harga), poin);
	    	//lblNewLabel_5.setText((total_bayar - harga)+"");
	    	
	    	//adminKasir.clearPelanggan();
	    }
	    else {
	    	lblNewLabel_7.setText("Uang  "+ textField.getText() +" kurang");
	    }
	}
	
	
	
	
	private void transaksi(Double harga, Double total_bayar, Double kembali, Double poin) {
		/*AdminKasir adminKasir = new AdminKasir();
		adminKasir.insertPenjualan(harga, total_bayar, kembali, poin);
    	lblNewLabel_5.setText((total_bayar - harga)+"");
    	*/
		
	}
}
