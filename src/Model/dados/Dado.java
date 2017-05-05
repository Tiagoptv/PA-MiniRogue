/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dados;

import java.util.ArrayList;

/**
 *
 * @author Diogo
 */
public class Dado {
    
    Dado(){}
    
    public static int lancaDado(){
        return (int)(Math.random()*6) + 1;
    }
    
    public static ArrayList<Integer> lancaDadosDesbloqueados(int nDadosDesbloqueados){
        ArrayList<Integer> lancamentos = new ArrayList<Integer>();
        for (int i = 0; i < nDadosDesbloqueados; i++) {
            lancamentos.add(lancaDado());
        }
        
        return lancamentos;
    }
}
