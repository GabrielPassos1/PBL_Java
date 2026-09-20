package controller;
import java.util.Scanner;

import view.MenuView;

public class MenuController {
    private MenuView view;
    private boolean menuRodando;

    public MenuController() {
        this.view = new MenuView();
        this.menuRodando = true;
    }

    public void inicar() {
        while (menuRodando){
            view.mostrarTexto("\n" +
                    "\u001B[0;37;40m▓ ▓ █▀▀ █▀█ █▀▀ ▀█▀ █▀▄█ ▀█▀ █▀█\u001B[0m\n" +
                    "\u001B[0;37;40m▀█▀ ▓▀  ▓▀▄ ▀▀▓  ▓░ █  ▓  ▓░ █▀▓\u001B[0m\n" +
                    "\u001B[0;37;40m ▀  ▀▀▀ ▀ ▀ ▀▀▀ ▀▀▀ ▀  ▀ ▀▀▀ ▀ ▀\u001B[0m");
            view.mostrarTexto(
                    "╔══════════════════════════════╗\n" +
                    "║ [1] Nova partida             ║\n" +
                    "║ [2] Instruções               ║\n" +
                    "║ [3] Créditos                 ║\n" +
                    "║ [4] Saída                    ║\n" +
                    "╚══════════════════════════════╝");
            String escolha = view.pedirEscolha();

            if (escolha.equals("1")) {
                view.mostrarTexto(("A jogatina está iniciando! Prepare-se..."));
                menuRodando = false;

            } else if (escolha.equals("2")) {
                view.mostrarTexto("\n" +
                        "╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                        "║                                                   Instruções                                                    ║\n" +
                        "╠═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣\n" +
                        "║ ▸ A escolha inicial de personagem define seus atributos base. Seus pontos fortes e fracos                       ║\n" +
                        "║ influenciam diretamente o sucesso de suas ações e as opções de diálogo disponíveis:                             ║\n" +
                        "║   ↳ Classe: Oratória e diplomacia, essencial para encantar pessoas e negociar com a nobreza.                    ║\n" +
                        "║   ↳ Medicina: Conhecimento científico e de saúde, vital para curar ferimentos e salvar vidas.                   ║\n" +
                        "║   ↳ Fé: O uso do sagrado, permitindo manipular pessoas e dobrá-las através da crença.                           ║\n" +
                        "║                                                                                                                 ║\n" +
                        "║ ▸ Como você trata os habitantes deste mundo importa. Suas escolhas definem seu nível                            ║\n" +
                        "║ de afinidade com alguns NPC's, moldando como eles reagem à sua presença e se irão ajudá-lo (ou não) no futuro.  ║\n" +
                        "║                                                                                                                 ║\n" +
                        "║ ▸ O cenário guarda memória de suas atitudes. Revisite locais conhecidos para descobrir novos eventos,           ║\n" +
                        "║ encontrar segredos ocultos e lidar com as consequências de suas decisões passadas.                              ║\n" +
                        "║                                                                                                                 ║\n" +
                        "║ ▸ Sobre o fim: Não existe um caminho único. Cada decisão ramifica a narrativa. Experimente jogar novamente      ║\n" +
                        "║ fazendo escolhas diferentes e utilizando outros personagens para desvendar todos os finais possíveis.           ║\n" +
                        "╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
                        view.pausar();

            } else if (escolha.equals("3")) {
                view.mostrarTexto("\n" +
                        "╔═════════════════════════════════════════════════════════╗\n" +
                        "║                        Créditos                         ║\n" +
                        "╠═════════════════════════════════════════════════════════╣\n" +
                        "║ Jogo desenvolvido por: Gabriel Passos  e Laila Carvalho ║\n" +
                        "║ Para a disciplina EXA863 - MI - PROGRAMAÇÃO (UEFS)      ║\n" +
                        "║ 2026.2                                                  ║\n" +
                        "╚═════════════════════════════════════════════════════════╝");
                        view.pausar();

            } else if (escolha.equals("4")) {
                view.mostrarTexto(("Fechando o jogo. Até a próxima!"));
                menuRodando = false;
            } else {
                view.mostrarTexto("Opção inválida. Digite 1, 2, 3 ou 4");
            }
        }
    }
}
