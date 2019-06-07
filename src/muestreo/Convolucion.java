package muestreo;

import io.ImageManager;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author mijum
 */
public class Convolucion {
    private int dim;
    private Image imagenOriginal;
    private double kernel[][][];
    //Mascaras
    //Pixeles
    private double[][] diferenciaPixelesGx = {{0.0, 0.0, 0.0}, {0.0, 1.0, -1.0}, {0.0, 0.0, 0.0}};
    private double[][] diferenciaPixelesGy = {{0.0, -1.0, 0.0}, {0.0, 1.0, 0.0}, {0.0, 0.0, 0.0}};
    // mascara de diferencia de pixeless separados
    private double[][] diferenciaPixelesSeparadosGx = {{0.0, 0.0, 0.0}, {1.0, 0.0, -1.0}, {0.0, 0.0, 0.0}};
    private double[][] diferenciaPixelesSeparadosGy = {{0.0, -1.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 1.0, 0.0}};
    // mascara de operador prewitt
    private double[][] prewittGx = {{1.0, 0.0, -1.0}, {1.0, 0.0, -1.0}, {1.0, 0.0, -1.0}};
    private double[][] prewittGy = {{-1.0, -1.0, -1.0}, {0.0, 0.0, 0.0}, {1.0, 1.0, 1.0}};
    // mascara de operador Sobel
    private double[][] SobelGx = {{1.0, 0.0, -1.0}, {2.0, 0.0, -2.0}, {1.0, 0.0, -1.0}};
    private double[][] SobelGy = {{-1.0, -2.0, -1.0}, {0.0, 0.0, 0.0}, {1.0, 2.0, 1.0}};
    // mascara dde operador Roberts
    private double[][] robertsGx = {{0.0, 0.0, -1.0}, {0.0, 1.0, 0.0}, {0.0, 0.0, 0.0}};
    private double[][] robertsGy = {{-1.0, 0.0, 0.0}, {0.0, 1.0, 0.0}, {0.0, 0.0, 0.0}};
    // kirch
    private double[][] kirsch1 = {{-3, -3, 5}, {-3, 0, 5}, {-3, -3, 5}};
    private double[][] kirsch2 = {{-3, 5, 5}, {-3, 0, 5}, {-3, -3, -3}};
    private double[][] kirsch3 = {{5, 5, 5}, {-3, 0, -3}, {-3, -3, -3}};
    private double[][] kirsch4 = {{5, 5, -3}, {5, 0, -3}, {-3, -3, -3}};
    private double[][] kirsch5 = {{5, -3, -3}, {5, 0, -3}, {5, -3, -3}};
    private double[][] kirsch6 = {{-3, -3, -3}, {5, 0, -3}, {5, 5, -3}};
    private double[][] kirsch7 = {{-3, -3, -3}, {-3, 0, -3}, {5, 5, 5}};
    private double[][] kirsch8 = {{-3, -3, -3}, {-3, 0, 5}, {-3, 5, 5}};
    private double[][][] arregloMascaras = {kirsch1, kirsch2, kirsch3,kirsch4, kirsch5, kirsch6,kirsch7, kirsch8};
    // terminamos kirch
    // creamos mascara de Laplace
    private double[][] laplace = {{0.0, 1.0, 0.0}, {1.0, -4.0, 1.0}, {0.0, 1.0, 0.0}};
    
    public Convolucion(Image imagenOriginal){
        this.dim = 0;
        this.imagenOriginal = imagenOriginal;
        this.kernel = null;
    }
    
    public Image aplicar(double kernel[][][], int divisor){
       this.dim = kernel[0].length;
       this.kernel = kernel;
       BufferedImage nueva = new BufferedImage(this.imagenOriginal.getWidth(null),this.imagenOriginal.getHeight(null),BufferedImage.TYPE_INT_RGB);
       BufferedImage bi = ImageManager.toBufferedImage(imagenOriginal);
        
       //System.out.println("W:"+nueva.getWidth()+"H:"+nueva.getHeight());
       //proceso iterativo para generar un imagen nueva
       for(int x=0; x<this.imagenOriginal.getWidth(null);x++){
           for(int y=0; y<this.imagenOriginal.getHeight(null);y++){
           double muestra[][] =extraerMuestra(x,y,bi);
            //System.out.println(x+","+y);
            // validar que la muestra se generó 
            if(muestra!=null){
                 //System.out.println("AAA"+y);
            Color colorRes = convulacionar(kernel,muestra,divisor);
            
            nueva.setRGB(x, y, colorRes.getRGB());
            
            }else{
            nueva.setRGB(x, y, new Color(255,255,255).getRGB());            
            }
           }
       }
       
       return ImageManager.toImage(nueva);
    }
    
    public static Color convulacionar(double[][][] kernel, double[][] muestra, int divisor) {
        int acumuladorR = 0; double r=0,g=0,b=0;
        int acumuladorG = 0;
        int acumuladorB = 0;    
        Color aux; 
        // recorremos el kernel y la muestra 
        for(int x=0; x<kernel[0].length;x++)
            for(int y=0; y<kernel[0].length;y++){
               // System.out.println(x);
               aux = new Color((int)muestra[x][y]);
                for (int z = 0; z < kernel.length; z++) {
                    if ((kernel[z][x][y]*aux.getRed())>r) {
                       r = (kernel[z][x][y]*aux.getRed()); 
                    }
                    if ((kernel[z][x][y]*aux.getGreen())>g) {
                        g = (kernel[z][x][y]*aux.getGreen());
                    }
                    if ((kernel[z][x][y]*aux.getBlue())>b) {
                        b = (kernel[z][x][y]*aux.getBlue());
                    }                           
                }
                if (r>acumuladorR) {
                   acumuladorR=(int) r; 
                }
                if (g>acumuladorG) {
                    acumuladorG=(int) g; 
                }
                if (b>acumuladorB) {
                    acumuladorB=(int) b;
                }
         
         }
        acumuladorR/=divisor;
        acumuladorG/=divisor;
        acumuladorB/=divisor;
        return new Color((int)expansion.validarRango(acumuladorR),(int)expansion.validarRango(acumuladorG),(int)expansion.validarRango(acumuladorB));
        
    }
    

    
    private double[][] extraerMuestra(int x, int y, BufferedImage bi) {
        double matriz[][] = new double[this.kernel[0].length][this.kernel[0].length];
       int xx=0;
        int yy=0;
        try {
         // recorremos la imagen 
         for(int i=x-(this.kernel[0].length-1)/2;i<=x+(this.kernel[0].length-1)/2;i++){
            for(int j=y-(this.kernel[0].length-1)/2;j<=y+(this.kernel[0].length-1)/2;j++){
            matriz[xx][yy] = bi.getRGB(i,j);
            yy++;
            }
            yy=0;
            xx++;
         }
          return matriz;
        } catch (Exception e) {
           // System.out.println("Indice no valido");
            return null;
        }
       
    }
    public static double validarRango(double valor){
        if(valor>255)return 255;
        if(valor<0)return 0;
        return valor;
    
    }
    
}   
    

