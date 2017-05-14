/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dados;
import UIConsola.Informacoes;


public class Treasure extends Carta{
    int spellTroca;
    public Treasure(){
        nome = "Treasure";
        spellTroca = 0;
    }
    
    public void recebeGold(Jogo j){
        if(j.getDerrotouMonstro()) {
            j.getPersonagem().setGold(j.getPersonagem().getGold()+2);
            Informacoes.recebeGold(2);
        } else {
            j.getPersonagem().setGold(j.getPersonagem().getGold()+1);
            Informacoes.recebeGold(1);
        }  
    }
    
    public void trocaSpell(Jogo j, int opcao){
        //retira spell
        switch(opcao){
            case 1: j.getPersonagem().setFire(j.getPersonagem().getFire()-1);break;
            
            case 2: j.getPersonagem().setIce(j.getPersonagem().getIce()-1);break;
            
            case 3: j.getPersonagem().setPoison(j.getPersonagem().getPoison()-1);break;
            
            case 4: j.getPersonagem().setHeal(j.getPersonagem().getHeal()-1);break;
        }
        
        switch(spellTroca){
            case 1: j.getPersonagem().setFire(j.getPersonagem().getFire()+1);break;
            
            case 2: j.getPersonagem().setIce(j.getPersonagem().getIce()+1);break;
            
            case 3: j.getPersonagem().setPoison(j.getPersonagem().getPoison()+1);break;
            
            case 4: j.getPersonagem().setHeal(j.getPersonagem().getHeal()+1);break; 
        }
        
        spellTroca = 0;
    }
    
    public int efeitoCarta(Jogo j, int dado){
        switch(dado){
            case 1: j.getPersonagem().setArmor(j.getPersonagem().getArmor()+1);break;
            
            case 2: j.getPersonagem().setXp(j.getPersonagem().getXp()+2);break;
            
            case 3: {
                if(!(j.getPersonagem().verificaSpellsCheios())){
                     j.getPersonagem().setFire(j.getPersonagem().getFire()+1);
                     j.getPersonagem().setNspells(j.getPersonagem().getNspells()+1);
                }else{
                    spellTroca = 1;
                    //Pergunta se quer trocar spell
                }
                break;
            }
            
            case 4: {
                if(!(j.getPersonagem().verificaSpellsCheios())){
                     j.getPersonagem().setIce(j.getPersonagem().getIce()+1);
                     j.getPersonagem().setNspells(j.getPersonagem().getNspells()+1);
                }else{
                    spellTroca = 2;
                    //Pergunta se quer trocar spell
                }
                break;
            }
            
            case 5: {
                if(!(j.getPersonagem().verificaSpellsCheios())){
                     j.getPersonagem().setPoison(j.getPersonagem().getPoison()+1);
                     j.getPersonagem().setNspells(j.getPersonagem().getNspells()+1);
                }else{
                    spellTroca = 3;
                    //Pergunta se quer trocar spell
                }
                break;
            }
            
            case 6: {
                if(!(j.getPersonagem().verificaSpellsCheios())){
                     j.getPersonagem().setHeal(j.getPersonagem().getHeal()+1);
                     j.getPersonagem().setNspells(j.getPersonagem().getNspells()+1);
                }else{
                    spellTroca = 4;
                    //Pergunta se quer trocar spell
                }
                break;
            }
        }
        return spellTroca;
    }
    
    public void desenhaCarta(){
        System.out.print("+");
        for (int i = 0; i < 52; i++) {
            System.out.print("-");
        }
        System.out.println("+");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t       Treasure \t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\033[32m    1$ No Monster defeated    \t\t\t     \033[0m+");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\033[32m    2$ If a Monster was defeated      \t\t     \033[0m+");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.print("+");
        for (int i = 0; i < 52; i++) {
            System.out.print("-");
        }
        System.out.println("+");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+  1.Armor Piece:                2.Better Weapon:    +");
        System.out.println("+\033[32m    +1 Armor                      +2 XP             \033[0m+");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+  3.Fireball Spell:             4.Ice Spell:        +");
        System.out.println("+\033[32m    +1 Fire Spell                 +1 Ice Spell      \033[0m+");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+  5.Poison Spell:               6.Healing Spell:    +");
        System.out.println("+\033[32m    +1 Poison Spell               +1 Heal Spell     \033[0m+");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.print("+");
        for (int i = 0; i < 52; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
