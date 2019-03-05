package muestreo;

import io.ImageManager;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author mijum
 */
public class temperatura {
    
    public Image temperaturaImagen(Image Original, int t){
        Color temp;
        Color fin;
        int r,g,b;
        BufferedImage bi = ImageManager.toBufferedImage(Original);
        for (int i = 0; i < bi.getWidth(); i++) {
            for (int j = 0; j < bi.getHeight(); j++) {
               temp = new Color(bi.getRGB(i, j));
                r = temp.getRed()+t;
                b = temp.getBlue()-t;
                if (r>255) {
                    r=255;
                }
                if (r<0) {
                    r=0;
                }
                if (b>255) {
                    b=255;
                }
                if (b<0) {
                    b=0;
                }
                g=temp.getGreen();
                fin = new Color(r,g,b);
            bi.setRGB(i, j,fin.getRGB());
            }
        }
        return ImageManager.toImage(bi);
    }
    public Image traslacion(Image Original, int c){
       BufferedImage bi = ImageManager.toBufferedImage(Original);
       Color col;
       
       int r,g,b;
       for (int x = 0; x < bi.getWidth(); x++) {
           for (int y = 0; y < bi.getHeight(); y++) {
               col = new Color(bi.getRGB(x, y));
               r=col.getRed()+c;
               g=col.getGreen()+c;
               b=col.getBlue()+c;
               if (r>255) {
                   r=255;
               }
               if (r<0) {
                   r=0;
               }
               if (b>255) {
                   b=255;
               }
               if (b<0) {
                   b=0;
               }
               if (g>255) {
                   g=255;
               }
               if (g<0) {
                   g=0;
               }
               col = new Color(r,g,b);
               bi.setRGB(x, y, col.getRGB());
           }
       }
       return ImageManager.toImage(bi);
   }
    
}
