/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Roberto Cruz Leija
 */
public class ImageManager {
    
    public static Image openImage (){
    
        try {
            // definir los filtros para lectura
            FileNameExtensionFilter filtro =
                    new FileNameExtensionFilter("Imagenes","jpg","jpeg","png","bmp");
            // crear un selector de archivos
            JFileChooser selector = new JFileChooser();
            // agregar el filtro al selector
            selector.addChoosableFileFilter(filtro);
            // especificar que solo se puedan abrir archivos
            selector.setFileSelectionMode(JFileChooser.FILES_ONLY);
            
            //ejecutar el selector de imagenes
            
            int res = selector.showOpenDialog(null);
            
            if (res == 1 ){
                
                return null;
                
            }
            
            File archivo = selector.getSelectedFile();
            
            BufferedImage bi = ImageIO.read(archivo);
            
            return toImage(bi);
        } catch (IOException ex) {
            Logger.getLogger(ImageManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static Image toImage (BufferedImage bi){
        return bi.getScaledInstance(bi.getWidth(),bi.getHeight(), BufferedImage.TYPE_INT_RGB);
    }
    
    public static BufferedImage toBufferedImage (Image imagen){
         // imagen es un objeto de tipo BufferedImage
        if (imagen instanceof BufferedImage){
          return (BufferedImage)imagen;
        }
        BufferedImage bi = 
                new BufferedImage(imagen.getWidth(null), imagen.getHeight(null), BufferedImage.TYPE_INT_RGB);
        
        Graphics2D nueva = bi.createGraphics();
        nueva.drawImage(imagen, 0, 0,null);
        nueva.dispose();
        
        return bi;
    }
    public static Image grises(BufferedImage imagen){
        Color gris;
        int promedio;
        for (int x = 0; x < imagen.getWidth(); x++) {
            for (int y = 0; y < imagen.getHeight(); y++) {
                gris = new Color(imagen.getRGB(x, y));
                promedio = (gris.getRed()+gris.getBlue()+gris.getGreen())/3;
                gris = new Color(promedio, promedio, promedio);
                imagen.setRGB(x, y, gris.getRGB());
            }
        }
        return ImageManager.toImage(imagen);
    }
    public static Image chromaKey(BufferedImage objeto, BufferedImage fondo, int rango){
        Color chromaGreen = new Color(0, 254, 0);
        Color chromaBlue = new Color(0,0,255); 
        Color x;
        for (int i = 0; i < objeto.getWidth(); i++) {
            for (int j = 0; j < objeto.getHeight(); j++) {
                x = new Color(objeto.getRGB(i, j));
              if(
                      (x.getRed() - chromaGreen.getRed() >= -rango && x.getRed() - chromaGreen.getRed() >= rango)
                      &&
                      (x.getGreen() - chromaGreen.getGreen() >= -rango && x.getGreen() - chromaGreen.getGreen() >= rango)
                      &&
                      (x.getBlue() - chromaGreen.getBlue() >= -rango && x.getBlue() - chromaGreen.getBlue() >= rango)
                 ){
                  objeto.setRGB(i, j, fondo.getRGB(i, j));
                  System.out.println(".");
              }
            }
        }
       
        return toImage(objeto);
    }
   public static void guardarImagen(Image imagen) throws IOException{
        // convertimos a buffered
        BufferedImage bi = toBufferedImage(imagen);
        // declaramos la ventana para seleccionar la ruta 
        JFileChooser ventana = new JFileChooser();
        int res = ventana.showSaveDialog(null);
        if (res == JFileChooser.APPROVE_OPTION){
           File archivo = ventana.getSelectedFile();
           ImageIO.write(bi,"jpg", archivo);
    
        }
          
    }
    
}