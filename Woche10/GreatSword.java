public class GreatSword extends Weapon implements TwoHanded, Melee {
    @Override
    public boolean isMelee() {
        return true;
    }

    @Override
    public boolean isRanged() {
        return false;
    }

    @Override
    public boolean isOneHanded() {
        return false;
    }
}
