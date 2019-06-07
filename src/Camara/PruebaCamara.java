package Camara;

/**
 *
 * @author mijum
 */
import java.awt.Image;
import javax.swing.JFrame;
import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
public class PruebaCamara {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        //System.loadLibrary("opencv_ffmpeg401_64.dll");
        VideoCapture camara = new VideoCapture("C:\\Users\\mijum\\Videos\\pl.mp4");
        JFrameImagen frame1 = new JFrameImagen();
    
        if (!camara.isOpened()) {
            System.out.println("Error!");
        }else{
            Mat frame = new Mat(); 
            while(true){
                if (camara.read(frame)) {
//                    System.out.println("Frame obtenido");
//                    System.out.println("Ancho del frame: "+frame.width()+"Alto del frame: "+frame.height());   
                //    frame1.nueva(frame1.Mat2BufferedImage(frame));
                }
            }
        }
    }
    
}
