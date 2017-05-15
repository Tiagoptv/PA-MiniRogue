/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;

import Model.dados.Jogo;

public class EsperaTroca extends EstadoAdapter {
    
    public EsperaTroca(Jogo jogo) {
        super(jogo);
    }
    
    public void realizaVenda(Jogo j, int item){
        switch(item){
            case 1:{
                jogo.getPersonagem().setArmor((jogo.getPersonagem().getArmor()-1));
                jogo.getPersonagem().setGold((jogo.getPersonagem().getGold()+3));
                break;
            }
            
            case 2:{
                switch((int)(Math.random()*4) + 1/*pedeIndexSpell*/){
                    case 1: jogo.getPersonagem().setFire((jogo.getPersonagem().getFire()-1));break;
                    
                    case 2: jogo.getPersonagem().setIce((jogo.getPersonagem().getIce()-1));break;
                    
                    case 3: jogo.getPersonagem().setPoison((jogo.getPersonagem().getPoison()-1));break;
                    
                    case 4: jogo.getPersonagem().setHeal((jogo.getPersonagem().getHeal()-1));break;
                }
                
                jogo.getPersonagem().setGold((jogo.getPersonagem().getGold()+4));
                break;
            }
        }
    }
    
    public void realizaCompra(int item){
        switch(item){
            case 1:{
                jogo.getPersonagem().setFood((jogo.getPersonagem().getFood()+1));
                jogo.getPersonagem().setGold((jogo.getPersonagem().getGold()-1));
                break;
            }
            
            case 2:{
                jogo.getPersonagem().setHp((jogo.getPersonagem().getHp()+1));
                jogo.getPersonagem().setGold((jogo.getPersonagem().getGold()-1));
                break;
            }
            
            case 3:{
                    jogo.getPersonagem().setHp((jogo.getPersonagem().getHp()+4));
                    jogo.getPersonagem().setGold((jogo.getPersonagem().getGold()-3));
                    break;
            }
            
            case 4:{
                jogo.getPersonagem().setArmor((jogo.getPersonagem().getArmor()+1));
                jogo.getPersonagem().setGold((jogo.getPersonagem().getGold()-6));
                break;
            }
            
            case 5:{
                switch((int)(Math.random()*4) + 1/*pedeIndexSpell*/){
                    case 1: jogo.getPersonagem().setFire((jogo.getPersonagem().getFire()+1));break;
                    
                    case 2: jogo.getPersonagem().setIce((jogo.getPersonagem().getIce()+1));break;
                    
                    case 3: jogo.getPersonagem().setPoison((jogo.getPersonagem().getPoison()+1));break;
                    
                    case 4: jogo.getPersonagem().setHeal((jogo.getPersonagem().getHeal()+1));break;
                }
                
                jogo.getPersonagem().setGold((jogo.getPersonagem().getGold()-8));
                break;
            }
        }
    }
    
    
    @Override
    public IEstado resolveMerchant() {
        return this;
    }
    
    @Override
    public IEstado realizarCompra(int item) {
        return this;
    }

    @Override
    public IEstado realizarVenda(int item) {
        return this;
    }
    
}
