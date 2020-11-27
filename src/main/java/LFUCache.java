import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class LFUCache<V> implements Cache<V> {

    LinkedHashMap<Integer, V> map = new LinkedHashMap<Integer, V>();
    LinkedList<Integer> frequency = new LinkedList<>();
    int count = 0;
    int size = 0;

    public LFUCache(int size) {
        this.size = size;
    }

    @Override
    public V get(Integer id) {
        frequency.set(id - 1, frequency.get(id - 1) + 1);
        return map.get(id);
    }

    @Override
    public void add(V value) {
        if (map.size() >= size) {
            int entryKeyToBeRemoved = getLFUKey();
            map.remove(entryKeyToBeRemoved);
        }
        map.put(++count, value);
        frequency.add(0);
    }

    private int getLFUKey() {
        int key = 0;
        int minFreq = Integer.MAX_VALUE;

        for (Map.Entry<Integer, V> entry : map.entrySet()) {
            if (minFreq > frequency.get(entry.getKey() - 1)) {
                key = entry.getKey();
                minFreq = frequency.get(entry.getKey() - 1);
            }
        }
        return key;
    }

    @Override
    public void remove(Integer id) {
        map.remove(id);
    }

    @Override
    public Map<Integer, V> model() {
        return new LinkedHashMap<>(map);
    }

    @Override
    public String toString() {
        return "LFUCache {" +
                "map=" + map +
                '}';
    }
}
