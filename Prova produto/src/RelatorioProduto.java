public class RelatorioProduto {
    public static void executar(Repositorio<Produto> repo) {
        if (repo.estaVazio()) {
            System.out.println("Sem produtos cadastrados.");
            return;
        }

        System.out.printf("%-6s %-30s %-10s %-10s\n", "Código", "Nome", "Valor", "Estoque");

        double max = Double.MIN_VALUE, min = Double.MAX_VALUE, total = 0;
        int count = 0;

        for (Produto p : repo.listar()) {
            System.out.printf("%06d %-30s R$ %-8.2f %-10d\n",
                    p.getCodigo(), p.getNome(), p.getValor(), p.getQuantidadeEstoque());
            max = Math.max(max, (double) p.getValor());
            min = Math.min(min, (double) p.getValor());
            count++;
        }

        System.out.printf("\nValor médio: R$ %.2f - Mínimo: R$ %.2f - Máximo: R$ %.2f\n", total / count, min, max);
    }
}
