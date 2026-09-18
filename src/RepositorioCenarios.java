import java.util.HashMap;
import java.util.Map;
import java.util.List;
public class RepositorioCenarios {

        private final Map<String, Cenario> cenarios;
        public List<String> falas;
        public RepositorioCenarios() {
            cenarios = new HashMap<>();
            criarCenarios();
            atribuirTexto();
        }
        public void criarCenarios(){
            Cenario casaPlayer = new Cenario("Casa do Jogador", 0);
            cenarios.put("CasaPlayer",casaPlayer);


            //Área 1
            Cenario centro = new Cenario("Centro da Capital", 0);
            cenarios.put("Centro da Capital", centro);

            //Área 2
            Cenario suburbio = new Cenario("Subúrbio",0);
            cenarios.put("Subúrbio",suburbio);

            Cenario bar = new Cenario("Bar",0);
            cenarios.put("Bar",bar);

            Cenario laboratorio = new Cenario("Laboratório",0);
            cenarios.put("Laboratório",laboratorio);

            Cenario casaNPC = new Cenario("Casa de Sillas",0);
            cenarios.put("Casa de Sillas",casaNPC);

            //Área 3
            Cenario bairroNobre = new Cenario("Bairro Nobre",0);
            cenarios.put("Bairro Nobre",bairroNobre);

            Cenario taberna = new Cenario("Taberna", 0);
            cenarios.put("Taberna",taberna);

            Cenario catedral = new Cenario("Catedral",0);
            cenarios.put("Catedral",catedral);

            Cenario mansao = new Cenario("Mansão de Rodrigo",0);
            cenarios.put("Mansão",mansao);
            //Área 4
            Cenario castelo = new Cenario("Castelo Real",0);
            cenarios.put("Castelo",castelo);
        }
        public void atribuirTexto() {
            cenarios.get("Centro da Capital").falas.add(
                    "Ao atravessar os grandes portões e adentrar o centro da Capital, " + "\n" +
                            "o contraste com a antiga glória de Oblitum é brutal. " + "\n" +
                            "As amplas calçadas de pedra agora estão tomadas por uma névoa rala " + "\n" +
                            "e pelo som distante de sinos fúnebres. " + "\n" +
                            "Perto do chafariz central (agora seco e sujo), você é abordado por " + "\n" +
                            "um homem de feições pálidas e roupas desgastadas, mas que carrega " + "\n" +
                            "um olhar surpreendentemente atento." + "\n" +
                            "— Saudações, forasteiro — ele diz, encostando-se na pedra fria. " + "\n" +
                            "— Meu nome é Jeffrey. Não é um bom dia para se visitar a Capital. " + "\n" +
                            "Se planeja sobreviver às próximas noites, precisa entender como a praga dividiu esta cidade.");

            cenarios.get("Subúrbio").falas.add("Ao chegar ao Subúrbio, o cenário é desolador.\n"+
                                                "O ambiente é barulhento, caótico e tomado por um odor terrível de sujeira e doença.\n"+
                                                "Em meio à miséria e ao luto das ruas, há apenas um estabelecimento com as portas abertas:\n"+
                                                "um barzinho humilde e mal iluminado, mas que parece ser o único refúgio seguro considerando o entorno.\n");

            cenarios.get("Bar").falas.add("Ao entrar no bar, você se sente acolhido e, ao olhar em volta, percebe que aquele lugar se tornou um refúgio para as pessoas.\n"+
                    "Alguns afogam as mágoas, outros xingam a nobreza, porém, ao fundo, atrás do barman, você consegue escutar gemidos abafados de dor e sentir um leve cheiro de sangue no ar.\n" +
                    "Ao puxar um banco de madeira rangente e se acomodar no balcão, a figura robusta do barman interrompe o que está fazendo.\n"+
                    "Ele joga um pano encardido sobre o balcão e avalia você de cima a baixo com olhos exaustos, mas afiados.\n"+
                    "Apoiando as mãos calejadas na madeira úmida, ele se inclina levemente em sua direção.\n" +
                    "— O meu nome é Silas — a voz grossa dele soa quase como um rosnado cansado. — Mas a verdadeira questão aqui é a sua identidade.\n"+
                    "Não temos visto rostos novos desde que a praga se espalhou. O que um forasteiro veio procurar na Capital em tempos tão sombrios?\n");

            
        }
}
