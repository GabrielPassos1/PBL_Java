import java.util.Scanner;

public class ViewTela{
    public static void main(String[] args){
        Protagonista player = new Protagonista();
        ControllerPlayer control = new ControllerPlayer(player);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual é o seu nome?");
        String nome = scanner.nextLine();
        control.AddNome(nome);
        System.out.println(control.getPlayer().nome);
    }
}
