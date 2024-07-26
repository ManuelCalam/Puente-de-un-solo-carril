/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package puenteconuncarrilgraphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author DELL
 */
public class PuenteConUnCarrilGraphics {

    /**
     * @param args the command line arguments
     */
    Puente Carril;
    public JLabel carroLabelNorte, carroLabelSur;
    public ImageIcon carroNorte, carroSur;
    public JLabel carsToNorthTxt;

    public void DibujarVentana() {
        Carril = new Puente();
    
        JFrame frame = new JFrame("Puente de un sólo carril");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);  
        
        JPanel fondo = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imagenFondo = new ImageIcon("src/img/fondo.jpg");
                Image imagen = imagenFondo.getImage();
                g.drawImage(imagen, 0, 0, 800, 450, this);
            }
        };
        frame.setContentPane(fondo);
        
        JButton toNorth = new JButton();
        toNorth = new JButton("Norte");
        toNorth.setBounds(50,30,200,30);
        frame.add(toNorth);
       
        carsToNorthTxt = new JLabel("");
        carsToNorthTxt.setBounds(260,35,50,20);
        carsToNorthTxt.setForeground(Color.ORANGE);
        carsToNorthTxt.setFont(new Font("Tahoma", Font. BOLD, 20));
        frame.add(carsToNorthTxt);
        
        JButton toSouth = new JButton("Sur");
        toSouth.setBounds(450,35,200,30);
        frame.add(toSouth);
        
        JLabel carsToSouthTxt = new JLabel("");
        carsToSouthTxt.setBounds(660,40,50,20);
        carsToSouthTxt.setForeground(Color.ORANGE);
        carsToSouthTxt.setFont(new Font("Tahoma", Font. BOLD, 20));
        frame.add(carsToSouthTxt);
        
        carroNorte = new ImageIcon("src/img/carroNorte.png");
        Image scaledImageNorth = carroNorte.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        carroNorte = new ImageIcon(scaledImageNorth); 
        carroLabelNorte = new JLabel(carroNorte);
        carroLabelNorte.setBounds(-220, 170, 250, 250);
        
        carroSur = new ImageIcon("src/img/carroSur.png");
        Image scaledImageSouth = carroSur.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        carroSur = new ImageIcon(scaledImageSouth);
        carroLabelSur = new JLabel(carroSur);
        carroLabelSur.setBounds(820, 170, 250, 250);

        
        toNorth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Carril.toNorth++;
                if(Carril.entradaSur){
                    Carril.entradaNorte = false;
                    
                }else{
                    Carril.entradaNorte = true;

                }
                Carril.puenteOcupado = true;
                
                frame.add(carroLabelNorte);
                coche car = new coche(Carril, 1, carroLabelNorte);
                car.start();
                //carsToNorthTxt.setText(String.valueOf(Carril.toNorth));
            }
        });
        

        toSouth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                Carril.toSouth++;
                if(Carril.entradaNorte){
                    Carril.entradaSur = false;
                }else{
                    Carril.entradaSur = true;
                }
                Carril.puenteOcupado = true;
                
                frame.add(carroLabelSur);
                coche car = new coche(Carril, 0, carroLabelSur);
                car.start();
                
            }
        });
        
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    
    }
    
}
