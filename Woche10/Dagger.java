public class Dagger extends Weapon implements OneHanded, Melee {
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
        return true;
    }
}
