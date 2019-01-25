public abstract class Weapon {
    public abstract boolean isMelee();

    public abstract boolean isRanged();

    public abstract boolean isOneHanded();

    public boolean isTwoHanded() {
        return !isOneHanded();
    }
}
