/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;

import Model.dados.Jogo;


public class EsperaInicio extends EstadoAdapter {
    
    public EsperaInicio(Jogo jogo) {
        super(jogo);
    }

    @Override
    public IEstado escolherArea(int op) {
        return getJogo().escolherArea(op);
    }

    @Override
    public IEstado escolherDificuldade(int op) {
        return getJogo().escolherDificuldade(op);
    }
    
    @Override
    public IEstado carregarJogo() {
        return this;//getJogo().carregarJogo();
    }

    @Override
    public IEstado comecarJogo() {
        return this;
    }
    
}
