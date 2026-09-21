package model;

import java.util.ArrayList;
import java.util.List;

public class Protagonista {
    private String nome;
    private int vida;
    private int dinheiro;
    private int medicina;
    private int classe;
    private int fe;
    private List<String> inventario;

    public Protagonista() {
        this.inventario = new ArrayList<>();
    }

    public Protagonista(String nome, int vida, int dinheiro, int medicina, int classe, int fe) {
        this.nome = nome;
        this.vida = vida;
        this.dinheiro = dinheiro;
        this.medicina = medicina;
        this.classe = classe;
        this.fe = fe;
        this.inventario = new ArrayList<>();
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getVida() { return vida; }
    public void setVida(int vida) { this.vida = vida; }

    public int getDinheiro() { return dinheiro; }
    public void setDinheiro(int dinheiro) { this.dinheiro = dinheiro; }

    public int getMedicina() { return medicina; }
    public void setMedicina(int medicina) { this.medicina = medicina; }

    public int getClasse() { return classe; }
    public void setClasse(int classe) { this.classe = classe; }

    public int getFe() { return fe; }
    public void setFe(int fe) { this.fe = fe; }

    public List<String> getInventario() { return inventario; }

    public void removeItem(String nome) { inventario.remove(nome); }
    public void addItem(String nome) { inventario.add(nome); }
}