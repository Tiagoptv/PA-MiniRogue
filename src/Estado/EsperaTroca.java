
package Estado;

import Model.dados.Jogo;

public class EsperaTroca extends EstadoAdapter {
    
    public EsperaTroca(Jogo jogo) {
        super(jogo);
    }
    
    @Override
    public IEstado resolveMerchant() {
        return this;
    }
    
    @Override
    public IEstado realizarCompra(int item) {
        switch(item){
            case 1:{
                if(jogo.getPersonagem().getGold() >= 1) {
                    jogo.getPersonagem().setFood((jogo.getPersonagem().getFood()+1));
                    jogo.getPersonagem().setGold((jogo.getPersonagem().getGold()-1));
                }
                break;
            }
            
            case 2:{
                if(jogo.getPersonagem().getGold() >= 1) {
                    jogo.getPersonagem().setHp((jogo.getPersonagem().getHp()+1));
                    jogo.getPersonagem().setGold((jogo.getPersonagem().getGold()-1));
                }
                break;
            }
            
            case 3:{ 
                if(jogo.getPersonagem().getGold()>=3) {
                    jogo.getPersonagem().setHp((jogo.getPersonagem().getHp()+4));
                    jogo.getPersonagem().setGold((jogo.getPersonagem().getGold()-3));
            }
                break;
            }
            
            case 4:{
                if(jogo.getPersonagem().getGold()>=6){
                    jogo.getPersonagem().setArmor((jogo.getPersonagem().getArmor()+1));
                    jogo.getPersonagem().setGold((jogo.getPersonagem().getGold()-6));
                }
                break;
            }
            
            case 5:{
                if(!jogo.getPersonagem().verificaSpellsCheios() && jogo.getPersonagem().getGold()>=8) {
                    
                    switch((int)(Math.random()*4) + 1){
                    case 1: jogo.getPersonagem().setFire((jogo.getPersonagem().getFire()+1)); jogo.getPersonagem().setNspells(jogo.getPersonagem().getNspells()+1);break;
                    
                    case 2: jogo.getPersonagem().setIce((jogo.getPersonagem().getIce()+1)); jogo.getPersonagem().setNspells(jogo.getPersonagem().getNspells()+1);break;
                    
                    case 3: jogo.getPersonagem().setPoison((jogo.getPersonagem().getPoison()+1)); jogo.getPersonagem().setNspells(jogo.getPersonagem().getNspells()+1);break;
                    
                    case 4: jogo.getPersonagem().setHeal((jogo.getPersonagem().getHeal()+1)); jogo.getPersonagem().setNspells(jogo.getPersonagem().getNspells()+1);break;
                }
                
                jogo.getPersonagem().setGold((jogo.getPersonagem().getGold()-8));
                break;
                }
                
            }
        }
        return this;
    }

    @Override
    public IEstado realizarVenda(int item) {
        switch(item){
            case 6:{
                jogo.getPersonagem().setArmor((jogo.getPersonagem().getArmor()-1));
                jogo.getPersonagem().setGold((jogo.getPersonagem().getGold()+3));
                break;
            }
            
            case 7:{
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
        return this;
    }
    
}
