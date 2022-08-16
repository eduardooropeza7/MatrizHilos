/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matrices;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josee
 */
public class Hilos extends Thread{
    int id;
    int valor;
    Matrices matriz;
    
    public Hilos(int id, Matrices matriz){
        this.id=id;
        this.matriz=matriz;
    }
    
    public void run(){
        try {
            switch(id){
                case 1:
                    
                    hilo1();

                    break;

                case 2:

                    hilo2();

                    break;

                default:
                    System.out.println("Opción no disponible");
                    break;
            }
        } catch (InterruptedException ex) {}
    }
    
    private void hilo1() throws InterruptedException{
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.println("("+this.matriz.x+", "+this.matriz.y+")");      
                this.matriz.moverY();
                Thread.sleep(1000);          
            }
            this.matriz.moverX();
        }
    }
    
    private void hilo2() throws InterruptedException{
        int t=0;
        while(t<=8){
            Thread.sleep(1000);
            this.matriz.multiplicarVal(2);
            t++;
            System.out.println("");
        }
    }
}