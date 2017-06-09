
package UIGrafica;

import Modelo.Modelo;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TabuleiroPanel extends JPanel implements Observer , Constantes{

    private Modelo modelo;
    
    private JLabel tabuleiroLabel;
    private String path;
    private JPanel tabuleiro, cartasInfo;
    

           
    public TabuleiroPanel(Modelo modelo) {
        
        path = System.getProperty("user.dir")+"\\Imagens\\";
        
        this.modelo = modelo;
        this.modelo.addObserver(this);
        
        setupComponents(); 
        setupLayout();
        
        //repaint no update?
        //update(modelo, null);
    }
    
    private void setupComponents() {
       
        
    }

    private void setupLayout() {
        
    }
    
    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
