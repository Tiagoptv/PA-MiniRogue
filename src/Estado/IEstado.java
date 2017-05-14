/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;


public interface IEstado {
    
    /***   Espera Inicio   ***/
    IEstado comecarMenus();
    IEstado escolherDificuldade();
    IEstado escolherArea();
    IEstado carregarJogo();
    IEstado comecarJogo();
    
    /*** Espera Carta ***/
    IEstado resolveTresureEvent();
    IEstado monstroEncontrado();
    
    
    /*** Espera Escolha Resting ***/
    IEstado resolveResting();
    
    /*** Espera Troca ***/
    IEstado resolveMerchant();
    IEstado realizarCompra(int item);
    IEstado realizarVenda(int intem);
}
