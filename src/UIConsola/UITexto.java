/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIConsola;

import Estado.IEstado;
import Model.dados.Jogo;


public class UITexto {

    private Jogo jogo;
    private boolean sair = false;
    
    public UITexto(Jogo j) {
        jogo = j;
    }
    
    
    void corre() {
        
        while(!sair) 
        {
         
            IEstado estado = jogo.getEstado();
            
            
            if( estado instanceof Estado.EsperaInicio)
                
                Menu.imprimePrincipal(jogo);
            
            //if(estado instanceof Estado.EsperaCarta)
                
              //  Menu.
        }
    }
    
}
