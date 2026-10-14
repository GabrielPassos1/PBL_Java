package model;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import model.Protagonista;
import model.Cenario;
public class Save {
    private Protagonista player;
    private String cenaAtual;
    private List<String> conquistas;
    private List<String> preferencias;
    public Save(Protagonista player, String cenaAtual, List<String> conquistas, List<String> preferencias){
        this.cenaAtual = cenaAtual;
        this.player = player;
        this.conquistas = conquistas;
        this.preferencias = preferencias;
    }

    public Protagonista GetPlayerSave(){
            return this.player;
    }
    public String GetCenaAtualSave(){
        return this.cenaAtual;
    }

    public List<String> getConquistas() {
        return conquistas;
    }

    public List<String> getPreferencias() {
        return preferencias;
    }

}
