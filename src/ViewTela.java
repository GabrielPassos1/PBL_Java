import java.util.Scanner;

public class ViewTela {
    private RepositorioCenario repositorio;
    private Cenario cenarioAtual;

    public ViewTela(String nomeJogador) {
        // Inicializa o repositório passando o nome digitado
        this.repositorio = new RepositorioCenario();

        // Define o ponto de partida do jogador
        carregarCenario("Casa do Jogador");
    }

    public void carregarCenario(String chave) {
        Cenario proximo = repositorio.getCenario(chave);
        if (proximo != null) {
            this.cenarioAtual = proximo;
            exibirCenario();
        } else {
            System.out.println("[Erro] Cenário '" + chave + "' não foi encontrado no Repositório.");
        }
    }

    private void exibirCenario() {
        System.out.println("\n==================================================");
        System.out.println("  " + cenarioAtual.nome.toUpperCase());
        System.out.println("==================================================");

        // Imprime as opções/escolhas configuradas para este cenário
        System.out.println("\n--- SUAS OPÇÕES ---");
        System.out.println(cenarioAtual.escolha);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do seu personagem: ");
        String nome = scanner.nextLine();

        // Instancia a View, inicializando internamente o RepositorioCenario
        ViewTela jogo = new ViewTela(nome);

        // Exemplo de navegação: mudando para o Centro da Capital
        System.out.println("\nPressione ENTER para continuar para a Capital...");
        scanner.nextLine();
        jogo.carregarCenario("Centro da Capital");
    }
}