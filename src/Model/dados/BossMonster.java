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
public class BossMonster extends CartaMonstro{
    int rewardGold;
    
    public BossMonster(Jogo j){
        nome = "BossMonster";
        setLevel(j.getLevel());
        setHp(5 + (j.getLevel() * 5));
        if(j.getLevel() == 5)
            setDmg(12);
        else{
            setDmg(j.getLevel() * j.getLevel() + 1);
        }
        if(j.getLevel() < 3)
            rewardGold = 2;
        else
            rewardGold = 3;
        setRewardXp(j.getLevel() + 1);
    }
    
    public int getRewardGold(){return rewardGold;}
    
    public void setRewardGold(int rewardGold){this.rewardGold = rewardGold;}
    
    public void recebeRecompensa(Jogo j){
        j.getPersonagem().setGold((j.getPersonagem().getGold()+getRewardGold()));
        j.getPersonagem().setGold((j.getPersonagem().getXp()+getRewardXp()));
        
        for (int i = 0; i < j.getCartas().size();i++) {
            if( j.getCartas().get(i) instanceof BossMonster)
                j.getCartas().set(i, new Treasure());
        }
    }
    
    public void desenhaCarta(){
        
    }
}
