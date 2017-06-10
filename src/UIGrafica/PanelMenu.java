/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIGrafica;

import Modelo.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class PanelMenu  extends JFrame implements Observer{
    
    private Container cp;
    
    private Modelo modelo;
    private JPanel painel;
    private JButton start, load, exit;
    protected String path;
    private ImgFundo fundo;
    
 
    public PanelMenu(Modelo modelo) {
        this(modelo, 750,150, 398, 600);
    }
    
    public PanelMenu(Modelo modelo, int x, int y, int largura, int altura) {
        super("Mini Rogue"); //Define titulo 
        
        this.modelo = modelo; 
        cp = getContentPane();
        
        criarObjGraf(); // Cria os objectos gr�ficos deste exemplo
        disporVista();  // Faz a montagem visual dos objectos gr�ficos deste exemplo
        registarListeners(); // Liga os objectos gr�ficos aos respectivos listeners
        
        setLocation(x, y); // Define a localiza��o deste componente (frame)
        setSize(largura,altura); // Define as suas dimens�es
        setVisible(true); // Torna-o vis�vel
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Termina a aplica��o quando a frame fechar
        validate();// Disp�e de novo os seus subcomponentes
        setResizable(false);

        
        //repaint();
        
        //Regista-se no jogo como observador
        //modelo.addObserver(this);
    }

    private void criarObjGraf() {
        fundo = new ImgFundo();
        fundo.setLayout(new GridLayout(1,1));
        
        start = new JButton("Start");
        start.setForeground(Color.black); //cor das letras do botao
        start.setBackground(Color.white); //cor do background do botao
        
        load = new JButton("Load");
        load.setForeground(Color.black); //cor das letras do botao
        load.setBackground(Color.white); //cor do background do botao
        
        exit = new JButton("Exit");
        exit.setForeground(Color.black); //cor das letras do botao
        exit.setBackground(Color.white); //cor do background do botao
        
        painel = new JPanel();
        painel.setBackground(Color.white);
        
    }   

    private void disporVista() {
        
        //Defina o layout desta frame como sendo tipo BorderLayout
        cp.setLayout(new BorderLayout());
        
        //Acresente o painel no centro da frame        
        cp.add(fundo, BorderLayout.CENTER);
        cp.add(painel, BorderLayout.SOUTH);
        
        //Acrescente os bot�es ao painel
        painel.add(start);
        painel.add(load); 
        painel.add(exit); 

    }

    protected void registarListeners() {
        start.addActionListener(new AcaoStart());
        load.addActionListener(new acaoLoad());
        exit.addActionListener(new acaoExit());
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    class acaoExit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }

    }

    class acaoLoad implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            modelo.carregarJogo();
            new UIJogo(modelo);
            setVisible(false);
        }

    }

    class AcaoStart implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new Configuracoes(modelo);
            setVisible(false);
        }
        
    }
    
    
    
    
}
