
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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class RestingGrafica extends CartaGrafica {
    
    public JPanel opcoes;
    private UIJogo uijogo;
    private ArrayList<String> nomeBotoes; 
    private ArrayList<JButton> botoes;
    
    public RestingGrafica(UIJogo  f, Modelo m, int id) {
        
        super(f, m, id);
        uijogo = f;
        
        botoes = new ArrayList<JButton>();
        
        nomeBotoes = new ArrayList<String>();
        nomeBotoes.add(0, "Reinforce your Weapon : +1XP");
        nomeBotoes.add(1, "Search for Ration: +1Food");
        nomeBotoes.add(2, "Heal: +2HP");
        
        try {        
            
            imagem =  ImageIO.read(new File(System.getProperty("user.dir")+"\\Imagens\\Resting.PNG"));
            Image scaled = imagem.getScaledInstance(150, 225, Image.SCALE_SMOOTH); 
            picLabel = new JLabel(new ImageIcon(scaled));
            
            add(picLabel);
        } catch (IOException ex) {
            Logger.getLogger(CartaGrafica.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        opcoes = new JPanel(new GridBagLayout());
        GridBagConstraints c =new GridBagConstraints();
        
        for(int i = 1; i < 4; i++)
        {
            JButton botaoRest;
            botoes.add( botaoRest = new JButton(""+nomeBotoes.get(i-1)));
            botaoRest.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    m.resolveResting(botaoRest.getText());
                }
            });
            c.gridx = 0;
            c.gridy = i-1;
            c.ipady = 10;
            c.fill = GridBagConstraints.BOTH;

            opcoes.add(botaoRest, c);
        }
        
    }

    @Override
    protected void paintChildren(Graphics g) {
        super.paintChildren(g); //To change body of generated methods, choose Tools | Templates.
        if( modelo.getJogo().getCartaPorIndex(id).getVisivel() )
            g.drawImage(imagem.getScaledInstance(150, 225, Image.SCALE_SMOOTH), 0, 0, null);
        else
            g.drawImage(imageContraCapa.getScaledInstance(150, 225, Image.SCALE_SMOOTH), 0, 0, null);
        
        
        if(modelo.getJogo().getEstado() instanceof Estado.EsperaEscolhaRest)
        {
            uijogo.south.add(opcoes);
            revalidate();
            repaint();
        }
        else{
            uijogo.south.remove(opcoes);
        }
    }
}
