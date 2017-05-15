
package Model.dados;

import Estado.EsperaAtaque;
import Estado.EsperaCarta;
import Estado.EsperaEscolhaRest;
import Estado.EsperaInicio;
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
import java.util.ArrayList;
import java.util.List;

public class Jogo {
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
        if( getArea() == 2 || getArea() == 4|| getArea() == 7 || getArea() == 10 || getArea() == 14)
            return true;
        return false;
    }
    public boolean maisCartas() {
        
        if(getCartas().isEmpty())
            if(!comBossMonster())
                return false;
        return true;
    }
    public void proximoEstado() {
        if(getCartaAtual() instanceof Resting)
            setEstado(new EsperaEscolhaRest(this));
        else if(getCartaAtual() instanceof Merchant)
            setEstado(new EsperaTroca(this));
        else if(getCartaAtual() instanceof Treasure || getCartaAtual() instanceof Event )
            resolveTresureEvent();
        else if(getCartaAtual() instanceof Monster)
            setEstado(new EsperaAtaque(this));
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
        ArrayList<Carta> cartasTemp = new ArrayList<>();
        
        cartasTemp.add(new Monster(this));
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
            this.cartas.add(new BossMonster(this));
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

        return comecarJogo();
    }
    
    public IEstado escolherArea (int op) {
        
        setArea(op);
        
        return estado;
    }
    
    public IEstado comecarJogo() {
        aplicaDificuldade();  //System.out.println("Dificuldade aplicada!");
        baralhaCartas();      //System.out.println("Cartas Baralhadas!");
        
        estado = new EsperaCarta(this);
        
        return estado ;
    }

    
    
    /** Estado - Espera Carta **/
    public IEstado resolveTresureEvent() {
        
        /*int dado = Dado.lancaDado();
        Informacoes.resultadoDado(dado);
        
        if(getCartaAtual().getNome().equals("Treasure")) {
            Treasure tesouro = new Treasure();
            tesouro.recebeGold(this);
            tesouro.efeitoCarta(this, dado);
        }
        
        if(getCartaAtual().getNome().equals("Event")) {
            Event evento = new Event();
            evento.efeitoCarta(this, dado);
        }
        
        System.out.println("falta passar para a proxima coluna \nou \nmudar de arena");
        //usar funçao maisCartas();
        
        //voltar ao EsperaCarta();
        */
        return estado;
    }
    
    public IEstado monstroEncontrado() {
        if(getCartaAtual().nome.equals("Monster") || getCartaAtual().nome.equals("BossMonster") )
            return estado;
        return estado;
    }
   
    
    /** Estado - Espera Escolha Rest **/
     public IEstado resolveResting() {
        
        Resting rest = new Resting();
        
        //int op = Menu.opcaoRestingCard();
        //rest.descansa(this, op);
        
        System.out.println("falta passar para a proxima coluna \nou \nmudar de arena");
        //usar funçao maisCartas();
        
        //voltar ao EsperaCarta();

        return estado;
    }
     
     
     /** Estado - Espera Escolha Merchant **/
     public IEstado resolveMerchant() {
        
        /*int op = Menu.realizarTroca();
        switch(op) {
            case 1:
                op = Menu.opcaoMerchant();
        
                if(op <= 5)
                    return realizaCompra(op);
                else 
                    return realizaVenda(op);
                
            case 2:
                System.out.println("falta passar para a proxima coluna \nou \nmudar de arena");
                //usar funçao maisCartas();
        
                //voltar ao EsperaCarta();
                return estado;
            
            default: 
        }*/return estado;
    }
     
     public IEstado realizaCompra(int item) {
        Merchant m = new Merchant();
        //m.realizaCompra(this, item);
        
        return resolveMerchant();
     }
     
     public IEstado realizaVenda(int item) {
        Merchant m = new Merchant();
        m.realizaVenda(this, item);
        
        return resolveMerchant();
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
         p.aplicaAtaque(this);
         //return aplicaSpell();
         return estado;
     }
     
     /** Estado - Espera Spell **/
     public IEstado aplicaSpell(int i) {
         p.usaSpell(this, i);
         return estado;
     }

}
