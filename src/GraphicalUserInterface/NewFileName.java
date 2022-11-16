/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GraphicalUserInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

/**
 *
 * @author Numan
 */
public class NewFileName extends JFrame implements ActionListener{
    
    File f;
    String Extension = "";
    String[] s = {"",".txt",".doc",".docx",".pdf",".jpg",".png",".jpeg",".mp3",".mp4",".xml",".apk",".jar"};
    JButton saveButton;
    JTextField name;
    JComboBox cb = new JComboBox();
    
    public NewFileName(File file){
        this.setTitle("Select File Specifications");
        this.setSize(600,260);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        for(String str:s){
            cb.addItem(str);
        }
        ((JLabel)cb.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        cb.setBounds(150,120,80,25);
        cb.addActionListener(this);
        
        f = file;
        
        JLabel label_3 = new JLabel("Choose a Name and Extension for your Decomprssed File",JLabel.CENTER);
        label_3.setBounds(0,25,600,30);
        label_3.setForeground(Color.WHITE);
        label_3.setFont(new Font("Ariel",Font.BOLD,14));
        label_3.setOpaque(false);
        
        JLabel label_1 = new JLabel("Name : ",JLabel.CENTER);
        label_1.setBounds(50,80,100,25);
        label_1.setForeground(Color.WHITE);
        label_1.setFont(new Font("Arial",Font.BOLD,14));
        label_1.setOpaque(false);
        
        name = new JTextField(20);
        name.setBounds(150,80,200,25);
        
        JLabel label_2 = new JLabel("Extension : ",JLabel.CENTER);
        label_2.setBounds(50,120,100,25);
        label_2.setForeground(Color.WHITE);
        label_2.setFont(new Font("Arial",Font.BOLD,14));
        label_2.setOpaque(false);
        
        saveButton = new JButton("Save");
        saveButton.addActionListener(this);
        saveButton.setBounds(185,180,200,30);
                
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Numan\\Documents\\NetBeansProjects\\Compress&Decompress\\BG.jpg");
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(600, 260,  java.awt.Image.SCALE_SMOOTH);
        
        this.setContentPane(new JLabel(new ImageIcon(newimg)));
        
        this.add(label_1);
        this.add(name);
        this.add(label_2);
        this.add(cb);
        this.add(label_3);
        this.add(saveButton);
        
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
 
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == cb){
            Extension = (String)((JComboBox)e.getSource()).getSelectedItem();
            System.out.print(Extension);
        }
        else if(e.getSource() == saveButton){
            String str = name.getText();
            str = str + Extension;
            str = "\\" + str;
            new View().setVisible(true);
            View.fileName(str,f);
            this.dispose();
        }
    }
    
    public static void main(String[] args){
        File file_1=null;
        NewFileName newName = new NewFileName(file_1);
    }
}