import java.util.ArrayList;
import java.util.List;
 class NPC {
    public String nome;
    public int amizade;
    public List<String> falas;

    public NPC(String nome, int amizade){

        this.amizade = amizade;
        this.nome = nome;
        this.falas = new ArrayList<>();
    }

}
