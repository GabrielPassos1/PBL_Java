package controller;

import model.Conquista;
import view.MenuView;
import model.Save;
import model.NPC;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class MenuController {
    private MenuView view;
    private boolean menuRodando;
    private PlayerController playerController;
    private JogoController jogoController;
    private PreferenciaController configController;
    private SaveController saveController;

    public MenuController(PlayerController playerController, JogoController jogoController) {
        this.view = new MenuView();
        this.menuRodando = true;
        this.playerController = playerController;
        this.jogoController = jogoController;
        this.configController = new PreferenciaController();
        this.saveController = new SaveController();
    }

    public void iniciar() {
        while (menuRodando) {
            atualizarCorDaView();
            view.exibirMenuPrincipal();
            String escolha = view.pedirEscolha();

            switch (escolha) {
                case "1":
                    abrirMenuJogar();
                    break;
                case "2":
                    abrirMenuConquistas();
                    break;
                case "3":
                    abrirMenuConfiguracoes();
                    break;
                case "4":
                    mostrarInstrucoes();
                    break;
                case "5":
                    mostrarCreditos();
                    break;
                case "6":
                    menuRodando = false;
                    System.exit(0);
                    break;
                default:
                    view.mostrarTexto("Opção inválida.");
                    break;
            }
        }
    }

    private void atualizarCorDaView() {
        String corANSI = configController.getConfigAtual().getCorFonte().equals("VERMELHO") ? "\u001B[31m" : "\u001B[37m";
        view.setCorAtual(corANSI);
    }

    private void abrirMenuJogar() {
        ConquistaController conquistaController = new ConquistaController();
        boolean noMenuJogar = true;

        while (noMenuJogar) {
            boolean extraDesbloqueada = conquistaController.carregarDadosJson().containsKey("INQUISIDOR_CHEFE");

            view.exibirMenuJogarDinamico(extraDesbloqueada);
            String escolha = view.pedirEscolha();

            if (extraDesbloqueada) {
                switch (escolha) {
                    case "1":
                        iniciarNovaPartida();
                        break;
                    case "2":
                        continuarJogo();
                        break;
                    case "3":
                        abrirMenuCarregar();
                        break;
                    case "4":
                        view.exibirCenaExtraAmigoNasSombras();
                        break;
                    case "5":
                        noMenuJogar = false;
                        break;
                    default:
                        view.mostrarTexto("Opção inválida.");
                        view.pausar();
                        break;
                }
            } else {
                switch (escolha) {
                    case "1":
                        iniciarNovaPartida();
                        break;
                    case "2":
                        continuarJogo();
                        break;
                    case "3":
                        abrirMenuCarregar();
                        break;
                    case "4":
                        noMenuJogar = false;
                        break;
                    default:
                        view.mostrarTexto("Opção inválida.");
                        view.pausar();
                        break;
                }
            }
        }
    }

    private void abrirMenuCarregar() {
        boolean noMenuCarregar = true;
        while (noMenuCarregar) {
            view.mostrarTexto("\n╔════════════════════════════════════════ CARREGAR JOGO ════════════════════════════════════════╗");

            for (int i = 1; i <= SaveController.SLOTS; i++) {
                String textoLinha;
                try {
                    if (saveController.existeSave(i)) {
                        Save save = saveController.carregar(i);
                        textoLinha = String.format("[%d] %s", i, save.getResumoMetadados());
                    } else {
                        textoLinha = String.format("[%d] Vazio", i);
                    }
                } catch (Exception e) {
                    textoLinha = String.format("[%d] Dados corrompidos", i);
                }

                view.mostrarTexto(String.format("║ %-93s ║", textoLinha));
            }

            view.mostrarTexto("╠═══════════════════════════════════════════════════════════════════════════════════════════════╣");
            view.mostrarTexto(String.format("║ %-93s ║", "[A] Excluir um Save"));
            view.mostrarTexto(String.format("║ %-93s ║", "[V] Voltar"));

            view.mostrarTexto("╚═══════════════════════════════════════════════════════════════════════════════════════════════╝");

            String op = view.pedirEscolha().toUpperCase();

            if (op.equals("V")) {
                noMenuCarregar = false;
            } else if (op.equals("A")) {
                excluirSave();
            } else {
                try {
                    int slot = Integer.parseInt(op);
                    if (slot >= 1 && slot <= SaveController.SLOTS) {
                        if (saveController.existeSave(slot)) {
                            carregarPartida(slot);
                            noMenuCarregar = false;
                        } else {
                            view.mostrarTexto("Slot vazio!");
                            view.pausar();
                        }
                    } else {
                        view.mostrarTexto("Opção inválida.");
                    }
                } catch (NumberFormatException e) {
                    view.mostrarTexto("Opção inválida.");
                }
            }
        }
    }

    private void carregarPartida(int slot) {
        try {
            Save saveCarregado = saveController.carregar(slot);

            playerController.setPlayer(saveCarregado.getPlayer());

            if (saveCarregado.getAmizadesNpcs() != null) {
                for (Map.Entry<String, Integer> entry : saveCarregado.getAmizadesNpcs().entrySet()) {
                    NPC npc = playerController.getRepositorioPersonagens().getNPC(entry.getKey());
                    if (npc != null) {
                        npc.setAmizade(entry.getValue());
                    }
                }
            }

            view.mostrarTexto("\nJogo carregado com sucesso! Bem-vindo de volta, " + playerController.getPlayer().getNome() + ".");
            view.pausar();

            jogoController.setCenaInicial(saveCarregado.getCenaAtual());
            jogoController.iniciarJogo();
        } catch (Exception e) {
            view.mostrarTexto("Erro crítico ao tentar carregar o save: " + e.getMessage());
            view.pausar();
        }
    }

    private void continuarJogo() {
        int ultimoSlot = -1;
        long ultimaModificacao = -1;

        for (int i = 0; i <= SaveController.SLOTS; i++) {
            if (saveController.existeSave(i)) {
                long timestamp = saveController.obterUltimaModificacao(i);
                if (timestamp > ultimaModificacao) {
                    ultimaModificacao = timestamp;
                    ultimoSlot = i;
                }
            }
        }

        if (ultimoSlot != -1) {
            carregarPartida(ultimoSlot);
        } else {
            view.mostrarTexto("Nenhum progresso encontrado para continuar.");
            view.pausar();
        }
    }

    private void excluirSave() {
        view.mostrarTexto("Qual slot deseja excluir? (1 a 3)");
        String op = view.pedirEscolha();
        try {
            int slot = Integer.parseInt(op);
            if (slot >= 1 && slot <= SaveController.SLOTS && saveController.existeSave(slot)) {
                view.mostrarTexto("Tem certeza que deseja apagar o Slot " + slot + "? (S/N)");
                String confirmacao = view.pedirEscolha().toUpperCase();
                if (confirmacao.equals("S")) {
                    saveController.deletar(slot);
                    view.mostrarTexto("Save deletado com sucesso.");
                } else {
                    view.mostrarTexto("Exclusão cancelada.");
                }
            } else {
                view.mostrarTexto("Slot inválido ou já está vazio.");
            }
        } catch (Exception e) {
            view.mostrarTexto("Opção inválida.");
        }
        view.pausar();
    }

    private void iniciarNovaPartida() {
        int slotDisponivel = saveController.obterProximoSlotDisponivel();

        if (slotDisponivel == -1) {
            view.mostrarTexto("\nNão é possível criar um novo jogo sem apagar um dos saves, pois todos os espaços estão cheios!");
            view.pausar();
            return;
        }

        view.mostrarTexto("Como gostaria de ser chamado?");
        String nome = view.pedirEscolha();

        view.exibirMenuProfissoes();
        String classeEscolhida = view.pedirEscolha();

        playerController.AddNome(nome);

        if (classeEscolhida.equals("1")) playerController.CriarMedico();
        else if (classeEscolhida.equals("2")) playerController.CriarCirurgiao();
        else if (classeEscolhida.equals("3")) playerController.CriarClerigo();
        else playerController.CriarMedico();

        playerController.GanhaOuro(configController.getConfigAtual().getDinheiroInicial());

        String cenaInicial = configController.getConfigAtual().isPularIntroducao() ? "Centro da Capital" : "Casa do Jogador";

        Map<String, Integer> amizadesIniciais = new HashMap<>();
        amizadesIniciais.put("Sillas", 0);
        amizadesIniciais.put("Laila", 0);
        amizadesIniciais.put("Zuri", 0);

        Save novoSave = new Save(playerController.getPlayer(), cenaInicial, amizadesIniciais);

        try {
            saveController.salvar(slotDisponivel, novoSave);
        } catch (Exception e) {
            view.mostrarTexto("Erro ao salvar o jogo: " + e.getMessage());
            view.pausar();
            return;
        }

        view.mostrarTexto("A jogatina está iniciando! Salvo automaticamente no slot " + slotDisponivel + ". Prepare-se, " + playerController.getPlayer().getNome() + "...");

        jogoController.setCenaInicial(cenaInicial);
        jogoController.iniciarJogo();
    }

    private void abrirMenuConfiguracoes() {
        boolean noMenuConfig = true;
        while (noMenuConfig) {
            String corFonte = configController.getConfigAtual().getCorFonte();
            String pularIntro = configController.getConfigAtual().isPularIntroducao() ? "SIM" : "NÃO";
            int dinheiroInicial = configController.getConfigAtual().getDinheiroInicial();

            String menu = String.format(
                    "\n╔═════════ CONFIGURAÇÕES ════════╗\n" +
                            "║ %-30s ║\n" +
                            "║ %-30s ║\n" +
                            "║ %-30s ║\n" +
                            "║ %-30s ║\n" +
                            "╚════════════════════════════════╝",
                    "[1] Cor da Fonte: " + corFonte,
                    "[2] Pular Introdução: " + pularIntro,
                    "[3] Dinheiro Inicial: " + dinheiroInicial,
                    "[4] Voltar"
            );

            view.mostrarTexto(menu);
            String op = view.pedirEscolha();

            switch (op) {
                case "1":
                    String novaCor = configController.getConfigAtual().getCorFonte().equals("CINZA") ? "VERMELHO" : "CINZA";
                    configController.getConfigAtual().setCorFonte(novaCor);
                    atualizarCorDaView();
                    break;
                case "2":
                    configController.getConfigAtual().setPularIntroducao(!configController.getConfigAtual().isPularIntroducao());
                    break;
                case "3":
                    int novoDinheiro = configController.getConfigAtual().getDinheiroInicial() == 0 ? 10 : 0;
                    configController.getConfigAtual().setDinheiroInicial(novoDinheiro);
                    break;
                case "4":
                    noMenuConfig = false;
                    break;
            }
            configController.salvar();
        }
    }

    private void mostrarInstrucoes() {
        view.exibirInstrucoes();
        view.pausar();
    }

    private void mostrarCreditos() {
        view.exibirCreditos();
        view.pausar();
    }

    private void abrirMenuConquistas() {
        ConquistaController conquistaController = new ConquistaController();
        List<Conquista> lista = conquistaController.getCatalogoComProgresso();
        int ganhas = conquistaController.getTotalConquistadas();
        int total = conquistaController.getTotalCatalogo();

        view.exibirMenuConquistas(lista, ganhas, total);
        view.pausar();
    }
}