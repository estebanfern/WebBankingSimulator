/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frontend;
import java.awt.Color;
import javax.swing.JOptionPane;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 *
 * @author esteb
 */
public class HistorialP extends javax.swing.JPanel {

    /**
     * Creates new form InicioP
     */
    public HistorialP() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Borde = new javax.swing.JPanel();
        TituloHistorial = new javax.swing.JLabel();
        LbConsulte = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PanelContenido = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(960, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Borde.setBackground(new java.awt.Color(13, 71, 161));
        Borde.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TituloHistorial.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        TituloHistorial.setForeground(new java.awt.Color(255, 255, 255));
        TituloHistorial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TituloHistorial.setText("Historial de transacciones");
        Borde.add(TituloHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 90));

        add(Borde, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 960, 90));

        LbConsulte.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        LbConsulte.setForeground(new java.awt.Color(0, 0, 0));
        LbConsulte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LbConsulte.setText("Consulte su historial de transacciones");
        add(LbConsulte, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 960, 70));

        jPanel2.setBackground(new java.awt.Color(13, 71, 161));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(13, 71, 161)));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Consultar");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 230, 40));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/historial.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 230, 40));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 580, 230, 100));

        PanelContenido.setBackground(new java.awt.Color(255, 255, 255));
        PanelContenido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(PanelContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 620, 310));
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
        // TODO add your handling code here:
        jPanel2.setBackground(new Color(255, 255, 255));
        jLabel1.setForeground(new Color(13, 71,161));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/historial_1.png")));
    }//GEN-LAST:event_jPanel2MouseEntered

    private void jPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseExited
        // TODO add your handling code here:
        jPanel2.setBackground(new Color(13, 71,161));
        jLabel1.setForeground(new Color(255, 255,255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/historial.png")));
    }//GEN-LAST:event_jPanel2MouseExited

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Historial");
        PanelHistorial muestra = new PanelHistorial();
        muestra.setSize(620, 310);
        PanelContenido.removeAll();
        PanelContenido.add(muestra, new AbsoluteConstraints(0,0,-1,-1));
        PanelContenido.revalidate();
        PanelContenido.repaint();
    }//GEN-LAST:event_jPanel2MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Borde;
    private javax.swing.JLabel LbConsulte;
    private javax.swing.JPanel PanelContenido;
    private javax.swing.JLabel TituloHistorial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
