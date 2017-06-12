/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIGrafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImgFundo extends JComponent
{
    private JButton b1 = new JButton("Start");
    private JButton b2 = new JButton("Load");
    private JButton b3 = new JButton("Exit");
    JPanel mainPanel = new JPanel();

    private String path = System.getProperty("user.dir")+"\\Imagens\\";
    
    
    public ImgFundo() {
      
        b1.setAlignmentX(CENTER_ALIGNMENT);
        b2.setAlignmentX(CENTER_ALIGNMENT);
        b3.setAlignmentX(CENTER_ALIGNMENT);
        
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        setLayout(new BorderLayout());
	JLabel background=new JLabel(new ImageIcon(path + "ImgFundo.png"));
	add(background);
        
    }

    
}