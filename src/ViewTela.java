import java.util.Scanner;

public class ViewTela{
    public static void main(String[] args){

        Protagonista player = new Protagonista();
        ControllerPlayer control = new ControllerPlayer(player);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual é o seu nome?");
        String nome = scanner.nextLine();

        control.AddNome(nome);

        System.out.println("Escolha uma classe: 1:Médico, 2:Cirurgião da Peste, 3: Clérigo, 4:Informações sobre as classes");
        int classe = scanner.nextInt();

        switch(classe){
            case 1:
                control.CriarMedico();
                break;

            case 2:
                control.CriarCirurgiao();
                break;

            case 3:
                control.CriarCirurgiao();
                break;

            case 4:
                System.out.println("O medico é mais focado na oratória, enquanto o cirurgião em medicina e o clérigo em Fé");
                break;
        }

        System.out.println(control.getPlayer().medicina);
        System.out.println(control.getPlayer().classe);
        System.out.println(control.getPlayer().fe);

    }
}
