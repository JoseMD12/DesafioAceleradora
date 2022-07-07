import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class App {
    public static void main(String [] args) throws IOException{
        Biblioteca b = leLivros();
        Scanner in = new Scanner(System.in);
        int op = 0;
        System.out.println("--------------------------Biblioteca--------------------------");
        do{
            System.out.println("\n  Insira a opcao desejada:");
            System.out.println("       1 - Doar Livro");
            System.out.println("       2 - Retirar Livro");
            System.out.println("       3 - Devolver Livro");
            System.out.println("       4 - Encerrar");
            op = in.nextInt();
            switch(op){
                case 1:
                    System.out.println("\n- Funcionalidade - Doar Livro ==================================");
                    System.out.println("\nDigite o titulo do livro");
                    in.nextLine();
                    String nome = in.nextLine();
                    System.out.println("\nDigite o autor do livro");
                    String autor = in.nextLine();
                    System.out.println("\nDigite o ano de lancamento do livro");
                    int anoLancamento = in.nextInt();
                    boolean doar = b.doarLivro(nome, autor, anoLancamento);
                    if(doar){
                        System.out.println("\n          Livro registrado com sucesso");
                        System.out.println(b.achaLivro(b.getQntLivros() - 1));
                    } else {
                        System.out.println("\n\n            ERROR: Livro nao registrado");
                    }
                    continue;
                case 2:
                    System.out.println("\n- Funcionalidade - Retirar Livro ===============================");
                    System.out.println("\nDigite o codigo do livro que deseja retirar");
                    int idLivro = in.nextInt() - 1;
                    System.out.println("\nDigite o nome do leitor que esta retirando");
                    in.nextLine();
                    String leitor = in.nextLine();
                    boolean retirar = b.retirarLivro(idLivro, leitor);
                    if(retirar){
                        System.out.println("\n          Livro retirado com sucesso");
                        System.out.println(b.achaLivro(idLivro));
                    } else {
                        System.out.println("\n\n            ERROR: Livro nao retirado");
                    }
                    continue;
                case 3:
                    System.out.println("\n- Funcionalidade - Devolver Livro ==============================");
                    System.out.println("\nDigite o codigo do livro que deseja devolver");
                    int idLivro1 = in.nextInt() - 1;
                    boolean devolver = b.devolverLivro(idLivro1);
                    if(devolver){
                        System.out.println("\n          Livro devolvido com sucesso");
                        System.out.println(b.achaLivro(idLivro1));
                    } else {
                        System.out.println("\n\n            ERROR: Livro nao devolvido");
                    }
                case 4:
                    in.close();
                    break;
                case default:
                    System.out.println("                    \nOPCAO INEXISTENTE");
                    continue;        
            }
        } while(op != 4);
        
        try {
            gravaLivros(b);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void gravaLivros(Biblioteca b) throws IOException{
        FileWriter arq = new FileWriter("Biblioteca Ágil/banco.txt");
        PrintWriter gravaArq = new PrintWriter(arq);
        for(int i = 0; i < b.getQntLivros(); i++){
            gravaArq.print(b.achaLivro(i) + "\n\n");
        }
        gravaArq.close();
    }

    public static Biblioteca leLivros() throws IOException{
        LinkedList<Livro> livros = new LinkedList<>();
        FileReader arq = new FileReader("Biblioteca Ágil/banco.txt");
        BufferedReader leArq = new BufferedReader(arq);
        String linha = leArq.readLine();
        int id;
        String nome;
        String autor;
        int anoLancamento;
        boolean disponivel;
        String leitor;
        do{
            id = Integer.parseInt(linha.split(": ")[1]) - 1;
            nome = leArq.readLine().split(": ")[1];
            autor = leArq.readLine().split(": ")[1];
            anoLancamento = Integer.valueOf(leArq.readLine().split(": ")[1]);
            disponivel = ((leArq.readLine().split(": ")[1].equals("Disponivel")) ? true : false);
            leitor = leArq.readLine().split(": ")[1];
            if(leitor.equals(null)){
                leitor = "";
            }
            leArq.readLine();
            linha = leArq.readLine();
            livros.add(new Livro(id, nome, autor, anoLancamento, disponivel, leitor));
        }while(linha != null);

        leArq.close();
        return new Biblioteca(livros);
    }
}
