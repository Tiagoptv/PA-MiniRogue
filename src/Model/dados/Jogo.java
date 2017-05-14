
package Model.dados;

//import Estado.EsperaCarta;
import Estado.IEstado;
import UIConsola.Menu;
import UIConsola.Informacoes;
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
    
    //setters
    public void setPersonagem(Personagem p){this.p = p;}
    public void setCartas(ArrayList<Carta> cartas){this.cartas = cartas;}
    public void setDificuldade(int dificuldade){this.dificuldade = dificuldade;}
    public void setLevel(int level){this.level = level;}
    public void setArea(int area){this.area = area;}
    public void setDerrotouMonstro(boolean derrotouMonstro){this.derrotouMonstro = derrotouMonstro;}
    public void setCartaAtual(int cartaAtual){this.cartaAtual = cartaAtual;}
    public void setNdadosDesbloqueados(int nDadosDesbloqueados){this.nDadosDesbloqueados =nDadosDesbloqueados;}
    
    
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
        for (int i = cartas.size()-1; i > 0; i--) {
            index = (int)(Math.random() * i );
            this.cartas.add(cartasTemp.get(index));
            cartasTemp.remove(index);
        }
        this.cartas.add(cartasTemp.get(0));
        this.cartas.add(new BossMonster(this));
    }
    
    public IEstado comecarMenus() {
        
        int op = Menu.ImprimePrincipal();
        
        switch(op) {
            case 1:

                escolherArea();
                escolherDificuldade();
                
                estado = comecarJogo();
                
                break;
                
            case 2:
                System.out.println("Falta Implementar Load\nFalta Implementar Load\nFalta Implementar Load\n");
                break;
                
            case 3:
            break;
        }
        return estado;
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
    
    public IEstado escolherDificuldade() {
        
        int op = Menu.ImprimeSelectDificuldade();
        
        if(op != 5)
            setDificuldade(op);

        return estado;
    }
    
    public IEstado escolherArea () {
        
        int op = Menu.ImprimeSelectArea();
        
        if(op != 0)
            setArea(op);
        
        return estado;
    }
    
    public IEstado comecarJogo() {
        aplicaDificuldade();  //System.out.println("Dificuldade aplicada!");
        baralhaCartas();      //System.out.println("Cartas Baralhadas!");
        
        //estado = new EsperaCarta(this);
        System.out.println("O Jogo vai agora comecar!");
        
        return estado ;
    }

    
    
    /** Estado - Espera Carta **/
    public IEstado resolveTresureEvent() {
        
        int dado = Dado.lancaDado();
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
        
        return estado;
    }
    
    public IEstado mostroEncontrado() {
        if(getCartaAtual().nome.equals("Monster") || getCartaAtual().nome.equals("BossMonster") )
            return estado;
        return estado;
    }
   
    
    /** Estado - Espera Escolha Rest **/
     public IEstado resolveResting() {
        
        Resting rest = new Resting();
        
        int op = Menu.OpcaoRestingCard();
        rest.descansa(this, op);
        
        System.out.println("falta passar para a proxima coluna \nou \nmudar de arena");
        //usar funçao maisCartas();
        
        //voltar ao EsperaCarta();

        return estado;
    }
     
     
     /** Estado - Espera Escolha Merchant **/
     public IEstado resolveMerchant() {
        
        int op = Menu.realizarTroca();
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
            
            default: return estado;
        }
    }
     
     public IEstado realizaCompra(int item) {
        Merchant m = new Merchant();
        m.realizaCompra(this, item);
        
        return resolveMerchant();
     }
     
     public IEstado realizaVenda(int item) {
        Merchant m = new Merchant();
        m.realizaVenda(this, item);
        
        return resolveMerchant();
     }
     
     
     /** Estado - Espera Ataque **/
     public IEstado lancaDados() {
         Dado.lancaDadosDesbloqueados(nDadosDesbloqueados);
         
         System.out.println("Tem de se dizer os valores dos dados \npara poder realizar o feats");
         
         return estado;
     }
     
     
     /** Estado - Espera Feats **/

}
