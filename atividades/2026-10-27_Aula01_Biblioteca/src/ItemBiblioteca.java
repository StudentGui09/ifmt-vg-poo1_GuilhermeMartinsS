/**
 * Item da biblioteca. Complete os TODO a partir do UML da ficha.
 * Consultas não alteram o estado.
 */
public class ItemBiblioteca {
    private String titulo;
    private boolean disponivel;

    public ItemBiblioteca(String titulo) {
        // TODO: se titulo for null ou em branco, lançar IllegalArgumentException.
        if ("".equals(titulo) || titulo == null) {
        throw new IllegalArgumentException("Não possui um titulo o livro");}
        // TODO: guardar o título e iniciar disponivel como true.
        this.titulo = titulo;
        this.disponivel = true;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public boolean emprestar() {
        // TODO: se já estiver indisponível, retornar false.
        if( disponivel == false) {
            return false;
        } else {
            disponivel=false;
            return true;}
        // TODO: senão, marcar indisponível e retornar true.
        
    }
    
    public void devolver() {
        // TODO: voltar a disponibilidade para true.
        disponivel= true;
    }

    public String descricao() {
        // TODO: retornar "Item: " seguido do título.
        return "Item:" +titulo;
    }
}
