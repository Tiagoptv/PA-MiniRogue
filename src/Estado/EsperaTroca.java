/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;

import Model.dados.Jogo;

public class EsperaTroca extends EstadoAdapter {
    
    public EsperaTroca(Jogo jogo) {
        super(jogo);
    }
    
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
    
}
