public class Corrida {
    private String circuito;
    private String pais;
    private int posicao;
    private int pontos;
    private double tempo;
    private double velocidade;

    public Corrida(String circuito) {
        this.circuito = circuito;
    }

    public String getCircuito() { return circuito; }
    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public int getPosicao() { return posicao; }
    public void setPosicao(int posicao) {
        if (posicao > 0) this.posicao = posicao;
    }

    public int getPontos() { return pontos; }
    public void setPontos(int pontos) {
        if (pontos >= 0) this.pontos = pontos;
    }

    public double getTempo() { return tempo; }
    public void setTempo(double tempo) {
        if (tempo >= 0) this.tempo = tempo;
    }

    public double getVelocidade() { return velocidade; }
    public void setVelocidade(double velocidade) {
        if (velocidade >= 0) this.velocidade = velocidade;
    }

    public boolean vitoria() { return this.posicao == 1; }
    public boolean podio() { return this.posicao >= 1 && this.posicao <= 3; }
}