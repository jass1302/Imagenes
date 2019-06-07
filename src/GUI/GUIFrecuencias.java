package GUI;

import frecuencias.FiltroButterworthPasaBajas;
import frecuencias.FiltroExponencialPasaBajas;
import frecuencias.FiltroIdealPasaAltas;
import frecuencias.FiltroIdealPasaBajas;
import frecuencias.Gestor;
import frecuencias.NumeroComplejo;
import io.ImageManager;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author mijum
 */
public class GUIFrecuencias extends javax.swing.JFrame {

    /**
     * Creates new form Filtros
     */
    public GUIFrecuencias() {
        this.setVisible(true);
        initComponents();
        filtroscombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion","Ideal Pasa Bajas","Ideal Pasa Altas","Butterworth Pasa Bajas","Exponencial Pasa Bajas"}));
    }
    public Image original;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        openimg = new javax.swing.JButton();
        labelfrec = new javax.swing.JLabel();
        labelOri = new javax.swing.JLabel();
        labelOri1 = new javax.swing.JLabel();
        labelOri2 = new javax.swing.JLabel();
        filtroscombo = new javax.swing.JComboBox<>();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Imagen:");

        openimg.setText("abrir");
        openimg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openimgActionPerformed(evt);
            }
        });

        labelfrec.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelOri.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelOri1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelOri2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        filtroscombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        filtroscombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroscomboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(openimg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filtroscombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(labelOri2, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelOri1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelfrec, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelOri, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelOri, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(openimg)
                                .addComponent(filtroscombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelfrec, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelOri2, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelOri1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openimgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openimgActionPerformed
        // TODO add your handling code here:
       this.original= ImageManager.openImage();
       this.labelOri2.setIcon(new ImageIcon(this.original));
    }//GEN-LAST:event_openimgActionPerformed

    private void filtroscomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroscomboActionPerformed
        // TODO add your handling code here:
        Gestor gestor = new Gestor(ImageManager.toBufferedImage(this.original));
        BufferedImage imagenFrecuencias = gestor.obtenerImagenFrecuencias(true);
        this.labelfrec.setIcon(new ImageIcon(imagenFrecuencias));
        if (filtroscombo.getSelectedItem() == "Ideal Pasa Bajas") {
         FiltroIdealPasaBajas filtrobutter = new FiltroIdealPasaBajas(512,512,20);
         filtrobutter.generar();
         NumeroComplejo[][] filter = filtrobutter.getMatriz();
         this.labelOri.setIcon(new ImageIcon(filtrobutter.toImage()));
         gestor.aplicarFiltro(filter);
         BufferedImage imagenEspacial = gestor.obtenerImagenEspacial();
         this.labelOri1.setIcon(new ImageIcon(ImageManager.toImage(imagenEspacial)));
            
            
        }
        if (filtroscombo.getSelectedItem() == "Ideal Pasa Altas") {
         FiltroIdealPasaAltas filtrobutter = new FiltroIdealPasaAltas(512,512,20);
         filtrobutter.generar();
         NumeroComplejo[][] filter = filtrobutter.getMatriz();
         this.labelOri.setIcon(new ImageIcon(filtrobutter.toImage()));
         gestor.aplicarFiltro(filter);
         BufferedImage imagenEspacial = gestor.obtenerImagenEspacial();
         this.labelOri1.setIcon(new ImageIcon(ImageManager.toImage(imagenEspacial)));
            
        }
        if (filtroscombo.getSelectedItem() == "Butterworth Pasa Bajas") {
         FiltroButterworthPasaBajas filtrobutter = new FiltroButterworthPasaBajas(512,512,20,15);
         filtrobutter.generar();
         NumeroComplejo[][] filter = filtrobutter.getMatriz();
         this.labelOri.setIcon(new ImageIcon(filtrobutter.toImage()));
         gestor.aplicarFiltro(filter);
         BufferedImage imagenEspacial = gestor.obtenerImagenEspacial();
         this.labelOri1.setIcon(new ImageIcon(ImageManager.toImage(imagenEspacial)));
        }
        if (filtroscombo.getSelectedItem() == "Exponencial Pasa Bajas") {
         FiltroExponencialPasaBajas filtrobutter = new FiltroExponencialPasaBajas(512,512,20,15);
         filtrobutter.generar();
         NumeroComplejo[][] filter = filtrobutter.getMatriz();
         this.labelOri.setIcon(new ImageIcon(filtrobutter.toImage()));
         gestor.aplicarFiltro(filter);
         BufferedImage imagenEspacial = gestor.obtenerImagenEspacial();
         this.labelOri1.setIcon(new ImageIcon(ImageManager.toImage(imagenEspacial)));
        }
    }//GEN-LAST:event_filtroscomboActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIFrecuencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIFrecuencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIFrecuencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIFrecuencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIFrecuencias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> filtroscombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelOri;
    private javax.swing.JLabel labelOri1;
    private javax.swing.JLabel labelOri2;
    private javax.swing.JLabel labelfrec;
    private javax.swing.JButton openimg;
    // End of variables declaration//GEN-END:variables
}
