import java.util.*;
import java.io.*;

public class LivroCRUD {
    Scanner sc = new Scanner(System.in);
    File file = new File("livros.txt");
    Map<String, String> livros = new HashMap<>();
    String codigo, titulo;
    
    
    public void livrosToString() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String linha;
        while ((linha = reader.readLine()) != null) {
            System.out.println();
            System.out.println(linha);
        }
        reader.close();
    }

    public void cadastrarLivro() throws IOException {
        System.out.println();
        System.out.print("Insira o código do livro: ");
        this.codigo = sc.nextLine();
        if (livros.containsKey(this.codigo)) {
            System.out.println();
            System.out.println("Livro já cadastrado.");
        } else {
            System.out.println();
            System.out.print("Digite o título do livro: ");
            this.titulo = sc.nextLine();
            livros.put(this.codigo, this.titulo);
            atualizarArquivo();
        }
    }

    public void atualizarLivro() throws IOException {
        System.out.println();
        System.out.print("Informe o código do livro que deseja atualizar: ");
        this.codigo = sc.nextLine();
        if (!livros.containsKey(codigo)) {
            System.out.println();
            System.out.println("Livro não encontrado.");
        } else {
            System.out.println();
            System.out.print("Informe o novo título do livro: ");
            String novoTitulo = sc.nextLine();
            livros.replace(this.codigo, novoTitulo);
            atualizarArquivo();
        }
    }

    public void atualizarArquivo() throws IOException {
        FileWriter writer = new FileWriter(file, false); 
        for (Map.Entry<String, String> entry : livros.entrySet()) {
            writer.write("Código: " + entry.getKey() + "\n" + "Título: " + entry.getValue() + "\n");
        }
        writer.close();
    }

    public void apagarLivro() throws IOException{
        System.out.println();
        System.out.print("Informe o código do livro que deseja remover: ");
        this.codigo = sc.nextLine();
        if (!livros.containsKey(this.codigo)) {
            System.out.println();
            System.out.println("Livro não encontrado.");
        } else {
            livros.remove(this.codigo);
            atualizarArquivo();
        }
    }
    
}
