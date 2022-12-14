/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frontend;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author esteb
 */
public class DepositosP extends javax.swing.JPanel {
    String seleccionado = "";
    String cuenta;
    /**
     * Creates new form InicioP
     */
    public DepositosP(String args) {
        initComponents();
        seleccionado = "efectivo";
        TxtNroCheque.setEditable(false);
        TxtNroCheque.setText("No disponible");
        cuenta = args;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtEfectivo = new javax.swing.JPanel();
        LbEfectivo = new javax.swing.JLabel();
        SepEfectivo = new javax.swing.JPanel();
        Borde = new javax.swing.JPanel();
        TituloDeposito = new javax.swing.JLabel();
        BtCheque = new javax.swing.JPanel();
        LbCheque = new javax.swing.JLabel();
        SepCheque = new javax.swing.JPanel();
        LbSeleccione = new javax.swing.JLabel();
        LbNroCheque = new javax.swing.JLabel();
        Sep1 = new javax.swing.JSeparator();
        TxtNroCheque = new javax.swing.JTextField();
        LbMonto = new javax.swing.JLabel();
        TxtMonto = new javax.swing.JTextField();
        Sep2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        SelEfectivo = new javax.swing.JLabel();
        SelCheque = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(960, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtEfectivo.setBackground(new java.awt.Color(255, 255, 255));
        BtEfectivo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(13, 71, 161)));
        BtEfectivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtEfectivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtEfectivoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtEfectivoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BtEfectivoMousePressed(evt);
            }
        });
        BtEfectivo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LbEfectivo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LbEfectivo.setForeground(new java.awt.Color(13, 71, 161));
        LbEfectivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LbEfectivo.setText("Efectivo");
        BtEfectivo.add(LbEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 170, 60));

        SepEfectivo.setBackground(new java.awt.Color(13, 71, 161));
        SepEfectivo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        BtEfectivo.add(SepEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 170, 10));

        add(BtEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 170, 80));

        Borde.setBackground(new java.awt.Color(13, 71, 161));
        Borde.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TituloDeposito.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        TituloDeposito.setForeground(new java.awt.Color(255, 255, 255));
        TituloDeposito.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TituloDeposito.setText("Deposito en cuenta");
        Borde.add(TituloDeposito, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 90));

        add(Borde, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 960, 90));

        BtCheque.setBackground(new java.awt.Color(13, 71, 161));
        BtCheque.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(13, 71, 161)));
        BtCheque.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtCheque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtChequeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtChequeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BtChequeMousePressed(evt);
            }
        });
        BtCheque.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LbCheque.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LbCheque.setForeground(new java.awt.Color(255, 255, 255));
        LbCheque.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LbCheque.setText("Cheque");
        BtCheque.add(LbCheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 170, 60));

        SepCheque.setBackground(new java.awt.Color(13, 71, 161));
        SepCheque.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        BtCheque.add(SepCheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 170, 10));

        add(BtCheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 170, 80));

        LbSeleccione.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        LbSeleccione.setForeground(new java.awt.Color(0, 0, 0));
        LbSeleccione.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LbSeleccione.setText("Seleccione su m??todo de deposito");
        add(LbSeleccione, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 960, 70));

        LbNroCheque.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        LbNroCheque.setForeground(new java.awt.Color(0, 0, 0));
        LbNroCheque.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LbNroCheque.setText("Numero de cheque:");
        add(LbNroCheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, 280, -1));
        add(Sep1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, 280, 10));

        TxtNroCheque.setBackground(new java.awt.Color(255, 255, 255));
        TxtNroCheque.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TxtNroCheque.setForeground(new java.awt.Color(153, 153, 153));
        TxtNroCheque.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtNroCheque.setText("Ingrese su numero de cheque...");
        TxtNroCheque.setBorder(null);
        TxtNroCheque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TxtNroChequeMousePressed(evt);
            }
        });
        add(TxtNroCheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 280, 30));

        LbMonto.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        LbMonto.setForeground(new java.awt.Color(0, 0, 0));
        LbMonto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LbMonto.setText("Monto a depositar:");
        add(LbMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 440, 280, -1));

        TxtMonto.setBackground(new java.awt.Color(255, 255, 255));
        TxtMonto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TxtMonto.setForeground(new java.awt.Color(153, 153, 153));
        TxtMonto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtMonto.setText("Ingrese el monto a depositar....");
        TxtMonto.setBorder(null);
        TxtMonto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TxtMontoMousePressed(evt);
            }
        });
        add(TxtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 490, 280, 30));
        add(Sep2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 520, 280, 10));

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
        jLabel1.setText("Depositar");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 230, 40));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/deposito.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 230, 40));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 580, 230, 100));

        SelEfectivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SelEfectivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/selec_1.png"))); // NOI18N
        add(SelEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, -1, 80));

        SelCheque.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SelCheque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/selec.png"))); // NOI18N
        add(SelCheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, -1, 80));
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
        // TODO add your handling code here:
        jPanel2.setBackground(new Color(255, 255, 255));
        jLabel1.setForeground(new Color(13, 71,161));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/deposito_1.png")));
    }//GEN-LAST:event_jPanel2MouseEntered

    private void jPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseExited
        // TODO add your handling code here:
        jPanel2.setBackground(new Color(13, 71,161));
        jLabel1.setForeground(new Color(255, 255,255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/deposito.png")));
    }//GEN-LAST:event_jPanel2MouseExited

    private void BtEfectivoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtEfectivoMouseEntered
        // TODO add your handling code here:
        if (seleccionado.equals("cheque")){
            BtEfectivo.setBackground(new Color(25, 118, 210));
            SepEfectivo.setBackground(new Color(25, 118, 210));
        }    
    }//GEN-LAST:event_BtEfectivoMouseEntered
    
    private void BtChequeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtChequeMouseEntered
        // TODO add your handling code here:
        if (seleccionado.equals("efectivo")){
            BtCheque.setBackground(new Color(25, 118, 210));
            SepCheque.setBackground(new Color(25, 118, 210));
        }
    }//GEN-LAST:event_BtChequeMouseEntered
    
    private void BtEfectivoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtEfectivoMouseExited
        // TODO add your handling code here:
        if (seleccionado.equals("cheque")){
            BtEfectivo.setBackground(new Color(13,71, 161));
            SepEfectivo.setBackground(new Color(13,71, 161));
        }
    }//GEN-LAST:event_BtEfectivoMouseExited
    
    private void BtChequeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtChequeMouseExited
        // TODO add your handling code here:
        if (seleccionado.equals("efectivo")){
            BtCheque.setBackground(new Color(13,71, 161));
            SepCheque.setBackground(new Color(13,71, 161));
        }
    }//GEN-LAST:event_BtChequeMouseExited
    
    private void BtEfectivoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtEfectivoMousePressed
        // TODO add your handling code here:
        BtEfectivo.setBackground(new Color(255, 255, 255));
        SelEfectivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/selec_1.png")));
        LbEfectivo.setForeground(new Color(13, 71, 161));
        SepEfectivo.setBackground(new Color(13,71, 161));
        TxtMonto.setText("Ingrese el monto a depositar....");
        TxtMonto.setForeground(new Color(153, 153, 153));
        seleccionado = "efectivo";
        BtCheque.setBackground(new Color(13, 71, 161));
        SelCheque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/selec.png")));
        LbCheque.setForeground(new Color(255, 255, 255));
        SepCheque.setBackground(new Color(13,71, 161));
        TxtNroCheque.setEditable(false);
        TxtNroCheque.setText("No disponible");
        TxtNroCheque.setForeground(new Color(153, 153, 153));
    }//GEN-LAST:event_BtEfectivoMousePressed
    
    private void BtChequeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtChequeMousePressed
        // TODO add your handling code here:
        BtCheque.setBackground(new Color(255, 255, 255));
        SelCheque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/selec_1.png")));
        LbCheque.setForeground(new Color(13, 71, 161));
        SepCheque.setBackground(new Color(13,71, 161));
        TxtNroCheque.setText("Ingrese su numero de cheque...");
        TxtNroCheque.setForeground(new Color(153, 153, 153));
        seleccionado = "cheque";
        BtEfectivo.setBackground(new Color(13, 71, 161));
        SelEfectivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/selec.png")));
        LbEfectivo.setForeground(new Color(255, 255, 255));
        SepEfectivo.setBackground(new Color(13,71, 161));
        TxtNroCheque.setEditable(true);
        TxtMonto.setText("Ingrese el monto a depositar....");
        TxtMonto.setForeground(new Color(153, 153, 153));
    }//GEN-LAST:event_BtChequeMousePressed

    private void TxtNroChequeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtNroChequeMousePressed
        // TODO add your handling code here:
        if (TxtNroCheque.getText().equals("Ingrese su numero de cheque...")){
            TxtNroCheque.setText("");
            TxtNroCheque.setForeground(new Color(0, 0, 0));
        }
        if (TxtMonto.getText().equals("Ingrese el monto a depositar....") || TxtMonto.getText().equals("")){
            TxtMonto.setText("Ingrese el monto a depositar....");
            TxtMonto.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_TxtNroChequeMousePressed

    private void TxtMontoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtMontoMousePressed
        // TODO add your handling code here:
        if (TxtMonto.getText().equals("Ingrese el monto a depositar....")){
            TxtMonto.setText("");
            TxtMonto.setForeground(new Color(0, 0, 0));
        }
        if (TxtNroCheque.getText().equals("No disponible")){
            TxtNroCheque.setForeground(new Color(153, 153, 153));
        }else if (TxtNroCheque.getText().equals("Ingrese su numero de cheque...") || TxtNroCheque.getText().equals("")){
            TxtNroCheque.setText("Ingrese su numero de cheque...");
            TxtNroCheque.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_TxtMontoMousePressed

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
        String [] tipos = {"Efectivo", "Cheque"};
        int nroCheque = 0;
        int monto;
        int tipo = 0;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
        LocalDateTime now = LocalDateTime.now();  
        String fecha = dtf.format(now);
        try{
            if (seleccionado.equals("efectivo")){
                monto = Integer.parseInt(TxtMonto.getText());
                if (monto <= 0){
                    throw new Exception("");
                }
                JOptionPane.showMessageDialog(null, "Ticket generado\nDeposito en Cuenta\nNro de cuenta: " + cuenta + "\nMonto: " + monto + "\nFecha: " + fecha + "\nTipo de deposito: " + tipos[tipo]);
            }else{
                tipo = 1;
                monto = Integer.parseInt(TxtMonto.getText());
                nroCheque = Integer.parseInt(TxtNroCheque.getText());
                if (monto <= 0 || nroCheque <= 0){
                    throw new Exception("");
                }
                JOptionPane.showMessageDialog(null, "Ticket generado\nDeposito en Cuenta\nNro de cuenta: " + cuenta + "\nMonto: " + monto + "\nFecha: " + fecha + "\nTipo de deposito: " + tipos[tipo] + "\nCheque nro: " + nroCheque);
            }
            Cliente.deposito(Integer.valueOf(cuenta), monto, tipo, nroCheque);
            
            
        }catch (Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Ingrese datos v??lidos");
        }
        
        
    }//GEN-LAST:event_jPanel2MousePressed




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Borde;
    private javax.swing.JPanel BtCheque;
    private javax.swing.JPanel BtEfectivo;
    private javax.swing.JLabel LbCheque;
    private javax.swing.JLabel LbEfectivo;
    private javax.swing.JLabel LbMonto;
    private javax.swing.JLabel LbNroCheque;
    private javax.swing.JLabel LbSeleccione;
    private javax.swing.JLabel SelCheque;
    private javax.swing.JLabel SelEfectivo;
    private javax.swing.JSeparator Sep1;
    private javax.swing.JSeparator Sep2;
    private javax.swing.JPanel SepCheque;
    private javax.swing.JPanel SepEfectivo;
    private javax.swing.JLabel TituloDeposito;
    private javax.swing.JTextField TxtMonto;
    private javax.swing.JTextField TxtNroCheque;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
