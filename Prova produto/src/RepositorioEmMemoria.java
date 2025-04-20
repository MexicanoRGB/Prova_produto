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
        for (T obj : lista) {
            if (obj instanceof Produto) {
                Produto p = (Produto) obj;
                if (p.getCodigo() == produto.getCodigo()) {
                    return p;
                }
            }
        }
        return null;
    }

    @Override
    public void atualizar(Produto p) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) instanceof Produto) {
                Produto prod = (Produto) lista.get(i);
                if (prod.getCodigo() == p.getCodigo()) {
                    lista.set(i, (T) p);
                    return;
                }
            }
        }
    }

}
