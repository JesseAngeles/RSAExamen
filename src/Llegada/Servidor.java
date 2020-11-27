package Llegada;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

public class Servidor extends Observable implements Runnable {

    private int puerto;
    private String m;
    
    public Servidor(int puerto){
        this.puerto = puerto;
    }
    
    @Override
    public void run() {

        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;

        try {
            servidor = new ServerSocket(puerto);
            System.out.println("El servidor fue iniciado");

            while (true) {
                sc = servidor.accept();
                System.out.println("Se ah conectado un cliente");

                in = new DataInputStream(sc.getInputStream());

                String mensaje = in.readUTF();
                System.out.println(mensaje);

                this.setChanged();
                this.notifyObservers(mensaje);
                this.clearChanged();
                
                sc.close();                
            }
        } catch (Exception e) {
            System.out.println("Cliente desconectado debido a un ERROR");
        }
        System.out.println("El cliente finalizo la conexión.");
    }
    
}
