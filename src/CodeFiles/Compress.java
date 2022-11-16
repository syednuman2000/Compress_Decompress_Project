/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 *
 * @author Numan
 */
public class Compress {
    
    public static void method(File file) throws FileNotFoundException, IOException{
        String fileDirectory = file.getParent();
        System.out.println(fileDirectory);
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileDirectory+"\\CompressedFile.gz");
        GZIPOutputStream gzipOS = new GZIPOutputStream(fos);
        
        byte[] buffer = new byte[1024];
        int len;
        
        while((len=fis.read(buffer))!= -1){
            gzipOS.write(buffer,0,len);
        }
        
        gzipOS.close();
        fis.close();
        fos.close();
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException{
        File path = new File("C:\\Users\\Numan\\Desktop\\HTML Files\\Project Compress Decompress\\Temp_File.txt");
        method(path);
    }
}
