public class CrossBow extends Weapon implements OneHanded, Ranged {
    @Override
    public boolean isMelee() {
        return false;
    }

    @Override
    public boolean isRanged() {
        return true;
    }

    @Override
    public boolean isOneHanded() {
        return true;
    }
}
