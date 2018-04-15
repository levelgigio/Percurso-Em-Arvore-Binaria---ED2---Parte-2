
import utfpr.dainf.ct.ed.exemplo.ArvoreBinaria;
import utfpr.dainf.ct.ed.exemplo.ArvoreBinariaPesquisa;

/**
 * UTFPR - Universidade Tecnológica Federal do Paraná
 * DAINF - Departamento Acadêmico de Informática
 * 
 * Cria e percorre a seguinte árvore binária:
 *       
 *                    8
 *                   / \
 *                  /   \
 *                 3     10
 *                / \     \
 *               1   6     14 
 *                  / \    /
 *                 4   7  13
 * 
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 */
public class Main {
    
    public static void main(String[] args) {
        Main main = new Main();
        main.testaArvoreBinaria();
        main.testaArvoreBinariaPesquisa();
    }
    
    private void testaArvoreBinaria() {
        System.out.println("\n\nTESTE DE ARVORE BINÁRIA");
        
        // cria a raiz da árvore binária
        ArvoreBinaria<Integer> a = new ArvoreBinaria<>(8);
        
        // monta o ramo esquerdo
        ArvoreBinaria<Integer> e = a.insereEsquerda(new ArvoreBinaria<>(3));
        e.insereEsquerda(new ArvoreBinaria<>(1));
        ArvoreBinaria<Integer> d = e.insereDireita(new ArvoreBinaria<>(6));
        d.insereEsquerda(new ArvoreBinaria<>(4)).insereDireita(new ArvoreBinaria<>(5));
        d.insereDireita(new ArvoreBinaria<>(7));

        // monta o ramo direito
        a.insereDireita(new ArvoreBinaria<>(10))
                .insereDireita(new ArvoreBinaria<>(14))
                .insereEsquerda(new ArvoreBinaria<>(13));
        
        System.out.println("PERCURSO RECURSIVO");
        a.visitaEmOrdem();
        System.out.println("\nPERCURSO ITERATIVO");
        ArvoreBinaria<Integer> no;
        while ((no = a.proximoEmOrdem()) != null) {
            System.out.print(" " + no.getValor());
        }
    }
    
    private void testaArvoreBinariaPesquisa() {
        System.out.println("\n\nTESTE DE ARVORE BINÁRIA DE PESQUISA");
        
        // monta a árvore binária de pesquisa
        // e armazena os nós em um vetor para uso posterior
        ArvoreBinariaPesquisa<Integer> a = new ArvoreBinariaPesquisa<>(8);
        System.out.println("\nTESTES DE INSERÇÃO");
        ArvoreBinariaPesquisa[] nos = { a, // 0 raiz
            a.insere(3),    // 1
            a.insere(10),   // 2
            a.insere(1),    // 3
            a.insere(6),    // 4
            a.insere(4),    // 5
            a.insere(7),    // 6
            a.insere(14),   // 7
            a.insere(13)    // 8
        };
        
        System.out.println("\nPERCURSO RECURSIVO");
        a.visitaEmOrdem();
        System.out.println("\nPERCURSO ITERATIVO");
        ArvoreBinaria<Integer> no;
        while ((no = a.proximoEmOrdem()) != null) {
            System.out.print(" " + no.getValor());
        }
        System.out.println();
        
        System.out.println("\nPesquisa pelo nó com chave 6");
        ArvoreBinaria<Integer> no6 = a.pesquisa(6);
        System.out.println("Nó localizado: " + (no6 == null ? no6 : no6.getValor()));

        System.out.println("\nPesquisa pelo nó com chave 12");
        ArvoreBinaria<Integer> no12 = a.pesquisa(12);
        System.out.println("Nó localizado: " + (no12 == null ? no12 : no12.getValor()));

        System.out.println("\nNó mínimo");
        ArvoreBinaria<Integer> min = a.getMinimo();
        System.out.println("Nó localizado: " + (min == null ? min : min.getValor()));

        System.out.println("\nNó máximo");
        ArvoreBinaria<Integer> max = a.getMaximo();
        System.out.println("Nó localizado: " + (max == null ? max : max.getValor()));
        
        System.out.println("\nTODOS OS SUCESSORES");
        for (ArvoreBinariaPesquisa abp: nos) {
            ArvoreBinaria<Integer> s = a.sucessor(abp);
            System.out.format("Sucessor de %s: %s\n", abp.getValor(), s == null ? s : s.getValor());
        }
        
        System.out.println("\nTODOS OS PREDECESSORES");
        for (ArvoreBinariaPesquisa abp: nos) {
            ArvoreBinaria<Integer> p = a.predecessor(abp);
            System.out.format("Predecessor de %s: %s\n", abp.getValor(), p == null ? p : p.getValor());
        }


        System.out.println("\nTESTES DE EXCLUSÃO");
        for (ArvoreBinariaPesquisa abp: nos) {
            System.out.println("\nExcluindo " + abp.getValor());
            a.exclui(abp); // arvore pode mudar
            a.visitaEmOrdem();
        }
    }
}
