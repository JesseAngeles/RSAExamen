package Llegada;

import java.util.Observable;
import java.util.Observer;
import java.lang.String;
import java.math.BigInteger;

public class FormularioLlegada extends javax.swing.JFrame implements Observer {

    String descifrado = null;
    String dd = null;

    public FormularioLlegada() {
        initComponents();
        this.getRootPane().setDefaultButton(this.Descifrar);
        Servidor s = new Servidor(6000);
        s.addObserver(this);
        Thread t = new Thread(s);
        t.start();

        this.mensajeDescifrado.setLineWrap(true);

        this.mensajeCifrado.setEditable(false);
        this.mensajeDescifrado.setEditable(false);
        this.p.setEditable(false);
        this.q.setEditable(false);
        this.phi.setEditable(false);
        this.n.setEditable(false);
        this.d.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Descifrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mensajeDescifrado = new javax.swing.JTextArea();
        p = new javax.swing.JTextField();
        q = new javax.swing.JTextField();
        d = new javax.swing.JTextField();
        phi = new javax.swing.JTextField();
        n = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        mensajeCifrado = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Descifrar.setText("Descifrar");
        Descifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescifrarActionPerformed(evt);
            }
        });
        getContentPane().add(Descifrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        mensajeDescifrado.setColumns(20);
        mensajeDescifrado.setRows(5);
        jScrollPane1.setViewportView(mensajeDescifrado);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 141));

        p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pActionPerformed(evt);
            }
        });
        getContentPane().add(p, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 160, -1));
        getContentPane().add(q, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 160, -1));
        getContentPane().add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 160, -1));
        getContentPane().add(phi, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 160, -1));
        getContentPane().add(n, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 160, -1));

        jLabel1.setText("Mensaje Cifrado:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jLabel2.setText("Mensaje Descifrado:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel3.setText("VALOR P:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, -1));

        jLabel4.setText("VALOR Q:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, -1));

        jLabel5.setText("VALOR PHI:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, -1, -1));

        jLabel6.setText("VALOR D:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, -1, -1));

        jLabel7.setText("VALOR N:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, -1, -1));
        getContentPane().add(mensajeCifrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 31, 400, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Llegada/fondoNaranja.jpg"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 290));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DescifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescifrarActionPerformed
        this.mensajeDescifrado.setText(descifrado);
        this.d.setText(dd);
    }//GEN-LAST:event_DescifrarActionPerformed

    private void pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pActionPerformed

    }//GEN-LAST:event_pActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Descifrar;
    private javax.swing.JTextField d;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mensajeCifrado;
    private javax.swing.JTextArea mensajeDescifrado;
    private javax.swing.JTextField n;
    private javax.swing.JTextField p;
    private javax.swing.JTextField phi;
    private javax.swing.JTextField q;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        String t = (String) arg;

        String[] valores = t.split("-");
        String msjCifrado = valores[0];
        String valorP = valores[1];
        String valorQ = valores[2];
        String valorPhi = valores[3];
        String valorN = valores[4];
        String valorE = valores[5];

        BigInteger[] cifrados = stringToInteger(msjCifrado);

        BigInteger p = new BigInteger(valorP);
        BigInteger q = new BigInteger(valorQ);
        BigInteger phi = new BigInteger(valorPhi);
        BigInteger n = new BigInteger(valorN);
        BigInteger e = new BigInteger(valorE);

        try {
            RSA rsa = new RSA(p, q, phi, n, e);
            this.descifrado = rsa.descifrar(cifrados);
            this.dd = rsa.getD().toString();
        } catch (Exception er) {
        }

        this.mensajeCifrado.setText(cifrados.toString());
        this.p.setText(valorP);
        this.q.setText(valorQ);
        this.phi.setText(valorPhi);
        this.n.setText(valorN);
        this.mensajeDescifrado.setText("");

    }

    public static BigInteger[] stringToInteger(String cadena) {
        String[] partes = cadena.split(",");
        BigInteger[] coleccion = new BigInteger[partes.length];
        if (partes != null && partes.length > 0) {
            for (int i = 0; i < partes.length; i++) {
                coleccion[i] = new BigInteger(partes[i]);
            }
        }
        return coleccion;
    }
}
