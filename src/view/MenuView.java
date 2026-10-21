package view;

import model.Conquista;

import java.util.List;
import java.util.Scanner;

public class MenuView {
    private Scanner scanner;
    private String corAtual = "\u001B[37m";

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

    public void exibirMenuJogarDinamico(boolean cenaExtraDesbloqueada) {
        if (cenaExtraDesbloqueada) {
            mostrarTexto("\n" +
                    "╔═══════════════ MENU JOGAR ═══════════════════╗\n" +
                    "║ [1] Nova partida                             ║\n" +
                    "║ [2] Continuar                                ║\n" +
                    "║ [3] Carregar                                 ║\n" +
                    "║ [4] O Amigo nas Sombras (Cena Extra)         ║\n" +
                    "║ [5] Voltar                                   ║\n" +
                    "╚══════════════════════════════════════════════╝");
        } else {
            exibirMenuJogar();
        }
    }

    public void exibirInstrucoes() {
        mostrarTexto("\n" +
                "╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                "║                                                 INSTRUÇÕES                                                      ║\n" +
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
                "║                        CRÉDITOS                         ║\n" +
                "╠═════════════════════════════════════════════════════════╣\n" +
                "║ Jogo desenvolvido por: Gabriel Passos e Laila Carvalho  ║\n" +
                "║ Para a disciplina EXA863 - MI - PROGRAMAÇÃO             ║\n" +
                "╚═════════════════════════════════════════════════════════╝");
    }

    public void exibirMenuConquistas(List<model.Conquista> conquistas, int ganhas, int total) {
        mostrarTexto("\n╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        mostrarTexto("║                                                  CONQUISTAS                                                     ║");
        mostrarTexto("╠═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");

        for (model.Conquista c : conquistas) {
            String status = c.isDesbloqueada() ? "[✔]" : "[ ]";
            String linhaNome = status + " " + c.getNome();
            mostrarTexto(String.format("║ %-111s ║", linhaNome));

            String desc = "   -> " + c.getDescricao();
            mostrarTexto(String.format("║ %-111s ║", desc));
            mostrarTexto("╠═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");
        }

        String linhaProgresso = "Progresso: " + ganhas + "/" + total + " conquistas alcançadas";
        mostrarTexto(String.format("║ %-111s ║", linhaProgresso));
        mostrarTexto("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
    }

    public void exibirMenuProfissoes() {
        mostrarTexto("\n" +
                "╔═══════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                "║ Escolha sua Profissão (define seus atributos e abordagens iniciais):                          ║\n" +
                "╠═══════════════════════════════════════════════════════════════════════════════════════════════╣\n" +
                "║ [1] Médico (+3 Medicina, +5 Classe/Sofisticação, +2 Fé)                                       ║\n" +
                "║ [2] Cirurgião (+5 Medicina, +2 Classe/Sofisticação, +3 Fé)                                    ║\n" +
                "║ [3] Clérigo (+2 Medicina, +3 Classe/Sofisticação, +5 Fé)                                      ║\n" +
                "╚═══════════════════════════════════════════════════════════════════════════════════════════════╝");
    }

    public void exibirCenaExtraAmigoNasSombras() {
        mostrarTexto("\n╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        mostrarTexto("║                                                O AMIGO NAS SOMBRAS                                              ║");
        mostrarTexto("╠═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");
        mostrarTexto("║ O silêncio na alta torre da mansão é absoluto após a queda do Duque Rodrigo.                                    ║");
        mostrarTexto("║ Olhando pela janela em direção às ruas que começam a cicatrizar, você finalmente compreende toda a verdade.      ║");
        mostrarTexto("║                                                                                                                 ║");
        mostrarTexto("║ A carta anônima entregue na sua porta na terceira manhã... não foi obra do acaso ou de um mero forasteiro.       ║");
        mostrarTexto("║ A caligrafia elegante, o conhecimento exato dos segredos da corte e a urgência em derrubar o Duque apontam      ║");
        mostrarTexto("║ para uma única mente brilhante e calculista nos bastidores do poder.                                           ║");
        mostrarTexto("║                                                                                                                 ║");
        mostrarTexto("║ A verdadeira remetente daquela carta que iniciou a sua jornada foi a Conselheira Zuri.                          ║");
        mostrarTexto("║ Ela usou você como a peça definitiva em seu tabuleiro para reorganizar o destino de Oblitum.                    ║");
        mostrarTexto("╠═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");
        mostrarTexto("║ [Pressione ENTER para retornar ao menu]                                                                         ║");
        mostrarTexto("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
        pausar();
    }
}