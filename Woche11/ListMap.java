import java.util.LinkedList;
import java.util.List;

class ListMap<K, V> {
    private List<Entry<K, V>> map = new LinkedList<>();

    List<Entry<K, V>> getMap() {
        return map;
    }

    void put(K key, V value) {
        for (Entry<K, V> entry : map) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        map.add(new Entry<>(key, value));
    }

    V get(K key) {
        for (Entry<K, V> entry : map) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    void remove(K key) {
        List<Entry<K, V>> toBeRemoved = new LinkedList<>();
        map.forEach(x -> {
            if (x.getKey().equals(key)) {
                toBeRemoved.add(x);
            }
        });
        map.removeAll(toBeRemoved);
    }
}
