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
abstract class CartaMonstro extends Carta{
    private int level, dmg, rewardXp, hp;
    private boolean congelado, envenenado;
    
    CartaMonstro(){
        level = dmg = rewardXp = hp = 0;
        congelado = envenenado = false;
    }
    
    public int getLevel(){return level;}
    public int getDmg(){return dmg;}
    public int getRewardXp(){return rewardXp;}
    public int getHp(){return hp;}
    public boolean getCongelado(){return congelado;}
    public boolean getEnvenenado(){return envenenado;}
    
    public void setLevel(int level){this.level = level;}
    public void setDmg(int dmg){this.dmg = dmg;}
    public void setRewardXp(int rewardXp){this.rewardXp = rewardXp;}
    public void setHp(int hp){ this.hp = hp;}
    public void setCongelado(boolean congelado){this.congelado = congelado;}
    public void setEnvenenado(boolean envenenado){this.envenenado = envenenado;}
    
    public void ataca(Jogo j){
        j.getPersonagem().setHp((j.getPersonagem().getHp()-(dmg - j.getPersonagem().getArmor()))); // retira os pontos da armor ao damage do boss e retira os pontos hp consoanto o dmg resultante
    }
}
