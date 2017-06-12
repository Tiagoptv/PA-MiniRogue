/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIGrafica.CartaGrafica;

import Modelo.Modelo;
import UIGrafica.UIJogo;
import java.awt.Dimension;
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

public class MonsterGrafica extends CartaGrafica {
    
    public JPanel opcoes;
    private UIJogo uijogo;
    private ArrayList<String> nomeBotoes; 
    private ArrayList<JButton> botoes;
    
    
    public MonsterGrafica(UIJogo  f, Modelo m, int id) {
        
        super(f, m, id);
        uijogo = f;
        
        botoes = new ArrayList<JButton>();
        
        nomeBotoes = new ArrayList<String>();
        nomeBotoes.add(0, "Lançar dados");
        nomeBotoes.add(1, "Reroll");
        nomeBotoes.add(2, "Feat");
        nomeBotoes.add(3, "Fire Spell");
        nomeBotoes.add(4, "Ice Spell");
        nomeBotoes.add(5, "Poison Spell");
        nomeBotoes.add(6, "Heal Spell");
                
                
        try {
            imagem =  ImageIO.read(new File(System.getProperty("user.dir")+"\\Imagens\\Monster.PNG"));
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
            JButton botaoAtaque;
            botoes.add( botaoAtaque = new JButton(""+nomeBotoes.get(i-1)));
            botaoAtaque.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    m.resolveAtaque(botaoAtaque.getText());
                }
            });
            c.gridx = 0;
            c.gridy = i-1;
            c.ipady = 10;
            c.fill = GridBagConstraints.BOTH;
            opcoes.add(botaoAtaque,c);
        }
        
            //botao fire
            JButton botaoFire = new JButton("Fire Spell");
            if(m.getJogo().getPersonagem().getFire() < 1)
                        botaoFire.setEnabled(false);
            else botaoFire.setEnabled(true);
            botaoFire.addActionListener( new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //ativar efeito botao
                }
            });
            c.gridx = 0;
            c.gridy = 3;
            c.ipady = 10;
            opcoes.add(botaoFire, c);
            
            //botao ice
            JButton botaoIce = new JButton("Ice Spell");
            if(m.getJogo().getPersonagem().getIce()< 1)
                        botaoIce.setEnabled(false);
            else botaoIce.setEnabled(true);
            botaoIce.addActionListener( new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //ativar efeito botao
                }
            });
            c.gridx = 0;
            c.gridy = 4;
            c.ipady = 10;
            opcoes.add(botaoIce, c);
            
            //botao poison
            JButton botaoPoison = new JButton("Poison Spell");
            if(m.getJogo().getPersonagem().getPoison()< 1)
                        botaoPoison.setEnabled(false);
            else botaoPoison.setEnabled(true);
            botaoPoison.addActionListener( new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //ativar efeito botao
                }
            });
            c.gridx = 0;
            c.gridy = 5;
            c.ipady = 10;
            opcoes.add(botaoPoison, c);
            
            //botao heal
            JButton botaoHeal = new JButton("Heal Spell");
            if(m.getJogo().getPersonagem().getHeal()< 1)
                        botaoHeal.setEnabled(false);
            else botaoHeal.setEnabled(true);
            botaoHeal.addActionListener( new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //ativar efeito botao
                }
            });
            c.gridx = 0;
            c.gridy = 6;
            c.ipady = 10;
            opcoes.add(botaoHeal, c);
        
        
        repaint();
    }
    
            
            
    
    @Override
    protected void paintChildren(Graphics g) {
        super.paintChildren(g); //To change body of generated methods, choose Tools | Templates.
        if( modelo.getJogo().getCartaPorIndex(id).getVisivel() )
            g.drawImage(imagem.getScaledInstance(150, 225, Image.SCALE_SMOOTH), 0, 0, null);
        else
            g.drawImage(imageContraCapa.getScaledInstance(150, 225, Image.SCALE_SMOOTH), 0, 0, null);
        
        
        if(modelo.getJogo().getEstado() instanceof Estado.EsperaAtaque)
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
