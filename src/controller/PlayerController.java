package controller;

import model.*;

import java.util.Random;

public class PlayerController {
    private Protagonista player;
    private RepositorioPersonagens repositorioP;
    private GerenciadorCenario gerenciadorCenario;
    private static final int CHANCE_BASE = 20;
    private static final int BONUS_POR_PONTO = 10;

    public NPC npcAtual;
    public Random rng = new Random();
    public boolean precisaTeste;

    public Itens itens = new Itens();

    public PlayerController(Protagonista player, GerenciadorCenario gerenciadorCenario, RepositorioPersonagens repositorioP) {
        this.player = player;
        this.gerenciadorCenario = gerenciadorCenario;
        this.repositorioP = repositorioP;
    }

    public Protagonista getPlayer() {
        return this.player;
    }

    public void setPlayer(Protagonista playerCarregado) {
        this.player = playerCarregado;
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
        this.player.setVida(4);
        this.player.setDinheiro(0);
    }

    public void CriarCirurgiao() {
        this.player.setMedicina(5);
        this.player.setClasse(2);
        this.player.setFe(3);
        this.player.setVida(4);
        this.player.setDinheiro(0);
    }

    public void CriarClerigo() {
        this.player.setMedicina(2);
        this.player.setClasse(3);
        this.player.setFe(5);
        this.player.setVida(4);
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

    private int atributo(int escolha) {
        switch (escolha) {
            case 1: return player.getMedicina();
            case 2: return player.getClasse();
            case 3: return player.getFe();
            default: return 0;
        }
    }

    public int chanceDeSucesso(int escolha) {
        int chance = CHANCE_BASE + atributo(escolha) * BONUS_POR_PONTO;
        return Math.max(10, Math.min(95, chance));
    }

    private boolean testar(int escolha) {
        return rng.nextInt(100) < chanceDeSucesso(escolha);
    }

    public boolean tentarEscolha(int escolha) {
        String nomeCenaAtual = gerenciadorCenario.getCenaAtual().getNome();

        if ("Subúrbio".equals(nomeCenaAtual)){
            if(escolha == 2 && !player.getInventario().contains(Itens.MAPA)){
                return false;
            }
            else if(escolha == 3 && !player.getInventario().contains(Itens.CHAVE)){
                return false;
            }
        }
        if ("Subúrbio - Olhar em volta".equals(nomeCenaAtual)) {
            if (!testar(escolha)) {
                PerdeVida();
                return false;
            } else if (escolha >= 1 && escolha <= 3) {
                player.setDinheiro(player.getDinheiro() + 10);
            }
        }
        else if("Centro da Capital".equals(nomeCenaAtual)){
            if (escolha == 3 && !player.getInventario().contains(Itens.PASSE_REAL)){
                return false;
            }
        }
        else if ("Bar".equals(nomeCenaAtual)) {
            npcAtual = repositorioP.getNPC("Sillas");
            if (escolha >= 1 && escolha <= 3) {
                if (!testar(escolha)) {
                    npcAtual.setAmizade(npcAtual.getAmizade() - 1);
                    return false;
                }
                if (escolha == 1 && player.registrarEvento("Bar-" + escolha)) player.addItem(Itens.CHAVE);

                player.addItem(Itens.MAPA);
            }
        }
        else if ("Portões do Bairro Nobre (Sem Passe)".equals(nomeCenaAtual)) {
            if (escolha >= 1 && escolha <= 3) {
                if (!testar(escolha)) return false;
                player.addItem(Itens.PASSE);
            } else if (escolha == 4) {
                if (!player.temItem(Itens.CARTA)) return false;
                player.addItem(Itens.PASSE);
            }
            // escolha 5 (voltar): não dá nada
        }

        else if ("Bairro Nobre - Olhar em volta".equals(nomeCenaAtual)) {
            if (!testar(escolha)) {
                return false;
            } else if (escolha >= 1 && escolha <= 3) {
                player.setDinheiro(player.getDinheiro() + 15);
            }
        }
        else if ("Casa de Sillas".equals(nomeCenaAtual)) {
            if (escolha >= 1 && escolha <= 3 && player.registrarEvento("silas-" + escolha)) {
                if (escolha == 1){
                    AumentaMedicina();
                    AumentaClasse();

                }
                else if (escolha == 2) {
                    GanhaOuro(50);
                }
                else{
                    player.addItem(Itens.CAIXA);
                }
            }
            player.removeItem(Itens.CHAVE);
        }
        else if ("Laboratório".equals(nomeCenaAtual)) {
            npcAtual = repositorioP.getNPC("Laila");

            if (escolha == 1) {
                if (player.getDinheiro() < 10) {
                    return false;
                }else {
                    RemoveOuro(10);
                    AumentaMedicina();
                    npcAtual.setAmizade(npcAtual.getAmizade() + 1);
                    if(npcAtual.getAmizade() >= 5){
                        player.addItem(Itens.CARTA);
                    }
                    return true;
                }
            }
            else if (escolha == 2) {
                if (!player.getInventario().contains(Itens.CAIXA)) {
                    return false;
                }
                else if (npcAtual != null){
                    npcAtual.setAmizade(npcAtual.getAmizade() + 3);
                    if(npcAtual.getAmizade() >= 5){
                        player.addItem(Itens.CARTA);
                        player.removeItem(Itens.CAIXA);
                    }
                }
            }
            else if (escolha == 3) {
                return true;
            }
        }
        else if ("Taberna".equals(nomeCenaAtual)) {
            if (!testar(escolha)) {
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
                player.addItem(Itens.CONVITE);
                player.setDinheiro(player.getDinheiro() - 50);
            }
            if (escolha == 3 ){
                player.setVida(player.getVida() - 1);
            }
        }
        else if ("Mansão de Rodrigo".equals(nomeCenaAtual)) {
            npcAtual = repositorioP.getNPC("Zuri");
            if (escolha == 1){
                if(!player.getInventario().contains(Itens.CARTA)){
                    return false;
                }
                else{
                    if(player.registrarEvento("Mansão-" + escolha)){
                        player.addItem(Itens.PASSE_REAL);
                    }

                }
            }
            if (escolha == 2){
                if( player.getDinheiro() < 15){
                    return false;
                }
                player.addItem(Itens.PASSE_REAL);
                player.setClasse(player.getClasse() + 1);
                player.setDinheiro(player.getDinheiro() - 15);
                npcAtual.setAmizade(npcAtual.getAmizade() + 1);
            }

            if (escolha == 3 && player.registrarEvento("Mansão-" + escolha) ){
                player.addItem(Itens.PASSE_REAL);
                npcAtual = repositorioP.getNPC("Zuri");
                npcAtual.setAmizade(npcAtual.getAmizade() - 1);
            }
        }
        else if ("Castelo Real".equals(nomeCenaAtual)) {
            if (escolha == 2 && (testar(escolha) && testar(3))){
                player.addItem(Itens.MANDATO);
            }
            else if (escolha == 3 && (testar(escolha) && testar(1))){
                player.addItem(Itens.MANDATO);
            }
        }

        return true;
    }
}