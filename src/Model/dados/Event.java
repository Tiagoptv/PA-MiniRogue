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
