package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Save {
    private Protagonista player;
    private String cenaAtual;

    private String nomeJogador;
    private String dataHora;
    private int vida;
    private int dinheiro;

    public Save(Protagonista player, String cenaAtual) {
        this.player = player;
        this.cenaAtual = cenaAtual;

        this.nomeJogador = player.getNome();
        this.vida = player.getVida();
        this.dinheiro = player.getDinheiro();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.dataHora = LocalDateTime.now().format(formatter);
    }

    public Protagonista getPlayer() {
        return this.player;
    }

    public String getCenaAtual() {
        return this.cenaAtual;
    }

    public String getDataHora() {
        return this.dataHora;
    }

    public String getResumoMetadados() {
        return String.format("[%s] %s | Vida: %d | Ouro: %d | %s",
                this.nomeJogador, this.cenaAtual, this.vida, this.dinheiro, this.dataHora);
    }
}