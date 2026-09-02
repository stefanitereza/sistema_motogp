import java.util.Scanner;

public class Main {
    private static Piloto[] pilotos;
    private static int qtd = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int max = lerInteiro("Digite quantos pilotos: ");
        pilotos = new Piloto[max];

        int op = -1;
        while (op != 0) {
            exibirMenu();
            op = lerInteiro("Opcao: ");

            switch (op) {
                case 1 -> cadastrar();
                case 2 -> registrar();
                case 3 -> historico();
                case 4 -> desempenho();
                case 5 -> comparar();
                case 0 -> System.out.println("Saindo");
                default -> System.out.println("Invalida");
            }
        }
    }

    private static String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    private static int lerInteiro(String mensagem) {
        System.out.print(mensagem);
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }

    private static double lerDouble(String mensagem) {
        System.out.print(mensagem);
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
    }

    private static void exibirMenu() {
        System.out.println("1. Cadastrar ");
        System.out.println("2. Registrar Corrida");
        System.out.println("3. Consultar Historico");
        System.out.println("4. Apresentar Desempenho");
        System.out.println("5. Comparar Pilotos");
        System.out.println("0. Sair");
    }

    private static Piloto buscar(int num) {
        for (int i = 0; i < qtd; i++) {
            if (pilotos[i].getNum() == num) {
                return pilotos[i];
            }
        }
        return null;
    }

    private static Piloto criarPiloto(int numero, int capacidade) {
        Piloto p = new Piloto(numero, capacidade);
        p.setNome(lerTexto("Nome: "));
        p.setNacionalidade(lerTexto("Nacionalidade: "));
        p.setEquipe(lerTexto("Equipe: "));
        return p;
    }

    private static Corrida criarCorrida() {
        String circuito = lerTexto("Circuito: ");
        Corrida c = new Corrida(circuito);
        c.setPais(lerTexto("Pais: "));
        c.setPosicao(lerInteiro("Posicao: "));
        c.setPontos(lerInteiro("Pontos: "));
        c.setTempo(lerDouble("Melhor tempo: "));
        c.setVelocidade(lerDouble("Velocidade: "));
        return c;
    }

    private static void cadastrar() {
        if (qtd >= pilotos.length) {
            System.out.println("Erro");
            return;
        }

        int numero = lerInteiro("Numero da Moto: ");
        if (buscar(numero) != null) {
            System.out.println("Erro");
            return;
        }

        int maxCorridas = lerInteiro("Capacidade maxima de corridas: ");
        pilotos[qtd] = criarPiloto(numero, maxCorridas);
        qtd++;
        System.out.println("Piloto cadastrado");
    }

    private static void registrar() {
        int numero = lerInteiro("Digite o numero da moto: ");
        Piloto p = buscar(numero);

        if (p == null) {
            System.out.println("Erro");
            return;
        }

        Corrida c = criarCorrida();
        if (p.adicionarCorrida(c)) {
            System.out.println("Corrida registrada");
        } else {
            System.out.println("Erro");
        }
    }

    private static void historico() {
        int numero = lerInteiro("Digite o numero da moto: ");
        Piloto p = buscar(numero);

        if (p == null) {
            System.out.println("Piloto não encontrado");
            return;
        }

        System.out.println("\nHistorico:" + p.getNome());
        Corrida[] corridas = p.getCorridas();
        for (int i = 0; i < p.getQtd(); i++) {
            System.out.println("Circuito: " + corridas[i].getCircuito() + " Pos: " + corridas[i].getPosicao() + " Pts: " + corridas[i].getPontos() + " Vel: " + corridas[i].getVelocidade());
        }
    }

    private static void desempenho() {
        int numero = lerInteiro("Digite o numero da moto: ");
        Piloto p = buscar(numero);

        if (p != null) {
            System.out.println();
            p.imprimir();
        } else {
            System.out.println("não encontrado");
        }
    }

    private static void comparar() {
        if (qtd == 0) {
            System.out.println("Nenhum");
            return;
        }

        Piloto liderPontos = pilotos[0];
        Piloto maisVitorias = pilotos[0];
        Piloto maiorVel = pilotos[0];

        for (int i = 1; i < qtd; i++) {
            if (pilotos[i].calcularTotal() > liderPontos.calcularTotal()) {
                liderPontos = pilotos[i];
            }
            if (pilotos[i].contarVitorias() > maisVitorias.contarVitorias()) {
                maisVitorias = pilotos[i];
            }
            if (pilotos[i].maiorVelocidade() > maiorVel.maiorVelocidade()) {
                maiorVel = pilotos[i];
            }
        }

        System.out.println("Lider: " + liderPontos.getNome() + " (" + liderPontos.calcularTotal() + ")");
        System.out.println("Mais Vitorias: " + maisVitorias.getNome() + " (" + maisVitorias.contarVitorias() + " vitorias)");

        Corrida cVeloz = maiorVel.identificarCorrida();
        System.out.println("Maior Velocidade: " + maiorVel.maiorVelocidade() + " Piloto: " + maiorVel.getNome() + " (Circuito: " + (cVeloz != null ? cVeloz.getCircuito() : "Nenhum") + ")");
    }
}