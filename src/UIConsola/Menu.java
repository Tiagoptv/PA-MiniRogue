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
import java.util.logging.Level;
import java.util.logging.Logger;


public class Menu {
    public static int imprimePrincipal(Jogo jogo) {
        int op = 0;
        do{
            
            System.out.print("+");
            for (int i = 0; i < 43; i++) {
                System.out.print("-");
            }
            System.out.println("+");
            System.out.print("|\t\t\t\t\t    |\n|                  M E N U                  |\n|\t\t\t\t\t    |\n| \t1. Comecar um novo jogo. \t    |\n| \t2. Continuar um jogo. \t\t    |\n| \t3. Sair.\t\t\t    |\n|\t\t\t\t\t    |\n+");
            for (int i = 0; i < 43; i++) {
                System.out.print("-");
            }
            System.out.println("+\n");
            System.out.print("Opçao: ");
            Scanner sc = new Scanner(System.in);
            while(( !sc.hasNextInt())) sc.next();
            op = sc.nextInt();

        }while( op >= 4 || op <= 0);
        
        switch(op) {
            case 1: 
                imprimeSelectArea(jogo);
                imprimeSelectDificuldade(jogo);
                break;
                
            case 2:
                try {
                    Jogo.carregaJogo();
                } catch (IOException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
                
            case 3:
                break;
        }
        
        return op;
    }

    public static int imprimeSelectDificuldade(Jogo jogo) {
        int op = 0;
        do{
            
            System.out.print("+");
            for (int i = 0; i < 43; i++) {
                System.out.print("-");
            }
            System.out.println("+");
            System.out.print("|\t\t\t\t\t    |\n|                  M E N U                  |\n|\t\t\t\t\t    |\n| \t1. Casual. \t\t\t    |\n| \t2. Normal. \t\t\t    |\n| \t3. Hard.\t\t\t    |\n|\t4. Impossible.  \t\t    |\n| \t5. Sair.\t\t\t    |\n|\t\t\t\t\t    |\n+");
            for (int i = 0; i < 43; i++) {
                System.out.print("-");
            }
                    
         
            System.out.println("+\n");
            System.out.print("Opçao: ");
            Scanner sc = new Scanner(System.in);
            while(( !sc.hasNextInt())) sc.next();
            op = sc.nextInt();

        }while( op >= 6 || op <= 0);
        
            if(op == 5)
                return op;
            jogo.escolherDificuldade(op);
        
        return op;
    }
    
    public static int imprimeSelectArea(Jogo jogo) {
        int op = 0;
        do{
            
            System.out.print("+");
            for (int i = 0; i < 43; i++) {
                System.out.print("-");
            }
            System.out.println("+");
            System.out.print("|\t\t\t\t\t    |\n|                  M E N U                  |\n|\t\t\t\t\t    |\n| \tIndique a Area desejada. (1-14)\t    |\n|\t\t\t\t\t    |\n| \t0. Sair.\t\t\t    |\n|\t\t\t\t\t    |\n+");
            for (int i = 0; i < 43; i++) {
                System.out.print("-");
            }
            System.out.println("+\n");
            System.out.print("Area: ");
            Scanner sc = new Scanner(System.in);
            while(( !sc.hasNextInt())) sc.next();
            op = sc.nextInt();

        }while( op >= 15 || op < 0);
        
        jogo.escolherArea(op);
        
        return op;
    }
    
    public static int opcaoRestingCard() {
        int op = 0;
        do{
            
            System.out.print("+");
            for (int i = 0; i < 43; i++) {
                System.out.print("-");
            }
            System.out.println("+");
            System.out.print("|\t\t\t\t\t    |\n|                  M E N U                  |\n|\t\t\t\t\t    |\n| \tIndique a opcao desejada. (1-3)\t    |\n|\t\t\t\t\t    |\n| \t\t\t\t\t    |\n|\t\t\t\t\t    |\n|\t\t\t\t\t    |\n+");
            for (int i = 0; i < 43; i++) {
                System.out.print("-");
            }
            System.out.println("+\n");
            System.out.print("Opcao: ");
            Scanner sc = new Scanner(System.in);
            while(( !sc.hasNextInt())) sc.next();
            op = sc.nextInt();

        }while( op >= 4 || op < 0);
        
        return op;
    }
    
    public static int opcaoMerchant() {
        int op = 0;
        do{
            
            System.out.print("+");
            for (int i = 0; i < 43; i++) {
                System.out.print("-");
            }
            System.out.println("+");
            System.out.print("|\t\t\t\t\t    |\n|                  M E N U                  |\n|\t\t\t\t\t    |\n| \tIndique a opcao desejada. (1-7)\t    |\n|\t\t\t\t\t    |\n| \tBuy: 1-5\tSell: 6-7\t    |\n|\t\t\t\t\t    |\n|\t\t\t\t\t    |\n+");
            for (int i = 0; i < 43; i++) {
                System.out.print("-");
            }
            System.out.println("+\n");
            System.out.print("Opcao: ");
            Scanner sc = new Scanner(System.in);
            while(( !sc.hasNextInt())) sc.next();
            op = sc.nextInt();

        }while( op >= 8 || op < 0);
        
        return op;
    }
    
    public static int realizarTroca() {
        int op = 0;
        do{
            
            System.out.print("+");
            for (int i = 0; i < 43; i++) {
                System.out.print("-");
            }
            System.out.println("+");
            System.out.print("|\t\t\t\t\t    |\n|                  M E N U                  |\n|\t\t\t\t\t    |\n| \tPretende realizar uma troca? \t    |\n|\t\t\t\t\t    |\n| \t  1. Sim\t2. Nao\t\t    |\n|\t\t\t\t\t    |\n|\t\t\t\t\t    |\n+");
            for (int i = 0; i < 43; i++) {
                System.out.print("-");
            }
            System.out.println("+\n");
            System.out.print("Opcao: ");
            Scanner sc = new Scanner(System.in);
            while(( !sc.hasNextInt())) sc.next();
            op = sc.nextInt();

        }while( op >= 3 || op < 0);
        
        return op;
    }
    
    public static int utilizarFeat() {
        int op = 0;
        do{
            
            System.out.print("+");
            for (int i = 0; i < 43; i++) {
                System.out.print("-");
            }
            System.out.println("+");
            System.out.print("|\t\t\t\t\t    |\n|                  M E N U                  |\n|\t\t\t\t\t    |\n| \tPretende realizar um Feat? \t    |\n|\t\t\t\t\t    |\n| \t  1. Sim\t2. Nao\t\t    |\n|\t\t\t\t\t    |\n|\t\t\t\t\t    |\n+");
            for (int i = 0; i < 43; i++) {
                System.out.print("-");
            }
            System.out.println("+\n");
            System.out.print("Opcao: ");
            Scanner sc = new Scanner(System.in);
            while(( !sc.hasNextInt())) sc.next();
            op = sc.nextInt();

        }while( op >= 3 || op < 0);
        
        return op;
    }
    
    public static int utilizaSpell(Jogo j) {
        int op = 0;
        do{
            
            System.out.print("+");
            for (int i = 0; i < 43; i++) {
                System.out.print("-");
            }
            System.out.println("+");
            System.out.print("|\t\t\t\t\t    |\n|                  M E N U                  |\n|\t\t\t\t\t    |\n| \tPretende utilizar um Spell? \t    |\n|\t\t\t\t\t    |\n| \t  1. Sim\t2. Nao\t\t    |\n|\t\t\t\t\t    |\n|\t\t\t\t\t    |\n+");
            for (int i = 0; i < 43; i++) {
                System.out.print("-");
            }
            System.out.println("+\n");
            System.out.print("Opcao: ");
            Scanner sc = new Scanner(System.in);
            while(( !sc.hasNextInt())) sc.next();
            op = sc.nextInt();

        }while( op >= 3 || op < 0);
        
        switch(op) {
            case 1:
                do{
            
                    System.out.print("+");
                    for (int i = 0; i < 43; i++) {
                        System.out.print("-");
                    }
                    System.out.println("+");
                    System.out.print("|\t\t\t\t\t    |\n|                  M E N U                  |\n|\t\t\t\t\t    |\n| \t1. Fire. \t\t\t    |\n| \t2. Ice. \t\t\t    |\n| \t3. Poison.\t\t\t    |\n|\t4. Heal.  \t\t\t    |\n| \t5. Sair.\t\t\t    |\n|\t\t\t\t\t    |\n+");
                    for (int i = 0; i < 43; i++) {
                        System.out.print("-");
                    }


                    System.out.println("+\n");
                    System.out.print("Opçao: ");
                    Scanner sc = new Scanner(System.in);
                    while(( !sc.hasNextInt())) sc.next();
                    op = sc.nextInt();

                }while( op >= 6 || op <= 0);
                
                if(op != 5)
                    j.getPersonagem().usaSpell(j, op);
                break;
                
            case 2: break;
        }
        
        return op;
        
    }
}

