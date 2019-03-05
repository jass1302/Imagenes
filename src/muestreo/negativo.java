/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestreo;

import io.ImageManager;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author mijum
 */
public class negativo {
      public static Image generarImagenEnNegativo(Image original,boolean re, boolean gr, boolean bl){
          int r,g,b;
        BufferedImage bi = ImageManager.toBufferedImage(original);
     // recorrido por pixel para hacer el tono gris
     for(int x=0; x<bi.getWidth();x++){
         for(int y=0;y<bi.getHeight();y++){
         //extrer el tono del pixel en RGB
         Color color = new Color(bi.getRGB(x, y));
             if (re){r = 255 - color.getRed(); } else{r=color.getRed();}
             if(gr){g = 255-color.getGreen(); } else{g=color.getGreen();}
             if (bl){b = 255-color.getBlue(); } else{b=color.getBlue();}
             
             bi.setRGB(x, y, new Color(r,g,b).getRGB());
         }
     }
     return ImageManager.toImage(bi);
    }
}
