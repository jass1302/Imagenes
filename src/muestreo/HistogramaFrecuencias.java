package muestreo;
import io.ImageManager;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
/**
 *
 * @author mijum
 */

public class HistogramaFrecuencias {

    private Image imagenOriginal;
    private int histogramaR[];
    private int histogramaG[];
    private int histogramaB[];
    private int histogramaBN[];

     public HistogramaFrecuencias(Image imagenOriginal) {
        this.imagenOriginal = imagenOriginal;
        this.histogramaR = new int[256];
        this.histogramaG = new int[256];
        this.histogramaB = new int[256];
        this.histogramaBN = new int[256];
        
         // calcular los histogramas por cada uno de los colores
        calcularHistogramas();
    
    }
    public void graficarHistogramasRGB(){
    // graficar los Histogramas
    Grafica grafica = new Grafica("Histogramas RGB","Color","Frecuencias");
    grafica.agregarSerie("Rojo",this.histogramaR);
    grafica.agregarSerie("Azul",this.histogramaB);
    grafica.agregarSerie("Verde",this.histogramaG);
    grafica.crearGrafica();

     }
   public Image traslacion(Image Original, int c){
       BufferedImage bi = ImageManager.toBufferedImage(Original);
       Color col;
       int r,g,b;
       for (int x = 0; x < bi.getWidth(); x++) {
           for (int y = 0; y < bi.getHeight(); y++) {
               col = new Color(bi.getRGB(x, y));
               if (col.getRed()+c>=0) {r=col.getRed()+c;}else{r=0;}
               if (col.getGreen()+c>=0){g=col.getGreen()+c;}else{g=0;}
               if (col.getBlue()+c>=0) {b=col.getBlue()+c;}else{b=0;}
               if (col.getRed()+c<=255) {r=col.getRed()+c;} else{r=255;}
               if (col.getGreen()+c<=255) {g=col.getGreen()+c;}else{g=255;}
               if (col.getBlue()+c<=255) {b=r=col.getBlue()+c;}else{b=255;}
               col = new Color(r,g,b);
               bi.setRGB(x, y, col.getRGB());
           }
       }
       return ImageManager.toImage(bi);
   }
     private void calcularHistogramas() {
        // recorrido de la imagen y contamos las frecuencias de color
        BufferedImage bi = ImageManager.toBufferedImage(this.imagenOriginal);
        // recorrer el BufferedImage 
        for (int x=0; x < bi.getWidth();x++)
            for(int y=0; y < bi.getHeight();y++){
                Color pixel = new Color(bi.getRGB(x, y));
                this.histogramaR[pixel.getRed()]++;
                this.histogramaG[pixel.getGreen()]++;
                this.histogramaB[pixel.getBlue()]++;
            }
    }
    
 }