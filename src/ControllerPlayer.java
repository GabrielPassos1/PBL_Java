
public class ControllerPlayer {
    private Protagonista player;
    private RepositorioCenarios repositorio;
    public Cenario cenaAtual;

    public ControllerPlayer(Protagonista player,RepositorioCenarios repositorio) {
        this.repositorio = repositorio;
        this.player = player;
    }

    public void AddNome(String nome){
        this.player.nome = nome;
    }

    public void AcessarCenario(String chave){
        Cenario local = repositorio.getCenario(chave);
        cenaAtual = local;
    }

    public Protagonista getPlayer(){
        return this.player;
    }

    public void CriarMedico(){
        this.player.medicina = 3;
        this.player.classe = 5;
        this.player.fe = 2;
    }

    public void CriarCirurgiao(){
        this.player.medicina = 5;
        this.player.classe = 2;
        this.player.fe = 3;
    }

    public void CriarClerigo(){
        this.player.medicina = 2;
        this.player.classe = 3;
        this.player.fe = 5;
    }

    // cobra o ouro em certas cenas
    public void RemoveOuro(int valor){
            player.dinheiro = player.dinheiro - valor;
    }

    public void GanhaOuro(int valor){
            player.dinheiro = player.dinheiro + valor;
    }

    public void PerdeVida(){
        player.vida = player.vida - 1;
    }

    public void AumentaMedicina(){
        player.medicina = player.medicina + 1;
    }

    public void AumentaClasse(){
        player.medicina = player.classe + 1;
    }

    public void AumentaFe(){
        player.medicina = player.fe + 1;
    }


}
