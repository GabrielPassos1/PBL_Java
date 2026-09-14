
public class ControllerPlayer {
    private Protagonista player;

    public ControllerPlayer(Protagonista player) {
        this.player = player;
    }

    public void AddNome(String nome){
        this.player.nome = nome;
    }
    public Protagonista getPlayer(){
        return this.player;
    }
}
