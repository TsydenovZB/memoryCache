import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestLFU extends TestCase {
    public static void assertModel(Cache<Object> cache, Object... keysAndValues) {
        List<Object> actualKeysAndValues = new ArrayList<>();
        for (Map.Entry<Integer, Object> entry : cache.model().entrySet()) {
            actualKeysAndValues.add(entry.getValue());
        }
        Assert.assertEquals(actualKeysAndValues, List.of(keysAndValues));
    }

    @Test
    public void test() {
        Cache<Object> cache = new LFUCache<>(3);

        cache.add("one");
        cache.get(1);
        cache.add("two");
        assertModel(cache, "one", "two");
        cache.add("three");
        cache.get(1);
        cache.get(1);
        cache.get(1);
        cache.add("four");
        cache.add("five");
        cache.add("six");
        assertModel(cache, "one", "five", "six");

        System.out.println(cache.toString());
    }
}