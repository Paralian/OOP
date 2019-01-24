import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class ListMapTest {
    private ListMap<String, String> listMap = new ListMap<>();

    @Test
    public void put() {
        listMap.put("1", "Eins");
        listMap.put("1", "One");
        listMap.put("2", "Two");
        listMap.put("II", "Two");
        listMap.put("3", "Three");
        listMap.put("III", "Drei");
        for (Entry<String, String> entry : listMap.getMap()) {
            System.out.println(entry.toString());
        }
        System.out.println();
    }

    @Test
    public void get() {
        listMap.put("1", "Eins");
        listMap.put("1", "One");
        listMap.put("2", "Two");
        listMap.put("II", "Two");
        listMap.put("3", "Three");
        listMap.put("III", "Drei");
        System.out.println("Value of Key 1: " + listMap.get("1"));
        System.out.println("Value of Key 2: " + listMap.get("2"));
        System.out.println("Value of Key 3: " + listMap.get("3"));
        System.out.println("Value of Key 4: " + listMap.get("4"));
        System.out.println("Value of Key 5: " + listMap.get("5"));
    }

    @Test
    public void remove() {
        listMap.put("1", "Eins");
        listMap.put("1", "One");
        listMap.put("2", "Two");
        listMap.put("II", "Two");
        listMap.put("3", "Three");
        listMap.put("III", "Drei");
        listMap.remove("II");
        listMap.remove("III");
        listMap.remove("4");
        listMap.remove("5");
        for (Entry<String, String> entry : listMap.getMap()) {
            System.out.println(entry.toString());
        }
    }
}