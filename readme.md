# Memory Cache

Implement a thread-unsafe in-memory cache (for caching any object) with configurable maximum size and delete strategy.  
 
Removal strategies used:
- LRU (Less Recent Usage)
- LFU (Less Frequent Usage)


## How to use

The application takes two arguments as input:
1. **size** - sets the cache size.
2. **algorithm removes** - takes two values *LRU* and *LFU* (default is LRU).

### Controller

The controller receives and sends HTTP requests.
It provides four methods as bellow.

- `V get(Integer id)` - Get an object from the cache by ID.
- `Collection<Object> getAll()` - Get all objects from the cache.
- `Collection<Object> add(Object o)` - Add an object to the cache.
- `Collection<Object> delete(Integer id)` - Remove an object from the cache by ID.

### Cache

It provides five methods as bellow.

- `V get(Integer id)` - Get an object from the cache by ID.
- `void add(V value)` - Add an object in the cache.
- `void remove(Integer id)` - Remove object in cache by ID
- `Collection<V> showAll()` - Return a collection without increasing element usage.
- `Map<Integer, V> model()` - Return the cache as a Map.

#### Note
The Strategy pattern is applied to use different caches.
#### LRUCache
The algorithm removes the element that has not been used the longest.
```java
Cache<String, String> cache = new LRUCache<>();
cache.put("A");
```

#### LFUCache
The algorithm removes the element that is least used.
```java
Cache<String, String> cache = new LFUCache<>();
cache.put("A");
```

#### Asymptotic Complexities

| Request       | LRU  | LFU  |
|:------------- |:-----|:-----|
| get           | O(1) | O(1) |
| add           | O(1) | O(n) |
| delete        | O(1) | O(1) |

## Start

## Test

```sh
mvn clean test
```
