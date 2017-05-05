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
public class Trap extends Carta{
    
    public Trap(){
        nome = "Trap";
    }
    

    public void opcaoAleatoria(Jogo j){
        switch(Dado.lancaDado()){
            case 1: j.getPersonagem().setFood((j.getPersonagem().getFood()-1));break;
            
            case 2: j.getPersonagem().setGold((j.getPersonagem().getGold()-1));break;
            
            case 3: j.getPersonagem().setArmor((j.getPersonagem().getArmor()-1));break;
            
            case 4: j.getPersonagem().setHp((j.getPersonagem().getHp()-1));break;
                
            case 5: j.getPersonagem().setXp((j.getPersonagem().getXp()-1));break;
                
            case 6:{
                j.getPersonagem().setHp((j.getPersonagem().getHp()-2));
                j.setArea(j.getArea()-1);//falta verificação
                break;
            }
        }
    }
    
    
    public boolean skillCheck(int rank){
        return Dado.lancaDado() <= rank;
    }
    
    
    public void desenhaCarta(){
        System.out.print("+");
        for (int i = 0; i < 52; i++) {
            System.out.print("-");
        }
        System.out.println("+");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t        Trap    \t\t     +");
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
        System.out.println("+  1.Mold Miasma:                2.Tripwire:         +");
        System.out.println("+\033[31m    -1 Food                       -1 Gold           \033[0m+");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+  3.Acid Mist:                  4.Spring Blades:    +");
        System.out.println("+\033[31m    -1 Armor                      -1 HP             \033[0m+");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+  5.Moving Walls:               6.Pit:              +");
        System.out.println("+\033[31m    -1 XP                         -2 HP,            \033[0m+");
        System.out.println("+\033[31m                                  fall area below   \033[0m+");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.print("+");
        for (int i = 0; i < 52; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
