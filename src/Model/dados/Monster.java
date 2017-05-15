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
public class Monster extends CartaMonstro {
    
    public Monster(Jogo j){
        nome = "Monster";
        setLevel(j.getLevel());
        setDmg(j.getLevel() * 2);
        setHp(j.getArea() + Dado.lancaDado());
        if(j.getLevel() == 5)
            setRewardXp(3);
        else
            if(j.getLevel() < 3 )
                setRewardXp(1);
            else
                setRewardXp(2);
        
    }
    
    public Monster(Jogo j, int rewardXp){
        nome = "Monster";
        setLevel(j.getLevel());
        setDmg(j.getLevel() * 2);
        setHp(j.getArea() + Dado.lancaDado());
        setRewardXp(rewardXp);   
    }
    
    public void recebeRecompensa(Jogo j){
        j.getPersonagem().setGold((j.getPersonagem().getXp()+getRewardXp()));
    }
    
     
    public void desenhaCarta(){
        System.out.print("+");
        for (int i = 0; i < 52; i++) {
            System.out.print("-");
        }
        System.out.println("+");
        System.out.println("+\t\t        Monster\t\t             +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+  Level\t\t\tDMG  \tREWARD       +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\033[31m  1. Undead Soldier     \t2    \t1 XP         \033[0m+");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\033[31m  2. Skeleton           \t4    \t1 XP         \033[0m+");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\033[31m  3. Undead Knight      \t6    \t2 XP         \033[0m+");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\033[31m  4. Serpent Knight     \t6    \t2 XP         \033[0m+");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+ \033[31m 5. Og's Sanctum Guard \t6    \t2 XP         \033[0m+");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.print("+");
        for (int i = 0; i < 52; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
    
}
