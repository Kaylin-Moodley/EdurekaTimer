/*
Filename: EdurekaTimer.java         
Author: Kaylin Moodley
Created: 20/10/2020
Operating System: Windows 10
*/

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class EdurekaTimer extends JFrame {
    
    //Variable Declaration
    JPanel panel;
    JLabel lblTime;
    JTextField txtTime;
    JButton btnStart,btnStop;
    private int seconds = 0;
    private boolean stop = false;
    
    //constructor
    EdurekaTimer()
    {
        lblTime = new JLabel("Time(in seconds)");
        txtTime = new JTextField(seconds+"",10);
        txtTime.setEditable(false);
        btnStart= new JButton("Start Timer");
        btnStop= new JButton("Stop Timer");  
        
        panel = new JPanel();
        panel.add(lblTime);
        panel.add(txtTime);
        panel.add(btnStart);
        panel.add(btnStop);
        
         btnStart.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
            stop = false;
            Thread t = new Thread() {
               @Override
               public void run() {  // override the run() to specify the running behavior
                  for (int i = 0; i < 100000; ++i) {
                     if (stop) break;
                     txtTime.setText(seconds + "");
                     ++seconds;
                     
                     try 
                     {
                        sleep(1000);  // 1000 milliseconds = 1 second
                     }  catch (InterruptedException ex) {}
                  }
               }
            };
            t.start();  // call back run()
         }
      });

      btnStop.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
            stop = true;  // set the stop flag to true
         }
      });
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(panel, BorderLayout.CENTER);
        setTitle("Edureka Timer");
        setSize(280, 120);
        setVisible(true);   
    }
    
            
    public static void main(String[] args) {
      
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            new EdurekaTimer(); 
         }
      });
    }
}
