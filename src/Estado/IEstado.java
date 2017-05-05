/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;

/**
 *
 * @author Tiago Prior
 */
public interface IEstado {
    
    /***   Espera Inicio   ***/
    IEstado comecarJogo();
    IEstado escolherDificuldade();
    IEstado escolherArea();
    IEstado carregarJogo();
    
    
}
