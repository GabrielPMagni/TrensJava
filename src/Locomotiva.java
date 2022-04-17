public class Locomotiva implements ItensTrem {

    private int id, qtdMaximaVagoes;
    private double pesoMaximo;
    private boolean disponivel = true;
    private Composicao composicaoAtual;

    public Locomotiva(int id, double pesoMaximo, int qtdMaximaVagoes) {
        this.id = id;
        this.pesoMaximo = pesoMaximo;
        this.qtdMaximaVagoes = qtdMaximaVagoes;
        this.composicaoAtual = null;
    }

    public int getIdentificador() {
        return this.id;
    }

    public double getPesoMaximo() {
        return this.pesoMaximo;
    }

    public int getQtdadeMaxVagoes() {
        return this.qtdMaximaVagoes;
    }

    public Composicao getComposicao() {
        return composicaoAtual;
    }

    public boolean setComposicao(Composicao composicao) {
        if (this.isDisponivel()) {
            this.composicaoAtual = composicao;
            return true;
        }
        return false;
    }

    public void liberarItem() {
        this.composicaoAtual = null;
        this.disponivel = true;
    }

    public boolean isDisponivel() {
        return this.disponivel;
    }

}