package view.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.AdminKasir;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class viewBayar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblByar;
	private JTextField textField;
	private JLabel lblNewLabel_1, lblNewLabel_3;
	private JLabel  lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JPanel panel_1;
	private String idPegawai;
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
			JLabel lblNewLabel_2 = new JLabel("Total Poin");
			lblNewLabel_2.setBounds(248, 237, 150, 16);
			lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Kembali");
			lblNewLabel_4.setBounds(40, 273, 128, 25);
			lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
			contentPanel.add(lblNewLabel_4);
		}
		{
		    lblNewLabel_5 = new JLabel("0");
		    lblNewLabel_5.setBounds(180, 248, 229, 67);
			lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
			contentPanel.add(lblNewLabel_5);
		}
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 224, 208));
		panel.setBounds(0, 6, 500, 154);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Total Bayar");
			lblNewLabel.setBounds(31, 32, 125, 28);
			panel.add(lblNewLabel);
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		}
		{
		    lblNewLabel_1 = new JLabel(total);
		    lblNewLabel_1.setBounds(169, 20, 250, 40);
		    panel.add(lblNewLabel_1);
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		}
		{
			panel_1 = new JPanel();
			panel_1.setBounds(114, 98, 267, 40);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
	    lblNewLabel_6 = new JLabel(nama_pelanggan);
	    lblNewLabel_6.setBounds(31, 0, 230, 40);
	    panel_1.add(lblNewLabel_6);
	    lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		}
		{
		    lblNewLabel_3 = new JLabel(poin);
		    lblNewLabel_3.setBounds(354, 220, 122, 50);
		    contentPanel.add(lblNewLabel_3);
			lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		}
		
		textField = new JTextField();
		textField.setBounds(141, 185, 201, 40);
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
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		textField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			
		}
	    setVisible(true);

	}
	private void BayarUang() {
		//lblNewLabel_1.getText();
	    String str = 	lblNewLabel_1.getText();
		String strNew = str.replaceFirst(",", "");
	    Double harga = Double.valueOf(Double.parseDouble(strNew));
	    Double total_bayar =  Double.valueOf(Double.parseDouble(textField.getText()));
	    //lblNewLabel_3
	    Double poin =  Double.valueOf(Double.parseDouble(lblNewLabel_3.getText()));
	    if(total_bayar>= harga) {
	    	System.out.println("sulses");
	    	
	    	AdminKasir adminKasir = new AdminKasir();
			adminKasir.insertPenjualan(harga, total_bayar,  (total_bayar - harga), poin, getIdPegawai());
	    	lblNewLabel_5.setText((total_bayar - harga)+"");
	    	
	    	//AdminKasir adminKasir = new AdminKasir();
	    	//AdminKasir.resetTransaksi();
			//transaksi(harga, total_bayar, (total_bayar - harga), poin);
	    	//lblNewLabel_5.setText((total_bayar - harga)+"");
	    	//adminKasir.clearPelanggan();
	    }
	    else {
	    	System.out.println("Tidak");
	    }
	}
	
	private void transaksi(Double harga, Double total_bayar, Double kembali, Double poin) {
		/*AdminKasir adminKasir = new AdminKasir();
		adminKasir.insertPenjualan(harga, total_bayar, kembali, poin);
    	lblNewLabel_5.setText((total_bayar - harga)+"");
    	*/
		
	}
}
