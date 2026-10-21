package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import model.Conquista;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ConquistaController {
    private static final Path CAMINHO = Paths.get("conquistas.json");
    private static final Type TIPO = new TypeToken<LinkedHashMap<String, String>>() {}.getType();
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private List<Conquista> catalogoConquistas;

    public ConquistaController() {
        catalogoConquistas = new ArrayList<>();
        catalogoConquistas.add(new Conquista("HEROI_FAVELAS", "O Herói das Favelas", "Confisque o ouro da Catedral, financie o laboratório de Laila e destrua o poder da Igreja."));
        catalogoConquistas.add(new Conquista("NOVO_LORDE", "O Novo Lorde", "Entregue a cura ao Rei, receba baús de ouro e feche os olhos enquanto as favelas queimam."));
        catalogoConquistas.add(new Conquista("INQUISIDOR_CHEFE", "Inquisidor Chefe", "Prenda o Duque Rodrigo e elimine o mal de Oblitum pela raiz."));
        catalogoConquistas.add(new Conquista("REI_SOMBRAS", "O Rei das Sombras", "Chantageie o Duque Rodrigo e governe a capital pelas sombras."));
        catalogoConquistas.add(new Conquista("ABRACO_OBLITUM", "O Abraço de Oblitum", "Perca todos os seus pontos de Vida."));
        catalogoConquistas.add(new Conquista("PRECO_GANANCIA", "O Preço da Ganância", "Na casa de Silas, escolha a bolsa de moedas de ouro em vez dos livros ou do catalisador."));
        catalogoConquistas.add(new Conquista("ALQUIMIA_PERFEITA", "Alquimia Perfeita", "Entregue o Catalisador Perfeito da caixa misteriosa para Laila."));
        catalogoConquistas.add(new Conquista("MILAGREIRO_RUAS", "Milagreiro das Ruas", "Cure a criança desmaiada no meio da favela sem ser espancado pela multidão."));
        catalogoConquistas.add(new Conquista("LINGUA_PRATA", "Língua de Prata", "Pague para a Conselheira Zuri lhe ensinar a etiqueta e manipulação da alta nobreza."));
    }

    public static Map<String, String> carregarDadosJson() {
        if (!Files.exists(CAMINHO)) return new LinkedHashMap<>();
        try {
            String json = Files.readString(CAMINHO, StandardCharsets.UTF_8);
            Map<String, String> mapa = gson.fromJson(json, TIPO);
            return mapa != null ? mapa : new LinkedHashMap<>();
        } catch (IOException | JsonParseException e) {
            return new LinkedHashMap<>();
        }
    }

    public static boolean desbloquear(String idConquista) {
        Map<String, String> mapa = carregarDadosJson();
        if (mapa.containsKey(idConquista)) return false;

        mapa.put(idConquista, "desbloqueada");
        try {
            Files.writeString(CAMINHO, gson.toJson(mapa, TIPO), StandardCharsets.UTF_8);
        } catch (IOException e) {
        }
        return true;
    }

    public List<Conquista> getCatalogoComProgresso() {
        Map<String, String> salvas = carregarDadosJson();
        for (Conquista c : catalogoConquistas) {
            c.setDesbloqueada(salvas.containsKey(c.getId()));
        }
        return catalogoConquistas;
    }

    public int getTotalConquistadas() {
        Map<String, String> salvas = carregarDadosJson();
        int count = 0;
        for (Conquista c : catalogoConquistas) {
            if (salvas.containsKey(c.getId())) count++;
        }
        return count;
    }

    public String getNome(String idConquista) {
        for (Conquista c : catalogoConquistas) {
            if (c.getId().equals(idConquista)) {
                return c.getNome();
            }
        }
        return idConquista;
    }

    public int getTotalCatalogo() {
        return catalogoConquistas.size();
    }
}