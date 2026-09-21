package main;

import model.Protagonista;
import model.RepositorioCenario;
import model.RepositorioPersonagens;
import controller.PlayerController;
import controller.MenuController;

public class Main {
    public static void main(String[] args) {
        RepositorioCenario repCenario = new RepositorioCenario();
        RepositorioPersonagens repPersonagens = new RepositorioPersonagens();

        Protagonista player = new Protagonista();

        PlayerController gameController = new PlayerController(player, repCenario, repPersonagens);

        MenuController menu = new MenuController(gameController);

        menu.inicar();
    }
}