
package UIGrafica.CartaGrafica;

import Model.dados.Merchant;
import Modelo.Modelo;
import UIGrafica.UIJogo;
import com.sun.imageio.plugins.jpeg.JPEG;
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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


public class MerchantGrafica extends CartaGrafica {
    
    public JPanel opcoes;
    private UIJogo uijogo;
    private ArrayList<String> nomeBotoes; 
    private ArrayList<JButton> botoes;

    public MerchantGrafica(UIJogo  f, Modelo m, int id) {
        super(f, m, id);
        uijogo = f;
        
        botoes = new ArrayList<JButton>();
        
        nomeBotoes = new ArrayList<String>();
        nomeBotoes.add(0, "1 - Ration: +1Food");
        nomeBotoes.add(1, "1 - HealthPotion: +1HP");
        nomeBotoes.add(2, "3 - BigHealthPotion: +4HP");
        nomeBotoes.add(3, "6 - ArmorPiece: +1Armor");
        nomeBotoes.add(4, "8 - Any 1 Spell");
        nomeBotoes.add(5, "3 - ArmorPiece");
        nomeBotoes.add(6, "4 - Any 1 Spell");
        
        try {        
            
            imagem =  ImageIO.read(new File(System.getProperty("user.dir")+"\\Imagens\\Merchant.PNG"));
            Image scaled = imagem.getScaledInstance(150, 225, Image.SCALE_SMOOTH); 
            picLabel = new JLabel(new ImageIcon(scaled));
            
            add(picLabel);
        } catch (IOException ex) {
            Logger.getLogger(CartaGrafica.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        opcoes = new JPanel(new GridBagLayout());
        GridBagConstraints c =new GridBagConstraints();
        
        for(int i = 1; i < 6; i++)
        {
            JButton botaoCompra;
            botoes.add( botaoCompra = new JButton(""+nomeBotoes.get(i-1)));
            botaoCompra.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    m.realizaCompra(botaoCompra.getText());
                }
            });
            c.gridx = 0;
            c.gridy = i-1;
            c.ipady = 10;
            c.fill = GridBagConstraints.BOTH;
            opcoes.add(botaoCompra,c);
        }
        
        for(int i = 1; i < 3; i++)
        {
            JButton botaoVenda;
            botoes.add( botaoVenda = new JButton(""+nomeBotoes.get(i+4)));
            botaoVenda.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    m.realizaVenda(botaoVenda.getText());
                }
            });
            c.gridx = 2;
            c.gridy = i-1;
            c.ipady = 10;
            opcoes.add(botaoVenda, c);
        }
        
        JButton skip = new JButton("Passar");
        skip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.mercadoriaPassar();
            }
        });
        c.gridx = 2;
        c.gridy = 4;
        c.ipady = 10;
        opcoes.add(skip, c);
        
        
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo.mercadoriaPassar();
            }
        });
    }

    
    
    @Override
    protected void paintChildren(Graphics g) {
        super.paintChildren(g); //To change body of generated methods, choose Tools | Templates.
        if( modelo.getJogo().getCartaPorIndex(id).getVisivel() )
            g.drawImage(imagem.getScaledInstance(150, 225, Image.SCALE_SMOOTH), 0, 0, null);
        else
            g.drawImage(imageContraCapa.getScaledInstance(150, 225, Image.SCALE_SMOOTH), 0, 0, null);
        
        
        if(modelo.getJogo().getEstado() instanceof Estado.EsperaTroca)
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