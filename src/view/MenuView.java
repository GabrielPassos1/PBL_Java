package view;

import java.util.Scanner;

public class MenuView {
    private Scanner scanner;
    private String corAtual = "\u001B[37m"; // Branco por padrão

    public MenuView() {
        this.scanner = new Scanner(System.in);
    }

    public void setCorAtual(String corAtual) {
        this.corAtual = corAtual;
    }

    public void mostrarTexto(String texto) {
        System.out.println(this.corAtual + texto + "\u001B[0m");
    }

    public String pedirEscolha() {
        System.out.print(this.corAtual + "Sua escolha: \u001B[0m");
        return scanner.nextLine().trim();
    }

    public void pausar() {
        System.out.print(this.corAtual + "\nPressione ENTER para continuar...\u001B[0m");
        scanner.nextLine();
    }

    public void exibirMenuPrincipal() {
        System.out.println("\n" +
                "\u001B[0;37;40m▓ ▓ █▀▀ █▀█ █▀▀ ▀█▀ █▀▄█ ▀█▀ █▀█\u001B[0m\n" +
                "\u001B[0;37;40m▀█▀ ▓▀  ▓▀▄ ▀▀▓  ▓░ █ ▓  ▓░  █▀▓\u001B[0m\n" +
                "\u001B[0;37;40m ▀  ▀▀▀ ▀ ▀ ▀▀▀ ▀▀▀ ▀ ▀ ▀▀▀  ▀ ▀\u001B[0m");

        mostrarTexto(
                "╔══════════════════════════════╗\n" +
                        "║ [1] Jogar                    ║\n" +
                        "║ [2] Conquistas               ║\n" +
                        "║ [3] Configurações            ║\n" +
                        "║ [4] Instruções               ║\n" +
                        "║ [5] Créditos                 ║\n" +
                        "║ [6] Saída                    ║\n" +
                        "╚══════════════════════════════╝");
    }

    public void exibirMenuJogar() {
        mostrarTexto("\n" +
                "╔════════ MENU JOGAR ══════════╗\n" +
                "║ [1] Nova partida             ║\n" +
                "║ [2] Continuar                ║\n" +
                "║ [3] Carregar                 ║\n" +
                "║ [4] Voltar                   ║\n" +
                "╚══════════════════════════════╝");
    }

    public void exibirInstrucoes() {
        mostrarTexto("\n" +
                "╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                "║ Instruções                                                                                                      ║\n" +
                "╠═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣\n" +
                "║ ▸ A escolha inicial de personagem define seus atributos base. Seus pontos fortes e fracos                       ║\n" +
                "║ influenciam diretamente o sucesso de suas ações e as opções de diálogo disponíveis:                             ║\n" +
                "║ ↳ Classe: Oratória e diplomacia, essencial para encantar pessoas e negociar com a nobreza.                      ║\n" +
                "║ ↳ Medicina: Conhecimento científico e de saúde, vital para curar ferimentos e salvar vidas.                     ║\n" +
                "║ ↳ Fé: O uso do sagrado, permitindo manipular pessoas e dobrá-las através da crença.                             ║\n" +
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
    }

    public void exibirCreditos() {
        mostrarTexto("\n" +
                "╔═════════════════════════════════════════════════════════╗\n" +
                "║ Créditos                                                ║\n" +
                "╠═════════════════════════════════════════════════════════╣\n" +
                "║ Jogo desenvolvido por: Gabriel Passos e Laila Carvalho  ║\n" +
                "║ Para a disciplina EXA863 - MI - PROGRAMAÇÃO             ║\n" +
                "╚═════════════════════════════════════════════════════════╝");
    }
}