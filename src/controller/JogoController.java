package controller;

import view.JogoView;
import model.Cenario;

public class JogoController {
    private PlayerController playerController;
    private GerenciadorCenario gerenciadorCenario;
    private JogoView view;

    public JogoController(PlayerController playerController, GerenciadorCenario gerenciadorCenario, JogoView view) {
        this.playerController = playerController;
        this.gerenciadorCenario = gerenciadorCenario;
        this.view = view;
    }

    public void iniciarJogo() {
        gerenciadorCenario.acessarCenario("Casa do Jogador");
        boolean jogando = true;

        while (jogando) {
            Cenario cenaAtual = gerenciadorCenario.getCenaAtual();

            // 1. Mostra a fala/narrativa da cena atual
            if (cenaAtual.getFalas() != null) {
                view.mostrarFalas(cenaAtual.getFalas());
            }

            // 2. Trava de segurança: Se a cena atual for o Game Over, encerra o jogo
            if (cenaAtual.getNome().contains("Game Over")) {
                jogando = false;
                view.mostrarTexto("Fim de Jogo!");
                view.pausar();
                continue;
            }

            // 3. Cenas com opções de escolha
            if (cenaAtual.getEscolha() != null && !cenaAtual.getEscolha().isEmpty()) {
                view.mostrarTexto(cenaAtual.getEscolha());
                int escolha = view.pedirEscolha();

                // 1. Tenta realizar a ação no PlayerController
                boolean sucesso = playerController.tentarEscolha(escolha);

                String proximaCena = gerenciadorCenario.definirProximaCena(
                        cenaAtual.getNome(),
                        escolha,
                        sucesso,
                        playerController.getPlayer()
                );

                if (playerController.getPlayer().getVida() <= 0) {
                    proximaCena = "Game Over - O Abraço de Oblitum";
                }

                if (proximaCena != null && !proximaCena.isEmpty()) {
                    gerenciadorCenario.acessarCenario(proximaCena);
                } else if (!sucesso) {
                    view.mostrarTexto("Você não tem os requisitos ou falhou na ação.");
                }

                view.pausar();
            } else {
                // 4. Cenas sem escolhas (transições automáticas)
                String proximaCena = gerenciadorCenario.definirProximaCena(
                        cenaAtual.getNome(),
                        0,
                        true,
                        playerController.getPlayer()
                );

                if (playerController.getPlayer().getVida() <= 0) {
                    proximaCena = "Game Over - O Abraço de Oblitum";
                }

                if (proximaCena != null && !proximaCena.isEmpty()) {
                    view.pausar();
                    gerenciadorCenario.acessarCenario(proximaCena);
                } else {
                    jogando = false;
                    view.mostrarTexto("Fim de Jogo!");
                    view.pausar();
                }
            }
        }
    }
}