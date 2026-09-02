public class Piloto {
    private int num;
    private String nome;
    private String nacionalidade;
    private String equipe;
    private Corrida[] corridas;
    private int qtd;

    public Piloto(int num, int capacidade) {
        this.num = num;
        this.corridas = new Corrida[capacidade];
        this.qtd = 0;
    }

    public int getNum() { return num; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getNacionalidade() { return nacionalidade; }
    public void setNacionalidade(String nacionalidade) { this.nacionalidade = nacionalidade; }
    public String getEquipe() { return equipe; }
    public void setEquipe(String equipe) { this.equipe = equipe; }
    public Corrida[] getCorridas() { return corridas; }
    public int getQtd() { return qtd; }

    public boolean adicionarCorrida(Corrida corrida) {
        if (qtd < corridas.length) {
            corridas[qtd] = corrida;
            qtd++;
            return true;
        }
        return false;
    }

    public int calcularTotal() {
        int total = 0;
        for (int i = 0; i < qtd; i++) {
            total += corridas[i].getPontos();
        }
        return total;
    }

    public double calcularMedia() {
        if (qtd == 0) return 0.0;
        return (double) calcularTotal() / qtd;
    }

    public int contarVitorias() {
        int vitorias = 0;
        for (int i = 0; i < qtd; i++) {
            if (corridas[i].vitoria()) vitorias++;
        }
        return vitorias;
    }

    public int contarPodios() {
        int podios = 0;
        for (int i = 0; i < qtd; i++) {
            if (corridas[i].podio()) podios++;
        }
        return podios;
    }

    public double calcularPercent() {
        if (qtd == 0) return 0.0;
        return ((double) contarVitorias() / qtd) * 100.0;
    }

    public int melhorResultado() {
        if (qtd == 0) return 0;
        int melhor = corridas[0].getPosicao();
        for (int i = 1; i < qtd; i++) {
            if (corridas[i].getPosicao() < melhor) {
                melhor = corridas[i].getPosicao();
            }
        }
        return melhor;
    }

    public double maiorVelocidade() {
        if (qtd == 0) return 0.0;
        double maior = corridas[0].getVelocidade();
        for (int i = 1; i < qtd; i++) {
            if (corridas[i].getVelocidade() > maior) {
                maior = corridas[i].getVelocidade();
            }
        }
        return maior;
    }

    public Corrida identificarCorrida() {
        if (qtd == 0) return null;
        Corrida maior = corridas[0];
        for (int i = 1; i < qtd; i++) {
            if (corridas[i].getVelocidade() > maior.getVelocidade()) {
                maior = corridas[i];
            }
        }
        return maior;
    }

    public void imprimir() {
        System.out.println("Piloto: " + nome + " Moto: " + num);
        System.out.println("Equipe: " + equipe + " Pais: " + nacionalidade);
        System.out.println("Corridas: " + qtd);
        System.out.println("Pontuação: " + calcularTotal());
        System.out.println("Media: " + String.format("%.2f", calcularMedia()));
        System.out.println("Vitorias: " + contarVitorias() + " (" + String.format("%.1f", calcularPercent()) + ")");
        System.out.println("Podios: " + contarPodios());
        System.out.println("Melhor lugar: " + (melhorResultado() > 0 ? melhorResultado() : "Nenhum"));

        Corrida corrida = identificarCorrida();
        if (corrida != null) {
            System.out.println("Maior Velocidade: " + corrida.getVelocidade() + " (Circuito: " + corrida.getCircuito() + ")");
        }
    }
}