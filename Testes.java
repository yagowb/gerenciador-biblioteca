public class Testes {
    public static void main(String[] args) {
        BibliotecaManager acervo = new BibliotecaManager();

        Livro livro1 = new Livro("Ensaio sobre a Cegueira", "José Saramago", 1995);
        Livro livro2 = new Livro("O Hobbit", "J.R.R. Tolkien", 1937);
        Livro livro3 = new Livro("Killers of the Flower Moon", "David Grann", 2017);

        acervo.inserirLivro(livro1);
        acervo.inserirLivro(livro2);
        acervo.inserirLivro(livro3);

        Livro livroEncontrado = acervo.buscarLivro("Ensaio");
        System.out.println(livroEncontrado); //retorna informações do livro1

        acervo.removerLivro("O Hobbit");

        livroEncontrado = acervo.buscarLivro("O Hobbit");
        System.out.println(livroEncontrado); //retorna null

        Livro livroBusca2 = acervo.buscarLivro("Killers");
        System.out.println(livroBusca2);

        acervo.removerLivro("Ensaio sobre a Cegueira");
        System.out.println(acervo.buscarLivro("Ensaio"));


    }
}
