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
public class Merchant extends Carta {
    
    public Merchant(){
        nome = "Merchant";
    }
    
    public void realizaCompra(Jogo j, int item){
        switch(item){
            case 1:{
                j.getPersonagem().setFood((j.getPersonagem().getFood()+1));
                j.getPersonagem().setGold((j.getPersonagem().getGold()-1));
                break;
            }
            
            case 2:{
                j.getPersonagem().setHp((j.getPersonagem().getHp()+1));
                j.getPersonagem().setGold((j.getPersonagem().getGold()-1));
                break;
            }
            
            case 3:{
                    j.getPersonagem().setHp((j.getPersonagem().getHp()+4));
                    j.getPersonagem().setGold((j.getPersonagem().getGold()-3));
                    break;
            }
            
            case 4:{
                j.getPersonagem().setArmor((j.getPersonagem().getArmor()+1));
                j.getPersonagem().setGold((j.getPersonagem().getGold()-6));
                break;
            }
            
            case 5:{
                switch((int)(Math.random()*4) + 1/*pedeIndexSpell*/){
                    case 1: j.getPersonagem().setFire((j.getPersonagem().getFire()+1));break;
                    
                    case 2: j.getPersonagem().setIce((j.getPersonagem().getIce()+1));break;
                    
                    case 3: j.getPersonagem().setPoison((j.getPersonagem().getPoison()+1));break;
                    
                    case 4: j.getPersonagem().setHeal((j.getPersonagem().getHeal()+1));break;
                }
                
                j.getPersonagem().setGold((j.getPersonagem().getGold()-8));
                break;
            }
        }
    }
    
    public void realizaVenda(Jogo j, int item){
        switch(item/*pedeIndexItem*/){
            case 1:{
                j.getPersonagem().setArmor((j.getPersonagem().getArmor()-1));
                j.getPersonagem().setGold((j.getPersonagem().getGold()+3));
                break;
            }
            
            case 2:{
                switch((int)(Math.random()*4) + 1/*pedeIndexSpell*/){
                    case 1: j.getPersonagem().setFire((j.getPersonagem().getFire()-1));break;
                    
                    case 2: j.getPersonagem().setIce((j.getPersonagem().getIce()-1));break;
                    
                    case 3: j.getPersonagem().setPoison((j.getPersonagem().getPoison()-1));break;
                    
                    case 4: j.getPersonagem().setHeal((j.getPersonagem().getHeal()-1));break;
                }
                
                j.getPersonagem().setGold((j.getPersonagem().getGold()+4));
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
        System.out.println("+\t\t        Merchant\t\t     +");
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
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+  BUY\t\t\t\t   SELL\t\t     +");
        System.out.println("+\033[32m  1$ Ration: +1 Food             3$  1 Armor Piece \033[0m+");
        System.out.println("+\033[32m  1$ Health Potion: +1 HP        4$  Any 1 Spell   \033[0m+");
        System.out.println("+\033[32m  3$ Big Health Potion: +4 HP                      \033[0m+");
        System.out.println("+\033[32m  6$ Armor Piece: +1 Armor                          \033[0m+");
        System.out.println("+\033[32m  8$ Any 1 Spell                                    \033[0m+");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.print("+");
        for (int i = 0; i < 52; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
