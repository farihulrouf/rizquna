package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingTester {
   public static void main(String[] args) {
      createWindow();
   }

   private static void createWindow() {    
      JFrame frame = new JFrame("Swing Tester");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      createUI(frame);
      frame.setSize(900, 700);      
      frame.setLocationRelativeTo(null);  
      frame.setVisible(true);
   }

   private static void createUI(final JFrame frame){  
      JPanel panel = new JPanel();
      LayoutManager layout = new FlowLayout();  
      panel.setLayout(layout);       

      JButton button = new JButton("Click Me!");
      final JDialog modelDialog = createDialog(frame);
      button.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            modelDialog.setVisible(true);
         }
      });

      panel.add(button);
      frame.getContentPane().add(panel, BorderLayout.CENTER);    
   }   

   private static JDialog createDialog(final JFrame frame){
      final JDialog modelDialog = new JDialog(frame, "Swing Tester", 
         Dialog.ModalityType.DOCUMENT_MODAL);
      modelDialog.setBounds(300, 300, 300, 200);
      Container dialogContainer = modelDialog.getContentPane();
      dialogContainer.setLayout(new BorderLayout());
      dialogContainer.add(new JLabel("                         Welcome to Swing!")
      , BorderLayout.CENTER);    
      JPanel panel1 = new JPanel();
      panel1.setLayout(new FlowLayout());
      JButton okButton = new JButton("Ok");
      okButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            modelDialog.setVisible(false);
         }
      });

      panel1.add(okButton);
      dialogContainer.add(panel1, BorderLayout.SOUTH);

      return modelDialog;
   }
} 