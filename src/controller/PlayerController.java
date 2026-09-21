package controller;
import view.JogoView;
import model.*;

import java.util.Random;

public class PlayerController {
    private Protagonista player;
    private RepositorioCenario repositorio;
    private RepositorioPersonagens repositorioP;
    private JogoView view;

    public Cenario cenaAtual;
    public NPC npcAtual;
    public Random rng = new Random();
    public int chance;
    public int sucesso;
    public int sorteio;
    public boolean precisaTeste;

    public PlayerController(Protagonista player, RepositorioCenario repositorio, RepositorioPersonagens repositorioP) {
        this.repositorio = repositorio;
        this.player = player;
        this.repositorioP = repositorioP;
        this.view = new JogoView();
    }

    public void iniciarJogo() {
        acessarCenario("Casa do Jogador");
        boolean jogando = true;

        while (jogando) {
            // 1. Mostra a fala/narrativa da cena atual
            if (cenaAtual.getFalas() != null) {
                view.mostrarFalas(cenaAtual.getFalas());
            }

            // 2. Trava de segurança: Se a cena atual for o Game Over, encerra o jogo agora.
            if (cenaAtual.getNome().contains("Game Over")) {
                jogando = false;
                view.mostrarTexto("Fim de Jogo!");
                view.pausar();
                continue; // Pula o resto do loop e finaliza
            }

            // 3. Se a cena tiver escolhas, aguarda a interação do jogador
            if (cenaAtual.getEscolha() != null && !cenaAtual.getEscolha().isEmpty()) {
                view.mostrarTexto(cenaAtual.getEscolha());
                int escolha = view.pedirEscolha();

                boolean resultadoTeste = tentarEscolha(escolha);
                String proximaCena = definirProximaCena(cenaAtual.getNome(), escolha, resultadoTeste);

                // Verifica se a vida zerou nesta rodada
                if (player.getVida() <= 0) {
                    proximaCena = "Game Over - O Abraço de Oblitum";
                }

                if (proximaCena != null && !proximaCena.isEmpty()) {
                    acessarCenario(proximaCena);
                } else {
                    view.mostrarTexto("Ainda não há um caminho programado para esta escolha ou ocorreu um erro.");
                }

                view.pausar();
            } else {
                // 4. Cenas SEM opções de escolha (transições automáticas)
                String proximaCena = definirProximaCena(cenaAtual.getNome(), 0, true);

                // Verifica se a vida zerou (caso tenha sofrido dano por consequência)
                if (player.getVida() <= 0) {
                    proximaCena = "Game Over - O Abraço de Oblitum";
                }

                // Note que aqui usamos if independentes, sem "else if"
                if (proximaCena != null && !proximaCena.isEmpty()) {
                    view.pausar(); // Dá um tempo para o jogador ler o resultado
                    acessarCenario(proximaCena);
                } else {
                    // Cenas que não têm para onde ir encerram a campanha
                    jogando = false;
                    view.mostrarTexto("Fim de Jogo!");
                    view.pausar();
                }
            }
        }
    }
    private String definirProximaCena(String cena, int escolha, boolean sucesso) {
        switch (cena) {
            case "Casa do Jogador":
                if (escolha == 1) return "Centro da Capital";
                break;
            case "Centro da Capital":
                if (escolha == 1) return "Subúrbio";
                if (escolha == 2) {
                    if (player.getInventario().contains("Passe Real") || player.getInventario().contains("Convite")) {
                        return "Bairro Nobre";
                    } else {
                        return "Portões do Bairro Nobre (Sem Passe)";
                    }
                }
                if (escolha == 3) return "Castelo Real";
                if (escolha == 4) return "Game Over - O Abraço de Oblitum";
                break;
            case "Subúrbio":
                if (escolha == 1) return "Bar";
                if (escolha == 2) return "Laboratório Clandestino";
                if (escolha == 3) return "Casa do Silas";
                if (escolha == 4) return "Centro da Capital";
                if (escolha == 5) return "Subúrbio - Olhar em volta";
                break;
            case "Subúrbio - Olhar em volta":
                if (escolha == 1) return sucesso ? "Subúrbio - Sucesso Medicina" : "Subúrbio - Falha";
                if (escolha == 2) return sucesso ? "Subúrbio - Sucesso Classe" : "Subúrbio - Falha";
                if (escolha == 3) return sucesso ? "Subúrbio - Sucesso Fé" : "Subúrbio - Falha";
                if (escolha == 4) return "Subúrbio";
                break;
            case "Bar":
                if (escolha == 1) return sucesso ? "Bar - Sucesso Medicina" : "Bar - Falha Medicina";
                if (escolha == 2) return sucesso ? "Bar - Sucesso Classe" : "Bar - Falha Classe";
                if (escolha == 3) return sucesso ? "Bar - Sucesso Fé" : "Bar - Falha Fé";
                if (escolha == 4) return "Subúrbio";
                break;
            case "Casa de Sillas": // Nome interno cadastrado no Cenario
                if (escolha == 1) return "Casa do Silas - Livros";
                if (escolha == 2) return "Casa do Silas - Bolsa";
                if (escolha == 3) return "Casa do Silas - Caixa";
                if (escolha == 4) return "Subúrbio";
                break;
            case "Laboratório": // Nome interno cadastrado no Cenario
                if (escolha == 1) return "Laboratório Clandestino - Pesquisar";
                if (escolha == 2) return "Laboratório Clandestino - Entregar Caixa";
                if (escolha == 3) return "Subúrbio";
                break;
            case "Laboratório Clandestino - Etapa Concluída":
                if (escolha == 1) return "Portões do Bairro Nobre (Sem Passe)";
                break;
            case "Portões do Bairro Nobre (Sem Passe)":
                if (escolha == 1 || escolha == 2 || escolha == 3) return sucesso ? "Portões - Sucesso Atributos" : "Portões - Falha";
                if (escolha == 4) return sucesso ? "Portões - Sucesso Carta" : "Portões - Falha";
                if (escolha == 5) return "Centro da Capital";
                break;
            case "Bairro Nobre":
                if (escolha == 1) return "Taverna Nobre";
                if (escolha == 2) return "Mansão";
                if (escolha == 3) return "Catedral";
                if (escolha == 4) return "Bairro Nobre - Olhar em volta";
                if (escolha == 5) return "Centro da Capital";
                break;
            case "Bairro Nobre - Olhar em volta":
                if (escolha == 1) return sucesso ? "Praça - Sucesso Medicina" : "Praça - Falha";
                if (escolha == 2) return sucesso ? "Praça - Sucesso Classe" : "Praça - Falha";
                if (escolha == 3) return sucesso ? "Praça - Sucesso Fé" : "Praça - Falha";
                if (escolha == 4) return "Bairro Nobre";
                break;
            case "Taberna": // Nome interno cadastrado no Cenario
                if (escolha == 1) return sucesso ? "Taverna Nobre - Sucesso Medicina" : "Taverna Nobre - Falha";
                if (escolha == 2) return sucesso ? "Taverna Nobre - Sucesso Classe" : "Taverna Nobre - Falha";
                if (escolha == 3) return sucesso ? "Taverna Nobre - Sucesso Fé" : "Taverna Nobre - Falha";
                if (escolha == 4) return "Bairro Nobre";
                break;
            case "Catedral":
                if (escolha == 1) return "Catedral - Opção 1";
                if (escolha == 2) return "Catedral - Opção 2";
                if (escolha == 3) return "Catedral - Opção 3";
                if (escolha == 4) return "Bairro Nobre";
                break;
            case "Mansão de Rodrigo":
                if (escolha == 1) return "Mansão - Opção 1";
                if (escolha == 2) return "Mansão - Opção 2";
                if (escolha == 3) return "Mansão - Opção 3";
                break;
            case "Castelo Real":
                if (escolha == 1) return "Castelo Real - Opção 1";
                if (escolha == 2) return "Castelo Real - Retorno à Catedral";
                if (escolha == 3) return "Castelo Real - Encontrar Traidor";
                break;
            case "Castelo Real - Encontrar Traidor":
                if (escolha == 1 || escolha == 3) return "Encontrar Traidor - Consequência 1 e 3";
                if (escolha == 2) return "Encontrar Traidor - Consequência 2";
                break;
        }

        // Retornos genéricos para os Hubs Centrais
        if (cena.contains("- Sucesso") || cena.contains("- Falha") || cena.contains("- Livros") || cena.contains("- Bolsa") || cena.contains("- Caixa") || cena.contains("- Pesquisar") || cena.contains("- Entregar Caixa") || cena.contains("Opção")) {
            if (cena.startsWith("Subúrbio")) return "Subúrbio";
            if (cena.startsWith("Bar")) return "Bar";
            if (cena.startsWith("Casa do Silas")) return "Casa do Silas";
            if (cena.startsWith("Laboratório")) return "Laboratório Clandestino";

            // Aqui está a nova condição do Portão
            if (cena.startsWith("Portões")) {
                return cena.contains("Sucesso") ? "Bairro Nobre" : "Centro da Capital";
            }
            if (cena.startsWith("Praça")) return "Bairro Nobre";

            if (cena.startsWith("Taverna")) return "Taverna Nobre";
            if (cena.startsWith("Catedral")) return "Catedral";
            if (cena.startsWith("Mansão")) return "Bairro Nobre";
        }

        return null;
    }
    public void acessarCenario(String chave) {
        Cenario local = repositorio.getCenario(chave);
        cenaAtual = local;
    }

    public void AddNome(String nome) {
        this.player.setNome(nome);
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
        this.player.setMedicina(3);
        this.player.setClasse(5);
        this.player.setFe(2);
        this.player.setVida(2);
    }

    public void CriarCirurgiao() {
        this.player.setMedicina(5);
        this.player.setClasse(2);
        this.player.setFe(3);
        this.player.setVida(2);
    }

    public void CriarClerigo() {
        this.player.setMedicina(2);
        this.player.setClasse(3);
        this.player.setFe(5);
        this.player.setVida(2);
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
        player.setMedicina(player.getClasse() + 1);
    }

    public void AumentaFe() {
        player.setMedicina(player.getFe() + 1);
    }

    private boolean testar(int chance) {
        return rng.nextInt(100) < chance;
    }

    public boolean tentarEscolha(int escolha) {
        String nomeCenaAtual = cenaAtual.getNome();

        // 1. Corrigido para o sub-menu correto e opções de 1 a 3
        if ("Subúrbio - Olhar em volta".equals(nomeCenaAtual)) {
            precisaTeste = (escolha == 1 && player.getMedicina() < 5)
                    || (escolha == 2 && player.getClasse() < 5)
                    || (escolha == 3 && player.getFe() < 5);

            if (precisaTeste && !testar(40)) {
                player.setVida(player.getVida() - 1);
                return false; // Retorna falha se o teste não passar
            } else if (escolha >= 1 && escolha <= 3) {
                player.setDinheiro(player.getDinheiro() + 10);
            }
        }
        else if ("Bar".equals(nomeCenaAtual)) {
            npcAtual = repositorioP.getNPC("Sillas");
            precisaTeste = (escolha == 1 && player.getMedicina() < 5)
                    || (escolha == 2 && player.getClasse() < 5)
                    || (escolha == 3 && player.getFe() < 5);

            if (precisaTeste && !testar(40)) {
                if (npcAtual != null) npcAtual.setAmizade(npcAtual.getAmizade() - 1);
                return false;
            }
        }

        else if ("Portões do Bairro Nobre (Sem Passe)".equals(nomeCenaAtual)) {
            precisaTeste = (escolha == 1 && player.getMedicina() < 5)
                    || (escolha == 2 && player.getClasse() < 5)
                    || (escolha == 3 && player.getFe() < 5)
                    || (escolha == 4 && !player.getInventario().contains("Convite"));

            if (precisaTeste && !testar(40)) {
                return false;
            }else{
                player.getInventario().add("Passe Real");
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
            if(escolha == 1){
                player.setMedicina(player.getMedicina() + 1);
                player.setClasse(player.getClasse() + 1);
            }
            else if(escolha == 2){
                player.setDinheiro(player.getDinheiro() + 50);
            }
            else if (escolha == 3){
                player.getInventario().add("Caixa");
            }
        }
        else if ("Laboratório".equals(nomeCenaAtual)) {
            npcAtual = repositorioP.getNPC("Laila");
            if (escolha == 1 && player.getDinheiro() > 10){
                player.setDinheiro(player.getDinheiro() - 10);
                player.setMedicina(player.getMedicina() + 1);
                if (npcAtual != null) npcAtual.setAmizade(npcAtual.getAmizade() + 1);
            }
            else if(escolha == 2 && player.getInventario().contains("Caixa")){
                npcAtual = repositorioP.getNPC("Laila");
                if (npcAtual != null) npcAtual.setAmizade(npcAtual.getAmizade() + 3);
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
            if (escolha == 1 && player.getDinheiro() >= 30){
                player.setDinheiro(player.getDinheiro() - 30);
                player.setFe(player.getFe() + 1);
            }
            else if(escolha == 2 && player.getDinheiro() >= 50){
                player.getInventario().add("Convite");
                player.setDinheiro(player.getDinheiro() - 50);
            }
            else if (escolha == 3 ){
                player.setVida(player.getVida() - 1);
            }
        }
        else if ("Mansão de Rodrigo".equals(nomeCenaAtual)) {
            if (escolha == 1){
                player.getInventario().add("Passe Real");
            }
            else if(escolha == 2 && player.getDinheiro() >= 15){
                npcAtual = repositorioP.getNPC("Zuri");
                player.getInventario().add("Passe Real");
                player.setClasse(player.getClasse() + 1);
                player.setDinheiro(player.getDinheiro() - 15);
                if (npcAtual != null) npcAtual.setAmizade(npcAtual.getAmizade() + 1);
            }
            else if (escolha == 3 ){
                player.getInventario().add("Passe Real");
                npcAtual = repositorioP.getNPC("Zuri");
                if (npcAtual != null) npcAtual.setAmizade(npcAtual.getAmizade() - 1);
            }
        }
        else if ("Castelo Real".equals(nomeCenaAtual)) {
            if (escolha == 2 && (player.getFe() >= 3 || player.getClasse() >= 3)){
                player.getInventario().add("Mandato");
            }
            else if(escolha == 3 && (player.getMedicina() >= 3 || player.getClasse() >= 3)){
                player.getInventario().add("Passe Real");
            }
        }


        return true;
    }
}