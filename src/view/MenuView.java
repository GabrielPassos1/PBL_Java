package view;
import java.util.Scanner;

public class MenuView {
    private Scanner scanner;

    public MenuView() {
        this.scanner = new Scanner((System.in));
    }

    public void mostrarTexto(String texto) {
        System.out.println(texto);
    }

    public String pedirEscolha() {
        System.out.print("Digite sua escolha: ");
        return scanner.nextLine().trim();
    }

    public void pausar() {
        System.out.print("Pressione ENTER para continuar...");
        scanner.nextLine();
    }
}