/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;

import Model.dados.Jogo;


public class EsperaFeats extends EstadoAdapter{
    
    public EsperaFeats(Jogo jogo) {
        super(jogo);
    }
    
    @Override
    public IEstado aplicaFeats() {
        return this;
    }
    
    @Override
    public IEstado ataca() {
        return this;
    }

    
}
