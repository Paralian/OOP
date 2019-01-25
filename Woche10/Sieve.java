import java.util.Iterator;

public class Sieve implements Iterator<Integer> {
    private Iterator<Integer> i = new MyIterator();

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        int tmp = i.next();
        i = new Eliminator(i, tmp);
        return tmp;
    }
}
