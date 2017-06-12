
package UIGrafica.CartaGrafica;

import Modelo.Modelo;
import UIGrafica.UIJogo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CartaGrafica extends JPanel
{
    public UIJogo frame;
    Modelo modelo;
    JLabel picLabel;
    Integer id;
    public BufferedImage imagem, imageContraCapa;
    
    public CartaGrafica(UIJogo  f, Modelo m, int id)
    {	 
        this.id = id;
        frame = f;	
        modelo = m;
        setVisible(true);
        setLayout(new BorderLayout());
        setOpaque(false);
        
        try {        
            
            imageContraCapa =  ImageIO.read(new File(System.getProperty("user.dir")+"\\Imagens\\ContraCapaCarta.PNG"));
            Image scaled = imageContraCapa.getScaledInstance(150, 225, Image.SCALE_SMOOTH); 
            picLabel = new JLabel(new ImageIcon(scaled));
            add(picLabel);
        } catch (IOException ex) {
            Logger.getLogger(CartaGrafica.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        addMouseListener( new MouseAdapter() 
        {
            @Override
            public void mousePressed(MouseEvent e) 
            {
                modelo.escolherCarta(id);
                revalidate();
                repaint();
            }
        });
    }    
    
}
