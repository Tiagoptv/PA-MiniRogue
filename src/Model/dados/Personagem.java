/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dados;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diogo
 */
public class Personagem {
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
    
    
    public void setHp(int hp){ this.hp = hp;}
    public void setXp(int xp){ this.xp = xp;}
    public void setArmor(int armor){ this.armor = armor;}
    public void setGold(int gold){ this.gold = gold;}
    public void setFood(int food){ this.food = food;}
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
    
    public void usaSpell(Jogo j){
        switch(/*pedeIndexSpell*/Dado.lancaDado()){
            case 1: usaFireBallSpell(j);break;
            
            case 2: usaIceSpell(j);break;
            
            case 3: usaPoisonSpell(j);break;
            
            case 4: usaHealingSpell(j);break;
        }
    }
    
    public void usaFireBallSpell(Jogo j){
        CartaMonstro m = (CartaMonstro) j.getCartaAtual();
        m.setHp(m.getHp()-8);
    }
    
    public void usaIceSpell(Jogo j){
        CartaMonstro m = (CartaMonstro) j.getCartaAtual();
        m.setCongelado(true);
    }
    
    public void usaPoisonSpell(Jogo j){
        CartaMonstro m = (CartaMonstro) j.getCartaAtual();
        m.setEnvenenado(true);
    }
    
    public void usaHealingSpell(Jogo j){
        setHp(8);
    }
    
    
    
    public void ataca(Jogo j){  
        ArrayList<Integer> lancamentos = Dado.lancaDadosDesbloqueados(j.getNdadosDesbloqueados());
    }

    public void ataca(Jogo j, int dmg){
        CartaMonstro m = (CartaMonstro) j.getCartaAtual();
        m.setHp(m.getHp()-dmg);
    }

    public void featsHp(Jogo j, int indexAtaque){
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
    
    public void featsXp(Jogo j, int indexAtaque){
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
    
    public void aplicaAtaque(Jogo j){
       int dmg = 0;
       
       //for()
    }
}
