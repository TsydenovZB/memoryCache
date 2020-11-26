import org.junit.Assert;
import org.junit.Test;

import java.util.*;


public class TestLRU {

    public static void assertModel(Cache<Integer, String> cache, String... keysAndValues) {
        List<String> actualKeysAndValues = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : cache.model().entrySet()) {
            actualKeysAndValues.add(String.valueOf(entry.getKey()));
            actualKeysAndValues.add(String.valueOf(entry.getValue()));
        }
        Assert.assertEquals(actualKeysAndValues, List.of(keysAndValues));
    }

    @Test
    public void test() {
        Cache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "one");
        cache.put(2, "two");
        assertModel(cache, String.valueOf(1), "one", String.valueOf(2), "two");
        cache.put(3, "three");
        cache.get(1);
        cache.put(4, "four");
        cache.put(5, "five");

        System.out.println(cache.toString());
    }
}
