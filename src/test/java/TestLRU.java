import org.junit.Assert;
import org.junit.Test;

import java.util.*;


public class TestLRU {

    public static void assertModel(Cache<Object> cache, Object... keysAndValues) {
        List<Object> actualKeysAndValues = new ArrayList<>();
        for (Map.Entry<Integer, Object> entry : cache.model().entrySet()) {
            actualKeysAndValues.add(entry.getValue());
        }
        Assert.assertEquals(actualKeysAndValues, List.of(keysAndValues));
    }

    @Test
    public void test() {
        Cache<Object> cache = new LRUCache<>(3);

        cache.add("one");
        cache.add("two");
        assertModel(cache, "one", "two");
        cache.add("three");
        cache.get(1);
        cache.add("four");
        cache.get(1);
        cache.add("five");
        assertModel(cache, "four", "one", "five");

        System.out.println(cache.toString());
    }
}
