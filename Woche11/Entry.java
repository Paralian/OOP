public class Entry<K, V> {
    private K key;
    private V value;

    Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    K getKey() {
        return key;
    }

    V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Key: " + key + ", Value: " + value;
    }
}
