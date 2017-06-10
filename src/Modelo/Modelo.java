/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Model.dados.Carta;
import Model.dados.Jogo;
import Model.dados.Treasure;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public void guardarJogo() throws IOException {
        jogo.guardarJogo();
        setChanged();
        notifyObservers();
    }
    
    public void carregarJogo() {
        try {
            jogo =  Jogo.carregaJogo();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        setChanged();
        notifyObservers();
    }


    public Boolean isVisivelCartaByClass(String cartaClass) {
        for (Carta carta : jogo.getCartas()) {
            if( carta.getClass().toString().contains(cartaClass) ){
                if(carta.getVisivel())
                    return true;
                else
                    return false;
            }
        }
        return false;
    }

    
    
    
}
