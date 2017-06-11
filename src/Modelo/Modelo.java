/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Estado.EsperaCarta;
import Model.dados.Carta;
import Model.dados.Jogo;
import Model.dados.Treasure;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public void realizaCompra(String id) {
        int idCompra=0;
        switch(id){
            case "1 - Ration: +1Food":
                idCompra = 1;
                break;
            case "1 - HealthPotion: +1HP":
                idCompra = 2;
                break;
            case "3 - BigHealthPotion: +4HP":
                idCompra = 3;
                break;
            case "6 - ArmorPiece: +1Armor":
                idCompra = 4;
                break;
            case "8 - Any 1 Spell":
                idCompra = 5;
                break;
        }
        jogo.realizaCompra(idCompra);
        setChanged();
        notifyObservers();
        
    }
    
    public void realizaVenda(String id) {
        int idVenda=0;
        switch(id){
            case "3 - ArmorPiece":
                idVenda = 1;
                break;
            case "4 - Any 1 Spell":
                idVenda = 2;
                break;
        }
        jogo.realizaVenda(idVenda);
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

    public void escolherCarta(int id) {
        jogo.getEstado().escolheCarta(id);
        setChanged();
        notifyObservers();
    }

    public void mercadoriaPassar() {
        jogo.setEstado(new EsperaCarta(jogo));
        jogo.virarCartas();
        setChanged();
        notifyObservers();
    }



    
    
    
}
