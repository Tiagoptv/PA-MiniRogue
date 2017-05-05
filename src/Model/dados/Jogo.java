/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dados;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Diogo
 */
public class Jogo {
    private Personagem p;
    private ArrayList<Carta> cartas;
    private int dificuldade, level, cartaAtual, area, nDadosDesbloqueados;
    boolean derrotouMonstro;
    
    public Jogo(int dificuldade){
        p = new Personagem();
        this.dificuldade = dificuldade;
        level = 1;
        cartas = new ArrayList<Carta>();
        cartaAtual = 0;
    }
    
    public Personagem getPersonagem(){return p;}
    public ArrayList<Carta> getCartas(){return cartas;}
    public int getDificuldade(){return dificuldade;}
    public int getLevel(){return level;}
    public int getArea(){return area;}
    public boolean getDerrotouMonstro(){return derrotouMonstro;}
    public int getCartaAtualIndex(){return cartaAtual;}
    public Carta getCartaAtual(){return cartas.get(cartaAtual);}
    public int getNdadosDesbloqueados(){return nDadosDesbloqueados;}
    
    public void setPersonagem(Personagem p){this.p = p;}
    public void setCartas(ArrayList<Carta> cartas){this.cartas = cartas;}
    public void setDificuldade(int dificuldade){this.dificuldade = dificuldade;}
    public void setLevel(int level){this.level = level;}
    public void setArea(int area){this.area = area;}
    public void setDerrotouMonstro(boolean derrotouMonstro){this.derrotouMonstro = derrotouMonstro;}
    public void setCartaAtual(int cartaAtual){this.cartaAtual = cartaAtual;}
    public void setNdadosDesbloqueados(int nDadosDesbloqueados){this.nDadosDesbloqueados =nDadosDesbloqueados;}
    
    public void aplicaDificuldade(){
        switch(dificuldade){
            case 1:{
                p.setArmor(1);
                p.setHp(5);
                p.setGold(5);
                p.setFood(6);
                break;
            }
            
            case 2:{
                p.setArmor(0);
                p.setHp(5);
                p.setGold(3);
                p.setFood(6);
                break;
            }
            
            case 3:{
                p.setArmor(0);
                p.setHp(4);
                p.setGold(2);
                p.setFood(5);
                break;
            }
            
            case 4:{
                p.setArmor(0);
                p.setHp(3);
                p.setGold(1);
                p.setFood(3);
                break;
            }
        }
    }
    
    public void baralhaCartas(){
        ArrayList<Carta> cartasTemp = new ArrayList<>();
        
        cartas.add(new Monster(this));
        cartas.add(new Merchant());
        cartas.add(new Trap());
        cartas.add(new Treasure());
        cartas.add(new Event());
        cartas.add(new Resting());
        
        int index;
        for (int i = cartas.size()-1; i > 0; i--) {
            index = (int)(Math.random() * i);
            this.cartas.add(cartasTemp.get(index));
            cartasTemp.remove(index);
        }
        this.cartas.add(cartasTemp.get(0));
        this.cartas.add(new BossMonster(this));
    }
}
