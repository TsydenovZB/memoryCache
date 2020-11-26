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

        cache.add(1, "one");
        cache.add(2, "two");
        assertModel(cache, String.valueOf(1), "one", String.valueOf(2), "two");
        cache.add(3, "three");
        cache.get(1);
        cache.add(4, "four");
        cache.add(5, "five");
        assertModel(cache, String.valueOf(1), "one", String.valueOf(4), "four", String.valueOf(5), "five");

        System.out.println(cache.toString());
    }
}
