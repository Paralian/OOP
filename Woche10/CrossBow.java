public class CrossBow extends Weapon implements OneHanded{
    @Override
    public boolean isOneHanded() {
        return true;
    }

    @Override
    public boolean isMelee() {
        return false;
    }

    @Override
    public boolean isRanged() {
        return true;
    }
}
