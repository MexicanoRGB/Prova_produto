import java.io.Serializable;
import java.time.LocalDate;

public class Venda implements Serializable {
    private LocalDate data;
    private Produto produto;
    private int quantidade;

    public Venda(LocalDate data, Produto produto, int quantidade) {
        this.data = data;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public LocalDate getData() {
        return data;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        double total = quantidade * produto.getValor();
        return String.format("%s - %s - Qtd: %d - Unit: R$ %.2f - Total: R$ %.2f",
                data.toString(), produto.getNome(), quantidade, produto.getValor(), total);
    }

    public Object getCodigo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCodigo'");
    }

    public Object getNome() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNome'");
    }

    public Object getValor() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getValor'");
    }
}
