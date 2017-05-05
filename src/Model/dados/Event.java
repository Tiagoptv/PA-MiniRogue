/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dados;

/**
 *
 * @author Diogo
 */
public class Event extends Carta{
    
    public Event(){
        nome = "Event";
    }
    
    public void opcaoAleatoria(Jogo j){
        switch(Dado.lancaDado()){
            case 1: j.getPersonagem().setFood((j.getPersonagem().getFood()+1));break;
            
            case 2: j.getPersonagem().setHp((j.getPersonagem().getHp()+2));break;
            
            case 3: j.getPersonagem().setGold((j.getPersonagem().getGold()+2));break;
            
            case 4: j.getPersonagem().setXp((j.getPersonagem().getXp()+1));break;
                
            case 5: j.getPersonagem().setArmor((j.getPersonagem().getArmor()+1));break;
                
            case 6: {
                for (int i = 0; i < j.getCartas().size();i++) {
                    if( j.getCartas().get(i) instanceof Event)
                        j.getCartas().set(i, new Monster(j));
                }
                break;
            }
        }
    }
    
    public void desenhaCarta(){
        
    }
}
