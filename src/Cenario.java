import java.util.ArrayList;
import java.util.List;
public class Cenario {
    public String nome;
    public int passagens;
    public List<String> falas;




    public  Cenario(String nome, int passagens){
        this.nome = nome;
        this.passagens = passagens;
        this.falas = new ArrayList<>();
    }

}
