/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package puenteconuncarrilgraphics;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author DELL
 */
public class coche extends Thread{
    public Puente puente;
    public int direccion;
    public JLabel carroImg;
    
    public coche(Puente puente, int direccion, JLabel carroImg){
        this.puente = puente;
        this.direccion = direccion;
        this.carroImg = carroImg;
    }
    
    public void run(){
        if(direccion == 1){
            try {
                puente.pasarNorteSur(carroImg);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(coche.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            try{
                puente.pasarSurNorte(carroImg);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(coche.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

