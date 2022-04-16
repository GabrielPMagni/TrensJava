import java.util.ArrayList;

public class Composicao {

    private int id, qtdLocomotivas = 0, qtdVagoes = 0, qtdMaxVagoes = 0;
    private double pesoMaximo = 0.0, pesoAtual = 0.0;
    private ArrayList<Object> composicao;

    public Composicao(int id, Locomotiva locomotiva) {
        this.id = id;
        this.engataLocomotiva(locomotiva);
    }

    public int getIdentificador() {
        return this.id;
    }

    public int getQtdadeLocomotivas() {
        return this.qtdLocomotivas;
    }

    public Locomotiva getLocomotiva(int posicao) {
        Object item = this.composicao.get(posicao);
        if (!(item instanceof Locomotiva)) {
            throw new IndexOutOfBoundsException("Locomotiva não encontrada nesta posição");
        }
        return (Locomotiva) item;
    }

    public int getQtdadeVagoes() {
        return this.qtdVagoes;
    }

    public Vagao getVagao(int posicao) {
        Object item = this.composicao.get(posicao);
        if (!(item instanceof Vagao)) {
            throw new IndexOutOfBoundsException("Vagão não encontrado nesta posição");
        }
        return (Vagao) item;
    }

    public boolean engataLocomotiva(Locomotiva locomotiva) {
        Object lastItem = this.composicao.get(this.composicao.size());
        if (lastItem instanceof Locomotiva || this.composicao.size() == 0) {
            if (this.composicao.add(locomotiva)) {
                this.qtdLocomotivas++;
                this.pesoMaximo += locomotiva.getPesoMaximo();
                this.qtdMaxVagoes += locomotiva.getQtdadeMaxVagoes();
                return true;
            }
        }
        return false;
    }

    public boolean desengataLocomotiva() {
        return true;
    }

    public boolean engataVagao(Vagao vagao) {
        if (!((vagao.getCapacidadeCarga() + this.pesoAtual) <= this.pesoMaximo && (qtdVagoes + 1) <= qtdMaxVagoes)) {
            return false;
        }
        if (this.composicao.add(vagao)) {
            this.qtdVagoes++;
            this.pesoAtual += vagao.getCapacidadeCarga();
            return true;
        }
        return false;
    }

}