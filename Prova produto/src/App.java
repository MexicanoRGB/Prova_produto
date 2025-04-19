import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Repositorio<Produto> repoProdutos = new RepositorioEmMemoria<>();
        Repositorio<Venda> repoVendas = new RepositorioEmMemoria<>();

        int opcao;
        do {
            System.out.println("\n====== MENU ======");
            System.out.println("1 - Incluir produto");
            System.out.println("2 - Consultar produto");
            System.out.println("3 - Listagem de produtos");
            System.out.println("4 - Vendas por período (detalhado)");
            System.out.println("5 - Realizar venda");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1:
                    IncluirProduto.executar(repoProdutos, sc);
                    break;
                case 2:
                    ConsultarProduto.executar(repoProdutos, sc);
                    break;
                case 3:
                    RelatorioProduto.executar(repoProdutos);
                    break;
                case 4:
                    RelatorioVendaDetalhado.executar(repoVendas, sc);
                    break;
                case 5:
                    Venda v = RegistroVenda.executar(repoProdutos, sc);
                    if (v != null)
                        repoVendas.adicionar(v);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (opcao != 0);

        sc.close();
    }
}
