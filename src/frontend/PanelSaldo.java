/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frontend;

import backend.Formatear;

/**
 *
 * @author esteb
 */
public class PanelSaldo extends javax.swing.JPanel {

    /**
     * Creates new form PanelSaldo
     */
    public PanelSaldo() {
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

        Borde2 = new javax.swing.JPanel();
        Borde1 = new javax.swing.JPanel();
        LbSaldo = new javax.swing.JLabel();
        TxtSaldo = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Borde2.setBackground(new java.awt.Color(13, 71, 161));

        javax.swing.GroupLayout Borde2Layout = new javax.swing.GroupLayout(Borde2);
        Borde2.setLayout(Borde2Layout);
        Borde2Layout.setHorizontalGroup(
            Borde2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        Borde2Layout.setVerticalGroup(
            Borde2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        add(Borde2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 620, 10));

        Borde1.setBackground(new java.awt.Color(13, 71, 161));

        javax.swing.GroupLayout Borde1Layout = new javax.swing.GroupLayout(Borde1);
        Borde1.setLayout(Borde1Layout);
        Borde1Layout.setHorizontalGroup(
            Borde1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        Borde1Layout.setVerticalGroup(
            Borde1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        add(Borde1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 10));

        LbSaldo.setBackground(new java.awt.Color(0, 0, 0));
        LbSaldo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        LbSaldo.setForeground(new java.awt.Color(0, 0, 0));
        LbSaldo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LbSaldo.setText("Su saldo de cuenta es:");
        add(LbSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 600, 130));

        TxtSaldo.setEditable(false);
        TxtSaldo.setBackground(new java.awt.Color(255, 255, 255));
        TxtSaldo.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        TxtSaldo.setForeground(new java.awt.Color(13, 71, 161));
        TxtSaldo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtSaldo.setText(" Gs.");
        TxtSaldo.setBorder(null);
        add(TxtSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 600, 130));
    }// </editor-fold>//GEN-END:initComponents

    public void setSaldo(String saldo){
        TxtSaldo.setText(Formatear.monto(saldo));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Borde1;
    private javax.swing.JPanel Borde2;
    private javax.swing.JLabel LbSaldo;
    private javax.swing.JTextField TxtSaldo;
    // End of variables declaration//GEN-END:variables
}
