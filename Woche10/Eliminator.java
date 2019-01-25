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
            //TODO Ein bisschen schwer zu lesen vielleicht..aber NICE!
            // hier wäre auch mal einer der wirklich seltenen Fälle gewesen, in dem man eine do-while-Schleife Sinnvoll benutzen kann :) ...just saing
        }
        return current;
    }
}
