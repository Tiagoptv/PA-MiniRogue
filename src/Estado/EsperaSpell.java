/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;

import Model.dados.*;

public class EsperaSpell extends EstadoAdapter{
    
    public EsperaSpell(Jogo jogo) {
        super(jogo);
    }
    
    public void usaSpell(int i){
        switch(i){
            case 1: usaFireBallSpell();break;
            
            case 2: usaIceSpell();break;
            
            case 3: usaPoisonSpell();break;
            
            case 4: usaHealingSpell();break;
        }
    }
    
    public void usaFireBallSpell(){
        CartaMonstro m = (CartaMonstro) jogo.getCartaAtual();
        m.setHp(m.getHp()-8);
    }
    
    public void usaIceSpell(){
        CartaMonstro m = (CartaMonstro) jogo.getCartaAtual();
        m.setCongelado(true);
    }
    
    public void usaPoisonSpell(){
        CartaMonstro m = (CartaMonstro) jogo.getCartaAtual();
        m.setEnvenenado(true);
    }
    
    public void usaHealingSpell(){
        jogo.getPersonagem().setHp(8);
    }
    
    @Override
    public IEstado aplicaSpell(int spell) {
        return this;
    }
}
