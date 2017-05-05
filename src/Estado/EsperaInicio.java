/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;

import Model.dados.Jogo;

/**
 *
 * @author Tiago Prior
 */
public class EsperaInicio extends EstadoAdapter {
    
    public EsperaInicio(Jogo jogo) {
        super(jogo);
    }

    @Override
    public IEstado comecarJogo() {
        return this;//getJogo().
    }

    @Override
    public IEstado escolherArea() {
        return this;//getJogo().
    }

    @Override
    public IEstado escolherDificuldade() {
        return this;//getJogo().
    }
    
    @Override
    public IEstado carregarJogo() {
        return this;//getJogo().
    }
    
    
    
}
