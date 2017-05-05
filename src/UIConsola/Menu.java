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

/**
 *
 * @author Diogo
 */
public class Menu {
    public static int ImprimePrincipal(){
        int op = 0;
        boolean flag = false;
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
            if((flag = sc.hasNextInt()))
                op = sc.nextInt();

        }while((!flag) || op >= 4 || op <= 0);
        
        return op;
    }
    
    /*public static int ImprimeCarrega() throws FileNotFoundException, IOException{
        BufferedReader in = null;
        String nome = null;
        int op = 0;
        boolean flag = false;
        
        do{
            System.out.print("+");
            for (int i = 0; i < 43; i++) {
                System.out.print("-");
            }
            System.out.println("+");
            System.out.println("Jogos guardados: ");
            while((nome = in.readLine()) != null){
                 System.out.println(nome);
             }
            for (int i = 0; i < 43; i++) {
                System.out.print("-");
            }
            System.out.println("+\n");
            System.out.print("Opçao: ");
            Scanner sc = new Scanner(System.in);
            if((flag = sc.hasNextInt()))
                op = sc.nextInt();

        }while((!flag) || op >= 4 || op <= 0);
        
        return op;
    }*/
}
