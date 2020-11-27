import org.junit.Test;


public class TestStrategyLRU extends TestStrategy {

    @Test
    public void test() {
        Cache<Object> cache = new LRUCache<>(5);

        cache.add(person1);
        cache.add(person2);
        cache.add(person3);
        assertModel(cache, person1, person2, person3);
        cache.add(person4);
        cache.add(person5);
        cache.get(1);
        cache.add(person6);
        assertModel(cache, person3, person4, person5, person1, person6);
        cache.add(person7);
        cache.add(person8);
        assertModel(cache, person5, person1, person6, person7, person8);
        cache.get(5);
        cache.add(person9);
        cache.add(person10);
        assertModel(cache, person7, person8, person5, person9, person10);
    }
}
