/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;

import Model.dados.Jogo;

public class EsperaSpell extends EstadoAdapter{
    
    public EsperaSpell(Jogo jogo) {
        super(jogo);
    }
    
    @Override
    public IEstado aplicaSpell(int spell) {
        return this;
    }
}
