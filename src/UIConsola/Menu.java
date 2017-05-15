/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIConsola;
import Estado.*;
import java.util.Scanner;
import Model.dados.*;
import java.io.IOException;
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
    
    public static void imprimeSelecionaCarta(Jogo jogo) {
        int op = 0;
        do{
            
            System.out.print("+");
            for (int i = 0; i < 43; i++) {
                System.out.print("-");
            }
            System.out.println("+");
            
            String carta1 = ((Carta)jogo.getCartas().get(jogo.getCartaAtualIndex())).getNome();
            String carta2 = null;
            if(jogo.getCartaAtualIndex() == 1 || jogo.getCartaAtualIndex() == 4){
                carta2 = ((Carta)jogo.getCartas().get(jogo.getCartaAtualIndex()+1)).getNome();
                System.out.print("|\t\t\t\t\t    |\n|                  M E N U                  |\n|\t\t\t\t\t    |\n| \tSelecione a carta.\t    |\n|\t1. "+carta1+".    |\n| \t2. "+carta2+".\t\t\t    |\n|\t\t\t\t\t    |\n+");
            }
            else{ 
                System.out.print("|\t\t\t\t\t    |\n|                  M E N U                  |\n|\t\t\t\t\t    |\n| \tSelecione a carta.\t    |\n|\t1. "+carta1+".    |\n|\t\t\t\t\t    |\n|\t\t\t\t\t    |\n+");
            }
            for (int i = 0; i < 43; i++) {
                System.out.print("-");
            }
            System.out.println("+\n");
            System.out.print("Carta: ");
            Scanner sc = new Scanner(System.in);
            while(( !sc.hasNextInt())) sc.next();
            op = sc.nextInt();

        }while( op >= 3 || op < 0);
        
        jogo.setCartaAtual(jogo.getCartaAtualIndex()+ op);
        
        jogo.proximoEstado();
    }
    
    public static int opcaoRestingCard(Jogo j) {
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
        
        ((EsperaEscolhaRest)j.getEstado()).descansa(op);
        
        return op;
    }
    
    public static void realizarTroca(Jogo j) {
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
        if(op == 1){
            do{
            
                System.out.print("+");
                for (int i = 0; i < 43; i++) {
                    System.out.print("-");
                }
                System.out.println("+");
                System.out.print("|\t\t\t\t\t    |\n|                  M E N U                  |\n|\t\t\t\t\t    |\n| \tIntroduza o index to item. \t    |\n|\t\t\t\t\t    |\n| \t\t\t\t    |\n|\t\t\t\t\t    |\n|\t\t\t\t\t    |\n+");
                for (int i = 0; i < 43; i++) {
                    System.out.print("-");
                }
                System.out.println("+\n");
                System.out.print("Opcao: ");
                Scanner sc = new Scanner(System.in);
                while(( !sc.hasNextInt())) sc.next();
                op = sc.nextInt();

            }while( op >= 8 || op < 0);
            if(op < 5)
                ((EsperaTroca)j.getEstado()).realizaCompra(op);
            else
                ((EsperaTroca)j.getEstado()).realizaVenda(op - 5);
        }
    }
    
    public static void utilizarFeat(Jogo j) {
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
        if(op == 1){
            do{
                System.out.print("+");
                for (int i = 0; i < 43; i++) {
                    System.out.print("-");
                }
                System.out.println("+");
                System.out.print("|\t\t\t\t\t    |\n|                  M E N U                  |\n|\t\t\t\t\t    |\n| \tO que pretende perder? \t    |\n|\t\t\t\t\t    |\n| \t  1. HP\t2. XP\t\t    |\n|\t\t\t\t\t    |\n|\t\t\t\t\t    |\n+");
                for (int i = 0; i < 43; i++) {
                    System.out.print("-");
                }
                System.out.println("+\n");
                System.out.print("Opcao: ");
                Scanner sc = new Scanner(System.in);
                while(( !sc.hasNextInt())) sc.next();
                op = sc.nextInt();

            }while( op >= 3 || op < 0);
            int op2;
            do{
                System.out.print("+");
                for (int i = 0; i < 43; i++) {
                    System.out.print("-");
                }
                System.out.println("+");
                System.out.print("|\t\t\t\t\t    |\n|                  M E N U                  |\n|\t\t\t\t\t    |\n| \tQual o index to ataque a ser repetido? \t    |\n|\t\t\t\t\t    |\n| \t\t\t\t    |\n|\t\t\t\t\t    |\n|\t\t\t\t\t    |\n+");
                for (int i = 0; i < 43; i++) {
                    System.out.print("-");
                }
                System.out.println("+\n");
                System.out.print("Opcao: ");
                Scanner sc = new Scanner(System.in);
                while(( !sc.hasNextInt())) sc.next();
                op2 = sc.nextInt();

            }while( op2 > j.getPersonagem().getAtaques().size() || op2 < 0);
            if(op == 1)
                j.getPersonagem().featsHp(op2);
            if(op == 2)
                j.getPersonagem().featsXp(op2);
        }
    }
    
    public static void utilizaSpell(Jogo j) {
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
                    ((EsperaSpell)j.getEstado()).usaSpell(op);
                break;
                
            case 2: break;
        } 
    }
    
    public static void menuAtaque() {
        
    }
    
       
}

