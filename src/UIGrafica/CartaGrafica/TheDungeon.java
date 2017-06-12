
package UIGrafica.CartaGrafica;

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


public class TheDungeon extends CartaGrafica {
    
    private BufferedImage tokenArea;
    //private BufferedImage tokenMonsterHP;
    
    public TheDungeon(UIJogo  f, Modelo m) {
        
        super(f, m, 0);
        try {        
            
            tokenArea =  ImageIO.read(new File(System.getProperty("user.dir")+"\\Imagens\\token2.PNG"));
            //tokenMonsterHP =  ImageIO.read(new File(System.getProperty("user.dir")+"\\Imagens\\token2.PNG"));
            imagem =  ImageIO.read(new File(System.getProperty("user.dir")+"\\Imagens\\TheDungeon.PNG"));
            Image scaled = imagem.getScaledInstance(300, 450, Image.SCALE_SMOOTH); 
            picLabel = new JLabel(new ImageIcon(scaled));
            
            add(picLabel);
        } catch (IOException ex) {
            Logger.getLogger(CartaGrafica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void paintChildren(Graphics g) {
        super.paintChildren(g); //To change body of generated methods, choose Tools | Templates.
        int area = modelo.getJogo().getArea();
        int offsetX = 0;
        int offsetY = 0;
        switch( area ){
            case 0: break;
            case 1: 
                offsetX += 32;
                break;
            case 2: 
                offsetY += 55;
                break;
            case 3: 
                offsetX += 32;
                offsetY += 55;
                break;
            case 4: 
                offsetY += 110;
                break;
            case 5: 
                offsetY += 110;
                offsetX += 32;
                break;
            case 6: 
                offsetY += 110;
                offsetX += 65;
                break;
            case 7: 
                offsetY += 165;
                break;
            case 8: 
                offsetY += 165;
                offsetX += 32;
                break;
            case 9: 
                offsetY += 165;
                offsetX += 65;
                break;
            case 10: 
                offsetY += 220;
                break;
            case 11: 
                offsetY += 220;
                offsetX += 32;
                break;
            case 12: 
                offsetY += 220;
                offsetX += 65;
                break;
            case 13: 
                offsetY += 220;
                offsetX += 97;
                break;
        }
        
        g.drawImage(tokenArea, 28+offsetX, 180+offsetY, frame);
        //g.drawImage(tokenMonsterHP, 28+offsetX, 180+offsetY, frame);
        
    }
    
}
