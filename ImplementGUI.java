import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImplementGUI extends JFrame {

    private BibliotecaManager biblioteca;

    private JTextField textFieldTitulo;
    private JTextField textFieldAutor;
    private JTextField textFieldAno;
    private JTextArea textAreaResultado;
    private JTextArea textAreaLivrosCadastrados;


    public ImplementGUI() {

        biblioteca = new BibliotecaManager();

        // Configurações da janela
        setTitle("Gerenciamento de Biblioteca");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel para os campos de inserção
        JPanel panelInserir = new JPanel(new GridLayout(4, 2));
        panelInserir.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel labelTitulo = new JLabel("Título:");
        JLabel labelAutor = new JLabel("Autor:");
        JLabel labelAno = new JLabel("Ano de Publicação:");

        textFieldTitulo = new JTextField();
        textFieldAutor = new JTextField();
        textFieldAno = new JTextField();


        //Método Inserir
        JButton buttonInserir = new JButton("Inserir");
        buttonInserir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = textFieldTitulo.getText();
                if (!titulo.isEmpty()) {
                    String autor = textFieldAutor.getText();
                    int ano = Integer.parseInt(textFieldAno.getText());

                    Livro livro = new Livro(titulo, autor, ano);

                    if (biblioteca.buscarLivro(titulo) != null) {
                        textAreaResultado.setText("Livro já inserido");
                    } else {
                        biblioteca.inserirLivro(livro);
                        textFieldTitulo.setText("");
                        textFieldAutor.setText("");
                        textFieldAno.setText("");
                        textAreaResultado.setText("Livro inserido com sucesso!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Inserir dados do Livro");
                }
            }
        });


        panelInserir.add(labelTitulo);
        panelInserir.add(textFieldTitulo);
        panelInserir.add(labelAutor);
        panelInserir.add(textFieldAutor);
        panelInserir.add(labelAno);
        panelInserir.add(textFieldAno);
        panelInserir.add(new JLabel());
        panelInserir.add(buttonInserir);

        add(panelInserir, BorderLayout.NORTH);


        // Área de texto para exibir o resultado da busca
        textAreaResultado = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textAreaResultado);

        add(scrollPane, BorderLayout.CENTER);

        // Painel para a busca e remoção
        JPanel panelBuscarRemover = new JPanel(new GridLayout(1, 3));
        panelBuscarRemover.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTextField textFieldBuscar = new JTextField();

        //Método Buscar
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String titulo = textFieldBuscar.getText();
                if (!titulo.isEmpty()) {
                    Livro livro = biblioteca.buscarLivro(titulo);
                    if (livro != null) {
                        textAreaResultado.setText(livro.toString());
                    } else {
                        textAreaResultado.setText("Livro não encontrado.");
                    }
                } else {
                    textAreaResultado.setText("Inserir nome do livro para busca");
                }
            }
        });


        //Método Remover
        JButton buttonRemover = new JButton("Remover");
        buttonRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = textFieldBuscar.getText();
                if (!titulo.isEmpty()) {
                    Livro livroRemovido = biblioteca.removerLivro(titulo);
                    if (livroRemovido != null) {
                        textAreaResultado.setText("Livro removido com sucesso.");
                    } else {
                        textAreaResultado.setText("Livro não está catalogado.");
                    }
                } else {
                    textAreaResultado.setText("Inserir nome do livro para remoção.");
                }
                textFieldBuscar.setText("");
            }
        });


        panelBuscarRemover.add(textFieldBuscar);
        panelBuscarRemover.add(btnBuscar);
        panelBuscarRemover.add(buttonRemover);


        add(panelBuscarRemover, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ImplementGUI();
            }
        });
    }
}
