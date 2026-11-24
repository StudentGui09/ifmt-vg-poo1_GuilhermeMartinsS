/**
 * Livro é um ItemBiblioteca e acrescenta o autor.
 * Use super(titulo). Não copie título nem disponibilidade para esta classe.
 */
public class Livro extends ItemBiblioteca {
    private String autor;

    public Livro(String titulo, String autor) {
        super(titulo);
        // TODO: se autor for null ou em branco, lançar IllegalArgumentException.
        if (autor==null || "".equals(autor)) {
        throw new IllegalArgumentException("O autor esta como null ou em branco");}
        // TODO: guardar o autor.
        this.autor=autor;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String descricao() {
        // TODO: retornar "Livro: ", o título, " | Autor: " e o autor.
        return "Livro: " +getTitulo()+ "| Autor: "+autor;
        // Exemplo: Livro: O Pequeno Príncipe | Autor: Antoine de Saint-Exupéry
    }
}