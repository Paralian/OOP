import java.util.Iterator;

public class Eliminator implements Iterator<Integer> {
    private int current;
    private int fixedNumber;
    private Iterator<Integer> iterator;

    Eliminator(Iterator<Integer> i, int givenNumber){
        current = givenNumber;
        fixedNumber = givenNumber;
        iterator = i;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        while((current = iterator.next()) % fixedNumber == 0){
        }
        return current;
    }
}
