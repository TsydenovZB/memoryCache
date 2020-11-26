import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache<K, V> implements Cache<K, V> {

    Map<K, V> map = new LinkedHashMap<K, V>();
    LinkedList<K> list = new LinkedList<K>();
    int size = 0;

    public LRUCache(final int SIZE) {
        this.size = SIZE;
    }

    @Override
    public V get(K key) {
        V v = null;
        if (map.containsKey(key)) {
            list.remove(key);
            v = map.get(key);
            list.add(key);
        }
        return v;
    }

    @Override
    public void put(K key, V value) {
        if (map.containsKey(key)) {
            list.remove(key);
        }
        if (list.size() >= size) {
            K listKey = list.poll();
            map.remove(listKey);
        }
        list.add(key);
        map.put(key, value);
    }

    @Override
    public void remove(K key) {
        V v = null;
        if (map.containsKey(key)) {
            v = map.remove(key);
            list.remove(key);
        } else try {
            throw new Exception("Key not found");
        } catch (Exception e) {
            e.printStackTrace();
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
