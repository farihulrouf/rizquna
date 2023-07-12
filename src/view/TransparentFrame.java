package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
 
public class TransparentFrame extends JFrame {
 
    private JPanel contentPane;
 
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TransparentFrame frame = new TransparentFrame();
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
    public TransparentFrame() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 670, 465);
        setLocationRelativeTo(null);
        setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
        contentPane = new JPanel();
        contentPane.setForeground(new Color(1.0f, 1.0f, 1.0f, 0.2f));
        contentPane.setBorder(null);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.2f));
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.2f));
        panel.setBounds(10, 11, 650, 56);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JButton btnNewButton = new JButton("CLOSE");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnNewButton.setBounds(279, 11, 89, 34);
        panel.add(btnNewButton);
    }
 
}