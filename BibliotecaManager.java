public class BibliotecaManager {
    private ArvoreBPlus arvore;

    public BibliotecaManager() {
        this.arvore = new ArvoreBPlus(10);
    }

    public void inserirLivro(Livro livro) {
        String titulo = livro.getTitulo();
        if (buscarLivro(titulo) != null) {
            System.out.println("Livro já inserido");
            return;
        }
        arvore.inserir(livro);
    }

    public Livro removerLivro(String titulo) {
        Livro livroRemovido = arvore.remover(titulo);
        if (livroRemovido != null) {
            return livroRemovido;
        } else {
            System.out.println("Livro não encontrado.");
            return null;
        }
    }



    public Livro buscarLivro(String titulo) {
        return arvore.buscar(titulo);
    }

}
