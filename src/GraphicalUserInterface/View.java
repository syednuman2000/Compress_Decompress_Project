/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GraphicalUserInterface;

import CodeFiles.Compress;
import CodeFiles.Decompress;
import GraphicalUserInterface.NewFileName;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Numan
 */
public class View extends JFrame implements ActionListener {
    
    JButton compressButton;
    JButton decompressButton;
    JButton exitButton;
    static String s = "\\text.txt";
    
    View(){
        this.setTitle("File Blip");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        
        compressButton = new JButton("Select File To Compress");
        compressButton.addActionListener(this);
        compressButton.setBounds(40,50,200,30);
        
        decompressButton = new JButton("Select File To Decompress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(340,50,200,30);
        
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        exitButton.setBounds(180,170,200,30);
        
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Numan\\Documents\\NetBeansProjects\\Compress&Decompress\\BG.jpg");
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(600, 300,  java.awt.Image.SCALE_SMOOTH);
        
        this.setContentPane(new JLabel(new ImageIcon(newimg)));
        this.setSize(600,300);
        
        this.add(compressButton);
        this.add(decompressButton);
        this.add(exitButton);
        
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == compressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try{
                    Compress.method(file);
                    JOptionPane.showMessageDialog(null,"File Compressed Successfully!","Congratulations",JOptionPane.INFORMATION_MESSAGE);
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null,"Oops!! There is an error","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        else if(e.getSource() == decompressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try{
                    new NewFileName(file).setVisible(true);
                    this.dispose();
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null,"Oops!! There is an error","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        else if(e.getSource() == exitButton){
            System.exit(0);
        }
    }
    
    public static void fileName(String str,File file){
        s = str;
        try{        
            Decompress.method(file,s);
            JOptionPane.showMessageDialog(null,"File Decompressed Successfully!","Congratulations",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception excp){
            JOptionPane.showMessageDialog(null,"Oops!! There is an error","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args){
        View view = new View();
    }
}
