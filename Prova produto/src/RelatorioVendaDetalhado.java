import java.time.LocalDate;
import java.util.Scanner;

public class RelatorioVendaDetalhado {
    public static void executar(Repositorio<Venda> repoVenda, Scanner sc) {
        System.out.print("Data inicial (yyyy-mm-dd): ");
        LocalDate inicio = LocalDate.parse(sc.nextLine());

        System.out.print("Data final (yyyy-mm-dd): ");
        LocalDate fim = LocalDate.parse(sc.nextLine());

        double total = 0;
        int count = 0;

        System.out.printf("%-12s %-30s %-8s %-10s %-12s\n", "Data", "Produto", "Qtd", "Unit", "Total");
        for (Venda v : repoVenda.listar()) {
            if (!v.getData().isBefore(inicio) && !v.getData().isAfter(fim)) {
                double valorTotal = v.getQuantidade() * v.getProduto().getValor();
                System.out.printf("%-12s %-30s %-8d R$ %-8.2f R$ %-10.2f\n",
                        v.getData(), v.getProduto().getNome(), v.getQuantidade(), v.getProduto().getValor(),
                        valorTotal);
                total += valorTotal;
                count++;
            }
        }

        if (count > 0)
            System.out.printf("Média de vendas: R$ %.2f\n", total / count);
        else
            System.out.println("Nenhuma venda no período.");
    }
}
