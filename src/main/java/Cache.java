import java.util.Map;

public interface Cache<K,V> {

    public V get (K k);

    public void add(K k, V v);

    public void remove(K k);

    public Map<K, V> model();
}
