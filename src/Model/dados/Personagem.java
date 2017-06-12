/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dados;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diogo
 */
public class Personagem implements Serializable{
    private int hp, xp, armor, gold, food, rank, dmg;
    private int fire, ice, poison, heal, nspells;
    private ArrayList<Integer> ataques;
    private boolean feats;
    
    public Personagem(){
        hp = xp = armor = gold = food = rank = dmg = 0;
        fire = ice = poison = heal = nspells = 0;
        List<Integer> ataques = new ArrayList<Integer>();
    }
    
    public int getHp(){return hp;}
    public int getXp(){return xp;}
    public int getArmor(){return armor;}
    public int getGold(){return gold;}
    public int getFood(){return food;}
    public int getFire(){return fire;}
    public int getIce(){return ice;}
    public int getPoison(){return poison;}
    public int getHeal(){return heal;}
    public int getRank(){return rank;}
    public int getNspells(){return nspells;}
    public boolean getFeats(){return feats;}
    public ArrayList<Integer> getAtaques(){return ataques;}
    public int getDmg(){return dmg;}
    
    
    public void setHp(int hp){ this.hp = hp; if(this.hp > 20) this.hp=20; /*Apenas por questoes de tempo!! Para não haver bugs na interface*/}
    public void setXp(int xp){ this.xp = xp; if(this.xp > 18) this.xp=18; /*Apenas por questoes de tempo!! Para não haver bugs na interface*/}
    public void setArmor(int armor){ this.armor = armor; if(this.armor > 5) this.armor=5; /*Apenas por questoes de tempo!! Para não haver bugs na interface*/}
    public void setGold(int gold){ this.gold = gold; if(this.gold > 20) this.gold=20; /*Apenas por questoes de tempo!! Para não haver bugs na interface*/}
    public void setFood(int food){ this.food = food; if(this.food > 6) this.food=6; /*Apenas por questoes de tempo!! Para não haver bugs na interface*/}
    public void setFire(int fire){ this.fire = fire;}
    public void setIce(int ice){ this.ice = ice;}
    public void setPoison(int poison){ this.poison = poison;}
    public void setHeal(int heal){ this.heal = heal;}
    public void setRank(int rank){this.rank = rank;}
    public void setNspells(int nspells){this.nspells = nspells;}
    public void setFeats(boolean feats){this.feats = feats;}
    public void setAtaques(ArrayList<Integer> ataques){this.ataques = ataques;}
    public void setDmg(int dmg){this.dmg = dmg;}
    
    public boolean verificaSpellsCheios(){
        if(nspells == 2)
            return true;
        else
            return false;
    }
    
    public void recolheAtaques(Jogo j){  
        ataques = Dado.lancaDadosDesbloqueados(j.getNdadosDesbloqueados());
    }

    public void featsHp(int indexAtaque){
        setHp(getHp()-2);
        setFeats(true);
        int nDado, nAtaques = 0;
        
        nDado = Dado.lancaDado();
        ataques.set(indexAtaque, nDado);
        nAtaques++;
        if(nDado == 6){
            for (int i = 0; i < 1; i++) {
                nDado = Dado.lancaDado();
                if(nDado == 6)
                    i--;
                ataques.add(indexAtaque+nAtaques);
            }
        }
    }
    
    public void featsXp(int indexAtaque){
        setXp(getXp()-1);
        setFeats(true);
        int nDado, nAtaques = 0;
        
        nDado = Dado.lancaDado();
        ataques.set(indexAtaque, nDado);
        nAtaques++;
        if(nDado == 6){
            for (int i = 0; i < 1; i++) {
                nDado = Dado.lancaDado();
                if(nDado == 6)
                    i--;
                ataques.add(indexAtaque+nAtaques);
            }
        }
    }
    
    
}
