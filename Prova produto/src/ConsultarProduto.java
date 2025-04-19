import java.util.Scanner;

public class ConsultarProduto {
    public static void executar(Repositorio<Produto> repo, Scanner sc) {
        System.out.print("Digite parte do nome: ");
        String busca = sc.nextLine().toLowerCase();

        repo.listar().stream()
                .filter(p -> p.getNome().toLowerCase().contains(busca))
                .sorted()
                .forEach(System.out::println);
    }
}
