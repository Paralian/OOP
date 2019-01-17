public class Bow extends Weapon implements TwoHanded, Ranged {
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
        return false;
    }
}
