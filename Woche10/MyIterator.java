import java.util.Iterator;

public class MyIterator implements Iterator<Integer> {
    private int current = 2;

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        int tmp = current;
        current++;
        return tmp;
    }
}
