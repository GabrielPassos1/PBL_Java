package view;

import java.util.List;
import java.util.Scanner;

public class JogoView {
    private Scanner scanner;
    private String corAtual = "\u001B[0m";

    public JogoView() {
        this.scanner = new Scanner(System.in);
    }

    public void setCorAtual(String corAtual) {
        this.corAtual = corAtual;
    }

    public void exibirTexto(String texto) {
        System.out.println(this.corAtual + texto);
    }

    public void mostrarFalas(List<String> falas) {
        if (falas != null) {
            for (String fala : falas) {
                System.out.println(fala);
            }
        }
    }

    public void exibirOpcaoPause() {
        System.out.println("0- Pausar");
    }
    public void exibirMenuPause() {
        System.out.println("\n" +
                "╔════════    PAUSE   ════════╗\n" +
                "║ [1] Continuar              ║\n" +
                "║ [2] Salvar Jogo            ║\n" +
                "║ [3] Voltar ao Menu         ║\n" +
                "╚════════════════════════════╝");
    }

    public void exibirPromptSalvamento() {
        System.out.println("\nEscolha um Slot para salvar (1 a 3): ");
        System.out.println("Ou digite 0 para cancelar.");
    }

    public void exibirSobrescrita(String resumoMetadados) {
        System.out.println("\nJá existe um save neste slot:");
        System.out.println(resumoMetadados);
        System.out.println("\nDeseja sobrescrever? (1 - Sim / 2 - Não)");
    }

    public int pedirEscolha() {
        System.out.print("\nDigite sua escolha: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. Digite um número: ");
            scanner.next();
        }
        int escolha = scanner.nextInt();
        scanner.nextLine();
        return escolha;
    }

    public void pausar() {
        System.out.print("\nPressione ENTER para continuar...\n");
        scanner.nextLine();
    }
}

