import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class RepositorioPersonagens {

    public final Map<String, NPC> personagens;

    public RepositorioPersonagens() {
        personagens = new HashMap<>();
        criarPersonagens();
        atribuirTexto();
    }

    public void criarPersonagens() {
        NPC guia = new NPC("Jeffrey", 0);
        personagens.put("Jeffrey", guia);

        NPC barman = new NPC("Sillas", 0);
        personagens.put("Sillas", barman);

        NPC nobre = new NPC("Rodrigo", 0);
        personagens.put("Rodrigo", nobre);

        NPC pesquisadora = new NPC("Laila", 0);
        personagens.put("Laila", pesquisadora);

        NPC cardeal = new NPC("Toin", 0);
        personagens.put("Toin", cardeal);
        }
    public void atribuirTexto() {
        //Falas do Guia
        personagens.get("Jeffrey").falas.add("A peste varreu a parte baixa sem piedade.\n" +
                                             "O número de mortos sobe a cada hora, e a guarda já desistiu de recolher os corpos.\n" +
                                             "Porém, os sussurros nos becos dizem que há alguém escondido por lá,\n" +
                                             " tentando desesperadamente desenvolver uma cura nas sombras.");

        personagens.get("Jeffrey").falas.add("Os ricos se trancaram atrás de portões de ferro. Quase não há casos de contaminação por lá.\n"+
                                             "Covardemente, todos os membros do alto clero e os grandes estudiosos fugiram para se abrigar no bairro nobre.\n"+
                                             "Dizem que estão revirando textos antigos em busca de uma solução, mas não dividem o conhecimento com o povo.\n ");

        personagens.get("Jeffrey").falas.add("Lá no alto, o Rei lida com palavras, não com a morte. O castelo virou um ninho de discussões políticas diárias.\n"+
                                             "A nobreza exige que a coroa encontre uma cura mágica, enquanto as facções radicais pedem medidas extremas:\n"+
                                             "querem que todos os infectados sejam incinerados vivos para limpar a cidade\n");


    }
    }