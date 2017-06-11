/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dados;

import java.io.Serializable;


public abstract class Carta implements Serializable{
    protected String nome;
    private Boolean visivel;

    public Carta(){
        visivel = false;
    }
    public String getNome(){return nome;}
    
    public void setNome(String nome){this.nome = nome;}
    
    public Boolean getVisivel() {
        return visivel;
    }

    public void setVisivel(Boolean visivel) {
        this.visivel = visivel;
    }
    public abstract void desenhaCarta();
    
    
}
