import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class RepositorioCenario{

    private final Map<String, Cenario> cenarios;
    public List<String> falas;

    public RepositorioCenario() {
        cenarios = new HashMap<>();
        criarCenarios();
        EscolhaDoCenario();
        atribuirTexto();
    }

    public void criarCenarios(){
        Cenario casaPlayer = new Cenario("Casa do Jogador", 0);
        cenarios.put("Casa do Jogador",casaPlayer);
        //Área 1
        Cenario centro = new Cenario("Centro da Capital", 0);
        cenarios.put("Centro da Capital", centro);

        //Área 2
        Cenario suburbio = new Cenario("Subúrbio",0);
        cenarios.put("Subúrbio",suburbio);
        cenarios.put("Subúrbio - Olhar em volta", new Cenario("Subúrbio - Olhar em volta", 0));
        cenarios.put("Subúrbio - Sucesso Medicina", new Cenario("Subúrbio - Sucesso Medicina", 0));
        cenarios.put("Subúrbio - Sucesso Classe", new Cenario("Subúrbio - Sucesso Classe", 0));
        cenarios.put("Subúrbio - Sucesso Fé", new Cenario("Subúrbio - Sucesso Fé", 0));
        cenarios.put("Subúrbio - Falha", new Cenario("Subúrbio - Falha", 0));

        Cenario bar = new Cenario("Bar",0);
        cenarios.put("Bar",bar);
        cenarios.put("Bar - Sucesso Medicina", new Cenario("Bar - Sucesso Medicina", 0));
        cenarios.put("Bar - Falha Medicina", new Cenario("Bar - Falha Medicina", 0));
        cenarios.put("Bar - Sucesso Classe", new Cenario("Bar - Sucesso Classe", 0));
        cenarios.put("Bar - Falha Classe", new Cenario("Bar - Falha Classe", 0));
        cenarios.put("Bar - Sucesso Fé", new Cenario("Bar - Sucesso Fé", 0));
        cenarios.put("Bar - Falha Fé", new Cenario("Bar - Falha Fé", 0));

        Cenario laboratorio = new Cenario("Laboratório",0);
        cenarios.put("Laboratório Clandestino",laboratorio);
        cenarios.put("Laboratório Clandestino - Pesquisar", new Cenario("Laboratório Clandestino - Pesquisar", 0));
        cenarios.put("Laboratório Clandestino - Entregar Caixa", new Cenario("Laboratório Clandestino - Entregar Caixa", 0));
        cenarios.put("Laboratório Clandestino - Etapa Concluída", new Cenario("Laboratório Clandestino - Etapa Concluída", 0));
        cenarios.put("Laboratório Clandestino - Retorno 5 Dias", new Cenario("Laboratório Clandestino - Retorno 5 Dias", 0));

        Cenario casaNPC = new Cenario("Casa de Sillas",0);
        cenarios.put("Casa do Silas",casaNPC);
        cenarios.put("Casa do Silas - Livros", new Cenario("Casa do Silas - Livros", 0));
        cenarios.put("Casa do Silas - Bolsa", new Cenario("Casa do Silas - Bolsa", 0));
        cenarios.put("Casa do Silas - Caixa", new Cenario("Casa do Silas - Caixa", 0));

        //Área 3
        Cenario bairroNobre = new Cenario("Bairro Nobre",0);
        cenarios.put("Bairro Nobre",bairroNobre);
        cenarios.put("Bairro Nobre - Olhar em volta", new Cenario("Bairro Nobre - Olhar em volta", 0));
        cenarios.put("Portões do Bairro Nobre (Sem Passe)", new Cenario("Portões do Bairro Nobre (Sem Passe)", 0));
        cenarios.put("Portões - Sucesso Carta", new Cenario("Portões - Sucesso Carta", 0));
        cenarios.put("Portões - Sucesso Atributos", new Cenario("Portões - Sucesso Atributos", 0));
        cenarios.put("Portões - Falha", new Cenario("Portões - Falha", 0));
        cenarios.put("Praça - Sucesso Medicina", new Cenario("Praça - Sucesso Medicina", 0));
        cenarios.put("Praça - Sucesso Classe", new Cenario("Praça - Sucesso Classe", 0));
        cenarios.put("Praça - Sucesso Fé", new Cenario("Praça - Sucesso Fé", 0));
        cenarios.put("Praça - Falha", new Cenario("Praça - Falha", 0));

        Cenario taberna = new Cenario("Taberna", 0);
        cenarios.put("Taverna Nobre",taberna); // CORREÇÃO: Chave padronizada
        cenarios.put("Taverna Nobre - Sucesso Medicina", new Cenario("Taverna Nobre - Sucesso Medicina", 0));
        cenarios.put("Taverna Nobre - Sucesso Classe", new Cenario("Taverna Nobre - Sucesso Classe", 0));
        cenarios.put("Taverna Nobre - Sucesso Fé", new Cenario("Taverna Nobre - Sucesso Fé", 0));
        cenarios.put("Taverna Nobre - Falha", new Cenario("Taverna Nobre - Falha", 0));

        Cenario catedral = new Cenario("Catedral",0);
        cenarios.put("Catedral",catedral);
        cenarios.put("Catedral - Opção 1", new Cenario("Catedral - Opção 1", 0));
        cenarios.put("Catedral - Opção 2", new Cenario("Catedral - Opção 2", 0));
        cenarios.put("Catedral - Opção 3", new Cenario("Catedral - Opção 3", 0));

        Cenario mansao = new Cenario("Mansão de Rodrigo",0);
        cenarios.put("Mansão",mansao);
        cenarios.put("Mansão - Opção 1", new Cenario("Mansão - Opção 1", 0));
        cenarios.put("Mansão - Opção 2", new Cenario("Mansão - Opção 2", 0));
        cenarios.put("Mansão - Opção 3", new Cenario("Mansão - Opção 3", 0));

        //Área 4
        Cenario castelo = new Cenario("Castelo Real",0);
        cenarios.put("Castelo Real",castelo); // CORREÇÃO: Chave padronizada
        cenarios.put("Castelo Real - Opção 1", new Cenario("Castelo Real - Opção 1", 0));
        cenarios.put("Castelo Real - Opção 2", new Cenario("Castelo Real - Opção 2", 0));
        cenarios.put("Castelo Real - Opção 3", new Cenario("Castelo Real - Opção 3", 0));

        cenarios.put("Castelo Real - Retorno à Catedral", new Cenario("Castelo Real - Retorno à Catedral", 0));
        cenarios.put("Castelo Real - Encontrar Traidor", new Cenario("Castelo Real - Encontrar Traidor", 0));

        cenarios.put("Retorno à Catedral - Opção 1", new Cenario("Retorno à Catedral - Opção 1", 0));
        cenarios.put("Retorno à Catedral - Opção 2", new Cenario("Retorno à Catedral - Opção 2", 0));
        cenarios.put("Retorno à Catedral - Opção 3", new Cenario("Retorno à Catedral - Opção 3", 0));
        cenarios.put("Retorno à Catedral - Final", new Cenario("Retorno à Catedral - Final", 0));

        cenarios.put("Encontrar Traidor - Consequência 1 e 3", new Cenario("Encontrar Traidor - Consequência 1 e 3", 0));
        cenarios.put("Encontrar Traidor - Consequência 2", new Cenario("Encontrar Traidor - Consequência 2", 0));

        cenarios.put("Game Over - O Abraço de Oblitum", new Cenario("Game Over - O Abraço de Oblitum", 0));
    }

    public Cenario getCenario(String chave) {
        return cenarios.get(chave);
    }

    public void EscolhaDoCenario(){
        cenarios.get("Casa do Jogador").escolha = ("1-Ir para a Capital\n");

        cenarios.get("Centro da Capital").escolha = ("1-Ir para a Favela\n" +
                "2-Ir para o Bairro Nobre\n" +
                "3-Ir para o Castelo Real (Necessário permissão)\n" +
                "4-[Sair do Diálogo] Agradeço pelas informações, Jeffrey. Oblitum mudou muito. Preciso decidir o meu caminho a partir daqui.\n");

        cenarios.get("Subúrbio").escolha = ("1-Entrar no bar\n" +
                "2-Ir para o laboratório (Bloqueado até atender aos requisitos)\n" +
                "3-Ir para casa do Sillas (Bloqueado por falta de afinidade)\n" +
                "4-Voltar ao Centro da capital\n" +
                "5-Olhar em volta\n");

        cenarios.get("Subúrbio - Olhar em volta").escolha = ("1-Tentar ajudá-lo com seus conhecimentos médicos. [Requisito: Medicina 2+]\n" +
                "2-Tentar acalmar a situação e usar a lógica para chegar a uma solução. [Requisito: Classe 2+]\n" +
                "3-Aproximar-se do grupo afirmando que a graça do Senhor irá curá-lo. [Requisito: Fé 2+]\n" +
                "4-Ignorar e ir embora.\n");

        cenarios.get("Bar").escolha = ("1-[Requisito: Medicina 2+] \"Onde há praga, há trabalho para mim. Inclusive, compreendo de ferimentos e escutei alguns gemidos de dor vindo dos fundos. Talvez eu possa ajudar em algo.\"\n" +
                "2-[Requisito: Classe 2+] (Você saca seu caderno de anotações e o apresenta a ele) \"Estou fazendo uma pesquisa para desenvolver uma cura para a peste babilônica. Ouvi que tem um laboratório nas favelas fazendo o mesmo e procuro por ele.\"\n" +
                "3-[Requisito: Fé 2+] \"Sou um apóstolo de Deus, e vim salvá-los dos males que os atormentam. Porém, fui instruído a purificar somente os justos de coração, portanto preciso que você me ajude a juntar informações.\"\n" +
                "4-Sair do Bar e voltar ao Subúrbio\n");

        cenarios.get("Casa do Silas").escolha = ("1-Ler os livros e grimórios na estante.\n" +
                "2-Pegar a bolsa gorda e pesada sobre a mesa.\n" +
                "3-Vasculhar uma caixa misteriosa de madeira escura no canto do quarto.\n" +
                "4-Voltar ao Subúrbio\n");

        cenarios.get("Laboratório Clandestino").escolha = ("1-Passar 1 Dia pesquisando. [-10 Moedas de Ouro]\n" +
                "2-Entregar a Caixa Misteriosa (Se adquirida na casa de Silas).\n" +
                "3-Voltar ao Subúrbio.\n");

        cenarios.get("Laboratório Clandestino - Etapa Concluída").escolha = ("1-Ir para o Bairro Nobre\n");

        cenarios.get("Portões do Bairro Nobre (Sem Passe)").escolha = (
                "1-[Requisito: Medicina 2+] \"Sou um profissional de saúde. A doença não escolhe sangue azul ou plebeu. Minhas habilidades médicas serão muito úteis se a praga ultrapassar esses portões.\"\n" +
                        "2-[Requisito: Classe 2+] \"Abaixe essa lança antes que eu mande cortarem suas mãos. Sou um membro da alta sociedade prestando serviços à Capital e você está sendo terrivelmente insolente com suas palavras.\"\n" +
                        "3-[Requisito: Fé 2+] \"Cuide de sua língua diante de um representante de Deus. 'Dominus vobiscum'... Sou um membro do clero autorizado a transitar livremente.\"\n" +
                        "4-[Requisito: Possuir a Carta de Laila] Mostrar o envelope lacrado em cera vermelha em silêncio.\n" +
                        "5-Voltar para o Centro da Capital\n");

        cenarios.get("Bairro Nobre").escolha = (
                "1-Ir à Taverna Nobre (Um bar requintado onde os ricos discutem política).\n" +
                        "2-Ir para a Mansão (Requer a carta de recomendação de Laila).\n" +
                        "3-Ir para a Catedral (O refúgio dourado do alto clero).\n" +
                        "4-Olhar em volta\n" +
                        "5-Voltar para o Centro da Capital\n");

        cenarios.get("Bairro Nobre - Olhar em volta").escolha = (
                "1-[Requisito: Medicina 2+] Examinar e tratar a ferida com precisão e cuidado.\n" +
                        "2-[Requisito: Classe 2+] Tentar dialogar calmamente, ensinando-o a se portar como um nobre diante da dor.\n" +
                        "3-[Requisito: Fé 2+] Aproximar-se, fazer o sinal da cruz e recitar orações em latim para confortá-lo.\n" +
                        "4-Ignorar a criança e voltar.\n");

        cenarios.get("Taverna Nobre").escolha = (
                "1-[Requisito: Medicina 2+] Ajudar um senhor elegante ao fundo da sala, que tosse de forma abafada e silenciosa em um lenço de tecido fino.\n" +
                        "2-[Requisito: Classe 2+] Auxiliar um jovem nobre que transpira de nervosismo enquanto encara um grande livro aberto à sua frente.\n" +
                        "3-[Requisito: Fé 2+] Consolar uma senhora isolada no canto do bar, que chora compulsivamente enquanto bebe uma taça de vinho sozinha.\n" +
                        "4-Sair da Taverna Nobre.\n");

        cenarios.get("Catedral").escolha = (
                "1-\"Sinto que minha fé precisa ser fortalecida. Gostaria que me ensinasse os textos e as orações sagradas em Latim.\" [-30 Moedas de Ouro]\n" +
                        "2-\"Preciso de uma audiência com o Duque Rodrigo. Sei que a Igreja tem influência para me garantir essa permissão.\" [-50 Moedas de Ouro]\n" +
                        "3-\"Com tanta morte lá fora, é no mínimo curioso ver o clero ostentando tanto ouro. A salvação agora tem um preço fixo?\"\n" +
                        "4-Sair da Catedral e voltar ao Bairro Nobre.\n");

        cenarios.get("Mansão").escolha = (
                "1-\"Trago uma mensagem confidencial da sua antiga tutora, Laila.\" (Entregar o envelope a Zuri).\n" +
                        "2-\"Trago assuntos vitais para a Coroa, mas fui avisado de que a corte é um ninho de cobras. Senhora Zuri, com toda a sua elegância e sabedoria, aceitaria me ensinar a etiqueta e a lábia da alta nobreza antes de eu me encontrar com o Rei?\" [-15 Moedas de Ouro]\n" +
                        "3-\"Tenho pressa e assuntos urgentes com a Coroa. Apenas me dê um passe para o castelo e sairei do seu caminho.\"\n");

        cenarios.get("Castelo Real").escolha = (
                "1-\"Majestade, trago a salvação de Oblitum. Aqui está a cura definitiva desenvolvida nas sombras. Entrego-a em suas mãos.\" (Entregar a cura e aceitar a recompensa)\n" +
                        "2-[Requisito: Fé 3+ ou Classe 3+] \"Esta é apenas a semente do milagre, Majestade. Para multiplicá-la, exijo um decreto real para confiscar o ouro que a Igreja esconde. A Catedral financiará a salvação do povo.\"\n" +
                        "3-[Requisito: Medicina 3+ ou Classe 3+] \"A cura está aqui, Majestade. Mas a Peste Babilônica não foi um castigo divino ou uma fatalidade da natureza. Ela foi fabricada. Exijo a autoridade da sua guarda para prender o traidor que envenenou Oblitum.\"\n");

        cenarios.get("Castelo Real - Retorno à Catedral").escolha = (
                "1-[Requisito: Classe 4+] Erguer o Selo da Inquisição Real. \"Eu não falo mais como forasteiro, falo com a voz do Rei. O ouro do dízimo salvará o povo hoje, ou amanhã a Coroa destruirá esta Catedral tijolo por tijolo.\"\n" +
                        "2-[Requisito: Fé 4+] Voltar-se para os guardas templários. \"O dever de vocês é proteger os justos, não os tesouros de um homem ganancioso! Ajoelhem-se perante o milagre que Deus me concedeu e deixem-nos passar!\"\n" +
                        "3-Ordenar que a Guarda Real ataque sem negociar. [Ataque Direto]\n");

        cenarios.get("Castelo Real - Encontrar Traidor").escolha = (
                "1-[Requisito: Medicina 3+] \"Um médico cura a doença, não mata o paciente. Você violou todas as leis da vida e responderá por isso.\" (Prender o Duque).\n" +
                        "2-[Requisito: Classe 3+] (Aproximar-se dele e falar baixo). \"Um plano brilhante, Duque. Mas você perdeu. Se eu entregar a cura ao Rei, você morre. Mas se você transferir suas terras e seu poder político para mim, eu digo ao Rei que o traidor era o Cardeal.\" (Chantagem).\n" +
                        "3-[Deixar Zuri decidir] \"Ele confiou na senhora, Conselheira Zuri. O destino dele está em suas mãos.\"\n");
    }

    public void atribuirTexto() {
        // CASA DO PROTAGONISTA
        cenarios.get("Casa do Jogador").falas.add(
                "\"Saudações, "  + ".\n" +
                        "A Peste Babilônica está ceifando a vida do nosso povo, mas o seu maior estrago é outro: " +
                        "ela está roubando a nossa capacidade de sonhar com dias melhores.\n" +
                        "Escrevo porque confio a você a tarefa de descobrir os segredos por trás desse mal repentino. " +
                        "Precisamos devolver a este reino a liberdade de sonhar e a força para lutar.\n" +
                        "Se estiver disposto a enfrentar o que está por vir, venha para a Capital.\n" +
                        "— Um amigo nas sombras.\"\n");

        // CAPITAL
        cenarios.get("Centro da Capital").falas.add(
                "Ao atravessar os grandes portões e adentrar o centro da Capital, o contraste com a antiga glória de Oblitum é brutal.\n" +
                        "As amplas calçadas de pedra agora estão tomadas por uma névoa rala e pelo som distante de sinos fúnebres.\n" +
                        "Perto do chafariz central (agora seco e sujo), você é abordado por um homem de feições pálidas e roupas desgastadas, mas que carrega um olhar surpreendentemente atento.\n" +
                        "— Saudações, forasteiro — ele diz, encostando-se na pedra fria. — Meu nome é Jeffrey. Não é um bom dia para se visitar a Capital.\n" +
                        "Se planeja sobreviver às próximas noites, precisa entender como a praga dividiu esta cidade.\n\n" +
                        "(Jeffrey se aproxima, baixando o tom de voz, e compartilha as instruções de como as coisas funcionam atualmente):\n\n" +
                        "Os Subúrbios (A Zona de Contágio): \"A peste varreu a parte baixa sem piedade. O número de mortos sobe a cada hora, e a guarda já desistiu de recolher os corpos.\n" +
                        "Porém, os sussurros nos becos dizem que há alguém escondido por lá, tentando desesperadamente desenvolver uma cura nas sombras.\"\n\n" +
                        "O Bairro Nobre (O Refúgio): \"Os ricos se trancaram atrás de portões de ferro. Quase não há casos de contaminação por lá.\n" +
                        "Covardemente, todos os membros do alto clero e os grandes estudiosos fugiram para se abrigar no bairro nobre.\n" +
                        "Dizem que estão revirando textos antigos em busca de uma solução, mas não dividem o conhecimento com o povo.\"\n\n" +
                        "O Castelo Real (O Trono em Crise): \"Lá no alto, o Rei lida com palavras, não com a morte. O castelo virou um ninho de discussões políticas diárias.\n" +
                        "A nobreza exige que a coroa encontre uma cura mágica, enquanto as facções radicais pedem medidas extremas: querem que todos os infectados sejam incinerados vivos para limpar a cidade.\"\n");


        // SUBÚRBIO
        cenarios.get("Subúrbio").falas.add(
                "Ao chegar ao Subúrbio, o cenário é desolador. O ambiente é barulhento, caótico e tomado por odor terrível de sujeira e doença.\n" +
                        "Em meio à miséria e ao luto das ruas, há apenas um estabelecimento com as portas abertas:\n" +
                        "um barzinho humilde e mal iluminado, mas que parece ser o único refúgio seguro considerando o entorno.\n");

        cenarios.get("Subúrbio - Olhar em volta").falas.add(
                "Observando o caos ao redor, você nota um grupo de pessoas em pânico no meio da rua lamacenta.\n" +
                        "Ao se aproximar, percebe que se trata de uma família reunida ao redor do filho mais novo.\n" +
                        "O garoto acabou de desmaiar, ardendo em febre. Acreditando ser o início da peste babilônica,\n" +
                        "os pais gritam por socorro, atraindo olhares desconfiados dos vizinhos.\n");

        cenarios.get("Subúrbio - Sucesso Medicina").falas.add(
                "[Sucesso]: Você após analisar a criança, percebe que sua doença não se trata da peste e sim de uma febre comum.\n" +
                        "Puxa alguns medicamentos e entrega à família. Todos no ambiente se acalmaram e, muito felizes com a melhora de sua criança, lhe entregaram 10 moedas de ouro.\n");

        cenarios.get("Subúrbio - Sucesso Classe").falas.add(
                "[Sucesso]: Você assume o controle da situação com voz firme, ordenando que deem espaço.\n" +
                        "Ao observar a dinâmica, nota que o irmão mais velho ao fundo segura anotações médicas. Você o reconhece como um estudante e o incita a debater os sintomas.\n" +
                        "Juntos, chegam à conclusão lógica de que é apenas uma febre comum e conseguem administrar o remédio correto.\n" +
                        "Impressionados com sua autoridade, eles lhe pagam 10 moedas de ouro.\n");

        cenarios.get("Subúrbio - Sucesso Fé").falas.add(
                "[Sucesso]: Você se ajoelha com postura solene, entoando orações em latim para acalmar a família.\n" +
                        "Enquanto atrai a atenção de todos erguendo seu crucifixo, você usa a outra mão para, furtivamente, alimentar o menino com uma erva curativa.\n" +
                        "Quando o semblante do garoto volta ao normal, a família cai de joelhos, louvando o milagre.\n" +
                        "Acreditando tratar-se de intervenção divina, eles lhe ofertam 15 moedas de ouro.\n");

        cenarios.get("Subúrbio - Falha").falas.add(
                "[Falha]: Você tenta intervir, mas hesita e demonstra insegurança. O estado do garoto parece piorar.\n" +
                        "Acreditando que você é um charlatão ou, pior, um amaldiçoado tentando espalhar a peste para a criança, o medo da família se transforma em ódio.\n" +
                        "Você é brutalmente espancado pela multidão em pânico antes de conseguir fugir. [-1 Vida]\n");

        // BAR
        cenarios.get("Bar").falas.add(
                "Ao entrar no bar, você se sente acolhido e, ao olhar em volta, percebe que aquele lugar se tornou um refúgio para as pessoas.\n" +
                        "Alguns afogam as mágoas, outros xingam a nobreza, porém, ao fundo, atrás do barman, você consegue escutar gemidos abafados de dor e sentir um leve cheiro de sangue no ar.\n" +
                        "Ao puxar um banco de madeira rangente e se acomodar no balcão, a figura robusta do barman interrompe o que está fazendo.\n" +
                        "Ele joga um pano encardido sobre o balcão e avalia você de cima a baixo com olhos exaustos, mas afiados.\n" +
                        "Apoiando as mãos calejadas na madeira úmida, ele se inclina levemente em sua direção.\n" +
                        "— O meu nome é Silas — a voz grossa dele soa quase como um rosnado cansado. — Mas a verdadeira questão aqui é a sua identidade.\n" +
                        "Não temos visto rostos novos desde que a praga se espalhou. O que um forasteiro veio procurar na Capital em tempos tão sombrios?\n");

        cenarios.get("Bar - Sucesso Medicina").falas.add(
                "[Sucesso]: Silas o leva aos fundos, onde você descobre que os gemidos vêm da filhinha dele, gravemente doente.\n" +
                        "Ao analisá-la, percebe que os sintomas são idênticos aos da peste. Por sorte, você carrega uma amostra experimental de cura.\n" +
                        "Ao fazer a menina beber, o semblante dela melhora quase instantaneamente. Sabendo que é uma solução temporária, o barman chora compulsivamente e o abraça.\n" +
                        "Ele lhe entrega uma Chave e um Mapa para a antiga casa dele, dizendo: \"Vá pegar os materiais e medicamentos que escondi lá. Quando voltar, terei todas as informações que precisar sobre o laboratório.\" [+1 Amizade com Silas]\n");

        cenarios.get("Bar - Falha Medicina").falas.add(
                "[Falha]: Silas o leva aos fundos, mas ao analisar a criança, você percebe que a doença está avançada e seu experimento ainda não está pronto para consumo humano — administrá-lo agora a mataria.\n" +
                        "Sem ter como ajudar, você assiste a menina piorar e começar a tossir sangue.\n" +
                        "Silas, consumido pelo desespero e pela raiva, grita mandando você ir embora, já que sua presença ali não serve para nada.\n");

        cenarios.get("Bar - Sucesso Classe").falas.add(
                "[Sucesso]: O barman analisa suas anotações e sua postura. Ele revela ser um ex-estudante de medicina e confessa que aquelas deduções escritas no caderno são as mais promissoras que ele viu em semanas.\n" +
                        "Vendo o seu potencial e acreditando na sua pesquisa, ele abaixa a voz e lhe entrega um mapa improvisado, detalhando a localização exata e as senhas para entrar no laboratório clandestino sem ser morto pelos guardas da favela.\n");

        cenarios.get("Bar - Falha Classe").falas.add(
                "[Falha]: Silas folheia o caderno, mas logo percebe as anotações ralas e a sua forma rude de falar, que não condiz com a de um verdadeiro estudioso.\n" +
                        "Ele joga o caderno de volta no balcão e revela que já foi estudante de medicina antes de abrir o bar para ajudar os necessitados.\n" +
                        "Ele reconhece um charlatão quando vê um e se recusa a dar qualquer informação.\n");

        cenarios.get("Bar - Sucesso Fé").falas.add(
                "[Sucesso]: Você diz que vai orar para saber se Silas é um homem digno. Enquanto finge estar em transe, você escuta os sussurros dos clientes ao redor elogiando o barman e lamentando que a filha dele tenha sido contaminada.\n" +
                        "Você abre os olhos e declara que Deus lhe revelou o sofrimento da criança, ordenando que Silas seja ajudado.\n" +
                        "Abalado por você saber o segredo dele, o barman se prostra, acredita na sua divindade e entrega imediatamente o mapa com a localização juntamente da senha necessária para acessar o laboratório em troca de suas orações.\n");

        cenarios.get("Bar - Falha Fé").falas.add(
                "[Falha]: Silas olha para você com aversão profunda. Em tempos de praga, ele já viu fanáticos demais lucrando com o medo alheio.\n" +
                        "Ele não acredita em uma única palavra sua, cospe no chão ao lado das suas botas e manda você sair da taverna imediatamente caso não vá comprar uma bebida. [-1 Amizade com Silas]\n");

        // CASA DO SILAS
        cenarios.get("Casa do Silas").falas.add(
                "Ao usar a chave entregue pelo barman, a fechadura enferrujada cede com um estalo seco.\n" +
                        "O interior da casa abandonada cheira a mofo e poeira acumulada, iluminado apenas por finos feixes de luz que escapam pelas tábuas nas janelas.\n" +
                        "O silêncio do lugar contrasta com o caos da favela lá fora.\n" +
                        "No fundo do cômodo principal, duas coisas chamam imediatamente a sua atenção.\n" +
                        "No entanto, caminhar de volta pelos becos perigosos carregando muito volume fará de você um alvo fácil para os saqueadores e desesperados.\n" +
                        "Você percebe que terá que escolher apenas um dos espólios.\n");

        cenarios.get("Casa do Silas - Livros").falas.add(
                "Você ignora os bens materiais e passa os próximos minutos folheando freneticamente as anotações médicas de Silas e velhos tratados de anatomia.\n" +
                        "O conhecimento contido ali expande sua compreensão sobre as mutações da peste e refina seus modos de se comunicar com outros acadêmicos.\n" +
                        "[Recompensa: Você ganha +1 ponto em Medicina e +1 ponto em Classe]\n");

        cenarios.get("Casa do Silas - Bolsa").falas.add(
                "Sobrevivência exige capital. Você agarra a bolsa de lona grossa. O som inconfundível de moedas tilintando preenche o silêncio.\n" +
                        "Com esse valor, você terá poder de barganha suficiente para comprar favores de qualquer pessoa na Capital.\n" +
                        "[Recompensa: Você ganha 50 moedas de ouro]\n");

        cenarios.get("Casa do Silas - Caixa").falas.add(
                "Atraído pela caixa esculpida com símbolos estranhos, você quebra o fecho de metal.\n" +
                        "Dentro, repousa um frasco de vidro contendo um reagente raríssimo (ou um extrato botânico extinto), conservado em perfeitas condições.\n" +
                        "Sua mente científica deduz imediatamente o valor inestimável daquilo.\n" +
                        "[Recompensa: Você adquire o Catalisador Perfeito (Item Chave)]\n" +
                        "Ao levar este item para o laboratório clandestino, ele avançará drasticamente a pesquisa, deixando a cura quase pronta.\n" +
                        "Restará apenas conseguir a permissão (ou força política) para realizar os testes finais e distribuir à população.\n");

        // LABORATÓRIO CLANDESTINO
        cenarios.get("Laboratório Clandestino").falas.add(
                "Você continua avançando cada vez mais fundo nas favelas. A quantidade de cadáveres amontoados aumenta a cada esquina, até que o mapa o guia para um beco mais escuro e estreito que o normal.\n" +
                        "Há apenas uma pequena e solitária luz no fundo. Você sente um calafrio na espinha a cada passo; a respiração pesa, trazendo uma ansiedade sufocante.\n" +
                        "Ao chegar, uma lamparina a óleo tremeluz acima de uma porta de madeira robusta e reforçada com ferro.\n" +
                        "Antes mesmo de você bater, uma pequena escotilha se abre na madeira e olhos desconfiados o encaram do outro lado.\n" +
                        "— Qual a senha? — uma voz rouca exige.\n" +
                        "Você lê a frase anotada por Silas: \"A igreja é uma farsa.\"\n" +
                        "Após alguns segundos de um silêncio tenso, o barulho de diversas trancas e ferrolhos pesados ecoa pelo beco.\n" +
                        "A porta se abre, e uma senhora de cabelos grisalhos e desgrenhados faz um gesto para você entrar.\n" +
                        "Assim que a porta se fecha às suas costas, um cheiro fortíssimo — uma mistura de álcool, ervas amargas e matéria orgânica em decomposição — atinge seu rosto, deixando-o atordoado.\n" +
                        "A pesquisadora ri da sua reação.\n" +
                        "— É melhor ir se acostumando com o cheiro se quiser trabalhar aqui. — Ela o avalia da cabeça aos pés, parando os olhos nos seus pertences. — O que traz alguém como você a este buraco? Pelas roupas, parece entender alguma coisa de medicina...\n" +
                        "Antes que você possa se apresentar a mulher dá de ombros e se vira. Ela se apresenta brevemente como Laila, a última alquimista e pesquisadora focada na praga. Ela deixa as regras do local bem claras:\n" +
                        "— Nada nesta vida é de graça, muito menos a ciência. Se quiser continuar aqui e usar minhas ferramentas, terá que pagar 10 moedas de ouro por dia para bancar a sua parte na compra de suprimentos e cadáveres frescos. Atendendo a essa condição, prevejo que a cura definitiva estará pronta em 5 dias.\n" +
                        "(O jogador deve escolher como gastar seu tempo e recursos. São necessários 5 dias de pesquisa para concluir a etapa).\n");

        cenarios.get("Laboratório Clandestino - Pesquisar").falas.add(
                "Você se dedica a auxiliar nas experimentações ao longo do dia, suportando o odor terrível.\n" +
                        "[Custo/Recompensa: -10 Moedas de Ouro, +1 Ponto em Medicina, -1 Dia Restante, +1 Amizade com Laila]\n");

        cenarios.get("Laboratório Clandestino - Entregar Caixa").falas.add(
                "Você entrega o catalisador perfeito a Laila. Os olhos da pesquisadora brilham ao ver a pureza do reagente. Isso avança a pesquisa drasticamente.\n" +
                        "[Custo/Recompensa: -3 Dias Restantes na contagem da cura. Isso salva tempo e 30 moedas de ouro do jogador. +3 Amizade com Laila]\n");

        // PESQUISA CONCLUÍDA
        cenarios.get("Laboratório Clandestino - Etapa Concluída").falas.add(
                "— O processo de decantação levará 5 dias para ficar estável — diz Laila, tossindo levemente. — Não fique aqui respirando esta fumaça tóxica.\n" +
                        "Vá para o Bairro Nobre e procure a Conselheira Zuri na mansão do Duque. Fui tutora dela no passado.\n" +
                        "Ela caminha até uma gaveta trancada e retira um envelope lacrado em cera vermelha.\n" +
                        "— Entregue isso a ela. Zuri conseguirá o passe para o Rei. Quando conseguir, volte aqui.\n" +
                        "(O jogador deve explorar o Bairro Nobre. Após conseguir o passe na Mansão, retorne ao laboratório).\n");

        // APÓS CONSEGUIR O PASSE
        cenarios.get("Laboratório Clandestino - Retorno 5 Dias").falas.add(
                "Ao retornar após os 5 dias, a fumaça abaixa. Laila segura um frasco maior contra a luz.\n" +
                        "— A cura está feita. Testei em amostras de sangue infectado nos fundos do laboratório e a purificação celular é imediata.\n" +
                        "Há líquido suficiente aqui para uma demonstração à corte e para iniciar a replicação em massa. O destino de Oblitum está com você.\n");

        // OS PORTÕES DO BAIRRO NOBRE (SEM PASSE)
        cenarios.get("Portões do Bairro Nobre (Sem Passe)").falas.add(
                "Ao deixar as favelas para trás, o ar começa a ficar menos espesso. O caminho de terra e lama dá lugar a ruas pavimentadas e limpas, até que seu avanço é interrompido.\n" +
                        "Diante de você ergue-se um imponente portão de ferro, protegido por uma barricada pesada e guardas vestindo armaduras polidas que ostentam o brasão da Coroa.\n" +
                        "Assim que você se aproxima, as lanças se cruzam bloqueando o caminho.\n" +
                        "— Alto lá! Identifique-se! — exige o capitão da guarda, claramente irritado ao ver suas roupas empoeiradas. — Esta é uma área restrita. O Bairro Nobre não é lugar para forasteiros ou vagabundos. Dê meia-volta.\n");

        cenarios.get("Portões - Sucesso Carta").falas.add(
                "[Sucesso]: O capitão da guarda arregala os olhos ao reconhecer o antigo selo de cera. \"Um assunto confidencial da Conselheira Zuri... Perdoe a minha insolência\".\n" +
                        "Ele abre caminho imediatamente, entregando-lhe um Passe de Livre Trânsito.\n");

        cenarios.get("Portões - Sucesso Atributos").falas.add(
                "[Sucesso]: O guarda engole seco, recuando as lanças. Seja por respeito à sua utilidade, medo de sua autoridade ou temor divino, ele pede desculpas e entrega a você um Passe de Livre Trânsito cunhado em prata.\n" +
                        "Agora você pode entrar e sair do Bairro Nobre quando quiser.\n");

        cenarios.get("Portões - Falha").falas.add(
                "[Falha]: O guarda ri da sua tentativa patética. Ele o empurra com o cabo da lança e ameaça prendê-lo se não sumir dali.\n" +
                        "Você é barrado e precisa encontrar outra forma de conseguir o passe.\n");

        // BAIRRO NOBRE (COM PASSE)
        cenarios.get("Bairro Nobre").falas.add(
                "Ao cruzar os portões de ferro, a realidade muda de forma drástica e perturbadora. É como se a Peste Babilônica não passasse de um mito distante.\n" +
                        "As ruas exalam perfume de flores e incenso, há pessoas rindo e caminhando com roupas de seda, e músicos tocam suavemente nas sacadas luxuosas.\n" +
                        "A elite vive suas vidas normalmente, alheia à montanha de cadáveres do lado de fora.\n");

        // OLHAR EM VOLTA (PRAÇA DO BAIRRO NOBRE)
        cenarios.get("Bairro Nobre - Olhar em volta").falas.add(
                "Ao olhar em volta pelos jardins perfeitamente podados da praça, você nota uma criança choramingando sozinha.\n" +
                        "Pelas roupas de veludo e bordados em ouro, ele claramente é filho de alguém muito importante.\n" +
                        "Ao se aproximar, percebe que ele tropeçou enquanto brincava e fez um pequeno corte no joelho — um ferimento inofensivo, mas que para o garoto mimado parece o fim do mundo.\n");

        cenarios.get("Praça - Sucesso Medicina").falas.add(
                "[Sucesso]: Você limpa o ferimento rapidamente com um unguento, aliviando a dor. A criança para de chorar e agradece, impressionada com sua habilidade.\n" +
                        "Ele se apresenta como filho do Duque Rodrigo, o maior estudioso e conselheiro da Capital, e promete contar ao pai sobre o seu heroísmo.\n" +
                        "O garoto lhe entrega 15 moedas de ouro que carregava nos bolsos antes de ir embora. [+1 Amizade com o Duque Rodrigo]\n");

        cenarios.get("Praça - Sucesso Classe").falas.add(
                "[Sucesso]: Você fala com ele de igual para igual, com eloquência, ensinando que a dor forja líderes. O garoto seca as lágrimas, recompõe a postura e diz que o seu jeito de falar lembra muito o do pai dele.\n" +
                        "Ele se apresenta como o filho do Duque Rodrigo, avisa que fará questão de falar sobre você no jantar, e lhe entrega 15 moedas de ouro em agradecimento. [+1 Amizade com o Duque Rodrigo]\n");

        cenarios.get("Praça - Sucesso Fé").falas.add(
                "[Sucesso]: Suas orações e a presença calmante da Igreja fazem o garoto esquecer a dor. Ele presta respeito, maravilhado, e afirma que Deus deve tê-lo enviado.\n" +
                        "Apresenta-se como filho do Duque Rodrigo e garante que o pai, um estudioso prestigiado, saberá da sua benevolência divina.\n" +
                        "Deslumbrado, ele doa 15 moedas de ouro como dízimo pela sua ajuda. [+1 Amizade com o Duque Rodrigo]\n");

        cenarios.get("Praça - Falha").falas.add(
                "[Falha]: Você se aproxima de forma muito brusca ou assustadora. Acostumado a ser bajulado, o garoto nobre se assusta com a sua presença,\n" +
                        "começa a gritar por socorro e sai correndo para casa, deixando você de mãos vazias.\n");

        // TAVERNA NOBRE
        cenarios.get("Taverna Nobre").falas.add(
                "Ao observar o ambiente luxuoso da taverna com mais atenção, o contraste se torna evidente. O ouro e a seda não escondem a vulnerabilidade humana.\n" +
                        "Você percebe que, mesmo cercadas de fartura, há pessoas precisando de ajuda, cada uma imersa em seus próprios tormentos e dilemas silenciosos.\n");

        cenarios.get("Taverna Nobre - Sucesso Medicina").falas.add(
                "[Sucesso]: Ao se aproximar, seus olhos treinados e sua audição diagnosticam rapidamente a causa da tosse, descartando a praga.\n" +
                        "Usando seus conhecimentos, você o convence a ingerir uma mistura de ervas calmantes que carrega consigo. A crise de tosse cessa quase imediatamente.\n" +
                        "Respirando aliviado e grato pela sua discrição médica, o senhor lhe entrega 15 moedas de ouro.\n");

        cenarios.get("Taverna Nobre - Sucesso Classe").falas.add(
                "[Sucesso]: Você se debruça sobre a mesa e escuta o garoto resmungando. Imediatamente, reconhece o texto como um antigo tratado médico.\n" +
                        "Com uma postura impecável, você lança um questionamento retórico. A conversa evolui para um debate intelectual brilhante, e sua argumentação resolve a dúvida acadêmica que o atormentava.\n" +
                        "Impressionado com a sua erudição, o jovem lhe entrega 10 moedas de ouro como agradecimento.\n");

        cenarios.get("Taverna Nobre - Sucesso Fé").falas.add(
                "[Sucesso]: Você se aproxima e oferece conforto. A senhora desabafa que perdeu o marido e o filho para a peste e que a quarentena a impediu de ir à Igreja para orar por suas almas.\n" +
                        "Com compaixão genuína, você se ajoelha ao lado dela ali mesmo e começa a recitar preces profundas e absolvições em latim.\n" +
                        "Encontrando paz nas suas palavras divinas, ela lhe agradece imensamente e lhe entrega 20 moedas de ouro.\n");

        cenarios.get("Taverna Nobre - Falha").falas.add(
                "[Falha]: Ao se aproximar e tentar interagir, você hesita. Rapidamente fica evidente que lhe faltam o conhecimento e o traquejo social necessários para lidar com a situação.\n" +
                        "A pessoa percebe a sua incapacidade, rejeita a sua abordagem de forma seca e exige ser deixada em paz. Você retorna ao balcão de mãos vazias.\n");

        // CATEDRAL
        cenarios.get("Catedral").falas.add(
                "Ao empurrar as pesadas portas de carvalho esculpido, o som do caos e do sofrimento lá fora desaparece, substituído pelo eco de cânticos distantes.\n" +
                        "A Catedral é um absurdo de opulência: vitrais coloridos filtram a luz do sol, iluminando estátuas de anjos banhadas a ouro e altares cobertos por sedas e veludo vermelho.\n" +
                        "O cheiro de incenso caro é tão forte que chega a enjoar.\n" +
                        "No centro do salão, sentado em uma cadeira acolchoada que mais parece um trono, está o Cardeal.\n" +
                        "Em total contradição com qualquer voto de humildade, ele veste tecidos finíssimos e ostenta uma quantidade obscena de riqueza:\n" +
                        "anéis cravejados de joias em quase todos os dedos, pesados colares que repousam sobre seu peito e uma cruz maciça de ouro puro que reflete a luz das velas.\n" +
                        "Ele o observa se aproximar com um olhar de puro desdém, girando distraidamente um de seus anéis.\n" +
                        "— A casa do Senhor é um refúgio para os de espírito elevado, forasteiro. Mas a elevação exige sacrifícios — diz o Cardeal, com uma voz arrastada e cheia de soberba.\n" +
                        "— O que o traz à minha presença? Espero que não tenha vindo mendigar milagres, pois a graça divina é um privilégio, não caridade.\n");

        cenarios.get("Catedral - Opção 1").falas.add(
                "O Cardeal abre um sorriso ganancioso e seus olhos brilham ao ver as moedas. Ele recolhe o ouro rapidamente e, durante as horas seguintes, compartilha antigas escrituras,\n" +
                        "ensinando-lhe a pronúncia correta de orações complexas em Latim. Ele deixa claro que o perdão divino é exclusivo para quem pode pagar o dízimo.\n" +
                        "[-30 Moedas de Ouro, +1 Ponto em Fé]\n");

        cenarios.get("Catedral - Opção 2").falas.add(
                "O Cardeal pesa a bolsa de moedas na mão, visivelmente satisfeito com o peso do ouro. Sem hesitar, ele assina um pergaminho, derrama cera quente e o carimba com o seu pesado anel de sinete, entregando-o a você com desdém.\n" +
                        "— O Duque Rodrigo é um homem recluso, mas ele não ousa recusar um convidado que carrega a bênção, e o selo, do alto clero.\n" +
                        "[-50 Moedas de Ouro, Recebe Permissão de Entrada para a Mansão do Duque Rodrigo]\n");

        cenarios.get("Catedral - Opção 3").falas.add(
                "O rosto do Cardeal se contorce em fúria. — Insolente! Este ouro é a manifestação terrena da glória do Senhor!\n" +
                        "Como ousa questionar a vontade divina com essa sua língua imunda e plebeia?\n" +
                        "Ele ergue a mão, e dois guardas templários fortemente armados surgem das sombras, expulsando-o violentamente da Catedral aos empurrões e o jogando de volta nas ruas do Bairro Nobre. [-1 Vida]\n");

        // MANSÃO DO DUQUE RODRIGO
        cenarios.get("Mansão").falas.add(
                "Ao entrar na mansão do Duque Rodrigo, você se depara com um ambiente que transpira intelecto e poder.\n" +
                        "As paredes são forradas por estantes de mogno que tocam o teto, repletas de mapas antigos e tratados diplomáticos.\n" +
                        "No centro da sala, o Duque analisa alguns pergaminhos, mas quem realmente domina o ambiente é a mulher ao lado dele.\n" +
                        "A Conselheira Zuri é uma mulher preta de postura imponente e elegância absoluta.\n" +
                        "Vestida com sedas finas de cores vivas e ostentando um olhar astuto que parece ler a sua alma, ela é a principal estrategista, diplomata e tutora da mansão.\n" +
                        "Fica evidente que ninguém ascende na corte sem passar pelo crivo rigoroso dela.\n" +
                        "O Duque levanta os olhos, curioso, enquanto Zuri o avalia da cabeça aos pés, notando silenciosamente cada imperfeição nos seus modos e na sua postura.\n" +
                        "— O que traz alguém de fora aos meus salões privados? — pergunta o Duque.\n");

        cenarios.get("Mansão - Opção 1").falas.add(
                "Zuri quebra o selo e lê a carta discretamente. Seus olhos brilham ao perceber que a cura está pronta.\n" +
                        "Voltando-se para o Duque, ela mente com fluidez perfeita: \"Meu senhor, este é um perito do exterior trazendo documentos militares urgentes para o Rei. Precisamos enviá-lo ao castelo imediatamente.\"\n" +
                        "O Duque, confiando cegamente nela, assina o passe sem fazer perguntas. [Recebe Passe para o Castelo Real]\n");

        cenarios.get("Mansão - Opção 2").falas.add(
                "Zuri sorri levemente, satisfeita com a sua perspicácia. Ela recolhe as moedas com um aceno elegante e, pelas próximas horas, submete você a um treinamento intensivo.\n" +
                        "Ela afia o seu vocabulário e lhe ensina as complexas regras não ditas de manipulação da elite.\n" +
                        "Ao final, ela mente para o Duque sobre a sua missão, convencendo-o de que você precisa ver o Rei.\n" +
                        "O Duque, impressionado com a sua evolução, entrega-lhe o documento selado. [-15 Moedas de Ouro, +1 Ponto em Classe, Recebe Passe para o Castelo Real, +1 Amizade com Zuri]\n");

        cenarios.get("Mansão - Opção 3").falas.add(
                "O Duque suspira profundamente, ofendido. Ele se recusa a assinar.\n" +
                        "Porém, Zuri se aproxima de você e segura seu pulso com força implacável, sussurrando: \"Sua ignorância não arruinará o meu tabuleiro.\"\n" +
                        "Ela mesma forja a assinatura do Duque em um salvo-conduto e o empurra contra o seu peito, junto com um bilhete contendo o que você não deve dizer ao Rei.\n" +
                        "Você sobrevive à sua própria estupidez, mas perde o respeito da corte. [Recebe Passe para o Castelo Real, -1 Amizade com Zuri e o Duque]\n");


        // CASTELO REAL
        cenarios.get("Castelo Real").falas.add(
                "Os imensos portões do Castelo Real se abrem com um estrondo.\n" +
                        "O salão do trono é vasto, adornado com tapeçarias que contam as vitórias de Oblitum, mas o clima lá dentro é de derrota e paranoia.\n" +
                        "O Rei repousa de mau humor em seu trono, com olheiras profundas, cercado por nobres que discutem aos gritos sobre a ordem de incendiar as favelas para conter a praga.\n" +
                        "Quando você avança pelo tapete vermelho e apresenta o selo do Duque Rodrigo, o silêncio toma conta do salão. Todos os olhos se voltam para você.\n" +
                        "O Rei se inclina para frente, a coroa pesando em sua cabeça cansada.\n" +
                        "— O Duque Rodrigo não enviaria qualquer um à minha presença enquanto o meu reino queima. Fale logo, forasteiro. O que você traz de tão urgente que ousa interromper o conselho da Coroa?\n" +
                        "(Você segura o frasco translúcido firme em sua mão. O destino de Oblitum depende de como você negociará a produção em massa desta cura).\n");

        cenarios.get("Castelo Real - Opção 1").falas.add(
                "O Rei, surpreso, ordena que o frasco seja testado em um servo infectado ali mesmo.\n" +
                        "Quando o servo apresenta melhoras imediatas, o salão entra em êxtase. O Rei decreta a produção da cura, mas a distribuição segue a ordem fria da corte:\n" +
                        "os nobres e o exército são curados primeiro. As Favelas, consideradas um risco contínuo, são queimadas de qualquer forma.\n" +
                        "Você é recompensado com baús de ouro e o título de Lorde, passando o resto dos seus dias em uma mansão luxuosa.\n" +
                        "Você sobreviveu e enriqueceu, mas o preço foi virar as costas para o povo.\n" +
                        "(FIM DE JOGO)\n");

        cenarios.get("Castelo Real - Opção 2").falas.add(
                "O Rei sorri de forma cruel. Ele está exausto das exigências da Igreja e vê na sua proposta a desculpa perfeita para abrir os cofres do clero.\n" +
                        "Ele lhe entrega o Selo da Inquisição Real, dando-lhe autoridade absoluta.\n" +
                        "Você deve marchar de volta ao Bairro Nobre e enfrentar o arrogante Cardeal em seu próprio território para confiscar as riquezas da Catedral. [Você recebeu Mandato Real]\n");

        cenarios.get("Castelo Real - Opção 3").falas.add(
                "O Rei se levanta bruscamente, a coroa quase escorregando de sua cabeça. A paranoia toma conta dos seus olhos.\n" +
                        "\"Tem a minha autoridade absoluta. Traga-me a cabeça do traidor, ou a sua rolará no lugar!\" decreta o monarca.\n" +
                        "Você saca de suas vestes a peça final do quebra-cabeça: um registro contábil e uma carta com o selo real interceptada por Zuri na mansão, comprovando que o Duque Rodrigo ordenou a importação do patógeno babilônico e bloqueou os recursos das favelas propositalmente para testá-lo no povo. [Você recebeu Mandato Real]\n");


        // RETORNO À CATEDRAL (ESCOLHA 2)
        cenarios.get("Castelo Real - Retorno à Catedral").falas.add(
                "Escoltado por um destacamento da Guarda Real, você chuta as pesadas portas da Catedral.\n" +
                        "O Cardeal se levanta de seu trono estofado, pálido de fúria, enquanto seus guardas templários cruzam as espadas com a Guarda do Rei. Um banho de sangue dentro da igreja parece iminente.\n" +
                        "— Blasfêmia! — grita o Cardeal. — A Coroa não tem autoridade sobre o ouro do Senhor! Este é um solo sagrado! Recue, forasteiro, ou será excomungado e morto!\n");

        cenarios.get("Retorno à Catedral - Opção 1").falas.add(
                "[Sucesso]: A ameaça é tão contundente e oficial que os guardas da igreja recuam, e o Cardeal não tem escolha a não ser se render. [Você obtém o ouro do clero]\n");

        cenarios.get("Retorno à Catedral - Opção 2").falas.add(
                "[Sucesso]: Seus apelos divinos causam uma profunda crise de consciência nos templários, que abaixam suas armas e permitem a pilhagem pacífica em nome de um bem maior. [Você obtém o ouro do clero]\n");

        cenarios.get("Retorno à Catedral - Opção 3").falas.add(
                "[Falha]: Você ordena o avanço das tropas do Rei. O choque entre as duas guardas é caótico e violento.\n" +
                        "Na confusão, uma flecha ou lâmina perdida lhe atinge. O Cardeal perde a luta e você confisca o ouro, mas sofre ferimentos no processo. [-1 Vida]. * Se a sua vida chegar a 0, você morre dentro da Catedral.\n");

        cenarios.get("Retorno à Catedral - Final").falas.add(
                "Seja pela força da lei (Classe) ou pela conversão dos guardas (Fé), o Cardeal cai de joelhos, derrotado. Os baús secretos da Catedral são abertos, revelando uma riqueza obscena.\n" +
                        "Você confisca tudo e marcha para as Favelas, entregando os recursos a Laila.\n" +
                        "Com o financiamento garantido, o laboratório clandestino é expandido. Em poucos dias, a cura jorra para as ruas.\n" +
                        "Os pobres são salvos, o poder abusivo da Igreja em Oblitum é destruído e o Cardeal é exilado.\n" +
                        "Você escolhe ficar nas favelas com Laila e Silas, tornando-se o protetor das ruas e uma lenda viva amada pelo povo.\n" +
                        "(FIM DE JOGO)\n");

        // ENCONTRAR O TRAIDOR (ESCOLHA 3)
        cenarios.get("Castelo Real - Encontrar Traidor").falas.add(
                "Você marcha com a Guarda Real em direção à Mansão do Duque Rodrigo.\n" +
                        "Ao chegar, descobre que as portas do salão principal foram trancadas pelo lado de fora por Zuri, que aguarda sua chegada com um olhar gélido de satisfação.\n" +
                        "— Ele está lá dentro. Tentando queimar as evidências — diz Zuri, entregando-lhe a chave pesada. — Sabia que você era a peça que faltava para derrubá-lo, forasteiro.\n" +
                        "Você abre a porta e flagra o Duque Rodrigo atirando pergaminhos antigos na lareira. Ele vira-se bruscamente, o desespero rompendo sua habitual pose de superioridade.\n" +
                        "O homem que elaborou a Peste Babilônica para \"limpar\" as Favelas e tomar o poder do Rei agora está encurralado.\n" +
                        "— Você não entende! — grita o Duque. — Eu fiz isso por Oblitum! A superpopulação, o lixo, a fome... a praga era a única forma de purificar o reino para que a elite pudesse reerguê-lo!\n");

        cenarios.get("Encontrar Traidor - Consequência 1 e 3").falas.add(
                "O Duque Rodrigo é arrastado para fora de sua mansão a ferros. Zuri assume a liderança política da casa e financia a produção da cura de Laila.\n" +
                        "O Duque é executado em praça pública, enquanto a cura devolve a vida a Oblitum. O Rei o nomeia Inquisidor Chefe do Reino. Você extirpou o mal pela raiz.\n" +
                        "(FIM DE JOGO)\n");

        cenarios.get("Encontrar Traidor - Consequência 2").falas.add(
                "O Duque aceita seu acordo sombrio, tremendo de medo. Você mente para a Coroa, incriminando um inimigo qualquer, e distribui a cura sendo aclamado como herói.\n" +
                        "No entanto, o Duque Rodrigo agora é o seu fantoche. Você toma o controle dos bens dele e se torna o governante das sombras de Oblitum.\n" +
                        "A peste acabou, mas a podridão na capital agora tem o seu nome.\n" +
                        "(FIM DE JOGO)\n");

        // FINAL DE MORTE (GAME OVER)
        cenarios.get("Game Over - O Abraço de Oblitum").falas.add(
                "Seu corpo não suporta mais. Com os ferimentos acumulados, a exaustão física e o ar envenenado da Capital invadindo seus pulmões, suas pernas finalmente cedem.\n" +
                        "Você cai de joelhos no chão frio de pedra de Oblitum. As vozes ao seu redor se tornam distantes e a visão escurece.\n" +
                        "A Peste Babilônica, ou a pura brutalidade de um reino em colapso, cobrou o seu preço.\n" +
                        "Você fecha os olhos, tornando-se apenas mais um corpo anônimo nas ruas sombrias da Capital.\n" +
                        "A carta que o trouxe até aqui voa para longe, levada pelo vento. A esperança de cura morreu com você.\n" +
                        "(FIM DE JOGO - TELA PRETA)\n");
    }
}