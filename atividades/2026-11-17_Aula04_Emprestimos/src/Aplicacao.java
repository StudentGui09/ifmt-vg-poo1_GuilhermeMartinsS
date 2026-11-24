import java.time.LocalDate;
import modelo.Emprestimo;
import modelo.Leitor;
import modelo.Livro;
import modelo.Revista;
import regras.Biblioteca;
import regras.RegraException;

/**
 * Teste pronto da prática de 17/11/2026.
 * Não altere este arquivo. Complete os TODO 1 a 11 dos pacotes modelo, regras e tela.
 * Os TODO 12 e 13 ficam em testes/TesteBiblioteca.java.
 */
public class Aplicacao {
    public static void main(String[] args) {
        LocalDate dia = LocalDate.of(2026, 11, 17);
        Biblioteca biblioteca = new Biblioteca("Biblioteca do Campus VG");
        Livro dom = new Livro("Dom Casmurro", "Machado de Assis", 1899);
        Livro vidas = new Livro("Vidas Secas", "Graciliano Ramos", 1938);
        Livro principe = new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry");
        Revista revista = new Revista("Revista do Campus", 12);
        biblioteca.adicionarItem(dom);
        biblioteca.adicionarItem(vidas);
        biblioteca.adicionarItem(principe);
        biblioteca.adicionarItem(revista);
        Leitor ana = biblioteca.cadastrarLeitor("Ana");
        Leitor bruno = biblioteca.cadastrarLeitor("Bruno");

        System.out.println("--- 1. Emprestar ---");
        Emprestimo primeiro = biblioteca.emprestar(ana, dom, dia);
        System.out.println(primeiro);
        // Esperado: 2026-11-17 | Ana | Dom Casmurro | em aberto
        biblioteca.emprestar(ana, revista, dia);
        System.out.println(ana);
        // Esperado: 1 - Ana (2/2)
        System.out.println(dom);
        // Esperado: [emprestado] Livro: Dom Casmurro | Autor: Machado de Assis (1899)

        System.out.println("--- 2. Regras ---");
        try {
            biblioteca.emprestar(ana, vidas, dia);
            System.out.println("ERRO: passou do limite");
        } catch (RegraException e) {
            System.out.println("Recusado: " + e.getMessage());
        }
        // Esperado: Recusado: Ana já está com 2 itens
        try {
            biblioteca.emprestar(bruno, dom, dia);
            System.out.println("ERRO: emprestou o mesmo livro duas vezes");
        } catch (RegraException e) {
            System.out.println("Recusado: " + e.getMessage());
        }
        // Esperado: Recusado: "Dom Casmurro" já está emprestado
        try {
            biblioteca.devolver(bruno, revista);
            System.out.println("ERRO: Bruno devolveu o que não pegou");
        } catch (RegraException e) {
            System.out.println("Recusado: " + e.getMessage());
        }
        // Esperado: Recusado: Bruno não está com "Revista do Campus"

        System.out.println("--- 3. Devolver ---");
        biblioteca.devolver(ana, dom);
        System.out.println(dom);
        // Esperado: [disponível] Livro: Dom Casmurro | Autor: Machado de Assis (1899)
        System.out.println(ana);
        // Esperado: 1 - Ana (1/2)
        System.out.println(primeiro);
        // Esperado: 2026-11-17 | Ana | Dom Casmurro | devolvido

        System.out.println("--- 4. Em aberto ---");
        for (Emprestimo e : biblioteca.emprestimosAtivos()) {
            System.out.println(e);
        }
        // Esperado: 2026-11-17 | Ana | Revista do Campus | em aberto
        System.out.println(biblioteca.relatorio());
        // Esperado:
        // Biblioteca do Campus VG
        // Itens: 4 | Disponíveis: 3 | Leitores: 2 | Empréstimos em aberto: 1
    }
}
