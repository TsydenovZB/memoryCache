import java.util.Map;

public interface Cache<V> {

    public V get (Integer id);

    public void add(V v);

    public void remove(Integer id);

    public Map<Integer, V> model();
}
