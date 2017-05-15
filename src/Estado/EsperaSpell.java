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
    
    public IEstado usaSpell(int i){
        switch(i){
            case 1: usaFireBallSpell();break;
            
            case 2: usaIceSpell();break;
            
            case 3: usaPoisonSpell();break;
            
            case 4: usaHealingSpell();break;
        }
        return this;
    }
    
    public IEstado usaFireBallSpell(){
        CartaMonstro m = (CartaMonstro) jogo.getCartaAtual();
        m.setHp(m.getHp()-8);
        return this;
    }
    
    public IEstado usaIceSpell(){
        CartaMonstro m = (CartaMonstro) jogo.getCartaAtual();
        m.setCongelado(true);
        return this;
    }
    
    public IEstado usaPoisonSpell(){
        CartaMonstro m = (CartaMonstro) jogo.getCartaAtual();
        m.setEnvenenado(true);
        return this;
    }
    
    public IEstado usaHealingSpell(){
        jogo.getPersonagem().setHp(8);
        return this;
    }
    
    @Override
    public IEstado aplicaSpell(int spell) {
        return this;
    }
}
