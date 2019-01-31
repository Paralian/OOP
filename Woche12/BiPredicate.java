public interface BiPredicate<T> {
    boolean test(T e1, T e2);

    static <T> T getBetterElement(T e1, T e2, BiPredicate<T> pred) {
        return pred.test(e1, e2) ? e1 : e2;
    }
}
