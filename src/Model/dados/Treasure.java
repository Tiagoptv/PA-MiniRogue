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
    
    public int getSpellTroca(){return spellTroca;}
    
    public void setSpellTroca(int spellTroca){this.spellTroca = spellTroca;}
        
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
