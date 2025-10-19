public class ArvoreAVL {
    private NoAVL raiz;

    private int altura(NoAVL no) {
        return (no == null) ? 0 : no.altura;
    }

    private void atualizarAltura(NoAVL no) {
        if (no != null) {
            no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));
        }
    }

    private int fatorBalanceamento(NoAVL no) {
        return (no == null) ? 0 : altura(no.esquerda) - altura(no.direita);
    }

    private NoAVL rotacaoDireita(NoAVL y) {
        NoAVL x = y.esquerda;
        NoAVL T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        atualizarAltura(y);
        atualizarAltura(x);

        return x;
    }

    private NoAVL rotacaoEsquerda(NoAVL x) {
        NoAVL y = x.direita;
        NoAVL T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        atualizarAltura(x);
        atualizarAltura(y);

        return y;
    }

    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private NoAVL inserirRec(NoAVL no, int valor) {
        if (no == null) {
            return new NoAVL(valor);
        }

        if (valor < no.valor) {
            no.esquerda = inserirRec(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = inserirRec(no.direita, valor);
        } else {
            return no;
        }

        atualizarAltura(no);

        int fator = fatorBalanceamento(no);

        if (fator > 1 && valor < no.esquerda.valor) {
            return rotacaoDireita(no);
        }

        if (fator < -1 && valor > no.direita.valor) {
            return rotacaoEsquerda(no);
        }

        if (fator > 1 && valor > no.esquerda.valor) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }

        if (fator < -1 && valor < no.direita.valor) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    public void emOrdem() {
        System.out.print("In-ordem AVL: ");
        emOrdemRec(raiz);
        System.out.println();
    }

    private void emOrdemRec(NoAVL no) {
        if (no != null) {
            emOrdemRec(no.esquerda);
            System.out.print(no.valor + "(h:" + no.altura + ",fb:" + fatorBalanceamento(no) + ") ");
            emOrdemRec(no.direita);
        }
    }
}