/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package puenteconuncarrilgraphics;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author DELL
 */
public class DibujarCarro{
    Image imagenes[] = new Image[2];
    int ProgresoCarro;
    public Puente Carril; 
    
    public DibujarCarro(Puente Carril){
        imagenes[0] = new ImageIcon("src/img/carroNorte.png").getImage();
        imagenes[1] = new ImageIcon("src/img/carroSur.png").getImage();
        this.Carril = Carril;

    }
    
    /*@Override
    public void paintComponent(Graphics g){
        
        repaint();
        super.paintComponent(g);
        System.out.println("asf");
        
        if (Carril.carroNorte) {
           {
                
                g.drawImage(imagenes[0], ProgresoCarro, 20, this);    
            }
        }
        else{
              g.drawImage(imagenes[1], ProgresoCarro, 20, this);  
        }
    }*/
    
    public void updateProgress(int Progreso){
       ProgresoCarro = Progreso;
    }
}
