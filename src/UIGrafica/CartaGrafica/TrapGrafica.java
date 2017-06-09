
package UIGrafica.CartaGrafica;

import Modelo.Modelo;
import UIGrafica.UIJogo;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class TrapGrafica extends CartaGrafica {
    
    
    public TrapGrafica(UIJogo  f, Modelo m) {
        
        super(f, m);
        BufferedImage imagem=null;
        try {        
            
            imagem =  ImageIO.read(new File(System.getProperty("user.dir")+"\\Imagens\\Trap.PNG"));
            Image scaled = imagem.getScaledInstance(150, 225, Image.SCALE_SMOOTH); 
            picLabel = new JLabel(new ImageIcon(scaled));
            
            add(picLabel);
        } catch (IOException ex) {
            Logger.getLogger(CartaGrafica.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
}
