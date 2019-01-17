public abstract class Weapon {
    public abstract boolean isOneHanded();
    public boolean isTwoHanded() { return !isOneHanded(); }
    public abstract boolean isMelee();
    public abstract boolean isRanged();

}
