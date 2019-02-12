package muestreo;

import io.ImageManager;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author mijum
 */
public class Umbralizacion {
    public static Image umbralizacionSimple(int u, Image imagenOriginal){
    BufferedImage bi = ImageManager.toBufferedImage(imagenOriginal);
    
        // Recorremos el buffer
        for (int x = 0; x < bi.getWidth(); x++) {
            for (int y = 0; y < bi.getHeight(); y++) {
                Color color = new Color(bi.getRGB(x, y));
                int prom = (color.getRed() + color.getGreen() + color.getBlue())/3;
                if(prom<u){
                    color = new Color(0,0,0);
                }else{
                    color = new Color(255,255,255);
                }
                bi.setRGB(x, y, color.getRGB());
            }
        }
        return ImageManager.toImage(bi);
    }
}
