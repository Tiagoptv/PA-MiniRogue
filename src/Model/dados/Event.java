/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dados;

public class Event extends Carta{
    
    public Event(){
        nome = "Event";
    }
    
    public void efeitoCarta(Jogo j, int dado){
        switch(dado){
            case 1: j.getPersonagem().setFood((j.getPersonagem().getFood()+1));break;
            
            case 2: j.getPersonagem().setHp((j.getPersonagem().getHp()+2));break;
            
            case 3: j.getPersonagem().setGold((j.getPersonagem().getGold()+2));break;
            
            case 4: j.getPersonagem().setXp((j.getPersonagem().getXp()+1));break;
                
            case 5: j.getPersonagem().setArmor((j.getPersonagem().getArmor()+1));break;
                
            case 6: {
                for (int i = 0; i < j.getCartas().size();i++) {
                    if( j.getCartas().get(i) instanceof Event)
                        j.getCartas().set(i, new Monster(j));
                }
                break;
            }
        }
    }
    
    public void desenhaCarta(){
        System.out.print("+");
        for (int i = 0; i < 52; i++) {
            System.out.print("-");
        }
        System.out.println("+");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t        Event   \t\t     +");
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
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\033[32m  1. Found Ration: +1 Food                          \033[0m+");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\033[32m  2. Health Potion: +2 HP                           \033[0m+");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\033[32m  3. Found Loot: +2 $                               \033[0m+");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\033[32m  4. Whetstone: +2 XP                               \033[0m+");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\033[32m  5. Found Shield: +1 Armor                         \033[0m+");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\033[31m  6. Monster                                        \033[0m+");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.print("+");
        for (int i = 0; i < 52; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
