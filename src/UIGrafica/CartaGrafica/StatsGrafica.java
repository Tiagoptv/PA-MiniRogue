
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


public class StatsGrafica extends CartaGrafica {
    
    private BufferedImage tokenArmor;
    private BufferedImage tokenHP;
    private BufferedImage tokenFood;
    private BufferedImage tokenMoney;
    private BufferedImage tokenFire;
    private BufferedImage tokenIce;
    private BufferedImage tokenPoison;
    private BufferedImage tokenHeal;
    
    public StatsGrafica(UIJogo  f, Modelo m) {
        
        super(f, m, 0);
        try {        
            tokenArmor =  ImageIO.read(new File(System.getProperty("user.dir")+"\\Imagens\\token2.PNG"));
            tokenHP =  ImageIO.read(new File(System.getProperty("user.dir")+"\\Imagens\\token2.PNG"));
            tokenFood =  ImageIO.read(new File(System.getProperty("user.dir")+"\\Imagens\\token2.PNG"));
            tokenMoney =  ImageIO.read(new File(System.getProperty("user.dir")+"\\Imagens\\token2.PNG"));
            tokenFire =  ImageIO.read(new File(System.getProperty("user.dir")+"\\Imagens\\token2.PNG"));
            tokenIce =  ImageIO.read(new File(System.getProperty("user.dir")+"\\Imagens\\token2.PNG"));
            tokenPoison =  ImageIO.read(new File(System.getProperty("user.dir")+"\\Imagens\\token2.PNG"));
            tokenHeal =  ImageIO.read(new File(System.getProperty("user.dir")+"\\Imagens\\token2.PNG"));
            imagem =  ImageIO.read(new File(System.getProperty("user.dir")+"\\Imagens\\CaracterStats.PNG"));
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
        
        int armor,food,hp,gold,offsetHPX, offsetMoneyX;
        
        armor = modelo.getJogo().getPersonagem().getArmor();
        food = modelo.getJogo().getPersonagem().getFood();
        hp = modelo.getJogo().getPersonagem().getHp();
        gold = modelo.getJogo().getPersonagem().getGold();

        if(modelo.getJogo().getPersonagem().getHp() > 10){
            offsetHPX = 33;
            hp -= 10;
        }
        else offsetHPX = 0;
        
        if(modelo.getJogo().getPersonagem().getGold()> 10) {
            offsetMoneyX = 33;
            gold -= 10;
        }
        else offsetMoneyX = 0;
        
        int offsetArmor = armor * 35 ;
        int offsetFood = food * 35 ;
        int offsetHP = hp * 35 ;
        int offsetMoney = gold * 35 ;
        
        g.drawImage(tokenArmor, 81, 240-offsetArmor, frame);
        g.drawImage(tokenFood, 264, 275-offsetFood, frame);
        g.drawImage(tokenHP, 154-offsetHPX , 415-offsetHP, frame);
        g.drawImage(tokenMoney, 226-offsetMoneyX, 415-offsetMoney, frame);
        
        if(modelo.getJogo().getPersonagem().getFire() > 0)
            g.drawImage(tokenFire, 81, 310, frame);
        if(modelo.getJogo().getPersonagem().getIce()> 0)
            g.drawImage(tokenIce, 81, 345, frame);
        if(modelo.getJogo().getPersonagem().getPoison()> 0)
            g.drawImage(tokenPoison, 81, 380, frame);
        if(modelo.getJogo().getPersonagem().getHeal()> 0)
            g.drawImage(tokenHeal, 81, 415, frame);
    }
}
    