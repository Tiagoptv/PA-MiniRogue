/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIConsola;

import java.io.IOException;
import Model.dados.*;
import java.io.FileNotFoundException;


public class Main {
    public static void main(String args[]) throws IOException, IOException, FileNotFoundException, ClassNotFoundException {
        Jogo j = new Jogo();
        
        System.out.println(""+j.getArea());
        j.setArea(12);
        System.out.println(""+j.getArea());
        j.guardarJogo();
        
        Jogo jogo = new Jogo();
        System.out.println(""+jogo.getArea());
        Menu.ImprimePrincipal(jogo);
        System.out.println(""+jogo.getArea());
    }
}
