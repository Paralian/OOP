import de.umr.oop.IOStreams;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class IOStreamsTest {

    @Test
    public void words() throws FileNotFoundException {
        IOStreams.words("D:\\Kien's Personal Documents\\Uni Documents\\Marburg Uni\\WS1819 (Semester 02)\\Objektorientierte Programmierung\\Übungsabgabe\\OOP\\Woche12\\quotes.txt").forEach(System.out::println);
    }

    @Test
    public void encrypt() {
        List<String> testSubject = Arrays.asList("Größe", "über", "Kapazität");
        IOStreams.encrypt(testSubject.stream(), 13).forEach(System.out::println);
        System.out.println();
        IOStreams.encrypt(IOStreams.encrypt(testSubject.stream(), 13), 13).forEach(System.out::println);
    }

    @Test
    public void countWords() {
        String paleBlueDotText = "From this distant vantage point, the Earth might not seem of any particular interest. But for us, it's different. Consider again that dot. That's here, that's home, that's us. On it everyone you love, everyone you know, everyone you ever heard of, every human being who ever was, lived out their lives. The aggregate of our joy and suffering, thousands of confident religions, ideologies, and economic doctrines, every hunter and forager, every hero and coward, every creator and destroyer of civilization, every king and peasant, every young couple in love, every mother and father, hopeful child, inventor and explorer, every teacher of morals, every corrupt politician, every superstar, every supreme leader, every saint and sinner in the history of our species lived there. On the mote of dust suspended in a sunbeam.";
        String text = paleBlueDotText.replace(".","").replace(",", "");
        for (Map.Entry<String, Integer> entry : IOStreams.countWords(Arrays.stream(text.split(" "))).entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}