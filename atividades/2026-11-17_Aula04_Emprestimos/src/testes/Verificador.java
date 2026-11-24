package testes;

/** Pronto (cap. 13): um mini "framework" de testes feito por nós. */
public class Verificador {
    private static int passou = 0;
    private static int falhou = 0;

    public static void verificar(boolean condicao, String descricao) {
        if (condicao) {
            passou++;
            System.out.println("[OK]    " + descricao);
        } else {
            falhou++;
            System.out.println("[FALHA] " + descricao);
        }
    }

    public static void resumo() {
        System.out.println(passou + " passaram, " + falhou + " falharam.");
    }
}
