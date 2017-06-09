/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIGrafica;

import Modelo.Modelo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Observable;
import java.util.Observer;
import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class Configuracoes extends JFrame implements Constantes{
    private Modelo modelo;
    private Container cp;
    
    private JLabel dificuldade, area;
    JRadioButton casual, normal, hard, impossible;
    ButtonGroup grupoDificuldade;
    private JTextField nArea;
    private JButton continuar;
    private ImgFundo fundo;
    protected JComboBox areaList ;
    private JPanel wrapper;
    public Integer[ ] listArea = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};

    
    public Configuracoes (Modelo modelo) {
        this(modelo, 750,150, 398, 600);
    }
    
    public Configuracoes(Modelo modelo,int x, int y, int largura, int altura) {

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

    public void criarObjGraf() {
        
        
        
        fundo = new ImgFundo();
        fundo.setLayout(new GridLayout(1,1));

        casual = new JRadioButton("Casual");
        casual.setSelected(true);
        normal = new JRadioButton("Normal");
        hard = new JRadioButton("Hard");
        impossible = new JRadioButton("Impossible");
        
        continuar = new JButton("Continuar");
        
        //criar grupo de botoes
        grupoDificuldade = new ButtonGroup();
        grupoDificuldade.add(casual);
        grupoDificuldade.add(normal);
        grupoDificuldade.add(hard);
        grupoDificuldade.add(impossible);
        
        dificuldade = new JLabel("Dificuldade: ");
        area = new JLabel("Area de inicio: ");
        
        //Create the combo box, select item at index 4.
        //Indices start at 0, so 4 specifies the pig.
        //dim = new Dimension(4, 1);
        //areaList.setPreferredSize(dim);
        //areaList.setMaximumSize( areaList.getPreferredSize() );
        areaList = new JComboBox(listArea);
        
        areaList.setSize(4, 1);
        
        wrapper = new JPanel();
        wrapper.add(areaList);
        
        nArea = new JTextField(1);
        nArea.setText("1");
        
               
    }
    
    public void disporVista() {
        
        Box box = Box.createVerticalBox();
        box.setBorder(new LineBorder(Color.RED, 2));
        box.add(Box.createVerticalStrut(150));
        box.add(dificuldade);
        box.add(casual);
        box.add(normal);
        box.add(hard);
        box.add(impossible);
        box.add(Box.createVerticalStrut(20));
        box.add(area);
        box.add(wrapper);
        box.add(Box.createVerticalStrut(20));
        box.add(continuar);
        box.add(Box.createHorizontalStrut(60));
        box.add(Box.createVerticalStrut(250));

        //Defina o layout desta frame como sendo tipo BorderLayout
        cp.setLayout(new BorderLayout());
          
        //Acresente o painel no centro da frame        
        cp.add(box, BorderLayout.CENTER);
        
        
    }
    
    protected void registarListeners(){
        areaList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer selected = (Integer) (areaList.getSelectedIndex()+1);
                modelo.setArea(selected);
            }
        });
        
        continuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Enumeration<AbstractButton> buttons = grupoDificuldade.getElements(); buttons.hasMoreElements();) {
                    AbstractButton button = buttons.nextElement();
                    if (button.isSelected()) {
                        switch(button.getText()) {
                            case "Casual":
                                modelo.escolherDificuldade(1);
                                break;    
                            case "Normal":
                                modelo.escolherDificuldade(2);
                                break;
                            case "Hard":
                                modelo.escolherDificuldade(3);
                                break;
                            case "Impossible":
                                modelo.escolherDificuldade(4);
                                break;
                        }
                        break;
                    }
                }
                
                modelo.comecarJogo();
                new UIJogo(modelo);
                setVisible(false);
            }
        });
        
    }

}
