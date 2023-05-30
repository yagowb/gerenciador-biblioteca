import java.util.ArrayList;
import java.util.List;

public class ArvoreBPlus {
    private int ordem;
    private No raiz;


    //construtor
    public ArvoreBPlus(int ordem) {
        this.ordem = ordem;
        this.raiz = new NoFolha();
    }


    //Métodos Básicos
    public void inserir(Livro livro) {
        if (livro != null) {
            raiz.inserir(livro);
        }
    }

    public Livro remover(String titulo) {
        if (!titulo.isEmpty()) {
            return raiz.remover(titulo);
        }
        return null;
    }



    public Livro buscar(String titulo) {
        if (!titulo.isEmpty()) {
            return raiz.buscar(titulo);
        }
        return null;
    }


    // Classe interna abstrata No
    private abstract class No {
        List<String> chaves;

        No() {
            this.chaves = new ArrayList<>();
        }

        abstract void inserir(Livro livro);

        abstract Livro remover(String titulo);

        abstract Livro buscar(String titulo);



    }

    // Classe interna NoFolha
    private class NoFolha extends No {
        List<Livro> livros;
        NoFolha proximo;

        NoFolha() {
            super();
            this.livros = new ArrayList<>();
            this.proximo = null;
        }


        @Override
        void inserir(Livro livro) {
            int index = 0;
            while (index < livros.size() && livro.getTitulo().compareTo(livros.get(index).getTitulo()) >= 0) {
                index++;
            }
            livros.add(index, livro);
            chaves.add(index, livro.getTitulo());

            if (livros.size() > ordem) {
                dividir();
            }
        }

        private void dividir() {
            int meio = livros.size() / 2;
            List<Livro> livrosDireita = new ArrayList<>(livros.subList(meio, livros.size()));
            List<String> chavesDireita = new ArrayList<>(chaves.subList(meio, chaves.size()));

            NoFolha novaFolha = new NoFolha(); // Cria um novo objeto NoFolha
            novaFolha.livros.addAll(livrosDireita);
            novaFolha.chaves.addAll(chavesDireita);
            novaFolha.proximo = this.proximo;

            this.proximo = novaFolha;
            livros.subList(meio, livros.size()).clear();
            chaves.subList(meio, chaves.size()).clear();
        }


        @Override
        Livro remover(String titulo) {
            int index = chaves.indexOf(titulo);
            if (index != -1) {
                chaves.remove(index);
                return livros.remove(index);
            } else {
                return null;
            }
        }

        @Override
        Livro buscar(String titulo) {
            for (int i = 0; i < chaves.size(); i++) {
                if (chaves.get(i).toLowerCase().contains(titulo.toLowerCase())) {
                    return livros.get(i);
                }
            }
            return null;
        }

    }

    // Classe interna NoInterno
    private class NoInterno extends No {
        List<No> filhos;

        NoInterno() {
            super();
            this.filhos = new ArrayList<>();
        }

        @Override
        void inserir(Livro livro) {
            int index = 0;
            while (index < chaves.size() && livro.getTitulo().compareTo(chaves.get(index)) > 0) {
                index++;
            }
            filhos.get(index).inserir(livro);
        }

        @Override
        Livro remover(String titulo) {
            int index = 0;
            while (index < chaves.size() && titulo.compareTo(chaves.get(index)) > 0) {
                index++;
            }
            Livro livroRemovido = filhos.get(index).remover(titulo);
            if (livroRemovido != null) {
                chaves.remove(index);
            }
            return livroRemovido;
        }


        @Override
        Livro buscar(String titulo) {
            int index = 0;
            while (index < chaves.size() && titulo.compareToIgnoreCase(chaves.get(index)) >= 0) {
                index++;
            }
            return filhos.get(index).buscar(titulo);
        }


    }
}
