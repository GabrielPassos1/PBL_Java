package controller;

import model.Cenario;
import model.Protagonista;
import model.RepositorioCenario;

public class GerenciadorCenario {
    private RepositorioCenario repositorio;
    private Cenario cenaAtual;

    public GerenciadorCenario(RepositorioCenario repositorio) {
        this.repositorio = repositorio;
    }

    public Cenario getCenaAtual() {
        return cenaAtual;
    }

    public void acessarCenario(String chave) {
        this.cenaAtual = repositorio.getCenario(chave);
    }

    public String definirProximaCena(String cena, int escolha, boolean sucesso, Protagonista player) {
        switch (cena) {
            case "Casa do Jogador":
                if (escolha == 1) return "Centro da Capital";
                break;
            case "Centro da Capital":
                if (escolha == 1) return "Subúrbio";
                if (escolha == 2) {
                    if (player.getInventario().contains("Passe")){
                        return "Bairro Nobre";
                    } else {
                        return "Portões do Bairro Nobre (Sem Passe)";
                    }
                }
                if (escolha == 3 && sucesso) return "Castelo Real";
                if (escolha == 4) return "Game Over - O Abraço de Oblitum";
                break;
            case "Subúrbio":
                if (escolha == 1) return "Bar";
                if (escolha == 2 && sucesso) return "Laboratório Clandestino";
                if (escolha == 3 && sucesso) return "Casa do Silas";
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
                if (escolha == 1 && sucesso) return  "Bar - Sucesso Medicina";
                if (escolha == 1 && sucesso == false) return "Bar - Falha Medicina";
                if (escolha == 2) return sucesso ? "Bar - Sucesso Classe" : "Bar - Falha Classe";
                if (escolha == 3) return sucesso ? "Bar - Sucesso Fé" : "Bar - Falha Fé";
                if (escolha == 4) return "Subúrbio";
                break;
            case "Casa de Sillas":
                if (escolha == 1) return "Casa do Silas - Livros";
                if (escolha == 2) return "Casa do Silas - Bolsa";
                if (escolha == 3) return "Casa do Silas - Caixa";
                if (escolha == 4) return "Subúrbio";
                break;
            case "Laboratório":
                if (escolha == 1 && sucesso) return "Laboratório Clandestino - Pesquisar";
                if (escolha == 2 && sucesso) return "Laboratório Clandestino - Entregar Caixa";
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
                if (escolha == 2 && sucesso) return "Mansão";
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
            case "Taberna":
                if (escolha == 1) return sucesso ? "Taverna Nobre - Sucesso Medicina" : "Taverna Nobre - Falha";
                if (escolha == 2) return sucesso ? "Taverna Nobre - Sucesso Classe" : "Taverna Nobre - Falha";
                if (escolha == 3) return sucesso ? "Taverna Nobre - Sucesso Fé" : "Taverna Nobre - Falha";
                if (escolha == 4) return "Bairro Nobre";
                break;
            case "Catedral":
                if (escolha == 1 && sucesso) return "Catedral - Opção 1";
                if (escolha == 2 && sucesso) return "Catedral - Opção 2";
                if (escolha == 3) return "Catedral - Opção 3";
                if (escolha == 4) return "Bairro Nobre";
                break;
            case "Mansão de Rodrigo":
                if (escolha == 1 && sucesso) return "Mansão - Opção 1";
                if (escolha == 2 && sucesso) return "Mansão - Opção 2";
                if (escolha == 3) return "Mansão - Opção 3";
                if (escolha == 4) return "Bairro Nobre";
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
}