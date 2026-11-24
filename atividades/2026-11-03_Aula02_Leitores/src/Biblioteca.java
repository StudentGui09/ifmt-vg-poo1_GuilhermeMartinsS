import java.util.ArrayList;

/**
 * Biblioteca com o seu acervo. Complete os TODO a partir do UML da ficha.
 * A lista do acervo nasce vazia no construtor.
 */
public class Biblioteca {
    private String nome;
    private ArrayList<ItemBiblioteca> acervo;

    public Biblioteca(String nome) {
        // TODO: validar o nome (null ou em branco gera IllegalArgumentException).
        if (nome.isBlank() || nome == null) {throw new IllegalArgumentException("Nome vazio ou nulo");}
        // TODO: guardar o nome e criar a lista vazia do acervo.
        this.nome=nome;
        acervo= new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionar(ItemBiblioteca item) {
        // TODO: se item for null, lançar IllegalArgumentException.
        if (item == null) {throw new IllegalArgumentException("Item vazio ou nulo");}
        // TODO: adicionar o item no acervo.
        acervo.add(item);
    }

    public int quantidadeItens() {
        // TODO: retornar quantos itens existem no acervo.
        return acervo.size();
    }

    public int contarDisponiveis() {
        // TODO: percorrer o acervo e contar os itens com isDisponivel() verdadeiro.
        int quantidadeItens= 0;
        for (ItemBiblioteca item : acervo) {
        if (item.isDisponivel()) {
        quantidadeItens++;}
        }
        return quantidadeItens;
    }

    public ItemBiblioteca buscarPorTitulo(String titulo) {
        // TODO: percorrer o acervo e devolver o primeiro item cujo título
        //       seja igual, ignorando maiúsculas: getTitulo().equalsIgnoreCase(titulo).
        // TODO: se nenhum combinar, retornar null.
        for (ItemBiblioteca item: acervo) {
        if (item.getTitulo().equalsIgnoreCase(titulo)) {
        return item;
        }
      }
        return null;
    }

    public String relatorio() {
        // TODO: primeira linha: o nome da biblioteca.
        // TODO: para cada item: "\n[disponível] " ou "\n[emprestado] " + item.descricao().
        String relato = getNome();
        for (ItemBiblioteca item: acervo) {
            if (item.isDisponivel()) {
            relato += "\n-Disponivel-=-" + item.descricao();}
            else {
            relato += "\n-Emprestado-=-"+item.descricao();}
        }
        return relato;
    }
}
