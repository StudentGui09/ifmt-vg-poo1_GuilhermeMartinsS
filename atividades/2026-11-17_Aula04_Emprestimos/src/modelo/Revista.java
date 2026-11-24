package modelo;

/** Revista: o desafio de 03/11, agora pronto e dentro do pacote modelo. */
public class Revista extends ItemBiblioteca {
    private int edicao;

    public Revista(String titulo, int edicao) {
        super(titulo);
        if (edicao <= 0) {
            throw new IllegalArgumentException("Edição deve ser positiva");
        }
        this.edicao = edicao;
    }

    public int getEdicao() {
        return edicao;
    }

    @Override
    public String descricao() {
        return "Revista: " + getTitulo() + " | Edição " + edicao;
    }
}
