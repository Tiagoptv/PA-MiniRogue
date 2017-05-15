/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;

import Model.dados.*;

public class EstadoAdapter implements IEstado{

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
    public IEstado escolherDificuldade() {
        return this;
    }
    @Override
    public IEstado escolherArea() {
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
    public IEstado resolveTresureEvent() {
        return this;
    }
    @Override
    public IEstado monstroEncontrado() {
        return this;
    }
    
    
    /*** Espera Escolha Resting ***/
    @Override
    public IEstado resolveResting() {
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


    
}
    
    
