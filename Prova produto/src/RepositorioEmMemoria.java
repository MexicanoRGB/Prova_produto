import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RepositorioEmMemoria<T> implements Repositorio<T> {
    private List<T> lista = new ArrayList<>();

    public void adicionar(T obj) {
        lista.add(obj);
    }

    public void alterar(T obj) {
        int idx = lista.indexOf(obj);
        if (idx >= 0)
            lista.set(idx, obj);
    }

    public T obterPorId(T obj) {
        int idx = lista.indexOf(obj);
        return idx >= 0 ? lista.get(idx) : null;
    }

    public Stream<T> obterStream() {
        return lista.stream();
    }

    public boolean estaVazio() {
        return lista.isEmpty();
    }

    public List<T> listar() {
        return new ArrayList<>(lista); // retorna uma cópia da lista
    }

    @Override
    public Produto buscar(Produto produto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscar'");
    }

    @Override
    public void atualizar(Produto p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }
}
