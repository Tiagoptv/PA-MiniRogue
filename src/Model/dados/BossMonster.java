/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dados;


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
        j.getPersonagem().setXp((j.getPersonagem().getXp()+getRewardXp()));
        
        for (int i = 0; i < j.getCartas().size();i++) {
            if( j.getCartas().get(i) instanceof BossMonster)
                j.getCartas().set(i, new Treasure());
        }
    }

    public void desenhaCarta(){
        System.out.print("+");
        for (int i = 0; i < 52; i++) {
            System.out.print("-");
        }
        System.out.println("+");
        System.out.println("+\t\t     Boss Monster\t\t     +");
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
        System.out.println("+  Level\t\t HP \tDMG  \tREWARD       +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\033[31m  1. Undead Giant       10      3   \t\033[0m\033[32m2$ + 2 XP    \033[0m+");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\033[31m  2. Skeleton Lord      15      5   \t\033[0m\033[32m2$ + 3 XP    \033[0m+");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\033[31m  3. Undead Lord        20      7   \t\033[0m\033[32m3$ + 4 XP    \033[0m+");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\033[31m  4. Serpent Demon      25      9   \t\033[0m\033[32m3$ + 5 XP    \033[0m+");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+ \033[31m 5. Og's Remains       30      12  \t\033[0m\033[32mOG's BLOOD   \033[0m+");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+*Todos os rewards contem um item \t\t     +");
        System.out.print("+");
        for (int i = 0; i < 52; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
