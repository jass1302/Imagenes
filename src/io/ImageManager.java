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
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.opencv.core.Mat;

/**
 *
 * @author Roberto Cruz Leija
 */
public class ImageManager {
       public BufferedImage Mat2BufferedImage(Mat m) {
    // Fastest code
    // output can be assigned either to a BufferedImage or to an Image
    int type = BufferedImage.TYPE_BYTE_GRAY;
    if ( m.channels() > 1 ) {
        type = BufferedImage.TYPE_3BYTE_BGR;
    }
    int bufferSize = m.channels()*m.cols()*m.rows();
    byte [] b = new byte[bufferSize];
    m.get(0,0,b); // get all the pixels
    BufferedImage image = new BufferedImage(m.cols(),m.rows(), type);
    final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
    System.arraycopy(b, 0, targetPixels, 0, b.length);  
    return image;
}
    
    public static String openVideo(){
        // definir los filtros para lectura
            FileNameExtensionFilter filtro =
                    new FileNameExtensionFilter("Videos","mp4","avi","mkv");
            // crear un selector de archivos
            JFileChooser selector = new JFileChooser();
            // agregar el filtro al selector
            selector.addChoosableFileFilter(filtro);
            // especificar que solo se puedan abrir archivos
            selector.setFileSelectionMode(JFileChooser.FILES_ONLY);
            
             int res = selector.showOpenDialog(null);
             
             if (res == 1) {
                 return null;
            
        }
             File archivo = selector.getSelectedFile();
             
        return archivo.getPath();
    }
    
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
    public static Image reedimensionar(Image imagen,int altura, int ancho){
       BufferedImage bi = toBufferedImage(imagen);
        double escalar;
        if (bi.getWidth()>bi.getHeight()) {
            escalar = bi.getWidth();
        }else{
            escalar = bi.getHeight();
        } 
            escalar = ancho/escalar;
            imagen = bi.getScaledInstance((int) (bi.getWidth()*escalar),(int)(bi.getHeight()*escalar),0);
       
        
        return imagen;
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
