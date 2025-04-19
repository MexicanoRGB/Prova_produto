import java.util.Scanner;

public class IncluirProduto {
    public static void executar(Repositorio<Produto> repo, Scanner sc) {
        System.out.print("Código: ");
        int cod = Integer.parseInt(sc.nextLine());

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Valor: ");
        double valor = Double.parseDouble(sc.nextLine());

        System.out.print("Quantidade em estoque: ");
        int qtd = Integer.parseInt(sc.nextLine());

        Produto p = new Produto(cod, nome, valor, qtd);
        repo.adicionar(p);
        System.out.println("Produto incluído com sucesso!");
    }
}
