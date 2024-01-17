/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SourceCodes;

import static SourceCodes.DashBoard.mainFrame;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author Ken-Carlon
 */
public class MethodsForAll {
     public static  ImageIcon setIconsReturnIcon(String resourcePath, JComponent component){
        try{
            // read the image file from the path given
            BufferedImage imagebuff = ImageIO.read(new File(resourcePath));
             ImageIcon icon = new ImageIcon(imagebuff);
              Image image = icon.getImage().getScaledInstance(component.getWidth(), component.getHeight(), Image.SCALE_SMOOTH);
           icon.setImage(image);
     
            return icon;
        }catch(IOException e){
     
            JOptionPane.showMessageDialog(mainFrame, "Error, Buffering Image.\n\"Could not find resource\"", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }       public static  Image setIconsReturnImage(String resourcePath, JComponent component){
        try{
            // read the image file from the path given
            BufferedImage imagebuff = ImageIO.read(new File(resourcePath));
             ImageIcon icon = new ImageIcon(imagebuff);
              Image image = icon.getImage().getScaledInstance(component.getWidth(), component.getHeight(), Image.SCALE_SMOOTH);
       
         
            return image;
        }catch(IOException e){
          
            JOptionPane.showMessageDialog(mainFrame, "Error, Buffering Image.\n\"Could not find resource\"", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }
}
