/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIGrafica;

import Model.dados.*;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UIJogo extends JFrame implements Observer {

    private Modelo modelo;
    protected String path;
    private GridBagConstraints c;
    public JPanel dungeon, south;
    public JLabel estadoLabel;
    private Container cp;
    private JButton guardar;
    
    private ArrayList<Carta> cartas;

    public UIJogo(Modelo modelo) {
        super("Mini Rogue");
        
        this.path = System.getProperty("user.dir") + "\\Imagens\\";
        this.modelo = modelo;
        
        criaObjectos();
        dispoeObjectos();
        registarListeners();
        
        
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
        estadoLabel = new JLabel("qualquercoisita");
        criaDungeon();
        criaInfoArea();
        //mostraCarta();
    }
    
    public void dispoeObjectos() {
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
  
        cp.add(estadoLabel, BorderLayout.LINE_END);
        cp.add(dungeon, BorderLayout.NORTH);
        cp.add(south,BorderLayout.SOUTH);
           
    }
  
    
    private void criaDungeon(){
        CartaGrafica carta=null;
        int gridx = 0, gridy = 0, ipadx = 0, ipady= 0;
        c = new GridBagConstraints();
        cartas = modelo.getJogo().getCartas();
        
       
        
        for(int i = 0; i < cartas.size(); i++){
            Carta card = cartas.get(i);
            if( card instanceof BossMonster)    carta = new BossMonsterGrafica(this, modelo, i);
            if( card instanceof Event)          carta = new EventGrafica(this, modelo, i);
            if( card instanceof Merchant)       carta = new MerchantGrafica(this, modelo, i);
            if( card instanceof Monster)        carta = new MonsterGrafica(this, modelo, i);
            if( card instanceof Resting)        carta = new RestingGrafica(this, modelo, i);
            if( card instanceof Trap)           carta = new TrapGrafica(this, modelo, i);
            if( card instanceof Treasure)       carta = new TreasureGrafica(this, modelo, i);
            
            switch (i) {
                    case 0:
                        gridx=0;
                        gridy=1;
                        ipadx = 10;
                        ipady = 0;
                        break;
                    case 1:
                        gridx=1;
                        gridy=0;
                        ipadx = 0;
                        ipady = 5;
                        break;
                    case 2:
                        gridx=1;
                        gridy=2;
                        ipadx = 0;
                        ipady = 0;
                        break;
                    case 3:
                        gridx=2;
                        gridy=1;
                        ipadx = 10;
                        ipady = 0;
                        break;
                    case 4:
                        gridx=3;
                        gridy=0;
                        ipadx = 0;
                        ipady = 5;
                        break;
                    case 5:
                        gridx=3;
                        gridy=2;
                        ipadx = 0;
                        ipady = 0;
                        break;
                    case 6:
                        gridx=4;
                        gridy=1;
                        ipadx = 10;
                        ipady = 5;
                        break;
                    default:
                        break;
                }
            
            
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = gridx;
            c.gridy = gridy;
            c.gridheight = 2;
            c.ipadx = ipadx;
            c.ipady = ipady;
            dungeon.add(carta, c);
        }
       
    }  
    
    private void  criaInfoArea() {
        CartaGrafica cartaInfo, cartaDungeon;
        
        cartaInfo = new StatsGrafica(this, modelo);
        cartaDungeon = new TheDungeon(this, modelo);
        
        guardar = new JButton("Guardar");
        
        south.add(cartaInfo);
        south.add(cartaDungeon);
        south.add(guardar);   
    }
    
    protected void registarListeners(){
        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    modelo.guardarJogo();
                } catch (IOException ex) {
                    Logger.getLogger(UIJogo.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }
    
    @Override
    public void update(Observable o, Object arg) {
        estadoLabel.setText(""+modelo.getJogo().getEstado().toString());
        repaint();
    }

    

}
