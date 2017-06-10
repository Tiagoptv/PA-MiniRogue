/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;

import Model.dados.*;
import UIConsola.*;

public class EsperaCarta extends EstadoAdapter{
    
    public EsperaCarta(Jogo jogo) {
        super(jogo);
    }
    
    public IEstado escolheCarta(int id) {
        
        if( !jogo.getCartaPorIndex(id).getVisivel() )
            return this;
        else if(jogo.getCartaAtualIndex() <= id){
            jogo.setCartaAtual(id);
            jogo.setEstado(jogo.proximoEstado());
        }
        return this;
    }
    
    //Event
    public IEstado efeitoCartaEvent(int dado){
        switch(dado){
            case 1: jogo.getPersonagem().setFood((jogo.getPersonagem().getFood()+1));break;
            
            case 2: jogo.getPersonagem().setHp((jogo.getPersonagem().getHp()+2));break;
            
            case 3: jogo.getPersonagem().setGold((jogo.getPersonagem().getGold()+2));break;
            
            case 4: jogo.getPersonagem().setXp((jogo.getPersonagem().getXp()+1));break;
                
            case 5: jogo.getPersonagem().setArmor((jogo.getPersonagem().getArmor()+1));break;
                
            case 6: {
                for (int i = 0; i < jogo.getCartas().size();i++) {
                    if( jogo.getCartas().get(i) instanceof Event)
                        jogo.getCartas().set(i, new Monster(jogo));
                }
                break;
            }
        }
        return this;
    }
    
    //Trap
    public IEstado opcaoAleatoria(){
        switch(Dado.lancaDado()){
            case 1: jogo.getPersonagem().setFood((jogo.getPersonagem().getFood()-1));break;
            
            case 2: jogo.getPersonagem().setGold((jogo.getPersonagem().getGold()-1));break;
            
            case 3: jogo.getPersonagem().setArmor((jogo.getPersonagem().getArmor()-1));break;
            
            case 4: jogo.getPersonagem().setHp((jogo.getPersonagem().getHp()-1));break;
                
            case 5: jogo.getPersonagem().setXp((jogo.getPersonagem().getXp()-1));break;
                
            case 6:{
                jogo.getPersonagem().setHp((jogo.getPersonagem().getHp()-2));
                if(jogo.getArea() > 1)
                    jogo.setArea(jogo.getArea()-1);
                break;
            }
        }
        jogo.virarCartas();
        return this;
    }
    
    //Treasure
    public IEstado recebeGold(){
        if(jogo.getDerrotouMonstro()) {
            jogo.getPersonagem().setGold(jogo.getPersonagem().getGold()+2);
        } else {
            jogo.getPersonagem().setGold(jogo.getPersonagem().getGold()+1);
        }
        return this;
    }
    
    public IEstado efeitoCartaTreasure(int dado){
        Treasure t = (Treasure)jogo.getCartaAtual();
        switch(dado){
            case 1: jogo.getPersonagem().setArmor(jogo.getPersonagem().getArmor()+1);break;
            
            case 2: jogo.getPersonagem().setXp(jogo.getPersonagem().getXp()+2);break;
            
            case 3: {
                if(!(jogo.getPersonagem().verificaSpellsCheios())){
                     jogo.getPersonagem().setFire(jogo.getPersonagem().getFire()+1);
                     jogo.getPersonagem().setNspells(jogo.getPersonagem().getNspells()+1);
                }else{
                    t.setSpellTroca(1);
                    //Pergunta se quer trocar spell
                }
                break;
            }
            
            case 4: {
                if(!(jogo.getPersonagem().verificaSpellsCheios())){
                     jogo.getPersonagem().setIce(jogo.getPersonagem().getIce()+1);
                     jogo.getPersonagem().setNspells(jogo.getPersonagem().getNspells()+1);
                }else{
                    t.setSpellTroca(2);
                    //Pergunta se quer trocar spell
                }
                break;
            }
            
            case 5: {
                if(!(jogo.getPersonagem().verificaSpellsCheios())){
                     jogo.getPersonagem().setPoison(jogo.getPersonagem().getPoison()+1);
                     jogo.getPersonagem().setNspells(jogo.getPersonagem().getNspells()+1);
                }else{
                    t.setSpellTroca(3);
                    //Pergunta se quer trocar spell
                }
                break;
            }
            
            case 6: {
                if(!(jogo.getPersonagem().verificaSpellsCheios())){
                     jogo.getPersonagem().setHeal(jogo.getPersonagem().getHeal()+1);
                     jogo.getPersonagem().setNspells(jogo.getPersonagem().getNspells()+1);
                }else{
                    t.setSpellTroca(4);
                    //Pergunta se quer trocar spell
                }
                break;
            }
        }
        return this;
    }
    
    public IEstado trocaSpell(int opcao){
        //retira spell
        switch(opcao){
            case 1: jogo.getPersonagem().setFire(jogo.getPersonagem().getFire()-1);break;
            
            case 2: jogo.getPersonagem().setIce(jogo.getPersonagem().getIce()-1);break;
            
            case 3: jogo.getPersonagem().setPoison(jogo.getPersonagem().getPoison()-1);break;
            
            case 4: jogo.getPersonagem().setHeal(jogo.getPersonagem().getHeal()-1);break;
        }
        
        Treasure t = (Treasure)jogo.getCartaAtual();
        
        switch(t.getSpellTroca()){
            case 1: jogo.getPersonagem().setFire(jogo.getPersonagem().getFire()+1);break;
            
            case 2: jogo.getPersonagem().setIce(jogo.getPersonagem().getIce()+1);break;
            
            case 3: jogo.getPersonagem().setPoison(jogo.getPersonagem().getPoison()+1);break;
            
            case 4: jogo.getPersonagem().setHeal(jogo.getPersonagem().getHeal()+1);break; 
        }
        
        t.setSpellTroca(0);
        
        return this;
    }
    
    @Override
    public IEstado resolveTresureEvent() {
        return this;
    }
    
    @Override
    public IEstado monstroEncontrado() {
        return this;
    }
    
}
