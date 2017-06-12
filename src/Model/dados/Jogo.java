
package Model.dados;

import Estado.EsperaAtaque;
import Estado.EsperaCarta;
import Estado.EsperaEscolhaRest;
import Estado.EsperaFeats;
import Estado.EsperaInicio;
import Estado.EsperaSpell;
import Estado.EsperaTroca;
import Estado.IEstado;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Jogo implements Serializable{
    private IEstado estado;
    private Personagem p;
    private ArrayList<Carta> cartas;
    private int dificuldade, level, cartaAtual, area, nDadosDesbloqueados;
    boolean derrotouMonstro;
    boolean bossMonstro;
    
    public Jogo(){
        p = new Personagem();
        this.dificuldade = 0;
        level = 1;
        cartas = new ArrayList<Carta>();
        cartaAtual = 0;
        derrotouMonstro = false;
        estado = new EsperaInicio(this);
    }
    
    //getters
    public Personagem getPersonagem(){return p;}
    public ArrayList<Carta> getCartas(){return cartas;}
    public int getDificuldade(){return dificuldade;}
    public int getLevel(){return level;}
    public int getArea(){return area;}
    public boolean getDerrotouMonstro(){return derrotouMonstro;}
    public int getCartaAtualIndex(){return cartaAtual;}
    public Carta getCartaAtual(){return cartas.get(cartaAtual);}
    public int getNdadosDesbloqueados(){return nDadosDesbloqueados;}
    public IEstado getEstado() { return estado;}
    
    //setters
    public void setPersonagem(Personagem p){this.p = p;}
    public void setCartas(ArrayList<Carta> cartas){this.cartas = cartas;}
    public void setDificuldade(int dificuldade){this.dificuldade = dificuldade;}
    public void setLevel(int level){this.level = level;}
    public void setArea(int area){this.area = area;}
    public void setDerrotouMonstro(boolean derrotouMonstro){this.derrotouMonstro = derrotouMonstro;}
    public void setCartaAtual(int cartaAtual){this.cartaAtual = cartaAtual;}
    public void setNdadosDesbloqueados(int nDadosDesbloqueados){this.nDadosDesbloqueados =nDadosDesbloqueados;}
    public void setEstado(IEstado e) {this.estado = e;}
    
    
    public boolean comBossMonster() {
        if( getArea() == 1 || getArea() == 3|| getArea() == 6 || getArea() == 9 || getArea() == 13)
            return true;
        return false;
    }
    public boolean maisCartas() {
        
        if(getCartas().isEmpty())
            if(!comBossMonster())
                return false;
        return true;
    }
    public IEstado proximoEstado() {
        if(getCartaAtual() instanceof Resting)
             return new EsperaEscolhaRest(this);
        else if(getCartaAtual() instanceof Merchant)
            return new EsperaTroca(this);
        else if(getCartaAtual() instanceof Treasure || getCartaAtual() instanceof Event )
            return resolveTresureEvent();
        else if(getCartaAtual() instanceof Monster || getCartaAtual() instanceof BossMonster)
            return new EsperaAtaque(this);
        else if(getCartaAtual() instanceof Trap)
           ((EsperaCarta)estado).opcaoAleatoria();
        return estado;
    }
    
    /** Estado - Espera Inicio **/
    public void aplicaDificuldade(){
        switch(dificuldade){
            case 1:{
                p.setArmor(1);
                p.setHp(5);
                p.setGold(5);
                p.setFood(6);
                break;
            }
            
            case 2:{
                p.setArmor(0);
                p.setHp(5);
                p.setGold(3);
                p.setFood(6);
                break;
            }
            
            case 3:{
                p.setArmor(0);
                p.setHp(4);
                p.setGold(2);
                p.setFood(5);
                break;
            }
            
            case 4:{
                p.setArmor(0);
                p.setHp(3);
                p.setGold(1);
                p.setFood(3);
                break;
            }
        }
    }
    
    public void baralhaCartas(){
        this.cartas = new ArrayList<Carta>();
        ArrayList<Carta> cartasTemp = new ArrayList<>();
        
        //cartasTemp.add(new Monster(this));
        cartasTemp.add(new Treasure());
        cartasTemp.add(new Merchant());
        cartasTemp.add(new Trap());
        cartasTemp.add(new Treasure());
        cartasTemp.add(new Event());
        cartasTemp.add(new Resting());
        
        int index;
        for (int i = cartasTemp.size()-1; i > 0; i--) {
            index = (int)(Math.random() * i );
            this.cartas.add(cartasTemp.get(index));
            cartasTemp.remove(index);
        }
        this.cartas.add(cartasTemp.get(0));
        if(comBossMonster())
            this.cartas.add(new Treasure());
            //this.cartas.add(new BossMonster(this));
        cartas.get(0).setVisivel(true);
    }
    
    public void guardarJogo() throws FileNotFoundException, IOException {
        ObjectOutputStream out = null;
        
        try{
            out = new ObjectOutputStream(new FileOutputStream("jogosGuardados.txt"));
            
            out.writeObject(this);
        }finally{
            if(out != null)
                out.close();
        }
    }
    
    public static Jogo carregaJogo() throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream in = null;
        Jogo j;
        
        try{
            in = new ObjectInputStream(new FileInputStream("jogosGuardados.txt"));
            
            j = (Jogo)in.readObject();
            return j;
        }finally{
            if(in != null) in.close();
        }
    }
    
    public IEstado escolherDificuldade(int op) {
        
        setDificuldade(op);

        return estado;
    }
    
    public IEstado escolherArea (int op) {
        
        setArea(op);
        
        return estado;
    }
    
    public IEstado comecarJogo() {
        aplicaDificuldade();  
        baralhaCartas();      
        estado = new EsperaCarta(this);
        
        return estado ;
    }

    
    
    /** Estado - Espera Carta **/
    public IEstado resolveTresureEvent() {
        
        int dado = Dado.lancaDado();
        
        if(getCartaAtual() instanceof  Treasure) {
            Treasure tesouro = (Treasure) getCartaAtual();
            //tesouro.recebeGold(this);
            //tesouro.efeitoCarta(this, dado);
        }
        
        if(getCartaAtual() instanceof  Event) {
            Event evento = new Event();
            //evento.efeitoCarta(this, dado);
        }
        
        //usar funçao maisCartas();
        
        //voltar ao EsperaCarta();
        virarCartas();
        return new EsperaCarta(this);
    }
    
    public IEstado monstroEncontrado() {
        if(getCartaAtual().nome.equals("Monster") || getCartaAtual().nome.equals("BossMonster") )
            return estado;
        return estado;
    }
   
    
    /** Estado - Espera Escolha Rest **/
     public IEstado resolveResting(int op) {
        
        //Resting rest = new Resting();
 
        estado.descansa(op);

        return estado;
    }
     
     
     /** Estado - Espera Escolha Merchant **/
     public IEstado resolveMerchant(int idTroca) {
        
         if(idTroca <= 5)
             return realizaCompra(idTroca);
         else if(idTroca > 5 || idTroca <= 7)
             return realizaVenda(idTroca);
         else {
            setEstado(new EsperaCarta(this));
            virarCartas();
         } 
        return new EsperaCarta(this);
    }
     
     public IEstado realizaCompra(int item) {
        estado.realizarCompra(item);
        
        return estado;
     }
     
     public IEstado realizaVenda(int item) {
        estado.realizarVenda(item);
        
        return estado;
     }
     
     
     /** Estado - Espera Ataque **/
     public IEstado lancaDados() {
         p.recolheAtaques(this);
         
         for(int i : p.getAtaques())
             //apresentar os dados
             
         System.out.println("Tem de se dizer os valores dos dados \npara poder realizar o feats");
         
         return estado;
     }
     
     
     /** Estado - Espera Feats **/
     public IEstado aplicaFeats() {
        //perguntar se quer utilizar um feat
        //se sim que lançamento do dado quer remover
        //remover e relançar dado
        System.out.println("Falta aplicar feats");
        
        return estado;
     }
     
     public IEstado ataca() {
         ((EsperaAtaque)estado).aplicaAtaqueAMonstro();
         //return aplicaSpell();
         return estado;
     }
     
     /** Estado - Espera Spell **/
     public IEstado aplicaSpell(int i) {
         ((EsperaSpell)estado).aplicaSpell(i);
         return estado;
     }

    public Carta getCartaPorIndex(Integer id) {
        Carta carta = cartas.get(id);
        return cartas.get(id);
    }

    public void virarCartas() {
        if(cartaAtual == 0) {
            cartas.get(1).setVisivel(true);
            cartas.get(2).setVisivel(true);
        } else if(cartaAtual == 1 || cartaAtual == 2) {
            cartas.get(3).setVisivel(true);
        } else if(cartaAtual == 3) {
            cartas.get(4).setVisivel(true);
            cartas.get(5).setVisivel(true);
        } else 
            if( cartas.size() ==  6){
                proximaArea();
            }
            else{
                if(cartaAtual == 4 || cartaAtual == 5) {
                    cartas.get(6).setVisivel(true);
                }
                else{
                    proximaArea();
                }
            }
    }
    
    private void proximaArea(){
        area++;
        cartaAtual = 0;
        baralhaCartas();
    }

}
