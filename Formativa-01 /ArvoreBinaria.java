public class ArvoreBinaria {
    private Node raiz;
    class Node {
        private int valor;
        private Node esquerda, direita;Node(int valor) {
            this.valor = valor;
            this.esquerda = null;
            this.direita = null;
        }
    }
    void inserir(int valor) {
        raiz = inserir(raiz, valor);
    }
    Node inserir(Node node, int valor) {
        if (node == null)
            return new Node(valor);
        if (valor < node.valor)
            node.esquerda = inserir(node.esquerda, valor);
        else if (valor > node.valor)
            node.direita = inserir(node.direita, valor);
        return node;
    }
    void remover(int valor) {
        raiz = remover(raiz, valor);
    }
    Node remover(Node node, int valor) {
        if (node == null) return null;
        if (valor < node.valor)
            node.esquerda = remover(node.esquerda, valor);
        else if (valor > node.valor)
            node.direita = remover(node.direita, valor);
        else {
            if (node.esquerda != null && node.direita != null) {
                Node maiorEsquerda = encontrarMaior(node.esquerda);
                node.valor = maiorEsquerda.valor;
                node.esquerda = remover(node.esquerda, maiorEsquerda.valor);
            } else if (node.esquerda != null) {
                node = node.esquerda;
            } else {
                node = node.direita;
            }
        }
        return node;
    }

    void removerMaior() {
        if (raiz != null) {
            raiz = removerMaior(raiz);
        }
    }

    Node removerMaior(Node node) {
        if (node.direita == null) {
            return node.esquerda;
        }
        node.direita = removerMaior(node.direita);
        return node;
    }

    void removerMenor() {
        if (raiz != null) {
            raiz = removerMenor(raiz);
        }
    }

    Node removerMenor(Node node) {
        if (node.esquerda == null) {
            return node.direita;
        }
        node.esquerda = removerMenor(node.esquerda);
        return node;
    }


    Node encontrarMaior(Node node) {
        while (node.direita != null)
            node = node.direita;
        return node;
    }

    void emOrdem(Node node) {
        if (node == null) return;
        emOrdem(node.esquerda);
        System.out.print(node.valor + " ");
        emOrdem(node.direita);
    }
    void preOrdem(Node node) {
        if (node != null) {
            System.out.print(node.valor + " ");
            preOrdem(node.esquerda);
            preOrdem(node.direita);
        }
    }
    void posOrdem(Node node) {
        if (node != null) {
            posOrdem(node.esquerda);
            posOrdem(node.direita);
            System.out.print(node.valor + " ");
        }
    }
    void desenhar(Node node, int nivel) {
        if (node == null) return;
        desenhar(node.direita, nivel + 1);
        for (int i = 0; i < nivel; i++) System.out.print(" ");
        System.out.println(node.valor);
        desenhar(node.esquerda, nivel + 1);
    }
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.inserir(14);
        arvore.inserir(15);
        arvore.inserir(4);
        arvore.inserir(9);
        arvore.inserir(7);
        arvore.inserir(18);
        arvore.inserir(3);
        arvore.inserir(5);
        arvore.inserir(16);
        arvore.inserir(20);
        arvore.inserir(17);

        System.out.println("Árvore em ordem:");
        arvore.emOrdem(arvore.raiz);
        System.out.println("\n");

        arvore.removerMaior();
        System.out.println("Árvore após remoção do maior elemento (em ordem):");
        arvore.emOrdem(arvore.raiz);
        System.out.println("\n");

        arvore.removerMenor();
        System.out.println("Árvore após remoção do menor elemento (em ordem):");
        arvore.emOrdem(arvore.raiz);
        System.out.println("\n");

        System.out.println("Árvore desenhada:");
        arvore.desenhar(arvore.raiz, 0);
    }

}
