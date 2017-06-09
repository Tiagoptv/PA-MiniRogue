/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIGrafica;

import Modelo.Modelo;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;


public class TabuleiroFrame extends JFrame implements Observer , Constantes{
    
    private Modelo modelo;       
    private TabuleiroPanel tabuleiroPanel;
    
    public TabuleiroFrame(Modelo modelo) {
        this(modelo, 400,150, 1200, 800);
    }

    public TabuleiroFrame(Modelo modelo, int x, int y, int largura, int altura) {
        
        super("Mini Rogue"); 

        this.modelo = modelo;
        modelo.addObserver(this);
        
        Container cp = getContentPane(); 
               
        tabuleiroPanel = new TabuleiroPanel(modelo);
        cp.add(tabuleiroPanel, BorderLayout.CENTER);
               
        setLocation(x, y); 
        setSize(largura,altura); 
        setMinimumSize(new Dimension(largura,altura));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();
    
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
    
}
