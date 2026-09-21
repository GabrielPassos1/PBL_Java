package model;

import java.util.ArrayList;
import java.util.List;

public class Cenario {
    private String nome;
    private int passagens;
    private List<String> falas;
    private String escolha;

    public Cenario(String nome, int passagens){
        this.nome = nome;
        this.passagens = passagens;
        this.falas = new ArrayList<>();
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getPassagens() { return passagens; }
    public void setPassagens(int passagens) { this.passagens = passagens; }

    public List<String> getFalas() { return falas; }

    public String getEscolha() { return escolha; }
    public void setEscolha(String escolha) { this.escolha = escolha; }
}