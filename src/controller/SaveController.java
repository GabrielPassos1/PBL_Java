package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Save;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;

public class SaveController {
    public static final int SLOTS = 3;
    private static final Path PASTA = Paths.get("saves");
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private final List<String> CENAS_AUTOSAVE = Arrays.asList(
            "Centro da Capital",
            "Bar",
            "Casa de Sillas",
            "Laboratório",
            "Portões do Bairro Nobre (Sem Passe)",
            "Catedral",
            "Castelo Real"
    );

    private Path caminhoSlot(int slot){
        if(slot < 0 || slot > SLOTS){
            throw new IllegalArgumentException("Slot inválido ");
        }
        return PASTA.resolve("save" + slot +".json");
    }

    public void salvar(int slot, Save save) throws IOException{
        Files.createDirectories(PASTA);
        String json = gson.toJson(save);
        Files.writeString(caminhoSlot(slot),json,StandardCharsets.UTF_8);
    }

    public Save carregar(int slot) throws IOException{
        if(!existeSave(slot)){
            return null;
        }
        String json = Files.readString(caminhoSlot(slot),StandardCharsets.UTF_8);
        return gson.fromJson(json,Save.class);
    }

    public boolean existeSave(int slot) {
        return Files.exists(caminhoSlot(slot));
    }

    public void deletar(int slot) throws IOException{
        Files.deleteIfExists(caminhoSlot(slot));
    }

    public int obterProximoSlotDisponivel() {
        for (int i = 1; i <= SaveController.SLOTS; i++) {
            if (!existeSave(i)) {
                return i; // Retorna o primeiro slot livre (1, 2 ou 3)
            }
        }
        return -1; // Retorna -1 se todos os slots estiverem ocupados
    }


    public long obterUltimaModificacao(int slot) {
        try {
            Path path = caminhoSlot(slot);
            if (Files.exists(path)) {
                BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
                return attrs.lastModifiedTime().toMillis();
            }
        } catch (IOException e) {
        }
        return 0;
    }
}