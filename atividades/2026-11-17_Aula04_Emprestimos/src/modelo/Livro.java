package modelo;

/** Pronta (vem da prática de 10/11). */
public class Livro extends ItemBiblioteca {
    private String autor;
    private int ano;   // 0 = não informado

    public Livro(String titulo, String autor, int ano) {
        super(titulo);
        if (autor == null || autor.isBlank()) {
            throw new IllegalArgumentException("Autor obrigatório");
        }
        if (ano < 0) {
            throw new IllegalArgumentException("Ano inválido");
        }
        this.autor = autor.trim();
        this.ano = ano;
    }

    public Livro(String titulo, String autor) {
        this(titulo, autor, 0);
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String descricao() {
        if (ano == 0) {
            return "Livro: " + getTitulo() + " | Autor: " + autor;
        }
        return "Livro: " + getTitulo() + " | Autor: " + autor + " (" + ano + ")";
    }
}
