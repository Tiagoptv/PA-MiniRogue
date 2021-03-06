/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;

import Model.dados.*;
import java.io.Serializable;

public class EstadoAdapter implements IEstado, Serializable{

    protected Jogo jogo;
    public EstadoAdapter(Jogo jogo){
        this.jogo = jogo;
    }
    
    public Jogo getJogo() {
        return jogo;
    }
    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }
    
    /***   Espera Inicio   ***/
    @Override
    public IEstado escolherDificuldade(int op) {
        return this;
    }
    @Override
    public IEstado escolherArea(int op) {
        return this;
    }
    @Override
    public IEstado carregarJogo() {
        return this;
    }
    @Override
    public IEstado comecarJogo() {
        return this;
    }

    
    /***  Espera Carta  ***/
    @Override
    public IEstado resolveTresureEvent(int dado) {
        return this;
    }
    @Override
    public IEstado monstroEncontrado() {
        return this;
    }
    
    
    /*** Espera Escolha Resting ***/
    @Override
    public IEstado resolveResting(int op) {
        return this;
    }
    
    @Override
    public IEstado descansa(int op) {
        return this;
    }

    
    /*** Espera Troca ***/
    @Override
    public IEstado resolveMerchant() {
        return this;
    }
    @Override
    public IEstado realizarCompra(int item) {
        return this;
    }
    @Override
    public IEstado realizarVenda(int item) {
        return this;
    }
    
    /*** Espera Ataque ***/
    @Override
    public IEstado lancaDados() {
        return this;
    }
    
    @Override
    public IEstado aplicaAtaqueAMonstro() {
        return this;
    }
    
    /*** Espera Feats ***/
    @Override
    public IEstado aplicaFeats() {
        return this;
    }

    @Override
    public IEstado ataca() {
        return this;
    }
    
    
    /*** Espera Spell***/
    @Override
    public IEstado aplicaSpell(int spell) {
        return this;
    }

    @Override
    public IEstado escolheCarta(int id) {
        return this;
    }

    

    


    
}
    
    
