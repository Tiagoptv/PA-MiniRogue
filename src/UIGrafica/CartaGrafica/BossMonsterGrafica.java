
package UIGrafica.CartaGrafica;

import Modelo.Modelo;
import UIGrafica.UIJogo;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class BossMonsterGrafica extends CartaGrafica {
    
        public JPanel opcoes;

    public BossMonsterGrafica(UIJogo  f, Modelo m, int id) {
        super(f, m, id);
        try {        
            
            imagem =  ImageIO.read(new File(System.getProperty("user.dir")+"\\Imagens\\BossMonster.PNG"));
            Image scaled = imagem.getScaledInstance(150, 225, Image.SCALE_SMOOTH); 
            picLabel = new JLabel(new ImageIcon(scaled));
            
            add(picLabel);
        } catch (IOException ex) {
            Logger.getLogger(CartaGrafica.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        opcoes = new JPanel(new GridBagLayout());
        GridBagConstraints c =new GridBagConstraints();
        
        JButton skip = new JButton("Passar");
        skip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.resolveMerchant(skip.getText());
            }
        });
        
        c.gridx = 2;
        c.gridy = 4;
        c.ipady = 10;
        opcoes.add(skip, c);
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