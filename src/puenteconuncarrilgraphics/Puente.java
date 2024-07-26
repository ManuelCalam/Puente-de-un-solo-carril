/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package puenteconuncarrilgraphics;

import static java.lang.Thread.sleep;
import javax.swing.JLabel;

/**
 *
 * @author DELL
 */
public class Puente {
    public boolean puenteOcupado = false;
    public boolean entradaNorte = false;
    public boolean entradaSur = false;
    public int toNorth = 0;
    public int toSouth = 0;
    public int leftLimit = 0;
    public int rightLimit = 0;
    
    
    public synchronized void pasarNorteSur(JLabel carroImg) throws InterruptedException {
        
        //System.out.println("Un carro ha pasado de norte a sur, quedan " + toNorth);
        while (toNorth != 0) {
            
            while(puenteOcupado && entradaSur){
                wait();
            }
            
            //System.out.println("Puente ocupado: " + puenteOcupado + "\nEntradaNorte: " + entradaNorte);
            toNorth--;
            while(leftLimit != 70){
                    leftLimit+=2;
                    carroImg.setLocation(carroImg.getX() + leftLimit, carroImg.getY());
                    carroImg.repaint();
                    carroImg.revalidate();
                    sleep(55);
                }
            carroImg.setLocation(-220, carroImg.getY());
            leftLimit = 0;
            Thread.sleep(1000);
            //System.out.println("Un carro cruzó de norte a sur, quedan: " + toNorth);
            
            if(toNorth == 0){
                
                puenteOcupado = false;
                entradaNorte = false;
                //System.out.println("Puente ocupado: " + puenteOcupado + "\nEntradaNorte: " + entradaNorte);
            }
            notifyAll();
        }
    }
    
    public synchronized void pasarSurNorte(JLabel carroImg) throws InterruptedException {
        while (toSouth != 0) {
            
            while(puenteOcupado && entradaNorte){
                wait();
            }
            //System.out.println("Puente ocupado: " + puenteOcupado + "\nEntradaNorte: " + entradaSur);

            toSouth--;
            while(rightLimit != -100){
                    //System.out.println(rightLimit);
                    rightLimit-=2;
                    carroImg.setLocation(carroImg.getX() + rightLimit, carroImg.getY());
                    carroImg.repaint();
                    carroImg.revalidate();
                    sleep(55);
                }
            carroImg.setLocation(820, carroImg.getY());
            rightLimit = 0;
            Thread.sleep(1000);
            //System.out.println("Un carro cruzó de sur a norte, quedan: " + toSouth);
            
            if(toSouth == 0){
                puenteOcupado = false;
                entradaSur = false;
                
                //System.out.println("Puente ocupado: " + puenteOcupado + "\nEntrada sur: " + entradaSur);
            }
            notifyAll();
        }
    }
}
