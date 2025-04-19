import java.io.Serializable;

public class Produto implements Comparable<Produto>, Serializable {
    private int codigo;
    private String nome;
    private double valor;
    private int quantidadeEstoque;

    public Produto(int codigo, String nome, double valor, int quantidadeEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Produto(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    @Override
    public int compareTo(Produto outro) {
        return Integer.compare(this.codigo, outro.codigo);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Produto) {
            Produto p = (Produto) obj;
            return this.codigo == p.codigo;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%06d - %s - R$ %.2f - Estoque: %d", codigo, nome, valor, quantidadeEstoque);
    }
}
