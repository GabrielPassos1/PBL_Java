package view;

import java.util.List;
import java.util.Scanner;

public class JogoView {
    private Scanner scanner;
    private static final int LARGURA = 110; // Largura interna do quadro duplo

    public JogoView() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarFalas(List<String> falas) {
        for (String fala : falas) {
            mostrarCaixa(fala);
        }
    }

    public void mostrarTexto(String texto) {
        mostrarCaixa(texto);
    }

    private void mostrarCaixa(String texto) {
        String linhaHorizontal = gerarLinhaHorizontal(LARGURA + 2);
        System.out.println("\n╔" + linhaHorizontal + "╗");

        String[] linhas = texto.split("\n");
        for (String linha : linhas) {
            quebrarEImprimirLinha(linha);
        }

        System.out.println("╚" + linhaHorizontal + "╝");
    }

    private void quebrarEImprimirLinha(String linha) {
        // Lida com linhas vazias vindas de "\n\n"
        if (linha.trim().isEmpty()) {
            imprimirLinhaFormatada("");
            return;
        }

        // Quebra a string caso seja maior que a largura do quadro
        while (linha.length() > LARGURA) {
            int espaco = linha.lastIndexOf(' ', LARGURA);
            if (espaco == -1) espaco = LARGURA; // Quebra a palavra forçadamente se for gigante

            imprimirLinhaFormatada(linha.substring(0, espaco));
            linha = linha.substring(espaco).trim();
        }
        imprimirLinhaFormatada(linha);
    }

    private void imprimirLinhaFormatada(String texto) {
        StringBuilder sb = new StringBuilder();
        sb.append("║ ").append(texto);
        while (sb.length() < LARGURA + 3) {
            sb.append(" "); // Preenche com espaços vazios para a borda alinhar perfeitamente
        }
        sb.append("║");
        System.out.println(sb.toString());
    }

    private String gerarLinhaHorizontal(int tamanho) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            sb.append("═");
        }
        return sb.toString();
    }

    public int pedirEscolha() {
        System.out.print("\nDigite sua escolha: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. Digite um número: ");
            scanner.next(); // consome a entrada inválida
        }
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do teclado
        return escolha;
    }

    public void pausar() {
        System.out.print("\nPressione ENTER para continuar...");
        scanner.nextLine();
    }
}