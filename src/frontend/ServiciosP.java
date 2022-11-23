/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frontend;
import javax.swing.JOptionPane;
import java.awt.Color;


/**
 *
 * @author esteb
 */
public class ServiciosP extends javax.swing.JPanel {
    String user;
    int seleccion = -1;
    String [] servicios = {"ESSAP", "ANDE", "COPACO", "NETFLIX"};
    /**
     * Creates new form InicioP
     */
    public ServiciosP(String args) {
        initComponents();
        user = args;
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
        TituloServicios = new javax.swing.JLabel();
        LbSeleccione = new javax.swing.JLabel();
        LbMonto = new javax.swing.JLabel();
        TxtMonto = new javax.swing.JTextField();
        Sep2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BtEssap = new javax.swing.JPanel();
        LogoEssap = new javax.swing.JLabel();
        SepEssap = new javax.swing.JPanel();
        BtAnde = new javax.swing.JPanel();
        LogoAnde = new javax.swing.JLabel();
        SepAnde = new javax.swing.JPanel();
        BtCopaco = new javax.swing.JPanel();
        LogoCopaco = new javax.swing.JLabel();
        SepCopaco = new javax.swing.JPanel();
        BtNetflix = new javax.swing.JPanel();
        LogoNetflix = new javax.swing.JLabel();
        SepNetflix = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(960, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Borde.setBackground(new java.awt.Color(13, 71, 161));
        Borde.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TituloServicios.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        TituloServicios.setForeground(new java.awt.Color(255, 255, 255));
        TituloServicios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TituloServicios.setText("Servicios");
        Borde.add(TituloServicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 90));

        add(Borde, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 960, 90));

        LbSeleccione.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        LbSeleccione.setForeground(new java.awt.Color(0, 0, 0));
        LbSeleccione.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LbSeleccione.setText("Seleccione el servicio y monto");
        add(LbSeleccione, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 960, 70));

        LbMonto.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        LbMonto.setForeground(new java.awt.Color(0, 0, 0));
        LbMonto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LbMonto.setText("Monto a pagar:");
        add(LbMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 430, 280, -1));

        TxtMonto.setBackground(new java.awt.Color(255, 255, 255));
        TxtMonto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TxtMonto.setForeground(new java.awt.Color(153, 153, 153));
        TxtMonto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtMonto.setText("Ingrese el monto a pagar....");
        TxtMonto.setBorder(null);
        TxtMonto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TxtMontoMousePressed(evt);
            }
        });
        add(TxtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 480, 280, 30));
        add(Sep2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 510, 280, 10));

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
        jLabel1.setText("Pagar");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 230, 40));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/dollar.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 230, 40));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 580, 230, 100));

        BtEssap.setBackground(new java.awt.Color(13, 71, 161));
        BtEssap.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(13, 71, 161)));
        BtEssap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtEssap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtEssapMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtEssapMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BtEssapMousePressed(evt);
            }
        });
        BtEssap.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LogoEssap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogoEssap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/essap.png"))); // NOI18N
        BtEssap.add(LogoEssap, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 70, 80));

        SepEssap.setBackground(new java.awt.Color(13, 71, 161));
        BtEssap.add(SepEssap, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 90, -1));

        add(BtEssap, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 90, 90));

        BtAnde.setBackground(new java.awt.Color(13, 71, 161));
        BtAnde.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(13, 71, 161)));
        BtAnde.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtAnde.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtAndeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtAndeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BtAndeMousePressed(evt);
            }
        });
        BtAnde.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LogoAnde.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogoAnde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ande.png"))); // NOI18N
        BtAnde.add(LogoAnde, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 70, 70));

        SepAnde.setBackground(new java.awt.Color(13, 71, 161));
        BtAnde.add(SepAnde, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 90, -1));

        add(BtAnde, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 90, 90));

        BtCopaco.setBackground(new java.awt.Color(13, 71, 161));
        BtCopaco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(13, 71, 161)));
        BtCopaco.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtCopaco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtCopacoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtCopacoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BtCopacoMousePressed(evt);
            }
        });
        BtCopaco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LogoCopaco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogoCopaco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/copaco.png"))); // NOI18N
        BtCopaco.add(LogoCopaco, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 70, 70));

        SepCopaco.setBackground(new java.awt.Color(13, 71, 161));
        BtCopaco.add(SepCopaco, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 90, -1));

        add(BtCopaco, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, 90, 90));

        BtNetflix.setBackground(new java.awt.Color(13, 71, 161));
        BtNetflix.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(13, 71, 161)));
        BtNetflix.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtNetflix.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtNetflixMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtNetflixMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BtNetflixMousePressed(evt);
            }
        });
        BtNetflix.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LogoNetflix.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogoNetflix.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/netflix.png"))); // NOI18N
        BtNetflix.add(LogoNetflix, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 70, 70));

        SepNetflix.setBackground(new java.awt.Color(13, 71, 161));
        BtNetflix.add(SepNetflix, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 90, -1));

        add(BtNetflix, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 280, 90, 90));
    }// </editor-fold>//GEN-END:initComponents

    private void TxtMontoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtMontoMousePressed
        // TODO add your handling code here:
        if (TxtMonto.getText().equals("Ingrese el monto a pagar....")){
            TxtMonto.setText("");
            TxtMonto.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_TxtMontoMousePressed

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
        // TODO add your handling code here:
        jPanel2.setBackground(new Color(255, 255, 255));
        jLabel1.setForeground(new Color(13, 71,161));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/dollar_1.png")));
    }//GEN-LAST:event_jPanel2MouseEntered

    private void jPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseExited
        // TODO add your handling code here:
        jPanel2.setBackground(new Color(13, 71,161));
        jLabel1.setForeground(new Color(255, 255,255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/dollar.png")));
    }//GEN-LAST:event_jPanel2MouseExited

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
        if (seleccion >= 0){
            try{
                if (Integer.parseInt(TxtMonto.getText()) <= 0){
                    throw new Exception("");
                }
                Cliente.servicio(Integer.parseInt(user), Integer.parseInt(TxtMonto.getText()), seleccion);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Ingrese correctamente los datos");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Por favor\nSeleccione un servicio");
        }

    }//GEN-LAST:event_jPanel2MousePressed

    private void BtEssapMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtEssapMouseEntered
        // TODO add your handling code here:
        if (seleccion != 0){
            BtEssap.setBackground(new Color(25, 118, 210));
            SepEssap.setBackground(new Color(25, 118, 210));
        }
    }//GEN-LAST:event_BtEssapMouseEntered
    
    private void BtAndeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtAndeMouseEntered
        // TODO add your handling code here:
        if (seleccion != 1){
            BtAnde.setBackground(new Color(25, 118, 210));
            SepAnde.setBackground(new Color(25, 118, 210));
        }
    }//GEN-LAST:event_BtAndeMouseEntered
    
    private void BtCopacoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtCopacoMouseEntered
        // TODO add your handling code here:
        if (seleccion != 2){
            BtCopaco.setBackground(new Color(25, 118, 210));
            SepCopaco.setBackground(new Color(25, 118, 210));
        }
    }//GEN-LAST:event_BtCopacoMouseEntered
    
    private void BtNetflixMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtNetflixMouseEntered
        // TODO add your handling code here:
        if (seleccion != 3){
            BtNetflix.setBackground(new Color(25, 118, 210));
            SepNetflix.setBackground(new Color(25, 118, 210));
        }
    }//GEN-LAST:event_BtNetflixMouseEntered
    
    private void BtEssapMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtEssapMouseExited
        // TODO add your handling code here:
        if (seleccion != 0){
            BtEssap.setBackground(new Color(13, 71, 161));
            SepEssap.setBackground(new Color(13, 71, 161));
        }
    }//GEN-LAST:event_BtEssapMouseExited
    
    private void BtAndeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtAndeMouseExited
        // TODO add your handling code here:
        if (seleccion != 1){
            BtAnde.setBackground(new Color(13, 71, 161));
            SepAnde.setBackground(new Color(13, 71, 161));
        }
    }//GEN-LAST:event_BtAndeMouseExited
    
    private void BtCopacoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtCopacoMouseExited
        // TODO add your handling code here:
        if (seleccion != 2){
            BtCopaco.setBackground(new Color(13, 71, 161));
            SepCopaco.setBackground(new Color(13, 71, 161));
        }
    }//GEN-LAST:event_BtCopacoMouseExited
    
    private void BtNetflixMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtNetflixMouseExited
        // TODO add your handling code here:
        if (seleccion != 3){
            BtNetflix.setBackground(new Color(13, 71, 161));
            SepNetflix.setBackground(new Color(13, 71, 161));
        }
    }//GEN-LAST:event_BtNetflixMouseExited
    
    private void BtEssapMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtEssapMousePressed
        // TODO add your handling code here:
        seleccion = 0;
        BtEssap.setBackground(new Color(255, 255, 255));
        BtAnde.setBackground(new Color(13, 71, 161));
        BtCopaco.setBackground(new Color(13, 71, 161));
        BtNetflix.setBackground(new Color(13, 71, 161));
    }//GEN-LAST:event_BtEssapMousePressed
    
    private void BtAndeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtAndeMousePressed
        // TODO add your handling code here:
        seleccion = 1;
        BtAnde.setBackground(new Color(255, 255, 255));
        BtEssap.setBackground(new Color(13, 71, 161));
        BtCopaco.setBackground(new Color(13, 71, 161));
        BtNetflix.setBackground(new Color(13, 71, 161));
    }//GEN-LAST:event_BtAndeMousePressed
    
    private void BtCopacoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtCopacoMousePressed
        // TODO add your handling code here:
        seleccion = 2;
        BtCopaco.setBackground(new Color(255, 255, 255));
        BtEssap.setBackground(new Color(13, 71, 161));
        BtAnde.setBackground(new Color(13, 71, 161));
        BtNetflix.setBackground(new Color(13, 71, 161));
    }//GEN-LAST:event_BtCopacoMousePressed
    
    private void BtNetflixMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtNetflixMousePressed
        // TODO add your handling code here:
        seleccion = 3;
        BtNetflix.setBackground(new Color(255, 255, 255));
        BtEssap.setBackground(new Color(13, 71, 161));
        BtAnde.setBackground(new Color(13, 71, 161));
        BtCopaco.setBackground(new Color(13, 71, 161));
    }//GEN-LAST:event_BtNetflixMousePressed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Borde;
    private javax.swing.JPanel BtAnde;
    private javax.swing.JPanel BtCopaco;
    private javax.swing.JPanel BtEssap;
    private javax.swing.JPanel BtNetflix;
    private javax.swing.JLabel LbMonto;
    private javax.swing.JLabel LbSeleccione;
    private javax.swing.JLabel LogoAnde;
    private javax.swing.JLabel LogoCopaco;
    private javax.swing.JLabel LogoEssap;
    private javax.swing.JLabel LogoNetflix;
    private javax.swing.JSeparator Sep2;
    private javax.swing.JPanel SepAnde;
    private javax.swing.JPanel SepCopaco;
    private javax.swing.JPanel SepEssap;
    private javax.swing.JPanel SepNetflix;
    private javax.swing.JLabel TituloServicios;
    private javax.swing.JTextField TxtMonto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
