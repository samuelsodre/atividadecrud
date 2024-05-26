import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        LivroCRUD crud = new LivroCRUD();
        int opcao;

        do {
            System.out.println("\nDigite a opção desejada\n"
            + "1 - Cadastrar novo livro\n"
            + "2 - Ler livros registrados\n"
            + "3 - Atualizar livro registrado\n"
            + "4 - Apagar livro registrado\n"
            + "0 - Encerrar Programa");
            System.out.print("\n" + "Opção: ");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    crud.cadastrarLivro();
                    break;
                case 2:
                    crud.livrosToString();
                    break;
                case 3:
                    crud.atualizarLivro();
                    break;
                case 4:
                    crud.apagarLivro();
                default:
                    break;
            }
        } while (opcao != 0);
        
        sc.close();
    }
}
