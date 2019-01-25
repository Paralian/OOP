import static org.junit.Assert.*;

public class SieveTest {
    public static void main(String[] args){
        Sieve s = new Sieve();
        int i;
        while ((i = s.next()) < 100) {
            System.out.println(i);
        }
    }
}