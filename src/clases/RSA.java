package clases;

import clases.*;
import java.util.*;
import java.math.BigInteger;
import java.io.*;

public class RSA {
    int tamPrimo;
    BigInteger p,q,n;
    BigInteger phi;
    BigInteger e, d;
    
    String mensajeDescifrado;

    public RSA(int tamPrimo){
        this.tamPrimo = tamPrimo;
    }
    
    public RSA(BigInteger p,BigInteger q,BigInteger phi,BigInteger n, BigInteger e){
        this.p = p;
        this.q = q;
        this.phi = phi;
        this.n = n;
        this.e = e;
    }
    
    public void GenerarPrimos(){
        p = new BigInteger(tamPrimo, 10,new Random());
        do q = new BigInteger(tamPrimo, 10, new Random());
            while(q.compareTo(p) == 0);
    }
    
    public void GenerarClaves(){
        n = p.multiply(q);
        phi = p.subtract(BigInteger.valueOf(1));
        phi = phi.multiply(q.subtract(BigInteger.valueOf(1)));
        
        do e = new BigInteger(2 * tamPrimo, new Random());
            while((e.compareTo(phi) != -1) || (e.gcd(phi).compareTo(BigInteger.valueOf(1)) != 0));
        d = e.modInverse(phi);
    }
    
    public BigInteger[] encritpar(String mensaje){
        int i;
        byte[] temp = new byte[1];
        byte[] digitos = mensaje.getBytes();
        BigInteger[] bigdigitos = new BigInteger[digitos.length];

        for (i = 0; i < bigdigitos.length; i++) {
            temp[0] = digitos[i];
            bigdigitos[i] = new BigInteger(temp);
        }

        BigInteger[] cifrado = new BigInteger[bigdigitos.length];
        
        for (i = 0; i < bigdigitos.length; i++) {
            cifrado[i] = bigdigitos[i].modPow(e, n);
        }
        
        return cifrado;
    }

    public String descifrar(BigInteger[] cifrado){
        BigInteger[] descifrado = new BigInteger[cifrado.length];
        for (int i = 0; i < descifrado.length; i++) {
            descifrado[i] = cifrado[i].modPow(d, n);
        }
        
        char[] charArray = new char[descifrado.length];
        
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = (char)(descifrado[i].intValue());
        }
        
        return (new String(charArray));
    }
    
    public int getTamPrimo() {
        return tamPrimo;
    }

    public void setTamPrimo(int tamPrimo) {
        this.tamPrimo = tamPrimo;
    }

    public BigInteger getP() {
        return p;
    }

    public void setP(BigInteger p) {
        this.p = p;
    }

    public BigInteger getQ() {
        return q;
    }

    public void setQ(BigInteger q) {
        this.q = q;
    }

    public BigInteger getN() {
        return n;
    }

    public void setN(BigInteger n) {
        this.n = n;
    }

    public BigInteger getPhi() {
        return phi;
    }

    public void setPhi(BigInteger phi) {
        this.phi = phi;
    }

    public BigInteger getE() {
        return e;
    }

    public void setE(BigInteger e) {
        this.e = e;
    }

    public BigInteger getD() {
        d = e.modInverse(phi);
        return d;
        
    }

    public void setD(BigInteger d) {
        this.d = d;
    }
    
    public String getMensajeDescifrado() {
        return mensajeDescifrado;
    }

    public void setMensajeDescifrado(String mensajeDescifrado) {
        this.mensajeDescifrado = mensajeDescifrado;
    }
    
}
