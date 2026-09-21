package main;

import model.Protagonista;
import model.RepositorioCenario;
import model.RepositorioPersonagens;
import controller.GerenciadorCenario;
import controller.PlayerController;
import controller.JogoController;
import controller.MenuController;
import view.JogoView;

public class Main {
    public static void main(String[] args) {
        // Repositórios e Views
        RepositorioCenario repCenario = new RepositorioCenario();
        RepositorioPersonagens repPersonagens = new RepositorioPersonagens();
        JogoView view = new JogoView();

        // Modelo
        Protagonista player = new Protagonista();

        // Controladores
        GerenciadorCenario gerenciadorCenario = new GerenciadorCenario(repCenario);
        PlayerController playerController = new PlayerController(player, gerenciadorCenario, repPersonagens);
        JogoController jogoController = new JogoController(playerController, gerenciadorCenario, view);

        // Menu Controller recebe tanto o PlayerController quanto o JogoController
        MenuController menu = new MenuController(playerController, jogoController);

        menu.iniciar();
    }
}