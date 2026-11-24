import modelo.ItemBiblioteca;
import modelo.Leitor;
import modelo.Livro;
import modelo.Revista;
import regras.Biblioteca;
import regras.RegraException;

/**
 * Teste pronto da prática de 10/11/2026.
 * Não altere este arquivo. Complete os TODO 1 a 12 dos pacotes modelo e regras.
 */
public class Aplicacao {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Biblioteca do Campus VG");
        Livro dom = new Livro("Dom Casmurro", "Machado de Assis", 1899);
        Livro vidas = new Livro("Vidas Secas", "Graciliano Ramos", 1938);
        Livro principe = new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry");
        Revista revista = new Revista("Revista do Campus", 12);
        biblioteca.adicionarItem(dom);
        biblioteca.adicionarItem(vidas);
        biblioteca.adicionarItem(principe);
        biblioteca.adicionarItem(revista);

        System.out.println("--- 1. Sobrecarga e this(...) ---");
        System.out.println(dom.descricao());
        // Esperado: Livro: Dom Casmurro | Autor: Machado de Assis (1899)
        System.out.println(principe.descricao());
        // Esperado: Livro: O Pequeno Príncipe | Autor: Antoine de Saint-Exupéry

        System.out.println("--- 2. static ---");
        Leitor ana = biblioteca.cadastrarLeitor("Ana");
        Leitor bruno = biblioteca.cadastrarLeitor("Bruno");
        System.out.println("Matrícula da Ana: " + ana.getMatricula());
        // Esperado: Matrícula da Ana: 1
        System.out.println("Matrícula do Bruno: " + bruno.getMatricula());
        // Esperado: Matrícula do Bruno: 2
        System.out.println("Limite de cada leitor: " + Leitor.LIMITE);
        // Esperado: Limite de cada leitor: 2

        System.out.println("--- 3. toString ---");
        System.out.println(ana);
        // Esperado: 1 - Ana (0/2)
        ana.pegar(dom);
        ana.pegar(revista);
        System.out.println(ana);
        // Esperado: 1 - Ana (2/2)
        System.out.println(dom);
        // Esperado: [emprestado] Livro: Dom Casmurro | Autor: Machado de Assis (1899)
        System.out.println("Acervo:");
        for (ItemBiblioteca item : biblioteca.getAcervo()) {
            System.out.println("  " + item);
        }
        // Esperado:
        //   [emprestado] Livro: Dom Casmurro | Autor: Machado de Assis (1899)
        //   [disponível] Livro: Vidas Secas | Autor: Graciliano Ramos (1938)
        //   [disponível] Livro: O Pequeno Príncipe | Autor: Antoine de Saint-Exupéry
        //   [emprestado] Revista: Revista do Campus | Edição 12
        System.out.println("Disponíveis: " + biblioteca.itensDisponiveis().size());
        // Esperado: Disponíveis: 2

        System.out.println("--- 4. equals ---");
        Leitor anaDoArquivo = new Leitor(1, "Ana");   // como se viesse de um arquivo
        System.out.println("Mesmo objeto? " + (ana == anaDoArquivo));
        // Esperado: Mesmo objeto? false
        System.out.println("Mesma leitora? " + ana.equals(anaDoArquivo));
        // Esperado: Mesma leitora? true
        System.out.println("Busca matrícula 2: " + biblioteca.buscarLeitor(2));
        // Esperado: Busca matrícula 2: 2 - Bruno (0/2)
        System.out.println("Busca matrícula 9: " + biblioteca.buscarLeitor(9));
        // Esperado: Busca matrícula 9: null

        Leitor carla = new Leitor(10, "Carla");        // também veio do arquivo
        biblioteca.adicionarLeitor(carla);
        Leitor davi = biblioteca.cadastrarLeitor("Davi");
        System.out.println("Matrícula do Davi: " + davi.getMatricula());
        // Esperado: Matrícula do Davi: 11   (o contador pulou a matrícula da Carla)

        System.out.println("--- 5. Regras viram exceção ---");
        try {
            biblioteca.adicionarItem(new Livro("dom casmurro", "Outro Autor"));
            System.out.println("ERRO: aceitou título repetido");
        } catch (RegraException e) {
            System.out.println("Recusado: " + e.getMessage());
        }
        // Esperado: Recusado: Já existe um item com o título "dom casmurro"
        try {
            biblioteca.adicionarLeitor(anaDoArquivo);
            System.out.println("ERRO: aceitou matrícula repetida");
        } catch (RegraException e) {
            System.out.println("Recusado: " + e.getMessage());
        }
        // Esperado: Recusado: Matrícula repetida: 1
        try {
            new Livro("Iracema", "José de Alencar", -1);
            System.out.println("ERRO: aceitou ano negativo");
        } catch (IllegalArgumentException e) {
            System.out.println("Inválido: " + e.getMessage());
        }
        // Esperado: Inválido: Ano inválido

        System.out.println(biblioteca.relatorio());
        // Esperado:
        // Biblioteca do Campus VG
        // Itens: 4 | Disponíveis: 2 | Leitores: 4
    }
}
