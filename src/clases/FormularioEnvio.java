package clases;

import java.math.BigInteger;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;

public class FormularioEnvio extends javax.swing.JFrame {

    public FormularioEnvio() {
        initComponents();
        this.getRootPane().setDefaultButton(this.btnEnviar);
        Servidor s = new Servidor(5000);
        Thread t = new Thread(s);
        t.start();

        this.mensaje.setLineWrap(true);

        this.q.setEditable(false);
        this.phi.setEditable(false);
        this.n.setEditable(false);
        this.e.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        btnEnviar = new javax.swing.JButton();
        tamPrimo = new javax.swing.JTextField();
        p = new javax.swing.JTextField();
        q = new javax.swing.JTextField();
        e = new javax.swing.JTextField();
        phi = new javax.swing.JTextField();
        n = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mensaje = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, -1, -1));

        tamPrimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tamPrimoActionPerformed(evt);
            }
        });
        getContentPane().add(tamPrimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 9, 72, -1));

        p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pActionPerformed(evt);
            }
        });
        getContentPane().add(p, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 9, 79, -1));
        getContentPane().add(q, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 44, 79, -1));
        getContentPane().add(e, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 79, 79, -1));
        getContentPane().add(phi, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 119, 79, -1));

        n.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nActionPerformed(evt);
            }
        });
        getContentPane().add(n, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 159, 79, -1));

        jLabel1.setText("Tamaño del primo:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, -1, -1));

        jLabel2.setText("Mensaje:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel3.setText("VALOR P:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 12, -1, -1));

        jLabel4.setText("VALOR Q:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 47, -1, -1));

        jLabel5.setText("VALOR E:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 82, -1, -1));

        jLabel6.setText("VALOR PHI:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 122, -1, -1));

        jLabel7.setText("VALOR N:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 162, -1, -1));

        mensaje.setColumns(20);
        mensaje.setRows(5);
        jScrollPane1.setViewportView(mensaje);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, 120));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clases/fondoAzul.jpg"))); // NOI18N
        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 220));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        int tamPrimito;
        String tamPrimo = this.tamPrimo.getText();
        try {
            tamPrimito = Integer.parseInt(tamPrimo);
        } catch (Exception e) {
            tamPrimito = 0;
        }

        if (tamPrimo != null && tamPrimito > 10) {
            RSA rsa = new RSA(tamPrimito);
            
            rsa.GenerarPrimos();
            rsa.GenerarClaves();

            String mensajeEnvio = this.mensaje.getText();
            if (mensajeEnvio != null && mensajeEnvio.length() > 0) {
                BigInteger[] cifradoBig = rsa.encritpar(mensajeEnvio);
                String cadenaCifradaString = IntegerToString(cifradoBig);

                String msjClaro = rsa.descifrar(cifradoBig);
                rsa.setMensajeDescifrado(msjClaro);

                String p = rsa.getP().toString();
                String q = rsa.getQ().toString();
                String phi = rsa.getPhi().toString();
                String n = rsa.getN().toString();
                String e = rsa.getE().toString();
                String d = rsa.getD().toString();

                this.p.setText(p);
                this.q.setText(q);
                this.phi.setText(phi);
                this.n.setText(n);
                this.e.setText(e);

                String conjuntoValores = cadenaCifradaString + "-" + p + "-" + q + "-" + phi + "-" + n + "-" + e;

                Cliente c = new Cliente(6000, conjuntoValores);
                Thread t = new Thread(c);

                t.start();
            } else {
                JOptionPane.showMessageDialog(null, "El mensaje no puede estar vacio.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un numero valido.");
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    public static String IntegerToString(BigInteger[] arregloBigInt) {
        StringBuilder strBigInteger = new StringBuilder("");
        if (arregloBigInt != null && arregloBigInt.length > 0) {
            for (int i = 0; i < arregloBigInt.length; i++) {
                strBigInteger.append(arregloBigInt[i].toString());
                if (i != arregloBigInt.length - 1) {
                    strBigInteger.append(",");
                }
            }
        }
        return strBigInteger.toString();
    }

    private void tamPrimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamPrimoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tamPrimoActionPerformed

    private void nActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nActionPerformed

    private void pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JTextField e;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea mensaje;
    private javax.swing.JTextField n;
    private javax.swing.JTextField p;
    private javax.swing.JTextField phi;
    private javax.swing.JTextField q;
    private javax.swing.JTextField tamPrimo;
    // End of variables declaration//GEN-END:variables

}
