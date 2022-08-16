/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package matrices;

/**
 *
 * @author josee
 */

import java.util.Arrays;
public class Matrices {

   public static void main(String[] args) throws InterruptedException {
        Matrices matriz=new Matrices(true);
        
        matriz.printMatriz();
        
        Hilos hilo1=new Hilos(1,matriz);
        Hilos hilo2=new Hilos(2,matriz);
        
        hilo2.start();
        hilo1.start();
        
        hilo2.join();
        hilo1.join();
        
        System.out.println("Matriz Final: ");
        matriz.printMatriz();
    }
    
    int[][] matriz;
    int x,y;
    boolean inicia;
        
    
    public Matrices(boolean inicia){
        this.inicia=inicia;
        
        if(inicia){
            this.x=0;
            this.y=0;
            matriz=new int[3][3];
            rellenaMatriz();
        }
    }
    
    public void moverX(){
        if(this.x>=0&&this.x<2){
            this.x++;
        }else{
            this.x=0;
        }
    }
    
    public void moverY(){
        if(this.y>=0&&this.y<2){
            this.y++;
        }else{
            this.y=0;
        }
    }
    
    public void multiplicarVal(int m){
        matriz[this.x][this.y]*=m;
    }
    
    public void rellenaMatriz(){
        for(int i=0; i<matriz.length ;i++){
            for(int j=0; j<matriz.length ;j++){
                matriz[i][j]=(int)(Math.random()*(100-0))+0;
            }
        }
    }
    
    public void printMatriz(){
        if(!(matriz==null)){   
            for(int i=0; i<matriz.length ;i++){
                System.out.println(Arrays.toString(matriz[i]));
            }
        }else{
            System.out.println("Vacio");
        }
    }
    
    
}
