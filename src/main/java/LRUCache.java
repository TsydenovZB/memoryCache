import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> implements Cache<K, V> {

    LinkedHashMap<K, V> map = new LinkedHashMap<K, V>();
    int size = 0;

    public LRUCache(final int SIZE) {
        this.size = SIZE;
    }

    @Override
    public V get(K key) {
        V value = null;
        if (map.containsKey(key)) {
            value = map.get(key);
            map.remove(key);
            map.put(key, value);
        }
        return value;
    }

    @Override
    public void add(K key, V value) {
        map.remove(key);
        if (map.size() >= size) {
            K currentKey = map.keySet().iterator().next();
            map.remove(currentKey);
        }
        map.put(key, value);
    }

    @Override
    public void remove(K key) {
        V v = null;
        if (map.containsKey(key)) {
            v = map.remove(key);
        }
    }

    @Override
    public Map<K, V> model() {
        return new LinkedHashMap<>(map);
    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "map=" + map +
                '}';
    }
}
