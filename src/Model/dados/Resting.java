/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dados;

public class Resting extends Carta{
    
    public Resting(){
        nome = "Resting";
    }
    
    public void descansa(Jogo j, int op){
        
        switch(op) {
            case 1: j.getPersonagem().setXp(j.getPersonagem().getXp()+1); System.out.println("Mais xp"); break;
            case 2: j.getPersonagem().setFood(j.getPersonagem().getFood()+1); System.out.println("Mais comida"); break;
            case 3: j.getPersonagem().setHp(j.getPersonagem().getHp()+2); System.out.println("Mais hp"); break;
        }
      
    }
    
    public void desenhaCarta(){
        
    }
}
