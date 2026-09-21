package controller;

import view.MenuView;

public class MenuController {
    private MenuView view;
    private boolean menuRodando;
    private PlayerController playerController;
    private JogoController jogoController;

    // O construtor recebe tanto o PlayerController (para criar o personagem)
    // quanto o JogoController (para iniciar o loop do jogo)
    public MenuController(PlayerController playerController, JogoController jogoController) {
        this.view = new MenuView();
        this.menuRodando = true;
        this.playerController = playerController;
        this.jogoController = jogoController;
    }

    public void iniciar() {
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
                view.mostrarTexto("\n" +
                        "╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                        "║                                              Criação de Personagem                                              ║\n" +
                        "╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
                view.mostrarTexto("Como gostaria de ser chamado?");
                String nome = view.pedirEscolha();

                view.mostrarTexto("\n" +
                        "╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                        "║ Escolha sua Profissão (define seus atributos e abordagens iniciais):                                            ║\n" +
                        "╠═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣\n" +
                        "║ [1] Médico (+3 Medicina, +5 Classe/Sofisticação, +2 Fé)                                                         ║\n" +
                        "║ [2] Cirurgião (+5 Medicina, +2 Classe/Sofisticação, +3 Fé)                                                      ║\n" +
                        "║ [3] Clérigo (+2 Medicina, +3 Classe/Sofisticação, +5 Fé)                                                        ║\n" +
                        "╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
                String classeEscolhida = view.pedirEscolha();

                // Usa o playerController para configurar os atributos do jogador
                playerController.AddNome(nome);
                playerController.getPlayer().setVida(5);
                playerController.getPlayer().setDinheiro(20);

                if (classeEscolhida.equals("1")) {
                    playerController.CriarMedico();
                } else if (classeEscolhida.equals("2")) {
                    playerController.CriarCirurgiao();
                } else if (classeEscolhida.equals("3")) {
                    playerController.CriarClerigo();
                } else {
                    playerController.CriarMedico();
                }

                view.mostrarTexto("\nA jogatina está iniciando! Prepare-se, " + playerController.getPlayer().getNome() + "...");
                menuRodando = false;

                // Usa o jogoController para dar o start na lógica das cenas
                jogoController.iniciarJogo();

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