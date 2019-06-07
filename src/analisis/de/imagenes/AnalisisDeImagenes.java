package analisis.de.imagenes;

import GUI.GUITodo;
import GUI.GUIUmbral;
import GUI.JFrameImagen;
import GUI.VisionArtificial;
import frecuencias.Gestor;
import frecuencias.HerramientasColor;
import io.ImageManager;
import java.awt.Image;
import io.DisposeImagen;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import muestreo.Convolucion;
import muestreo.HistogramaFrecuencias;
import muestreo.Umbralizacion;
import muestreo.escalaGrises;
import muestreo.expansion;
import muestreo.negativo;
import muestreo.temperatura;

/**
 *
 * @author 
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
        GUITodo ventana = new GUITodo();
        
//        BufferedImage bi = ImageManager.toBufferedImage(ImageManager.openImage());
//         Color color = new Color(bi.getRGB(120, 34));
//         int r =  color.getRed();
//         int g =  color.getGreen();
//         int b =  color.getBlue();
//         Gestor gestor = new Gestor(bi);
////         NumeroComplejo [][] aux = gestor.representacionEspacial.get(HerramientasColor.CanalColor.AZUL);
////         NumeroComplejo [][] aux2 = gestor.representacionEspacial.get(HerramientasColor.CanalColor.ROJO);
////         NumeroComplejo [][] aux3 = gestor.representacionEspacial.get(HerramientasColor.CanalColor.VERDE);
//
//         System.out.println();
//        FiltroExponencialPasaBajas filtro = new FiltroExponencialPasaBajas(512, 512, 150,2);
//        filtro.generar();
//        Image imagen = filtro.toImage();
//        JFrameImagen frame1 = new JFrameImagen(imagen);
        //double kernel [][] = new double[][]{{-2,-1,0},{-1,1,1},{0,1,2}};
        //double kernel [][] = new double[][]{{0,1,0},{1,-4,1},{0,1,0}};
        //double kernel2 [][] = new double[][]{{1,1,1,1,1},{1,4,4,4,1},{1,4,12,4,1},{1,4,4,4,1},{1,1,1,1,1}};
        ///Convolucion2 convo = new Convolucion2(imagen);
        //Image nueva = convo.aplicar(kernel, 1);
        
        
       // JFrameImagen frame2 = new JFrameImagen(nueva);        System.out.println();
        
        
//        Image imagen = ImageManager.openImage();
//        JFrameImagen frame1 = new JFrameImagen(imagen);
//        //double kernel [][] = new double[][]{{-2,-1,0},{-1,1,1},{0,1,2}};
//        double kernel [][] = new double[][]{{0,1,0},{1,-4,1},{0,1,0}};
//        //double kernel2 [][] = new double[][]{{1,1,1,1,1},{1,4,4,4,1},{1,4,12,4,1},{1,4,4,4,1},{1,1,1,1,1}};
//        Convolucion convo = new Convolucion(imagen);
//        Image nueva = convo.aplicar(kernel, 1);
//        JFrameImagen frame2 = new JFrameImagen(nueva);
//        
//       
//        System.out.println();
//            VisionArtificial ventana = new VisionArtificial();
////          GUITodo ventana = new GUITodo();
//            ventana.setVisible(true);
////          
          
//        ImageManager img = new ImageManager();
//        Image objeto = img.openImage();
//        
//        escalaGrises perro = new escalaGrises();
//        objeto = perro.generarImagenEnGrises(objeto);
//        JFrameImagen ver2= new JFrameImagen(objeto);
        
//        expansion ex = new expansion();
//        Image tan = ex.expansionCuadratica(0,objeto);
//        //Image tan = ex.expansionTangencial(-100,objeto);
//        //Image tan = ex.expansionLogaritmica(0,objeto);
//         HistogramaFrecuencias h = new HistogramaFrecuencias(tan);
//         h.graficarHistogramasRGB();
//         
         
//        temperatura t = new temperatura();
//        JFrameImagen dos = new JFrameImagen(objeto);
//        JFrameImagen frame2 = new JFrameImagen(t.temperaturaImagen(objeto, -255));
//        Image neg = negativo.generarImagenEnNegativo(objeto, true, true, true);
//          JFrameImagen ver = new JFrameImagen(tan);
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