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
public class Treasure extends Carta{
    
    public Treasure(){
        nome = "Treasure";
    }
    
    public void recebeGold(Jogo j){
        if(j.getDerrotouMonstro())
            j.getPersonagem().setGold(j.getPersonagem().getGold()+2);
        else
            j.getPersonagem().setGold(j.getPersonagem().getGold()+1);
    }
    
    public void opcaoAleatoria(Jogo j){
        switch(Dado.lancaDado()){
            case 1: j.getPersonagem().setArmor(j.getPersonagem().getArmor()+1);break;
            
            case 2: j.getPersonagem().setXp(j.getPersonagem().getXp()+2);break;
            
            case 3: /*Não percebi bem*/break;
            
            case 4: /*Não percebi bem*/break;
            
            case 5: /*Não percebi bem*/break;
            
            case 6: j.getPersonagem().setHp(j.getPersonagem().getHp()+8);break;
        }
    }
    
    public void desenhaCarta(){
        
    }
}
