package Woche2;
public class aufgabeVier {
    static String giveChange(int amount) {
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
        String change = "";
        int i = coins.length - 1;
        while (amount > 0) {
            if (amount < coins[i]) {
                i--;
            }
            else {
                amount = amount - coins[i];
                change = change.concat(String.valueOf(coins[i]) + ", ");
            }
        }

        return change.trim();

    }

    public static void main(String[] args) {
        int a = 314;
        System.out.println(giveChange(a));

    }
}
