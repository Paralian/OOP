public class GreatSword extends Weapon implements TwoHanded {
    @Override
    public boolean isOneHanded() {
        return false;
    }

    @Override
    public boolean isMelee() {
        return true;
    }

    @Override
    public boolean isRanged() {
        return false;
    }
}
