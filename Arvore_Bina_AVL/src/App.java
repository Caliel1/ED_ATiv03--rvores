public class App {
    public static void main(String[] args) throws Exception {
    
        int[] elementos = {1, 2, 3, 10, 4, 5, 9, 7, 8, 6};
        System.out.print("Sequência de inserção: {");
        for (int i = 0; i < elementos.length; i++) {
            System.out.print(elementos[i] + (i < elementos.length - 1 ? ", " : ""));
        }
        System.out.println("}\n");

        // ---------------------------------------------------
        // 1. TESTE DA ÁRVORE BINÁRIA DE BUSCA (BST)
        // ---------------------------------------------------
        System.out.println("==================================================");
        System.out.println("1. ÁRVORE BINÁRIA DE BUSCA (BST - NÃO BALANCEADA)");
        System.out.println("Resultado da BST após a inserção:");
        
        ArvoreBina bst = new ArvoreBina();
        
        for (int valor : elementos) {
            bst.inserir(valor);
        }

        bst.emOrdem(); 
        
        System.out.println("-> ANÁLISE: A inserção da sequência causou um grande desequilíbrio (inclinação).");
        System.out.println("   A altura da árvore é próxima de N (10), o que torna a busca O(N) no pior caso.");
        System.out.println("   A raiz final será o '1'.");


        // ---------------------------------------------------
        // 2. TESTE DA ÁRVORE AVL (BALANCEADA)
        // ---------------------------------------------------
        System.out.println("\n==================================================");
        System.out.println("2. ÁRVORE AVL (AUTO-BALANCEADA)");
        System.out.println("Resultado da AVL após a inserção:");
        
        ArvoreAVL avl = new ArvoreAVL();
        
        for (int valor : elementos) {
            avl.inserir(valor);
        }

        avl.emOrdem(); 
        
        System.out.println("-> ANÁLISE: As rotações garantiram que a árvore ficasse compacta.");
        System.out.println("   A altura da árvore é muito menor (h=4, no máximo), o que mantém a busca O(log N).");
        System.out.println("   Todos os fatores de balanceamento (fb) estão em [-1, 0, 1].");
        System.out.println("==================================================");
    }
}
