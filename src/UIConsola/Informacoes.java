/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIConsola;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import Model.dados.*;

public class Informacoes {
    
    public static void resultadoDado(int dado) {
        System.out.println("Saiu o numero " + dado + " no dado!") ;
    }
    
    public static void recebeGold(int gold) {
        System.out.println("Recebeu " + gold + " moedas de ouro!");
    }
    
    public static void mostraInfoPersonagem(Jogo j){
        Personagem p = j.getPersonagem();
        System.out.println("Rank: "+p.getRank()+"\tXP: "+p.getXp());
        System.out.println("HP: "+p.getHp()+"\t  Armor: "+p.getArmor()+"\tFood: "+p.getFood()+" \tGold: "+p.getGold());
        System.out.println("Spells:\t  Fire - "+p.getFire()+"\tIce - "+p.getIce()+" \tPoison - "+p.getPoison()+"\tHeal - "+p.getHeal());
    }
}
