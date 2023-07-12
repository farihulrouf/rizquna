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
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public viewBayar(String total, String poin) {
		setUndecorated(true);
		setBounds(400, 300, 500, 300);
		setBackground(new Color(1.0F, 1.0F, 1.0F, 0.0F));
		getContentPane().setLayout(new BorderLayout());
		//lblByar = new JLabel(total);
		this.lblByar = new JLabel(total);
		this.lblByar.setBounds(5, 2, 100, 35);
	   
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
	   // getContentPane().setLayout(new BorderLayout());
	    this.contentPanel.setBackground(new Color(0.1F, 0.1F, 0.1F, 0.0F));
	    this.contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Total Bayar");
			lblNewLabel.setBounds(34, 62, 150, 30);
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
			contentPanel.add(lblNewLabel);
		}
		{
		    lblNewLabel_1 = new JLabel(total);
		    lblNewLabel_1.setBounds(196, 62, 250, 40);
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			contentPanel.add(lblNewLabel_1);
		}
		
		textField = new JTextField();
		textField.setBounds(111, 123, 265, 40);
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
		contentPanel.add(textField);
		textField.setColumns(10);
		{
			JLabel lblNewLabel_2 = new JLabel("Total Poin");
			lblNewLabel_2.setBounds(34, 19, 150, 16);
			lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
			contentPanel.add(lblNewLabel_2);
		}
		{
		    lblNewLabel_3 = new JLabel(poin);
		    lblNewLabel_3.setBounds(199, -5, 150, 50);
			lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Kembali");
			lblNewLabel_4.setBounds(34, 193, 128, 25);
			lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
			contentPanel.add(lblNewLabel_4);
		}
		{
		    lblNewLabel_5 = new JLabel("0");
		    lblNewLabel_5.setBounds(217, 175, 229, 67);
			lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
			contentPanel.add(lblNewLabel_5);
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
		String strNew = str.replaceFirst(",", "");
	    Double harga = Double.valueOf(Double.parseDouble(strNew));
	    Double total_bayar =  Double.valueOf(Double.parseDouble(textField.getText()));
	    //lblNewLabel_3
	    Double poin =  Double.valueOf(Double.parseDouble(lblNewLabel_3.getText()));
	    if(total_bayar>= harga) {
	    	System.out.println("sulses");
	    	AdminKasir adminKasir = new AdminKasir();
			adminKasir.insertPenjualan(harga, total_bayar, (total_bayar - harga), poin);
	    	lblNewLabel_5.setText((total_bayar - harga)+"");
	    	//AdminKasir.labelTotal.setText("0");
	    	//adminKasir.clearPelanggan();
	    }
	    else {
	    	System.out.println("Tidak");
	    }
	}
}
