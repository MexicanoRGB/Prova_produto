import java.time.LocalDate;
import java.util.Scanner;

public class RegistroVenda {
    public static Venda executar(Repositorio<Produto> repoProd, Scanner sc) {
        System.out.print("Código do produto: ");
        int cod = Integer.parseInt(sc.nextLine());

        Produto p = (Produto) repoProd.buscar(new Produto(cod));
        if (p == null) {
            System.out.println("Produto não encontrado.");
            return null;
        }

        if (p.getQuantidadeEstoque() == 0) {
            System.out.println("Produto sem estoque.");
            return null;
        }

        System.out.print("Quantidade: ");
        int qtd = Integer.parseInt(sc.nextLine());

        if (qtd > p.getQuantidadeEstoque()) {
            System.out.println("Estoque insuficiente.");
            return null;
        }

        p.setQuantidadeEstoque(p.getQuantidadeEstoque() - qtd);
        repoProd.atualizar(p);
        return new Venda(LocalDate.now(), p, qtd);
    }
}
