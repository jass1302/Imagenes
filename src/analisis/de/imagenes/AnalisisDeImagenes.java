package analisis.de.imagenes;

import GUI.GUIFiltros;
import GUI.GUIUmbral;
import GUI.JFrameImagen;
import io.ImageManager;
import java.awt.Image;
import io.DisposeImagen;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import muestreo.HistogramaFrecuencias;
import muestreo.Umbralizacion;
import muestreo.negativo;
import muestreo.temperatura;

/**
 *
 * @author Roberto Cruz Leija
 */
public class AnalisisDeImagenes {

    /**
     * @param args the command line arguments
     */
    public static boolean pintar(Color normal,Color muestra, int rango){
        if((muestra.getRed() - normal.getRed() >= -rango && muestra.getRed() - normal.getRed() <= rango) && 
                     (muestra.getGreen() - normal.getGreen() >= -rango && muestra.getGreen() - normal.getGreen() <= rango)&& 
                     (muestra.getBlue() - normal.getBlue() >= -rango && muestra.getBlue() - normal.getBlue() <= rango)){
                 return true;
             }
        return false;
    }
    public static void main(String[] args) throws IOException {
        
          GUIFiltros ventana = new GUIFiltros();
          ventana.setVisible(true);
//        ImageManager img = new ImageManager();
//        Image objeto = img.openImage();
//        temperatura t = new temperatura();
//        JFrameImagen dos = new JFrameImagen(objeto);
//        JFrameImagen frame2 = new JFrameImagen(t.temperaturaImagen(objeto, -255));
//        Image neg = negativo.generarImagenEnNegativo(objeto, true, true, true);
//        JFrameImagen ver = new JFrameImagen(neg);
//       GUIUmbral ventana = new GUIUmbral();
//       ventana.setVisible(true);
//        Image fondo = img.openImage();
//        BufferedImage obj = ImageManager.toBufferedImage(objeto);
//        BufferedImage back = ImageManager.toBufferedImage(fondo);
//        
//       Image Res = ImageManager.chromaKey(obj, back, 0);
//        Image imagen = ImageManager.grises(ImageManager.toBufferedImage(objeto));
//        ;
//        Image binaria = Umbralizacion.umbralizacionSimple(100, imagen);
//        JFrameImagen frame2 = new JFrameImagen(binaria);
//        ImageManager.guardarImagen(binaria);
//        HistogramaFrecuencias hf = new HistogramaFrecuencias(imagen);
//        hf.graficarHistogramasRGB();
//        BufferedImage bf = ImageManager.toBufferedImage(imagen);
//        int rango = 50;
//        Color normal = new Color(255, 215, 1); 
//        Color shiny = new Color(74, 139, 180);
//        Color albino = new Color(244,244,244);
//        Color normal2 = new Color(226,61,57);
//        Color muestra;
//        for (int i = 0; i < bf.getWidth(); i++) {
//            for (int j = 0; j < bf.getHeight(); j++) {
//             muestra = new Color(bf.getRGB(i, j));
//             if(pintar(normal,muestra,rango)){bf.setRGB(i, j, shiny.getRGB());}
//             else if(pintar(normal2,muestra,rango)){bf.setRGB(i, j, normal.getRGB());}
//            }
//        }
//        JFrameImagen frame2 = new JFrameImagen(ImageManager.toImage(bf));
           
////      bf.setRGB(rgb, rgb, rgb);
//        Color color = new Color(rgb);
//        int r = color.getRed();
//        int b = color.getBlue();
//        int g = color.getGreen();
        
 
        //img.guardarImagen(imagen);
    }   
}