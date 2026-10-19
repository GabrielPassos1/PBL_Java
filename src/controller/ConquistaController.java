package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

public class ConquistaController {
    private static final Path CAMINHO = Paths.get("conquistas.json");
    private static final Type TIPO = new TypeToken<LinkedHashMap<String, String>>() {}.getType();
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /** id da conquista -> data/hora em que foi desbloqueada. */
    public Map<String, String> carregar() {
        if (!Files.exists(CAMINHO)) return new LinkedHashMap<>();
        try {
            String json = Files.readString(CAMINHO, StandardCharsets.UTF_8);
            Map<String, String> mapa = gson.fromJson(json, TIPO);
            return mapa != null ? mapa : new LinkedHashMap<>();
        } catch (IOException | JsonParseException e) {
            System.err.println("Erro ao ler conquistas: " + e.getMessage());
            return new LinkedHashMap<>();
        }
    }

    /** @return true se foi desbloqueada agora; false se já estava (ou se não foi possível gravar). */
    public boolean desbloquear(String conquista) {
        Map<String, String> mapa = carregar();
        if (mapa.containsKey(conquista)) return false;

        String agora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        mapa.put(conquista, agora);
        try {
            Files.writeString(CAMINHO, gson.toJson(mapa, TIPO), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Erro ao salvar conquista: " + e.getMessage());
            return false;     // não avisa o jogador se não conseguiu gravar
        }
        return true;
    }
}