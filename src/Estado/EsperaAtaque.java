/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;

import Model.dados.*;


public class EsperaAtaque extends EstadoAdapter {
    
    public EsperaAtaque(Jogo jogo) {
        super(jogo);
    }
    
    public IEstado aplicaAtaqueAMonstro(){
       int dmg = 0;
       
       for(int i : jogo.getPersonagem().getAtaques())
           dmg += i;
       
       CartaMonstro cm = (CartaMonstro)jogo.getCartaAtual();
       
       cm.setHp(cm.getHp()-dmg);
       
       return this;
    }
    
    @Override
    public IEstado lancaDados() {
        return this;
    }
}
