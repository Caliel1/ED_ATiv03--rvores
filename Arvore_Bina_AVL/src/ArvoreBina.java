public class ArvoreBina {
    private No raiz;

    public ArvoreBina() {
        this.raiz = null;
    }

    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private No inserirRec(No raizAtual, int valor) {
        if (raizAtual == null) {
            return new No(valor);
        }

        if (valor < raizAtual.valor) {
            raizAtual.esquerda = inserirRec(raizAtual.esquerda, valor);
        } else if (valor > raizAtual.valor) {
            raizAtual.direita = inserirRec(raizAtual.direita, valor);
        }
        return raizAtual;
    }

    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(No raizAtual, int valor) {
        if (raizAtual == null) {
            return false;
        }

        if (valor == raizAtual.valor) {
            return true;
        }

        if (valor < raizAtual.valor) {
            return buscarRec(raizAtual.esquerda, valor);
        } else {
            return buscarRec(raizAtual.direita, valor);
        }
    }

    public void emOrdem() {
        System.out.print("In-ordem BST: ");
        emOrdemRec(raiz);
        System.out.println();
    }

    private void emOrdemRec(No no) {
        if (no != null) {
            emOrdemRec(no.esquerda);
            System.out.print(no.valor + " ");
            emOrdemRec(no.direita);
        }
    }
}