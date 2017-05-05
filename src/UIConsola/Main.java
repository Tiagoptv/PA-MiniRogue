/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIConsola;

import java.io.IOException;
import Model.dados.*;
/**
 *
 * @author Diogo
 */
public class Main {
    public static void main(String args[]) {
        int op;
        Merchant m = new Merchant();
        op = Menu.ImprimePrincipal();//Menu.ImprimeCarrega();

        if(op == 1){
            m.desenhaCarta();
        }
    }
}
