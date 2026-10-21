package controller;

import view.JogoView;
import model.Cenario;
import model.Save;
import model.NPC;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class JogoController {
    private PlayerController playerController;
    private GerenciadorCenario gerenciadorCenario;
    private JogoView view;
    private SaveController saveController;
    private String cenaInicial = "Casa do Jogador";
    private String ultimaCenaAutosave = "";

    private final List<String> CENAS_AUTOSAVE = Arrays.asList(
            "Centro da Capital",
            "Bar",
            "Casa de Sillas",
            "Laboratório",
            "Portões do Bairro Nobre (Sem Passe)",
            "Catedral",
            "Castelo Real"
    );

    public JogoController(PlayerController playerController, GerenciadorCenario gerenciadorCenario, JogoView view) {
        this.playerController = playerController;
        this.gerenciadorCenario = gerenciadorCenario;
        this.view = view;
        this.saveController = new SaveController();
    }

    public void setCenaInicial(String cenaInicial) {
        this.cenaInicial = cenaInicial;
    }

    private Save criarSaveAtual(String cenaNome) {
        Map<String, Integer> amizadesAtuais = new HashMap<>();
        for (String nomeNpc : Arrays.asList("Sillas", "Laila", "Zuri")) {
            NPC npc = playerController.getRepositorioPersonagens().getNPC(nomeNpc);
            if (npc != null) {
                amizadesAtuais.put(nomeNpc, npc.getAmizade());
            }
        }
        return new Save(playerController.getPlayer(), cenaNome, amizadesAtuais);
    }

    public void iniciarJogo() {
        PreferenciaController configController = new PreferenciaController();
        String corANSI = configController.getConfigAtual().getCorFonte().equals("VERMELHO") ? "\u001B[31m" : "\u001B[37m";
        view.setCorAtual(corANSI);
        gerenciadorCenario.acessarCenario(this.cenaInicial);
        boolean jogando = true;

        while (jogando) {
            Cenario cenaAtual = gerenciadorCenario.getCenaAtual();

            verificarAutoSave(cenaAtual.getNome());

            if (cenaAtual.getFalas() != null) {
                for (String fala : cenaAtual.getFalas()) {
                    view.exibirTexto(fala);
                }
            }

            if (cenaAtual.getNome().contains("Game Over") || cenaAtual.getNome().contains("FIM DE JOGO")) {
                jogando = false;
                view.exibirTexto("\nFim de Jogo!");
                view.pausar();
                continue;
            }

            if (cenaAtual.getEscolha() != null && !cenaAtual.getEscolha().isEmpty()) {
                view.exibirTexto(cenaAtual.getEscolha());
                view.exibirOpcaoPause();

                int escolha = view.pedirEscolha();

                if (escolha == 0) {
                    boolean sair = abrirMenuPause();
                    if (sair) {
                        jogando = false;
                    }
                    continue;
                }

                boolean sucesso = playerController.tentarEscolha(escolha);

                String proximaCena = gerenciadorCenario.definirProximaCena(
                        cenaAtual.getNome(), escolha, sucesso, playerController.getPlayer());

                if (playerController.getPlayer().getVida() <= 0) {
                    proximaCena = "Game Over - O Abraço de Oblitum";
                }

                if (proximaCena != null && !proximaCena.isEmpty()) {
                    gerenciadorCenario.acessarCenario(proximaCena);
                } else if (!sucesso) {
                    view.exibirTexto("Você não tem os requisitos ou falhou na ação.");
                }
                view.pausar();
            } else {
                String proximaCena = gerenciadorCenario.definirProximaCena(
                        cenaAtual.getNome(), 0, true, playerController.getPlayer());

                if (playerController.getPlayer().getVida() <= 0) {
                    proximaCena = "Game Over - O Abraço de Oblitum";
                }

                if (proximaCena != null && !proximaCena.isEmpty()) {
                    view.pausar();
                    gerenciadorCenario.acessarCenario(proximaCena);
                } else {
                    jogando = false;
                    view.exibirTexto("\nFim de Jogo!");
                    view.pausar();
                }
            }
        }
    }

    private void verificarAutoSave(String nomeCena) {
        if (nomeCena == null) return;

        String cenaLimpa = nomeCena.trim();
        boolean ehCenaChave = false;

        for (String cenaAuto : CENAS_AUTOSAVE) {
            if (cenaAuto.trim().equalsIgnoreCase(cenaLimpa)) {
                ehCenaChave = true;
                break;
            }
        }

        if (ehCenaChave && !cenaLimpa.equals(ultimaCenaAutosave)) {
            try {
                Save autoSave = criarSaveAtual(cenaLimpa);
                saveController.salvar(0, autoSave);
                view.exibirTexto("\n\u001B[33m[Progresso Salvo Automaticamente]\u001B[0m");
                ultimaCenaAutosave = cenaLimpa;
            } catch (Exception e) {
                view.exibirTexto("\n\u001B[31m[Erro no Salvamento Automático]\u001B[0m");
            }
        }
    }

    private boolean abrirMenuPause() {
        boolean noPause = true;
        while (noPause) {
            view.exibirMenuPause();
            int op = view.pedirEscolha();

            if (op == 1) {
                return false;
            } else if (op == 2) {
                salvarJogoManual();
            } else if (op == 3) {
                return true;
            } else {
                view.exibirTexto("Opção inválida.");
            }
        }
        return false;
    }

    private void salvarJogoManual() {
        view.exibirPromptSalvamento();
        int slot = view.pedirEscolha();

        if (slot >= 1 && slot <= SaveController.SLOTS) {
            try {
                if (saveController.existeSave(slot)) {
                    String resumo = saveController.carregar(slot).getResumoMetadados();
                    view.exibirSobrescrita(resumo);

                    int confirmar = view.pedirEscolha();
                    if (confirmar != 1) {
                        view.exibirTexto("Salvamento cancelado.");
                        return;
                    }
                }

                Save novoSave = criarSaveAtual(gerenciadorCenario.getCenaAtual().getNome());
                saveController.salvar(slot, novoSave);
                view.exibirTexto("Jogo salvo com sucesso no Slot " + slot + "!");

            } catch (Exception e) {
                view.exibirTexto("Erro ao salvar o jogo: " + e.getMessage());
            }
        } else if (slot != 0) {
            view.exibirTexto("Slot inválido.");
        }
    }
}