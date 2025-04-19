import java.util.stream.Stream;
import java.util.List;

public interface Repositorio<T> {
    void adicionar(T obj);

    void alterar(T obj);

    T obterPorId(T obj);

    Stream<T> obterStream();

    boolean estaVazio();

    List<T> listar(); // <- ADICIONADO

    Produto buscar(Produto produto);

    void atualizar(Produto p);
}
