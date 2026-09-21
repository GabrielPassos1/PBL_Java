package model;

import java.util.ArrayList;
import java.util.List;

public class NPC {
    private String nome;
    private int amizade;
    private List<String> falas;

    public NPC(String nome, int amizade){
        this.nome = nome;
        this.amizade = amizade;
        this.falas = new ArrayList<>();
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getAmizade() { return amizade; }
    public void setAmizade(int amizade) { this.amizade = amizade; }

    public List<String> getFalas() { return falas; }
}