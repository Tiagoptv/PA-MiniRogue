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
    public int area;
    public Modelo(Jogo jogo){
        this.jogo = jogo;
        area=0;
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

    
    //espera Inicio
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
    //espera Inicio
    
    
    //resolve Merchant
    public void resolveMerchant(String id) {
        
            int idTroca=0;
        
            switch(id){
                case "1 - Ration: +1Food":
                    idTroca = 1;
                    realizaCompra(idTroca);
                    break;
                case "1 - HealthPotion: +1HP":
                    idTroca = 2;
                    realizaCompra(idTroca);
                    break;
                case "3 - BigHealthPotion: +4HP":
                    idTroca = 3;
                    realizaCompra(idTroca);
                    break;
                case "6 - ArmorPiece: +1Armor":
                    idTroca = 4;
                    realizaCompra(idTroca);
                    break;
                case "8 - Any 1 Spell":
                    idTroca = 5;
                    realizaCompra(idTroca);
                    break;
                case "3 - ArmorPiece":
                    idTroca = 6;
                    realizaVenda(idTroca);
                    break;
                case "4 - Any 1 Spell":
                    idTroca = 7;
                    realizaVenda(idTroca);
                    break;  
                case "Passar":
                    idTroca = 8;
                    mercadoriaPassar();
                    break;
            }
            setChanged();
            notifyObservers();
    }
    
    public void realizaCompra(int id) {
        jogo.realizaCompra(id);
        setChanged();
        notifyObservers();
        
    }
    
    public void realizaVenda(int id) {
        jogo.realizaVenda(id);
        setChanged();
        notifyObservers();
    }

    public void mercadoriaPassar() {
        jogo.setEstado(new EsperaCarta(jogo));
        jogo.virarCartas();
        setChanged();
        notifyObservers();
    }
    //resolve Merchant

    
    //resolve Resting
    public void resolveResting(String str) {
        int op=0;
        
        switch(str){
            case "Reinforce your Weapon : +1XP":
                op = 1;
                jogo.resolveResting(op);
                break;
            case "Search for Ration: +1Food":
                op = 2;
                //jogo.resolveResting(op);
                jogo.getEstado().descansa(op);
                break;
            case "Heal: +2HP":
                op = 3;
                jogo.resolveResting(op);
                break;
        }
            
        jogo.setEstado(new EsperaCarta(jogo));
        jogo.virarCartas();
        setChanged();
        notifyObservers();
    }
    //resolve Resting
    
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
    
    public boolean comBoss() {
        return jogo.comBossMonster();
    }





    
    
    
}
