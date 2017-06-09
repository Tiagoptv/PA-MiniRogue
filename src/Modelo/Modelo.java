/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Model.dados.Jogo;
import java.util.Observable;

/**
 *
 * @author Tiago Prior
 */
public class Modelo extends Observable
{
    protected Jogo jogo;
    public Modelo(Jogo jogo){
        this.jogo = jogo;
    }
    public Jogo getJogo() 
    {
        return jogo;
    }
    
    public void setJogo(Jogo j) 
    {
        jogo=j;
    }
    
    //tratar eventos

    public void setArea(int area) {
        jogo.setArea(area);
        setChanged();
        notifyObservers();
    }
    
    public void escolherDificuldade(int dificuldade) {
        jogo.escolherDificuldade(dificuldade);
        setChanged();
        notifyObservers();
    }

    public void comecarJogo() {
        jogo.comecarJogo();
        setChanged();
        notifyObservers();
    }

    
    
    
}
