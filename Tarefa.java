import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tarefa {

    public static class Audvis {
        private String diretor;
        private String titulo;
        private List<String> generos;
        private List<Pessoa> elenco;

        public Audvis(String diretor, String titulo, List<String> generos, List<Pessoa> elenco) {
            this.titulo = titulo;
            this.generos = generos;
            this.diretor = diretor;
            this.elenco = elenco;
        }

        public String Rtitulo() {
            return titulo;
        }

        public List<String> Rgeneros() {
            return generos;
        }

        public String Rdiretor() {
            return diretor;
        }

        public List<Pessoa> Relenco() {
            return elenco;
        }
    }

    public static class Filme extends Audvis {
        private String dataLanc;
        private int duracao;

        public Filme(String diretor, String titulo, List<String> generos, List<Pessoa> elenco, String dataLanc,
                int duracao) {
            super(diretor, titulo, generos, elenco);
            this.dataLanc = dataLanc;
            this.duracao = duracao;
        }
    }

    public static class Serie extends Audvis {
        private int qntTemp;
        private int qntEp;

        public Serie(String diretor, String titulo, List<String> generos, List<Pessoa> elenco, int qntTemp,
                int qntEp) {
            super(diretor, titulo, generos, elenco);
            this.qntTemp = qntTemp;
            this.qntEp = qntEp;
        }
    }

    public static class Pessoa {
        private String nome;
        private String datNasc;
        private List<String> premios;

        public Pessoa(String nome, String datNasc) {
            this.nome = nome;
            this.datNasc = datNasc;
            this.premios = new ArrayList<>();
        }

        public String Rnome() {
            return nome;
        }

        public String RDatNasc() {
            return datNasc;
        }

        public List<String> Rpremios() {
            return premios;
        }
    }

    public static class Catalogo {
        private List<Filme> catalogo;

        public Catalogo(List<Filme> catalogo) {
            this.catalogo = catalogo;
        }

        public List<Filme> RCatalogo() {
            return catalogo;
        }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("O que você quer fazer?\n  1 - Inserir\n  2 - Editar\n  3 - Listar");
        List<Filme> filmes = new ArrayList<>();
        List<Pessoa> elenco = new ArrayList<>();
        int escolha = teclado.nextInt();

        if (escolha == 1) {
            System.out.println("1 - Pessoa\n2 - Filme");
            escolha = teclado.nextInt();

            if (escolha == 1) {
                System.out.print("Digite o nome da pessoa: ");
                teclado.nextLine();
                String nome = teclado.nextLine();

                System.out.print("Digite a data de nascimento da pessoa: ");
                String datNasc = teclado.nextLine();

                Pessoa pessoa = new Pessoa(nome, datNasc);
                System.out.println("Pessoa inserida com sucesso!");
            } else if (escolha == 2) {
                System.out.print("Digite o diretor: ");
                teclado.nextLine();
                String diretor = teclado.nextLine();
                System.out.print("Digite o título: ");
                String titulo = teclado.nextLine();

                List<String> generos = new ArrayList<>();
                while (true) {
                    System.out.print("Digite um gênero (ou digite '0' para parar): ");
                    String genero = teclado.nextLine();
                    if (genero.equals("0")) {
                        break;
                    }
                    generos.add(genero);
                }
                System.out.print("Digite a data de lançamento do filme: ");
                String dataLanc = teclado.nextLine();

                System.out.print("Digite a duração do filme em minutos: ");
                int duracao = teclado.nextInt();

                Filme filme = new Filme(diretor, titulo, generos, new ArrayList<>(), dataLanc, duracao);
                System.out.println("Filme inserido.");
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        } else if (escolha == 2) {
            System.out.println("1 - Pessoa\n2 - Filme");
            escolha = teclado.nextInt();
            if (escolha == 1) {

            } else if (escolha == 2) {

            }
        } else if (escolha == 3) {
            System.out.println("1 - Pessoa\n2 - Filme");
            escolha = teclado.nextInt();
            if (escolha == 2) {
                Catalogo catalogo = new Catalogo(filmes);
                for (Filme filme : catalogo.RCatalogo()) {
                    System.out.println("Título: " + filme.Rtitulo());
                    System.out.println("Diretor: " + filme.Rdiretor());
                    System.out.println("Gêneros: " + filme.Rgeneros());
                    System.out.println("Data de lançamento: " + filme.dataLanc);
                    System.out.println("Duração: " + filme.duracao + " minutos");
                    System.out.println("Elenco:" + filme.Relenco());
                }
            } else if (escolha == 1) {
    System.out.println("Selecione o filme para exibir o elenco:");
    for (int i = 0; i < filmes.size(); i++) {
        Filme filme = filmes.get(i);
        System.out.println((i + 1) + ". " + filme.Rtitulo());
    }
    int opcaoFilme = teclado.nextInt();

    if (opcaoFilme >= 1 && opcaoFilme <= filmes.size()) {
        Filme filmeSelecionado = filmes.get(opcaoFilme - 1);

        for (Pessoa pessoa : filmeSelecionado.Relenco()) {
            System.out.println("- Nome: " + pessoa.Rnome());
            System.out.println("  Data de Nascimento: " + pessoa.RDatNasc());
            System.out.println("  Prêmios: " + pessoa.Rpremios());
        }
    } else {
        System.out.println("Opção de filme inválida.");
    }
    }
}
}
}





