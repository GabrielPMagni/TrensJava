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
        try {
            Object item = this.composicao.get(posicao);
            if (!(item instanceof Locomotiva)) {
                throw new IndexOutOfBoundsException();
            }
            return (Locomotiva) item;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Não encontrados itens na posição indicada");
        }
        return null;
    }

    public int getQtdadeVagoes() {
        return this.qtdVagoes;
    }

    public Vagao getVagao(int posicao) {
        try {
            Object item = this.composicao.get(posicao);
            if (!(item instanceof Vagao)) {
                throw new IndexOutOfBoundsException();
            }
            return (Vagao) item;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Não encontrados itens na posição indicada");
        }
        return null;
    }

    public boolean engataLocomotiva(Locomotiva locomotiva) {
        Object lastItem = this.composicao.get(this.composicao.size());
        int tamanhoTrem = this.composicao.size();
        if (lastItem instanceof Locomotiva || tamanhoTrem == 0) {
            if (this.composicao.add(locomotiva)) {
                this.qtdLocomotivas++;
                this.pesoMaximo += tamanhoTrem == 0 ? locomotiva.getPesoMaximo() : locomotiva.getPesoMaximo() * 0.9;
                this.qtdMaxVagoes += (int) tamanhoTrem == 0 ? locomotiva.getQtdadeMaxVagoes()
                        : locomotiva.getQtdadeMaxVagoes() * 0.9;
                return true;
            }
        }
        return false;
    }

    public boolean desengataUltimoItem() {
        int indexFinal = this.composicao.size();

        if (this.composicao.get(indexFinal) instanceof ItensTrem) {
            ItensTrem item = (ItensTrem) this.composicao.get(indexFinal);
            item.liberarItem();
            return true;
        }
        return false;
    }

    public boolean engataVagao(Vagao vagao) {
        if ((vagao.getCapacidadeCarga() + this.pesoAtual) <= this.pesoMaximo && (qtdVagoes + 1) <= qtdMaxVagoes) {
            if (this.composicao.add(vagao)) {
                this.qtdVagoes++;
                this.pesoAtual += vagao.getCapacidadeCarga();
                return true;
            }
        }
        return false;
    }

}