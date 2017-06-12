
package UIGrafica.CartaGrafica;

import Model.dados.Carta;
import Model.dados.Treasure;
import Modelo.Modelo;
import UIGrafica.UIJogo;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class TreasureGrafica extends CartaGrafica {
    
    
    public TreasureGrafica(UIJogo  f, Modelo m, int id) {
        super(f, m, id);
        try {        
            
            imagem =  ImageIO.read(new File(System.getProperty("user.dir")+"\\Imagens\\Treasure.PNG"));
            Image scaled = imagem.getScaledInstance(150, 225, Image.SCALE_SMOOTH); 
            picLabel = new JLabel(new ImageIcon(scaled));
            
            add(picLabel);
        } catch (IOException ex) {
            Logger.getLogger(CartaGrafica.class.getName()).log(Level.SEVERE, null, ex);
        }
        revalidate();
        repaint();
    }

    
    @Override
    protected void paintChildren(Graphics g) {
        super.paintChildren(g); //To change body of generated methods, choose Tools | Templates.
        if( modelo.getJogo().getCartaPorIndex(id).getVisivel() )
            g.drawImage(imagem.getScaledInstance(150, 225, Image.SCALE_SMOOTH), 0, 0, null);
        else
            g.drawImage(imageContraCapa.getScaledInstance(150, 225, Image.SCALE_SMOOTH), 0, 0, null);
        
    }
    
    
}
