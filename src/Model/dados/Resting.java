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
public class Resting extends Carta{
    
    public Resting(){
        nome = "Resting";
    }
    
    public void descansa(Jogo j){
        j.getPersonagem().setXp(j.getPersonagem().getXp()+1);
        j.getPersonagem().setFood(j.getPersonagem().getFood()+1);
        j.getPersonagem().setHp(j.getPersonagem().getHp()+2);
    }
    
    public void desenhaCarta(){
        
    }
}
