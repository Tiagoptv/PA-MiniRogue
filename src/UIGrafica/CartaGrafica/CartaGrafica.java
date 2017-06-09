
package UIGrafica.CartaGrafica;

import Modelo.Modelo;
import UIGrafica.UIJogo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CartaGrafica extends JPanel
{
    UIJogo frame;
    Modelo modelo;
    JLabel picLabel;
    

    public CartaGrafica(UIJogo  f, Modelo m)
    {	 
        frame = f;	
        modelo = m;
        setVisible(true);
        setLayout(new BorderLayout());
        setOpaque(false);
        
        
        
        
        addMouseListener( new MouseAdapter() 
        {
            @Override
            public void mousePressed(MouseEvent e) 
            {
                
            }
        });
        
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
      

    }
}
