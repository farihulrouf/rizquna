package view;

import simple.escp.Template;
import simple.escp.json.JsonTemplate;
import simple.escp.swing.PrintPreviewPane;
import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import com.silver.data.Fakturx;
import com.silver.data.ItemFakturx;

public class Cetak extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cetak frame = new Cetak();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cetak() {
		super("Latihan");

        Fakturx faktur = new Fakturx("FA-1234-556677-XX-BB-CC","farihul","12:23","50000","50000","49999", "12-2023");
        
        for(int i=0;i<=10;i++) {
        	faktur.tambahItemFakturx(new ItemFakturx("Plantronics Backbeat",
                    "1", "600,000",  "600,000"));
        }
      
        Template template  = null;
        try {
        	//   jsonTemplate = new JsonTemplate(Main.class.getResourceAsStream("templatedua.json"));

            template = new JsonTemplate(Cetak.class.getResourceAsStream("faktur.json"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
       PrintPreviewPane preview = new PrintPreviewPane(template, null, faktur);
        setLayout(new BorderLayout());
        add(preview, BorderLayout.CENTER);
 
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}

}
