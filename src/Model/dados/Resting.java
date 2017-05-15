/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dados;

public class Resting extends Carta{
    
    public Resting(){
        nome = "Resting";
    }
       
    public void desenhaCarta(){
        System.out.print("+");
        for (int i = 0; i < 52; i++) {
            System.out.print("-");
        }
        System.out.println("+");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t       Resting  \t\t     +");
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
        System.out.println("+\033[32m  1. Reinforce your Weapon: +1 XP                   \033[0m+");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\033[32m  2. Search for Ration: +1 Food                     \033[0m+");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\033[32m  3. Heal: +2 HP                                    \033[0m+");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.println("+\t\t\t\t\t\t     +");
        System.out.print("+");
        for (int i = 0; i < 52; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
