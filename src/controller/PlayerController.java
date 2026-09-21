package controller;

import model.*;

import java.util.Random;

public class PlayerController {
    private Protagonista player;
    private RepositorioPersonagens repositorioP;
    private GerenciadorCenario gerenciadorCenario;

    public NPC npcAtual;
    public Random rng = new Random();
    public boolean precisaTeste;

    public PlayerController(Protagonista player, GerenciadorCenario gerenciadorCenario, RepositorioPersonagens repositorioP) {
        this.player = player;
        this.gerenciadorCenario = gerenciadorCenario;
        this.repositorioP = repositorioP;
    }

    public Protagonista getPlayer() {
        return this.player;
    }

    public void AddNome(String nome) {
        this.player.setNome(nome);
    }

    public void AcessarPersonagem(String nome){
        this.npcAtual = repositorioP.getNPC(nome);
    }

    public void CriarMedico() {
        this.player.setMedicina(3);
        this.player.setClasse(5);
        this.player.setFe(2);
        this.player.setVida(2);
        this.player.setDinheiro(0);
    }

    public void CriarCirurgiao() {
        this.player.setMedicina(5);
        this.player.setClasse(2);
        this.player.setFe(3);
        this.player.setVida(2);
        this.player.setDinheiro(0);
    }

    public void CriarClerigo() {
        this.player.setMedicina(2);
        this.player.setClasse(3);
        this.player.setFe(5);
        this.player.setVida(2);
        this.player.setDinheiro(0);
    }

    public void RemoveOuro(int valor) {
        player.setDinheiro(player.getDinheiro() - valor);
    }

    public void GanhaOuro(int valor) {
        player.setDinheiro(player.getDinheiro() + valor);
    }

    public void PerdeVida() {
        player.setVida(player.getVida() - 1);
    }

    public void AumentaMedicina() {
        player.setMedicina(player.getMedicina() + 1);
    }

    public void AumentaClasse() {
        player.setClasse(player.getClasse() + 1);
    }

    public void AumentaFe() {
        player.setFe(player.getFe() + 1);
    }

    private boolean testar(int chance) {
        return rng.nextInt(100) < chance;
    }

    public boolean tentarEscolha(int escolha) {
        String nomeCenaAtual = gerenciadorCenario.getCenaAtual().getNome();

        if ("Subúrbio".equals(nomeCenaAtual)){
            if(escolha == 2 && !player.getInventario().contains("mapa")){
                return false;
            }
            else if(escolha == 3 && !player.getInventario().contains("Chave")){
                return false;
            }
        }
        if ("Subúrbio - Olhar em volta".equals(nomeCenaAtual)) {
            precisaTeste = (escolha == 1 && player.getMedicina() < 5)
                    || (escolha == 2 && player.getClasse() < 5)
                    || (escolha == 3 && player.getFe() < 5);

            if (precisaTeste && !testar(40)) {
                player.setVida(player.getVida() - 1);
                return false;
            } else if (escolha >= 1 && escolha <= 3) {
                player.setDinheiro(player.getDinheiro() + 10);
            }
        }
        else if("Centro da Capital".equals(nomeCenaAtual)){
            if (escolha == 3 && !player.getInventario().contains("Passe Real")){
                return false;
            }
        }
        else if ("Bar".equals(nomeCenaAtual)) {
            npcAtual = repositorioP.getNPC("Sillas");
            precisaTeste = (escolha == 1 && player.getMedicina() < 5)
                    || (escolha == 2 && player.getClasse() < 5)
                    || (escolha == 3 && player.getFe() < 5);

            if (precisaTeste && !testar(40)) {
                npcAtual.setAmizade(npcAtual.getAmizade() - 1);
                return false;
            }
            if (precisaTeste && testar(40) && escolha == 1){
                player.getInventario().add("Chave");
                player.getInventario().add("mapa");
                return true;
            }
            if (!precisaTeste && escolha == 1){
                player.getInventario().add("Chave");
                player.getInventario().add("mapa");
            }
            if (!precisaTeste && (escolha == 2 || escolha ==3)){
                player.getInventario().add("mapa");
            }

        }
        else if ("Portões do Bairro Nobre (Sem Passe)".equals(nomeCenaAtual)) {
            precisaTeste = (escolha == 1 && player.getMedicina() < 5)
                    || (escolha == 2 && player.getClasse() < 5)
                    || (escolha == 3 && player.getFe() < 5);

            if (precisaTeste && !testar(40)) {
                return false;
            }else  {
                player.getInventario().add("Passe");
            }
            if(escolha == 4 &&!player.getInventario().contains("Carta")) {
                return false;
            }else {
                player.getInventario().add("Passe");
            }
            }

            else if ("Bairro Nobre".equals(nomeCenaAtual)){
                if (escolha == 2) {
                    if (!player.getInventario().contains("Convite") && !player.getInventario().contains("Carta")) {
                        return false;
                    }
                }
            }

        else if ("Bairro Nobre - Olhar em volta".equals(nomeCenaAtual)) {
            precisaTeste = (escolha == 1 && player.getMedicina() < 5)
                    || (escolha == 2 && player.getClasse() < 5)
                    || (escolha == 3 && player.getFe() < 5);

            if (precisaTeste && !testar(40)) {
                return false;
            } else if (escolha >= 1 && escolha <= 3) {
                player.setDinheiro(player.getDinheiro() + 15);
            }
        }
        else if ("Casa de Sillas".equals(nomeCenaAtual)){
            if (escolha == 1){
                player.setMedicina(player.getMedicina() + 1);
                player.setClasse(player.getClasse() + 1);
            }
            else if (escolha == 2){
                player.setDinheiro(player.getDinheiro() + 50);
            }
            else if (escolha == 3){
                player.getInventario().add("Caixa");
            }
        }
        else if ("Laboratório".equals(nomeCenaAtual)) {
            npcAtual = repositorioP.getNPC("Laila");

            if (escolha == 1) {
                if (player.getDinheiro() < 10) {
                    return false;
                }else {
                    player.setDinheiro(player.getDinheiro() - 10);
                    player.setMedicina(player.getMedicina() + 1);
                    npcAtual.setAmizade(npcAtual.getAmizade() + 1);
                    if(npcAtual.getAmizade() == 5){
                        player.getInventario().add("Carta");
                    }
                    return true;
                }
            }
            else if (escolha == 2) {
                if (!player.getInventario().contains("Caixa")) {
                    if(npcAtual.getAmizade() == 5){
                        player.getInventario().add("Carta");
                    }
                    return false;
                }
                if (npcAtual != null) npcAtual.setAmizade(npcAtual.getAmizade() + 3);
            }
            else if (escolha == 3) {
                return true;
            }
        }
        else if ("Taberna".equals(nomeCenaAtual)) {
            precisaTeste = (escolha == 1 && player.getMedicina() < 5)
                    || (escolha == 2 && player.getClasse() < 5)
                    || (escolha == 3 && player.getFe() < 5);

            if (precisaTeste && !testar(40)) {
                return false;
            } else if (escolha >= 1 && escolha <= 3) {
                player.setDinheiro(player.getDinheiro() + 15);
            }
        }
        else if ("Catedral".equals(nomeCenaAtual)) {
            if (escolha == 1 ){
                if(player.getDinheiro() < 30){
                    return false;
                }
                player.setDinheiro(player.getDinheiro() - 30);
                player.setFe(player.getFe() + 1);
            }
            if (escolha == 2){
                if(player.getDinheiro() < 50){
                    return false;
                }
                player.getInventario().add("Convite");
                player.setDinheiro(player.getDinheiro() - 50);
            }
            if (escolha == 3 ){
                player.setVida(player.getVida() - 1);
            }
        }
        else if ("Mansão de Rodrigo".equals(nomeCenaAtual)) {
            npcAtual = repositorioP.getNPC("Zuri");
            if (escolha == 1){
                if(!player.getInventario().contains("Carta")){
                    return false;
                }
                player.getInventario().add("Passe Real");
            }
            if (escolha == 2){
                if( player.getDinheiro() < 15){
                    return false;
                }
                player.getInventario().add("Passe Real");
                player.setClasse(player.getClasse() + 1);
                player.setDinheiro(player.getDinheiro() - 15);
                npcAtual.setAmizade(npcAtual.getAmizade() + 1);
            }

            if (escolha == 3 ){
                player.getInventario().add("Passe Real");
                npcAtual = repositorioP.getNPC("Zuri");
                npcAtual.setAmizade(npcAtual.getAmizade() - 1);
            }
        }
        else if ("Castelo Real".equals(nomeCenaAtual)) {
            if (escolha == 2 && (player.getFe() >= 3 || player.getClasse() >= 3)){
                player.getInventario().add("Mandato");
            }
            else if (escolha == 3 && (player.getMedicina() >= 3 || player.getClasse() >= 3)){
                player.getInventario().add("Mandato");
            }
        }

        return true;
    }
}