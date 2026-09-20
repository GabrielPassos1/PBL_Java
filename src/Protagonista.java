import java.util.ArrayList;
import java.util.List;
public class Protagonista {
    //atributos
    public String nome;
    public int vida;
    public int dinheiro;
    public int medicina;
    public int classe;
    public int fe;
    public List<String> inventario;

    public Protagonista(){

        this.inventario = new ArrayList<>();
    }
    public  Protagonista (String nome, int vida, int dinheiro, int medicina, int classe, int fe){
        this.nome = nome;
        this.vida = vida;
        this.dinheiro = dinheiro;
        this.medicina = medicina;
        this.classe = classe;
        this.fe = fe;
    }
    public void removeItem(String nome){
        inventario.remove(nome);
    }

    public void addItem(String nome){
        inventario.add(nome);
    }

}

