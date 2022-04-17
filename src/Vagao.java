public class Vagao implements ItensTrem {

    private int id;
    private boolean disponivel;
    private double capacidadeCarga;
    private Composicao composicaoAtual;

    public Vagao(int id, double capacidadeCarga) {
        this.id = id;
        this.disponivel = true;
        this.capacidadeCarga = capacidadeCarga;
        this.composicaoAtual = null;
    }

    public int getIdentificador() {
        return this.id;
    }

    public double getCapacidadeCarga() {
        return this.capacidadeCarga;
    }

    public Composicao getComposicao() {
        return this.composicaoAtual;
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