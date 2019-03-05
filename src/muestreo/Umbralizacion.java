package muestreo;

import io.ImageManager;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Random;

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
    public static int umbralizacionIterativa(int Histograma[]){
        // Calculamos el umbral inicial
        Random ran = new Random();
        int uR = ran.nextInt();
        int uA;
        // Hacemos el proceso iterativo de reajuste
        do{
            uA = uR;
            uR = reajustarUmbral(Histograma,uA);
            
        }while(uR!=uA);
        return uR;
    }

    private static int reajustarUmbral(int[] Histograma, int u) {
        int aFi=0,aPi=0;
        int aPd=0,aFd=0;
        aPi+=Histograma[0];
        for (int x = 1; x < u; x++) {
            aPi+=Histograma[x];
            aFi+=Histograma[x]*x;
        }
        for (int y = 0; y < Histograma.length; y++) {
            aPd+=Histograma[y];
            aFd+=Histograma[y]*y;
        }
       
        int uI= aPi/aFi;
        int uD = aPd/aFd;
        return (int)(uI+uD)/2;
    }
}
