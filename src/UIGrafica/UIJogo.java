/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIGrafica;

import Modelo.Modelo;
import UIGrafica.CartaGrafica.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UIJogo extends JFrame implements Observer {

    private Modelo modelo;
    protected String path;
    
    private JPanel dungeon, south, east;
    private JButton botaoTeste;
    private Container cp;

    public UIJogo(Modelo modelo) {
        super("Mini Rogue");
        
        this.path = System.getProperty("user.dir") + "\\Imagens\\";
        this.modelo = modelo;
        
        criaObjectos();
        dispoeObjectos();
        
        
        setLocation(400, 50);
        setSize(1200, 800);
        setResizable(false);
        setMinimumSize(new Dimension(800, 1000));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();
        repaint();
        modelo.addObserver(this);   //Regista-se no jogo como observador
    }

    public void criaObjectos() {

        dungeon = new JPanel(new GridBagLayout());
        south = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        criaDungeon();
        criaInfoArea();
    }
    
    public void dispoeObjectos() 
    {
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
  
        cp.add(dungeon, BorderLayout.NORTH);
        cp.add(south,BorderLayout.SOUTH);
        //cp.add(east, BorderLayout.SOUTH);      
    }
  
    
    private void criaDungeon(){
        CartaGrafica carta;
        GridBagConstraints c = new GridBagConstraints();
        
        carta = new CartaTrasGrafica(this, modelo);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 2;
        c.ipadx = 10;
        dungeon.add(carta, c);

        carta = new RestingGrafica(this, modelo);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 2;
        c.ipady = 5;
        dungeon.add(carta, c);

        carta = new MonsterGrafica(this, modelo);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        c.gridheight = 2;
        dungeon.add(carta, c);
        
        carta = new EventGrafica(this, modelo);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 1;
        c.gridheight = 2;
        c.ipadx = 10;
        dungeon.add(carta, c);
        
        carta = new TrapGrafica(this, modelo);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 0;
        c.gridheight = 2;
        c.ipadx = 10;
        dungeon.add(carta, c);
        
        carta = new MerchantGrafica(this, modelo);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 2;
        c.gridheight = 2;
        c.ipady = 5;
        dungeon.add(carta, c);

        carta = new BossMonsterGrafica(this, modelo);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 4;
        c.gridy = 1;
        c.gridheight = 2;
        dungeon.add(carta, c);
        
    } 
    
    private void  criaInfoArea() {
        CartaGrafica cartaInfo, cartaDungeon;
        
        cartaInfo = new StatsGrafica(this, modelo);
        cartaDungeon = new TheDungeon(this, modelo);
        
        south.add(cartaInfo);
        south.add(cartaDungeon);
        
    }

    
    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

}
