import java.util.ArrayList;
import java.util.List;
public class Cenario {
    public String nome;
    public Integer passagens;
    private List<String> inventario;


    public List<String> getInventario(){
        return  this.inventario;
    }

    public  Cenario(String nome, int passagens){
        this.nome = nome;
        this.passagens = passagens;
    }
}
