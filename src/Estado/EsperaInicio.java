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

    public IEstado escolherArea() {
        return this;//getJogo().pedirArea();
    }

    @Override
    public IEstado escolherDificuldade() {
        return this;//getJogo().pedirDificuldade();
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
