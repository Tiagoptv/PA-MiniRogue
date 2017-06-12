/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;

import Model.dados.Jogo;

public class EsperaEscolhaRest extends EstadoAdapter{
    
    public EsperaEscolhaRest(Jogo jogo) {
        super(jogo);
    }
    
    public IEstado descansa(int op){
        
        switch(op) {
            case 1: jogo.getPersonagem().setXp(jogo.getPersonagem().getXp()+1);break;
            case 2: jogo.getPersonagem().setFood(jogo.getPersonagem().getFood()+1); break;
            case 3: jogo.getPersonagem().setHp(jogo.getPersonagem().getHp()+2);break;
        }
      return this;
    }
    
    @Override
    public IEstado resolveResting(int op) {
        return getJogo().resolveResting(op);
    }
    
}
