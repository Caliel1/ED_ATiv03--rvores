class NoAVL {
    int valor;
    int altura;
    NoAVL esquerda;
    NoAVL direita;

    public NoAVL(int valor) {
        this.valor = valor;
        this.altura = 1;
        this.esquerda = null;
        this.direita = null;
    }
}