public interface ItensTrem {
    public int getIdentificador();

    public boolean setComposicao(Composicao composicao);

    public void liberarItem();

    public boolean isDisponivel();
}
