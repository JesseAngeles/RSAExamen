package clases;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Cliente implements Runnable {

    private int puerto;
    private String mensaje;
    
    
    public Cliente(int puerto, String mensaje){
        this.puerto = puerto;
        this.mensaje = mensaje;

    }
    
    @Override
    public void run() {
        final String HOST = ""/*DIRECCION IP*/;
        DataOutputStream out;

        try {
            Socket sc = new Socket(HOST, puerto);

            out = new DataOutputStream(sc.getOutputStream());
            out.writeUTF(mensaje);

            sc.close();

        } catch (Exception e) {
            System.out.println("No se ah conectado con ningun cliente.");
        }
        System.out.println("El cliente finalizo la conexión.");
    }
}
