import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambdas {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("bB", "aaaAA", "KKKKkkk", "cCC", "EEeee", "fFFF", "Zz", "dDDD", "hhH", "IIIiiiiii", "GGGGGGGGGgggg", "jjJJJJJ");
        list.sort(Comparator.comparingInt(x -> x.length()));
        list.forEach(x -> System.out.println(x));
        System.out.println();
        list.sort(Comparator.comparing((String x) -> x.toUpperCase().charAt(0)).reversed());
        list.forEach(x -> System.out.println(x));
        System.out.println();
        list.forEach(x -> System.out.println(new StringBuilder(x).reverse().toString()));
    }
}
