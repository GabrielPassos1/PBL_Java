import java.util.Random;
public class ControllerPlayer {
    private Protagonista player;
    private RepositorioCenario repositorio;
    private RepositorioPersonagens repositorioP;
    public Cenario cenaAtual;
    public NPC npcAtual;
    public Random rng = new Random();
    public int chance;
    public int sucesso;
    public int sorteio;
    public boolean precisaTeste;


    public ControllerPlayer(Protagonista player, RepositorioCenario repositorio) {
        this.repositorio = repositorio;
        this.player = player;
    }

    public void AddNome(String nome) {
        this.player.nome = nome;
    }

    public void AcessarCenario(String chave) {
        Cenario local = repositorio.getCenario(chave);
        cenaAtual = local;
    }
    public void AcessarPersonagem(String nome){
        NPC npc = repositorioP.getNPC(nome);
    }

    public Protagonista getPlayer() {
        return this.player;
    }

    public void CriarMedico() {
        this.player.medicina = 3;
        this.player.classe = 5;
        this.player.fe = 2;
    }

    public void CriarCirurgiao() {
        this.player.medicina = 5;
        this.player.classe = 2;
        this.player.fe = 3;
    }

    public void CriarClerigo() {
        this.player.medicina = 2;
        this.player.classe = 3;
        this.player.fe = 5;
    }

    // cobra o ouro em certas cenas
    public void RemoveOuro(int valor) {
        player.dinheiro = player.dinheiro - valor;
    }

    public void GanhaOuro(int valor) {
        player.dinheiro = player.dinheiro + valor;
    }

    public void PerdeVida() {
        player.vida--;
    }

    public void AumentaMedicina() {
        player.medicina = player.medicina + 1;
    }

    public void AumentaClasse() {
        player.medicina = player.classe + 1;
    }

    public void AumentaFe() {
        player.medicina = player.fe + 1;
    }

    private boolean testar(int chance) {
        return rng.nextInt(100) < chance;
    }

    public boolean tentarEscolha(int escolha) {
        if ("Subúrbio".equals(cenaAtual.nome)) {
             precisaTeste = (escolha == 6 && player.medicina < 5)
                    || (escolha == 7 && player.classe < 5)
                    || (escolha == 8 && player.fe < 5);
            if (precisaTeste && !testar(40)) {
                player.vida--;
                return false;
            }else{
                player.dinheiro = player.dinheiro + 10;
            }
        } else if ("Bar".equals(cenaAtual.nome)) {
             precisaTeste = (escolha == 1 && player.medicina < 5)
                    || (escolha == 2 && player.classe < 5)
                    || (escolha == 3 && player.fe < 5);
            if (precisaTeste && !testar(40)) {
                npcAtual.amizade--;
                return false;
            }
            else if ("Laboratório".equals(cenaAtual.nome)) {
                if (escolha == 1 && player.dinheiro > 10){
                    player.dinheiro = player.dinheiro - 10;
                    player.medicina++;
                    npcAtual.amizade++;
                }
                else if(escolha == 2 && player.inventario.contains("Caixa")){
                    npcAtual.amizade = npcAtual.amizade + 3;
                }
                return true;
            }

        } else if ("Bairro Nobre".equals(cenaAtual.nome) && player.inventario.isEmpty()) {
             precisaTeste = (escolha == 1 && player.medicina < 5)
                    || (escolha == 2 && player.classe < 5)
                    || (escolha == 3 && player.fe < 5);
            if (precisaTeste && !testar(40)) {
                return false;
            }
        }

        else if ("Bairro Nobre".equals(cenaAtual.nome) && player.inventario.contains("passe")) {
            precisaTeste = (escolha == 5 && player.medicina < 5)
                    || (escolha == 6 && player.classe < 5)
                    || (escolha == 7 && player.fe < 5);
            if (precisaTeste && !testar(40)) {
                return false;
            }else{
                player.dinheiro = player.dinheiro + 15;
            }
        }

        else if ("Taberna".equals(cenaAtual.nome)) {
            precisaTeste = (escolha == 1 && player.medicina < 5)
                    || (escolha == 2 && player.classe < 5)
                    || (escolha == 3 && player.fe < 5);
            if (precisaTeste && !testar(40)) {
                return false;
            } else {
                player.dinheiro = player.dinheiro + 15;
            }
        }
        else if ("Catedral".equals(cenaAtual.nome)) {
            if (escolha == 1 && player.dinheiro > 30){
                player.dinheiro = player.dinheiro - 30;
                player.fe++;
            }
                else if(escolha == 2 && player.dinheiro > 50){
                    player.inventario.add("Convite");
                    player.dinheiro = player.dinheiro - 50;
            }
                    else if (escolha == 3 ){
                        player.vida--;
            }
             return true;
        }
        else if ("Mansão de Rodrigo".equals(cenaAtual.nome)) {
            if (escolha == 1){
                player.inventario.add("Passe Real");
            }
            else if(escolha == 2 && player.dinheiro < 15){
                player.inventario.add("Passe Real");
                player.classe++;
                player.dinheiro = player.dinheiro - 15;
                npcAtual.amizade++;
                return true;
            }
            else if (escolha == 3 ){
                player.inventario.add("Passe Real");
                npcAtual.amizade--;

            }
        }

        else if ("Castelo Real".equals(cenaAtual.nome)) {
            if (escolha == 2 && (player.fe < 5 || player.classe < 5)){
                player.inventario.add("Mandato");
            }
            else if(escolha == 3 && (player.medicina < 5 || player.classe < 5)){
                player.inventario.add("Passe Real");
            }


        }

        return true;
    }
}



