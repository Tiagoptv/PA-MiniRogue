/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIConsola;

import java.io.IOException;
import Model.dados.*;
import Modelo.Modelo;
import UIGrafica.*;


public class Main {
    public static void main(String args[]) {

            //new UITexto (new Jogo()).corre();
            //new Configuracoes();
            new PanelMenu(new Modelo(new Jogo()));
            //new UIJogo(new Modelo(new Jogo()));
            //new TabuleiroFrame();
                
    }
}
